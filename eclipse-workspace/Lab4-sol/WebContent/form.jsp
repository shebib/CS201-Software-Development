<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form id = "myForm" name = "lab5_form"  method= "GET" action = "Validation">

<h3>Customer Info</h3>
Name:  <input type ="text" name = "name" value =${param.name!=null? param.name : ''}>
<span style="color: red;font-weight:bold">${name_err!=null? name_err : ''}</span><br>
E-mail:<input type = "email" name = "email" value =${param.email!=null? param.email : ''}>
<span style="color: red;font-weight:bold">${email_err!=null? email_err : ''}</span><br>
Favorite color: <input type = "color" name = "favcolor" value =${param.color!=null? param.color : ''}><br>
Favorite month: <input type="month" name="favmonth" value =${param.month!=null? param.month : ''}>
<span style="color: red;font-weight:bold">${month_err!=null? month_err : ''}</span><br>
Favorite website url: <input type="url" name="favweb" value =${param.url!=null? param.url : ''}>
<span style="color: red;font-weight:bold">${url_err!=null? url_err : ''}</span><br>
Things you want to search most: <input type = "search" name = "favsearch" value =${param.search!=null? param.search : ''}>
<span style="color: red;font-weight:bold">${search_err!=null? search_err : ''}</span><br>

<h3>Please select burger style</h3>
<select name = "brand">
	<option value="innout" ${param.brand=="innout"? 'selected' : ''}>In And Out Animal Style</option>
	<option value="mcdonald" ${param.brand=="mcdonald"? 'selected' : ''}>Mc Donald Double Cheese</option>
	<option value="habit" ${param.brand=="habit"? 'selected' : ''}>Habit Charburger</option>
	<option value="burgerk" ${param.brand=="burgerk"? 'selected' : ''}>Burger King Sandwich</option>
</select>

<h4>Please choose a theme for your burger: </h4>
<input type = "radio" name = "burgertype" value = "beef" ${param.burgertype=="beef"||param.burgertype==null? 'checked' : ''}> Beef
<input type = "radio" name = "burgertype" value = "pork" ${param.burgertype=="pork"? 'checked' : ''}> Pork
<input type = "radio" name = "burgertype" value = "chicken" ${param.burgertype=="chicken"? 'checked' : ''}>Chicken
<input type = "radio" name = "burgertype" value = "vaggie" ${param.burgertype=="vaggie"? 'checked' : ''}>Vaggie<br>

<h4>Other preference: </h4>
<input type = "checkbox" name = "onion" value = "onion" ${param.onion=="onion"? 'checked' : ''}>Onion?<br>

<h4>How would you like the burger cooked: </h4>
<input type = "range" name = "cooked" min = "0" max = "10" value = ${param.cooked!=null? param.cooked : '5'}><br>

<h4>Please enter other special special requests: </h4>
<textarea name = "special" rows="4" cols="50">${param.special!=null? param.special : ''}</textarea>

<h3>Press the button to place your order</h3>
<input type="reset" value="Reset">
<input type = "submit" name = "submit" value = "place order">
</form>
</body>
</html>