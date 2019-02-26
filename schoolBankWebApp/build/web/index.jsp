<%-- 
    Document   : index
    Author     : Julian A. P.
--%>
<%
    //clears session incase user did not select logout
    HttpSession ses1;
    ses1 = request.getSession();
    ses1.invalidate();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>BlankBank</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <a href = "login.jsp">Login</a>	<br><br>
        <a href = "newUser.jsp">Create new account</a>
        <h1>Welcome to BlankBank</h1>
        <img src="bank.jpg" width="300" height="150">
    </body>
</html>