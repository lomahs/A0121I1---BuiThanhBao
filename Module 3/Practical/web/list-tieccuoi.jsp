<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lomahs
  Date: 27/08/2021
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Danh Sach</title>
    </head>
    <body>
        <table>
            <caption>Danh Sách Tiệc Cưới</caption>
            <thead>
            <tr>
                <th>STT</th>
                <th>Ngày tổ chức</th>
                <th>Cô Dâu</th>
                <th>Chú Rể</th>
                <th>Số Lượng Bàn</th>
                <th>Đơn Giá</th>
                <th>Dịch Vụ Đi Kèm</th>
                <th>Tiền Nợ Đặt Cọc</th>
                <th>Tiền Nợ Thanh Toán</th>
                <th>Ngày Đặt Cọc</th>
                <th>Ngày Thanh Toán</th>
                <th>Ghi Chú</th>
                <th>Trạng Thái</th>
                <th colspan="2">Thao tác</th>
            </tr>
            </thead>
            <tbody>
                <c:set var="i" value="1"/>
                <c:forEach var="tiecCuoi" items="${requestScope.danhSachTiec}">
                    <tr>
                        <td>${i = i + 1}</td>
                        <td>${tiecCuoi.ngayToChuc}</td>
                        <td>${tiecCuoi.tenCoDau}</td>
                        <td>${tiecCuoi.tenChuRe}</td>
                        <td>${tiecCuoi.soLuongBan}</td>
                        <td>${tiecCuoi.donGia}</td>
                        <td>${tiecCuoi.dichVuDiKem}</td>
                        <td>${tiecCuoi.tienNoDatCoc}</td>
                        <td>${tiecCuoi.tienNoThanhToan}</td>
                        <td>${tiecCuoi.ngayDatCoc}</td>
                        <td>${tiecCuoi.ngayThanhToan}</td>
                        <td>${tiecCuoi.ghiChu}</td>
                        <td>${tiecCuoi.trangThai}</td>
                        <td>${tiecCuoi.ngayToChuc}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/tieccuoi?action=edit&id=${tiecCuoi.id}">
                                <button type="button">Edit</button>
                            </a>

                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/tieccuoi?action=delete&id=${tiecCuoi.id}">
                                <button type="button">Delete</button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <a href="${pageContext.request.contextPath}/tieccuoi?action=add">
            <button type="button">Thêm tiệc cưới</button></a>
    </body>
</html>
