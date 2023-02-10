<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/7/2023
  Time: 5:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách khai báo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <h4>${mess}</h4>
    <button class="btn btn-success" ><a href="/create" style="color: #ffffff; text-decoration: none">Thêm mới</a></button>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">Mã tờ khai</th>
            <th scope="col">Họ tên</th>
            <th scope="col">Năm sinh</th>
            <th scope="col">Giới tính</th>
            <th scope="col">Quốc tịch</th>
            <th scope="col">Hộ chiếu/CMND</th>

        </tr>
        </thead>
        <tbody>

        <c:forEach items="${declarationList}" var="declaration" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${declaration.getId()}</td>
                <td>${declaration.getName()}</td>
                <td>${declaration.getYearOfBirth()}</td>
                <c:choose>
                    <c:when test="${declaration.getGender()==0}">
                        <td>Nữ</td>
                    </c:when>
                    <c:when test="${declaration.getGender()==1}">
                        <td>Nam</td>
                    </c:when>
                    <c:otherwise>
                        <td>Khác</td>
                    </c:otherwise>
                </c:choose>

                <td>${declaration.getNationality()}</td>
                <td>${declaration.getIdCard()}</td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
