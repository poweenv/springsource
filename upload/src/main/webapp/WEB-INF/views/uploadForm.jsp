<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   <!-- form 안에 file 요소가 존재 시 enctype 변경 -->
	<form action="" method="post" enctype="multipart/form-data">
		<div>
			<label for="name"></label>
			<input type="text" name="name" id="name" />
		</div>
		<div>
			<label for="file"></label>
			<input type="file" name="file" id="file" multiple accept="image/*,.txt"/> <!-- accept 첨부할수 있는 파일 제안 -->
		</div>
		<div>
			<button type="submit">submit</button>
		</div>
	</form>
</body>
</html>