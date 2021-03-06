
<!-- for using the springform we have to add the below use -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
  <head>
     <title>Student Register form</title>
  </head>
  <body>
     <!-- the model attribute should be same as the model which we have given in the controller -->
      <form:form action = "processForm" modelAttribute = "student">
           <!-- fistname is the property of the student 
           class and spring behind the scene read the path name as "student.setFirstname()" -->
           
            student first name : <form:input path="firstname"/>
            <br><br>
            
            student last name : <form:input path="lastname"/>
            <br><br>
            <form:select path="country">
               <form:options items= "${student.countryoptions}"/>

            </form:select>
            
            <br><br>
            Favorite language
            Java<form:radiobutton path="favouritelanguage" value = "java"/>
            Cpp <form:radiobutton path="favouritelanguage" value = "cpp"/>
            Python<form:radiobutton path="favouritelanguage" value = "python"/>
            Php<form:radiobutton path="favouritelanguage" value = "php"/>
            Rupby<form:radiobutton path="favouritelanguage" value = "ruby"/>
          
            <br><br>
            Favorite operating systems
            Mac<form:checkbox path="operatingSystems" value="mac"/>
            Mac OS<form:checkbox path="operatingSystems" value="mac os"/>
            Windows<form:checkbox path="operatingSystems" value="windows"/>
       
            <br><br>
            
            
            <input type ="submit"/>
            <!-- whenever we submit the form spring will call student.setFirstname() and student.setLastname() -->
      </form:form>
  </body>
</html>
