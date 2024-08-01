<%--
  Created by IntelliJ IDEA.
  User: G201
  Date: 2024-07-31
  Time: 오후 3:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
  <div class="row">
    <div class="col">
      <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
          <a class="navbar-brand" href="#">Navbar</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Features</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Pricing</a>
              </li>
              <li class="nav-item">
                <a class="nav-link disabled" aria-disabled="true">Disabled</a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </div>

    <div class="row content">
      <div class="col">
        <div class="card">
          <div class="card-header">
            Featured
          </div>
          <div class="card-body">
            <form action="/todo/modify" method="post">
              <div class="input-group mb-3">
                <span class="input-group-text">Tno</span>
                <input type="text" name="tno" class="form-control" value="${dto.tno}" readonly>
              </div>
              <div class="input-group mb-3">
                <span class="input-group-text">Title</span>
                <input type="text" name="title" class="form-control" value="${dto.title}">
              </div>
              <div class="input-group mb-3">
                <span class="input-group-text">DueDate</span>
                <input type="date" name="dueDate" class="form-control" value="${dto.dueDate}">
              </div>
              <div class="input-group mb-3">
                <span class="input-group-text">Writer</span>
                <input type="text" name="writer" class="form-control" value="${dto.writer}" readonly>
              </div>

              <div class="form-check">
                <label for="finished" class="form-check-label">
                  Finished
                </label>
                <input type="checkbox" name="finished" id="finished" class="form-check-input" ${dto.finished ? "checked" : ""}>
              </div>

              <div class="my-4">
                <div class="float-end">
                  <button type="button" class="btn btn-danger">Remove</button>
                  <button type="button" class="btn btn-primary">Modify</button>
                  <button type="button" class="btn btn-secondary">List</button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="row footer">
    <div class="row fixed-bottom" style="z-index: -100">
      <footer class="py-1 my-1">
        <p class="text-center text-muted">Footer</p>
      </footer>
    </div>
  </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

<script>
    const serverValidResult = {};

    <c:forEach items="${errors}" var="error">
      serverValidResult['${error.getField()}'] = '${error.defaultMessage}';
    </c:forEach>

    console.log(serverValidResult);

    const formObj = document.querySelector("form");

    document.querySelector(".btn-danger").addEventListener("click", function (e) {
        e.preventDefault();
        e.stopPropagation();

        formObj.action = "/todo/remove";
        formObj.method = "post";

        formObj.submit();
    });

    document.querySelector(".btn-primary").addEventListener("click", function (e) {
        e.preventDefault();
        e.stopPropagation();

        formObj.action = "/todo/modify";
        formObj.method = "post";

        formObj.submit();
    });

    document.querySelector(".btn-secondary").addEventListener("click", function (e) {
        // self.location = "/todo/list";
        location.href = "/todo/list";
    });
</script>
</body>
</html>
