<!DOCTYPE html>
<html lang="en">
<!-- This is the view the users have when they wish to make a transfer for their team and swap out one of their existing players and bring in a new one to fill the same position.-->
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Transfer</title>
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

/* The form css is adapted from boostrap 4 and this video: https://youtu.be/Q16slwMglFI*/
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
/*-----------------------------------------------------------------------------------------*/
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
/*The football pitch graphic with the button and text overlays*/
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

/* Buttons representing players positions in a 4-4-2 formation with 4 subs */
.football .btn {
  position:fixed;
  background-color: white;
  color: black;
  font-size: 16px;
  font-weight: bold;
  border: solid;
  border-width:thin;
  cursor: pointer;
  border-radius: 50%;
  border-color: black;
  margin: 0px 0px;
  text-align: center;
}

.btn:hover {
  background-color: black;
}

/*Football image from https://www.vecteezy.com/vector-art/234128-soccer-field-background*/
.image{
  width: 100%;
  text-align: center;
}

/* Positional CSS for the 15 player buttons, price badges and name text. All positioned absolutely on the football pitch graphic */
.one{
  position: absolute;
  top: 32.5%;
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
  top: 5%;
  left:30%;
  line-height:2;
  max-width:110px;
  text-align: center;
}
.four{
  position: absolute;
  top: 45%;
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
  top: 45%;
  left:50%;
  line-height:2;
  max-width:110px;
  text-align: center;
}
.seven{
  position: absolute;
  top: 45%;
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
  top: 25%;
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
  top: 5%;
  left:50%;
  line-height:2;
  max-width:110px;
  text-align: center;
}
.twelve{
  position: absolute;
  top: 57.5%;
  left:10%;
  line-height:2;
  max-width:110px;
  text-align: center;
}
.thirteen{
  position: absolute;
  top: 85%;
  left:30%;
  line-height:2;
  max-width:110px;
  text-align: center;
}
.fourteen{
  position: absolute;
  top: 85%;
  left:50%;
  line-height:2;
  max-width:110px;
  text-align: center;
}
.fifteen{
  position: absolute;
  top: 65%;
  right:20%;
  line-height:2;
  max-width:110px;
  text-align: center;
}
/*---------------------------------------------------------------------------------------------*/

/*CSS for modal adpated from bootstrap 4 https://getbootstrap.com/docs/4.0/components/modal/*/
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

/*Nested table for selecting players, nested inside modal*/
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
thead th {
    width: 32.0%;
    height: 60px;
    float: left;
}
tbody td {
    width: 33.2%;
    height: 60px;
    float: left;
}
/*--------------------------------------------------------*/
/*Navbar CSS adapted from boostrap 4 https://getbootstrap.com/docs/4.0/components/navbar/*/
/*Height modfication CSS apadted and modified from https://bootstrapious.com/p/how-to-change-bootstrap-navbar-height*/
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
/*--------------------------------------------------------*/
</style>
</head>

