<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
    <head>
        <title>Create Product</title>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Bootstrap CSS -->
        <link
                rel="stylesheet"
                href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
                integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
                crossorigin="anonymous"
        />
    </head>
    <body>
        <nav class="navbar navbar-light bg-light justify-content-between">
            <a class="navbar-brand">Create Product</a>
        </nav>
        <div class="container">
            <form
                    action="${pageContext.request.contextPath}/productAction?action=create"
                    method="post"
            >
                <div class="form-group">
                    <label for="name" class="form-label">Name Product</label>
                    <input type="text" name="name" id="name" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="price" class="form-label">Price</label>
                    <input type="text" name="price" id="price" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="description" class="form-label">Description</label>
                    <input
                            type="text"
                            id="description"
                            name="description"
                            class="form-control"
                    />
                </div>
                <div class="form-group">
                    <label for="manufacturer" class="form-label">Manufacturer</label>
                    <input
                            type="text"
                            id="manufacturer"
                            name="manufacturer"
                            class="form-control"
                    />
                </div>
                <a href="${pageContext.request.contextPath}/productAction">
                    <button type="button" class="btn btn-secondary">Back</button>
                </a>
                <button type="submit" class="btn btn-primary">Create</button>
            </form>
        </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script
                src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
                crossorigin="anonymous"
        ></script>
        <script
                src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
                crossorigin="anonymous"
        ></script>
        <script
                src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
                crossorigin="anonymous"
        ></script>
    </body>
</html>