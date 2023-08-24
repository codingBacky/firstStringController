<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- http://localhost:8081/test프로젝트명/memberJoin -->
<form action="memberJoin" method="get">
	<label for="memId">ID</label><input type="text" id="memId" name="memId"/><br />
	<label for="memPwd1">PWD</label><input type="password" id="memPwd1"/><br />
	<label for="memPwd2">PWD check</label><input type="password" id="memPwd2" name="memPwd"/><br />
	<label for="memName">NAME</label><input type="text" id="memName" name="memName"/><br />
	<label for="email">Email address</label><input type="text" id="email" name="email"/><br />
	<label for="postCode">Post code</label><input type="text" id="postCode" name="postCode"/><br />
	<label for="detailAddress">Detail address</label><input type="text" id="detailAddress" name="detailAddress"/><br />
	<input type="submit" value="회원가입" />
	<input type="reset" value="입력취소" />
</form>
</body>
</html>