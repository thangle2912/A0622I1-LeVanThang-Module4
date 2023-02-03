<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/1/2023
  Time: 9:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Từ điển</title>
</head>
<body>
<h1>Từ điển</h1>
<form class=" g-3" action="/dictionary" method="post">
    <div >
        <div >
            <label for="english" class="form-label">Nhập từ</label>
            <input type="text" class="form-control" id="english" name="english">
        </div>
    </div>

    <div >
        <div>
            <button type="submit" class="btn btn-primary">Dịch</button>
        </div>
    </div>

</form>
    <h1>Kết quả: ${result}</h1>
</body>
</html>
