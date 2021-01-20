<!DOCTYPE html>
<html lang="en">
<!-- This is the view the users have when registering a new account with the application. -->
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Register</title>
  <link rel="shortcut icon" href="http://www.iconj.com/ico/d/i/dibsn5mujm.ico" type="image/x-icon" />
  <link rel="apple-touch-icon" sizes="180x180" href="http://www.iconj.com/ico/h/h/hh8qspkn7b.ico">
  <link rel="icon" type="image/png" sizes="32x32" href="http://www.iconj.com/ico/8/g/8g9cie3f5e.ico">
  <link rel="icon" type="image/png" sizes="16x16" href="http://www.iconj.com/ico/s/c/scddysfzv3.ico">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
  <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/sticky-footer/">
  <link href="../assets/dist/css/bootstrap.css" rel="stylesheet">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<style type="text/css">
html{
    font-size: 16px;
    line-height: 1.7;
    font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", "Roboto", "Helvetica Neue", Arial,  "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol" ;
}

pre, code{
    font-family: SFMono-Regular, Menlo, Monaco, Consolas, "Liberation Mono", "Courier New", monospace;
}

/*This ensures that the users browser is at the right scale to display the application */
#my{
zoom: 100%;
}

/* baby blue*/
body {
  background: #8eb7de;
}

.wrapper {
  margin: 80px;
}

/* The form css is adapted from boostrap 4 and this video: https://youtu.be/Q16slwMglFI*/
.form-signin {
  max-width: 380px;
  margin: 0 auto;
  background-color: #fff;
  padding: 15px 40px 50px;
  border: 1px solid #e5e5e5;
  border-radius: 10px;
}

.form-signin .form-signin-heading, .form-signin .warning {
  margin-bottom: 30px;
}

.form-signin input[type="text"], .form-signin input[type="password"] {
  margin-top:20px;
  margin-bottom: 20px;
  ;

}

.form-signin .form-control .logo {
  padding: 10px;
}

.form-signin .form-signin-button {
  background-color: #1e5422;
}
/*-----------------------------------------------------------------------------------------*/
.footer{
  margin: 600 auto;
  text-align: center;
  background-color: #fff;  
}

.container {
  width: auto;
  max-width: 680px;
  padding: 0 15px;
}

.logo{
  padding: 15px;
}

/*Register button and login screen hyperlink*/
.login{
  margin-top:10px;
}

 /*Email or password mismatch*/
.text-danger{
  display: none;
}

/*CAPS LOCK warning*/
.text-warning{
  display: none;
}

