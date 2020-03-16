layui.define([ 'form', 'laydate', 'table' ], function(exports) {
    var form = layui.form;
    var laydate = layui.laydate;
    var table = layui.table;
    var coreArticleTable = null;
    var view ={
        init:function(){
            this.initTable();
            this.initSearchForm();
            this.initToolBar();
            window.dataReload = function(){
                Lib.doSearchForm($("#searchForm"),coreArticleTable)
            }
        },
        initTable:function(){
            coreArticleTable = table.render({
                elem : '#coreArticleTable',
                height : Lib.getTableHeight(1),
                cellMinWidth: 100,
                method : 'post',
                url : Common.ctxPath + '/cms/coreArticle/list.json' // 数据接口
                ,page : Lib.tablePage // 开启分页
                ,limit : 10,
                cols : [ [ // 表头
                    {
                        type : 'checkbox',
                        fixed:'left',
                    },
                {

                    field : 'id', 
                        title : 'id',
                    fixed:'left',
                        width : 60,
                },
                {

                    field : 'title', 
                        title : 'title',
                },
                {

                    field : 'pubdata', 
                        title : 'pubdata',
                },
                {

                    field : 'contents', 
                        title : 'contents',
                },
                {

                    field : 'uid', 
                        title : 'uid',
                }

        ] ]

        });

            table.on('checkbox(coreArticleTable)', function(obj){
                var coreArticle = obj.data;
                if(obj.checked){
                    //按钮逻辑Lib.buttonEnable()
                }else{

                }
            })
        },

        initSearchForm:function(){
            Lib.initSearchForm( $("#searchForm"),coreArticleTable,form);
        },
        initToolBar:function(){
            toolbar = {
                add : function() { // 获取选中数据
                    var url = "/cms/coreArticle/add.do";
                    Common.openDlg(url,"CoreArticle管理>新增");
                },
                edit : function() { // 获取选中数目
                    var data = Common.getOneFromTable(table,"coreArticleTable");
                    if(data==null){
                        return ;
                    }
                    var url = "/cms/coreArticle/edit.do?id="+data.id;
                    Common.openDlg(url,"CoreArticle管理>"+data.id+">编辑");
                },
                del : function() {
                    layui.use(['del'], function(){
                        var delView = layui.del
                        delView.delBatch();
                    });
                }
            ,
                exportDocument : function() {
                    layui.use([ 'coreArticleApi' ], function() {
                        var coreArticleApi = layui.coreArticleApi
                        Common.openConfirm("确认要导出这些CoreArticle数据?", function() {
                            coreArticleApi.exportExcel($("#searchForm"), function(fileId) {
                                Lib.download(fileId);
                            })
                        })
                    });
                },
                importDocument:function(){
                    var uploadUrl = Common.ctxPath+"/cms/coreArticle/excel/import.do";
                    //模板,
                    var templatePath= "/cms/coreArticle/coreArticle_upload_template.xls";
                    //公共的简单上传文件处理
                    var url = "/core/file/simpleUpload.do?uploadUrl="+uploadUrl+"&templatePath="+templatePath;
                    Common.openDlg(url, "CoreArticle管理>上传");
                }
        };
            $('.ext-toolbar').on('click', function() {
                var type = $(this).data('type');
                toolbar[type] ? toolbar[type].call(this) : '';
            });
        }
    }
    exports('index',view);

});