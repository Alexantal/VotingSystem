<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<script type="text/javascript" src="resources/js/common.js" defer></script>
<script type="text/javascript" src="resources/js/dishes.js" defer></script>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron pt-4">
    <div class="container">
        <table id="commonTable" width="100%" border=0 cellpadding="8" cellspacing="0">
            <tr>
                <td  width="20%" cellpadding="8" cellspacing="0">
                    <form id="restForm">
                        <table width="100%" border=0 cellpadding="8" cellspacing="0">
                            <c:forEach items="${restaurants}" var="restaurant">
                                <jsp:useBean id="restaurant" type="ru.graduation.topjava.model.Restaurant"/>
                                <tr>
                                    <td><a class="btn btn-primary" onclick="showMenu(${restaurant.id}, '${restaurant.name}')">${restaurant.name}</a></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </form>
                </td>
                <td  width="70%" cellpadding="8" cellspacing="0">
                    <form id="menu">
                        <table class="table table-striped" id="menuTable" width="70%" border=0 cellpadding="8" cellspacing="0">
                            <thead>
                            <tr>
                                <th id="restaurantName">Text</th>
                            </tr>
                            <tr>
                                <th><spring:message code="dish.name"/></th>
                                <th><spring:message code="dish.price"/></th>
                            </tr>
                            </thead>
                            <tfoot>
                                <tr>
                                    <td class="btn btn-primary" id="votingBtn" width="100px">Vote</td>
                                </tr>
                            </tfoot>
                        </table>
                    </form>
                </td>
            </tr>
        </table>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
