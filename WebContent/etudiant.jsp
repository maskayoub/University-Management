<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page import="metier.GestionEtudiant" %>
     <%@ page import="metier.Etudiant" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="testcss/helpstyle.css">
</head>
<body>
<br>

<br>
<br>
			<%
				String id = request.getParameter("cne");
				GestionEtudiant metier = new GestionEtudiant();
				Etudiant e = metier.getEtudiant(id);
				
				%>
		
		<div class="container">
				<form method="post" action="edit.php" name="ajouterEtudiant" role="form">
						<div class="form-group">
							<label>CNE</label>
							<input type="text" class="form-control" name="numEt" value="<%=id %>" required>
						</div>
						<div class="form-group">
							<label>Nom</label>
							<input type="text" class="form-control" name="nomEt" value="<%= e.getNomEt() %>"required>
						</div>				
						<div class="form-group">
							<label>Prénom</label>
							<input type="text" class="form-control" name="prenomEt"  value="<%=e.getPrenomEt() %>" required>
						</div>
						 <div class="form-group">
                                    <label>Sexe</label>
                                    <div class="p-t-10">
                                        <label class="radio-container m-r-45">Homme
                                            <input type="radio"  name="sexe"  value="H">
                                            <span class="checkmark"></span>
                                        </label>
                                        <label class="radio-container">Femme
                                            <input type="radio" name="sexe"  value="F">
                                            <span class="checkmark"></span>
                                        </label>
                                    </div>
                                   
                                </div>
                            
						<div class="form-group">
							<label>Date de Naissance</label>
							<input type="date"class="form-control" name="dateNaiss" value="<%=e.getDateNaiss() %>" required>
						</div>
						<div class="form-group">
							<label>Lieu de Naissance</label>
							<input type="text"class="form-control" name="lieuNaiss" value="<%=e.getLieuNaiss() %>"required>
						</div>
						<div class="form-group">
							<label>Email</label>
							<input type="email" class="form-control" name="email" value="<%=e.getEmail() %>" required>
						</div>
						<div class="form-group">
							<label>N° Tel</label>
							<input type="text" class="form-control" name="numTel"value="<%=e.getNumTel() %>" required>
						</div>
						<div class="form-group">
                            <label class="label">Semestre</label>
                            <div class="rs-select2 js-select-simple select--no-search">
                                <select name="semestre">
                                    <option>S1</option>
                                    <option>S2</option>
                                    <option>S3</option>
                                    <option>S4</option>
                                    <option>S5</option>
                                </select>
                                <div class="select-dropdown"></div>
                            </div>
                        </div>	

			
			<input type="submit" name="action" value="Update" class="btn btn-warning"/>
			
			<a href="${pageContext.request.contextPath}/connexion.php" class="btn btn-default">Tous les Etudiants</a>
			</form>
	</div>
  <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</body>
</html>