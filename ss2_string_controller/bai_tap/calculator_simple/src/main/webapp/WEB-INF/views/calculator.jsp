<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/3/2023
  Time: 8:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Máy tính đơn giản</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <form class="row g-3" method="post" action="/calculator">

        <div class="col-md-3">
            <label for="number1" class="form-label" >First operand</label>
            <input type="number" class="form-control" id="number1" name="number1" value="${number1}">
        </div>
        <div class="col-md-3">
            <label for="number2" class="form-label">Second operand</label>
            <input type="number" class="form-control" id="number2" name="number2" value="${number2}">
        </div>
        <div class="col-12">
            <h3>${result}</h3>
        </div>
        <div class="col-12">
            <button type="submit" class="btn btn-primary" name="operator" value="+">Addition</button>
        </div>
        <div class="col-12">
            <button type="submit" class="btn btn-primary" name="operator" value="-">Subtraction</button>
        </div>
        <div class="col-12">
            <button type="submit" class="btn btn-primary" name="operator" value="*">Multiplication</button>
        </div>
        <div class="col-12">
            <button type="submit" class="btn btn-primary" name="operator" value="/">Division</button>
        </div>
    </form>
</div>

</body>
</html>
