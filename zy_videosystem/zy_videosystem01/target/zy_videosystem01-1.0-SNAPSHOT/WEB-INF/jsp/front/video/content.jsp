<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<div class="intro">
	<div class="container">
		<div class="v-intro">
			<div class="left">
				<video id="videoPlayer" src="${video.videoUrl}" class="video-js vjs-default-skin" controls width="627" height="280"
					   poster="${video.videoImageUrl}" data-setup="{}">
				</video>
			</div>
			<div class="right">
				<p class="right-title">${video.videoTitle}</p>
				<div class="avatar">
					<span style="background-image: url(${speaker.speakerHeadUrl})"></span>
					<p><b>讲师：${speaker.speakerName}</b><br><i>${speaker.speakerDesc}</i></p>
				</div>
				<p class="video-intro">
					<span>本节内容：</span> ${video.videoDesc}
				</p>
			</div>
		</div>

		<div class="kcjs">
			<p class="title">课程介绍</p>
			<p class="content">${course.courseDesc}</p>
		</div>

	</div>
</div>
<!--目录-->
<div class="catalog">
	<div class="container">
		<p class="title">目录</p>
		<c:forEach items="${videoList}" var="video" >
			<div class="chapter">
				<p class="biaoti"><a href="front/video/index.action?videoId=${video.id}&subjectId=${subjectId}">${video.videoTitle}</a></p>
				<p class="lecturer">${video.videoDesc}</p>
				<p class="lecturer">讲师：${speaker.speakerName}</p>
				<div class="v-info">
					<span class="count"><img src="static/img/count.png" alt="">${video.videoPlayTimes}</span>
					<span class="duration"><img src="static/img/player.png" alt="">${video.videoLength}</span>
				</div>
			</div>
		</c:forEach>
	</div>
</div>