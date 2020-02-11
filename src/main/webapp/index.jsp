<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <title>Tickets</title>

</head>
<body>
<center>
    <h2>
        Sign up and choose the flight
    </h2>
</center>
<div align="center">
    <form action="index" method="post">
        <table border="1" cellpadding="5">

            <tr>
                <th>Email: </th>
                <td>
                    <input type="text" name="email" size="45"

                    />
                </td>
            </tr>
            <tr>
                <th>Password: </th>
                <td>
                    <input type="text" name="pass" size="45"

                    />
                </td>
            </tr>
            <tr>
                <th>FirstName: </th>
                <td>
                    <input type="text" name="firstName" size="45"

                    />
                </td>
            </tr>
            <th>LastName: </th>
            <td>
                <input type="text" name="lastName" size="45"

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

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" type="text/css">
    <meta charset="utf-8">
    <title>Login</title>

    <style>
        .col-centered{
            float: none;
            margin: 0 auto;
        }
    </style>
</head>
<body style="background-color: #4b5257">
<div class="container">
    <div class="col-xs-12 col-sm-8 col-md-4 col-lg-4 col-centered">
        <div class="jumbotron">
            <h3>Please login</h3>
            <form action="login" method="post">
                <div class="form-group">
                    <input name="email" type="text" class="form-control"   placeholder="Enter email">

                </div>
                <div class="form-group">
                    <input name="pass" type="text"   class="form-control" placeholder="Enter password">

                </div>
                <div class="custom-checkbox">
                    <label><input type="checkbox"> Remember me</label>
                </div>
                <button type="submit" class="btn-primary form-control">Login</button>
            </form>
        </div>
    </div>

</div>
</body>
</html>