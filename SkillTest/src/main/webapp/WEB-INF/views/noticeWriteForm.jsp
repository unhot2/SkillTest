<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Notice Write</title>
<!-- 공통 파일 include -->
<%@ include file="common.jspf"%>
<!-- CSS 파일 -->
<link rel="stylesheet" href="resources/css/writeForm.css">
<!-- TinyMCE -->
<script
	src="https://cdn.tiny.cloud/1/pyf8q7628ksvj3qubyx8rsw0isih2qaef5jsvej0txldx5ji/tinymce/5/tinymce.min.js"
	referrerpolicy="origin"></script>
<!-- TinyMCE 초기화 -->
<script>
	var tiny_textArea = {
		selector : "#mytextarea",
		min_width : 1810,
		max_width : 1810,
		min_height : 350,
		max_height : 350,
		toolbar : 'insertfile undo redo | styleselect | bold italic underline forecolor | fontselect | fontsizeselect | fullscreen | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image',
		menubar : false,
		plugins : [
				'insertfile advlist autolink link image lists charmap print preview hr anchor pagebreak spellchecker',
				'searchreplace wordcount visualblocks visualchars code fullscreen insertdatetime media nonbreaking',
				'table emoticons template paste help' ],
		forced_root_block : ''
	}
	tinymce.init(tiny_textArea);
