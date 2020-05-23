$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/jobmessageall/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '', name: 'jobname', index: 'jobName', width: 80 }, 			
			{ label: '', name: 'cpnaddress', index: 'cpnAddress', width: 80 }, 			
			{ label: 'uuid', name: 'good1', index: 'good1', width: 80 }, 			
			{ label: '', name: 'good2', index: 'good2', width: 80 }, 			
			{ label: '', name: 'good3', index: 'good3', width: 80 }, 			
			{ label: '', name: 'good4', index: 'good4', width: 80 }, 			
			{ label: '', name: 'jobpay', index: 'jobPay', width: 80 }, 			
			{ label: '', name: 'conditionone', index: 'conditionOne', width: 80 }, 			
			{ label: '', name: 'conditiontwo', index: 'conditionTwo', width: 80 }, 			
			{ label: '', name: 'condition3', index: 'condition3', width: 80 }, 			
			{ label: '', name: 'workcontent', index: 'workContent', width: 80 }, 			
			{ label: '', name: 'workcontentshow', index: 'workContentShow', width: 80 }, 			
			{ label: '', name: 'dizhi', index: 'Dizhi', width: 80 }, 			
			{ label: '', name: 'workaddress', index: 'workAddress', width: 80 }, 			
			{ label: '', name: 'cpnimage', index: 'cpnImage', width: 80 }, 			
			{ label: '', name: 'cpnname1', index: 'cpnName1', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		jobMessageAll: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.jobMessageAll = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.jobMessageAll.id == null ? "sys/jobmessageall/save" : "sys/jobmessageall/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.jobMessageAll),
                    success: function(r){
                        if(r.code === 0){
                             layer.msg("操作成功", {icon: 1});
                             vm.reload();
                             $('#btnSaveOrUpdate').button('reset');
                             $('#btnSaveOrUpdate').dequeue();
                        }else{
                            layer.alert(r.msg);
                            $('#btnSaveOrUpdate').button('reset');
                            $('#btnSaveOrUpdate').dequeue();
                        }
                    }
                });
			});
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			var lock = false;
            layer.confirm('确定要删除选中的记录？', {
                btn: ['确定','取消'] //按钮
            }, function(){
               if(!lock) {
                    lock = true;
		            $.ajax({
                        type: "POST",
                        url: baseURL + "sys/jobmessageall/delete",
                        contentType: "application/json",
                        data: JSON.stringify(ids),
                        success: function(r){
                            if(r.code == 0){
                                layer.msg("操作成功", {icon: 1});
                                $("#jqGrid").trigger("reloadGrid");
                            }else{
                                layer.alert(r.msg);
                            }
                        }
				    });
			    }
             }, function(){
             });
		},
		getInfo: function(id){
			$.get(baseURL + "sys/jobmessageall/info/"+id, function(r){
                vm.jobMessageAll = r.jobMessageAll;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});