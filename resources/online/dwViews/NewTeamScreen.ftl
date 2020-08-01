<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>New Team</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
  <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/sticky-footer/">
  <link href="../assets/dist/css/bootstrap.css" rel="stylesheet">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<style type="text/css">
body {
  background: #8eb7de;
}
.wrapper {
  margin: 90px;
}
.main {
  max-width: 2000px;
  max-height: 1200px;
  height: 750px;
  margin: 0 auto;
  margin-bottom: 100px;
  background-color: #fff;
  padding: 15px 40px 50px;
  border: 1px solid #e5e5e5;
  border-radius: 10px;
}
.form-signin-heading, .form-signin .warning {
  margin-bottom: 30px;
}

.form-signin .form-control .logo {
  padding: 10px;
}

.form-signin .form-signin-button {
  background-color: #1e5422;
}

.header{
	  
}

.footer{
  margin: 600 auto;
  text-align: center;
  background-color: #fff;  
}

.logo{
  padding: 15px;
  position: absolute;
  top: -6px;
  left: 0px;
}

.football {
	position:relative;
  width: auto;
  max-width: 700px;
  margin-top:100px;
  margin-left: auto;
  margin-right: auto;
}

.football .p {
  width: 100%;
  height: auto;
}

/* Style the button and place it in the middle of the container/image */
.football .btn {
  background-color: #555;
  color: white;
  font-size: 16px;
  border: solid;
  cursor: pointer;
  border-radius: 50%;
  border-color: black;
  margin: 4px 4px;
  text-align: center;
}

.btn:hover {
  background-color: black;
}

.image{
  width: 100%;
  text-align: center;
}

.one{
	position: absolute;
	top: 43%;
	left:10%;
}

.two{
	position: absolute;
	bottom: 15%;
	left:25%;
}

.three{
	position: absolute;
	top: 15%;
	left:25%;
}

.four{
	position: absolute;
	bottom: 35%;
	left:25%;
}

.five{
	position: absolute;
	top: 35%;
	left:25%;
}

.six{
	position: absolute;
	bottom: 35%;
	left:46%;
}

.seven{
	position: absolute;
	bottom: 35%;
	right:25%;
}

.eight{
	position: absolute;
	bottom: 15%;
	left:46%;
}

.nine{
	position: absolute;
	top: 35%;
	right:25%;
}

.ten{
	position: absolute;
	top: 35%;
	left:46%;
}

.eleven{
	position: absolute;
	top: 15%;
	left:46%;
}

.twelve{
	position: absolute;
	bottom: -2%;
	left:5%;
}

.thirteen{
	position: absolute;
	bottom: -2%;
	left:12%;
}

.fourteen{
	position: absolute;
	bottom: -2%;
	left:19%;
}

.fifteen{
	position: absolute;
	bottom: -2%;
	left:26%;
}

.modal{
	position:absolute;
	background-color: white;
	width: 500px;
	height:auto;
  	max-width: 700px;
  	margin-top:100px;
  	margin-left:100px;
}

.list-group{
    max-height: 300px;
    margin-bottom: 10px;
    overflow:scroll;
    -webkit-overflow-scrolling: touch;
}

</style>
</head>

