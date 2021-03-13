<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/index.action">视频管理系统
            </a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li <c:if test='${param.fromJsp=="video"}'>class="active"</c:if>><a
                        href="admin/video/index.action">视频管理</a></li>
                <li <c:if test='${param.fromJsp=="speaker"}'>class="active"</c:if>><a href="admin/speaker/index.action">主讲人管理</a>
                </li>
                <li <c:if test='${param.fromJsp=="course"}'>class="active"</c:if>><a href="admin/course/index.action">课程管理</a>
                </li>
                <li <c:if test='${param.fromJsp=="state"}'>class="active"</c:if>><a href="admin/state/courseavg.action">统计分析</a>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="admin/logout.action" title="点击退出登录">${sessionScope.session_admin.loginName }<i
                        class="glyphicon glyphicon-log-out" aria-hidden="true"></i></a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
    