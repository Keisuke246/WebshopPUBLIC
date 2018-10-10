<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="include/importTags.jsp" %>
<link type="text/css" href="<spring:url value='/css/inscription.css' />" rel="Stylesheet">

	<h1><spring:message code="allOrders"/></h1>
	
	
    <c:if test="${order.etat == 'attente'}" >
        <a href="<spring:url value='/commande/payer/${order.numero}' />"><spring:message code="payOrder" /></a>
    </c:if>
        ${order.numero} ${order.date} ${order.etat}
        

	
	
	<div id="produit">
		
		<c:forEach items="${order.lignes}" var="ligne">
	  		<div>
	  			<img class='main' src='<spring:url value="/images/categories/${ligne.article.categorie.id}.png"/>' height="70">
				<p>${ligne.prixArticle} XBT</p>		
	  			
	  			<h2><a href="<spring:url value='/boutique/${ligne.article.id}' />">${ligne.article.libelle}</a></h2>
	  			
	  			<p>${ligne.quantite} <spring:message code="ordered"/></p>
				
	  		</div>	  		
		</c:forEach>
	</div>
	
	
	<p>${order.prixTotal} XBT</p>
	
	
