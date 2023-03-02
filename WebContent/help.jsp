<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Gestion Etudiants</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="testcss/helpstyle.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" >

<script type="text/javascript">
$(document).ready(function(){
	// Activate tooltip
	$('[data-toggle="tooltip"]').tooltip();
	
	// Select/Deselect checkboxes
	var checkbox = $('table tbody input[type="checkbox"]');
	$("#selectAll").click(function(){
		if(this.checked){
			checkbox.each(function(){
				this.checked = true;                        
			});
		} else{
			checkbox.each(function(){
				this.checked = false;                        
			});
		} 
	});
	checkbox.click(function(){
		if(!this.checked){
			$("#selectAll").prop("checked", false);
		}
	});
});


</script>

<script>/*
$('#deleteEmployeeModal').on('show.bs.modal', function(e){
		var cne = $(e.relatedTarget).data('cne');
		$(e.currentTarget).find('input[name="cne"]').val(cne);
		
return cne;});*/
</script>
</head>
<body>

	<% if(session.getAttribute("sessionUtilisateur")==null)
		{response.sendRedirect("home2.jsp");}%>
		

    <div class="container-fluid">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                
                    <div class="col-sm-9">
						<h2 id="lol">Gestion <b>Etudiants</b></h2>
					</div>
					</div>
				<div class="row">
				
				<div class="col-8 col-sm-6">
				<div class="input-group mb-3">
				<form method="post" action="chercher.php">
 						 <input type="text" class="form-control" placeholder="Nom etudiant" name="motCle"aria-label="nom" aria-describedby="basic-addon2">
  							<div class="input-group-append">
   							 <button class="btn btn-outline-secondary" type="submit">Chercher</button>
						  </div>
						   </form>

				</div>
				</div>
				<div class="col-6">
				<c:if test="${!empty sessionScope.sessionUtilisateur }">
                	<p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionUtilisateur.email }</p>
                	
               	</c:if></div>	
					<div class="col-4 col-sm-6">
				<form method="post" action="list.php">
					
						<a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Ajouter</span></a>
						<a href="${pageContext.request.contextPath}/connexion.php" class="btn btn-info" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Tous les Etudiants</span></a>
						<a href="index.jsp"	class="btn btn-danger"><span>Accueil</span></a>
						</form>
					</div>
				
                </div>
            </div>
            <table class="table table-striped table-hover" id="list" >
                <thead>
                    <tr>
						<th>
							<span class="custom-checkbox">
								<input type="checkbox" id="selectAll">
								<label for="selectAll"></label>
							</span>
						</th>
                        <th>CNE</th>
                        <th>Nom</th>
						<th>Prénom</th>
						<th>Date de Naissance</th>
                        <th>Lieu de Naissance</th>
                        <th>Sexe</th>
                        <th>E-mail</th>
                        <th>N° Tel</th>
                        <th>Semestre</th>
                        
                    </tr>
                </thead>
                <tbody>
               
                
                <c:forEach items="${model.etudiants}"  var="e">
               
	<tr>
	<td>
							<span class="custom-checkbox">
								<input type="checkbox" id="checkbox1" name="options[]" value="1">
								<label for="checkbox1"></label>
							</span>
						</td>
					<td>${e.numEt}</td>
					<td>${e.nomEt}</td>
					<td><c:out value="${e.prenomEt }" /></td>
					<td><c:out value="${e.dateNaiss}" /></td>
					<td><c:out value="${e.lieuNaiss}" /></td>
					<td><c:out value="${e.sexe}" /></td>
					<td><c:out value="${e.email}" /></td>
					<td><c:out value="${e.numTel}" /></td>
					<td><c:out value="${e.semestre}" /></td>
					<td>
                          <a href="etudiant.jsp?action=edit&cne=${e.numEt}" class="edit edit_data"  data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>  
                            <a href="delete.php?action=delete&cne=${e.numEt }"  onclick="return confirm('Are you sure you want to delete this item?');" class="delete"  data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                 			<!--  <a href="" ><i class="icon-eye-open" title="view">&#xE02b;</i></a>-->
                           <!--  <a href="etudiant.jsp?action=edit&cne=${e.numEt}" class="view view_data" ><i class="fas fa-eye"></i></a> -->
                           <!-- <input type="submit" data-toggle="modal" class="fas fa-eye" data-target="#myModal"> -->
                           <a href="#myModal" id="view" data-toggle="modal" data-target="#myModal" class="view view_data"><i class="fas fa-eye"></i></a>
                 			
                        </td>
                        <td><input type="hidden" value="${e.numEt}" id="numEt"></td>
                        
					
					</tr>
					
				</c:forEach>
                   
                </tbody>
            </table>
          
        </div>
    </div>
    <script>/*
    $(document).ready(function(){
    	$(document).on('click','edit', function(){
    		var etudiant_id = $(this).attr("id");
    		$.ajax({
    			url:"controller.php",
   				method:"POST",
   				data:{etudiant_id:etudiant_id},
   				dataType:"json",
   				success:function(data){
   					$('#nomEt').val(data.nomEt);
   					$('#prenomEt').val(data.prenomEt);
   					$('#sexe').val(data.sexe);
   					$('#dateNaiss').val(data.dateNaiss);
   					$('#lieuNaiss').val(data.lieuNaiss);
   					$('#email').val(data.email);
   					$('#numTel').val(data.numTel);
   					$('#semestre').val(data.semestre);
   					$('#editEmployeeModal').modal('show');
   					
   				}
   				
    		});
    	});
    });*/
    
    </script>
 <!-- Delete Modal HTML -->
	  	 <div id="deleteEmployeeModal"  class="modal fade" tabindex="-1" role="dialog">
                            
		<div class="modal-dialog">
			<div class="modal-content">
				
					<div class="modal-header">						
						<h4 class="modal-title">Supprimer Etudiant</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					
					<form method="post" action="delete.php">
					<div class="modal-body">
						
						  <input type="hidden" name="cne" id="cne" value=""/>				
						<p>Êtes-vous sûrs de vouloir supprimer ces enregistrements?</p>
						<p class="text-warning"><small>Cette action ne peut pas être annulée.</small></p>
					</div>
					
					<div class="modal-footer">
						<button type="button"	class="btn btn-default" data-dismiss="modal" >Cancel</button> 
					<!--  	<button  name="action" id="btnYes" class="btn btn-danger btn-ok" value="delete">Delete</button> -->
					<a class="btn btn-danger btn-ok">Delete</a>
					</div>
					</form>
			
			</div>
			
		</div>
	</div>
	
	<script>/*
	function updateEtudiant() {
		$.ajax({
			type:"POST",
			url:"edit.php"+"?id="+$("#numEt").val(),
			data:"nomEt="+$("#nomEt").val()+"&prenomEt="+$("#prenomEt").val()+"&dateNaiss="+$("#dateNaiss").val()+
			"&lieuNaiss="+$("#lieuNaiss").val()+"&sexe="+$("#sexe").val()+"&email="+$("#email").val()+
            	 "&numTel="+$("#numTel").val()+"&numEt="+$("#numEt").val(),
            success:function(result){
            	var ht= result.msg;
    			$("#resp").html(ht);
            },
            error: function(result){
            	alert("Some error occured.");
            	console.log(numEt);
            }
		});	
	}*/
	</script>
 
	<!-- Add Modal HTML -->
	
	<div id="addEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form method="post" action="ajout.php">
					<div class="modal-header">						
						<h4 class="modal-title">Ajouter Etudiant</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">	
					<div class="form-group">
							<label>CNE</label>
							<input type="text" class="form-control" name="numEt" required>
						</div>
						<div class="form-group">
							<label>Nom</label>
							<input type="text" class="form-control" name="nomEt" required>
						</div>				
						<div class="form-group">
							<label>Prénom</label>
							<input type="text" class="form-control" name="prenomEt" required>
						</div>
						 <div class="form-group">
                                    <label class="label">Sexe</label>
                                    <div class="p-t-10">
                                        <label class="radio-container m-r-45">Homme
                                            <input type="radio" checked="checked" name="sexe" value="H">
                                            <span class="checkmark"></span>
                                        </label>
                                        <label class="radio-container">Femme
                                            <input type="radio" name="sexe" value="F">
                                            <span class="checkmark"></span>
                                        </label>
                                    </div>
                                   
                                </div>
                            
						<div class="form-group">
							<label>Date de Naissance</label>
							<input type="date"class="form-control" name="dateNaiss" required>
						</div>
						<div class="form-group">
							<label>Lieu de Naissance</label>
							<input type="text"class="form-control" name="lieuNaiss"required>
						</div>
						<div class="form-group">
							<label>Email</label>
							<input type="email" class="form-control" name="email" required>
						</div>
						<div class="form-group">
							<label>N° Tel</label>
							<input type="text" class="form-control" name="numTel" required>
						</div>
						 <div class="form-group">
                                    <label>Filière</label>
                                    <div class="p-t-10">
                                        <label class="radio-container m-r-45">GI
                                            <input type="radio" checked="checked" name="codeFil" value="GI">
                                            <span class="checkmark"></span>
                                        </label>
                                        <label class="radio-container">GB
                                            <input type="radio" name="codeFil" value="GB">
                                            <span class="checkmark"></span>
                                        </label>
                                        <label class="radio-container">CA
                                            <input type="radio" name="codeFil" value="CA">
                                            <span class="checkmark"></span>
                                        </label>
                                    </div>
                                   
                                </div>
						<div class="form-group">
                            <label>Semestre</label>
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
                        <div class="form-group">
							<label>Date d'inscription</label>
							<input type="date"class="form-control" name="dateInscription" required>
						</div>	
						 <div class="form-group">
                                    <label class="label">Groupe</label>
                                    <div class="p-t-10">
                                        <label class="radio-container m-r-45">A
                                            <input type="radio" checked="checked" name="groupe" value="A">
                                            <span class="checkmark"></span>
                                        </label>
                                        <label class="radio-container">B
                                            <input type="radio" name="groupe" value="B">
                                            <span class="checkmark"></span>
                                        </label>
                                    </div>
                                   
                                </div>
							
					</div>
					<div class="modal-footer">
						<button	class="btn btn-default" data-dismiss="modal" >Cancel</button> 
						<button type="submit" class="btn btn-success" >Save</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Edit Modal HTML -->
