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
            <a class="nav-item nav-link text-right" href="#">Team</a>
            <a class="nav-item nav-link text-right" href="#">Leagues</a>
            <a class="nav-item nav-link text-right" href="#">Transfers</a>
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
          <h1 class="">Round 4 Starts: 25th Aug 15:00</h1>
       </div>
      <div class="point-header text-center ">
        <h4>Points in Round 3</h4>
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
                45
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
               <table class="table-responsive-sm">
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
                <tbody>
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
                  <tr>
                    <th scope="row">2</th>
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                  <tr>
                    <th scope="row">3</th>
                    <td></td>
                    <td></td>
                  </tr>
                  <tr>
                    <th scope="row">4</th>
                    <td></td>
                    <td></td>
                  </tr>
                  <tr>
                    <th scope="row">5</th>
                    <td></td>
                    <td></td>
                  </tr>
                  <tr>
                    <th scope="row">6</th>
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                  <tr>
                    <th scope="row">7</th>
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                  <tr>
                    <th scope="row">8</th>
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                  <tr>
                    <th scope="row">9</th>
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                  <tr>
                    <th scope="row">10</th>
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                  <tr>
                    <th scope="row">11</th>
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                  <tr>
                    <th scope="row">12</th>
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                  <tr>
                    <th scope="row">13</th>
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                  <tr>
                    <th scope="row">14</th>
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                  <tr>
                    <th scope="row">15</th>
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                  <tr>
                    <th scope="row">16</th>
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                  <tr>
                    <th scope="row">17</th>
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                  <tr>
                    <th scope="row">18</th>
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                  <tr>
                    <th scope="row">19</th>
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                  <tr>
                    <th scope="row">20</th>
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                  <tr>
                    <th scope="row">21</th>
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                  <tr>
                    <th scope="row">22</th>
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                  <tr>
                    <th scope="row">23</th>
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                  <tr>
                    <th scope="row">24</th>
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                  <tr>
                    <th scope="row">25</th>
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                  <tr>
                    <th scope="row">26</th>
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                  <tr>
                    <th scope="row">27</th>
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                  <tr>
                    <th scope="row">28</th>
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                </tbody>
              </table> 
            </div>
            </div>
             
             <div class="col-lg border" >
              <div class="border-bottom ">
             <h4 class="text-center">Team Overview<h4>
             </div>
             <table class="table-responsive-sm">
                  <thead>
                <tr>
                  <th scope="col"></th>
                  <th scope="col">Home Club</th>
                    <th scope="col">Away Club</th>
                    <th scope="col">Date</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <th scope="row">1</th>
                    <td>Celtic</td>
                    <td>Hibs</td>
                    <td>25 Aug</td>
                  </tr>
                  <tr>
                    <th scope="row">2</th>
                    <td>Hearts</td>
                    <td>St. Mirren</td>
                    <td>25 Aug</td>
                  </tr>
                  <tr>
                    <th scope="row">3</th>
                    <td>Motherwell</td>
                    <td>Livingstone</td>
                  </tr>
                  <tr>
                    <th scope="row">2</th>
                    <td>Hearts</td>
                    <td>St. Mirren</td>
                    <td>25 Aug</td>
                  </tr>
                  <tr>
                    <th scope="row">2</th>
                    <td>Hearts</td>
                    <td>St. Mirren</td>
                    <td>25 Aug</td>
                  </tr>
                  <tr>
                    <th scope="row">2</th>
                    <td>Hearts</td>
                    <td>St. Mirren</td>
                    <td>25 Aug</td>
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
                    <td>Celtic</td>
                    <td>v</td>
                    <td>Hibs</td>
                  </tr>
                  <tr>
                    <td>Hearts</td>
                    <td>v</td>
                    <td>St. Mirren</td>
                  </tr>
                  <tr>
                    <td>Motherwell</td>
                    <td>v</td>
                    <td>Livingstone</td>
                  </tr>
                  <tr>
                    <td>Hearts</td>
                    <td>v</td>
                    <td>St. Mirren</td>
                  </tr>
                  <tr>
                    <td>Hearts</td>
                    <td>v</td>
                    <td>St. Mirren</td>
                  </tr>
                  <tr>
                    <td>Hearts</td>
                    <td>v</td>
                    <td>St. Mirren</td>
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
           for(var i in user.team.squad){
            // alert(user.team.squad[i].name);
            // alert(user.team.squad[i].position);
          }
          buildNextFixtures().call;
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
          paintFixtureTable().call;
        }
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();   
      }

      function paintFixtureTable() {
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