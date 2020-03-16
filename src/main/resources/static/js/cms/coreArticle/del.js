layui.define(['table', 'coreArticleApi'], function(exports) {
    var coreArticleApi = layui.coreArticleApi;
    var table=layui.table;
    var view = {
        init:function(){
        },
        delBatch:function(){
            var data = Common.getMoreDataFromTable(table,"coreArticleTable");
            if(data==null){
                return ;
            }
            Common.openConfirm("确认要删除这些CoreArticle?",function(){
            var ids =Common.concatBatchId(data,"id");
            coreArticleApi.del(ids,function(){
                Common.info("删除成功");
                    dataReload();
                })
            })
        }
    }
    exports('del',view);
	
});