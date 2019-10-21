<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<!doctype html>
<html>
    <title>Registration Page</title>
    <body>
        <h1>Registration Page</h1>

        <div>
            <c:if test="${toShowError}">
                <p> Please, input correct data! </p>
            </c:if>
        </div>

        <form action="./registration" method="post">

            <br>
            <input type="text" name="name" placeholder="Name" class="input-group-text">
            <br>
            <input type="text" name="username" placeholder="UserName" class="input-group-text">
            <br>
            <input type="text" name="login" placeholder="Login" class="input-group-text">
            <br>
            <input type="text" name="phone" placeholder="Phone" class="input-group-text">
            <br>
            <input type="password" name="password" placeholder="Password" class="input-group-text">
            <br>
            <input type="submit" value="Submit">
            <br>

        </form>

    </body>
</html>