<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Edit Employee</title>
        <!-- Required meta tags -->
        <meta charset="utf-8"/>
        <meta
                name="viewport"
                content="width=device-width, initial-scale=1, shrink-to-fit=no"
        />

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
              integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
              crossorigin="anonymous">
    </head>
    <body>
        <jsp:include page="../navbar.jsp"/>

        <div class="bg-light border">
            <div class="container p-5">
                <div class="text-center">
                    <h2 class="text-primary">Edit Employee Information</h2>
                </div>
                <c:set var="employee" value="${requestScope.employee}"/>
                <span class="font-italic bg-success">${requestScope.message}</span>
                <form action="${pageContext.request.contextPath}/employee?action=edit" method="post">
                    <div class="form-group">
                        <input type="hidden" name="id" value="${employee.id}">
                        <label for="name">Name</label>
                        <input
                                type="text"
                                class="form-control"
                                id="name"
                                name="name"
                                placeholder="Enter name"
                                required
                                value="${employee.name}"
                        />
                    </div>
                    <div class="form-group">
                        <label for="birthday">Birthday</label>
                        <input
                                class="form-control"
                                type="date"
                                id="birthday"
                                name="birthday"
                                value="${employee.birthdayForInput}"
                        />
                    </div>
                    <div class="form-group">
                        <label for="idCard">ID Card</label>
                        <input
                                type="text"
                                class="form-control"
                                id="idCard"
                                required
                                name="idCard"
                                placeholder="Enter ID Card"
                                value="${employee.idCard}"
                        />
                    </div>
                    <div class="form-group">
                        <label for="salary">Salary</label
                        ><input
                            type="text"
                            class="form-control"
                            id="salary"
                            name="salary"
                            placeholder="Enter Salary"
                            required
                            value="${employee.salary}"
                    />
                    </div>
                    <div class="form-group">
                        <label for="phone">Phone</label>
                        <input
                                type="tel"
                                class="form-control"
                                id="phone"
                                name="phone"
                                placeholder="0123-456-789"
                                pattern="[0-9]{4}-[0-9]{3}-[0-9]{3}"
                                required
                                value="${employee.phone}"
                        />
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input
                                type="email"
                                class="form-control"
                                id="email"
                                name="email"
                                placeholder="abc@mail.com"
                                required
                                value="${employee.email}"
                        />
                    </div>
                    <div class="form-group">
                        <label for="address">Address</label>
                        <input
                                type="text"
                                class="form-control"
                                id="address"
                                name="address"
                                placeholder="Enter Address"
                                value="${employee.address}"
                        />
                    </div>
                    <div class="form-group">
                        <label for="position">Position</label>
                        <select class="custom-select" id="position" name="position">
                            <optgroup label="Choose Position">
                                <option value="1" ${(employee.position.id == 1)?"selected":''}>Receptionist</option>
                                <option value="2" ${(employee.position.id == 2)?"selected":''}>Serve</option>
                                <option value="3" ${(employee.position.id == 3)?"selected":''}>Specialist</option>
                                <option value="4" ${(employee.position.id == 4)?"selected":''}>Supervisor</option>
                                <option value="5" ${(employee.position.id == 5)?"selected":''}>Manager</option>
                                <option value="6" ${(employee.position.id == 6)?"selected":''}>Director</option>
                            </optgroup>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="educationDegree">Education Degree</label>
                        <select
                                class="custom-select"
                                id="educationDegree"
                                name="educationDegree"
                        >
                            <optgroup label="Select Education Degree">
                                <option value="1" ${(employee.educationDegree.id == 1)?"selected":''}>Intermediate
                                </option>
                                <option value="2" ${(employee.educationDegree.id == 2)?"selected":''}>Colleges</option>
                                <option value="3" ${(employee.educationDegree.id == 3)?"selected":''}>University
                                </option>
                                <option value="4" ${(employee.educationDegree.id == 4)?"selected":''}>Graduated</option>
                            </optgroup>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="division">Division</label>
                        <select class="custom-select" id="division" name="division">
                            <optgroup label="Select Division">
                                <option value="1" ${(employee.division.id == 1)?"selected":''}>Sale - Marketing</option>
                                <option value="2" ${(employee.division.id == 2)?"selected":''}>Administrative</option>
                                <option value="3" ${(employee.division.id == 3)?"selected":''}>Service</option>
                                <option value="4" ${(employee.division.id == 4)?"selected":''}>Management</option>
                            </optgroup>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input
                                type="text"
                                class="form-control"
                                id="username"
                                name="username"
                                placeholder="Enter Username"
                                value="${employee.user.username}"
                        />
                    </div>
                    <div class="form-group">
                        <button class="btn btn-primary" type="submit">
                            Edit
                        </button>
                    </div>
                </form>
                <a href="${pageContext.request.contextPath}/employee">
                    <button class="btn btn-secondary">Back</button>
                </a>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
                integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
                crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
                crossorigin="anonymous"></script>
    </body>
</html>
