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
        <h2 class="form-signin-heading text-center">Welcome to Fantasy Scotland!</h2>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
          <div class="navbar-nav">
            <a class="nav-item nav-link text-right" href="#">Manage</a>
            <a class="nav-item nav-link text-right" href="#">Leagues</a>
            <a class="nav-item nav-link text-right" href="#">Transfer</a>
            <a class="nav-item nav-link text-right" href="#">Rules</a>
          </div>
        </div>
      </nav>
    <div class="main">
      <div class = "header">
        <h6 class="form-signin-heading text-right" id="welcomeHeader">Signed in: user</h6>
      </div>

      <div class="body">
      <div class="point-header text-center">
          <h1 class="" id=>Round 3 Starts: 24th Aug 12:00 Ends: 25th Aug 15:00</h1>
       </div>
      <div class="point-header text-center ">
        <h4>Points in Round 2</h4>
          <div class="container">
            <div class="row">
              <div class="col-sm border border-dark font-weight-bold">
                Your Score
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
              <div class="col-sm border border-dark">
                14
              </div>
              <div class="col-sm border border-dark">
                24
              </div>
              <div class="col-sm border border-dark">
                65
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
                  <tr>
                    <th>1</th>
                    <td>2</td>
                    <td>2</td>
                    <td>1</td>
                    <td>2</td>
                    <td>2</td>
                    <td>2</td>
                    <td>2</td>
                    <td>2</td>
                    <td>2</td>
                    <td>2</td>
                    <td>2</td>
                    <td>2</td>
                  </tr>
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
                  <td>Default</td>
                </tr>
                <tr>
                  <th>Budget</th>
                  <td>0</td>
                </tr>
                <tr>
                  <th>Captain</th>
                  <td>johncarter@mail.com</td>
                </tr>
                <tr>
                  <th>Global Position</th>
                  <td>6334</td>
                </tr>
                <tr>
                  <th>Total Points</th>
                  <td>123</td>
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
                  <tr>
                    <td>Default</td>
                    <td>v</td>
                    <td>Default</td>
                  </tr>
                  <tr>
                    <td>Default</td>
                    <td>v</td>
                    <td>Default</td>
                  </tr>
                  <tr>
                    <td>Default</td>
                    <td>v</td>
                    <td>Default</td>
                  </tr>
                  <tr>
                    <td>Default</td>
                    <td>v</td>
                    <td>Default</td>
                  </tr>
                  <tr>
                    <td>Default</td>
                    <td>v</td>
                    <td>Default</td>
                  </tr>
                  <tr>
                    <td>Default</td>
                    <td>v</td>
                    <td>Default</td>
                  </tr>
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
      var user;
      var clubs = [];
      var position;
      var fixtures = [];
      var history = [];

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
          loadTeam().call;
        }
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();   
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
          document.getElementById("welcomeHeader").innerHTML = "Signed in as: " + fields[0] + "!";
           alert(xhr.response);
           for(var i in user.team.squad){
              alert(user.team.squad[i].weeklyScores);
            // alert(user.team.squad[i].name);
            // alert(user.team.squad[i].position);
          }
          buildPointHistory().call;
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

      function buildPointHistory() {
        // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "http://localhost:7777/fantasyscotland/buildPointHistory"); // Request type and URL
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }

        // CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
        // to do when the response arrives 
        xhr.onload = function(e) {
          var response = JSON.parse(xhr.response); // the text of the response
          var keys = Object.keys(response);
          alert(xhr.response);
          alert(response [1] [1]);
          alert(keys[0]);
          var historytable = document.getElementById('history-table');
          var historybody = document.getElementById('history-body');
          historybody.innerHTML = "";
          alert(keys.length);
          for(var i = 0; i < keys.length; i++) {
              var tr = document.createElement('tr');

              var round = document.createElement('th');
              var rText = document.createTextNode(keys[i]);
              round.appendChild(rText);

              var gk = document.createElement('td');
              var gText = document.createTextNode(response [i+1] [1]);
              gk.appendChild(gText);

              var df1 = document.createElement('td');
              var df1Text = document.createTextNode(response [i+1] [2]);
              df1.appendChild(df1Text);

              var df2 = document.createElement('td');
              var df2Text = document.createTextNode(response [i+1] [3]);
              df2.appendChild(df2Text);

              var df3 = document.createElement('td');
              var df3Text = document.createTextNode(response [i+1] [4]);
              df3.appendChild(df3Text);

              var df4 = document.createElement('td');
              var df4Text = document.createTextNode(response [i+1] [5]);
              df4.appendChild(df4Text);

              var mf1 = document.createElement('td');
              var mf1Text = document.createTextNode(response [i+1] [6]);
              mf1.appendChild(mf1Text);

              var mf2 = document.createElement('td');
              var mf2Text = document.createTextNode(response [i+1] [7]);
              mf2.appendChild(mf2Text);

              var mf3 = document.createElement('td');
              var mf3Text = document.createTextNode(response [i+1] [8]);
              mf3.appendChild(mf3Text);

              var mf4 = document.createElement('td');
              var mf4Text = document.createTextNode(response [i+1] [9]);
              mf4.appendChild(mf4Text);

              var fw1 = document.createElement('td');
              var fw1Text = document.createTextNode(response [i+1] [10]);
              fw1.appendChild(fw1Text);

              var fw2 = document.createElement('td');
              var fw2Text = document.createTextNode(response [i+1] [11]);
              fw2.appendChild(fw2Text);

              var tot = ((response [i+1] [1]) + (response [i+1] [2]) + (response [i+1] [3]) + (response [i+1] [4]) + (response [i+1] [5]) + (response [i+1] [6]) + (response [i+1] [7]) + (response [i+1] [8]) + (response [i+1] [9]) + (response [i+1] [10]) + (response [i+1] [11]))
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
          buildNextFixtures().call;
        }
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();   
      }

      function buildNextFixtures() {
        // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "http://localhost:7777/fantasyscotland/buildNextFixtures"); // Request type and URL
        
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
           // Finally, return the constructed list:
          repaint().call;
        }
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();   
      }
      
      function repaint(){
        document.getElementById("budgetBadge").innerHTML = user.team.transferBudget;
        var length = Object.keys(user.team.squad).length;
        document.getElementById('fixture-table').appendChild(loadTable(fixtures));
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
        document.getElementById('fixture-table').appendChild(loadTable(fixtures));
      }
      
      function convertClub(id){
        for(var i = 0; i < clubs.length; i++){
          if(clubs[i].club_id === id){
            return clubs[i].name;
          }
        }
      }

      const dateFormat = /^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}Z$/;

      function reviver(key, value) {
        if (typeof value === "string" && dateFormat.test(value)) {
        return new Date(value);
        }

        return value;
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