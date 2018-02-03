<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CSCI 201 Forms</title>
</head>
<body>
<h2>We got forms</h2>
		<form id="artform" method="get" action="Validation">
			<fieldset>
				<legend>Personal Info:</legend>
				First Name: 
				<input type="text" name="fname" value="First Name"><br>
				${fname_err}
				Last Name: 
				<input type="text" name="lname" value="Last Name"><br>
				${lname_err}
				<input type="submit" value="Submit">
			</fieldset>
			<fieldset>
				<legend>Music Taste:</legend>
				Favorite Artist:
				<select name="Artist">
					<option value="kperry">Katy Perry</option>
					<option value="dglo">Donald Glover</option>
				</select>
				
			</fieldset>
		</form>
</body>
</html>