<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
  <title>student confirmation form
  </title>
 
</head>
<body>
<!-- student.firstname work as student.getfirstname() -->
   student first name : ${student.firstname}
  <br><br>
   student first name : ${student.firstname}
  <br><br>

   student country : ${student.country}
 <br><br>
 student country : ${student.favouritelanguage}
 
 <br><br>
 Operating Systems:
 <ul>
 <!-- we use JSTL to using for loop -->
   <c:forEach var ="temp" items ="${student.operatingSystems}">
          <li>
          ${temp}
          </li>
   </c:forEach>
 </ul>
 
 <br><br>
</body>
</html>