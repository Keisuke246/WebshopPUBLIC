<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="include/importTags.jsp" %>

	<h1><spring:message code="validateOrder"/></h1>
	
	<div id="produit">
		
		<c:forEach items="${articlesPanier}" var="article">
	  		<div>
	  			<img class='main' src='<spring:url value="/images/categories/${article.key.categorie.id}.png"/>' height="70">
					 
	  			<p>${article.key.prix} XBT</p>
	  			
	  			<p class="qtepanier">
					<span>${article.value} </span>
				</p>
	  			
	  			<h2>${article.key.libelle}</h2>
				
	  		</div>	  		
		</c:forEach>
	</div>
	
	<p><spring:message code="totalPrice"/> : ${coutTotal} XBT</p>
	<c:if test="${articlesPanier.size() != 0}">
		<a id="payer" href="/webshop/panier/commander"><spring:message code="order" /></a>
	</c:if>

