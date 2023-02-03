<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/1/2023
  Time: 8:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chuyển đổi tiền tệ</title>

</head>
<body>
<h1>Chuyển đổi tiền tệ</h1>
<form class=" g-3" action="/convert" method="post">
    <div >
        <div >
            <label for="usd" class="form-label">Nhập số tiền(USD)</label>
            <input type="text" class="form-control" id="usd" name="usd">
        </div>
    </div>

    <div >
        <div>
            <button type="submit" class="btn btn-primary">Chuyển đổi</button>
        </div>
    </div>

</form>
<h1>${convertCurrency} VNĐ</h1>
</body>
</html>
