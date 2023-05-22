<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">BoardRead</h1>
</div>
<div class="row">
	<div class="col">
		<form action="" method="post">
			<div class="form-group">
				<label for="title">title</label> <input
					type="text" class="form-control" id="title" name="title" readonly value="${dto.title}">
			</div>
			<div class="form-group">
				<label for="content">Content</label>
				<textarea class="form-control" id="content" name="content" rows="10" readonly >${dto.content}</textarea>
			</div>
			<div class="form-group">
				<label for="writer">writer</label> <input
					type="text" class="form-control" id="writer" name="writer" readonly value="${dto.writer}">
			</div>
			<button type="button" class="btn btn-info">수정</button>
			<button type="button" class="btn btn-secondary">목록</button>
		</form>
	</div>
</div>

<form action="" id="operForm">
	<input type="hidden" name="bno" value="${dto.bno}"/>
</form>
<script src="/resources/js/read.js"></script>
<%@ include file="../include/footer.jsp"%>