<body onload="initalize()">
  <div class="wrapper">
    <!--Nav bar with nested logo hosted remotely.-->
    <nav class="navbar fixed-top navbar-light" style="background-color: #8eb7de;">
        <a class="navbar-brand" id="logo" href='/fantasyscotland/home'><img src="https://i.ibb.co/yVc3vPy/Fantasy-Scotland.png" alt="Fantasy-Scotland" width="200" ></a>
        <h1 class="form-signin-heading text-center ">Transfer Players</h1>
        <!--Button for opening menu to other views-->
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
          <div class="navbar-nav">
            <a class="nav-item nav-link text-right" href='/fantasyscotland/manage'>Manage</a>
            <a class="nav-item nav-link text-right" href='/fantasyscotland/leagues'>Leaderboard</a>
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
        <h4 class="form-signin-heading text-center">You can make one transfer per week.</h4>
        <!--Badge displays the remianing transfer budget of the team.-->
        <h4 class="form-signin-heading text-center">Remaining transfers: <span class="badge badge-secondary" id="transferBadge"></span></h4>
        <h4 class="form-signin-heading text-center">Remaining Budget: &pound<span class="badge badge-secondary" id="budgetBadge"></span> million.</h4>
      </div>
      <!--Success text indicates that there was no problem with adding or removing a player to the team-->
      <div class="alert alert-success text-center" id="successText" style="display:none;vertical-align: top">
         Sucess text
      </div>
      <!--Error text indicates that there was a problem with adding or removing a player to the team, stuff like duplicate player, more than 3 players from same club...-->
      <div class="alert alert-danger text-center" id="errorText" style="display:none;vertical-align: top">
         Danger text
      </div>
      <!--Buttons for removing changes and continuing once the team has been filled correctly-->
      <div class="col-md-12 text-center">
        <div class = "btn-group" >
        <button type="button" class="btn btn-danger" id="removeTransfer" onclick="removeChanges()" style="display:none">Remove Transfer</button>
        <button type="button" style="float: right;display:none" data-target="#confirmModal" data-toggle="modal" class="btn btn-success" id="continue">Continue</button>
        </div>
      </div>
      
       <!--This div holds the football image and all the overlayed player buttons. When each player button is pressed, depending on the button that is pressed, a different array for each of the player categories is appended to the modal table.-->
      <div class="football">
          <p class="image"><img src="https://i.ibb.co/s9ddGFt/Background-illustration-of-a-soccer-field.jpg" alt="Fantasy-Scotland" class="image" ></p>
          <div class="one">
            <a data-target="#selectModal" role="button" class="btn" data-toggle="modal" id="button1" onclick="setPosition(1); document.getElementById('table').appendChild(loadTable(players[0]));">1</a>
            </br>
            <h7 id="button1Text">LName<span class="badge badge-dark" id="button1Badge">0</span></h7>
          </div>
          <div class="two">
            <a data-target="#selectModal" role="button" class="btn" data-toggle="modal" id="button2" onclick="setPosition(2); document.getElementById('table').appendChild(loadTable(players[1]));">2</a>
            </br>
            <h7 id="button2Text">LName<span class="badge badge-dark" id="button2Badge">0</span></h7>
          </div>
          <div class="three">
            <a data-target="#selectModal" role="button" class="btn" data-toggle="modal" id="button3" onclick="setPosition(3); document.getElementById('table').appendChild(loadTable(players[1]));">3</a>
            </br>
            <h7 id="button3Text">LName<span class="badge badge-dark" id="button3Badge">0</span></h7>
          </div>
          <div class="four">
            <a data-target="#selectModal" role="button" class="btn" data-toggle="modal" id="button4" onclick="setPosition(4); document.getElementById('table').appendChild(loadTable(players[1]));">4</a>
            </br>
            <h7 id="button4Text">LName<span class="badge badge-dark" id="button4Badge">0</span></h7>
          </div>
          <div class="five">
            <a data-target="#selectModal" role="button" class="btn" data-toggle="modal" id="button5" onclick="setPosition(5); document.getElementById('table').appendChild(loadTable(players[1]));">5</a>
            </br>
            <h7 id="button5Text">LName<span class="badge badge-dark" id="button5Badge">0</span></h7>
          </div>
          <div class="six">
            <a data-target="#selectModal" role="button" class="btn" data-toggle="modal" id="button6" onclick="setPosition(6); document.getElementById('table').appendChild(loadTable(players[2]));">6</a>
            </br>
            <h7 id="button6Text">LName<span class="badge badge-dark" id="button6Badge">0</span></h7>
          </div>
          <div class="seven">
            <a data-target="#selectModal" role="button" class="btn" data-toggle="modal" id="button7" onclick="setPosition(7); document.getElementById('table').appendChild(loadTable(players[3]));">7</a>
            </br>
            <h7 id="button7Text">LName<span class="badge badge-dark" id="button7Badge">0</span></h7>
          </div>
          <div class="eight">
            <a data-target="#selectModal" role="button" class="btn" data-toggle="modal" id="button8" onclick="setPosition(8); document.getElementById('table').appendChild(loadTable(players[2]));">8</a>
            </br>
            <h7 id="button8Text">LName<span class="badge badge-dark" id="button8Badge">0</span></h7>
          </div>
          <div class="nine">
            <a data-target="#selectModal" role="button" class="btn" data-toggle="modal" id="button9" onclick="setPosition(9); document.getElementById('table').appendChild(loadTable(players[3]));">9</a>
            </br>
            <h7 id="button9Text">LName<span class="badge badge-dark" id="button9Badge">0</span></h7>
          </div>
          <div class="ten">
            <a data-target="#selectModal" role="button" class="btn" data-toggle="modal" id="button10" onclick="setPosition(10); document.getElementById('table').appendChild(loadTable(players[2]));">10</a>
            </br>
            <h7 id="button10Text">LName<span class="badge badge-dark" id="button10Badge">0</span></h7>
          </div>
          <div class="eleven">
            <a data-target="#selectModal" role="button" class="btn" data-toggle="modal" id="button11" onclick="setPosition(11); document.getElementById('table').appendChild(loadTable(players[2]));">11</a>
            </br>
            <h7 id="button11Text">LName<span class="badge badge-dark" id="button11Badge">0</span></h7>
          </div>
          <div class="twelve">
            <a data-target="#selectModal" role="button" class="btn" data-toggle="modal" id="button12" onclick="setPosition(12); document.getElementById('table').appendChild(loadTable(players[0]));">12</a>
            </br>
            <h7 id="button12Text">LName<span class="badge badge-dark" id="button12Badge">0</span></h7>
          </div>
          <div class="thirteen">
            <a data-target="#selectModal" role="button" class="btn" data-toggle="modal" id="button13" onclick="setPosition(13); document.getElementById('table').appendChild(loadTable(players[1]));">13</a>
            </br>
            <h7 id="button13Text">LName<span class="badge badge-dark" id="button13Badge">0</span></h7>
          </div>
          <div class="fourteen">
            <a data-target="#selectModal" role="button" class="btn" data-toggle="modal" id="button14" onclick="setPosition(14); document.getElementById('table').appendChild(loadTable(players[2]));">14</a>
            </br>
            <h7 id="button14Text">LName<span class="badge badge-dark" id="button14Badge">0</span></h7>
          </div>
          <div class="fifteen">
            <a data-target="#selectModal" role="button" class="btn" data-toggle="modal" id="button15" onclick="setPosition(15); document.getElementById('table').appendChild(loadTable(players[3]));">15</a>
            </br>
            <h7 id="button15Text">LName<span class="badge badge-dark" id="button15Badge">0</span></h7>
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

  <!--Primary Modal with nested table for selecting players.-->
  <div class="modal hide" id="selectModal" tabindex="-1" role="dialog" aria-labelledby="selectModalLabel" aria-hidden="true">
      <div class="modal-header">
        <h3 id="selectModalLabel">Select Player</h3>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
          </button>
      </div>
      <div class="modal-body">
        <!--Nested table.-->
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
          <!--Table body is empty and is appended with an array when the users clicks on of the 15 buttons.-->
          <tbody id="table-body">
          </tbody>
      </table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn-primary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>

  <!--A secondary modal for confirming all changes to the team.-->
  <div class="modal hide" id="confirmModal" tabindex="-1" role="dialog" aria-labelledby="confirmModalLabel" aria-hidden="true">
      <div class="modal-header">
        <h3 id="confirmModalLabel">Confirm Transfer.</h3>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
          </button>
      </div>
      <form onsubmit="updateTeam();return false" class="form-inline">
        <div class="form-group mb-2">
          <div class="form-group mx-sm-3 mb-2">
            <p>Are you sure you want to make this transfer?</p>
          <button type="submit" class="btn btn-primary mb-2">Make Transfer</button>
      </form>
    </div>
  </div>


  <script type="text/javascript">
      // Method that is called on page load
      function initalize() {
        isUserSignedIn();//first check to see user has been authenticated and hasnt randomly landed on the page.
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
      var players = [ //differnt nested arrays for each of the player categories
          goalkeepers = [],
          defenders = [],
          midfielders = [],
          forwards = [],
      ];
      var user;
      var clubs = []; //array to hold all the clubs
      var position;//position variable holds the value of the position the player has just pressed the button for
      var clubLimit = false; //default false as team already validated
      var dupPlayer = false;
      var changes = 1; //varaible to hold the number of changes allowed by the user, 1 per round

      function isUserSignedIn(){
         // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "http://localhost:7777/fantasyscotland/userSignedIn"); // Request type and URL
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }

        //When the response arrives... 
        xhr.onload = function(e) {
          if(xhr.response == "false"){ //If no user is signed in and session has no id attribute
            alert("You are not logged in. Redirecting...")
            window.location.href = '/fantasyscotland'; //redirect to login page
          }
          else{
            isRoundRunning().call; //if user is logged in, check if round is currently in play
          }
        }
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();  
      }

      //If fixtures are being played and the current date is during the simualted period of the round, transfer activity is not premitted and the user should be directed away from the transfer screen.
      function isRoundRunning(){
         // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "http://localhost:7777/fantasyscotland/isRoundRunning"); // Request type and URL
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }

        //When the response arrives...  
        xhr.onload = function(e) {
          if(xhr.response == "true"){ //If round is running
            alert("Round is currently in progress, you cant make transfers. Redirecting...")
            window.location.href = '/fantasyscotland/home'; //redirect user to home page
          }
          else{
            isTransferOn().call; //If round isnt running, check if team has transfer credit available and that they have not already used their credit for the rounnd.
          }
          
        }
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();  
      }

      //Check to see if team has used their transfer credit by checkjing the database
      function isTransferOn(){
         // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "http://localhost:7777/fantasyscotland/isTransferOn"); // Request type and URL
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }

        //When the response arrives... 
        xhr.onload = function(e) {
          if(xhr.response == "false"){ //if team has used their transfer credit
            alert("You have no remaining transfers. Redirecting...")
            window.location.href = '/fantasyscotland/home'; //redirect home
          }
          else{
            buildClubs().call;//load the clubs
          }
          
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

        //When the response arrives...  
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

      //This function loads all of the players from the database, and splits them into serperate arrays depending on their playing position.
      function buildPlayers() {
        // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "http://localhost:7777/fantasyscotland/buildPlayers"); // Request type and URL
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }

        //When the response arrives... 
        xhr.onload = function(e) {
          var response = JSON.parse(xhr.response); // the text of the response
          players = [ //Empty the arrays
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
          loadTeam().call; //load team into user object
        }
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();   
      }

      //This method is called before loading the user profile in order to search the database for the user's team and attach it to the user profile in the model before being loaded into the view.
      function loadTeam() {
        // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "http://localhost:7777/fantasyscotland/loadTeam"); // Request type and URL
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }

        //When the response arrives... 
        xhr.onload = function(e) {
          buildUser().call; //load in user profile and team
        }
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();   
      }

      //This method is called when a user has made a change, it decrements the changes variable and calls the function to remove the player from the squad
       function swapPlayer(player_id, position){
        changes--;
        removePlayer(player_id, position);
      }

      function addPlayer(player_id, position) {
        // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "http://localhost:7777/fantasyscotland/addPlayer?Id="+player_id+"&Pos="+position); // Request type and URL+parameters
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }

        //When the response arrives... 
        xhr.onload = function(e) {
          var responseText = xhr.response.replace(/['"]+/g, '');
          if(responseText.localeCompare("Successfully added player.") === 0){//If player was successfully added
            document.getElementById("successText").innerHTML = "Successfully swaped player.";//display success
            document.getElementById("successText").style.display = "block";
            document.getElementById("errorText").style.display = "none";
          } else {
            document.getElementById("errorText").innerHTML = responseText;//display error
            document.getElementById("errorText").style.display = "block";
            document.getElementById("successText").style.display = "none";
          }
          var button = document.getElementById("button"+position);
          clubLimitReached().call;
        };
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();   
      }
      
      //This method is called to remove a player from a postion and call another function to fill it with a different player object.
      function removePlayer(player_id, position) {
        // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "http://localhost:7777/fantasyscotland/removePlayer?Pos="+position); // Request type and URL+parameters
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }

        //When the response arrives... 
        xhr.onload = function(e) {
          addPlayer(player_id, position).call; //add player to vacant position
        };
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();   
      }

      function clubLimitReached() {
        // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "http://localhost:7777/fantasyscotland/clubLimitReached"); // Request type and URL+parameters
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }
        
        //When the response arrives... 
        xhr.onload = function(e) {
          if(xhr.response == "false"){ //If three player from one club limit not reached
          clubLimit = false;
          }else{
            clubLimit = true;
          } 
          doesDuplicateExist().call; //check if same player exists in squad more than once
        };
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();   
      }
      
      function doesDuplicateExist() {
        // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "http://localhost:7777/fantasyscotland/duplicateExists"); // Request type and URL+parameters
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }

        //When the response arrives... 
        xhr.onload = function(e) {
          if(xhr.response == "false"){ //If same player exists in squad more than once
            dupPlayer = false;
          }else{
            dupPlayer = true;
          } 
          buildUser().call; //Load user and team again
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

        //When the response arrives...  
        xhr.onload = function(e) {
          user = JSON.parse(xhr.response);
          var fields = user.email.split('@');
          document.getElementById("welcomeHeader").innerHTML = "Welcome " + fields[0] + "!";
          repaint().call; //refresh view
        }
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();   
      }

      //This function is called when the user has finished making changes to their team. It makes calls to the database to update the existing data with new values.
       function updateTeam() {
        // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "http://localhost:7777/fantasyscotland/updateTeam"); // Request type and URL+parameters
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }

        //When the response arrives... 
        xhr.onload = function(e) {
          window.location.href = '/fantasyscotland/home'; //redirect user to home page
         // return false;
        };
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();   
      }

      //Called when the user presses the sign out button, removes all id and email attributes from the session and redirects user to login page.
      function signOut(){
         // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "http://localhost:7777/fantasyscotland/signOut"); // Request type and URL
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }

        //When the response arrives... 
        xhr.onload = function(e) {
            window.location.href = '/fantasyscotland'; //redirect to login page
        }
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();  
      }

      //-------------------Local functions---------------------------------

      //Resets all the changes made by the user and reloads unmodified team object from database.
      function removeChanges(){
        changes = 1;
        document.getElementById("errorText").style.display = "none";
        document.getElementById("successText").style.display = "none";
        loadTeam().call;
      }

      //This function is called after new team data is loaded from the model. It refreshes the transfer budget, displays and blocks buttons, paints buttons and applies name and cost to positions that have been filled.
      function repaint(){
        
        document.getElementById("budgetBadge").innerHTML = user.team.transferBudget;//refresh transfer budget
        document.getElementById("transferBadge").innerHTML = changes; //refresh changes made
        
        //buttons display and block
        var length = Object.keys(user.team.squad).length;
        if(changes == "0"){
          document.getElementById("removeTransfer").style.display = "block";
          for(var x = 1;x<=15;x++){
            var button = document.getElementById("button"+x);
            button.disabled = true;
          } 
        }
        else{
          document.getElementById("removeTransfer").style.display = "none";
           for(var x = 1;x<=15;x++){
          var button = document.getElementById("button"+x);
          button.disabled = false;
          } 
        }
        if(length == "15" && user.team.transferBudget >= "0" && dupPlayer === false && clubLimit === false && changes == "0"){
          document.getElementById("continue").style.display = "block";
        }
        else{
          document.getElementById("continue").style.display = "none";
        }

        //set all buttons to default state
        for(var x = 1;x<=15;x++){
          var button = document.getElementById("button"+x);
          button.style.background = "rgb(255,255,255)";
          document.getElementById("button"+x+"Text").firstChild.nodeValue = "";
          document.getElementById("button"+x+"Badge").innerHTML = 0;
        }  

        //paint buttons the colour of the players club using helper method, add players names and cost.
        for(var i in user.team.squad){
          var button = document.getElementById("button"+i);
          button.style.background = buttonPainter(user.team.squad[i].club_id);
          if(user.team.captain === user.team.squad[i].player_id){ //Identify the captain by outlining the button with thick yellow border
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

      //This function is called to appdend the nested table in the modal with a given array. It is adapted from https://stackoverflow.com/q/51421470
      function loadTable(array) {
          var table = document.getElementById('table-body');
        table.innerHTML = "";
          for(var i = 0; i < array.length; i++) {
              // Create the list item:
              var tr = document.createElement('tr');
              tr.setAttribute('value', array[i].player_id); //sets the value of the row to player's id 
              tr.setAttribute('class', "clickable-row"); //makes it clickable 
              tr.setAttribute('style', "cursor:pointer");
              var name = document.createElement('td'); //Player's name
              name.setAttribute('class', "name"); 
              var nText = document.createTextNode(array[i].name);
              name.appendChild(nText);
              var club = document.createElement('td'); //Player's club
              club.setAttribute('class', "club");
              var cText = document.createTextNode(convertClub(array[i].club_id));
              club.appendChild(cText);
              var price = document.createElement('td'); //Player's cost
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

      //This function uses the real patterns and hex colours of each of the clubs to return to the repaint method when refreshing the view.
      function buttonPainter(club){
        if(club === 45){ //Aberdeen
          return "rgb(226,0,26)";
        }
        else if(club === 54){ //Celtic
          return "linear-gradient(to bottom, rgb(1,135,73) 50%, white 50%)";
        }
        else if(club === 228){ //Hamilton Accies
          return "linear-gradient(to bottom, rgb(204,56,63) 50%, white 50%)";
        }
        else if(club === 50){ //Hearts 
          return "rgb(159,25,49)";
        }
        else if(club === 53){ //Hibs
          return "rgb(0,117,59)";
        }
        else if(club === 52){ //Kilmarnock
          return "linear-gradient(to right, rgb(47,54,143) 50%, white 50%)";
        }
        else if(club === 560){ //Livingston
          return "rgb(255,204,0)";
        }
        else if(club === 47){ //Motherwell
          return "linear-gradient(to bottom, rgb(251,186,45) 50%, rgb(122,20,63)  50%)";
        }
        else if(club === 49){ //Rangers
          return "rgb(27,69,143)";
        }
        else if(club === 360){ //Ross County
          return "linear-gradient(to bottom, rgb(4,9,87) 50%, rgb(244,19,43)  50%)";
        }
        else if(club === 46){ //St Johnstone
          return "linear-gradient(to bottom, rgb(36,63,144) 50%, white  50%)";
        }
        else if(club === 56){ //St Mirren
          return "linear-gradient(to right, black 50%, white 50%)";
        }
      }

      //Sets the position the user has just selected
      function setPosition(pos){
        position = pos; 
      }

      //Converts the club id of a player into the club name, this is why the clubs are loaded in at the beginning. The club name is displayed in the nested table.
      function convertClub(id){
        for(var i = 0; i < clubs.length; i++){
          if(clubs[i].club_id === id){
            return clubs[i].name;
          }
        }
      }

      //This function is taken from https://www.w3schools.com/howto/howto_js_sort_table.asp.
      //It is used for sorting the modal nested table when clciking each of the column headers. It is adapted slightly to accomadate both numerical and lexicographic sorting.
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

     //---------------------------------------------------------------------------------

     //jQuery for clicakble table rows that can run functions was adapted and modified from https://stackoverflow.com/a/17147973
      jQuery(document).ready(function($) {
          $('#table').on('click', '.clickable-row', function() {
              swapPlayer($(this).attr('value'), position);
              var $item = $(this).closest("tr") 
                       .find(".price")     // Gets a descendent with class="price"
                       .text();         // Retrieves the text within <td>
              $("#selectModal").modal('hide');
          });
      });

      //jQuery for reseting the scroll position to the top every time the modal is opened
      $('#selectModal').on('shown.bs.modal', function (e) {
        $('#table-body').scrollTop(0);
    });
    </script>     
</body>
</html>