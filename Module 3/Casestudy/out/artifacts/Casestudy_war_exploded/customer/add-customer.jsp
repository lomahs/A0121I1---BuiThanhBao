<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Add Customer</title>
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
                    <h2 class="text-primary">Add New Customer</h2>
                </div>
                <form action="${pageContext.request.contextPath}/customer?action=create" method="post">
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input
                                type="text"
                                class="form-control"
                                id="name"
                                name="name"
                                placeholder="Enter name"
                                required
                        />
                    </div>
                    <div class="form-group">
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="gender" id="male" value="${true}">
                            <label class="form-check-label" for="male">Male</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="gender" id="female" value="${false}">
                            <label class="form-check-label" for="female">Female</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="birthday">Birthday</label>
                        <input
                                class="form-control"
                                type="date"
                                id="birthday"
                                name="birthday"
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
                        />
                    </div>
                    <div class="form-group">
                        <label for="type">Type</label>
                        <select class="custom-select" id="type" name="type">
                            <optgroup label="Select Type">
                                <option value="1" selected>Member</option>
                                <option value="2">Silver</option>
                                <option value="3">Gold</option>
                                <option value="4">Platinum</option>
                                <option value="5">Diamond</option>
                            </optgroup>
                        </select>
                    </div>
                    <div class="form-group">
                        <button class="btn btn-primary" type="submit">
                            Save
                        </button>
                    </div>
                </form>
                <a href="${pageContext.request.contextPath}/customer">
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
