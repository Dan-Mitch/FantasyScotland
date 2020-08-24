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
/*******************************
font-family: 
// Safari for OS X and iOS (San Francisco)
-apple-system,
// Chrome < 56 for OS X (San Francisco)
BlinkMacSystemFont,
// Windows
"Segoe UI",
// Android
"Roboto",
// Basic web fallback
"Helvetica Neue", Arial, sans-serif,
// Emoji fonts
"Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol" 

font-family: SFMono-Regular, Menlo, Monaco, Consolas, "Liberation Mono", "Courier New", monospace;
***********************************/
html{
    font-size: 16px;
    line-height: 1.7;
    font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", "Roboto", "Helvetica Neue", Arial,  "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol" ;
}
pre, code{
    font-family: SFMono-Regular, Menlo, Monaco, Consolas, "Liberation Mono", "Courier New", monospace;
}
body {
  background: #8eb7de;
}
.wrapper {
  margin: 90px;
}

.main {
  max-width: 2000px;
  max-height: 1000px;
  min-height:730px;
  margin: 0 auto;
  margin-bottom: 100px;
  background-color: #fff;
  padding: 15px 60px 20px;
  border: 1px solid #e5e5e5;
  border-radius: 10px;
}

.body{
  max-width: 2000px;
  max-height: 1000px;
  width:100%;
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

.form-signin-heading{
  padding-right: 9%;
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
  position:fixed;
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

.image{
  width: 100%;
  text-align: center;
}

.side-line {
  height: 50px;
  width: 100%;
  background-color: #6b9c58;
}

.one{
  position: absolute;
  top: 38.5%;
  left:10%;
  line-height:2;
  max-width:110px;
  text-align: center;
}
.two{
  position: absolute;
  top: 65%;
  left:30%;
  line-height:2;
  max-width:110px;
  text-align: center;
}
.three{
  position: absolute;
  top: 10%;
  left:30%;
  line-height:2;
  max-width:110px;
  text-align: center;
}
.four{
  position: absolute;
  top: 50%;
  left:30%;
  line-height:2;
  max-width:110px;
  text-align: center;
}
.five{
  position: absolute;
  top: 25%;
  left:30%;
  line-height:2;
  max-width:110px;
  text-align: center;
}
.six{
  position: absolute;
  top: 50%;
  left:50%;
  line-height:2;
  max-width:110px;
  text-align: center;
}
.seven{
  position: absolute;
  top: 50%;
  right:20%;
  line-height:2;
  max-width:110px;
  text-align: center;
}
.eight{
  position: absolute;
  top: 65%;
  left:50%;
  line-height:2;
  max-width:110px;
  text-align: center;
}
.nine{
  position: absolute;
  top: 30%;
  right:20%;
  line-height:2;
  max-width:110px;
  text-align: center;
}
.ten{
  position: absolute;
  top: 25%;
  left:50%;
  line-height:2;
  max-width:110px;
  text-align: center;
}
.eleven{
  position: absolute;
  top: 10%;
  left:50%;
  line-height:2;
  max-width:110px;
  text-align: center;
}
.twelve{
  position: absolute;
  top: 92%;
  left:10%;
  line-height:2;
  max-width:110px;
  text-align: center;
}
.thirteen{
  position: absolute;
  top: 92%;
  left:30%;
  line-height:2;
  max-width:110px;
  text-align: center;
}
.fourteen{
  position: absolute;
  top: 92%;
  left:50%;
  line-height:2;
  max-width:110px;
  text-align: center;
}
.fifteen{
  position: absolute;
  top: 92%;
  right:20%;
  line-height:2;
  max-width:110px;
  text-align: center;
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

.navbar {
min-height: 50px;
height:90px;
}

.navbar-brand {
  padding: 0 1px;
  height: 75px;
  line-height: 50px;
}

.navbar-toggle {
  /* (80px - button height 34px) / 2 = 23px */
  margin-top: 28px;
  padding: 9px 10px !important;
}

@media (min-width: 768px) {
  .navbar-nav > li > a {
    /* (80px - line-height of 27px) / 2 = 26.5px */
    padding-top: 31.5px;
    padding-bottom: 31.5px;
    line-height: 100px;
  }
}


</style>
</head>

<body onload="initalize()">
  
  <div class="wrapper">
    <nav class="navbar fixed-top navbar-light" style="background-color: #8eb7de;">
        <a class="navbar-brand" id="logo" href='/fantasyscotland/home'><img src="https://i.ibb.co/yVc3vPy/Fantasy-Scotland.png" alt="Fantasy-Scotland" width="200" ></a>
        <h1 class="form-signin-heading text-center ">Manage Team</h1>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
          <div class="navbar-nav">
            <a class="nav-item nav-link text-right" href='/fantasyscotland/manage'>Manage</a>
            <a class="nav-item nav-link text-right" href='/fantasyscotland/leagues'>Leagues</a>
            <a class="nav-item nav-link text-right" href='/fantasyscotland/transfer'>Transfer</a>
            <a class="nav-item nav-link text-right" href='/fantasyscotland/rules'>Rules</a>
          </div>
        </div>
      </nav>
    <div class="main">
      <div class = "header">
        <button type="button" class="btn btn-danger" style="float:right" onclick="signOut();">Sign Out</button><h6 class="form-signin-heading text-right" id="welcomeHeader"></h6>
      </div>

      <div class="body">
         <div class = "header">
        <h4 class="text-center">Please manage your team before the next round.</h4>
      </div>
      <div class="alert alert-success text-center" id="successText" style="display:none;vertical-align: top">
         Sucess text
      </div>
      <div class="alert alert-danger text-center" id="errorText" style="display:none;vertical-align: top">
         Danger text
      </div>
      <div class="col-md-12 text-center">
        <div class = "btn-group" >
        <button type="button" class="btn btn-danger" id="removeTransfer" onclick="removeChanges()" style="display:none">Remove Changes</button>
        <button type="button" style="float: right;display:none" data-target="#confirmModal" data-toggle="modal" class="btn btn-success" id="continue">Continue</button>
        </div>
      </div>
      
      <div class="football">
        
          <p class="image"><img src="https://i.ibb.co/s9ddGFt/Background-illustration-of-a-soccer-field.jpg" alt="Fantasy-Scotland" class="image" ></p>
          <div class="side-line text-center">
            <h1 class = "text-center">SIDE LINE SIDE LINE SIDE LINE SIDE</h1>
          </div>

          <div class="one">
            <a data-target="#menuModal" role="button" class="btn" data-toggle="modal" id="button1" onclick="setPosition(1); document.getElementById('table').appendChild(loadTable(players[1]));">1</a>
            </br>
            <p id="button1Text">LName<span class="badge badge-dark" id="button1Badge">0</span></p>
          </div>
          <div class="two">
            <a data-target="#menuModal" role="button" class="btn" data-toggle="modal" id="button2" onclick="setPosition(2); document.getElementById('table').appendChild(loadTable(players[3]));">2</a>
            </br>
            <p id="button2Text">LName<span class="badge badge-dark" id="button2Badge">0</span></p>
          </div>
          <div class="three">
            <a data-target="#menuModal" role="button" class="btn" data-toggle="modal" id="button3" onclick="setPosition(3); document.getElementById('table').appendChild(loadTable(players[3]));">3</a>
            </br>
            <p id="button3Text">LName<span class="badge badge-dark" id="button3Badge">0</span></p>
          </div>
          <div class="four">
            <a data-target="#menuModal" role="button" class="btn" data-toggle="modal" id="button4" onclick="setPosition(4); document.getElementById('table').appendChild(loadTable(players[3]));">4</a>
            </br>
            <p id="button4Text">LName<span class="badge badge-dark" id="button4Badge">0</span></p>
          </div>
          <div class="five">
            <a data-target="#menuModal" role="button" class="btn" data-toggle="modal" id="button5" onclick="setPosition(5); document.getElementById('table').appendChild(loadTable(players[3]));">5</a>
            </br>
            <p id="button5Text">LName<span class="badge badge-dark" id="button5Badge">0</span></p>
          </div>
          <div class="six">
            <a data-target="#menuModal" role="button" class="btn" data-toggle="modal" id="button6" onclick="setPosition(6); document.getElementById('table').appendChild(loadTable(players[5]));">6</a>
            </br>
            <p id="button6Text">LName<span class="badge badge-dark" id="button6Badge">0</span></p>
          </div>
          <div class="seven">
            <a data-target="#menuModal" role="button" class="btn" data-toggle="modal" id="button7" onclick="setPosition(7); document.getElementById('table').appendChild(loadTable(players[7]));">7</a>
            </br>
            <p id="button7Text">LName<span class="badge badge-dark" id="button7Badge">0</span></p>
          </div>
          <div class="eight">
            <a data-target="#menuModal" role="button" class="btn" data-toggle="modal" id="button8" onclick="setPosition(8); document.getElementById('table').appendChild(loadTable(players[5]));">8</a>
            </br>
            <p id="button8Text">LName<span class="badge badge-dark" id="button8Badge">0</span></p>
          </div>
          <div class="nine">
            <a data-target="#menuModal" role="button" class="btn" data-toggle="modal" id="button9" onclick="setPosition(9); document.getElementById('table').appendChild(loadTable(players[7]));">9</a>
            </br>
            <p id="button9Text">LName<span class="badge badge-dark" id="button9Badge">0</span></p>
          </div>
          <div class="ten">
            <a data-target="#menuModal" role="button" class="btn" data-toggle="modal" id="button10" onclick="setPosition(10); document.getElementById('table').appendChild(loadTable(players[5]));">10</a>
            </br>
            <p id="button10Text">LName<span class="badge badge-dark" id="button10Badge">0</span></p>
          </div>
          <div class="eleven">
            <a data-target="#menuModal" role="button" class="btn" data-toggle="modal" id="button11" onclick="setPosition(11); document.getElementById('table').appendChild(loadTable(players[5]));">11</a>
            </br>
            <p id="button11Text">LName<span class="badge badge-dark" id="button11Badge">0</span></p>
          </div>
          <div class="twelve">
            <a data-target="#menuModal" role="button" class="btn" data-toggle="modal" id="button12" onclick="setPosition(12); document.getElementById('table').appendChild(loadTable(players[0]));">12</a>
            </br>
            <p id="button12Text">LName<span class="badge badge-dark" id="button12Badge">0</span></p>
          </div>
          <div class="thirteen">
            <a data-target="#menuModal" role="button" class="btn" data-toggle="modal" id="button13" onclick="setPosition(13); document.getElementById('table').appendChild(loadTable(players[2]));">13</a>
            </br>
            <p id="button13Text">LName<span class="badge badge-dark" id="button13Badge">0</span></p>
          </div>
          <div class="fourteen">
            <a data-target="#menuModal" role="button" class="btn" data-toggle="modal" id="button14" onclick="setPosition(14); document.getElementById('table').appendChild(loadTable(players[4]));">14</a>
            </br>
            <p id="button14Text">LName<span class="badge badge-dark" id="button14Badge">0</span></p>
          </div>
          <div class="fifteen">
            <a data-target="#menuModal" role="button" class="btn" data-toggle="modal" id="button15" onclick="setPosition(15); document.getElementById('table').appendChild(loadTable(players[6]));">15</a>
            </br>
            <p id="button15Text">LName<span class="badge badge-dark" id="button15Badge">0</span></p>
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

  <div class="modal hide" id="selectModal" tabindex="2" role="dialog" aria-labelledby="selectModalLabel" aria-hidden="true">

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

  <div class="modal hide" id="menuModal" tabindex="1" role="dialog" aria-labelledby="menuModalLabel" aria-hidden="true">

      <div class="modal-header">
        <h3 id="menuModalLabel">Please select an option.</h3>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
          </button>
      </div>

      <div class="modal-body">
        <button type="button" class="btn btn-primary mb-2" onclick="setCaptain(position)" data-dismiss="modal">Make Captain</button>
        <button type="button" style="float: right;" data-target="#selectModal" data-toggle="modal" class="btn btn-success" id="subButton">Sub Player</button>
      </div>

      
  </div>


  <div class="modal hide" id="confirmModal" tabindex="-1" role="dialog" aria-labelledby="confirmModalLabel" aria-hidden="true">

      <div class="modal-header">
        <h3 id="confirmModalLabel">Confirm Changes.</h3>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
          </button>
      </div>

      <form onsubmit="manageTeam();return false" class="form-inline">
        <div class="form-group mb-2">
          <div class="form-group mx-sm-3 mb-2">
            <p>Are you sure you want to make these changes?</p>
          <button type="submit" class="btn btn-primary mb-2">Make Changes</button>
      </form>
    </div>
  </div>


  <script type="text/javascript">
      // Method that is called on page load
      function initalize() {
        isUserSignedIn();
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
          goalkeepersSub = [],
          defenders = [],
          defendersSub = [],
          midfielders = [],
          midfieldersSub = [],
          forwards = [],
          forwardsSub = [],
      ];
      var user;
      var clubs = [];
      var position;
      var clubLimit = false;
      var dupPlayer = false;
      var changes = 0;

      function isUserSignedIn(){
         // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "http://localhost:7777/fantasyscotland/userSignedIn"); // Request type and URL
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }

        // CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
        // to do when the response arrives 
        xhr.onload = function(e) {
          if(xhr.response == "false"){
            alert("You are not logged in. Redirecting...")
            window.location.href = '/fantasyscotland';
          }
          else{
            isRoundRunning().call;
          }
          
        }
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();  
      }

      function isRoundRunning(){
         // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "http://localhost:7777/fantasyscotland/isRoundRunning"); // Request type and URL
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }

        // CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
        // to do when the response arrives 
        xhr.onload = function(e) {
          if(xhr.response == "true"){
            alert("Round is currently in progress, you cant make transfers. Redirecting...")
            window.location.href = '/fantasyscotland/home';
          }
          else{
             buildClubs().call;
          }
          
        }
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();  
      }

      function swapPlayers(player_id, position){
        // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "http://localhost:7777/fantasyscotland/swapPlayers?Id="+player_id+"&Pos="+position); // Request type and URL
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }

        // CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
        // to do when the response arrives 
        xhr.onload = function(e) {
          var responseText = xhr.response.replace(/['"]+/g, '');
          changes++;
          document.getElementById("successText").innerHTML = responseText;
          document.getElementById("successText").style.display = "block";
          buildUser().call;
        }
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();  
      }

       function manageTeam() {
        // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "http://localhost:7777/fantasyscotland/manageTeam"); // Request type and URL+parameters
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }
        // CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
        // to do when the response arrives 
        xhr.onload = function(e) {
          window.location.href = '/fantasyscotland/home';
         // return false;
        };
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();   
      }

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
      
      function buildSquad() {
           players = [
            goalkeepers = [],
            goalkeepersSub = [],
            defenders = [],
            defendersSub = [],
            midfielders = [],
            midfieldersSub = [],
            forwards = [],
            forwardsSub = [],
            ];
          var length = Object.keys(user.team.squad).length;
          for(var i = 1; i <= length; i++){
            if(i == 1){
              var obj = user.team.squad[i]
              players[0].push(obj);
            }
            else if(i == 12){
              var obj = user.team.squad[i]
              players[1].push(obj);
            }
            else if(i == 2 || i == 3 || i == 4 || i ==5){
              var obj = user.team.squad[i]
              players[2].push(obj);
            }
            else if(i == 13){
              var obj = user.team.squad[i]
              players[3].push(obj);
            }
            else if(i == 11 || i == 10 || i == 6 || i ==8){
              var obj = user.team.squad[i]
              players[4].push(obj);
            }
            else if(i == 14){
              var obj = user.team.squad[i]
              players[5].push(obj);
            }
            else if(i == 9 || i == 7){
              var obj = user.team.squad[i]
              players[6].push(obj);
            }
            else if(i == 15){
              var obj = user.team.squad[i]
              players[7].push(obj);
            }
          }
          repaint().call;
      }

      function loadTeam() {
        // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "http://localhost:7777/fantasyscotland/loadTeam"); // Request type and URL
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }

        // CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
        // to do when the response arrives 
        xhr.onload = function(e) {
          buildUser().call;
        }
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();   
      }

      function setCaptain(position){
       // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "http://localhost:7777/fantasyscotland/setCaptain?Pos="+position); // Request type and URL+parameters
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }
        // CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
        // to do when the response arrives 
        xhr.onload = function(e) {
          changes++;
          buildUser().call;
        };
        
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
          document.getElementById("welcomeHeader").innerHTML = "Welcome " + fields[0] + "!";
          buildSquad().call;
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
          loadTeam().call;
        }
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();   
      }

      function repaint(){
        if(changes >= "1"){
          document.getElementById("continue").style.display = "block";
          document.getElementById("removeTransfer").style.display = "block";
        }
        else{
          document.getElementById("removeTransfer").style.display = "none";
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
          if(user.team.captain === user.team.squad[i].player_id){
            button.style.border = "medium solid #FFFF00"
          }
          else{
            button.style.border = "thin solid black"
          }
          var names = (user.team.squad[i].name).split(' ');
          document.getElementById("button"+i+"Text").firstChild.nodeValue = names[names.length-1];
          document.getElementById("button"+i+"Badge").innerHTML = user.team.squad[i].price;
        }
      }
      
      function signOut(){
         // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "http://localhost:7777/fantasyscotland/signOut"); // Request type and URL
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }

        // CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
        // to do when the response arrives 
        xhr.onload = function(e) {
            window.location.href = '/fantasyscotland';
        }
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();  
      }

      function removeChanges(){
        changes = 0;
        document.getElementById("errorText").style.display = "none";
        document.getElementById("successText").style.display = "none";
        loadTeam().call;
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

       function convertClub(id){
      for(var i = 0; i < clubs.length; i++){
        if(clubs[i].club_id === id){
          return clubs[i].name;
        }
      }
    }

      jQuery(document).ready(function($) {
          $('#table').on('click', '.clickable-row', function() {
              swapPlayers($(this).attr('value'), position);
              var $item = $(this).closest("tr") 
                       .find(".price")     // Gets a descendent with class="price"
                       .text();         // Retrieves the text within <td>
              $("#selectModal").modal('hide');
               $("#menuModal").modal('hide');
          });
      });

      $(document).ready(function () {

    $('#openBtn').click(function () {
        $('#myModal').modal({
            show: true
        })
    });

    $(document).on('show.bs.modal', '.modal', function (event) {
        var zIndex = 1040 + (10 * $('.modal:visible').length);
        $(this).css('z-index', zIndex);
        setTimeout(function() {
            $('.modal-backdrop').not('.modal-stack').css('z-index', zIndex - 1).addClass('modal-stack');
        }, 0);
    });

    $('#selectModal').on('shown.bs.modal', function (e) {
    $('#table-body').scrollTop(0);
      });
    });
    </script>     
</body>
</html>