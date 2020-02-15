<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <title>Tickets</title>
    <meta charset="utf-8">
    <title>Order panel flight tickets</title>
</head>
<body>
<div style="text-align: center">
    <h1>Plane order panel</h1>
    <b>${user.firstName} (${user.lastName})</b>
    <br><br>
    <a href="http://localhost:8080/flighttickets_war_exploded/">Logout</a>
</div>
</body>
</html>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <title>Tickets</title>
    <title>Order tickets</title>
</head>
<body>
<div align="center">
    <h2>Select plane</h2>
    <table border="1" cellpadding="5">
        <tr>
            <th>Id_plane</th>
            <th>Type</th>
            <th>Comfort</th>
            <th>Price</th>
            <th>Action</th>

        </tr>
        <c:forEach var="plane" items="${planeList}">
            <tr>
                <td><c:out value="${plane.id_plane}" /></td>
                <td><c:out value="${plane.name_type}" /></td>
                <td><c:out value="${plane.comfort}" /></td>
                <td><c:out value="${plane.price}" /></td>
                <td>
                    <a href="http://localhost:8080/flighttickets_war_exploded/multiresult?id_plane=<c:out value='${plane.id_plane}' />">add</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
