<!DOCTYPE html>
<html>
	
	<head>
	<!-- Required? Tags -->
		<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<!-- Boostrap v4.5 must load before all other stylesheets -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
		
	</head>
	
	<nav class="navbar navbar-light bg-light">
			<a href="/" class="navbar-brand">
				<img 
				src="https://cdn.hipwallpaper.com/i/50/67/P2HQgW.png"
				width="30" height="30" /> Fusion Intern Project</a>
			<ul class="navbar-nav">
				<li class="nav-item">
					<c:if test="${loggedin == false}">
					<a href="SignUp" class="nav-link ">New? Sign up now!</a>
					</c:if>
					
					
				</li>
			</ul>
		</nav>
	
</html>