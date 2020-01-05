<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"/>
</head>
<body>
<c:import url="../template/nav.jsp"/>

<div class="container">
	  <h2>Notice Write</h2>
	  <form action="./noticeWrite" method="post" enctype="multipart/form-data">
	  	
	    <div class="form-group">
	      <label for="title">Title:</label>
	      <input type="text" class="form-control" id="title" placeholder="Enter title" name="title">
	    </div>
	    
	    <div class="form-group">
	      <label for="writer">Writer:</label>
	      <input type="text" class="form-control" id="writer" placeholder="Enter Writer" name="writer">
	    </div>
	    
	    <div class="form-group">
	      <label for="contents">Contents:</label>
	      <textarea  rows="20" cols="50" class="form-control" id="contents" placeholder="Enter Contents" name="contents"></textarea>
	    </div>
	    
	    <div class="form-group">
	      <label for="File">File:</label>
	      <input type="file" class="form-control" id="files" name="files">
	    </div>
	    
	    
	     <button class="btn btn-info">Submit</button>
	    </form>
	</div>


</body>
</html>