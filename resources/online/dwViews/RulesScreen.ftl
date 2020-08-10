<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Fantasy Scotland</title>
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
  height: 730px;
  margin: 0 auto;
  margin-bottom: 100px;
  background-color: #fff;
  padding: 15px 60px 20px;
  border: 1px solid #e5e5e5;
  border-radius: 10px;
}
.form-signin-heading, .form-signin .warning {
  margin-bottom: 16px;
}
.form-signin .form-control .logo {
  padding: 10px;
}
.form-signin .form-signin-button {
  background-color: #1e5422;
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
  margin-top: 0px;
  margin-left: auto;
  margin-right: auto;
  background-color: black;
}
.football .p {
  width: 100%;
  height: auto;
}
/* Style the button and place it in the middle of the container/image */
.football .btn {
  background-color: white;
  color: black;
  font-size: 16px;
  font-weight: bold;
  border: solid;
  cursor: pointer;
  border-radius: 50%;
  border-color: black;
  margin: 0px 0px;
  text-align: center;
}
.btn:hover {
  background-color: black;
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
.grid-container {
  display: grid;
  grid-template-columns: auto auto auto;
  background-color: #fff;
  padding: 10px;
  max-height: 500px;
  max-width: 2000px;
  height: 500px;
}
.grid-item {
  background-color: rgba(250, 255, 255, 0.8);
  border: 1px solid rgba(0, 0, 0, 0.8);
  padding: 20px;
  font-size: 30px;
  text-align: center;
}
table {
    width: 100%;
}
thead, tbody, tr, td, th { 
  display: block; 
}
tr:after {
    content: ' ';
    display: block;
    visibility: hidden;
    clear: both;
}
thead th {
    height: 50px;
    /*text-align: left;*/
}
tbody {
    height: 300px;
    overflow-y: auto;
}
thead {
  width: 450px;
    /* fallback */
}
tbody td, thead th {
    width: 33.2%;
    height: 60px;
    float: left;
}
.navbarNavAltMarkup{
  position: absolute;
}
</style>
</head>

<body onload="initalize()">
  <a class="logo" id="logo"><img src="https://i.ibb.co/yVc3vPy/Fantasy-Scotland.png" alt="Fantasy-Scotland" width="200" ></a>
  <div class="wrapper">
    <div class="main">
      <div class = "header">
        <h2 class="form-signin-heading text-center">Welcome to Fantasy Scotland!</h2>
        <h3 class="form-signin-heading text-center" id="welcomeHeader">Hello user!</h3>
      </div>
      <div>
      <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">FantasyScotland</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
          <div class="navbar-nav">
            <a class="nav-item nav-link active" href="#">Home <span class="sr-only">(current)</span></a>
            <a class="nav-item nav-link" href="#">Team</a>
            <a class="nav-item nav-link" href="#">Leagues</a>
            <a class="nav-item nav-link" href="#">Transfers</a>
            <a class="nav-item nav-link" href="#">Rules</a>
          </div>
        </div>
      </nav>
    </div>
      <div class="grid-container">
        <div class="grid-item">Points per Week
          <div class="points-item">
            <h1>1</h1>
          </div>
          </div>
        <div class="grid-item">Team Overview
          <div class="team-item">
            <h1>2</h1>
          </div>
        </div>
        <div class="grid-item">Fixtures
          <div class="fixture-item">
            <h1>3</h1>
          </div>
        </div> 
      </div>


      <footer class="footer mt-auto py-2 fixed-bottom">
          <div class="container">
            <span class="text-muted">Made by Daniel Mitchell</span>
          </div>
      </footer>
    </div>
  </div>

  <div class="modal hide" id="selectModal" tabindex="-1" role="dialog" aria-labelledby="selectModalLabel" aria-hidden="true">

      <div class="modal-header">
        <h3 id="selectModalLabel">Select Player</h3>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
          </button>
      </div>

      <div class="modal-body">
        <table id="table" class="table table-bordered table-hover table-sm " cellspacing="0" width="100%">
          <thead>
            <tr>
                <th class="th-sm" style="cursor:s-resize" onclick="sortTable(0)">Name
                </th>
                <th class="th-sm" style="cursor:s-resize" onclick="sortTable(1)">Club
                </th>
                <th class="th-sm" style="cursor:s-resize" onclick="sortTable(2)">Cost(&pound mill)
                </th>

            </tr>
          </thead>
          <tbody id="table-body">
            <tr class='clickable-row' style="cursor:pointer" value="111111111">
                <td class="name">Default Default</td> <td class="club">Default</td> <td class="price">0.0</td>
            </tr>
          </tbody>
      </table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn-primary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>


  <div class="modal hide" id="removeModal" tabindex="-1" role="dialog" aria-labelledby="removeModalLabel" aria-hidden="true">

      <div class="modal-header">
        <h3 id="removeModalLabel">Remove Player</h3>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
          </button>
      </div>

      <div class="modal-body" id = "removeDiv">
          <button type="button" class="btn-primary" data-dismiss="modal" onclick = "removePlayer(position);">Remove Player</button>
      </div>
    </div>
  </div>


  <script type="text/javascript">
      // Method that is called on page load
      function initalize() {
        buildClubs();
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
      var user;
      var clubs = [];
      var position;
      function loadTable(array) {
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
              var cText = document.createTextNode(convertClub(array[i].club_id));
              club.appendChild(cText);
              var price = document.createElement('td');
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
          players = [
              goalkeepers = [],
              defenders = [],
            midfielders = [],
            forwards = [],
            ];
          for(var i = 0; i < response.length; i++){
            if(response[i].selectable === false){
              continue;
            }
            else if(response[i].position === "Goalkeeper"){
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
          buildUser().call;
        }
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();   
      }
      function buildUser() {
        // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "http://localhost:7777/fantasyscotland/buildUser"); // Request type and URL
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }
        // CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
        // to do when the response arrives 
        xhr.onload = function(e) {
          user = JSON.parse(xhr.response);
          var fields = user.email.split('@');
          document.getElementById("welcomeHeader").innerHTML = "Hello " + fields[0] + "!";
          
          repaint().call;
        }
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();   
      }
      
      function buildClubs() {
        // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "http://localhost:7777/fantasyscotland/buildClubs"); // Request type and URL
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }
        // CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
        // to do when the response arrives 
        xhr.onload = function(e) {
          var response = JSON.parse(xhr.response); // the text of the response
          for(var i = 0; i < response.length; i++){
            clubs.push(response[i]);
          }
          buildPlayers().call;
        }
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();   
      }
      
      function repaint(){
        document.getElementById("budgetBadge").innerHTML = user.team.transferBudget;
        var length = Object.keys(user.team.squad).length;
       
        if(length == "0"){
          document.getElementById("removeAll").style.display = "none";
        }
        if(length == "15" && user.team.transferBudget >= "0"){
          document.getElementById("continue").style.display = "block";
        }
        else{
          document.getElementById("continue").style.display = "none";
        }
        for(var x = 1;x<=15;x++){
          var button = document.getElementById("button"+x);
          button.style.background = "rgb(255,255,255)";
          document.getElementById("button"+x+"Text").firstChild.nodeValue = "";
          document.getElementById("button"+x+"Badge").innerHTML = 0;
        }  
        for(var i in user.team.squad){
          var button = document.getElementById("button"+i);
          button.style.background = buttonPainter(user.team.squad[i].club_id);
          var names = (user.team.squad[i].name).split(' ');
          document.getElementById("button"+i+"Text").firstChild.nodeValue = names[1];
          document.getElementById("button"+i+"Badge").innerHTML = user.team.squad[i].price;
        }
      }
      
      function buttonPainter(club){
        if(club === 45){
          return "rgb(226,0,26)";
        }
        else if(club === 54){
          return "linear-gradient(to bottom, rgb(1,135,73) 50%, white 50%)";
        }
        else if(club === 228){
          return "linear-gradient(to bottom, rgb(204,56,63) 50%, white 50%)";
        }
        else if(club === 50){
          return "rgb(159,25,49)";
        }
        else if(club === 53){
          return "rgb(0,117,59)";
        }
        else if(club === 52){
          return "linear-gradient(to right, rgb(47,54,143) 50%, white 50%)";
        }
        else if(club === 560){
          return "rgb(255,204,0)";
        }
        else if(club === 47){
          return "linear-gradient(to bottom, rgb(251,186,45) 50%, rgb(122,20,63)  50%)";
        }
        else if(club === 49){
          return "rgb(27,69,143)";
        }
        else if(club === 360){
          return "linear-gradient(to bottom, rgb(4,9,87) 50%, rgb(244,19,43)  50%)";
        }
        else if(club === 46){
          return "linear-gradient(to bottom, rgb(36,63,144) 50%, white  50%)";
        }
        else if(club === 56){
          return "linear-gradient(to right, black 50%, white 50%)";
        }
      }
      
      function setPosition(pos){
        position = pos; 
      }
      
      function convertClub(id){
        for(var i = 0; i < clubs.length; i++){
          if(clubs[i].club_id === id){
            return clubs[i].name;
          }
        }
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
              addPlayer($(this).attr('value'), position);
              var $item = $(this).closest("tr") 
                       .find(".price")     // Gets a descendent with class="price"
                       .text();         // Retrieves the text within <td>
              $("#selectModal").modal('hide');
          });
      });
    </script>     
</body>
</html> 