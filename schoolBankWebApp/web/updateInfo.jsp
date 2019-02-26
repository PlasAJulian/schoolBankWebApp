<%-- 
    Document   : updateInfo
    Author     : Julian A. P.
--%>

<%@page import="bis.customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Info</title>
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
        <h1>Please edit the information you wish to update.</h1>
        <form action="/schoolBankWebApp/updateInfoServelt" method="post">
            <h2>Account No: <%=c.getId()%></h2>
            First name: <input type="text" name="fName" value="<%=c.getFName()%>"required><br>
            Last name: <input type="text" name="lName" value="<%=c.getLName()%>" required><br>
            Password: <input type="text" name="password" value="<%=c.getPwd()%>" required><br>
            State <select name="state">
                <option selected="<%=c.getState()%>"><%=c.getState()%></option>
                <option value="Alabama">Alabama</option>
                <option value="Alaska">Alaska</option>
                <option value="Arizona">Arizona</option>
                <option value="Arkansas">Arkansas</option>
                <option value="California">California</option>
                <option value="Colorado">Colorado</option>
                <option value="Connecticut">Connecticut</option>
                <option value="Delaware">Delaware</option>
                <option value="District Of Columbia">District Of Columbia</option>
                <option value="Florida">Florida</option>
                <option value="Georgia">Georgia</option>
                <option value="Hawaii">Hawaii</option>
                <option value="Idaho">Idaho</option>
                <option value="Illinois">Illinois</option>
                <option value="Indiana">Indiana</option>
                <option value="Iowa">Iowa</option>
                <option value="Kansas">Kansas</option>
                <option value="Kentucky">Kentucky</option>
                <option value="Louisiana">Louisiana</option>
                <option value="Maine">Maine</option>
                <option value="Maryland">Maryland</option>
                <option value="Massachusetts">Massachusetts</option>
                <option value="Michigan">Michigan</option>
                <option value="Minnesota">Minnesota</option>
                <option value="Mississippi">Mississippi</option>
                <option value="Missouri">Missouri</option>
                <option value="Montana">Montana</option>
                <option value="Nebraska">Nebraska</option>
                <option value="Nevada">Nevada</option>
                <option value="New Hampshire">New Hampshire</option>
                <option value="New Jersey">New Jersey</option>
                <option value="New Mexico">New Mexico</option>
                <option value="New York">New York</option>
                <option value="North Carolina">North Carolina</option>
                <option value="North Dakot">North Dakota</option>
                <option value="Ohio">Ohio</option>
                <option value="Oklahoma">Oklahoma</option>
                <option value="Oregon">Oregon</option>
                <option value="Pennsylvania">Pennsylvania</option>
                <option value="Rhode Island">Rhode Island</option>
                <option value="South Carolina">South Carolina</option>
                <option value="South Dakota">South Dakota</option>
                <option value="Tennessee">Tennessee</option>
                <option value="Texas">Texas</option>
                <option value="Utah">Utah</option>
                <option value="Vermont">Vermont</option>
                <option value="Virginia">Virginia</option>
                <option value="Washington">Washington</option>
                <option value="West Virginia">West Virginia</option>
                <option value="Wisconsin">Wisconsin</option>
                <option value="Wyoming">Wyoming</option>
            </select><br>
            E-mail: <input type="email" name="email" value="<%=c.getEMail()%>" required><br>
            <input type="submit" value="Update">
            <input type="reset" value="Reset">
        </form>
    </body>
</html>
