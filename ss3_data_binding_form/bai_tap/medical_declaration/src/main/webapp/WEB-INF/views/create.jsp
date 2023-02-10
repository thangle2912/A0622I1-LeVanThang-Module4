<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/7/2023
  Time: 5:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Tờ khai y tế</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        .required {
            color: red;
        }
    </style>
</head>
<body>
<div class="container">
    <div style="text-align: center">
        <h3>TỜ KHAI Y TẾ</h3>
        <h5>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG
            DỊCH BỆNH TRUYỀN NHIỄM</h5>
        <h7 style="color: red">Khuyến cáo : Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình
            sự
        </h7>
    </div>
    <form:form modelAttribute="declaration" action="/create" method="post">
        <div class="row">
            <div class="mb-3">
                <label for="name" class="form-label">Họ tên(ghi chữ IN HOA)<i class="required">(*)</i></label>
                <form:input path="id"  class="form-control" id="name" name="name"></form:input>
            </div>
        </div>
        <div class="row">
            <div class="mb-3">
                <label for="name" class="form-label">Họ tên(ghi chữ IN HOA)<i class="required">(*)</i></label>
                <form:input path="name"  class="form-control" id="name" name="name"></form:input>
            </div>
        </div>
        <div class="row">
            <div class="col-4">
                <div class="mb-3">
                    <label for="yearOfBirth" class="form-label">Năm sinh<i class="required">(*)</i></label>
                    <form:select path="yearOfBirth" class="form-select form-select-sm form-control"
                                 id="yearOfBirth">
                        <form:options items="${yeahOfBirth}"></form:options>
                    </form:select>
                </div>
            </div>
            <div class="col-4">
                <div class="mb-3">
                    <label for="gender" class="form-label">Giới tính<i class="required">(*)</i></label>
                    <form:select path="gender" class="form-select form-select-sm form-control"  id="gender">
                        <form:option value="0">Nữ</form:option>
                        <form:option value="1">Nam</form:option>
                        <form:option value="2">Khác</form:option>
                    </form:select>
                </div>
            </div>
            <div class="col-4">
                <div class="mb-3">
                    <label for="nationality" class="form-label">Giới tính<i class="required">(*)</i></label>
                    <form:select path="nationality" class="form-select form-select-sm form-control"  id="gender">
                        <form:options items="${nationality}"></form:options>
                    </form:select>                </div>

            </div>
        </div>
        <div class="row">
            <div class="mb-3">
                <label for="idCard" class="form-label">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác<i
                        class="required">(*)</i></label>
                <form:input path="idCard" class="form-control" id="idCard" name="idCard" ></form:input>
            </div>
        </div>
        <button class="btn btn-success" style="color: aliceblue">Gửi tờ khai</button>
    </form:form>
</div>

</body>
</html>