</script>
</head>
<body>
	<!-- 메뉴 부분 -->
	<div class="top-text">
		<img src="resources/img/home.png">
		<div>협업관리 > 커뮤니티 > 공지사항 작성</div>
	</div>
	<!-- 입력 폼 상단 부분 -->
	<form action="noticeWrite" method="post" enctype="multipart/form-data">
		<div class="container notice-info border-box">
			<div class="row">
				<div class="col-lg-1 text text-gr">회사</div>
				<div class="col-lg-2">
					<select name="company" class="company-select">
						<option value="(주)씨엔원">(주)씨엔원</option>
						<option value="(주)데상트">(주)데상트</option>
						<option value="(주)나이키">(주)나이키</option>
						<option value="(주)아디다스">(주)아디다스</option>
					</select>
				</div>
				<div class="col-lg-1 text">파일 첨부</div>
				<div class="col-lg-2">
					<input type="text" id="fileName" class="file_input_textbox"
						readonly="readonly">

					<div class="file_input_div glyphicon glyphicon-floppy-open">
					<input type="file" name="file" class="file_input_hidden"
							onchange="javascript: document.getElementById('fileName').value = this.value" />
					</div>

				</div>
				<div class="col-lg-1 text-gr text">비밀번호</div>
				<div class="col-lg-5">
					<input type="password" name="password" class="pwd-input">
				</div>
			</div>
			<!-- 제목 부분 -->
			<div class="row">
				<div class="col-lg-1 text text-gr">제목</div>
				<div class="col-lg-11">
					<input type="text" name="title" class="title-input">
				</div>
			</div>
			<!-- 공지 시작 -->
			<div class="row">
				<div class="col-lg-1 text text-gr">공지기간(시작)</div>
				<div class="col-lg-2">
					<input type="date" name="announment_start_date" class="date-form">
					<select name="announment_start_hour" class="time-select">
						<c:set var="n" value="0" />
						<c:forEach begin="0" end="23">
							<c:choose>
								<c:when test="${n < 10 }">
									<option value="${n }">0${n}시</option>
									<c:set var="n" value="${n+1}" />
								</c:when>
								<c:otherwise>
									<option value="${n }">${n}시</option>
									<c:set var="n" value="${n+1}" />
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select> <select name="announment_start_minute" class="time-select">
						<c:set var="n" value="0" />
						<c:forEach begin="0" end="59">
							<c:choose>
								<c:when test="${n < 10 }">
									<option value="${n }">0${n }분</option>
									<c:set var="n" value="${n+1}" />
								</c:when>
								<c:otherwise>
									<option value="${n }">${n }분</option>
									<c:set var="n" value="${n+1}" />
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</div>
				<!-- 공지 종료 -->
				<div class="col-lg-1 text text-gr">공지기간(종료)</div>
				<div class="col-lg-2">
					<input type="date" name="announment_end_date" class="date-form">
					<select name="announment_end_hour" class="time-select">
						<c:set var="n" value="0" />
						<c:forEach begin="0" end="23">
							<c:choose>
								<c:when test="${n < 10 }">
									<option value="${n }">0${n}시</option>
									<c:set var="n" value="${n+1}" />
								</c:when>
								<c:otherwise>
									<option value="${n }">${n}시</option>
									<c:set var="n" value="${n+1}" />
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select> <select name="announment_end_minute" class="time-select">
						<c:set var="n" value="0" />
						<c:forEach begin="0" end="59">
							<c:choose>
								<c:when test="${n < 10 }">
									<option value="${n }">0${n }분</option>
									<c:set var="n" value="${n+1}" />
								</c:when>
								<c:otherwise>
									<option value="${n }">${n }분</option>
									<c:set var="n" value="${n+1}" />
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</div>
				<div class="col-lg-1 text">팝업여부</div>
				<div class="col-lg-5">
					<input type="checkbox" class="form-check-input text"
						name="popup_use" value="1" checked />
				</div>
			</div>
			<!-- 팝업 시작 -->
			<div class="row">
				<div class="col-lg-1 text text-gr">팝업기간(시작)</div>
				<div class="col-lg-2">
					<input type="date" name="popup_start_date" class="date-form">
					<select name="popup_start_hour" class="time-select">
						<c:set var="n" value="0" />
						<c:forEach begin="0" end="23">
							<c:choose>
								<c:when test="${n < 10 }">
									<option value="${n }">0${n}시</option>
									<c:set var="n" value="${n+1}" />
								</c:when>
								<c:otherwise>
									<option value="${n }">${n}시</option>
									<c:set var="n" value="${n+1}" />
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select> <select name="popup_start_minute" class="time-select">
						<c:set var="n" value="0" />
						<c:forEach begin="0" end="59">
							<c:choose>
								<c:when test="${n < 10 }">
									<option value="${n }">0${n }분</option>
									<c:set var="n" value="${n+1}" />
								</c:when>
								<c:otherwise>
									<option value="${n }">${n }분</option>
									<c:set var="n" value="${n+1}" />
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</div>
				<!-- 팝업 종료 -->
				<div class="col-lg-1 text text-gr">팝업기간(종료)</div>
				<div class="col-lg-2">
					<input type="date" name="popup_end_date" class="date-form">
					<select name="popup_end_hour" class="time-select">
						<c:set var="n" value="0" />
						<c:forEach begin="0" end="23">
							<c:choose>
								<c:when test="${n < 10 }">
									<option value="${n }">0${n}시</option>
									<c:set var="n" value="${n+1}" />
								</c:when>
								<c:otherwise>
									<option value="${n }">${n}시</option>
									<c:set var="n" value="${n+1}" />
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select> <select name="popup_end_minute" class="time-select">
						<c:set var="n" value="0" />
						<c:forEach begin="0" end="59">
							<c:choose>
								<c:when test="${n < 10 }">
									<option value="${n }">0${n }분</option>
									<c:set var="n" value="${n+1}" />
								</c:when>
								<c:otherwise>
									<option value="${n }">${n }분</option>
									<c:set var="n" value="${n+1}" />
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>
		<!-- 내용 입력 영역 -->
		<div class="container border-box">
			<div class="col-lg-12 contextbox">
				<label>내용</label>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<textarea id="mytextarea" name="content"></textarea>
				</div>
			</div>
		</div>
		<div class="btns">
			<input type="submit" value="저장"> 
			<input type="button" value="목록" onclick="noticeList()">
		</div>
	</form>
	<script>
		/* 공지기간, 팝업기간 날짜입력 부분 오늘날짜로 초기화 */
		$(document).ready(function() {
			$(".date-form").val(new Date().toISOString().substring(0, 10))
		})

		/* 게시판 목록 이동 */
		function noticeList() {
			location.href = 'list'
		}
	</script>
</body>
</html>
