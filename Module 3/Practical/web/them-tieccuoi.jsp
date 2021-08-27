<%--
  Created by IntelliJ IDEA.
  User: lomahs
  Date: 27/08/2021
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Thêm</title>
    </head>
    <body>
      <form action="${pageContext.request.contextPath}/tieccuoi?action=add" method="post">
        <div>
          <label for="ngayToChuc">Ngày Tổ Chức:</label>
          <input type="date" id="ngayToChuc" name="ngayToChuc">
        </div>
        <div>
          <label for="tenCoDau">Tên Cô Dâu:</label>
          <input type="text" id="tenCoDau" name="tenCoDau">
        </div>
        <div>
          <label for="tenChuRe">Tên Chú Rể:</label>
          <input type="text" id="tenChuRe" name="tenChuRe">
        </div>
        <div>
          <label for="soLuongBan">Số Lượng Bán:</label>
          <input type="text" id="soLuongBan" name="soLuongBan">
        </div>
        <div>
          <label for="donGia">Đơn Giá:</label>
          <input type="text" id="donGia" name="donGia">
        </div>
        <div>
          <label for="dichVuDiKem">Dịch Vụ Đi Kèm:</label>
          <select name="dichVuDiKem" id="dichVuDiKem">
            <option value=""></option>
          </select>
        </div>
        <div>
          <label for="tienNoDatCoc">Tiền Nợ Đặt Cọc</label>
          <input type="text" id="tienNoDatCoc" name="tienNoDatCoc">
        </div>
        <div>
          <label for="tienNoThanhToan">Tiền Nợ Thanh Toán:</label>
          <input type="text" id="tienNoThanhToan" name="tienNoThanhToan">
        </div>
        <div>
          <label for="ngayDatCoc">Ngày Đặt Cọc:</label>
          <input type="date" id="ngayDatCoc" name="ngayDatCoc">
        </div>
        <div>
          <label for="ngayThanhToan">Ngày Thanh Toán:</label>
          <input type="date" id="ngayThanhToan" name="ngayThanhToan">
        </div>
        <div>
          <label for="ghiChu">Ghi Chú:</label>
          <input type="text" id="ghiChu" name="ghiChu">
        </div>
        <div>
          <label for="trangThai">Trạng Thái</label>
          <input type="text" id="trangThai" name="trangThai">
        </div>
        <button type="submit">Add</button>
      </form>
    </body>
</html>
