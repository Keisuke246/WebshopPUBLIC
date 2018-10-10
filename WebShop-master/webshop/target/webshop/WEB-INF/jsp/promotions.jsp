<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<link type="text/css" href="<spring:url value='/css/boutique.css' />" rel="Stylesheet">

<div id="center" class="column">
	<h1><spring:message code="promotions"/></h1>
	<table>
		<tr>
			<th><spring:message code="image"/></th><th><spring:message code="name"/></th><th><spring:message code="reduction"/><th><spring:message code="until"/></th>
		</tr>
			<c:forEach items="${promotions}" var="promotion">
		  		<tr>
		  			<td><img src="<spring:url value='/images/promotionRouge.jpg'/>" alt="<spring:message code='imageNotFound'/>" width="70" height="112"/></td>
		  			<td>${promotion.nom}</td>
		  			<td>-${promotion.pourcPromo} %</td>
		  			<td>
		  				<fmt:formatDate value="${promotion.dateFin}" pattern="dd/M/yyyy" />
					</td>
		  		</tr>	  		
			</c:forEach>
	</table>
</div>
