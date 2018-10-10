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
	<div id="header">																																																																																																																																																																																																				<div class="inner_copy"></div>
		<a href="/webshop/welcome" class="float"><img src='<spring:url value="/images/logo.png"/>' alt="" width="171" height="73" /></a>																																																		
	    <div class="topblock2">
			<spring:message code="language"/>:<br />																															
		    <spring:url var="localeFr" value="">
		    	<spring:param name="locale" value="fr"/>
		    </spring:url>
		    <spring:url var="localeEn" value="">
		    	<spring:param name="locale" value="en"/>
		    </spring:url>
		    <a href="${localeFr}"><img src='<spring:url value="/images/flag2.gif"/>' alt="" width="19" height="11" /></a>
		    <a href="${localeEn}"><img src='<spring:url value="/images/flag4.gif"/>' alt="" width="19" height="11" /></a>
		</div>
		<div class="topblock2">
			<img src='<spring:url value="/images/shopping.gif"/>' alt="" width="24" height="24" class="shopping" />
			 <p><a href='/webshop/panier'><spring:message code="shoppingCart"/></a></p>
			 <c:if test="${nbArticlesTotal !=0}"><p><strong>${nbArticlesTotal}</strong> <span><spring:message code="items"/></span></c:if></p>
		 	<c:if test="${currentUser.inscrit == true && not empty currentUser.prenom}"><spring:message code="welcome"/> ${currentUser.prenom}</c:if>
		</div>
		<ul id="menu">
			<li><img src="<spring:url value="/images/li.gif"/>" alt="" width="19" height="29" /></li>
			<li><a href="/webshop/welcome"><img src='<spring:url value="/images/but1_a.gif"/>' alt="" width="90" height="29" /></a></li>
			<li><a href="/webshop/boutique"><img src='<spring:url value="/images/but2.gif"/>' alt="" width="129" height="29" /></a></li>
			<li><a href="/webshop/promotions"><img src='<spring:url value="/images/but3.gif"/>' alt="" width="127" height="29" /></a></li>
			<li><a href="/webshop/welcome"><img src='<spring:url value="/images/but8.gif"/>' alt="" width="112" height="29" /></a></li>
		</ul>
	</div>
	<div id="container">	
		<div>
			<tiles:insertAttribute name="main-content" />
		</div>																																																																																																																																																																																																																																																																																																																																																																																							
	  <div id="left" class="column">
	  	<div class="block">
		<img src='<spring:url value="/images/title1.gif"/>' alt="" width="168" height="42" /><br />
			<ul id="navigation">
				<c:forEach items="${categories}" var="categorie">
				  		<li><a href ="<spring:url value="/boutique/categorie/${categorie.id}"/>">${categorie.libelle}</a></li>		  		
				</c:forEach>
			</ul>
		</div>
	  </div>
	  <div id="right" class="column">
		<div class="rightblock">
			<img src='<spring:url value="/images/title4.gif"/>' alt="" width="223" height="29" /><br />
			<div class="blocks">
				<img src='<spring:url value="/images/top_bg.gif"/>' alt="" width="218" height="12" />
				<c:if test="${currentUser == null || currentUser.inscrit == false}">
					<a href="<spring:url value='/connexion'/>"><p><spring:message code="login"/> / <spring:message code="register"/></p></a>
				</c:if>
				<c:if test="${currentUser.inscrit == true}">
					<a href="<spring:url value='/commande'/>"><p><spring:message code="allOrders"/></p></a>
					<a href="<spring:url value='/connexion/deconnexion'/>"><p><spring:message code="logout"/></p></a>
				</c:if>
				<img src='<spring:url value="/images/bot_bg.gif"/>' alt="" width="218" height="10" /><br />
			</div>
			<div class="blocks">
				<img src='<spring:url value="/images/top_bg.gif"/>' alt="" width="218" height="12" />
				<div id="news">
					<img src='<spring:url value="/images/title5.gif"/>' alt="" width="201" height="28" />
					<span class="date"><spring:message code="date"/></span>
					<p><spring:message code="news"/></p>
				</div>
				<img src='<spring:url value="/images/bot_bg.gif"/>' alt="" width="218" height="10" /><br />
			</div>
		</div>
	  </div>
	</div>
	
	<div id="footer">																																																																																																																																																																																							<div class="inner_copy"><a href="https://www.entrepreneur.com/article/276921">Entrepreneur.com: website builders for small businesses</a></div>
		<a href="/webshop/welcome"><spring:message code="home"/></a>  |  <a href="/webshop/boutique"><spring:message code="products"/></a>  |  <a href="/webshop/promotions"><spring:message code="promotions"/></a>  |  <a href="/webshop/welcome"><spring:message code="aboutUs"/></a>																																																																																														
	</div>
</body>
</html>