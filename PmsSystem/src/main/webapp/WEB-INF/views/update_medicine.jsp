<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="./base.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="container mt-5">
		<!-- Your add medicine form goes here -->

		<h1 class="text-center">Update Medicine</h1>
		<form action="${pageContext.request.contextPath}/handle-medicine" method="post">
		 <input type = "hidden" value="${m.medicineId}" name ="medicineId"/>
			<div class="form-group">
				<label for="medicineName">Medicine Name:</label> <input type="text"
					class="form-control" id="medicineName" name="medicineName" 
					value="${m.medicineName }" required>
			</div>
			<div class="form-group">
				<label for="medicineQuantity">Medicine Quantity:</label> <input
					type="number" class="form-control" id="medicineQuantity"
					name="medicineQuantity" 
					value="${m.medicineQuantity }"required>
			</div>
			<div class="form-group">
				<label for="medicinePrice">Medicine Price:</label> <input
					type="number" class="form-control" id="medicinePrice"
					name="medicinePrice" 
					value="${m.medicinePrice }"required>
			</div>
			<div class="form-group">
				<label for="manufacturerDate">Manufacturer Date:</label> <input
					type="date" class="form-control" id="manufacturerDate"
					name="manufacturerDate" required pattern="\d{4}-\d{2}-\d{2}"
					value="${m.manufacturerDate }">
			</div>
			<div class="form-group">
				<label for="expiryDate">Expiry Date:</label> <input type="date"
					class="form-control" id="expiryDate" name="expiryDate" required
					pattern="\d{4}-\d{2}-\d{2}" value="${m.expiryDate }">
			</div>

			<!-- Add more form fields as needed -->
			<div class="container text-center">
				<a href="${pageContext.request.contextPath }/Main"
					class="btn btn-outline-danger">Back</a>
				<button type="submit" class="btn btn-primary">Update Medicine</button>
			</div>

		</form>


	</div>

</body>
</html>