<body onload="initalize()">
	<a class="logo" id="logo"><img src="https://i.ibb.co/yVc3vPy/Fantasy-Scotland.png" alt="Fantasy-Scotland" width="200" ></a>
	<div class="wrapper">
		<div class="main">
			<div class = "header">
				<h2 class="form-signin-heading text-center">Welcome to Fantasy Scotland!</h2>
				<h3 class="form-signin-heading text-center">Please Create a Team!</h3>
		  	</div>
			<div class="football">
  				<p class="image"><img src="https://i.ibb.co/s9ddGFt/Background-illustration-of-a-soccer-field.jpg" alt="Fantasy-Scotland" class="image" ></p>
  				<div class="one">
  					<a data-target="#myModal" role="button" class="btn" data-toggle="modal">1</a>
  				</div>
  				<div class="two">
  					<button class="btn">2</button>
  				</div>
  				<div class="three">
  					<button class="btn">3</button>
  				</div>
  				<div class="four">
  					<button class="btn">4</button>
  				</div>
  				<div class="five">
  					<button class="btn">5</button>
  				</div>
  				<div class="six">
  					<button class="btn">6</button>
  				</div>
  				<div class="seven">
  					<button class="btn">7</button>
  				</div>
  				<div class="eight">
  					<button class="btn">8</button>
  				</div>
  				<div class="nine">
  					<button class="btn">9</button>
  				</div>
  				<div class="ten">
  					<button class="btn">10</button>
  				</div>
  				<div class="eleven">
  					<button class="btn">11</button>
  				</div>
  				<div class="twelve">
  					<button class="btn">12</button>
  				</div>
  				<div class="thirteen">
  					<button class="btn">13</button>
  				</div>
  				<div class="fourteen">
  					<button class="btn">14</button>
  				</div>
  				<div class="fifteen">
  					<button class="btn">15</button>
  				</div>
  				
  				<div class="modal fade hide" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  					<div class="modal-header">
    					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    					<h3 id="myModalLabel">Select Player</h3>
  					</div>
  					<div class="modal-body">
      					<div class="list-group">
						  <div class="row">
					  <div class="col-4">
					    <div class="list-group" id="list-tab" role="tablist">
					      <a class="list-group-item list-group-item-action active" id="list-home-list" data-toggle="list" href="#list-home" role="tab" aria-controls="home">Home</a>
					      <a class="list-group-item list-group-item-action" id="list-profile-list" data-toggle="list" href="#list-profile" role="tab" aria-controls="profile">Profile</a>
					      <a class="list-group-item list-group-item-action" id="list-messages-list" data-toggle="list" href="#list-messages" role="tab" aria-controls="messages">Messages</a>
					      <a class="list-group-item list-group-item-action" id="list-settings-list" data-toggle="list" href="#list-settings" role="tab" aria-controls="settings">Settings</a>
					    </div>
					  </div>
					  <div class="col-8">
					    <div class="tab-content" id="nav-tabContent">
					      <div class="tab-pane fade show active" id="list-home" role="tabpanel" aria-labelledby="list-home-list">...</div>
					      <div class="tab-pane fade" id="list-profile" role="tabpanel" aria-labelledby="list-profile-list">...</div>
					      <div class="tab-pane fade" id="list-messages" role="tabpanel" aria-labelledby="list-messages-list">...</div>
					      <div class="tab-pane fade" id="list-settings" role="tabpanel" aria-labelledby="list-settings-list">...</div>
					    </div>
					  </div>
				</div>
  				</div>
				  <div class="modal-footer">
				    <button  data-dismiss="modal" aria-hidden="true">Close</button>
				    <button class="btn-primary">Save changes</button>
				  </div>
				</div>
			</div>
		 	
		  
		</div>

	</div>
	
	<footer class="footer mt-auto py-2 fixed-bottom">
  		<div class="container">
    		<span class="text-muted">Made by Daniel Mitchell<span>
  		</div>
	</footer>


	<script type="text/javascript">
		
			// Method that is called on page load
			function initalize() {
				// --------------------------------------------------------------------------
				// You can call other methods you want to run when the page first loads here
				// --------------------------------------------------------------------------
				
				// For example, lets call our sample methods
				
				
			}
			
			// -----------------------------------------
			// Add your other Javascript methods Here
			// -----------------------------------------
		
			// This is a reusable method for creating a CORS request. Do not edit this.
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
		
		<!-- Here are examples of how to call REST API Methods -->
		<script type="text/javascript">
		
			// This calls the helloJSONList REST method from TopTrumpsRESTAPI
			function helloJSONList() {
			
				// First create a CORS request, this is the message we are going to send (a get request in this case)
				var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/helloJSONList"); // Request type and URL
				
				// Message is not sent yet, but we can check that the browser supports CORS
				if (!xhr) {
  					alert("CORS not supported");
				}

				// CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
				// to do when the response arrives 
				xhr.onload = function(e) {
 					var responseText = xhr.response; // the text of the response
					alert(responseText); // lets produce an alert
				};
				
				// We have done everything we need to prepare the CORS request, so send it
				xhr.send();		
			}
			
			// This calls the helloJSONList REST method from TopTrumpsRESTAPI
			function helloWord(word) {
			
				// First create a CORS request, this is the message we are going to send (a get request in this case)
				var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/helloWord?Word="+word); // Request type and URL+parameters
				
				// Message is not sent yet, but we can check that the browser supports CORS
				if (!xhr) {
  					alert("CORS not supported");
				}

				// CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
				// to do when the response arrives 
				xhr.onload = function(e) {
 					var responseText = xhr.response; // the text of the response
					alert(responseText); // lets produce an alert
				};
				
				// We have done everything we need to prepare the CORS request, so send it
				xhr.send();		
			}

			function addGoalkeeper()

		</script>			
</body>
</html>











