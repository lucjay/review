<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<title>boot.jsp</title>
<style type="text/css">
</style>
</head>
<body>
	<div class="container">
		<!-- Content here -->

		<!-- help start -->
		<div>
			<div class="alert alert-primary" role="alert">
				A simple primary alert—check it out!
				<button type="button" class="btn btn-primary">
					Notifications <span class="badge badge-light">4</span>
				</button>
			</div>

			<!-- help end -->


			<div class="row align-items-center">
				<!-- list start -->
				<div class="col-xl-6 col-md-12 col-sm-12 table-responsive">
					<table class="table border">
						<thead class="thead-dark">
							<tr>
								<th scope="row">번호</th>
								<th>이름</th>
								<th>전화번호</th>
							</tr>
						</thead>
						<tbody>
							<tr class="bg-primary">
								<td>4</td>
								<td>5</td>
								<td class="text-break" style="max-width: 150px;">Use border
									utilities to add or remove an element’s borders. Choose from
									all borders or one at a time.</td>
							</tr>
							<tr class="bg-success">
								<td>7</td>
								<td>8</td>
								<td>9</td>
							</tr>
							<tr class="bg-warning">
								<td>10</td>
								<td>11</td>
								<td>12</td>
							</tr>
					</table>
					<nav aria-label="Page navigation example">
						<ul class="pagination">
							<li class="page-item"><a class="page-link" href="#">Previous</a></li>
							<li class="page-item"><a class="page-link" href="#">1</a></li>
							<li class="page-item"><a class="page-link" href="#">2</a></li>
							<li class="page-item"><a class="page-link" href="#">3</a></li>
							<li class="page-item"><a class="page-link" href="#">Next</a></li>
						</ul>
					</nav>
				</div>

				<!-- list end -->

				<!-- start form -->
				<div class="col-xl-6 col-md-12 col-sm-12 border bg-light">
					<br>
					<!-- button group start -->
					<div class="row">
						<div class="col-auto mr-auto"></div>
						<div class="col-auto"></div>

						<div>
							<button class="btn btn-outline-primary">등록</button>
							<span class="btn btn-outline-warning">수정</span> <a href="#"
								class="btn btn-outline-danger">삭제</a>
						</div>
					</div>
					<br>
					<div>
						<!-- button group end -->
						<!-- start -->
						<form action="" method="post">
							<div class="row form-group">
								<label for="id" class="col-4">ID</label>
								<div class="col">
									<input type="text" id="id" name="id" class="form-control"
										placeholder="ID" autofocus="autofocus" tabindex="1">
								</div>
							</div>
							<div class="row form-group">
								<label for="pw" class="col-4">PW </label>
								<div class="col">
									<input type="password" id="pw" name="pw" class="form-control"
										placeholder="PASSWORD" tabindex="2">
								</div>
							</div>
							<div class="row form-group">
								<label for="role" class="col-4">ROLE </label>
								<div class="col">
									<div class="form-check form-check-inline">
										<input type="radio" class="form-check-input" id="admin"
											name="role" value="admin"><label for="admin"
											class="form-check-label">Admin</label>
									</div>
									<div class="form-check form-check-inline">
										<input type="radio" class="form-check-input" id="user"
											name="role" value="user"> <label for="user"
											class="form-check-label">User</label>
									</div>
								</div>
							</div>
							<div class="row form-group">
								<label for="jobs" class="col-4">JOB </label>
								<div class="col">
									<select id="jobs" name="jobs"
										class="form-control form-control-md">
										<option value="se">개발자</option>
										<option value="ds">디자이너</option>
									</select>
								</div>
							</div>
							<div>
								<label for="reason" class="col-4">가입동기 </label>
								<textarea name="reason" rows="10" cols="30"></textarea>
							</div>
							<div>
								<label for="hobbys">HOBBY </label> <input type="checkbox"
									id="hobby1" name="hobby1" value="movie"> <label
									for="hobby2">영화</label> <input type="checkbox" id="hobby2"
									name="hobby2" value="music"> <label for="hobby2">음악</label><input
									type="checkbox" id="hobby3" name="hobby3" value="ex"> <label
									for="hobby3">운동</label>
							</div>
							<div>
								<label for="addr">ADDRESS </label><input type="text" id="addr"
									name="addr">
								<button type="button">검색</button>
							</div>
							<br>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>