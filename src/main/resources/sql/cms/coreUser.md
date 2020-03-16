queryByCondition
===


    select 
    @pageTag(){
    t.*
    @}
    from core_user t
    where 1=1  
    @//数据权限，该sql语句功能点,如果不考虑数据权限，可以删除此行  
    and #function("coreUser.query")#
    @if(!isEmpty(id)){
        and  t.ID =#id#
    @}
    @if(!isEmpty(code)){
        and  t.CODE =#code#
    @}
    @if(!isEmpty(name)){
        and  t.NAME =#name#
    @}
    @if(!isEmpty(createTime)){
        and  t.CREATE_TIME =#createTime#
    @}
    @if(!isEmpty(orgId)){
        and  t.ORG_ID =#orgId#
    @}
    @if(!isEmpty(state)){
        and  t.STATE =#state#
    @}
    @if(!isEmpty(jobType1)){
        and  t.JOB_TYPE1 =#jobType1#
    @}
    @if(!isEmpty(delFlag)){
        and  t.DEL_FLAG =#delFlag#
    @}
    @if(!isEmpty(updateTime)){
        and  t.update_Time =#updateTime#
    @}
    @if(!isEmpty(jobType0)){
        and  t.JOB_TYPE0 =#jobType0#
    @}
    @if(!isEmpty(attachmentId)){
        and  t.attachment_id =#attachmentId#
    @}
    
    
    

batchDelCoreUserByIds
===

* 批量逻辑删除

    update core_user set del_flag = 1 where ID  in( #join(ids)#)
    
