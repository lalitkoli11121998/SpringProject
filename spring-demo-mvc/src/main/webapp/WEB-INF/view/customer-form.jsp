
<!-- for using the springform we have to add the below use -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
  <head>
     <title>Customer Register form</title>
     <style>
         .error {
          color: red;
          font-size: 1.2em
         }
     </style>
  </head>
  <body>
     <!-- the model attribute should be same as the model which we have given in the controller -->
     <p>Fill out the Form. (*) means required</p>
      <form:form action = "processForm" modelAttribute = "customer">
           <!-- fistname is the property of the student 
           class and spring behind the scene read the path name as "student.setFirstname()" -->
           
            customer first name: <form:input path="firstname"/>
            <br><br>
            
            customer last name(*): <form:input path="lastname"/>
            <form:errors path ="lastname" cssClass ="error"/>
            <br><br>
             
             
            customer free passes: <form:input path="freePasses"/>
            <form:errors path ="freePasses" cssClass ="error"/>
            <br><br>
            
            
            customer postal code: <form:input path="postalCode"/>
            <form:errors path ="postalCode" cssClass ="error"/>
            <br><br>
            
            customer course code: <form:input path="courseCode"/>
            <form:errors path ="courseCode" cssClass ="error"/>
            <br><br>
            
            
            <input type ="submit" value ="submit"/>
            <!-- whenever we submit the form spring will call student.setFirstname() and student.setLastname() -->
      </form:form>
  </body>
</html>
