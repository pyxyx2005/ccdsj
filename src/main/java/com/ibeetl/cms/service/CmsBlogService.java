package com.ibeetl.cms.service;


import com.ibeetl.cms.dao.CmsBlogDao;
import com.ibeetl.cms.entity.CmsBlog;



import com.ibeetl.admin.core.service.CoreBaseService;
import com.ibeetl.admin.core.util.PlatformException;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;






/**
 * CmsBlog Service
 */

@Service
@Transactional
public class CmsBlogService extends CoreBaseService<CmsBlog>{

    @Autowired private CmsBlogDao cmsBlogDao;

    public PageQuery<CmsBlog>queryByCondition(PageQuery query){
        PageQuery ret =  cmsBlogDao.queryByCondition(query);
        queryListAfter(ret.getList());
        return ret;
    }

    public void batchDelCmsBlog(List<Long> ids){
        try {
            cmsBlogDao.batchDelCmsBlogByIds(ids);
        } catch (Exception e) {
            throw new PlatformException("批量删除CmsBlog失败", e);
        }
    }
}