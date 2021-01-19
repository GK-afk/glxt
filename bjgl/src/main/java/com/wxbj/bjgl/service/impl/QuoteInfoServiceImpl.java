package com.wxbj.bjgl.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wxbj.bjgl.entity.QuoteInfo;
import com.wxbj.bjgl.mapper.QuoteInfoMapper;
import com.wxbj.bjgl.service.IQuoteInfoService;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-12-19
 */
@Service
public class QuoteInfoServiceImpl implements IQuoteInfoService {
    @Resource
    private QuoteInfoMapper QuoteInfoMapper;
    @Override
    public int save(QuoteInfo quoteinfo) {
        return  QuoteInfoMapper.insert(quoteinfo);
    }

    @Override
    public int update(QuoteInfo quoteinfo) {
       //return QuoteInfoMapper.update(quoteinfo, Wrappers.update());
        return  QuoteInfoMapper.updateById(quoteinfo);
    }

    @Override
    public Page<QuoteInfo> page(long curr, long size, String key, String value) {
        String colum=null;
        switch (key) {
            case "test": colum = "test"; break;
            case "test1": colum = "test1"; break;
            case "test2": colum = "test2"; break;
            case "test3": colum = "test3"; break;

            case "Input_Date": colum = "Input_Date"; break;
            case "Status": colum = "Status"; break;
        }

        Page<QuoteInfo> objectPage = new Page<>(curr,size);
        QueryWrapper<QuoteInfo> query = Wrappers.query();
        if (!StringUtils.isEmpty(key)){
            query.like(colum,value);
        }

        Page<QuoteInfo> quoteInfoPage = QuoteInfoMapper.selectPage(objectPage, query);
        return quoteInfoPage;
    }

    @Override
    public QuoteInfo findById(Integer id) {
        return QuoteInfoMapper.selectById(id);
    }

    @Override
    public void deleteById(Integer id) {
        QuoteInfoMapper.deleteById(id);
    }

    @Override
    public List<Map> listTableColumn(String tableName) {
        return QuoteInfoMapper.listTableColumn(tableName);
    }

    @Override
    public List<QuoteInfo> QuoteInfo() {
        return QuoteInfoMapper.QuoteInfo();
    }


}
