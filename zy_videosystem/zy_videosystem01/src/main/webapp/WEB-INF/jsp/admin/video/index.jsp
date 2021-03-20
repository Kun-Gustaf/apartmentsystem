<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<base href="${BaseContext }">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>视频列表 - 视频管理</title>
<link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/css/jquery-confirm.min.css" rel="stylesheet">
</head>
<body>
	<!-- 引入公用的导航信息 -->
	<jsp:include page="../header.jsp">
		<jsp:param value="video" name="fromJsp"/>
	</jsp:include>

	<div class="container">
		<div class="jumbotron">
  			<h2>视频列表 - 视频管理</h2>
		</div>
		<div class="row">
		<a href="admin/video/saveOrUpdate.action" class="btn btn-primary">添加视频</a>
		<button class="btn btn-primary" type="button" onclick="batchDelete();">
		  批量删除 <span class="badge" id="countSpan">0</span>
		</button>
		<div style="float: right;">
			<form class="form-inline" action="admin/video/index.action" method="post">
			  <div class="form-group">
			    <input type="text" class="form-control" name="videoTitle"  value="${videoTitle}" placeholder="视频标题">
			  </div>
			   <div class="form-group">
			    <select name="speakerId"  class="form-control">
			    	<option value="0">请选择主讲人</option>
			    	<c:forEach items="${speakers}" var="sp">
			    		<option <c:if test="${speakerId==sp.id}">selected</c:if> value="${sp.id}">${sp.speakerName}</option>
			    	</c:forEach>
			    </select>
			  </div>
			  
			  <div class="form-group">
			    <select name="courseId" class="form-control">
			    	<option value="0">请选择课程</option>
			    	<c:forEach items="${courses}" var="c">
			    		<option  <c:if test="${courseId==c.id }">selected</c:if>  value="${c.id}">${c.courseName}</option>
			    	</c:forEach>
			    </select>
			  </div>
			  <button type="submit" class="btn btn-primary">查询</button>
			</form>
		</div>
		</div>
		<form action="admin/video/batchDelete.action" name="deleteForm" method="get">
		<table class="table table-hover">
 			<thead>
 				<tr>
 					<th><input type="checkbox" id="checkAll" onclick="selectAll()"></th>
 					<th>序号</th>
 					<th>名称</th>
 					<th>介绍</th>
 					<th>讲师</th>
 					<th>课程</th>
 					<th>时长(秒 )</th>
 					<th>播放次数</th>
 					<th>编辑</th>
 					<th>删除</th>
 				</tr>
 			</thead>
 			<tbody>
 				<c:if test="${not empty pageInfo.results }">
 					<c:forEach items="${pageInfo.results}" var="sp" varStatus="i">
		 				<tr>
		 					<td><input type="checkbox" name="checkId" class="checkId" value="${sp.id }" onclick="selectOne(this)"> </td>
		 					<td>${i.index+1}</td>
		 					<td>${sp.videoTitle}</td>
		 					<td>${sp.videoDesc}</td>
		 					<td>${sp.speaker.speakerName}</td>
		 					<td>${sp.course.courseName}</td>
		 					<td>${sp.videoLength}</td>
		 					<td>${sp.videoPlayTimes}</td>
		 					<td><a href="admin/video/saveOrUpdate.action?id=${sp.id}"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>
		 					<td><a href="admin/video/delete.action" onclick="return deleteInfo(${sp.id});"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>
		 				</tr>
	 				</c:forEach>
 				</c:if>
 				<c:if test="${empty pageInfo.results }">
 					<tr><td>当前查询结果为空!</td></tr>
 				</c:if>
 			</tbody>
		</table>
	</form>
        <jsp:include page="../page.jsp"/>
	</div>

    <form id="pageForm" action="${pageContext.request.contextPath}/admin/video/index.action" method="post">
        <input type="hidden" name="videoTitle" value="${videoTitle}">
        <input type="hidden" name="speakerId" value="${speakerId}">
        <input type="hidden" name="courseId" value="${courseId}">
        <input type="hidden" name="pageNum" value="${pageInfo.pageNum}" id="queryPage">
    </form>
<script src="static/js/jquery-1.12.4.min.js"></script>
<script src="static/js/jquery-confirm.min.js"></script>
<script>
    //翻页提交
    function queryPage(page){
        $('#queryPage').val(page);
        $('#pageForm').submit();
    }
    function selectAll(obj) {
        //借助于input标签中的checked属性 布尔值
        $(".checkId").prop("checked",$("#checkAll").prop("checked"));
        $('#countSpan').html($(".checkId:checked").length);
    }

    //选中单个 并且统计选中的数量
    function selectOne(obj) {
        //表单过滤选择器 :checked 选中过滤选择器
        var count =  $(".checkId:checked").length;
        $("#checkAll").prop("checked", $(".checkId").length === count)
        $('#countSpan').html(count);
    }
	//批量删除操作
	function batchDelete(){
		var count=0;
		var checkboxes = document.getElementsByName('checkId');
		for(var i=0;i<checkboxes.length;i++){
			var c = checkboxes[i];//当前遍历到的checkbox
			if(c.checked){
				count++;
			}
		}
		
		//判断count是否大于0，如果大于0，可以提交，等于0，提示先选择
		if(count>0){
			//getElementById获取表单
			//获取表单的方法
			var form = document.forms['deleteForm'];
			//提交表单
			form.submit();
		}else{
			alert('请先选择要删除的信息!');
		}
	}
	
	//删除数据操作
	function deleteInfo(id){
		$.confirm({
			title:'删除确认提示',
			content:'确定要删除id为'+id+'的数据吗？',
			type:'orange',
			buttons:{
				confirm:{
					text:'删除',
					btnClass:'btn-primary',
					action:function(){
						//根据id发送删除请求ajax
						$.get('admin/video/delete.action',{id:id},function(data){
                            $.alert(data)
                            refresh()
						},'text');
					}
				},
				cancel:function(){
					//取消删除，自动关闭弹窗，不做其他操作
				}
			}
		});
		return false;
	}
    function refresh() {
        location.href = "${pageContext.request.contextPath}/admin/video/index.action";
    }
</script>
</body>
</html>