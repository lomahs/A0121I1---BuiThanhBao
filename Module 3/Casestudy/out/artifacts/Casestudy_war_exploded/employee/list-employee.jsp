<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>List Employee</title>
        <!-- Required meta tags -->
        <meta charset="utf-8"/>
        <meta
                name="viewport"
                content="width=device-width, initial-scale=1, shrink-to-fit=no"/>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
              integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
              crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.11.1/css/dataTables.bootstrap4.min.css">

    </head>
    <body>
        <jsp:include page="../navbar.jsp"/>

        <div class="container-fluid py-5">
            <nav>
                <a href="${pageContext.request.contextPath}/employee?action=create">
                    <button class="btn btn-success">Add New Employee</button>
                </a>
            </nav>
            <header class="text-center">
                <h2 class="text-primary">List Employee</h2>
            </header>
            <div class="row py-5">
                <div class="col mx-auto">
                    <div class="card rounded shadow border-0">
                        <div class="card-body p-4 bg-white rounded">
                            <span class="font-italic bg-success">${requestScope.message}</span>
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
                                    <th>Position</th>
                                    <th>Education Degree</th>
                                    <th>Division</th>
                                    <th colspan="2">Operation</th>
                                    </thead>
                                    <tbody>
                                    <c:set var="i" value="0"/>
                                    <c:forEach var="employee" items="${requestScope.listEmployee}">
                                        <tr class="${(employee.id == requestScope.newEmployeeId) ? 'table-success':''}">
                                            <td>${i = i + 1}</td>
                                            <td>${employee.user.username}</td>
                                            <td>${employee.name}</td>
                                            <td>${employee.birthday}</td>
                                            <td>${employee.idCard}</td>
                                            <td>${employee.salary}</td>
                                            <td>${employee.phone}</td>
                                            <td>${employee.email}</td>
                                            <td>${employee.address}</td>
                                            <td>${employee.position.name}</td>
                                            <td>${employee.educationDegree.name}</td>
                                            <td>${employee.division.name}</td>
                                            <td>
                                                <form action="${pageContext.request.contextPath}/employee"
                                                      method="post">
                                                    <input type="hidden" name="action" value="showEditForm">
                                                    <input type="hidden" name="id" value="${employee.id}">
                                                    <button type="submit" class="btn btn-primary">Edit</button>
                                                </form>
                                            </td>
                                            <td>
                                                <form action="${pageContext.request.contextPath}/employee"
                                                      method="post">
                                                    <input type="hidden" name="action" value="delete">
                                                    <input type="hidden" name="id" value="${employee.id}">
                                                    <button type="submit" class="btn btn-secondary" data-toggle="modal"
                                                            data-target="#staticBackdrop">Remove
                                                    </button>
                                                </form>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>

                                    <!-- Modal -->
                                    <div class="modal fade" id="staticBackdrop" data-backdrop="static"
                                         data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel"
                                         aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="staticBackdropLabel">Confirm Delete
                                                        Employee?</h5>
                                                    <button type="button" class="close" data-dismiss="modal"
                                                            aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>
                                                <div class="modal-body">
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary"
                                                            data-dismiss="modal">Back
                                                    </button>
                                                    <button type="button" class="btn btn-primary">Delete</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
                integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
                crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
                crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.11.1/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.11.1/js/dataTables.bootstrap4.min.js"></script>

        <script>
            $(document).ready(function () {
                $('#list').DataTable();
            });
        </script>
    </body>
</html>
