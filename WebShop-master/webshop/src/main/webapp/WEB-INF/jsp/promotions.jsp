<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<link type="text/css" href="<spring:url value='/css/boutique.css' />" rel="Stylesheet">

	<div id="promos">
		<c:forEach items="${promotions}" var="promotion">
			<div onclick="location.replace('<spring:url value='/promotions/${promotion.id}' />')">
  				<h2>${promotion.nom}</h2>
  				<p>-${promotion.pourcPromo} %</p>
  				<p><spring:message code="until" /> <fmt:formatDate value="${promotion.dateFin}" pattern="dd/M/yyyy" />!</p>
  			</div>
		</c:forEach>
	</div>

