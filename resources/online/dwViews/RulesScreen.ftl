<!DOCTYPE html>
<html lang="en">
<!-- This is the view the users have when they wish view the rules of the Fantasy Scotland application. It is a basic HTML document with the rules listed clearly by scrollable text.-->
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Rules</title>
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
html {
    font-size: 16px;
    line-height: 1.7;
    font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", "Roboto", "Helvetica Neue", Arial,  "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol" ;
}
pre, code{
    font-family: SFMono-Regular, Menlo, Monaco, Consolas, "Liberation Mono", "Courier New", monospace;
}

/*This ensures that the users browser is at the right scale to display the application */
#my{
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
  min-height:200px;
  max-height: 700px;
  margin: 0 auto;
  width:100%;
  height:100%;
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
        <h1 class="form-signin-heading text-center ">Rules</h1>
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
      <!--Basic HTML of all the rules-->
      <div class="body">
        <h2 title="header"><u>Fantasy Scotland</u></h2>
        <p title="para">This page will tell you everything you need to know about what this application is and how to use it:   
        <ol>
          <li><h4 title="header"><u>What is this?</u></h4>
            <ul>
             <li>Fantasy Scotland is a fantasy football application for the Scottish Premiership, designed to be played online.</li>
            <li>The application uses match data and results from the <span><b>2019/2020</b></span> season to simulate gameplay.</li>
          </ul>
          </li>
          <li><h4 title="header"><u>Why was it made?</u></h4>
            <ul>
              <li>The application was designed and implemented by Glasgow University student Daniel Mitchell, as part of their MSc Software Development summer project.</li>
              <li>The application was developed during the height of the COVID-19 epidemic. It was very clear that the season following the outbreak would be very disrupted and so Fantasy Scotland was developed to offer additional value to every fan's season and allow them to engage with the game from a new perspective.</li>
              <li>It also aims to support Scottish football in general, by providing a space for football fans and newcomers to congregate and learn more about Scottish Football!</li>
          </ul>
          </li>
          <li><h4 title="header"><u>How to Play</u></h4>
            <ul>
              <li>The first step you've probably already done, which is picking a team of <span><b>15 players!</b></span></li>
              <li>You are then free to leave the game from there, the application will calculate your score automatically each week.</li>
              <li>If you wish to be more involved, you can choose to manage your team for the upcoming rounds or make a transfer and bring in new players.</li>
              <li>Once the last game has been played, the application will stop calculating scores and the application will finish.</li>
          </ul>
          </li>
          <li><h4 title="header"><u>Picking your Team</u></h4>
            <ul>
              <li>You select a team of 15 Scottish Premiership players from the 2019/20 season, with over 400 players to choose from!.</li>
              <li>There is a fixed formation of <span><b>4-4-2</b></span>, that's 1 goalkeeper, 4 defenders, 4 midfielders, 2 forwards and a substitute for each position.</li>
              <li>Each player has a predetermined cost based on their previous performances and real-world value. You must select a squad with a <span><b>&#163 60 million</b></span> transfer budget.</li>
              <li>You may only choose <span><b>3 players</b></span> from each of the 12 premiership clubs.</li>
          </ul>
          </li>
          <li><h4 title="header"><u>Managing your Team</u></h4>
             <ul>
              <li>You can manage your team before a round commences by visiting the <a href='manage'>Manage</a> page. <span><b>You can not make changes to your squad while the round is in progress.</b></span> Click on a player icon and select an option.</li>
              <li>You can make unlimited changes to your team by making substitutions, which will be applied instantly for that upcoming round.</li>
              <li>You may also select a captain, but features relating to this option will be included in a future update.</li>
          </ul>
          </li>
          <li><h4 title="header"><u>Making Transfers</u></h4>
            <ul>
              <li>Each week you may make <span><b>1 transfer</b></span> while there are no rounds currently in progress from the <a href='transfer'>Transfer</a> page.</li>
              <li>Once the round has finished, the transfers will refresh but be careful as they do not stack! <span><b> You will only ever be able to make one transfer per week!</b></span></li>
              <li>Remember, you can't have 3 players from the same club, duplicate players or exceed the transfer budget!</li>
              <li>This game encourages and rewards attention, if a player is injured or not playing, it is expected that you will make the necessary changes.</li>
          </ul>
          </li>
          <li><h4 title="header"><u>Scoring</u></h4>
            <h5 title="header"><u>General</u></h5>
              <ul>
              <li>Appearance <span><b>+1</b></span></li>
              <li>Yellow Card <span><b>-1</b></span></li>
              <li>Red Card <span><b>-3</b></span></li>
          </ul>
            <h5 title="header"><u>Attacking</u></h5>
             <ul>
              <li>Goal (FOR) <span><b>+2</b></span></li>
              <li>Goal (MID) <span><b>+3</b></span></li>
              <li>Goal (DEF) <span><b>+4</b></span></li>
              <li>Goal (GK) <span><b>+8</b></span></li>
              <li>Assist <span><b>+1</b></span></li>
          </ul>
            <h5 title="header"><u>Defensive</u></h5>
             <ul>
              <li>Clean Sheet (GK) <span><b>+5</b></span></li>
              <li>Clean Sheet (DEF) <span><b>+3</b></span></li>
              <li>Clean Sheet (MID) <span><b>+1</b></span></li>
              <li>Concede 2+ Goals (GK) <span><b>-3</b></span></li>
              <li>Concede 2+ Goals (DEF) <span><b>-2</b></span></li>
              <li>Concede 2+ Goals (MID) <span><b>-1</b></span></li>
              <li>Own Goal <span><b>-2</b></span></li>
          </ul>
          </li>
          <li><h4 title="header"><u>Rounds</u></h4>
            <ul>
              <li>Rounds are essentially clusters of fixtures that are played closely together. This usually comprises of up to 6 fixtures per week but sometimes there can be more.</li>
              <li>There are a total of 30 rounds in the 2019/20 season.</li>
              <li>A round starts when the first fixture of the round begins and ends when the last fixture ends.</li>
              <li>The round times will be advertised each week on the home page.</li>
              <li>Fixture and match event data is supplied by <a href="https://www.xmlsoccer.com/">XML Soccer</a>, a free to use API for football data.</li>
          </ul>
          </li>
          <li><h4 title="header"><u>League</u></h4>
            <ul>
              <li>When you create a team you automatically join<span><b> the Global league</b></span>, which comprises of all other registered Fantasy Scotland users.</li>
              <li>You can compare your progress by visiting the <a href='leagues'>Leaderboard</a> page. You will find your team highlighted in <span style="color:blue"><b>blue.</b></span></li>
              <li>Other details relating to your previous scores over the weeks can be found on the <a href='home'>Home</a> page.</li>
          </ul>
          </li>
        </ol> 
        </p>
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
        isUserSignedIn(); //first check to see user has been authenticated and hasnt randomly landed on the page.
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
            loadTeam().call; //load team into user object in model
          }
          
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
          buildUser().call; //Load user and team
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
        //When the response arrives... 
        xhr.onload = function(e) {
          user = JSON.parse(xhr.response);
          var fields = user.email.split('@');
          document.getElementById("welcomeHeader").innerHTML = "Welcome " + fields[0] + "!";
        }
        
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
    </script>     
</body>
</html>