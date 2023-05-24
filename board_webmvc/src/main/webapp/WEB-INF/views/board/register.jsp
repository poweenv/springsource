<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">BoardRegister</h1>
</div>
<div class="row">
	<div class="col">
		<form action="" method="post" id="registerForm" novalidate>
			<div class="form-group">
				<label for="title">title</label>
				<input type="text" class="form-control" id="title" name="title" placeholder="title" required>
				<div class="invalid-feedback">제목을 확인해 주세요</div>
			</div>
			<div class="form-group">
				<label for="content">Content</label>
				<textarea class="form-control" id="content" name="content" placeholder="content" required rows="10"></textarea>
			<div class="invalid-feedback">내용을 확인해 주세요</div>
			</div>
			<div class="form-group">
				<label for="writer">writer</label> <input
					type="text" class="form-control" id="writer" placeholder="writer" required name="writer">
				<div class="invalid-feedback">작성자를 확인해 주세요</div>
			</div>
			<button type="submit" class="btn btn-primary">등록</button>
			<button type="reset" class="btn btn-secondary">취소</button>
		</form>
	</div>
</div>






<script src="/resources/js/register.js"> </script>
<%@ include file="../include/footer.jsp"%>