<%-- 
    Document   : newAcc
    Author     : Julian A. P.
--%>

<%@page import="bis.customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    //gets customer from session 
    customer c;
    c = (customer)session.getAttribute("c1");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BB New Account</title>
    </head>
    <body>
        <a href="/schoolBankWebApp/logout">Logout</a>
        <a href="userHome.jsp">Home</a>
        <a href="updateInfo.jsp">Update personal info</a>
        <a href="newAcc.jsp">Add Account</a>
        <a href="WDAccount.jsp">Withdraw/Deposit</a>
        <h2>Customer ID: <%=c.getId()%></h2>
        <%
            //checks if customer has reached the max number of accounts
            if(c.accList.count == 4){
        %>
        <h2>Sorry, <%=c.getFName()%> but you have reached the account limit.</h2>
        <%}
            else{
            %>
            <h3>The starting balance for any account is $100. Please select the account to wish to have.</h3>
            <form action="/schoolBankWebApp/addAccServelt" method="post">
                Account Type: <select name="aType">
                    <option value="SAV">Saving Account</option>
                    <option value="CHK">Checking Account</option>
                    <option value="MMA">Money Market Account</option>
                </select>
                <input type="submit" value="Submit">
                <input type="reset" value="Clear">
            </form>
            <%}
            %>
    </body>
</html>
