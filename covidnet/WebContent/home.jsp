<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
  
   	<style><%@include file="assets/css/pages/index.css"%></style>
   	<style><%@include file="assets/css/header.css"%></style>
   	<style><%@include file="assets/css/footer.css"%></style>
   	<style><%@include file="assets/css/global.css"%></style>
  
    <title>COVIDNET</title>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, user-scalable=no"
    />
    <script ><%@include file="js/pages/home.js"%></script>
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
  </head>

  <body>
    <!-- Header -->
    <site-header></site-header>

    <!-- Banner -->
    <section>
      <div id="banner">
        <span data-color="covid">COVID</span><span data-color="net">NET</span>
        <p>Uma descrição interessante do sistema.</p>
      </div>
    </section>

    <section>
      <div class="cards-section">
        <a onClick={checkPrivateLink('list-patient')} class="card">
          <div class="image-container"></div>
          <h4>Paciente</h4>
        </a>
      
        <a onClick={checkPrivateLink('list-local')} class="card">
          <div class="image-container"></div>
          <h4>Local de Atendimento</h4>
        </a>
      
        <a onClick={checkPrivateLink('list-transfer')} class="card">
          <div class="image-container"></div>
          <h4>Transferência</h4>
        </a>
      </div>
    </section>
    <site-footer></site-footer>
    <script><%@include file="js/footer.js"%></script>
    <script><%@include file="js/header.js"%></script>
  </body>
</html>
