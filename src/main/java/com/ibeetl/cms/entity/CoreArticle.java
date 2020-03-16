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
public class CoreArticle extends BaseEntity{

    @NotNull(message = "ID不能为空", groups =ValidateConfig.UPDATE.class)
    @SeqID(name = ORACLE_CORE_SEQ_NAME)
    @AutoID	

    private Integer id ;
	

    private String title ;
	

    private Date pubdata ;
	

    private String contents ;
	

    private Integer uid ;
	
    public CoreArticle(){
    }

    public Integer getId(){
        return  id;
    }
    public void setId(Integer id){
        this.id = id;
    }

    public String getTitle(){
        return  title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public Date getPubdata(){
        return  pubdata;
    }
    public void setPubdata(Date pubdata){
        this.pubdata = pubdata;
    }

    public String getContents(){
        return  contents;
    }
    public void setContents(String contents){
        this.contents = contents;
    }

    public Integer getUid(){
        return  uid;
    }
    public void setUid(Integer uid){
        this.uid = uid;
    }


}
