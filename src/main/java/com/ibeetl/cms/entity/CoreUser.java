package com.ibeetl.cms.entity;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.beetl.sql.core.annotatoin.AutoID;
import org.beetl.sql.core.annotatoin.SeqID;

import com.ibeetl.admin.core.util.ValidateConfig;

import org.beetl.sql.core.TailBean;
import java.math.*;

import com.ibeetl.admin.core.annotation.Dict;
import com.ibeetl.admin.core.entity.BaseEntity;

import org.beetl.sql.core.annotatoin.InsertIgnore;
import org.beetl.sql.core.annotatoin.Version;
import org.beetl.sql.core.annotatoin.LogicDelete;


/* 
* 
* gen by Spring Boot2 Admin 2020-03-15
*/
public class CoreUser extends BaseEntity{

    @NotNull(message = "ID不能为空", groups =ValidateConfig.UPDATE.class)
    @SeqID(name = ORACLE_CORE_SEQ_NAME)
    @AutoID	

    private Integer id ;
	

    private String code ;
	

    private String name ;
	

    private String password ;
	

    private Date createTime ;
	

    private Integer orgId ;
	
    //用户状态 1:启用 0:停用

    private String state ;
	

    private String jobType1 ;
	
    //用户删除标记 0:未删除 1:已删除
	/*逻辑删除标志*/
	@InsertIgnore
	@LogicDelete(value = 1)

    private Integer delFlag ;
	

    private Date updateTime ;
	

    private String jobType0 ;
	

    private String attachmentId ;
	
    public CoreUser(){
    }

    public Integer getId(){
        return  id;
    }
    public void setId(Integer id){
        this.id = id;
    }

    public String getCode(){
        return  code;
    }
    public void setCode(String code){
        this.code = code;
    }

    public String getName(){
        return  name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getPassword(){
        return  password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public Date getCreateTime(){
        return  createTime;
    }
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    public Integer getOrgId(){
        return  orgId;
    }
    public void setOrgId(Integer orgId){
        this.orgId = orgId;
    }

    /**用户状态 1:启用 0:停用
    *@return 
    */
    public String getState(){
        return  state;
    }
    /**用户状态 1:启用 0:停用
    *@param  state
    */
    public void setState(String state){
        this.state = state;
    }

    public String getJobType1(){
        return  jobType1;
    }
    public void setJobType1(String jobType1){
        this.jobType1 = jobType1;
    }

    /**用户删除标记 0:未删除 1:已删除
    *@return 
    */
    public Integer getDelFlag(){
        return  delFlag;
    }
    /**用户删除标记 0:未删除 1:已删除
    *@param  delFlag
    */
    public void setDelFlag(Integer delFlag){
        this.delFlag = delFlag;
    }

    public Date getUpdateTime(){
        return  updateTime;
    }
    public void setUpdateTime(Date updateTime){
        this.updateTime = updateTime;
    }

    public String getJobType0(){
        return  jobType0;
    }
    public void setJobType0(String jobType0){
        this.jobType0 = jobType0;
    }

    public String getAttachmentId(){
        return  attachmentId;
    }
    public void setAttachmentId(String attachmentId){
        this.attachmentId = attachmentId;
    }


}
