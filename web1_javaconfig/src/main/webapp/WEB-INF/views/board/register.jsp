<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>B.REGISTER</h2>
	<form action="" method="post">
		<div>
			<label for="name">name</label>
			<input type="text" name="name" id="name" value="${boardDTO.name}"/>
		</div>
		<div>
			<label for="password">password</label>
			<input type="password" name="password" id="password" value="${boardDTO.password}"/>
		</div>
		<div>
			<label for="title">title</label>
			<input type="text" name="title" id="title" value="${boardDTO.title }"/>
		</div>
		<div>
			<label for="content">content</label>
			<textarea rows="5" cols="30" name="content" value="${boardDTO.content}"></textarea>
		</div>
	
		<div>
			<button type="submit">회원가입</button>
		</div>
	</form>
</body>
</html>