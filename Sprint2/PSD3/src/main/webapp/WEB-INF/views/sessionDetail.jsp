<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
  
<html>  
   <head>  
 <title>Sprint 2</title>  
   </head>  
<body>  
<h2>  
Submitted Session Information</h2>  
<table border="1"><tbody>  
<tr>     <td>Session Date </td>      <td>${date}</td>   </tr>   
<tr>     <td>Session Duration</td>      <td>${duration}</td>     </tr>  
<tr>      <td>Session Repeat Frequency</td>       <td>${repeatFrequency}</td> </tr>
<tr>     <td>Session Lecturer</td>      <td>${lecturer}</td>     </tr>  
<tr>      <td>Session Max Attendance</td>      <td>${maxAttendance}</td>     </tr>  
<tr>     <td>Session Compulsory</td>      <td>${compulsory}</td>     </tr>  
<tr>      <td>Session Venue</td>      <td>${venue}</td>     </tr>  
</tbody></table>  
</body>  
</html>  