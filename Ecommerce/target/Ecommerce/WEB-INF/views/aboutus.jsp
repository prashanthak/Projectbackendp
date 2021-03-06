<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<!-- Navbar (sit on top) -->
<div class="w3-top">
  <div class="w3-bar w3-white w3-padding w3-card" style="letter-spacing:4px;">
    <a href="#home" class="w3-bar-item w3-button">Ewayhome</a>
    <!-- Right-sided navbar links. Hide them on small screens -->
    <div class="w3-right w3-hide-small">
      <a href="#about" class="w3-bar-item w3-button">About</a>
      <a href="#product" class="w3-bar-item w3-button">Product</a>
      <a href="#contact" class="w3-bar-item w3-button">Contact</a>
    </div>
  </div>
</div>

<!-- Header -->
<header class="w3-display-container w3-content w3-wide" style="max-width:1600px;min-width:500px" id="home">
  <img class="w3-image" src="/resources/images/welcomenew.jpg" alt="Ewayhome" width="1600" height="800">
  <div class="w3-display-bottomleft w3-padding-large w3-opacity">
    <h1 class="w3-xxlarge">Ewayhome</h1>
  </div>
</header>

<!-- Page content -->
<div class="w3-content" style="max-width:1100px">

  <!-- About Section -->
  <div class="w3-row w3-padding-64" id="about">
    <div class="w3-col m6 w3-padding-large w3-hide-small">
     <img src="/resources/images/mobilenew2.jpg" class="w3-round w3-image w3-opacity-min" alt="Table Setting" width="600" height="750">
    </div>

    <div class="w3-col m6 w3-padding-large">
      <h1 class="w3-center">About Ewayhome</h1><br>
      <h5 class="w3-center">Tradition since 2018</h5>
      <p class="w3-large">The Ewayhome<span class="w3-tag w3-light-grey">seasonal</span> products.</p>
      <p class="w3-large w3-text-grey w3-hide-medium">Ewayhome.</p>
    </div>
  </div>
  
  <hr>
  
<!--   <!-- <!-- Menu Section --> -->
<!--   <div class="w3-row w3-padding-64" id="menu"> -->
<!--     <div class="w3-col l6 w3-padding-large"> -->
<!--       <h1 class="w3-center">Our Menu</h1><br> -->
<!--       <h4>Bread Basket</h4> -->
<!--       <p class="w3-text-grey">Assortment of fresh baked fruit breads and muffins 5.50</p><br> -->
    
<!--       <h4>Honey Almond Granola with Fruits</h4> -->
<!--       <p class="w3-text-grey">Natural cereal of honey toasted oats, raisins, almonds and dates 7.00</p><br> -->
    
<!--       <h4>Belgian Waffle</h4> -->
<!--       <p class="w3-text-grey">Vanilla flavored batter with malted flour 7.50</p><br> -->
    
<!--       <h4>Scrambled eggs</h4> -->
<!--       <p class="w3-text-grey">Scrambled eggs, roasted red pepper and garlic, with green onions 7.50</p><br> -->
    
<!--       <h4>Blueberry Pancakes</h4> -->
<!--       <p class="w3-text-grey">With syrup, butter and lots of berries 8.50</p>     -->
<!--     </div> -->
    
<!--     <div class="w3-col l6 w3-padding-large"> -->
<!--       <img src="/w3images/tablesetting.jpg" class="w3-round w3-image w3-opacity-min" alt="Menu" style="width:100%"> -->
<!--     </div> -->
<!--   </div> -->

<!--   <hr> --> -->

  <!-- Contact Section -->
<!--   <div class="w3-container w3-padding-64" id="contact"> -->
<!--     <h1>Contact</h1><br> -->
<!--     <p>We offer full-service catering for any event, large or small. We understand your needs and we will cater the food to satisfy the biggerst criteria of them all, both look and taste. Do not hesitate to contact us.</p> -->
<!--     <p class="w3-text-blue-grey w3-large"><b>Catering Service, 42nd Living St, 43043 New York, NY</b></p> -->
<!--     <p>You can also contact us by phone 00553123-2323 or email catering@catering.com, or you can send us a message here:</p> -->
<!--     <form action="/action_page.php" target="_blank"> -->
<!--       <p><input class="w3-input w3-padding-16" type="text" placeholder="Name" required name="Name"></p> -->
<!--       <p><input class="w3-input w3-padding-16" type="number" placeholder="How many people" required name="People"></p> -->
<!--       <p><input class="w3-input w3-padding-16" type="datetime-local" placeholder="Date and time" required name="date" value="2017-11-16T20:00"></p> -->
<!--       <p><input class="w3-input w3-padding-16" type="text" placeholder="Message \ Special requirements" required name="Message"></p> -->
<!--       <p><button class="w3-button w3-light-grey w3-section" type="submit">SEND MESSAGE</button></p> -->
<!--     </form> -->
<!--   </div> -->
  
<!-- <!-- End page content --> -->
<!-- </div> -->

<!-- <!-- Footer --> -->
<!-- <footer class="w3-center w3-light-grey w3-padding-32"> -->
<!--   <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" title="W3.CSS" target="_blank" class="w3-hover-text-green">w3.css</a></p> -->
<!-- </footer> -->

</body>
</html>