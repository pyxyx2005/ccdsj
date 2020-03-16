package com.ibeetl.cms.service;


import com.ibeetl.cms.dao.CoreUserDao;
import com.ibeetl.cms.entity.CoreUser;



import com.ibeetl.admin.core.service.CoreBaseService;
import com.ibeetl.admin.core.util.PlatformException;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;






/**
 * CoreUser Service
 */

@Service
@Transactional
public class CoreUserService extends CoreBaseService<CoreUser>{

    @Autowired private CoreUserDao coreUserDao;

    public PageQuery<CoreUser>queryByCondition(PageQuery query){
        PageQuery ret =  coreUserDao.queryByCondition(query);
        queryListAfter(ret.getList());
        return ret;
    }

    public void batchDelCoreUser(List<Long> ids){
        try {
            coreUserDao.batchDelCoreUserByIds(ids);
        } catch (Exception e) {
            throw new PlatformException("批量删除CoreUser失败", e);
        }
    }
}