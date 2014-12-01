<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Index</title>
<link type="text/css" href="./style/index.css" rel="stylesheet">
</head>
<body>
<div>
	<div class="container">
		<div class="title"></div>
		<c:forEach items="${list}" step="3" varStatus="status">
		<div class="content">
			<c:forEach items="${list}" var="tb" begin="${status.index}" end="${status.index + 2}" varStatus="tbStatus">
			<c:choose>
			<c:when test="${tbStatus.last}">
			<div class="column last">
			</c:when>
			<c:otherwise>
			<div class="column">
			</c:otherwise>
			</c:choose>
				<div class="img_container">
					<img class="img_show" src="${tb.img}"/>
				</div>
				<div class="des"><a href="${tb.link }">${tb.title }</a></div>
			</div>
			</c:forEach>
		</div> 
		</c:forEach>
		
	</div>
</div>
</body>
</html>