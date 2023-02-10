<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/6/2023
  Time: 8:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cài đặt hiện tại</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <h4>${mess}</h4>
    <button class="btn btn-success"><a href="/update">Update</a></button>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Language</th>
            <th scope="col">Page size</th>
            <th scope="col">Spams filter</th>
            <th scope="col">Signature</th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td>${setting.getLanguage()}</td>
                <td>${setting.pageSize}</td>

                <c:if test="${setting.isSpamFilter()}">
                    <td> Enable</td>
                </c:if>
                <c:if test="${!setting.isSpamFilter()}">
                    <td> Disable</td>
                </c:if>

                <td>${setting.getSignature()}</td>

            </tr>

        </tbody>
    </table>
</div>

</body>
</html>