<div class="myForm">
	
	<div id="myModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				
					<div class="modal-header">						
						<h4 class="modal-title">Modifier Etudiant</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
					<form method="post" action="edit.php">				
						<div class="form-group">
							<label>Nom</label>
							<input type="text" class="form-control" name="nomEt" value="${model.etudiant.nomEt }" id="nomEt" required>
						</div>				
						<div class="form-group">
							<label>Prénom</label>
							<input type="text" class="form-control" name="prenomEt" value="${model.etudiant.prenomEt }" id="prenomEt" required>
						</div>
						 <div class="form-group">
                                    <label class="label">Sexe</label>
                                    <div class="p-t-10">
                                        <label class="radio-container m-r-45">Homme
                                            <input type="radio" checked="checked" name="sexe"  value="H" id="sexe">
                                            <span class="checkmark"></span>
                                        </label>
                                        <label class="radio-container">Femme
                                            <input type="radio" name="sexe" value="F" id="sexe">
                                            <span class="checkmark"></span>
                                        </label>
                                    </div>
                                   
                                </div>
                            
						<div class="form-group">
							<label>Date de Naissance</label>
							<input type="date"class="form-control" name="dateNaiss" value="${model.etudiant.dateNaiss }" id="dateNaiss" required>
						</div>
						<div class="form-group">
							<label>Lieu de Naissance</label>
							<input type="text"class="form-control" name="lieuNaiss" value="${model.etudiant.lieuNaiss }" id="lieuNaiss"required>
						</div>
						<div class="form-group">
							<label>Email</label>
							<input type="email" class="form-control" name="email" value="${model.etudiant.email }" id="email" required>
						</div>
						<div class="form-group">
							<label>N° Tel</label>
							<input type="text" class="form-control" name="numTel" value="${model.etudiant.numTel}" id="numTel" required>
						</div>
						<div class="form-group">
                            <label class="label">Semestre</label>
                            <div class="rs-select2 js-select-simple select--no-search">
                                <select name="semestre"  id="semestre">
                                    <option>S1</option>
                                    <option>S2</option>
                                    <option>S3</option>
                                    <option>S4</option>
                                    <option>S5</option>
                                </select>
                                <div class="select-dropdown"></div>
                            </div>
                        </div>
                        <div class="form-group">
                        <input type="hidden" name="numEt" id="numEt" value="${model.etudiant.numEt }">
                        </div>
                       	</form>
					</div>
					<div class="modal-footer">
						
						
						<button	class="btn btn-default" data-dismiss="modal" >Cancel</button> 
						<button type="submit" onclick="updateEtudiant();" class="btn btn-info" value="Save" name="action">Save</button>
						<div id="resp" class="text-center" style="margin-top: 13px;"></div>
					</div>
			
			</div>
		</div>
	</div>
	</div>
	
	

	
	
	<script>/*
	$(document).ready(function(){
		$(".delete").click(function(){
			var id = this.id;
			$.ajax({
				url:"ControleurServlet.java",
				type:"post",
				data:{id:id},
				success: function(data){
					alert(data);
					location.reload();
				}
				
			});
		});
	});*/</script>
	 
	
	
	
	<script>/*
	$('#deleteEmployeeModal').on('show', function() {
	    var id = $(this).data('id'),
	        removeBtn = $(this).find('.danger');
	})

	$('.delete').on('click', function(e) {
	    e.preventDefault();

	    var id = $(this).data('id');
	    $('#deleteEmployeeModal').data('id', id);
	});

	$('#btnYes').click(function() {
	    // handle deletion here
	  	var id = $('#deleteEmployeeModal').data('id');
	  	$('[data-id='+id+']').parents('tr').remove();
	    $('#deleteEmployeeModal').modal('hide');
	  	
	  	
	});*/
	</script>
	
	
	
</body>

</html>                                		                                                       		                            