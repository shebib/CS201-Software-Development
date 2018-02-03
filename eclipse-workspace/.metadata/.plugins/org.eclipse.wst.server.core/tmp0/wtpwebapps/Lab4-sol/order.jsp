<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Order Submission</title>
  </head>
  <body>
    <h1>Submitted Order</h1>
    <table>
      <tr>
        <th style = "width: 250px">Field</th>
        <th>Value</th>
      </tr>
      <tr>
        <td>Name</td>
        <td>${param.name}</td>
      </tr>
      <tr>
        <td>Email</td>
        <td>${param.email}</td>
      </tr>
      <tr>
        <td>Color</td>
        <td>${param.favcolor}</td>
      </tr>
      <tr>
        <td>Month</td>
        <td>${param.favmonth}</td>
      </tr>
      <tr>
        <td>URL</td>
        <td>${param.favweb}</td>
      </tr>
      <tr>
        <td>Search</td>
        <td>${param.favsearch}</td>
      </tr>
      <tr>
        <td>Takeout Box</td>
        <td>${param.brand}</td>
      </tr>
      <tr>
        <td>Burger Style</td>
        <td>${param.burgertype}</td>
      </tr>
      <tr>
        <td>Onion?</td>
        <td>${param.onion=="onion"?"Yes":"No"}</td>
      </tr>
      <tr>
        <td>Cooking style</td>
        <td>${param.cooked}</td>
      </tr>
      <tr>
        <td>Special Request</td>
        <td>${param.special}</td>
      </tr>
    </table>
  </body>
</html>