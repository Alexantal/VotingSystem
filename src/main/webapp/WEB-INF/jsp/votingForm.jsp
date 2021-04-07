<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<script type="text/javascript">
    function operation(){
        const td11 = document.getElementById('td11');
        td11.innerHTML = "меню ресторана " + event.target.id;
    }
</script>

<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<table id="table1" width="100%" border=0 cellpadding="8" cellspacing="0">
    <tr>
        <td  width="30%" cellpadding="8" cellspacing="0">
            <table id="table2" width="100%" border=0 cellpadding="8" cellspacing="0">
                <c:forEach items="${restaurants}" var="restaurant">
                    <jsp:useBean id="restaurant" type="ru.graduation.topjava.model.Restaurant"/>
                    <tr>
                        <td id = ${restaurant.id} onclick="operation()"><c:out value="${restaurant.name}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </td>
        <td  width="70%" cellpadding="8" cellspacing="0">
            <table id="table3" width="100%" border=0 cellpadding="8" cellspacing="0">
                <tr>
                    <td id="td11" align="center">Выберете ресторан</td>
                </tr>
            </table>
        </td>
    </tr>
</table>


<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
