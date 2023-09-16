
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form thêm</title>
    <!-- Latest compiled and minified CSS -->
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
            rel="stylesheet"
    />
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
</head>
<body>
<div class="container">
    <h2 style="text-align: center;margin-top: 20px;">Xem thông tin sinh viên</h2>
    <form action="/nhan_vien/add" method="post">
        <div class="mb-3">
            <label class="form-label">Mã sinh viên:</label>
            <input type="text" class="form-control" name="manv" value="${nv.ma}">
        </div>
        <div class="mb-3">
            <label class="form-label">Tên sinh viên:</label>
            <input type="text" class="form-control" name="ten" value="${nv.ten}">
        </div>
        <label class="form-label">Giới tính:</label>
        <div class="form-check" style="margin-left: 20px;">
            <input
                    class="form-check-input"
                    type="radio"
                    name="gioiTinh"
                    value="true" ${nv.gioiTinh==true?"checked":""}
            />
            <label class="form-check-label">
                Nam
            </label>
        </div>
        <div class="form-check" style="margin-left: 20px;">
            <input
                    class="form-check-input"
                    type="radio"
                    name="gioiTinh"
                    value="false" ${nv.gioiTinh==false?"checked":""}

            />
            <label class="form-check-label" >
                Nữ
            </label>
        </div>
        <div class="mb-3">
            <label class="form-label">Tuối:</label>
            <input type="text" class="form-control" name="tuoi" value="${nv.tuoi}">
        </div>
        <div class="mb-3">
            <label class="form-label">Địa chỉ:</label>
            <input type="text" class="form-control" name="diaChi" value="${nv.diaChi}">
        </div>
    </form>
</div>

</body>
</html>
