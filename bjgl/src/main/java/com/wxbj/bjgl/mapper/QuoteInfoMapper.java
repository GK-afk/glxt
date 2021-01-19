package com.wxbj.bjgl.mapper;

import com.wxbj.bjgl.entity.QuoteInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-12-19
 */
@Mapper
public interface QuoteInfoMapper extends BaseMapper<QuoteInfo> {
    @Select("select * from information_schema.COLUMNS where TABLE_SCHEMA = (select database()) and TABLE_NAME=#{tableName}")
    List<Map> listTableColumn(String tableName);
    List<QuoteInfo> QuoteInfo ();

    @Select("select * from test where id= #{id}")
    QuoteInfo seteclById(Integer id);
;
}
