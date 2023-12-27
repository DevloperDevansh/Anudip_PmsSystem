<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./base.jsp"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
</head>
<style>
body {
	background: url('<c:url value="/resources/img/pms.jpg"/>') no-repeat
		center center fixed;
	background-size: cover;
}
</style>
<body>

	<div class="container mt-5">
		<div class="row justify-content-center">
			<h1>Welcome to Pharmacy Management Store</h1>
			<div class="col-md-6">
				<div class="card">
					<div class="card-header">
						<h3 class="text-center">Login</h3>
					</div>
					<c:if test="${not empty error}">
						<div class="alert alert-danger" role="alert">${error}</div>
					</c:if>
					<div class="card-body">
						<!-- Your login form -->
						<form action="${pageContext.request.contextPath}/loginpage"
							method="post">
							<div class="form-group">
								<label for="username">Username:</label> <input type="text"
									class="form-control" id="username" name="username" required>
							</div>
							<div class="form-group">
								<label for="password">Password:</label> <input type="password"
									class="form-control" id="password" name="password" required>
							</div>
							<button type="submit" class="btn btn-primary btn-block">Login</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
