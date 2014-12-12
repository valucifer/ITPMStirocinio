<%@page import="it.unisa.tirocinio.beans.TrainingOffer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="it.unisa.tirocinio.manager.concrete.ConcreteMessageForServlet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta name="description" content="Xenon Boostrap Admin Panel" />
	<meta name="author" content="" />
	
	<title>DISTRA-MIT</title>

	<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Arimo:400,700,400italic">
	<link rel="stylesheet" href="../../assets/css/fonts/linecons/css/linecons.css">
	<link rel="stylesheet" href="../../assets/css/fonts/fontawesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="../../assets/css/bootstrap.css">
	<link rel="stylesheet" href="../../assets/css/xenon-core.css">
	<link rel="stylesheet" href="../../assets/css/xenon-forms.css">
	<link rel="stylesheet" href="../../assets/css/xenon-components.css">
	<link rel="stylesheet" href="../../assets/css/xenon-skins.css">
	<link rel="stylesheet" href="../../assets/css/custom.css">

	<script src="../../assets/js/jquery-1.11.1.min.js"></script>
        <script src="../../assets/js/tpProfessorLibrary.js"></script>
        <script src="../../assets/js/validatr.js"></script>
        
	<script>
            jQuery(document).ready(function ($) {
                $('form').validatr();
            });
        </script>
        
        <%
            pageContext.setAttribute("path", "\""+pageContext.getServletContext().getContextPath()+"\"");
        %>
        <script>
            function modifyTrainingToDatabase(idModify){
                $("#descriptionTrainingForModify").attr("placeholder",$('#paragraphDescriptionListTraining_'+idModify).text());
                $("#idForModifyTrainingProfessor").attr("value",idModify);
                jQuery('#modalGestioneTirocinioANDPlacementProfessore').modal('show', {backdrop: 'static'});
            }
            function removeTrainingToDatabase(idRemove){
                if(confirm("Sei sicuro di voler eliminare questo tirocinio?")){
                    tpProfessorFunction.deleteTraining(idRemove,${path });
                    setTimeout(function(){ location.reload(); }, 1000);
                }
            }
            jQuery(document).ready(function ($) {
                tpProfessorFunction.appendTraining('#listTrainingProfessore',${path });
            });
        </script>

	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
	
	
