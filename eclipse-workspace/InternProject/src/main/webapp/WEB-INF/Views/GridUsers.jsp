<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Users Grid</title>
	<!-- JQuery CDN -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	
	<!-- Datatables CDN -->
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.2/css/jquery.dataTables.css">
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.2/js/jquery.dataTables.js"></script>
	
	<!-- Must be included before style sheets -->
	<%@ include file = "parts/navbar.jsp" %>
	<style><%@include file="/css/localStyles/defaultStyle.css"%></style>
	
</head>

<body>
	
	<h1>User table using Javscript, JQuery, and Ajax</h1>
	
	
	
	<table style="width:100%" border="1" id="users-table" class="table">
	<thead>
			<tr>
				<th>id</th>
				<th>email</th>
				<th>password</th>
				<th>lastLogin</th>
				<th>adminStatus</th>
				<th>edit</th>
			</tr>
		</thead>
		
		<tfoot>
			<tr>
				<th>id</th>
				<th>email</th>
				<th>password</th>
				<th>lastLogin</th>
				<th>adminStatus</th>
				<th>edit</th>
		</tfoot>
	</table>
	
	<script type="text/javascript">

	
	
    $(document).ready(function() {
	    $('#users-table').DataTable( {
	        ajax: {
	        	url: "/UsersGridController/usersList",
		        dataSrc: '',
	        },
	        columns: [
	            { data: 'id' },
	            { data: 'email' },
	            { data: 'password' },
	            { data: 'lastLogin' },
	            { data: 'adminStatus' },
	            { data: null,
                  render: function ( data, type, row, meta ) {
                         return '<button class="btn" type="button" onclick="deleteUser(' + meta.row + ');"> DELETE </button>';
					}
	            }
	        ]	
	        
	    } )

	  
	} );
    
    function deleteUser(rowNum){
    	var table = $('#users-table').DataTable();
    	var rowData = table.row(rowNum).data();
    	var id = rowData.id;
    	
    	$.ajax({
    		url: "/UsersGridController/deleteUser",
    		type: 'post',
    		data: { 'id': id },
    		success: function() {
    			alert("Deleting User...");
    			table.ajax.reload();
    			},
    		error: function(xhr, status, error) {
    			var errorMessage = xhr.status + ': ' + xhr.statusText;
    			alert("Your changes could not be completed. Error: " + errorMessage);
    		}
    		});
    	}
    
    
	
	
	
	</script>

</body>
</html>