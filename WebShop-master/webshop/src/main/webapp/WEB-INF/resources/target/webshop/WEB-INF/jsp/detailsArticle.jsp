<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="include/importTags.jsp" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<link rel="stylesheet" href="<spring:url value='/css/styleProduct.css' />">
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
<div id="center" class="column">
    <div class="product-breadcroumb">
        <a href="/webshop/welcome"><spring:message code="home"/></a>
        <a href="/webshop/boutique/categorie/${article.categorie.id}">${article.categorie.libelle}</a>
        <a href="">${article.libelle }</a>
    </div>             
    <h2 class="product-name">${article.libelle }</h2>
        <p>${article.prix} &euro;</p>             
        <div class="quantity">
            <input type="number" size="4" class="input-text qty text" id="qtyCart" title="Qty" value="1" name="quantity" min="1" step="1">
        </div>
        <div id="addedToCart" hidden="true"><spring:message code="addedToCart"/></div>
        <button class="add_to_cart_button" onclick="ajoutPanier(${article.id})"><spring:message code="addToCart"/></button>
    <h2><spring:message code="productDescription"/></h2>  
    	<p>${article.description}</p>
</div>