<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <base href="${BaseContext}">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta name="keywords" content="Web前端视频教程,大数据视频教程,HTML5视频教程,UI视频教程,PHP视频教程,java视频教程,python基础教程">
    <meta name="description" content="智游教育在线课程视频,为您提供java,python,HTML5,UI,PHP,大数据等学科经典视频教程在线浏览学习,精细化知识点解析,深入浅出,想学不会都难,智游教育,学习成就梦想！">
    <link rel="stylesheet" href="static/css/base.css">
    <link rel="stylesheet" href="static/css/profile.css">
    <title>在线公开课-智游教育|java|大数据|HTML5|python|UI|PHP视频教程</title>

</head>

<body class="w100">
   <jsp:include page="uheader.jsp"></jsp:include>
    <main>
        <div class="container">
            <h2>我的资料</h2>
            <div id="profile_tab">
                <ul class="profile_tab_header f_left clearfix">
                    <li><a href="${pageContext.request.contextPath}/front/user/profile.action">更改资料</a></li>
                    <li class="profile_tab_line">|</li>
                    <li><a href="${pageContext.request.contextPath}/front/user/avatar.action">更改头像</a></li>
                    <li class="profile_tab_line">|</li>
                    <li><a href="${pageContext.request.contextPath}/front/user/password.action">密码安全</a></li>
                </ul>
                <div class="proflle_tab_body">
                    <div class="proflle_tab_workplace clearfix">
                        <div class="profile_avatar_area">
                           <c:if test="${empty user.headUrl}">
		                         <img id="avatar"  src="static/img/avatar_lg.png" alt="">
		                      </c:if>
		                      
		                      <c:if test="${not empty user.headUrl}">
		                         <img id="avatar" width="200px" height="200px" src="static/img/${user.headUrl}" alt="">
		                      </c:if>
                        </div>
                        <div class="profile_ifo_area">
                         <c:if test="${not empty message}">
				            <div>
				                <strong>${message}</strong>
				            </div>
				            </c:if>
                            <form action="${pageContext.request.contextPath}/front/user/resetPwd.action?id=${user.id}" method="post" id="loginForm">
                                <div class="form_group">
                                    <span class="dd">旧&#x3000;密&#x3000;码：</span>
                                    <input type="password" id="oldPassword" name="oldPassword" onblur="checkOldPwd()">
                                    <span id="msg"></span>
                                </div>
                                <div class="form_group">
                                    <span class="dd">新&#x3000;密&#x3000;码：</span>
                                    <input type="password" id="newPassword"  name="newPassword">
                                </div>
                                <div class="form_group">
                                    <span class="dd">确认新密码：</span>
                                    <input type="password" id="newPassword02" name="newPasswordAgain">
                                    <span id="msg2"></span>
                                </div>
                                <div class="form_submit dd">
                                    <button type="submit"   onclick="return checkDouble()">保&#x3000;存</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <jsp:include page="ufooter.jsp"/>
   <script>
           function checkOldPwd() {
               var oldPassword = $("#oldPassword").val();
               $.post('/front/user/confirmPwd.action',
                   {
                       "id":${user.id},
                       "oldPassword":oldPassword
                   },
                   function(data){
                       $("#msg").html(data.msg);
                   },
                   'json');
           }

           function checkDouble() {
               var new1 =  $("#newPassword").val();
               var new2 = $("#newPassword02").val();
               console.log(new1);
               console.log(new2);
               if(new1 !== new2){
                   $("#msg2").html("两次输入的密码不一致");
                   return false;
               }else {
                   $("#msg2").html("");
                   return true;
               }
           }
   </script><%--
   <%@include file="../include/script.html"%>--%>
   <script src="static/js/jquery-1.12.4.min.js"></script>
   <script src="static/js/jquery.validate.min.js"></script>
   <script src="static/js/jquery-confirm.min.js"></script>

</body>
</html>