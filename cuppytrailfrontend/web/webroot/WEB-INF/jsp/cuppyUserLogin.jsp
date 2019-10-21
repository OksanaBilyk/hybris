<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<!doctype html>
<html>
    <title>Login Page</title>
    <body>
        <h3>Login Page</h3>

        <div>
            <c:if test="${toShowError}">
            <p> Please, input correct data! </p>
            </c:if>
        </div>

        <form action="./login" method="post">

            <br>
            <input type="text" name="username" placeholder="UserName" class="input-group-text"><br>
            <input type="password" name="password" placeholder="Password" class="input-group-text">
            <br><br>

            <input type="submit" value="Login">

        </form>

    </body>
</html>