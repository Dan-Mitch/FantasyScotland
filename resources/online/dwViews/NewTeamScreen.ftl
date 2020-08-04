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
  margin-top:50px;
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
	 top: 24%;
  	left: 31%;
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
				<h3 class="form-signin-heading text-center">Transfer Budget £<span class="badge badge-secondary" id="budgetBadge">60.0</span>million.</h3>
				<h4 class="text-danger text-center">ERRORS HERE</h4>
		  	</div>

			<div class="football">
  				<p class="image"><img src="https://i.ibb.co/s9ddGFt/Background-illustration-of-a-soccer-field.jpg" alt="Fantasy-Scotland" class="image" ></p>
  				<div class="one">
  					<a data-target="#myModal" role="button" class="btn" data-toggle="modal" id="button1" onclick="document.getElementById('table').appendChild(loadTable(players[0]));">1</a>
  				</div>
  				<div class="two">
  					<a data-target="#myModal" role="button" class="btn" data-toggle="modal" id="button2" onclick="document.getElementById('table').appendChild(loadTable(players[1]));">2</a>
  				</div>
  				<div class="three">
  					<a data-target="#myModal" role="button" class="btn" data-toggle="modal" id="button3" onclick="document.getElementById('table').appendChild(loadTable(players[1]));">3</a>
  				</div>
  				<div class="four">
  					<a data-target="#myModal" role="button" class="btn" data-toggle="modal" id="button4" onclick="document.getElementById('table').appendChild(loadTable(players[1]));">4</a>
  				</div>
  				<div class="five">
  					<a data-target="#myModal" role="button" class="btn" data-toggle="modal" id="button5" onclick="document.getElementById('table').appendChild(loadTable(players[1]));">5</a>
  				</div>
  				<div class="six">
  					<a data-target="#myModal" role="button" class="btn" data-toggle="modal" id="button6" onclick="document.getElementById('table').appendChild(loadTable(players[2]));">6</a>
  				</div>
  				<div class="seven">
  					<a data-target="#myModal" role="button" class="btn" data-toggle="modal" id="button7" onclick="document.getElementById('table').appendChild(loadTable(players[3]));">7</a>
  				</div>
  				<div class="eight">
  					<a data-target="#myModal" role="button" class="btn" data-toggle="modal" id="button8" onclick="document.getElementById('table').appendChild(loadTable(players[2]));">8</a>
  				</div>
  				<div class="nine">
  					<a data-target="#myModal" role="button" class="btn" data-toggle="modal" id="button9" onclick="document.getElementById('table').appendChild(loadTable(players[3]));">9</a>
  				</div>
  				<div class="ten">
  					<a data-target="#myModal" role="button" class="btn" data-toggle="modal" id="button10" onclick="document.getElementById('table').appendChild(loadTable(players[2]));">10</a>
  				</div>
  				<div class="eleven">
  					<a data-target="#myModal" role="button" class="btn" data-toggle="modal" id="button11" onclick="document.getElementById('table').appendChild(loadTable(players[2]));">11</a>
  				</div>
  				<div class="twelve">
  					<a data-target="#myModal" role="button" class="btn" data-toggle="modal" id="button12" onclick="document.getElementById('table').appendChild(loadTable(players[0]));">12</a>
  				</div>
  				<div class="thirteen">
  					<a data-target="#myModal" role="button" class="btn" data-toggle="modal" id="button13" onclick="document.getElementById('table').appendChild(loadTable(players[1]));">13</a>
  				</div>
  				<div class="fourteen">
  					<a data-target="#myModal" role="button" class="btn" data-toggle="modal" id="button14" onclick="document.getElementById('table').appendChild(loadTable(players[2]));">14</a>
  				</div>
  				<div class="fifteen">
  					<a data-target="#myModal" role="button" class="btn" data-toggle="modal" id="button15" onclick="document.getElementById('table').appendChild(loadTable(players[3]));">15</a>
  				</div>
			</div>

			<footer class="footer mt-auto py-2 fixed-bottom">
  				<div class="container">
    				<span class="text-muted">Made by Daniel Mitchell</span>
  				</div>
			</footer>
		</div>
	</div>

	<div class="modal hide" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

  		<div class="modal-header">
    		<h3 id="myModalLabel">Select Player</h3>
    		<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          		<span aria-hidden="true">&times;</span>
        	</button>
  		</div>

  		<!-- <div class="modal-body">
  			<div class="list-group" id="list-group">
	      		<a href="#" class="list-group-item list-group-item-action ">
	    		1</a>
	  			<a href="#" class="list-group-item list-group-item-action">2</a>
	  			<a href="#" class="list-group-item list-group-item-action">3</a>
  			</div>
  		</div> -->
  		<div class="modal-body">
  			<table id="table" class="table table-bordered table-hover table-sm " cellspacing="0" width="100%">
  				<thead>
    				<tr>
      					<th class="th-sm" style="cursor:s-resize" onclick="sortTable(0)">Name
      					</th>
      					<th class="th-sm" style="cursor:s-resize" onclick="sortTable(1)">Club
      					</th>
      					<th class="th-sm" style="cursor:s-resize" onclick="sortTable(2)">Cost(£mill)
      					</th>
      
    				</tr>
  				</thead>
  				<tbody id="table-body">
    				<tr class='clickable-row' style="cursor:pointer" value="111111111">
        				<td class="name">Tom Wallop</td> <td class="club">Aberdeen</td> <td class="price">1.3</td>
    				</tr>
    				<tr class='clickable-row' style="cursor:pointer" value="2222222">
        				<td class="name">Adam Strong</td> <td class="club">Celtic</td> <td class="price">2.3</td>
    				</tr>
  				</tbody>
			</table>
  		</div>
			<div class="modal-footer">
				<button type="button" class="btn-secondary" data-dismiss="modal">Close</button>
				<button class="btn-primary">Add Player</button>
			</div>
		</div>
	</div>


	<script type="text/javascript">
			// Method that is called on page load
			function initalize() {
				buildPlayers();
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
			var players = [
    		goalkeepers = [],
    		defenders = [],
			midfielders = [],
			forwards = [],
			];
			
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

			function addPlayer(word) {
				alert(word);
				// First create a CORS request, this is the message we are going to send (a get request in this case)
				var xhr = createCORSRequest('GET', "http://localhost:7777/fantasyscotland/helloWord?Word="+word); // Request type and URL+parameters
				
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

			function updateTransfer(word) {
				alert(word);
				// First create a CORS request, this is the message we are going to send (a get request in this case)
				var xhr = createCORSRequest('GET', "http://localhost:7777/fantasyscotland/helloWord?Word="+word); // Request type and URL+parameters
				
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

			function loadTable(array) {
				// Create the list element:
			    var table = document.getElementById('table-body');
					table.innerHTML = "";
			    for(var i = 0; i < array.length; i++) {
			        // Create the list item:
			        var tr = document.createElement('tr');
			        tr.setAttribute('value', array[i].player_id);
			        tr.setAttribute('class', "clickable-row");
			        tr.setAttribute('style', "cursor:pointer");

			        var name = document.createElement('td');
			        name.setAttribute('class', "name");
			        var nText = document.createTextNode(array[i].name);
			        name.appendChild(nText);

			        var club = document.createElement('td');
			        club.setAttribute('class', "club");
			        var cText = document.createTextNode(array[i].club_id);
			        club.appendChild(cText);

			        var	price =	document.createElement('td');
					price.setAttribute('class', "price");
					var pText = document.createTextNode(array[i].price);
			        price.appendChild(pText);


					tr.appendChild(name);
					tr.appendChild(club);
					tr.appendChild(price);

			        // Add it to the list:
			        table.appendChild(tr);
			    }

			    // Finally, return the constructed list:
			    return list;
			}

			function buildPlayers() {
			
				// First create a CORS request, this is the message we are going to send (a get request in this case)
				var xhr = createCORSRequest('GET', "http://localhost:7777/fantasyscotland/buildPlayers"); // Request type and URL
				
				// Message is not sent yet, but we can check that the browser supports CORS
				if (!xhr) {
  					alert("CORS not supported");
				}

				// CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
				// to do when the response arrives 
				xhr.onload = function(e) {
 					var response = JSON.parse(xhr.response); // the text of the response
					for(var i = 0; i < response.length; i++){
						if(response[i].position === "Goalkeeper"){
							players[0].push(response[i]);
						}
						else if(response[i].position === "Defender"){
							players[1].push(response[i]);
						}
						else if(response[i].position === "Midfielder"){
							players[2].push(response[i]);
						}
						else if(response[i].position === "Forward"){
							players[3].push(response[i]);
						}
					}
				}
				
				// We have done everything we need to prepare the CORS request, so send it
				xhr.send();		
			}

			function sortTable(n) {
			  var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
			  table = document.getElementById("table");
			  switching = true;
			  // Set the sorting direction to ascending:
			  dir = "asc";
			  /* Make a loop that will continue until
			  no switching has been done: */
			  while (switching) {
			    // Start by saying: no switching is done:
			    switching = false;
			    rows = table.rows;
			    /* Loop through all table rows (except the
			    first, which contains table headers): */
			    for (i = 1; i < (rows.length - 1); i++) {
			      // Start by saying there should be no switching:
			      shouldSwitch = false;
			      /* Get the two elements you want to compare,
			      one from current row and one from the next: */
			      x = rows[i].getElementsByTagName("TD")[n];
			      y = rows[i + 1].getElementsByTagName("TD")[n];
			      /* Check if the two rows should switch place,
			      based on the direction, asc or desc: */
			      if (dir == "asc") {
			        if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
			          // If so, mark as a switch and break the loop:
			          shouldSwitch = true;
			          break;
			        }
			      } else if (dir == "desc") {
			        if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
			          // If so, mark as a switch and break the loop:
			          shouldSwitch = true;
			          break;
			        }
			      }
			    }
			    if (shouldSwitch) {
			      /* If a switch has been marked, make the switch
			      and mark that a switch has been done: */
			      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
			      switching = true;
			      // Each time a switch is done, increase this count by 1:
			      switchcount ++;
			    } else {
			      /* If no switching has been done AND the direction is "asc",
			      set the direction to "desc" and run the while loop again. */
			      if (switchcount == 0 && dir == "asc") {
			        dir = "desc";
			        switching = true;
			      }
			    }
			  }
			}

			jQuery(document).ready(function($) {
    			$('#table').on('click', '.clickable-row', function() {
        			addPlayer($(this).attr('value'));
        			var $item = $(this).closest("tr") 
                       .find(".price")     // Gets a descendent with class="price"
                       .text();         // Retrieves the text within <td>
        			updateTransfer($item);
        			$("#myModal").modal('hide');
    			});
			});

		</script>			
</body>
</html>