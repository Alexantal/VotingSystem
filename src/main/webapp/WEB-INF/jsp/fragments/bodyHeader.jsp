<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-light bg-white py-0">
    <div class="container">
        <a href="menu" class="navbar-brand"><spring:message code="app.title"/></a>
        <form class="form-inline my-2">
            <sec:authorize access="isAuthenticated()">
                <form class="form-inline my-2">
                    <sec:authorize access="hasRole('ADMIN')">
                        <a class="btn btn-info mr-1" href="admin"><spring:message code="restaurant.title"/></a>
                    </sec:authorize>
                    <a class="btn btn-primary my-1" href="logout">
                        <span class="fa fa-sign-out"></span>
                    </a>
                </form>
            </sec:authorize>
        </form>
    </div>
</nav>
