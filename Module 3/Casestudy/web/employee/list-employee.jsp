<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>List Employee</title>
        <!-- Required meta tags -->
        <meta charset="utf-8"/>
        <meta
                name="viewport"
                content="width=device-width, initial-scale=1, shrink-to-fit=no"
        />

        <link
                rel="stylesheet"
                href="/WEB-INF/lib/bootstrap/css/http_maxcdn.bootstrapcdn.com_bootstrap_4.5.2_css_bootstrap.css"
        />

        <link rel="stylesheet" href="https://cdn.datatables.net/1.11.0/css/dataTables.bootstrap4.min.css">

    </head>
    <body>
        <div class="container py-5">
            <header class="text-center">
                <h1>List Employee</h1>
            </header>
            <div class="row py-5">
                <div class="col mx-auto">
                    <div class="card rounded shadow border-0">
                        <div class="card-body p-4 bg-white rounded">
                            <div class="table-responsive">
                                <table
                                        id="list"
                                        class="table table-bordered table-hover"
                                >
                                    <thead class="text-center">
                                    <th></th>
                                    <th>Username</th>
                                    <th>Name</th>
                                    <th>Birthday</th>
                                    <th>ID Card</th>
                                    <th>Salary</th>
                                    <th>Phone</th>
                                    <th>Email</th>
                                    <th>Address</th>
                                    <th>Education Degree</th>
                                    <th>Division</th>
                                    </thead>
                                    <tbody>
                                    <c:set var="i" value="1"/>
                                    <c:forEach var="employee" items="${requestScope.listEmployee}">
                                        <tr>
                                            <td>${i = i + 1}</td>
                                            <td>${employee.username}</td>
                                            <td>${employee.name}</td>
                                            <td>${employee.birthday}</td>
                                            <td>${employee.idCard}</td>
                                            <td>${employee.salary}</td>
                                            <td>${employee.phone}</td>
                                            <td>${employee.email}</td>
                                            <td>${employee.address}</td>
                                            <td>${employee.edicationDegree}</td>
                                            <td>${employee.idDivision}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="/WEB-INF/lib/bootstrap/js/http_cdnjs.cloudflare.com_ajax_libs_popper.js_1.16.0_umd_popper.js"></script>
        <script src="/WEB-INF/lib/bootstrap/js/http_maxcdn.bootstrapcdn.com_bootstrap_4.5.2_js_bootstrap.js"></script>
        <script src="/WEB-INF/lib/bootstrap/js/http_ajax.googleapis.com_ajax_libs_jquery_3.5.1_jquery.js"></script>

        <script src="//cdn.datatables.net/1.11.0/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.11.0/js/dataTables.bootstrap4.min.js"></script>

        <script>
            $(document).ready(function () {
                $("#list").DataTable();
            });
        </script>
    </body>
</html>