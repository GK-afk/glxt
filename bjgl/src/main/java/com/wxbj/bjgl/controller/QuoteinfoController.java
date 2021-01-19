package com.wxbj.bjgl.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wxbj.bjgl.entity.QuoteInfo;
import com.wxbj.bjgl.excel.ExcelUtil;
import com.wxbj.bjgl.mapper.QuoteInfoMapper;
import com.wxbj.bjgl.service.IQuoteInfoService;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;


@RestController
@RequestMapping("/test")
public class QuoteinfoController {

    @Resource
    private IQuoteInfoService IQuoteInfoService;
    @Resource
    private QuoteInfoMapper QuoteInfoMapper;

    @GetMapping("/findAll")
    public Page<QuoteInfo> findAll(@RequestParam(value = "page", defaultValue = "1") long page, @RequestParam(value = "size", defaultValue = "5") long size, @RequestParam(value = "key", required = false) String key, @RequestParam(value = "value", required = false) String value) {
        Page<QuoteInfo> page1 = IQuoteInfoService.page(page, size, key, value);
        return page1;
    }


    @GetMapping("findById/{id}")
    public QuoteInfo findById(@PathVariable("id") Integer id) {
        return IQuoteInfoService.findById(id);
    }


    @RequestMapping(value = "table", method = RequestMethod.GET)
    public List<String> showTable() {
        ArrayList<String> list = new ArrayList<>();
        List<Map> maps = IQuoteInfoService.listTableColumn("test");
        for (Map<String, String> map : maps) {
            String column_name = map.get("COLUMN_NAME");
            if (!column_name.equals("Id") && !column_name.equals("user_Id")) {
                list.add(column_name);
            }
        }
        return list;

    }

    //    ADD
    @PostMapping("/save")
    public String save(@RequestBody QuoteInfo quoteinfo) {
        int result = IQuoteInfoService.save(quoteinfo);
        if (result != 0) {
            return "success";
        } else {
            return "error";
        }
    }

    @PostMapping("/update")
    public String update(@RequestBody QuoteInfo quoteinfo) {
        int result = IQuoteInfoService.update(quoteinfo);
        if (result != 0) {
            return "success";
        } else {
            return "error";
        }
    }


    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        IQuoteInfoService.deleteById(id);
    }






   //excel

    @PostMapping("/export")
    public void exportData(@RequestBody List<Long> item) {

            HttpServletResponse resp = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
            List<Map<String, Object>> list = new ArrayList<>();
            List<QuoteInfo> quoteInfos = QuoteInfoMapper.selectBatchIds(item);
            for (QuoteInfo QuoteInfo : quoteInfos) {
                Map<String, Object> map = new LinkedHashMap<>();
                map.put("ID", QuoteInfo.getId().toString());
                map.put("test", QuoteInfo.getTest());
                map.put("test1", QuoteInfo.getTest1());
                map.put("test2", QuoteInfo.getTest2());
                map.put("test3", QuoteInfo.getTest3());

                map.put("Input_Date", QuoteInfo.getInputDate());
                map.put("Status", QuoteInfo.getStatus());
                list.add(map);
                System.out.println(item);
            }
            ExcelUtil.downloadExcel(list, resp);
        }

    }

