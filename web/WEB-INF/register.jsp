<%-- 
    Document   : register
    Created on : Jun 26, 2021, 7:51:34 PM
    Author     : 786097
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form method="post" action="">
            <label for="user" name="username" id="username">Username: </label>
            <input type="text" name="username">
            <input type="submit" action="register" value="Register Name"><br>
            <input type="hidden" name="action" value="register"/>
        </form>
    </body>
</html>
