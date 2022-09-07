<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	
	<head>
		<!-- Required Tags -->
		<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<!-- Must be included before style sheets -->
		<%@ include file = "parts/navbar.jsp" %>
		<style><%@include file="/css/localStyles/homeStyle.css"%></style>
		<style><%@include file="/css/localStyles/carousel.css"%></style>
	
	</head>
	
	<body>
		
		<form action="loggedin" method="post">
			<div class="container container-style">
				
				<!-- Title Row -->
				<div class="row justify-content-center align-items-center my-row"> 
					<h1>Fusion Internship Project</h1>
				</div>
				
				<!-- Login Grid -->
				<div class="row justify-content-center align-items-start my-row">
					
					<!-- Left column of home grid -->
					<div class="col-6 no-gutters my-col">
					
						
						<div class="carousel">
						    <ul class="slides">
						    
						      <!-- Slide 1 -->
						      <input type="radio" name="radio-buttons" id="img-1" checked />
						      <li class="slide-container">
						        <div class="slide-image">
						          <img src="/resources/images/971.png" alt="img-1">
						        </div>
						        <div class="carousel-controls">
						          <label for="img-3" class="prev-slide">
						            <span>&lsaquo;</span>
						          </label>
						          <label for="img-2" class="next-slide">
						            <span>&rsaquo;</span>
						          </label>
						        </div>
						      </li>
						      
						      <!-- Slide 2 -->
						      <input type="radio" name="radio-buttons" id="img-2" />
						      <li class="slide-container">
						        <div class="slide-image">
						          <img src="/resources/images/875.png" alt="img-2">
						        </div>
						        <div class="carousel-controls">
						          <label for="img-1" class="prev-slide">
						            <span>&lsaquo;</span>
						          </label>
						          <label for="img-3" class="next-slide">
						            <span>&rsaquo;</span>
						          </label>
						        </div>
						      </li>
						      
						      <!-- Slide 3 -->
						      <input type="radio" name="radio-buttons" id="img-3" />
						      <li class="slide-container">
						        <div class="slide-image">
						          <img src="/resources/images/4412009.png" alt="img-3">
						        </div>
						        <div class="carousel-controls">
						          <label for="img-2" class="prev-slide">
						            <span>&lsaquo;</span>
						          </label>
						          <label for="img-1" class="next-slide">
						            <span>&rsaquo;</span>
						          </label>
						        </div>
						      </li>
						      <div class="carousel-dots">
						        <label for="img-1" class="carousel-dot" id="img-dot-1"></label>
						        <label for="img-2" class="carousel-dot" id="img-dot-2"></label>
						        <label for="img-3" class="carousel-dot" id="img-dot-3"></label>
						      </div>
						    </ul>
						  </div>
						</div>
						
						<!-- Right column of home page -->
						<div class="col-6 my-col">
						<h2>EXISTING USERS:</h2> <p>
						<a class="btn btn-light" href = "googlelogin">Sign in with Google</a> <p>
						<h2>----OR----</h2> <p>
						<h3>Email:</h3> <input type ="email" name="email"/> <p>
						<h3>Password:</h3> <input type ="password" name="password"/> <p>
						<p>
						<input class="btn btn-light" type="submit" /> <p>
						${error}
					</div>
					
					</div>
		</form>
		
	</body>
	
	
</html>