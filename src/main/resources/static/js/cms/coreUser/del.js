layui.define(['table', 'coreUserApi'], function(exports) {
    var coreUserApi = layui.coreUserApi;
    var table=layui.table;
    var view = {
        init:function(){
        },
        delBatch:function(){
            var data = Common.getMoreDataFromTable(table,"coreUserTable");
            if(data==null){
                return ;
            }
            Common.openConfirm("确认要删除这些CoreUser?",function(){
            var ids =Common.concatBatchId(data,"id");
            coreUserApi.del(ids,function(){
                Common.info("删除成功");
                    dataReload();
                })
            })
        }
    }
    exports('del',view);
	
});