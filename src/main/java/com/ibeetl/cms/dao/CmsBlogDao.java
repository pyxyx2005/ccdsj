package com.ibeetl.cms.dao;

import java.util.List;

import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;
import org.beetl.sql.core.engine.PageQuery;

import  com.ibeetl.cms.entity.*;

/**
 * CmsBlog Dao
 */
@SqlResource("cms.cmsBlog")
public interface CmsBlogDao extends BaseMapper<CmsBlog>{
    public PageQuery<CmsBlog> queryByCondition(PageQuery query);
    public void batchDelCmsBlogByIds( List<Long> ids);
}