</style>
</head>
<body onload="initalize()">
	<div class="wrapper">
		<!--Form adapted from bootstrap 4 and https://youtu.be/Q16slwMglFI-->
		<form onsubmit="doesUserExist();return false" class="form-signin">
		  <h2 class="form-signin-heading text-center">Welcome to Fantasy Scotland!</h2>
		  <!--Logo hosted remotely.-->
		  <a class="logo" id="logo"><img src="https://i.ibb.co/yVc3vPy/Fantasy-Scotland.png" alt="Fantasy-Scotland" width="250" ></a>
		   <!--Email field with validation.-->
		  <input type="email" id="email" class="form-control" name="email" placeholder="Enter Email Address" required="" autofocus="" />
		  <!--Password field with validation adapted fromhttps://www.w3schools.com/tags/att_input_pattern.asp.-->
		  <input type="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one  number and one uppercase and lowercase letter, and at least 8 or more characters" id="password" class="form-control" name="password" placeholder="Enter Password" required="" />
		   <!--Confirm password field-->
		  <input type="password" id="passwordRepeat" class="form-control" name="passwordRepeat" placeholder="Repeat Password" required="" />
		  <!--Warning texts for caps lock being on and danger text for password or email mismatch or user already registered-->
		  <p id="text-danger" class="text-danger"></p>
		  <p class="text-warning" id="text-warning">Caps lock is ON.</p>
		  <!--Register button and login screen hyperlink-->
		  <div class="login">
		    <button type="submit" class="btn btn-lg btn-primary btn-block" id="registerButton" value="Submit"">Register</button>
		    <p id="loginLine">Already got an account? <a href='/fantasyscotland'>Sign In.</p>
		  </div>
		</form>
	</div>
	
	<footer class="footer mt-auto py-2 fixed-bottom">
	  <div class="container">
	    <span class="text-muted">Made by Daniel Mitchell<span>
	  </div>
	</footer>
	
	<script type="text/javascript">
		
			// Method that is called on page load
			function initalize() {
			}
			// --------------------------------------------------------------------------
			
			// This is a reusable method for creating a CORS request.
			//This method was adapted from https://www.tutorialspoint.com/html5/html5_cors.htm
			function createCORSRequest(method, url) {
  				var xhr = new XMLHttpRequest();
  				if ("withCredentials" in xhr) {

    				// Check if the XMLHttpRequest object has a "withCredentials" property.
    				// "withCredentials" only exists on XMLHTTPRequest2 objects.
    				xhr.open(method, url, true);

  				} else if (typeof XDomainRequest != "undefined") {

    				// Otherwise, check if XDomainRequest.
    				// XDomainRequest only exists in IE, and is IE's way of making CORS requests.
    				xhr = new XDomainRequest();
    				xhr.open(method, url);

 				 } else {

    				// Otherwise, CORS is not supported by the browser.
    				xhr = null;

  				 }
  				 return xhr;
			}
		
		</script>

		<script type="text/javascript">
			var input = document.getElementById("password"); //Password input
			var input2 = document.getElementById("passwordRepeat"); //Repeat password input
			var text = document.getElementById("text-warning"); //CAPS LOCK warning text
			
			function doesUserExist() {
				var email = document.getElementById("email").value;
				
				// First create a CORS request, this is the message we are going to send (a get request in this case)
				var xhr = createCORSRequest('GET', "http://localhost:7777/fantasyscotland/userExists?Email="+email); // Request type and URL+parameters
				
				// Message is not sent yet, but we can check that the browser supports CORS
				if (!xhr) {
  					alert("CORS not supported");
				}

				//When the response arrives...
				xhr.onload = function(e) {
 					if(xhr.response == "true"){ //If user already registed on database with same email
	     				document.getElementById("text-danger").innerText = "Email already registered.";
	          			document.getElementById("text-danger").style.display = "block";
	          			return false;
	     			}
	     			else{
	     				newUser().call(); //If no user can be found on database with that email, create new account.
	     			}
				};
				
				// We have done everything we need to prepare the CORS request, so send it
				xhr.send();		
			}

			function newUser() {
		        var email = document.getElementById("email").value;
	       		var pass = document.getElementById("password").value;
		        var passRep = document.getElementById("passwordRepeat").value;
	     		
	     		if(pass !== passRep){ //Check password match before sending info to database
	        		document.getElementById('text-danger').innerText = "Passwords did not match.";
	          		document.getElementById("text-danger").style.display = "block";
	        	}else{
		        	// First create a CORS request, this is the message we are going to send (a post request in this case)
		        	var xhr = createCORSRequest('POST', "http://localhost:7777/fantasyscotland/register?Email="+email+"&Pass="+pass); // Request type and URL+parameters
	        
	        		// Message is not sent yet, but we can check that the browser supports CORS
	       			 if (!xhr) {
	            		alert("CORS not supported");
	        		}
	
		        	//When the response arrives...
	       			 xhr.onload = function(e) {
	         		 	window.location.href = '/fantasyscotland/newteam'; //Send user to screen to create a team for their account
	       			 }
	       		 } 
	        	// We have done everything we need to prepare the CORS request, so send it
	       		 xhr.send();  
	  		}
			
			//Javascript to detect CAPSLOCK on both password input fields, adapted from https://www.w3schools.com/howto/howto_js_detect_capslock.asp
			input.addEventListener("keyup", function(event) {
				if (event.getModifierState("CapsLock")) {
			    	text.style.display = "block";
			  	} else {
			    	text.style.display = "none"
			  	}
			
			});
			
			input2.addEventListener("keyup", function(event) {
				if (event.getModifierState("CapsLock")) {
			    	text.style.display = "block";
			  	} else {
			    	text.style.display = "none"
			  	}
			
			});
		</script>
</body>
</html>