queryByCondition
===


    select 
    @pageTag(){
    t.*
    @}
    from core_article t
    where 1=1  
    @//数据权限，该sql语句功能点,如果不考虑数据权限，可以删除此行  
    and #function("coreArticle.query")#
    
    
    

batchDelCoreArticleByIds
===

* 批量逻辑删除

    update core_article set del_flag = 1 where id  in( #join(ids)#)
    
