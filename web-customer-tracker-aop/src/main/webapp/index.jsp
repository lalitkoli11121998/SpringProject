<!-- if you see in web.xml then we mention the welcome page where we have given the index.jsp file name which is our  -->
<!-- welcome page. now what we wil do we redirect the user to index.jsp to the customer list  -->
<% response.sendRedirect("customer/list"); %>
