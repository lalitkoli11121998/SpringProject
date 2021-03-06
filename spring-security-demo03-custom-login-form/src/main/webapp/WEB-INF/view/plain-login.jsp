<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
     <title>Login form</title>
     <style>
     
        .failed {
            color: red;
        }
     </style>
  </head>
  <body>
    <h2>Custom login form</h2>
     <!-- the model attribute should be same as the model which we have given in the controller -->
      <c:if test ="${parm.error != null}">
            <i class ="failed">Sorry ! you entered invalid username/password.</i>
      
      </c:if>
      <form:form action = "${pageContaxt.request.contextPath}/authenticateTheUser" modelAttribute = "">
                <p>
                    User name : <input type ="text" name = "username"/>
                </p>
                 <p>
                    Password : <input type ="text" name = "password"/>
                </p>
                <input type ="submit" value ="Login"/>
      </form:form>
  </body>
</html>
