<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="include/importTags.jsp" %>
<link type="text/css" href="<spring:url value='/css/inscription.css' />" rel="Stylesheet">
 <script src="<spring:url value='/js/panier.js' />"></script> 
<script>
	function plusArticle(id, qty){
		updateCart(id, qty+1, function(){location.reload();});
	}
	function moinsArticle(id, qty){
		if(qty <= 1)
			return;
		updateCart(id, qty-1, function(){location.reload();});
	}
</script>
	<h1><spring:message code="allProducts"/></h1>
	
	<div id="produit">
		
		<c:forEach items="${articlesPanier}" var="article">
	  		<div>
	  			<img class='main' src='<spring:url value="/images/categories/${article.key.categorie.id}.png"/>' height="70">
					 
	  			<p>${article.key.prix} XBT</p>
	  			
	  			<p class="qtepanier">
					<a href="#" onclick="plusArticle(${article.key.id}, ${article.value})" ><img src='<spring:url value="/images/plus.png"/>' width="20" /></a>
					<span>${article.value} </span>
					<a href="#" onclick="moinsArticle(${article.key.id}, ${article.value})" ><img src='<spring:url value="/images/moins.png"/>' width="20" /></a>
					<a href="#" onclick="deleteFromCart(${article.key.id}); location.reload();" ><img src='<spring:url value="/images/bin.png"/>' width="20" /></a>
				</p>
	  			
	  			<h2>${article.key.libelle}</h2>
				
	  		</div>	  		
		</c:forEach>
	</div>
	
	<p><spring:message code="totalPrice"/> : ${coutTotal} XBT</p>
	<c:if test="${articlesPanier.size() != 0}">
		<a id="payer" href="/webshop/panier/valider"><spring:message code="order" /></a>
	</c:if>
