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
					type="text" class="form-control" id="writer" readonly name="writer"
					value='<security:authentication property="principal.username"/>'>
				<div class="invalid-feedback">작성자를 확인해 주세요</div>
			</div>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<button type="submit" class="btn btn-primary">등록</button>
			<button type="reset" class="btn btn-secondary">취소</button>
		</form>
	</div>
</div>
<div class="row mt-3">
	<div class="col">
	 <div class="card">
		<div class="card-header">
			<i class="fa fa-file"></i>
			파일첨부
		</div>
			<div class="card-body">
				<div class="form-group uploadDiv">
					<input type="file" name="uploadFile" id="uploadFile" multiple />
				</div>
				<div class="uploadResult">

					<ul></ul>
				</div>
			</div>
		</div>
	</div>
</div>


<script>
	const path= '${pageContext.request.requestURI}';
	// CSRF 토큰값 생성
	const csrfToken='${_csrf.token}';
</script>

<script src="/js/register.js"> </script>
<script src="/js/upload.js"> </script>
<%@ include file="../include/footer.jsp"%>