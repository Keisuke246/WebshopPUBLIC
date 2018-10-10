<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="include/importTags.jsp" %>
<link type="text/css" href="<spring:url value='/css/inscription.css' />" rel="Stylesheet">

<div id="center" class="column">
	<h1><spring:message code="payOrderBitcoin" arguments="${order.prixTotal}" /></h1>
    <h2>${order.bitcoinAddress}</h2>
    <a href="http://faucet.xeno-genesis.com/">Testnet bitcoin faucet</a>
</div>
