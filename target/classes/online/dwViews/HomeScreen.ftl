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

.table-responsive-sm {
     display:table;
     margin-right:auto;
     margin-left:auto;
     width:100%;
}

th {
    white-space: nowrap;
}

td {
    white-space: nowrap;
}

.scroll{
  overflow:scroll;
  max-height:300px;
}


.container{
  max-width: 2000px;
  max-height: 900px;
  height: 100%;
  width:100%;
}

.border-bottom {
    white-space: nowrap;
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
        <h1 class="form-signin-heading text-center ">Welcome to Fantasy Scotland!</h1>
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
      <div class="point-header text-center">
          <h1 id="roundHeader"></h1>
       </div>
      <div class="point-header text-center ">
        <h4>Scores</h4>
          <div class="container">
            <div class="row">
              <div class="col-sm border border-dark font-weight-bold">
                Your Total Score
              </div>
              <div class="col-sm border border-dark font-weight-bold">
                Global Average
              </div>
              <div class="col-sm border border-dark font-weight-bold">
                Global Top
              </div>
              <div class="w-100"></div>
              <div class="container">
            <div class="row">
              <div class="col-sm border border-dark" id="your-score">
                
              </div>
              <div class="col-sm border border-dark" id="average-score">
                
              </div>
              <div class="col-sm border border-dark" id="top-score">
                
              </div>
            </div>
          </div>
       </div>
      <div class="container" id="main-container">
          <div class="row">
            <div class="col-lg border" >
              <div class="border-bottom ">
                <h4 class="text-center">Points History<h4>
              </div>
              <div class="scroll">
               <table class="table-responsive-sm" id="history-table">
                  <thead>
                <tr>
                  <th scope="col">Round</th>
                  <th scope="col">GK</th>
                    <th scope="col">DF1</th>
                    <th scope="col">DF2</th>
                    <th scope="col">DF3</th>
                    <th scope="col">DF4</th>
                    <th scope="col">MF1</th>
                    <th scope="col">MF2</th>
                    <th scope="col">MF3</th>
                    <th scope="col">MF4</th>
                    <th scope="col">FW1</th>
                    <th scope="col">FW2</th>
                    <th scope="col">Total</th>
                  </tr>
                </thead>
                <tbody id="history-body">
                </tbody>
              </table> 
            </div>
            </div>
             
             <div class="col-lg border" >
              <div class="border-bottom ">
             <h4 class="text-center">Team Overview<h4>
             </div>
             <table class="table-responsive-sm table-striped" id="team-table">
              <tbody>
                <tr>
                  <th>Team Name</th>
                  <td id="team-name"></td>
                </tr>
                <tr>
                  <th>Budget</th>
                  <td id="team-budget"></td>
                </tr>
                <tr>
                  <th>Captain</th>
                  <td id="team-captain"></td>
                </tr>
                <tr>
                  <th>Global Position</th>
                  <td id="global-rank"></td>
                </tr>
                <tr>
                  <th>Total Points</th>
                  <td id="total-points"></td>
                </tr>
            </tbody>
              
              </table>
            </div>
              
              <div class="col-lg border" >
                <div class="border-bottom">
                  <h4 class="text-center">Next Fixtures<h4>
                </div>
                <table class="table-responsive-sm table-striped" id="fixture-table">
                  <thead>
                <tr>
                  <th scope="col">Home Club</th>
                   <th scope="col"></th>
                    <th scope="col">Away Club</th>
                  </tr>
                </thead>
                <tbody id="fixture-body">
                </tbody>
              </table>
              </div>
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
          defenders = [],
          midfielders = [],
          forwards = [],
      ];
      var user;
      var clubs = [];
      var position;
      var fixtures = [];
      var history = [];
      var globalAverage;
      var globalMax;
      var teamTotal;
      var captain;
      var globalRank;
      var startDate;
      var endDate;
      var currentRound;

      function isUserSignedIn(){
         // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "https://stark-wave-35947.herokuapp.com/fantasyscotland/userSignedIn"); // Request type and URL
        
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
            buildPlayers().call;
          }
          
        }
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();  
      }

      function buildPlayers() {
        // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "https://stark-wave-35947.herokuapp.com/fantasyscotland/buildPlayers"); // Request type and URL
        
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
          loadTeam().call;
        }
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();   
      }

      function loadTeam() {
        // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "https://stark-wave-35947.herokuapp.com/fantasyscotland/loadTeam"); // Request type and URL
        
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

      function buildUser() {
        // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "https://stark-wave-35947.herokuapp.com/fantasyscotland/buildUser"); // Request type and URL
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }

        // CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
        // to do when the response arrives 
        xhr.onload = function(e) {
          user = JSON.parse(xhr.response);
          var fields = user.email.split('@');
          document.getElementById("welcomeHeader").innerHTML = "Signed in as: " + fields[0] + "!";
          buildNextFixtures().call;
        }
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();   
      }

      function buildNextFixtures() {
        // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "https://stark-wave-35947.herokuapp.com/fantasyscotland/buildNextFixtures"); // Request type and URL
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }

        // CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
        // to do when the response arrives 
        xhr.onload = function(e) {
          var response = JSON.parse(xhr.response); // the text of the response
          for(var i = 0; i < response.length; i++){
            fixtures.push(response[i]);
          }
          var fixturetable = document.getElementById('fixture-table');
          var fixturebody = document.getElementById('fixture-body');
          fixturebody.innerHTML = "";
          for(var i = 0; i < fixtures.length; i++) {
              // Create the list item:
              var tr = document.createElement('tr');

              var home = document.createElement('td');
              home.setAttribute('class', "home");
              var hText = document.createTextNode(fixtures[i].homeTeam);
              home.appendChild(hText);

              var versus = document.createElement('td');
              versus.setAttribute('class', "date");
              var vText = document.createTextNode("v");
              versus.appendChild(vText);

              var away = document.createElement('td');
              away.setAttribute('class', "away");
              var aText = document.createTextNode(fixtures[i].awayTeam);
              away.appendChild(aText);

              tr.appendChild(home);
              tr.appendChild(versus);
               tr.appendChild(away);
              // Add it to the list:
              fixturebody.appendChild(tr);
              fixturetable.appendChild(fixturebody);
          }
          buildGlobalMax().call;
           // Finally, return the constructed list:
        }
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();   
      }

       function buildGlobalMax() {
        // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "https://stark-wave-35947.herokuapp.com/fantasyscotland/getGlobalMax"); // Request type and URL
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }

        // CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
        // to do when the response arrives 
        xhr.onload = function(e) {
          var response = JSON.parse(xhr.response); // the text of the response
          globalMax = response;
          buildGlobalAvg().call;
           // Finally, return the constructed list:
        }
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();   
      }

       function buildGlobalAvg() {
        // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "https://stark-wave-35947.herokuapp.com/fantasyscotland/getGlobalAvg"); // Request type and URL
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }

        // CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
        // to do when the response arrives 
        xhr.onload = function(e) {
          var response = JSON.parse(xhr.response); // the text of the response
          globalAvg = response;
          buildTeamTotal().call;
           // Finally, return the constructed list:
        }
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();   
      }

       function buildTeamTotal() {
        // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "https://stark-wave-35947.herokuapp.com/fantasyscotland/getTeamTotal"); // Request type and URL
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }

        // CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
        // to do when the response arrives 
        xhr.onload = function(e) {
          var response = JSON.parse(xhr.response); // the text of the response
          teamTotal = response;
          getNameFrom(user.team.captain).call;
           // Finally, return the constructed list:
        }
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();   
      }

      function getNameFrom(id){
        // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "https://stark-wave-35947.herokuapp.com/fantasyscotland/getNameFrom?Id="+id); // Request type and URL
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }

        // CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
        // to do when the response arrives 
        xhr.onload = function(e) {
          var response = JSON.parse(xhr.response); // the text of the response
          captain = response;
          getGlobalRank().call;
        }
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();  
      }

       function getGlobalRank(){
        var id = '3573e359-7c59-4d43-90c9-52d3ba04a66e';
        // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "https://stark-wave-35947.herokuapp.com/fantasyscotland/getRankIn?Id="+id); // Request type and URL
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }

        // CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
        // to do when the response arrives 
        xhr.onload = function(e) {
          var response = JSON.parse(xhr.response); // the text of the response
          globalRank = response;
          getStartDate().call;
        }
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();  
      }

      function getStartDate(){
        // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "https://stark-wave-35947.herokuapp.com/fantasyscotland/getStartDate"); // Request type and URL
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }

        // CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
        // to do when the response arrives 
        xhr.onload = function(e) {
          var response = JSON.parse(xhr.response); // the text of the response
          startDate = response;
          var myNumber = startDate.minute;
          var formattedNumber = ("0" + myNumber).slice(-2);
          startDate.minute = formattedNumber;
          getEndDate().call;
        }
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();  
      }

      function getEndDate(){
        // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "https://stark-wave-35947.herokuapp.com/fantasyscotland/getEndDate"); // Request type and URL
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }

        // CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
        // to do when the response arrives 
        xhr.onload = function(e) {
          var response = JSON.parse(xhr.response); // the text of the response
          endDate = response;
          var myNumber = endDate.minute;
          var formattedNumber = ("0" + myNumber).slice(-2);
          endDate.minute = formattedNumber;
          getCurrentRound().call;
        }
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();  
      }

      function getCurrentRound(){
        // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "https://stark-wave-35947.herokuapp.com/fantasyscotland/getCurrentRound"); // Request type and URL
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }

        // CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
        // to do when the response arrives 
        xhr.onload = function(e) {
          var response = JSON.parse(xhr.response); // the text of the response
          currentRound = response;
          repaint().call;
        }
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();  
      }

      function repaint(){
        var length = Object.keys(user.team.squad).length;
        document.getElementById("average-score").innerHTML = globalAvg;
        document.getElementById("top-score").innerHTML = globalMax;
        document.getElementById("your-score").innerHTML = teamTotal;
        document.getElementById("team-name").innerHTML = user.team.name;
        document.getElementById("team-captain").innerHTML = captain;
        document.getElementById("total-points").innerHTML = teamTotal;
        document.getElementById("team-budget").innerHTML = "&#163 " + user.team.transferBudget + "million";
        document.getElementById("global-rank").innerHTML = globalRank;
        document.getElementById("roundHeader").innerHTML = "Round " + currentRound + " Starts: " + startDate.dayOfMonth + "/" + startDate.monthValue + " " + startDate.hour + ":" + startDate.minute + " Ends: " + endDate.dayOfMonth + "/" + endDate.monthValue + " " + (endDate.hour+5) + ":" + endDate.minute;
        buildPointHistory().call;
      }

      function buildPointHistory() {
        // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "https://stark-wave-35947.herokuapp.com/fantasyscotland/buildPointHistory"); // Request type and URL
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }

        // CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
        // to do when the response arrives 
        xhr.onload = function(e) {
          var historytable = document.getElementById('history-table');
          var historybody = document.getElementById('history-body');
          historybody.innerHTML = "";
          if(xhr.response == "null"){
            return;
            }
          var response = JSON.parse(xhr.response); // the text of the response
          var keys = Object.keys(response);
    		
          for(var i = 0; i < keys.length; i++) {
              var tr = document.createElement('tr');

              var round = document.createElement('th');
              var rText = document.createTextNode(keys[i]);
              round.appendChild(rText);

              var gk = document.createElement('td');
              var gText = document.createTextNode(response [keys[i]] [1]);
              gk.appendChild(gText);

              var df1 = document.createElement('td');
              var df1Text = document.createTextNode(response [keys[i]] [2]);
              df1.appendChild(df1Text);

              var df2 = document.createElement('td');
              var df2Text = document.createTextNode(response [keys[i]] [3]);
              df2.appendChild(df2Text);

              var df3 = document.createElement('td');
              var df3Text = document.createTextNode(response [keys[i]] [4]);
              df3.appendChild(df3Text);

              var df4 = document.createElement('td');
              var df4Text = document.createTextNode(response [keys[i]] [5]);
              df4.appendChild(df4Text);

              var mf1 = document.createElement('td');
              var mf1Text = document.createTextNode(response [keys[i]] [6]);
              mf1.appendChild(mf1Text);

              var mf2 = document.createElement('td');
              var mf2Text = document.createTextNode(response [keys[i]] [7]);
              mf2.appendChild(mf2Text);

              var mf3 = document.createElement('td');
              var mf3Text = document.createTextNode(response [keys[i]] [8]);
              mf3.appendChild(mf3Text);

              var mf4 = document.createElement('td');
              var mf4Text = document.createTextNode(response [keys[i]] [9]);
              mf4.appendChild(mf4Text);

              var fw1 = document.createElement('td');
              var fw1Text = document.createTextNode(response [keys[i]] [10]);
              fw1.appendChild(fw1Text);

              var fw2 = document.createElement('td');
              var fw2Text = document.createTextNode(response [keys[i]] [11]);
              fw2.appendChild(fw2Text);

              var tot = ((response [keys[i]] [1]) + (response [keys[i]] [2]) + (response [keys[i]] [3]) + (response [keys[i]] [4]) + (response [keys[i]] [5]) + (response [keys[i]] [6]) + (response [keys[i]] [7]) + (response [keys[i]] [8]) + (response [keys[i]] [9]) + (response [keys[i]] [10]) + (response [keys[i]] [11]))
              var total = document.createElement('td');
              var totalText = document.createTextNode(tot);
              total.appendChild(totalText);

              tr.appendChild(round);
              tr.appendChild(gk);
              tr.appendChild(df1);
              tr.appendChild(df2);
              tr.appendChild(df3);
              tr.appendChild(df4);
              tr.appendChild(mf1);
              tr.appendChild(mf2);
              tr.appendChild(mf3);
              tr.appendChild(mf4);
              tr.appendChild(fw1);
              tr.appendChild(fw2);
              tr.appendChild(total);
              historybody.appendChild(tr);
              historytable.appendChild(historybody);
          }
        }
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();   
      }

      function signOut(){
         // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "https://stark-wave-35947.herokuapp.com/fantasyscotland/signOut"); // Request type and URL
        
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

    </script>     
</body>
</html>