<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>

    <style>
        .container {
            padding-top: 50px;
            padding-bottom: 100px;
            width: 50%;
        }
    </style>

</head>
<body>

<% try { if(request.getParameter("register").equals("false") && request.getParameter("username").equals("exists")) { %>

	<div class="alert alert-warning alert-dismissible fade show" role="alert">
	  Username already exists!
	  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
	</div>

<% } } catch(NullPointerException e) {} %>


    <div class="container">

        <div class="d-flex mb-3">
            <div class="p-0"><h1>Enter Details</h1></div>
            <div class="ms-auto p-2">
                <a href="index.jsp">
                    <button type="button" class="btn btn-primary">
                    Back
                    </button> 
                </a>
            </div>
          </div>

        <form action="register" method="post" onsubmit="return validateForm()">
            <h3>Name: </h3>
            <div class="row g-3">
                <div class="col-sm-2">
                    <select class="form-select" id="specificSizeSelect" name="prefix" required>
                      <option value="Mr." selected>Mr.</option>
                      <option value="Mrs.">Mrs.</option>
                      <option value="Ms.">Ms.</option>
                    </select>
                </div>
                <div class="col">
                    <input type="text" class="form-control" placeholder="First name" aria-label="First name" name="first_name" required>
                </div>
                <div class="col">
                    <input type="text" class="form-control" placeholder="Middle name" aria-label="First name" name="middle_name" required>
                  </div>
                <div class="col">
                  <input type="text" class="form-control" placeholder="Last name" aria-label="Last name" name="last_name" required>
                </div>
            </div> <br/>

            <div class="mb-3">
                <h3>User Name: </h3>
                <input type="text" class="form-control" id="username" name="username" placeholder="Username" required>
            </div> <br/>

            <div class="mb-3">
                <h3>Email: </h3>
                <input type="email" class="form-control" id="email" name="email" placeholder="abc@example.com" required>
            </div> <br/>

            <div class="mb-3">
                <h3>Password: </h3>
                <input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
            </div> <br/>

            <div class="mb-3">
                <h3>Re-Enter </h3>
                <input type="password" class="form-control" id="rpassword" name="rpassword" placeholder="Re-Enter Password" required>
            </div> <br/>

            <div class="form-group">
                <h3>Birth Date: </h3>
                <input class="form-control" id="birthdate" name="birthdate" type="date" required>
            </div> <br/>

            <div class="mb-3">
                <h3>Age: </h3>
                <input type="number" class="form-control" id="age" name="age" placeholder="Age" required>
            </div> <br/>

            <h3>Gender: </h3>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="gender" id="male" checked>
                <label class="form-check-label" for="male">
                  Male
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="gender" id="female">
                <label class="form-check-label" for="female">
                  Female
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="gender" id="others">
                <label class="form-check-label" for="others">
                  Others
                </label>
            </div> <br/>

            <h3>Ratings</h3>
            <input type="range" class="form-range" min="1" max="5" step="1" id="ratings" name="ratings"> <br/> <br/>

            <div class="form-check form-switch">
                <input class="form-check-input" type="checkbox" role="switch" id="checked" name="cookies" checked>
                <label class="form-check-label" for="checked">Store Cookies</label>
            </div> <br/>

            <button type="submit" class="btn btn-primary">Submit</button>

        </form>
    </div>

<script>
//Get the form element
const form = document.querySelector('form');

// Add event listener to the form on submit
function validateForm() {

  // Validate name fields
  const prefix = document.querySelector('#specificSizeSelect').value;
  const firstName = document.querySelector('[name="first_name"]').value.trim();
  const middleName = document.querySelector('[name="middle_name"]').value.trim();
  const lastName = document.querySelector('[name="last_name"]').value.trim();

  if (!prefix || !firstName || !middleName || !lastName) {
    alert("Please fill in all name fields");
    return false;
  }

   // Validate username field
   const username = document.getElementById('username').value.trim();

   if (!username) {
     alert("Please enter a username");
     return false;
   }

   // Validate email field
   const email = document.getElementById('email').value.trim();

   if (!email || !validateEmail(email)) {
     alert("Please enter a valid email address");
     return false;
   }

   // Validate password and re-enter password fields
   const password = document.getElementById('password').value.trim();
   const rpassword = document.getElementById('rpassword').value.trim();

    if (password.length <8){
      alert ("Password must be at least eight characters long.");
        return false; 
    }
    
    else if (/\d/.test(password)){
        
        var hasUpperCase=/[A-Z]/g.test(password);
        var hasLowerCase=/[a-z]/g.test(password);
        
        if(hasUpperCase && hasLowerCase==true){
            console.log("It contains both uppercase and lowercase letters.")
          
         }
         else{
             console.log("Warning: It does not contain both uppercase and lowercase letters.")
             return false;
         }
        
    }
    
     else{
        console.log ("Warning: It does not contain a number.")
        return false; 
    }

   if (password !== rpassword) {
     alert("Passwords do not match");
     return false;
   }

   // Validate birth date field
   const birthdate = document.getElementById('birthdate').value.trim();

  if (!birthdate) {
    alert("Please enter your birth date");
    return false;
  }

  // Validate age field
  const age = parseInt(document.getElementById('age').value);


  if (isNaN(age) || age <= 0) {
  alert("Please enter a valid age");
  return false;
  }

  // Validate gender field
  const gender = document.querySelector('[name="gender"]:checked');

  if (!gender) {
  alert("Please select a gender");
  return false;
  }
  };

  // Function to validate email format
  function validateEmail(email) {
  const re = /^[^\s@]+@[^\s@]+.[^\s@]+$/;
  return re.test(email);
  }
</script>

</body>
</html>