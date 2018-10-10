<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/importTags.jsp" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
    
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Partycamp</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="<spring:url value='/css/style.css' />" rel="Stylesheet">
</head>

<body>
	<header>																																																																																																																																																																																																				<div class="inner_copy"></div>
		<a href="/webshop/welcome"><img src='<spring:url value="/images/logo.png"/>' alt="" width="200" /></a>																																																		
	    
	    <div>
	    	<p>
				<c:choose>
					<c:when test="${currentUser.inscrit == true && not empty currentUser.prenom}">
						<span class="userco">
							<a href="<spring:url value='/commande'/>"><spring:message code="allOrders"/></a>
							<a href="<spring:url value='/connexion/deconnexion'/>"><spring:message code="logout"/></a>
						</span>
					</c:when>
					<c:otherwise>
						<a class="login" href="<spring:url value='/connexion'/>">
							<spring:message code="login"/> | <spring:message code="register"/>
						</a>
					</c:otherwise>				
				</c:choose>
			</p>
			<ul>
				<li>
					<img src='<spring:url value="/images/shop.png"/>' alt="cart" width="40" class="shopping" />
					<a href='/webshop/panier'><spring:message code="shoppingCart"/></a>
				</li>
				<li>
					<c:choose>
						<c:when test="${nbArticlesTotal != 0}"><strong>${nbArticlesTotal}</strong> </c:when>
						<c:otherwise><strong><spring:message code="none" /></strong> </c:otherwise>
					</c:choose>
					<span><spring:message code="items"/></span>
				</li>
			</ul>
			
		</div>
	    <div>
	    	<spring:url var="localeEn" value="">
		    	<spring:param name="locale" value="en"/>
		    </spring:url>																															
		    <spring:url var="localeFr" value="">
		    	<spring:param name="locale" value="fr"/>
		    </spring:url>
		    
		    <a href="${localeEn}"><img src='<spring:url value="/images/uk.png"/>' alt="english" width="35" /></a>
		    <a href="${localeFr}"><img src='<spring:url value="/images/french.png"/>' alt="french" width="35" /></a>
		    
		    <c:if test="${currentUser.inscrit == true && not empty currentUser.prenom}">
		   		<span><spring:message code="welcome"/> ${currentUser.prenom}</span>
		   	</c:if>
		   
		</div>
		
	</header>
	
	<ul id="menu">
			<li><a <c:if test="${currentPage == 'welcome'}">class="active"</c:if> href="/webshop/welcome"><spring:message code="home"/></a></li>
			<li><a <c:if test="${currentPage == 'boutique'}">class="active"</c:if> href="/webshop/boutique"><spring:message code="products"/></a></li>
			<li id="submenu"><a <c:if test="${currentPage == 'categorie'}">class="active"</c:if> href="#"><spring:message code="categories"/></a>
				<ul id="navigation" <c:if test="${currentPage == 'categorie'}">class="active"</c:if>>
				<div>
					<c:forEach items="${categories}" var="categorie">
					  		<li><a <c:if test="${categorie.id == idcategorie}">class="active"</c:if> href ="<spring:url value="/boutique/categorie/${categorie.id}"/>">${categorie.libelle}</a></li>		  		
					</c:forEach>
				</div>
				</ul>
			</li>
			<li><a <c:if test="${currentPage == 'promotions'}">class="active"</c:if> href="/webshop/promotions"><spring:message code="specialOffers"/></a></li>
			<li><a <c:if test="${currentPage == 'contact'}">class="active"</c:if> href="/webshop/welcome/contact"><spring:message code="contactUs"/></a></li>
		</ul>
	<div id="container">	
		<div>
			<tiles:insertAttribute name="main-content" />
		</div>																																																																																																																																																																																																																																																																																																																																																																																							
	  
	</div>
	
	<footer>
		<ul>
			
			<li><a href="/webshop/welcome"><spring:message code="home"/></a></li>
			<li><a href="/webshop/welcome/contact"><spring:message code="aboutUs"/></a></li>	
			<li id="u"><spring:message code="rights"/></li>
		</ul>
	</footer>
</body>
</html>