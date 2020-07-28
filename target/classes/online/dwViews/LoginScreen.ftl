<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Login</title>
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
  margin: 80px;
}
.form-signin {
  max-width: 380px;
  margin: 0 auto;
  background-color: #fff;
  padding: 15px 40px 50px;
  border: 1px solid #e5e5e5;
  border-radius: 10px;
}
.form-signin .form-signin-heading, .form-signin .checkbox {
  margin-bottom: 30px;
}
.form-signin input[type="text"], .form-signin input[type="password"] {
  margin-top:20px;
  margin-bottom: 20px;
  ;

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

.container {
  width: auto;
  max-width: 680px;
  padding: 0 15px;
}

.logo{
  padding: 15px;
}

.register{
  margin-top:10px;
}
</style>
</head>
<body>

<div class="wrapper">

<form class="form-signin">
  <h2 class="form-signin-heading text-center">Welcome to Fantasy Scotland!</h2>
  <a class="logo" id="logo"><img src="https://i.ibb.co/yVc3vPy/Fantasy-Scotland.png" alt="Fantasy-Scotland" width="250" ></a>
  <input type="text" id="username" class="form-control" name="username" placeholder="Enter Email Address" required="" autofocus="" />
  <input type="password" id="password" class="form-control" name="password" placeholder="Enter Password" required="" />
  <label class="checkbox">
    <input type="checkbox" value="remember-me" id="rememberMe" name="rememberMe">
    Remember me
  </label>
  <div class="register">
    <button type="button" class="btn btn-lg btn-primary btn-block" id="loginButton">Login</button>
    <p id="registerLine">Don't have an account? <a href='fantasyscotland/register'>Register Here.</a></p>
  </div>
</form>

</div>

<footer class="footer mt-auto py-2 fixed-bottom">
  <div class="container">
    <span class="text-muted">Made by Daniel Mitchell<span>
  </div>
</footer>

<script type="text/javascript">
    
      // Method that is called on page load
      function initalize() {
      
        // --------------------------------------------------------------------------
        // You can call other methods you want to run when the page first loads here
        // --------------------------------------------------------------------------
        startGame();
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
      

      

</body>
</html>











