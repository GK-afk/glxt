package com.wxbj.bjgl.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wxbj.bjgl.entity.QuoteInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2020-12-19
 */
public interface IQuoteInfoService {
    int save(QuoteInfo quoteinfo);
    int update(QuoteInfo quoteinfo);
    Page<QuoteInfo> page(long curr, long size, String key, String value);

    QuoteInfo findById(Integer id);

    void deleteById(Integer id);
    List<Map> listTableColumn(String tableName);

    List<QuoteInfo> QuoteInfo ();


}
