<%-- 
    Document   : register
    Created on : Feb 14, 2022, 11:20:16 PM
    Author     : Yoonju Baek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        
        <form action="ShoppingList" method="post">
            <input type="hidden" name="action" value="register">
            <label for="username">Username: </label>
            <input type="text" name="username" id="username" />
            
            <button type="submit">Register name</button>
        </form>
    </body>
</html>
