<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <title>Tickets</title>
 <style>
   body {
    background: #c7b39b url(C:\Users\pc\Desktop\софтсерв\page1a); /* Цвет фона и путь к файлу */
    color: #fff; /* Цвет текста */
   }
  </style>
</head>
<body>
    <center>
        <h2>
          Sign up and choose the flight
        </h2>
    </center>
    <div align="center">
            <form action="insert" method="post">
        <table border="1" cellpadding="5">
            <caption>
            </caption>
                <c:if test="${client != null}">
                    <input type="hidden" name="id" value="<c:out value='${client.id}' />" />
                </c:if>
            <tr>
                <th>Email: </th>
                <td>
                    <input type="text" name="email" size="45"
                            value="<c:out value='${client.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Password: </th>
                <td>
                    <input type="text" name="pass" size="45"
                            value="<c:out value='${client.pass}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>FirstName: </th>
                <td>
                    <input type="text" name="firstName" size="45"
                            value="<c:out value='${client.firstName}' />"
                    />
                </td>
            </tr>
                <th>LastName: </th>
                <td>
                    <input type="text" name="lastName" size="45"
                           value="<c:out value='${client.lastName}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Sign up" />
                </td>
            </tr>
        </table>
        </form>
    </div>
</body>
</html>