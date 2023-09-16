
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Boostrap CRUD</title>
    <!-- Latest compiled and minified CSS -->
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
            rel="stylesheet"
    />

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container mt-3">
    <h2>Danh sách nhân viên</h2>
    <a href="/nhan_vien/view_add" class="btn btn-success">Add</a>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Mã nhân viên</th>
            <th>Tên nhân viên</th>
            <th>Giới tính</th>
            <th>Tuổi</th>
            <th>Địa chỉ</th>
            <th>Action</th>
        </tr>
        </thead>
        <c:forEach items="${nhanvien}" var="nv">
            <tbody>
            <tr>
                <td>${nv.ma}</td>
                <td>${nv.ten}</td>
                <td>${nv.gioiTinh=="true"?"Nam":"Nữ"}</td>
                <td>${nv.tuoi}</td>
                <td>${nv.diaChi}</td>
                <td>
                    <a href="/nhan_vien/details?manv=${nv.ma}" class="btn btn-primary">Details</a>
                    <a href="/nhan_vien/view-update?manv=${nv.ma}" class="btn btn-danger">Update</a>
                    <a href="/nhan_vien/delete?manv=${nv.ma}" class="btn btn-warning">Delete</a>
                </td>
            </tr>
            </tbody>
        </c:forEach>

    </table>
</div>
</body>
</html>

