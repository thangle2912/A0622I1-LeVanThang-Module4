<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/3/2023
  Time: 7:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1> Sandwich Condiments</h1>
    <form action="/sandwich" method="post">
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="condiment1" value="Lettuce" name="condiment">
            <label class="form-check-label" for="condiment1">Lettuce</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="condiment2" value="Tomato" name="condiment">
            <label class="form-check-label" for="condiment2">Tomato</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="condiment3" value="Mustard" name="condiment">
            <label class="form-check-label" for="condiment3">Mustard</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="condiment4" value="Sprouts" name="condiment">
            <label class="form-check-label" for="condiment4">Sprouts</label>
        </div>
        <div>
            <button type="submit" class="btn btn-primary">Save</button>
        </div>
    </form>

    <div>
        <p>Result:
            <c:forEach var="condiment" items="${condiments}" varStatus="status">
                ${condiment}
            </c:forEach>
        </p>

    </div>
</div>

</body>
</html>
