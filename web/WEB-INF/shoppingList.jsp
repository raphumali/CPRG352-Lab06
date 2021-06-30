<%-- 
    Document   : shoppingList
    Created on : Jun 26, 2021, 7:51:47 PM
    Author     : 786097
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p> Hello, ${username} </p>
        <a href="?action=logout">Logout</a>
        <form method="post" action="">
            <h2>List</h2>
            <label for="items" name="itemsLabel" value="add">Add item: </label>
            <input type="text" name="addItem">
            <input type="submit" action="add" value="Add">
            <input type="hidden" name="action" value="add">
        </form>
        <c:if test ="${!items.isEmpty()}">
            <form method="post" action="">
                
                <c:forEach var="i" items="${items}">
                      <input type="radio" name="list" value="${i}">${i}<br>
                </c:forEach>
                      
                      <input type="submit" action="delete" value="Delete">
                      <input type="hidden" name="action" value="delete">
                
            </form>
            </c:if>
    </body>
</html>
