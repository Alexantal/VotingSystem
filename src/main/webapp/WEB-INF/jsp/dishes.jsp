<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<section>
    <h3><spring:message code="dish.title"/></h3>

    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
            <tr>
                <th><spring:message code="dish.restaurant"/></th>
                <th><spring:message code="dish.name"/></th>
                <th><spring:message code="dish.price"/></th>
                <th><spring:message code="dish.date"/></th>
                <th><spring:message code="dish.vote"/></th>
            </tr>
        </thead>
        <c:forEach items="${dishes}" var="dish">
            <jsp:useBean id="dish" scope="page" type="ru.graduation.topjava.model.Dish"/>
            <tr>
                <td><c:out value="${dish.restaurant.name}"/></td>
                <td><c:out value="${dish.name}"/></td>
                <td><c:out value="${dish.price}"/></td>
                <td><fmt:formatDate value="${dish.date}" pattern="dd-MM-yyyy"/></td>
                <td></td>
            </tr>
        </c:forEach>
    </table>
</section>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
