<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>notice select</title>
<c:import url="../layout/bootStrap.jsp" />
<style type="text/css">
.div_t {
	width: 70%;
	height: 910px;
	margin: 0 auto;
	background-color: rgb(240, 240, 240);
}

.t {
	width: 100%;
	margin: 0 auto;
	text-align: center;
	font-size: 13px;
	border-bottom: 5px rgb(240, 240, 240) solid;
	border-spacing: 0px;
	border-collapse: collapse;
}

.notice {
	height: 70px;
	font-size: 30px;
	background-color: rgb(240, 240, 240);
}

.black {
	font-weight: bold;
	height: 50px;
	background-color: #252525;
	text-align: center;
	color: white;
}

.b1 {
	width: 10%;
}

.b2 {
	text-align: left;
	border-bottom: 5px rgb(240, 240, 240) solid;
}

.b3 {
	height: 50px;
	background-color: white;
	border-bottom: 5px rgb(240, 240, 240) solid;
}

.b4 {
	text-align: left;
	font-weight: bold;
}

.b5 {
	width: inherit;
	height: 400px;
}

.a {
	color: black;
	text-decoration: none;
}
</style>
</head>
<body>
	<c:import url="../layout/nav.jsp" />
	<h1>Notice Select</h1>

	<section
		style="background-color: rgb(240, 240, 240); height: auto; padding-bottom: 20px;">
		<div class="div_t">
			<table class="t">

				<thead>
					<tr class="notice">
						<td colspan="5">NOTICE</td>
					</tr>

					<tr class="black">
						<td class="b1">NO</td>
						<td>TITLE</td>
						<td class="b1">WRITER</td>
						<td class="b1">DATE</td>
						<td class="b1">HIT</td>
					</tr>
				</thead>

				<tbody>
					<tr class="b3">
						<td>${requestScope.dto.num}</td>
						<td class="b4">${requestScope.dto.title}</td>
						<td>${requestScope.dto.writer}</td>
						<td>${requestScope.dto.reg_date}</td>
						<td>${requestScope.dto.hit}</td>
					</tr>

					<tr class="b3">
						<td class="b5" colspan="5"
							style="text-align: left; vertical-align: top; padding: 25px; height: 650px;">${requestScope.dto.contents}</td>
					</tr>
				</tbody>
			</table>

			<a href="./noticeUpdate?num=${requestScope.dto.num}">UPDATE</a>
			<a href="./noticeDelete?num=${requestScope.dto.num}">DELETE</a>

		</div>
	</section>

</body>
</html>