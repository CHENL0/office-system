<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ page isELIgnored="false" %>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<!--[if lt IE 9]>
	<script type="text/javascript" src="lib/html5shiv.js"></script>
	<script type="text/javascript" src="lib/respond.min.js"></script>
	<![endif]-->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/static/h-ui/css/H-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/static/h-ui.admin/css/H-ui.admin.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/lib/Hui-iconfont/1.0.8/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/static/h-ui.admin/skin/default/skin.css" id="skin" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/static/h-ui.admin/css/style.css" />
	<!--[if IE 6]>
	<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
	<script>DD_belatedPNG.fix('*');</script>
	<![endif]-->
	<title>用户管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 用户中心 <span class="c-gray en">&gt;</span> 用户管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c">
		<form action="<%=basePath%>RlLeave/auditLeavePage.do?auditUserId=${param.currentUserId}" method="post">
			日期范围：<input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="datemin" name="datemin" class="input-text Wdate" style="width:120px;">
			-
			<input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })" id="datemax" name="datemax" class="input-text Wdate" style="width:120px;">
			<button type="submit" class="btn btn-success radius" ><i class="Hui-iconfont">&#xe665;</i> 搜标题</button>
		</form>
	</div>

	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l">
		<%--<a href="javascript:;" onclick="member_add('申请请假','<%=basePath%>RlLeave/submitLeave.do?delFlag=1&current_user_Id=${param.currentUserId }','','510')" class="btn btn-primary radius">--%>
			<%--<i class="Hui-iconfont">&#xe600;</i>申请请假--%>
		<%--</a>--%>
	</span> <span class="r">共有数据：<strong>88</strong> 条</span>
	</div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-hover table-bg table-sort">
			<thead>
			<tr class="text-c">
				<!-- 				<th width="25"><input type="checkbox" name="" value=""></th>
                 -->		    <th width="80">状态</th>
				<th width="100">创建时间</th>
				<th width="100">开始时间</th>
				<th width="100">结束时间</th>
				<th width="100">受理人</th>
				<th width="130">类型</th>
				<th width="100">操作</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${rlLeaveList }" var="rlLeaveList">
				<%--<c:if test="${rlLeaveList.delFlag != '2'}">--%>
					<tr class="text-c" >
					<!-- 				<td><input type="checkbox" value="1" name=""></td>

                     -->

						<c:if test="${rlLeaveList.leaveStatus == 1}">
							<td><span style="color: #3b97d7">待审核</span></td>
						</c:if>
						<c:if test="${rlLeaveList.leaveStatus == 2}">
							<td><span style="color: #00B83F">已批准</span></td>
						</c:if>
						<c:if test="${rlLeaveList.leaveStatus == 3}">
							<td><span style="color: #A60000">审核被拒</span></td>
						</c:if>
						<td><fmt:formatDate value="${rlLeaveList.createDate}" pattern="yyyy-MM-dd HH:mm"/></td>
						<td><fmt:formatDate value="${rlLeaveList.startDate}" pattern="yyyy-MM-dd HH:mm"/></td>
						<td><fmt:formatDate value="${rlLeaveList.endDate}" pattern="yyyy-MM-dd HH:mm"/></td>
						<td>${rlLeaveList.auditUser.name}</td>
						<td>${rlLeaveList.leaveType}</td>
						<td class="td-manage">


							<a title="查看详情" href="javascript:;" onclick="member_show('请假条详细','<%=basePath%>RlLeave/showLeave.do?leaveId=${rlLeaveList.id}','10001','360','400')" class="ml-5" style="text-decoration:none">
								<i class="Hui-iconfont">&#xe631;</i>
							</a>
							<%--<c:if test="${sessionScope.currentRoleName == '经理' || sessionScope.currentRoleName == '系统管理员'}">--%>
							<%--<c:if test="${param.currentUserRole == '经理' || param.currentUserRole == '系统管理员'}">--%>
								<a title="审核" href="javascript:;" onclick="member_edit('审核请假','<%=basePath%>RlLeave/updateLeaveStatus.do?leaveId=${rlLeaveList.id}&leaveStatus=0','10001','360','400')" class="ml-5" style="text-decoration:none">
									<i class="Hui-iconfont">&#xe631;</i>
								</a>
							<%--</c:if>--%>
							<a title="删除" href="javascript:;" onClick="member_del(this,'${rlLeaveList.id}')" class="ml-5" style="text-decoration:none">
								<i class="Hui-iconfont">&#xe6e2;</i>
							</a>
						</td>
					</tr>
				<%--</c:if>--%>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="<%=basePath%>static/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>static/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=basePath%>static/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>static/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="<%=basePath%>static/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>static/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=basePath%>static/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="<%=basePath%>static/lib/date.format.js"></script>
<script type="text/javascript">
    $(function(){
        $('.table-sort').dataTable({
            "aaSorting": [[ 1, "desc" ]],//默认第几个排序
            "bStateSave": true,//状态保存
            "aoColumnDefs": [
                //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
                {"orderable":false,"aTargets":[0,8,9]}// 制定列不参与排序
            ]
        });

    });
    /*用户-添加*/
    function member_add(title,url,w,h){
        layer_show(title,url,w,h);
    }
    /*用户-查看*/
    function member_show(title,url,id,w,h){
        layer_show(title,url,w,h);
    }
    /*用户-停用*/
    function member_stop(obj,id){
        layer.confirm('确认要停用吗？',function(index){
            $.ajax({
                type: 'POST',
                url: '',
                dataType: 'json',
                success: function(data){
                    $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe6e1;</i></a>');
                    $(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已停用</span>');
                    $(obj).remove();
                    layer.msg('已停用!',{icon: 5,time:1000});
                },
                error:function(data) {
                    console.log(data.msg);
                },
            });
        });
    }

    /*用户-启用*/
    function member_start(obj,id){
        layer.confirm('确认要启用吗？',function(index){
            $.ajax({
                type: 'POST',
                url: '',
                dataType: 'json',
                success: function(data){
                    $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>');
                    $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
                    $(obj).remove();
                    layer.msg('已启用!',{icon: 6,time:1000});
                },
                error:function(data) {
                    console.log(data.msg);
                },
            });
        });
    }
    /*用户-编辑*/
    function member_edit(title,url,id,w,h){
        layer_show(title,url,w,h);
    }
    /*密码-修改*/
    function change_password(title,url,id,w,h){
        layer_show(title,url,w,h);
    }
    /*用户-删除*/
    function member_del(obj,id){
        var id = id;
        layer.confirm('确认要删除吗？',function(index){
            $.ajax({
                data:{id:id},
                type: 'POST',
                url: '<%=basePath%>/RlLeave/delLeaveForAudit.do',
                dataType: 'json',
                success: function(data){
                    $(obj).parents("tr").remove();
                    layer.msg('已删除!',{icon:1,time:1000});
                },
                error:function(data) {
                    console.log(data.msg);
                },
            });
        });
    }
</script>
</body>
</html>