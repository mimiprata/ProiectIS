<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Get a hotel</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="../css/index.css">
<style>
.container{
position: fixed; /* or absolute */
  top: 5%;
  left: 10%;
}
body {
  margin: 200;
  font-family: Calibri, Gadget, sans-serif;
}


</style>
</head>
<div class="card-header" style="background:Red">
              <h2 class="text-left my-auto font-weight-light">Read Hotel Page</h2>
            </div>
<body>
<div class="hero-image">
	<div class="container">
	
        <div class="row justify-content-center align-items-center" id="central">
          <div class="card" style="width: 35rem;">
            
              <div class="card-body">
                
                  <form:form class="form-signin" method="POST" action="/FinalProject/readHotel">
                  
                  <div class="form-label-group">
                      <form:input path="id" type="id" id="inputId" class="form-control mb-2" placeholder="Enter hotel id"/>
                    </div>
                    
					                 
     
                    <button class="btn btn-sm btn-default btn-block mt-4" type="submit"  >Read</button>
                              
                  </form:form> 
                  
              </div>
          </div>
        </div>
    </div>
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</div>
</body>
</html>