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
  max-height: 650px;
  margin: 0 auto;
  width:100%;
  overflow:scroll;
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

table {
    max-width: 2000px;
    max-height: 700px;
    min-height: 500px;
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
    background-color: #B3CFDD;
}

tbody {
    height: 50px;
}

thead {
  width: 100%;

}

tbody td {
    max-width:33.33%;
    width:100%;
    height: 50px;
    float: left;
}

tbody th {
    max-width:33.33%;
    width:100%;
    height: 50px;
    float: left;
}

thead th{
    max-width:33.33%;
    width:100%;
    height: 65px;
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
        <h1 class="form-signin-heading text-center ">Leaderboard</h1>
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
        <h6 class="form-signin-heading text-right" id="welcomeHeader"></h6>
      </div>

      <div class="body">
               <table class="table-responsive-sm table table-striped table-bordered" id="leaderboard-table">
                  <thead>
                <tr>
                  <th class="th-sm" style="cursor:s-resize" onclick="sortTable(0)" scope="col">Rank</th>
                  <th class="th-sm" style="cursor:s-resize" onclick="sortTable(1)" scope="col">Team Name</th>
                  <th class="th-sm" style="cursor:s-resize" onclick="sortTable(2)" scope="col">Total</th>
                  </tr>
                </thead>
                <tbody id="leaderboard-body">
                    <tr  style="cursor:pointer">
                <td class="rank">4</td> <td class="name">Ant</td> <td class="score">10</td>
                  </tr>
                  <tr  style="cursor:pointer">
                <td class="rank">3</td> <td class="name">Yellow</td> <td class="score">20</td>
                  </tr>
                  <tr  style="cursor:pointer">
                <td class="rank">2</td> <td class="name">mAN</td> <td class="score">30</td>
                  </tr>
                  <tr  style="cursor:pointer">
                <td class="rank">1</td> <td class="name">Zebra</td> <td class="score">120</td>
                  </tr>
                  
                </tbody>
              </table> 
      </div>

      <footer class="footer mt-auto py-2 fixed-bottom">
          <div class="container">
            <span class="text-muted">Made by Daniel Mitchell</span>
          </div>
      </footer>
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
      var user;
      var rankings = [];

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
            loadTeam().call;
          }
          
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
          document.getElementById("welcomeHeader").innerHTML = "Welcome " + fields[0] + "!";
          buildRankings().call;
        }
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();   
      }
      
      function buildRankings() {
        // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "https://stark-wave-35947.herokuapp.com/fantasyscotland/getPublicRankings"); // Request type and URL
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }

        // CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
        // to do when the response arrives 
        xhr.onload = function(e) {
          var leaderboardtable = document.getElementById('leaderboard-table');
          var leaderboardbody = document.getElementById('leaderboard-body');
          leaderboardbody.innerHTML = "";
          if(xhr.response == "null"){
            return;
            }
          var response = JSON.parse(xhr.response); // the text of the response
          var keys = Object.keys(response);
          for(var i = 0; i < keys.length; i++) {
              var tr = document.createElement('tr');
              tr.setAttribute('id', response[i].team_id);
              tr.setAttribute('style', "cursor:pointer");
              var rank = document.createElement('td');
              var rText = document.createTextNode(response[i].rank);
              rank.appendChild(rText);

              var name = document.createElement('td');
              var nText = document.createTextNode(response[i].teamName);
              name.appendChild(nText);

              var score = document.createElement('td');
              var sText = document.createTextNode(response[i].score);
              score.appendChild(sText);

              tr.appendChild(rank);
              tr.appendChild(name);
              tr.appendChild(score);
              leaderboardbody.appendChild(tr);
              leaderboardtable.appendChild(leaderboardbody);
          }
          repaint().call;
        }
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();   
      }

      function repaint(){
        document.getElementById(user.team.team_id).style.border = "thick solid #33C4FF";
      }

      function sortTable(n) {
        var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
        table = document.getElementById("leaderboard-table");
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
            if(n === 1){
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
          } else{
              if (dir == "asc") {
                if (Number(x.innerHTML) > Number(y.innerHTML)) {
                  shouldSwitch = true;
                  break;
                }
            } else if (dir == "desc") {
                if (Number(x.innerHTML) < Number(y.innerHTML)) {
                  shouldSwitch = true;
                  break;
                }
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

      // jQuery(document).ready(function($) {
      //     $('#table').on('click', '.clickable-row', function() {
      //         swapPlayer($(this).attr('value'), position);
      //         var $item = $(this).closest("tr") 
      //                  .find(".price")     // Gets a descendent with class="price"
      //                  .text();         // Retrieves the text within <td>
      //         $("#selectModal").modal('hide');
      //     });
      // });
    </script>     
</body>
</html>