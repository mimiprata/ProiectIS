<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="hello.domainModel.Offer" %>
<%@ page import="hello.domainModel.Hotel" %>

<%@ page import="hello.dataAcces.HotelAcces" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Client page</title>

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
<div class="card-header" style="background:Blue">
              <h2 class="text-left my-auto font-weight-light">List of offers</h2>
            </div>
<body>
<div class="hero-image">
	<div class="container">
	
        <div class="row justify-content-center align-items-center" id="central">
          <div class="card" style="width: 35rem;">
            
              <div class="card-body">
                
                <table class="table">
                <thead>
                <tr>
                <th>Price</th>
                <th>Place</th>
                <th>Hotel</th>
                <th>Time</th>
                <th>Hotel</th>
                <th>Buy</th>
                </tr>
                </thead>
                <tbody>
                <%
                List<Offer> offerts=(List <Offer>)request.getAttribute("offerts");
                Offer offer=new Offer();
                Iterator<Offer> iterator=offerts.iterator();
                int i=0;
                HotelAcces hotelAcces=new HotelAcces();
                
                %>
                <tr >
                <% while(iterator.hasNext()){
                	i++;
                	offer=iterator.next();
                	System.out.println(offer.getId());
                	
                %>
                    <td><%=offer.getPrice() %></td>
                    <td><%=offer.getPlace() %></td>
                    <td><%=hotelAcces.getHotel(offer.getHotelID()).getName() %></td>
                    <td><%=offer.getTime() %></td>
                     
                    <td> <form:form class="form-signin" method="POST" action="/FinalProject/readHotel">
                    <input name="id" type="hidden" value="<%=hotelAcces.getHotel(offer.getHotelID()).getId()%>"/>
                    <button class="btn btn-sm btn-default btn-block mt-4" type="submit"  >Check Hotel!</button>
                              
                  </form:form> 
                    </td>
                    <td> <form:form class="form-signin" method="POST" action="/FinalProject/deleteOffer2">
                    <input name="id" type="hidden" value="<%=offer.getId()%>"/>
                    <button class="btn btn-sm btn-default btn-block mt-4" type="submit"  >Buy This!</button>
                              
                  </form:form> 
                    </td>
                </tr>
               
                <%}%>
                 <tr>
                <form:form class="form-signin" method="POST" action="/FinalProject/suggest">
                <button class="btn btn-sm btn-default btn-block mt-4" type="submit"  >Suggest offer!</button>
				</form:form> 				
				</tr>
                </tbody>
                </table> 
                  
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