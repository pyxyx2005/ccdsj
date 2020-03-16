/*访问后台的代码*/
layui.define([], function(exports) {
    var api={
            updateCoreArticle:function(form,callback){
                Lib.submitForm("/cms/coreArticle/edit.json",form,{},callback)
            },
            addCoreArticle:function(form,callback){
                Lib.submitForm("/cms/coreArticle/add.json",form,{},callback)
            },
            del:function(ids,callback){
                Common.post("/cms/coreArticle/delete.json",{"ids":ids},function(){
                    callback();
                })
            }
            ,
            exportExcel:function(form,callback){
                var formPara = form.serializeJson();
                Common.post("/cms/coreArticle/excel/export.json", formPara, function(fileId) {
                    callback(fileId);
                })
            }
		
    };
    exports('coreArticleApi',api);
});