<!DOCTYPE html>
<html lang="en">
<!-- This is the view the users have when they wish to view the leaderboard of the public league. In the future functionality for creating and joining private leagues will be added.-->
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Leagues</title>
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
  max-height: 650px;
  margin: 0 auto;
  width:100%;
  overflow:scroll;
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

.btn:hover {
  background-color: black;
}

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

/*Leaderboard table CSS*/
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
        <h1 class="form-signin-heading text-center ">Leaderboard</h1>
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
      <!--Leaderboard table-->
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
      var user;
      var rankings = []; //table rows 

      function isUserSignedIn(){
         // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "https://stark-wave-35947.herokuapp.com/fantasyscotland/userSignedIn"); // Request type and URL
        
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
            loadTeam().call; //load team into user object
          }
          
        }
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();  
      }
      
      //This method is called before loading the user profile in order to search the database for the user's team and attach it to the user profile in the model before being loaded into the view.
      function loadTeam() {
        // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "https://stark-wave-35947.herokuapp.com/fantasyscotland/loadTeam"); // Request type and URL
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }

        //When the response arrives...  
        xhr.onload = function(e) {
          buildUser().call; //Load user and team 
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
        //When the response arrives...  
        xhr.onload = function(e) {
          user = JSON.parse(xhr.response);
          var fields = user.email.split('@');
          document.getElementById("welcomeHeader").innerHTML = "Welcome " + fields[0] + "!";
          buildRankings().call; //load in rankings to append to empty table
        }
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();   
      }
      
      //This function is called to load in all the pre sorted leaderboard rankings of the different teams in the public league.
      function buildRankings() {
        // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "https://stark-wave-35947.herokuapp.com/fantasyscotland/getPublicRankings"); // Request type and URL
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }

        //When the response arrives...  
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
          repaint().call; //paint border round users team
        }
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();   
      }
      
      //Called when the user presses the sign out button, removes all id and email attributes from the session and redirects user to login page.
      function signOut(){
        // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "https://stark-wave-35947.herokuapp.com/fantasyscotland/signOut"); // Request type and URL
        
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

      //This function highlights the user's team's ranking in the leaderboard with a thick blue border
      function repaint(){
        document.getElementById(user.team.team_id).style.border = "thick solid #33C4FF";
      }

      //This function is taken from https://www.w3schools.com/howto/howto_js_sort_table.asp.
      //It is used for sorting the modal nested table when clciking each of the column headers. It is adapted slightly to accomadate both numerical and lexicographic sorting.
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
    </script>     
</body>
</html>