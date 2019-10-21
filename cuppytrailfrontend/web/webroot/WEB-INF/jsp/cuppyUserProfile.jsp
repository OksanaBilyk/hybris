<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<!doctype html>
<html>
<title>Profile Page</title>
<div class="align-content-center">
    <body>
    <h3>Profile Page</h3>

    <h4>Hello, "${userName}"!</h4>
    <p>Special match listing:</p>
    <br>

    <c:choose>
        <c:when test="${fn:length(matches) gt 0}">
            <ul class="list-group">
                <c:forEach var="match" items="${matches}">
                    <li class="list-group-item">
                            ${match.matchSummaryFormatted}
                    </li>
                </c:forEach>
            </ul>
        </c:when>
        <c:otherwise>
            <br>
            Special matches are not found.
            <br>
        </c:otherwise>
    </c:choose>
    <br>
    <a href="./home"><button type="button" class="btn btn-warning">Log out</button></a>
    <br>
    </body>
</div>
</html>