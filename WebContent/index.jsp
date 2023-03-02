<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Acceuil</title>
<meta charset="UTF-8">
	<meta name="description" content="WebUni Education Template">
	<meta name="keywords" content="webuni, education, creative, html">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- Favicon -->   
	<link href="img/favicon.ico" rel="shortcut icon"/>

	<!-- Google Fonts -->
	<link href="https://fonts.googleapis.com/css?family=Raleway:400,400i,500,500i,600,600i,700,700i,800,800i" rel="stylesheet">

	<!-- Stylesheets -->
	<link rel="stylesheet" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" href="css/font-awesome.min.css"/>
	<link rel="stylesheet" href="css/owl.carousel.css"/>
	<link rel="stylesheet" href="css/style.css"/>

</head>
<body>
<% if(session.getAttribute("sessionUtilisateur")==null)
		{response.sendRedirect("home2.jsp");}%>

<header class="header-section">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-3">
					
					<div class="nav-switch">
						<i class="fa fa-bars"></i>
					</div>
				</div>
				<div class="col-lg-9 col-md-9">
					
					<nav class="main-menu">
						<ul>
							<li><a href="index.jsp">Acceuil</a></li>
							<li><a href="help.jsp">Etudiants</a></li>
							<li><a href="courses.html">Abscences</a></li>
							<li><a href="blog.html">Salles</a></li>
							<li><a href="contact.html">A Propos</a></li>
						</ul>
						<form class="intro-newslatter" action="Logout" method="post">
						<button class="site-btn">Se Déconnecter</button>							
						</form>
					</nav>
				</div>
			</div>
		</div>
	</header>
	<section class="hero-section set-bg" data-setbg="img/login.jpg">
		</section>
		<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/mixitup.min.js"></script>
	<script src="js/circle-progress.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/main.js"></script>


</body>
</html>