<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Title</title>
        <!-- Required meta tags -->
        <meta charset="utf-8" />
        <meta
                name="viewport"
                content="width=device-width, initial-scale=1, shrink-to-fit=no"
        />

        <!-- Bootstrap CSS -->
        <link
                rel="stylesheet"
                href="${pageContext.request.contextPath}/WEB-INF/lib/bootstrap/css/http_maxcdn.bootstrapcdn.com_bootstrap_4.5.2_css_bootstrap.css"
        />
        <script src="${pageContext.request.contextPath}/WEB-INF/lib/bootstrap/js/http_ajax.googleapis.com_ajax_libs_jquery_3.5.1_jquery.js"></script>
        <script src="${pageContext.request.contextPath}/WEB-INF/lib/bootstrap/js/http_cdnjs.cloudflare.com_ajax_libs_popper.js_1.16.0_umd_popper.js"></script>
        <script src="${pageContext.request.contextPath}/WEB-INF/lib/bootstrap/js/http_maxcdn.bootstrapcdn.com_bootstrap_4.5.2_js_bootstrap.js"></script>
    </head>
    <body>
        <header class="py-3 border-bottom">Home</header>

        <nav class="navbar navbar-expand-sm bg-light navbar-light">
            <div class="container-fluid">
                <button
                        class="navbar-toggler"
                        type="button"
                        data-toggle="collapse"
                        data-target="#toggleMenu"
                >
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div
                        class="collapse navbar-collapse justify-content-between"
                        id="toggleMenu"
                >
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="#">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Employee</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Customer</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Service</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Contract</a>
                        </li>
                    </ul>

                    <form class="d-flex mr-0">
                        <input
                                type="search"
                                class="form-control mr-2"
                                placeholder="Search"
                        />
                        <button class="btn btn-outline-success" type="submit">
                            Search
                        </button>
                    </form>
                </div>
            </div>
        </nav>

        <div class="d-flex" style="height: 90vh">
            <div class="bg-light col-lg-2 col-3 border">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Item One</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Item Two</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Item Three</a>
                    </li>
                </ul>
            </div>
            <div class="bg-light col-lg-10 col-9 border">Body</div>
        </div>

        <footer class="fixed-bottom bg-dark text-light">
            <div class="text-center py-3">Codegym</div>
        </footer>
    </body>
</html>