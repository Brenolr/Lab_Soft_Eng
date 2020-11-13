<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
    <title>COVIDNET</title>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, user-scalable=no"
    />
    <link
      href="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.css"
      rel="stylesheet"
    />
    <script src="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.js"></script>
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/icon?family=Material+Icons"
    />
    <style><%@include file="assets/css/pages/login-page.css"%></style>
    <style><%@include file="assets/css/form.css"%></style>
   	<style><%@include file="assets/css/header.css"%></style>
   	<style><%@include file="assets/css/footer.css"%></style>
   	<style><%@include file="assets/css/global.css"%></style>
   	<style><%@include file="assets/css/lib/flexbox.css"%></style>

    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
  </head>

  <body class="page">
    <!-- Header -->
    <site-header></site-header>

    <div class="row center-xs login-page">
      <div class="col-xs-12 col-sm-8 col-md-6 col-lg-4">
        <div class="form-container">
          <form method="get" action="validate-login" onsubmit="return validateLogin(event)">
            <label for="emailOrCpf">E-mail ou CPF</label>
            <input
              id="emailOrCpf"
              name="emailOrCpf"
              type="text"
              placeholder="E-mail ou CPF"
            />
            <p
              display="none"
              id="emailOrCpf_errorMessage"
              class="error_color"
            ></p>
            <label for="password">Senha</label>
            <input
              id="password"
              name="password"
              type="password"
              placeholder="Senha"
            />
            <p
              display="none"
              id="password_errorMessage"
              class="error_color"
            ></p>
            <p
            	displat="none"
            	id="backend_errorMessage"
            	class="error_color"
            ></p>
            <button class="mdc-button mdc-button--raised" type="submit">
              <span class="mdc-button__ripple"></span>Login
            </button>
          </form>
        </div>
      </div>
    </div>
    <site-footer></site-footer>
    <script><%@include file="js/footer.js"%></script>
    <script><%@include file="js/header.js"%></script>
    <script><%@include file="js/form-helpers.js"%></script>
    <script><%@include file="js/form-validators.js"%></script>
    <script><%@include file="js/pages/login.js"%></script>
  </body>
</html>
