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
<div id="center" class="column">
	<h1><spring:message code="allProducts"/></h1>
	<table>
		<tr>
			<th>#</th><th><spring:message code="name"/></th><th><spring:message code="unitPrice" /></th><th><spring:message code="cartQuantity"/></th>
		</tr>
			<c:forEach items="${articlesPanier}" var="article">
		  		<tr>
		  			<td>${article.key.id}</td>
		  			<td>${article.key.libelle}</td>
		  			<td>${article.key.prix}</td>
					<td><a href="#" onclick="plusArticle(${article.key.id}, ${article.value})" >+</a>
					 ${article.value} 
					 <a href="#" onclick="moinsArticle(${article.key.id}, ${article.value})" >-</a>
					 <a href="#" onclick="deleteFromCart(${article.key.id}); location.reload();" >X</a></td>
		  		</tr>
			</c:forEach>
	</table>
	<p><spring:message code="totalPrice"/> : ${coutTotal}</p>
	<a href="/webshop/panier/commander"><spring:message code="order" /></a>
</div>
