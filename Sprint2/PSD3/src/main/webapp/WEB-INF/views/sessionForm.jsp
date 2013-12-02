<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
  
<html>  
 <head>  
    
  <title>Sprint 2</title>  
 </head>  
 <body>  
<h2>  
Session Data Form</h2>  
<form:form action="/src/addSession" method="POST">        
<table><tbody>  
<tr>        <td><form:label path="name">Session Name:</form:label></td>      <td><form:input path="name"></form:input></td>    </tr>  
<tr>        <td><form:label path="type">Session Type:</form:label></td>      <td><form:input path="type"></form:input></td>    </tr>  
<tr>        <td><form:label path="date">Session Date  (mm/dd/yyyy hh:mm):</form:label></td>      <td><form:input path="date"></form:input></td>    </tr>  
<tr>       <td><form:label path="duration">Session Duration (hh:mm:ss):</form:label></td>       <td><form:input path="duration"></form:input></td>     </tr>  
<tr>      <td><form:label path="repeatFrequency">Session Repeat Frequency :</form:label></td>     <td><form:input path="repeatFrequency"></form:input></td>    </tr>  
<tr>       <td><form:label path="lecturer">Session Lecturer :</form:label></td>       <td><form:input path="lecturer"></form:input></td>     </tr>  
<tr>       <td><form:label path="maxAttendance">Session Max Attendance :</form:label></td>       <td><form:input path="maxAttendance"></form:input></td>     </tr>  
<tr>       <td><form:label path="compulsory">Session Compulsory :</form:label></td>       <td><form:input path="compulsory"></form:input></td>     </tr>  
<tr>       <td><form:label path="venue">Session Venue :</form:label></td>       <td><form:input path="venue"></form:input></td>     </tr>  
<tr>         <td colspan="2"><input type="submit" value="Submit"/>  </td>       </tr>  
</tbody></table>  
</form:form>  
</body>  
</html>  