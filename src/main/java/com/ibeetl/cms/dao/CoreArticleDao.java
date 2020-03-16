package com.ibeetl.cms.dao;

import java.util.List;

import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;
import org.beetl.sql.core.engine.PageQuery;

import  com.ibeetl.cms.entity.*;

/**
 * CoreArticle Dao
 */
@SqlResource("cms.coreArticle")
public interface CoreArticleDao extends BaseMapper<CoreArticle>{
    public PageQuery<CoreArticle> queryByCondition(PageQuery query);
    public void batchDelCoreArticleByIds( List<Long> ids);
}