 <%-- 
    Document   : userHome
    Author     : Julian A. P.
--%>

<%@page import="bis.customer"%>
<%@page import="bis.userAccs"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accounts</title>
    </head>
    <body>
        <a href="/schoolBankWebApp/logout">Logout</a>
        <a href="userHome.jsp">Home</a>
        <a href="updateInfo.jsp">Update personal info</a>
        <a href="newAcc.jsp">Add Account</a>
        <a href="WDAccount.jsp">Withdraw/Deposit</a>
        <%
            //get customer from session
            customer c;
            c = (customer)session.getAttribute("c1");
        %> 
        <h1>Hello, <%= c.getFName()%> <%= c.getLName()%></h1>
        <h3>Customer ID: <%=c.getId()%></h3>
        <h3>State: <%=c.getState()%></h3>
        <h3>Email: <%=c.getEMail()%></h3>
            <% 
                //checks how many accounts the customer has
                int i = c.accList.count;
                if(i == 0){
            %>
            <h1>You have zero accounts</h1>
            <a href="newAcc.jsp">Create Account</a>
            <% }
                //displays accounts
                else{
                    for(int x = 0; x < i; x++){
            %>
            <table>
                <tr>
                    <th>Account No</th>
                    <th>Customer ID</th>
                    <th>Account Type</th>
                    <th>Balance</th>
                </tr>
                <tr>
                    <th><%=c.accList.uAcc[x].getAccNo()%></th>
                    <th><%=c.accList.uAcc[x].getCustId()%></th>
                    <th><%=c.accList.uAcc[x].getType()%></th>
                    <th>$<%=c.accList.uAcc[x].getBal()%></th>
                    <%  }
                    }
                    %>
                </tr>
            </table>
    </body>
</html>