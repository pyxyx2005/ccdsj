/*访问后台的代码*/
layui.define([], function(exports) {
    var api={
            updateCmsBlog:function(form,callback){
                Lib.submitForm("/cms/cmsBlog/edit.json",form,{},callback)
            },
            addCmsBlog:function(form,callback){
                Lib.submitForm("/cms/cmsBlog/add.json",form,{},callback)
            },
            del:function(ids,callback){
                Common.post("/cms/cmsBlog/delete.json",{"ids":ids},function(){
                    callback();
                })
            }
            ,
            exportExcel:function(form,callback){
                var formPara = form.serializeJson();
                Common.post("/cms/cmsBlog/excel/export.json", formPara, function(fileId) {
                    callback(fileId);
                })
            }
		
    };
    exports('cmsBlogApi',api);
});