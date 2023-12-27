<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="./base.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	background: url('<c:url value="/resources/img/pms.jpg"/>') no-repeat
		center center fixed;
	background-size: cover;
}
</style>
</head>
<body>

	<div class="container mt-3">

		<div class="row">

			<div class="col-md-12">
				<h1 class="text-center mb-3">All Medicine Detail</h1>
				<table class="table table-dark">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Medicine Id</th>
							<th scope="col">Medicine Name</th>
							<th scope="col">Medicine Quantity</th>
							<th scope="col">Medicine Price</th>
							<th scope="col">Manufacturer Date</th>
							<th scope="col">Expiry Date</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${medicine}" var="m">
							<tr>
								<th scope="row">Med${m.medicineId}</th>
								<td>${m.medicineName}</td>
								<td>${m.medicineQuantity}</td>
								<td class="font-weight-bold">&#x20B9; ${m.medicinePrice}</td>
								<td>${m.manufacturerDate}</td>
								<td>${m.expiryDate}</td>
								<td><a href="delete/${m.medicineId}"> <i
										class="fa-solid fa-trash text-danger" style="font-size: 20px"></i>
								</a> <a href="update/${m.medicineId}"> <i
										class="fa-solid fa-pen-nib text-primary"
										style="font-size: 20px"></i>
								</a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
				<div class="container text-center">
					<a href="${pageContext.request.contextPath }/Main"
						class="btn btn-outline-primary">Back</a>
				</div>
			</div>

		</div>

	</div>

</body>
</html>
