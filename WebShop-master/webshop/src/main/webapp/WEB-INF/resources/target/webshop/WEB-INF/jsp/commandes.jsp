<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="include/importTags.jsp" %>
<link type="text/css" href="<spring:url value='/css/inscription.css' />" rel="Stylesheet">

<div id="center" class="column">
	<h1><spring:message code="allOrders"/></h1>
    <c:forEach items="${currentOrders}" var="order">
        ${order.numero} ${order.date} ${order.etat}
        <table>
		<tr>
			<th>#</th><th><spring:message code="name"/></th><th><spring:message code="unitPrice" /></th><th><spring:message code="cartQuantity"/></th>
		</tr>
			<c:forEach items="${order.lignes}" var="ligne">
		  		<tr>
		  			<td>${ligne.numero}</td>
		  			<td>${ligne.article.libelle}</td>
		  			<td>${ligne.prixArticle}</td>
					<td>${ligne.quantite} </td>
		  		</tr>
			</c:forEach>
	</table>
    </c:forEach>
</div>