</head>
<body class="page-body">

	<nav class="navbar horizontal-menu navbar-fixed-top"><!-- set fixed position by adding class "navbar-fixed-top" -->
		
		<div class="navbar-inner">
		
			<!-- Navbar Brand -->
			<div class="navbar-brand">
				<a href="../../offertaFormativa/professore/offertaFormativaProfessore.html" class="logo">
					<img src="../../assets/images/mitforsite.png" width="80" alt="" class="hidden-xs" />
					<img src="../../assets/images/mitforsitemini.png" width="80" alt="" class="visible-xs" />
				</a>
			</div>
				
			<!-- Mobile Toggles Links -->
			<div class="nav navbar-mobile">
			
				<!-- This will toggle the mobile menu and will be visible only on mobile devices -->
				<div class="mobile-menu-toggle">
					
					<a href="#" data-toggle="user-info-menu-horizontal">
						<i class="fa-key"></i>
					</a>
					
					<a href="#" data-toggle="mobile-menu-horizontal">
						<i class="fa-bars"></i>
					</a>
				</div>
			</div>
			
			<div class="navbar-mobile-clear"></div>
			
			<!-- main menu -->
					
			<ul class="navbar-nav">
				<li>
					<a href="../../offertaFormativa/professore/offertaFormativaProfessore.html">
						<i class="linecons-desktop"></i>
						<span class="title">Offerta Formativa</span>
					</a>
				</li>
				<li>
					<a href="#">
						<i class="linecons-graduation-cap"></i>
						<span class="title">Gestione Tesi</span>
					</a>
				</li>
				<li class="opened active">
					<a href="../../tirocinio/professore/gestioneTirocinio&PlacementProfessore.html">
						<i class="linecons-megaphone"></i>
						<span class="title">Gestione Tirocinio</span>
					</a>
				</li>
				<li>
					<a href="#">
						<i class="linecons-lightbulb"></i>
						<span class="title">Dottorato</span>
					</a>
				</li>
                <li>
				    <a href="#">
				        <i class="linecons-globe"></i>
						<span class="title">Links</span>
					</a>
					<ul>
						<li>
							<a href="http://www.magistralemit.unisa.it/" target="_blank">
								<span class="title">DISTRA-MIT</span>
							</a>
						</li>
						<li>
							<a href="https://esse3web.unisa.it/unisa/Start.do" target="_blank">
								<span class="title">Esse3</span>
							</a>
						</li>
					</ul>
                </li>
			</ul>
			<!-- notifications and other links -->
			<ul class="nav nav-userinfo navbar-right">
                <li class="dropdown user-profile">
					<a href="#" data-toggle="dropdown">
						<img src="../../assets/images/user-1.png" alt="user-image" class="img-circle img-inline userpic-32" width="28" />
						<span id="spaceForUsername">
						</span>
					</a>
					
					<ul class="dropdown-menu user-profile-menu list-unstyled">
						<li>
							<a href="../../tirocinio/professore/gestioneTirocinio&PlacementProfessoreProfiloPersonale.html">
								<i class="fa-edit"></i>
								Profilo
							</a>
						</li>
						<li class="last">
							<a href="#" id="logout">
								<i class="fa-lock"></i>
								Logout
							</a>
						</li>
					</ul>
				</li>
			</ul>
	
		</div>
		
	</nav>
	<div class="page-container"><!-- add class "sidebar-collapsed" to close sidebar by default, "chat-visible" to make chat appear always -->
			
		<!-- Add "fixed" class to make the sidebar fixed always to the browser viewport. -->
		<!-- Adding class "toggle-others" will keep only one menu item open at a time. -->
		<!-- Adding class "collapsed" collapse sidebar root elements and show only icons. -->
		<div class="sidebar-menu toggle-others">
			<div class="sidebar-menu-inner">	
				<ul id="main-menu" class="main-menu">
					<!-- add class "multiple-expanded" to allow multiple submenus to open -->
					<!-- class "auto-inherit-active-class" will automatically add "active" class for parent elements who are marked already with class "active" -->
					<li id="offertaTirocini" class="opened active">
						<a href="../../tirocinio/professore/gestioneTirocinio&PlacementProfessore.html">
							<i class="linecons-cog"></i>
							<span class="title">Offerta Tirocinio</span>
						</a>
					</li>
				</ul>
			</div>
		</div>
		
		<div class="main-content">
					
			<script>
				jQuery(document).ready(function($)
				{
					$('a[href="#layout-variants"]').on('click', function(ev)
					{
						ev.preventDefault();
						
						var win = {top: $(window).scrollTop(), toTop: $("#layout-variants").offset().top - 15};
						
						TweenLite.to(win, .3, {top: win.toTop, roundProps: ["top"], ease: Sine.easeInOut, onUpdate: function()
							{
								$(window).scrollTop(win.top);
							}
						});
					});
				});
			</script>
			
			<div class="row">
				<div class="col-sm-12">
					
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Aggiungi Offerta di Tirocinio</h3>
						</div>
						<div class="panel-body">
							<p align="justify">
								Questa sezione è adibita all'inserimento di un'offerta di tirocinio. Completa i campi sottostanti per rendere l'offerta visualizzabile agli studenti; al termine di questa operazione, potrai visualizzare tutti i tirocini inseriti nella tabella di riepilogo nel pannello sottostante. Puoi ovviamente inserire più tirocini per gli studenti interessati utilizzando sempre questo modulo.
							</p>
							<br>
								
							<form role="form" class="form-horizontal" action="/ServerWeb/insertTrainingByProfessorServlet" method="POST">
								<div class="form-group">
									<label class="col-sm-2 control-label" for="field-2">Descrizione del Tirocinio</label>
									<div class="col-sm-10">
										<textarea name="description" id="descriptionTrainingProfessore" required class="form-control" rows="5" cols="5" placeholder="Descrizione..." maxlength="250"></textarea>
										<span id="validate_descriptionTrainingProfessore" style="color:#cc3f44"></span>
									</div>
								</div>
								
								<div class="col-sm-12">
									<div id="messageTrainingControl" align="center"></div>
								</div>
								
								<div class="form-group">
									<center>
										<button type="submit" class="btn btn-secondary btn-single" id="addTrainingProfessore">
											<i class="fa-plus"></i>
											<span>Aggiungi Tirocinio</span>
										</button>
									</center>
								</div>
							</form>
						</div>
					</div>
					
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							Lista dei tirocini aggiunti
						</div>
						<div class="panel-body">
							<div class="col-sm-12">
								<div id="listTrainingProfessore" class="list-group">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<!-- Main Footer -->
			<!-- Choose between footer styles: "footer-type-1" or "footer-type-2" -->
			<!-- Add class "sticky" to  always stick the footer to the end of page (if page contents is small) -->
			<!-- Or class "fixed" to  always fix the footer to the end of page -->
			<footer class="main-footer sticky footer-type-1">
				
				<div class="footer-inner">
				
					<!-- Add your copyright text here -->
					<div class="footer-text">
						&copy; 2014 
						<strong>Unisa</strong> 
						<a href="http://www.unisa.it" target="_blank"></a>
					</div>
					
					
					<!-- Go to Top Link, just add rel="go-top" to any link to add this functionality -->
					<div class="go-up">
					
						<a href="#" rel="go-top">
							<i class="fa-angle-up"></i>
						</a>
						
					</div>
					
				</div>
				
			</footer>
		</div>
		
	</div>
	<div class="modal fade" id="modalGestioneTirocinioANDPlacementProfessore">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<center><h4 class="modal-title">Modifica il Tirocinio.</h4></center>
				</div>
                                <form role="form" class="form-horizontal" action="/ServerWeb/updateTrainingOfferByProfessorServlet" method="POST">
                                    <div class="modal-body">
                                            <div class="row">
                                                    <div class="col-md-12">
                                                            <div class="form-group">
                                                                    <label for="descriptionTrainingForModify" class="col-sm-3 control-label">Descrizione del Tirocinio</label>
                                                                    <div class="col-sm-9">
                                                                            <input type="hidden" name="idModify" id="idForModifyTrainingProfessor">
                                                                            <textarea required name="description" id="descriptionTrainingForModify" class="form-control" placeholder="" rows="5" cols="5" maxlength="250"></textarea>
                                                                    </div>
                                                            </div>	
                                                    </div>
                                            </div>
                                    </div>
                                    <div class="modal-footer">
                                            <center>
                                                    <button type="button" class="btn btn-white" data-dismiss="modal">Close</button>
                                                    <button type="submit" id="modifyDataForTrainingIntoDatabase" class="btn btn-orange">Modifica</button>
                                            </center>
                                    </div>
                                </form>
			</div>
		</div>
	</div>
	
	<div class="page-loading-overlay">
		<div class="loader-2"></div>
	</div>
	
	<!-- Bottom Scripts -->
	<script src="../../assets/js/bootstrap.min.js"></script>
	<script src="../../assets/js/TweenMax.min.js"></script>
	<script src="../../assets/js/resizeable.js"></script>
	<script src="../../assets/js/joinable.js"></script>
	<script src="../../assets/js/xenon-api.js"></script>
	<script src="../../assets/js/xenon-toggles.js"></script>


	<!-- JavaScripts initializations and stuff -->
	<script src="../../assets/js/xenon-custom.js"></script>
	<script>		
		function emptyControl(id){
			if($("#"+id).val() == "")
				return false;
			return true;
		}
		
		function checkNotEmptyFields(){
			var tmp2 = emptyControl("descriptionTrainingProfessore");
			if(!tmp2) {
				$("#validate_descriptionTrainingProfessore").html("Campo descrizione vuoto");
				$("#descriptionTrainingProfessore").attr("style","border-color:#cc3f44;");
			}
			
			return tmp2;
		}
		
		jQuery(document).ready(function($){
		
			$("#descriptionTrainingProfessore").keyup(function(){
				$("#descriptionTrainingProfessore").attr("style","border-color:#e4e4e4;");
				$("#validate_descriptionTrainingProfessore").html("");
			});
			
		});
	</script>
	
</body>
</html>