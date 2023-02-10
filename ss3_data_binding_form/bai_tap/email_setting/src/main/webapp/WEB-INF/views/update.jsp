<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/6/2023
  Time: 7:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cài đặt thư điện tử</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <h1>Settings</h1>
    <form:form modelAttribute="setting" action="/update" method="post">
        <div class="mb-3 row">
            <label for="language" class="col-sm-2 col-form-label">Language</label>
            <div class="col-sm-6">
                <form:select path="language" class="form-select form-select-sm" id="language">
                    <form:options items="${languages}"></form:options>
                </form:select>
            </div>
        </div>
        <div class="mb-3 row">
            <label for="pageSize" class="col-sm-2 col-form-label">Page Size</label>
            <div class="col-sm-6">
                <p style="display: flex;">
                    <span>Show</span>
                    <form:select path="pageSize" class="form-select form-select-sm"  cssStyle="width: 80px" id="pageSize">
                        <form:options items="${pageSize}"></form:options>
                    </form:select>
                    <span>emails per page</span>
                </p>

            </div>
        </div>
        <div class="mb-3 row">
            <label for="spamsFilter" class="col-sm-2 col-form-label">Spams Filter</label>
            <div class="col-sm-6">
                <form:checkbox path="spamFilter" class="form-check-input" value="true"  id="spamsFilter"></form:checkbox>
                <span>Enable spams Filter</span>
            </div>
        </div>
        <div class="mb-3 row">
            <label for="signature" class="col-sm-2 col-form-label">Signature</label>
            <div class="col-sm-6">
                <form:input path="signature" class="form-control" id="signature"></form:input>
            </div>
        </div>

        <button class="btn btn-primary">Update</button>
    </form:form>
</div>
</body>
</html>
