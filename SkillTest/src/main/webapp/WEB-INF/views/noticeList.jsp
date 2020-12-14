<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice List</title>
<!-- 공통 파일 include -->
<%@ include file="common.jspf" %>
<!-- CSS 파일 -->
<link rel="stylesheet" href="resources/css/noticeList.css">
</head>
<body>
	<div class="top-text">
		<img src="resources/img/home.png">
		<div>협업관리 > 커뮤니티 > 공지사항</div>
	</div>
	<form action="search" method="post">
		<div class="search-info border-box">
			<div class="text">회사</div>
			<div class="select-form">
				<select name="search_company" class="company-select">
					<option value="(주)씨엔원">(주)씨엔원</option>
					<option value="(주)데상트">(주)데상트</option>
					<option value="(주)나이키">(주)나이키</option>
					<option value="(주)아디다스">(주)아디다스</option>
				</select>
			</div>
			<div class="text text-gr text">등록일</div>
			<div>
				<input type="date" name="search_regdate_start" class="date-form"
					required>~
			</div>
			<div>
				<input type="date" name="search_regdate_end" class="date-form"
					required>
			</div>
			<div class="text text">제목</div>
			<div>
				<input type="text" name="search_title" class="title-input" required>
			</div>
			<div class="text text">등록자</div>
			<div>
				<input type="text" name="search_writer" class="title-input" required>
			</div>
		</div>
		<div class="search_btn">
			<input type="submit" class="btns" value="조회">
		</div>
	</form>
	<div class="container border-box">
		<table class="table">
			<thead>
				<tr>
					<th scope="col" class="tb-td-1">선택</th>
					<th scope="col" class="tb-td-2">회사</th>
					<th scope="col" class="tb-td-3">제목</th>
					<th scope="col" class="tb-td-4">첨부파일</th>
					<th scope="col" class="tb-td-5">조회수</th>
					<th scope="col" class="tb-td-6">작성자</th>
					<th scope="col" class="tb-td-7">등록일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="list">
					<tr>
						<td><input type="checkbox" name="notice_num" class="chk"
							value="${list.notice_num }"></td>
						<td>${list.company }</td>
						<td>
						<a href="javascript:hit_up('${list.notice_num }')">${list.title }</a>
						</td>
						<td>${list.org_file_name }</td>
						<td>${list.hit }</td>
						<td>${list.writer }</td>
						<td><fmt:formatDate value="${list.regdate }" type="date" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="paging">
			<button onclick="first_prev()">&#171;</button>
			<button onclick="prev('${current_page}')" class="prev">&#60;</button>
			<c:forEach begin="1" end="${page_num }" step="1" var="cnt">
				<c:choose>
					<c:when test="${current_page == cnt }">
						<button onclick="move_page('${cnt}')"
							style="background: #2b7fbb; color: white;">${cnt }</button>
					</c:when>
					<c:otherwise>
						<button onclick="move_page('${cnt}')">${cnt }</button>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<button onclick="next('${current_page}')" class="next">&#62;</button>
			<button onclick="last_next('${page_num}')">&#187;</button>
		</div>
	</div>
	<div class="btn-div">
		<a class="btns" href="noticeWriteForm">등록</a> <a class="btns" href="#">수정</a>
		<label onclick="if(confirm('삭제 하시겠습니까?')){noticeDel()}" class="btns">삭제</label>
		<a class="btns" href="/">목록</a>
	</div>
	<script>
		/* 페이지 번호 < , > 비활성화 기능 */
		$(document).ready(function() {
			var cp = ${current_page}
			var pn = ${page_num} 
			$(".prev").attr("disabled", cp > 1 ? false : true)
			$(".next").attr("disabled", cp == pn ? true : false)
		})
		/* 조회수 올리기 */
		function hit_up(notice_num){
			$.ajax({
				url : 'hitUp',
				type : 'post',
				dataType : 'text',
				data :{num : notice_num}
			}).done(function(){location.href='/'})
		}
		/* 맨앞으로 이동 */
		function first_prev() {
			location.href = '/?current_page=' + 1
		}
		/* 이전화면 이동 */
		function prev(current_page) {
			var prevNum = Number(current_page)
			location.href = '/?current_page=' + (prevNum - 1)
		}
		/* 다음화면 이동 */
		function next(current_page) {
			var nextNum = Number(current_page)
			location.href = '/?current_page=' + (nextNum + 1)
		}
		/* 맨뒤로 이동 */
		function last_next(page_num) {
			location.href = '/?current_page=' + page_num
		}
		/* 페이지 이동 */
		function move_page(cnt) {
			location.href = '/?current_page=' + cnt
		}
		/* 게시글 삭제 chk된 값들을 배열에 저장해서 dao.noticeDelete()에서 
		배열크기 만큼 반복하여 SQL문 실행 -> 클릭된 게시글 한번에 삭제 가능*/
		function noticeDel() {
			var checkArr = []
			$(".chk:checked").each(function() {
				checkArr.push($(this).val())
			})
			$.ajax({
				url : 'noticeDelete',
				type : 'post',
				dataType : 'text',
				data : {
					deleteArr : checkArr
				}				
			}).done(function(){location.href='/'})
		}
	</script>
</body>
</html>