package com.ibeetl.cms.web.query;

import org.apache.commons.lang3.StringUtils;
import com.ibeetl.admin.core.annotation.Query;
import com.ibeetl.admin.core.util.Tool;
import com.ibeetl.admin.core.util.enums.CoreDictType;
import com.ibeetl.admin.core.web.query.PageParam;
import java.util.Date;
/**
 *CoreUser查询
 */
public class CoreUserQuery extends PageParam {
    @Query(name = "id", display = true)
    private Integer id;
    @Query(name = "code", display = true)
    private String code;
    @Query(name = "name", display = true)
    private String name;
    @Query(name = "createTime", display = true)
    private Date createTime;
    @Query(name = "orgId", display = true)
    private Integer orgId;
    @Query(name = "用户状态 1:启用 0:停用", display = true)
    private String state;
    @Query(name = "jobType1", display = true)
    private String jobType1;
    @Query(name = "用户删除标记 0:未删除 1:已删除", display = true)
    private Integer delFlag;
    @Query(name = "updateTime", display = true)
    private Date updateTime;
    @Query(name = "jobType0", display = true)
    private String jobType0;
    @Query(name = "attachmentId", display = true)
    private String attachmentId;
    public Integer getId(){
        return  id;
    }
    public void setId(Integer id ){
        this.id = id;
    }
    public String getCode(){
        return  code;
    }
    public void setCode(String code ){
        this.code = code;
    }
    public String getName(){
        return  name;
    }
    public void setName(String name ){
        this.name = name;
    }
    public Date getCreateTime(){
        return  createTime;
    }
    public void setCreateTime(Date createTime ){
        this.createTime = createTime;
    }
    public Integer getOrgId(){
        return  orgId;
    }
    public void setOrgId(Integer orgId ){
        this.orgId = orgId;
    }
    public String getState(){
        return  state;
    }
    public void setState(String state ){
        this.state = state;
    }
    public String getJobType1(){
        return  jobType1;
    }
    public void setJobType1(String jobType1 ){
        this.jobType1 = jobType1;
    }
    public Integer getDelFlag(){
        return  delFlag;
    }
    public void setDelFlag(Integer delFlag ){
        this.delFlag = delFlag;
    }
    public Date getUpdateTime(){
        return  updateTime;
    }
    public void setUpdateTime(Date updateTime ){
        this.updateTime = updateTime;
    }
    public String getJobType0(){
        return  jobType0;
    }
    public void setJobType0(String jobType0 ){
        this.jobType0 = jobType0;
    }
    public String getAttachmentId(){
        return  attachmentId;
    }
    public void setAttachmentId(String attachmentId ){
        this.attachmentId = attachmentId;
    }
 
}
