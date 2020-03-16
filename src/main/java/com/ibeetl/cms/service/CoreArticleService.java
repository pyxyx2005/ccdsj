package com.ibeetl.cms.service;


import com.ibeetl.cms.dao.CoreArticleDao;
import com.ibeetl.cms.entity.CoreArticle;



import com.ibeetl.admin.core.service.CoreBaseService;
import com.ibeetl.admin.core.util.PlatformException;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;






/**
 * CoreArticle Service
 */

@Service
@Transactional
public class CoreArticleService extends CoreBaseService<CoreArticle>{

    @Autowired private CoreArticleDao coreArticleDao;

    public PageQuery<CoreArticle>queryByCondition(PageQuery query){
        PageQuery ret =  coreArticleDao.queryByCondition(query);
        queryListAfter(ret.getList());
        return ret;
    }

    public void batchDelCoreArticle(List<Long> ids){
        try {
            coreArticleDao.batchDelCoreArticleByIds(ids);
        } catch (Exception e) {
            throw new PlatformException("批量删除CoreArticle失败", e);
        }
    }
}