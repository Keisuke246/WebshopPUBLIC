<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="include/importTags.jsp" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<link rel="stylesheet" href="<spring:url value='/css/responsive.css' />">
<script src="<spring:url value='/js/panier.js' />"></script>
<script>
	function ajoutPanier(id){
        var elem = document.getElementById("qtyCart");
        addToCart(id, elem.value, function(){
            var el = document.getElementById("addedToCart");
            el.hidden = false;
        });
	}
</script>



    <div class="product-breadcroumb">
        <a href="/webshop/welcome"><spring:message code="home"/></a> <span>>></span>
        <a href="/webshop/boutique/categorie/${article.categorie.id}">${categories[article.categorie.id-1].libelle}</a> <span>>></span>
        <a href="">${article.libelle }</a>
    </div>             
    <h2 class="produitlibelle">${article.libelle }</h2>
    <img class="imagearticle" style="max-width: 300px;" src='<spring:url value="/images/categories/${article.categorie.id}.png"/>'>
      
              
    <div class="quantity">

        <c:if test="${article.promotionValid}">
            <h3>${article.promotion.nom}</h3>
  			<p>-${article.promotion.pourcPromo} %</p>
  			<p><spring:message code="until" /> <fmt:formatDate value="${article.promotion.dateFin}" pattern="dd/M/yyyy" />!</p>
            <p><s>${article.prixBase}</s> ${article.prix} XBT</p>
        </c:if>
        <c:if test="${!article.promotionValid}">
     	    <p>${article.prix} XBT</p>
        </c:if>
        <input type="number" size="4" class="input-text qty text" id="qtyCart" title="Qty" value="1" name="quantity" min="1" step="1">
       
       	<div id="addedToCart" hidden="true"><spring:message code="addedToCart"/></div>
       	<button class="add_to_cart_button" onclick="ajoutPanier(${article.id})"><spring:message code="addToCart"/></button>
    </div>
    <div class="description">
   		<p><spring:message code="productDescription"/></p>  
   		<p>${article.description}</p>
   	</div>

    	
    	