<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"/>
<!-- include summernote css/js -->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js">
</script>
</head>
<body>
<c:import url="../template/nav.jsp"/>

<div class="container">
	  <h2>Notice Write</h2>
	  <form:form action="./noticeWrite" modelAttribute="noticeVO" method="post" enctype="multipart/form-data" id = "frm">
	  	
	    <div class="form-group">
	      <label for="title">Title:</label>
	 <!--      <input type="text" class="form-control" id="title" placeholder="Enter title" name="title"> -->
	      <form:input path="title" class="form-control" id="title" placeholder="Enter title"/>
	      <form:errors path="title"/>
	    </div>
	    
	    <div class="form-group">
	      <label for="writer">Writer:</label>
	      <form:input path="writer" class="form-control" id="writer" placeholder="Enter Writer"/>
	      <form:errors path="writer"/>
	    </div>
	    
	    <div class="form-group">
	      <label for="contents">Contents:</label>
	   <!--    <textarea  rows="20" cols="50" class="form-control" id="contents" placeholder="Enter Contents" name="contents"></textarea> -->
	      <form:textarea path="contents" class="form-control" id="contents" placeholder="Enter Contents" />
	      <form:errors path="contents"/>
	    </div>
	    
	 <!--    <div class="form-group">
	      <label for="File">File:</label>
	      <input type="file" class="form-control" id="files" name="files">
	    </div>  -->
	    
	    <div class = "row">
	    <input type="button" class="btn btn-info col-sm-3" id = "add" value="Add file">
	    <div id = "files" class = "col-sm-12"></div>
	    
	    </div>
	    
	    
	     <button class="btn btn-info">Submit</button>
	    </form:form>
	</div>
	
	<script type="text/javascript" src="../js/summernote.js"></script>
	<script type="text/javascript" src="../js/fileCount.js"></script>


</body>
</html>