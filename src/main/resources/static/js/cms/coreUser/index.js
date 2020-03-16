layui.define([ 'form', 'laydate', 'table' ], function(exports) {
    var form = layui.form;
    var laydate = layui.laydate;
    var table = layui.table;
    var coreUserTable = null;
    var view ={
        init:function(){
            this.initTable();
            this.initSearchForm();
            this.initToolBar();
            window.dataReload = function(){
                Lib.doSearchForm($("#searchForm"),coreUserTable)
            }
        },
        initTable:function(){
            coreUserTable = table.render({
                elem : '#coreUserTable',
                height : Lib.getTableHeight(1),
                cellMinWidth: 100,
                method : 'post',
                url : Common.ctxPath + '/cms/coreUser/list.json' // 数据接口
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

                    field : 'code', 
                        title : 'code',
                },
                {

                    field : 'name', 
                        title : 'name',
                },
                {

                    field : 'password', 
                        title : 'password',
                },
                {

                    field : 'createTime', 
                        title : 'createTime',
                },
                {

                    field : 'orgId', 
                        title : 'orgId',
                },
                {

                    field : 'state', 
                        title : '用户状态 1:启用 0:停用',
                },
                {

                    field : 'jobType1', 
                        title : 'jobType1',
                },
                {

                    field : 'updateTime', 
                        title : 'updateTime',
                },
                {

                    field : 'jobType0', 
                        title : 'jobType0',
                },

        ] ]

        });

            table.on('checkbox(coreUserTable)', function(obj){
                var coreUser = obj.data;
                if(obj.checked){
                    //按钮逻辑Lib.buttonEnable()
                }else{

                }
            })
        },

        initSearchForm:function(){
            Lib.initSearchForm( $("#searchForm"),coreUserTable,form);
        },
        initToolBar:function(){
            toolbar = {
                add : function() { // 获取选中数据
                    var url = "/cms/coreUser/add.do";
                    Common.openDlg(url,"CoreUser管理>新增");
                },
                edit : function() { // 获取选中数目
                    var data = Common.getOneFromTable(table,"coreUserTable");
                    if(data==null){
                        return ;
                    }
                    var url = "/cms/coreUser/edit.do?id="+data.id;
                    Common.openDlg(url,"CoreUser管理>"+data.id+">编辑");
                },
                del : function() {
                    layui.use(['del'], function(){
                        var delView = layui.del
                        delView.delBatch();
                    });
                }
            ,
                exportDocument : function() {
                    layui.use([ 'coreUserApi' ], function() {
                        var coreUserApi = layui.coreUserApi
                        Common.openConfirm("确认要导出这些CoreUser数据?", function() {
                            coreUserApi.exportExcel($("#searchForm"), function(fileId) {
                                Lib.download(fileId);
                            })
                        })
                    });
                },
                importDocument:function(){
                    var uploadUrl = Common.ctxPath+"/cms/coreUser/excel/import.do";
                    //模板,
                    var templatePath= "/cms/coreUser/coreUser_upload_template.xls";
                    //公共的简单上传文件处理
                    var url = "/core/file/simpleUpload.do?uploadUrl="+uploadUrl+"&templatePath="+templatePath;
                    Common.openDlg(url, "CoreUser管理>上传");
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