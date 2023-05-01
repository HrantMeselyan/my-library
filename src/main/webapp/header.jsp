<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg">
        <a href="/" class="logo-link">
            <img src="../../img/logo3.png" alt="" class="logo">
            <h1 class="logo-h1">ITSpace</h1>
        </a>
        <% if (session.getAttribute("user") != null) { %>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <div class="navbar-nav">
                <a class="nav-item nav-link " href="/home">Home</a>
                <a class="nav-item nav-link" href="/authors">Authors</a>
                <a class="nav-item nav-link" href="/books">Books</a>
            </div>
            <div class="logout">
                <a class="form-inline my-2 my-lg-0" href="/logout"> <img src="../../img/logout.png" class="logout"></a>
            </div>
        </div>
        <%}%>
    </nav>
</header>