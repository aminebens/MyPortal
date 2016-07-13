<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>

<nav class="col-md-2 sidemenu">
    <ul>
        <c:forEach var="item" items="${sidemenu}">
            <li class="withripple ${requestScope['javax.servlet.forward.servlet_path'] == item.value ? 'active' : 'none'}">
                <a href="<c:url value='${item.value}'/>">${item.key}</a>
                <div class="ripple-container"></div>
            </li>
        </c:forEach>
    </ul>
</nav>

