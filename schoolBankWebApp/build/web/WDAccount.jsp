<%-- 
    Document   : WDAccount
    Author     : Julian A. P.
--%>

<%@page import="bis.account"%>
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
        <title>BB W/D</title>
    </head>
    <body>
        <a href="/schoolBankWebApp/logout">Logout</a>
        <a href="userHome.jsp">Home</a>
        <a href="updateInfo.jsp">Update personal info</a>
        <a href="newAcc.jsp">Add Account</a>
        <a href="WDAccount.jsp">Withdraw/Deposit</a>
        <h1>Hello <%=c.getFName() %></h1>
        <%
            //checks how many account the customer has
            int i = c.accList.count;
            if(i == 0){
        %>
        <h2>Sorry but you do not have any accounts to deposit or withdraw from.</h2>
        <%}
            else{
        %>
        <h2>Please select an account you and wither you wish to deposit or withdraw.</h2>
        <form action="/schoolBankWebApp/WDServelt" method="post">
        Account No: <select name="acc">
            <%
                //combo box with customer's account
            for(int x = 0; x < i; x++){
            %>
            <option value="<%=x%>"><%=c.accList.aArr[x].getAccNo() + " " +c.accList.aArr[x].getType()%></option>
            <%}%>
        </select><br>
        Amount: $ <input type="text" name="amount"required><br>
        Action: <select name="WD">
            <option value="W">Withdraw</option>
            <option value="D">Deposit</option>
        </select><br>
        <input type="submit" value="Submit">
        <input type="reset" value="Reset">
        </form>
            <%
            }
            %>
    </body>
</html>
