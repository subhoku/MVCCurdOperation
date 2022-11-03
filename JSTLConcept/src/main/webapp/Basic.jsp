<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"  import="java.util.*"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="x"%> 
 
 <!-- Traditional for loop -->
    <x:forEach var="i"  begin="1"  end="5"   step="1">
          10 *  ${i} = ${ 10 * i} <br>
          </x:forEach>    
        
          
 <!-- Enhanced for loop for array -->
   <jsp:scriptlet>
         
        String names[]={"raja","rani","mani","jani","phani"};
        request.setAttribute("namesArray",names);
   </jsp:scriptlet>
   <br><br>
   <x:forEach var="name" items="${namesArray}">
            ${name} <br>
   </x:forEach>          
   <!-- Enhanced for loop for Collection -->
     <jsp:scriptlet>
      <![CDATA[
        SortedSet<String> namesList=new TreeSet<String>();
       namesList.add("raja"); 
       namesList.add("rani");
       namesList.add("mani"); 
       namesList.add("phani");
       namesList.add("raja"); 
       namesList.add("rani");
       namesList.add("mani"); 
     
       request.setAttribute("namesListArray",namesList);
       ]]>
   </jsp:scriptlet>
   <br><br>
   <x:forEach var="nameArray" items="${namesListArray}">
            ${nameArray} <br>
   </x:forEach>  
   <x:set>
   <x:forTokens  var items="" delims=""></x:forTokens>
   </x:set>        
   
   
