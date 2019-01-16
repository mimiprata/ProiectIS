<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Page</title>

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


p.b {
    font-family: "Arial Black", Gadget, sans-serif;
}
</style>
</head>
 <div class="card-header" style="background:Orange">
            <h2 class="text-left my-auto font-italic">Admin page</h2>
              
             
       </div> 
<body>
<div class=>

	<div class="container">
		
        <div class="row justify-content-center align-items-center" id="central">
          <div class="card" style="width: 35rem;">
          
           
              <div class="card-body">
                
                  <form:form class="form-signin" method="GET" action="/FinalProject/offerCreate">
                    
     
                    <button class="btn btn-sm btn-default btn-block mt-4" type="submit">Create Offer</button>                   
                  </form:form> 
                   <form:form class="form-signin" method="GET" action="/FinalProject/offerDelete">
                    
     
                    <button class="btn btn-sm btn-default btn-block mt-4" type="submit">Delete Offer</button>                   
                  </form:form> 
                   <form:form class="form-signin" method="GET" action="/FinalProject/offerUpdate">
                    
     
                    <button class="btn btn-sm btn-default btn-block mt-4" type="submit">Update Offer</button>                   
                  </form:form> 
                   <form:form class="form-signin" method="GET" action="/FinalProject/offerRead">
                    
     
                    <button class="btn btn-sm btn-default btn-block mt-4" type="submit">Read Offer</button>                   
                  </form:form>  
                  <form:form class="form-signin" method="GET" action="/FinalProject/hotelCreate">
                    
     
                    <button class="btn btn-sm btn-default btn-block mt-4" type="submit">Create Hotel</button>                   
                  </form:form> 
                   <form:form class="form-signin" method="GET" action="/FinalProject/hotelDelete">
                    
     
                    <button class="btn btn-sm btn-default btn-block mt-4" type="submit">Delete Hotel</button>                   
                  </form:form> 
                   <form:form class="form-signin" method="GET" action="/FinalProject/hotelUpdate">
                    
     
                    <button class="btn btn-sm btn-default btn-block mt-4" type="submit">Update Hotel</button>                   
                  </form:form> 
                   <form:form class="form-signin" method="GET" action="/FinalProject/hotelRead">
                    
     
                    <button class="btn btn-sm btn-default btn-block mt-4" type="submit">Read Hotel</button>                   
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