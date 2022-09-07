<!DOCTYPE html>
<html>
    <head>
    
    	<!-- Required Tags -->
		<meta charset="utf-8">
		<!-- For Mobile -->
    	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<!-- Must be included before style sheets -->
		<!-- Boostrap v4.5 must load before all other stylesheets -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
		<style><%@include file="/css/localStyles/SignUp.css"%></style>
		
    </head>
    <body>
        <form action="/welcome" method="post">
        
        <div id="SignUp"> <!-- Parent Div -->
        	<div class="container">
        	
		        <div class="row justify-content-center align-items-center my-row">
		        		<div class="col-4 my-col"></div>
		        		<div class="col-4 my-col"></div>
		        		<div class="col-4 my-col"></div>
		        </div>
	        	
	        	<div class="row justify-content-center align-items-center">
	        		<div class="col-4 my-col"></div>
	        		<div class="col-4 justify-content-center align-items-center fields-col">
	        		
		        		<div class="SignUp-Fields">
					        		<h3>Sign Up here</h3>
					        		<p>	Email: <input type ="email" name="email"/> </p>
					        		<p> Password: <input type ="password" name="password"/> </p>
					        		<p> Re-type Pass: <input type ="password" name="passwordRetyped"/> </p>
					        		<p> (Optional) Age: <input type ="number" name="age"/> </p>
					     
					        		<p> (Optional) Gender: 
					        			<input type ="radio" name="gender" id="male"  value="Male"/> <label for="Male">Male</label>
					        			<input type ="radio" name="gender" id="female" value="Female"/> <label for="Male">Female</label>
					        			<input type ="radio" name="gender" id="other" value="other"/> <label for="other">Not preferred</label> 
					        			
					        		<label for="securityQuestion">(Optional) Select a security question:</label>
					        				  <select name="securityQuestion" id="securityQuestion">
					        				  	<option value="mother's maiden name">What is your mother's maiden name?</option>
					        				  	<option value="favorite movie">What is your favorite movie?</option>
					        				  	<option value="favorite sport">What is your favorite sport?</option>
					        				  	<option value="elementary school">What elementary school did you attend?</option>
					        				  	<option value="first car">What was your first car?</option>
					        				  	<option value="best friend">Who is your best friend?</option>
					        				  	<option value="null">Do not use a security question.</option>
					        				  </select>
					        				  
					        		<p> (Optional) secA: <input type="text" name="securityAnswer"> </p>
					        		
					        		<button class="btn btn-dark btn-lg" type="submit">Submit </button> ${error}
			        			</div>
		        		
		        		</div>
		        	
	        		<div class="col-4 my-col"></div>
	        		
	        	</div>
	        	
		        	<div class="row justify-content-center align-items-center my-row">
		        		<div class="col-4 my-col"></div>
		        		<div class="col-4 my-col"></div>
		        		<div class="col-4 my-col"></div>
		        	</div>	
        	
        	</div>

        </div>
        
        </form>
    </body>
</html>