<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add User</title>
</head>
<body>
	<form action="user" method="post">
		<fieldset>
			<legend>Add User</legend>

			<label for="nom">Name:</label> 
			<input type="text" name="name" id="nam" required><br> 
            <label for="lastname">Last Name:</label> 
			<input type="text" name="lastname" id="lastname"><br>
            <label for="user">User:</label> 
			<input type="text" name="user" id="user"><br>
			<label for="key">Password:</label> 
			<input type="password" name="password" id="key">
			<input 	type="hidden" value="ADD" name="action">
		</fieldset>
		<input type="submit" value="Send">

	</form>
</body>
</html>
