<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>notice list</title>
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

.a {
	color: black;
	text-decoration: none;
}
</style>

</head>
<body>
	<c:import url="../layout/nav.jsp" />
	<h1>Notice List</h1>

	<section style="background-color: rgb(240, 240, 240); height: auto; padding-bottom: 20px;">
		<div class="div_t">
<<<<<<< Updated upstream:src/main/webapp/WEB-INF/views/notice/noticeList.jsp
=======
		
		<div>
			<form action="./qnaList" id="frm">
				<input type="hidden" value="1" name="curPage" id="curPage">
			
				<select name="kind">				
					<option id="kT" value="kT">제목</option>
					<option id="kW"  value="kW">작성자</option>
					<option id="kC" value="kC">내용</option>
				</select>
			
				<input type="text" name="search" value="${pager.search}">
				
				<button>검색</button>
			</form>
		</div>

>>>>>>> Stashed changes:src/main/webapp/WEB-INF/views/qna/qnaList.jsp
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
					<c:forEach items="${list}" var="dto">
						<tr class="b3">
							<td>${dto.num}</td>
							<td class="b4"><a class="a" href="./noticeSelect?num=${dto.num}">${dto.title}</a></td>
							<td>${dto.writer}</td>
							<td>${dto.reg_date}</td>
							<td>${dto.hit}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div style="width: 100%; margin: 0 auto; text-align: center; padding-top: 10px;">
				<ul class="pagination" style="margin: 0 auto; text-align: center;">
					
					<c:if test="${pager.curBlock gt 1}">
<<<<<<< Updated upstream:src/main/webapp/WEB-INF/views/notice/noticeList.jsp
					<li style="margin: 0 auto;"><a href="./noticeList?curPage=${pager.startNum - 1}">이전</a></li>
=======
						<%-- <li><a href="./qnaList?curPage=${pager.startNum - 1}">이전</a></li> --%>
						<li><span id=${pager.startNum - 1} class="List">이전</span></li>
>>>>>>> Stashed changes:src/main/webapp/WEB-INF/views/qna/qnaList.jsp
					</c:if>
					
					<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" step="1" var="i">
<<<<<<< Updated upstream:src/main/webapp/WEB-INF/views/notice/noticeList.jsp
    				<li style="margin: 0 auto;"><a href="./noticeList?curPage=${i}">${i}</a></li>
					</c:forEach>
					
					<c:if test="${pager.curBlock lt pager.totalBlock }">
					<li style="margin: 0 auto;"><a href="./noticeList?curPage=${pager.lastNum + 1}">다음</a></li>
=======
						<%-- <li><a href="./qnaList?curPage=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li> --%>
						<li><span id="${i}" class="list">${i}</span></li>
					</c:forEach>

					<c:if test="${pager.curBlock lt pager.totalBlock}">
						<%-- <li><a href="./qnaList?curPage=${pager.lastNum + 1}">다음</a></li> --%>
						<li><span id="${pager.lastNum + 1}" class="list">다음</span></li>
>>>>>>> Stashed changes:src/main/webapp/WEB-INF/views/qna/qnaList.jsp
					</c:if>
					
				</ul>
			</div>

			<a href="./noticeWrite">Go notice write</a><br>
		</div>
		
	</section>
	
<<<<<<< Updated upstream:src/main/webapp/WEB-INF/views/notice/noticeList.jsp
	<img alt="" src="../resources/images/cha2.jpg">
	
=======
	<script type="text/javascript">
		var kind = '${pager.kind}';
		if (kind == '') {
			kind = "kT";
			
		}
		$("#"+kind).prop("selected", true);
	
		$(".list").click(function() {
			$("#curPage").val($(this).attr("id"));
			$("#frm").submit();
		});
	
		
		
	</script>
>>>>>>> Stashed changes:src/main/webapp/WEB-INF/views/qna/qnaList.jsp

</body>
</html>