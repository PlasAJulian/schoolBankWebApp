<%-- 
    Document   : login
    Author     : Julian A. P.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>BB Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <a href = "index.jsp">Home</a>
        <h1>Login</h1>
        <form action="/schoolBankWebApp/loginServlet" method="post">
            Customer ID: <input type="text" name="ID" required ><br>
            Password: <input type="password" name="password" required><br>
            <input type="submit" value="Login">
            <input type="reset" value="Clear">
        </form>
    </body>
</html>