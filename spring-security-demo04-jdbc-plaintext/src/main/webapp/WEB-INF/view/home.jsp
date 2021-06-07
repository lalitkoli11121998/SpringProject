<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
      <title>Luv2code company home page</title>
</head>
<body>
    <h2>Luv2code company home page !!!login bro</h2>
    <hr>
    <h2>welcome to the luv2code company home page</h2>
    <hr>
    
    <!-- display username and role -->
    <p>
         User : <security:authentication property="principal.username"/>
         <br><br>
         <!-- authorities same as role -->
         Role(s) : <security:authentication property="principal.authorities"/>
    </p>
    
    <hr>
    
    <!-- add a link to point to /leaders.....this is for manager -->
    <security:authorize access = "hasRole('MANAGER')">
      <p>
       <a href ="${pageContext.request.contextPath}/leaders">Leadership meeting</a>
       (only for peeps)
      </p>
    </security:authorize>
    
    
    <br>
    
    <!-- only show the link to the amin role  -->
    
     <security:authorize access = "hasRole('ADMIN')">
     <p>
       <a href ="${pageContext.request.contextPath}/admins">Systems meeting</a>
       (only for admins)
    </p>
    </security:authorize>
    <form:form action = "${pageContext.request.contextPath}/logout" method ="POST">
    
          <input type = "submit" value = "Logout">
    </form:form>
</body>
</html>