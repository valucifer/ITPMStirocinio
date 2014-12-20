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
        <link rel="stylesheet" href="../../assets/css/bootstrap-mod.css">
        <link rel="stylesheet" href="../../assets/css/xenon-core.css">
        <link rel="stylesheet" href="../../assets/css/xenon-forms.css">
        <link rel="stylesheet" href="../../assets/css/xenon-components.css">
        <link rel="stylesheet" href="../../assets/css/xenon-skins.css">
        <link rel="stylesheet" href="../../assets/css/custom.css">

        <script src="../../assets/js/jquery-1.11.1.min.js"></script>
        <script src="../../assets/js/tpAdministratorLibrary.js"></script>
        <script src="../../assets/js/validatr.js"></script>

        <script>
            jQuery(document).ready(function ($) {
                $('form').validatr();
            });
        </script>

        <%
            pageContext.setAttribute("path", "\"" + pageContext.getServletContext().getContextPath() + "\"");
        %>
        <script>
            function functionDownload(idStudent, typology) {
                tpAdminFunction.downloadFile(idStudent, typology, ${path });
            }

            function rejectTrainingRequest(count, email) {
                if ($("#esDocumentError").is(":checked")) {
                    $("#esDocumentError").click();
                }
                if ($("#cfuNotFoundError").is(":checked")) {
                    $("#cfuNotFoundError").click();
                }
                $("#textareaDescriptionError").val("");
                $("#serialNumberModalForReject").val(count);
                $("#hiddenErroriRiscontrati").attr("value", count);
                $("#nameANDsurnameModalForReject").val(email);
                jQuery('#modalGestioneTirocinioANDPlacementAmministratore').modal('show', {backdrop: 'static'});
            }

            function acceptTrainingRequest(idRequest, email) {
                tpAdminFunction.acceptStudentForTraining(idRequest, ${path });
                setTimeout(function () {
                    location.reload();
                }, 1000);
            }
            function completeTrainingRequest(idComplete) {
                tpAdminFunction.completeStudentForTraining(idComplete, ${path });
                alert("Lo studente " + idComplete + " ha concluso il tirocinio!");
                setTimeout(function () {
                    location.reload();
                }, 1000);
            }

            jQuery(document).ready(function ($) {
                tpAdminFunction.appendStudentInformation('#tableNotifications',${path });
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
                    <a href="../../offertaFormativa/amministratore/offertaFormativaAmministratore.html" class="logo">
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
                        <a href="../../offertaFormativa/amministratore/offertaFormativaAmministratore.html">
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
                        <a href="../../tirocinio/amministratore/tpamministratore.jsp">
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
                                ${sessionScope.person.name } ${sessionScope.person.surname }
                            </span>
                        </a>

                        <ul class="dropdown-menu user-profile-menu list-unstyled">
                            <li>
                                <a href="../../tirocinio/amministratore/gestioneTirocinio&PlacementAmministratoreProfiloPersonale.html">
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
                        <li  class="opened active">
                            <a href="#">
                                <i class="linecons-cog"></i>
                                <span class="title">Offerta Tirocinio</span>
                            </a>
                        </li>
                        <li>
                            <a href="../../tirocinio/amministratore/tpinserimentofileamministratore.jsp">
                                <i class="linecons-cog"></i>
                                <span class="title">Inserimento Moduli</span>
                            </a>
                        </li>
                        <li>
                            <a href="../../tirocinio/amministratore/tpassociazioneprofessoreazienda.jsp">
                                <i class="linecons-cog"></i>
                                <span class="title">Associa Professore</span>
                            </a>
                        </li>
                        <li>
                            <a href="../../tirocinio/amministratore/tpregisteranorganization.jsp">
                                <i class="linecons-cog"></i>
                                <span class="title">Registra Azienda</span>
                            </a>
                        </li>
                        <li>
                            <a href="../../tirocinio/amministratore/tpaggiungistudentetraining.jsp">
                                <i class="linecons-cog"></i>
                                <span class="title">Aggiungi Tirocinio</span>
                            </a>
                        </li>
                        <li>
                            <a href="../../tirocinio/amministratore/tpvisionetirocini.jsp">
                                <i class="linecons-cog"></i>
                                <span class="title">Visione Tirocini</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>

            <div class="main-content">

                <script>
                    jQuery(document).ready(function ($) {
                        $('a[href="#layout-variants"]').on('click', function (ev)
                        {
                            ev.preventDefault();

                            var win = {top: $(window).scrollTop(), toTop: $("#layout-variants").offset().top - 15};

                            TweenLite.to(win, .3, {top: win.toTop, roundProps: ["top"], ease: Sine.easeInOut, onUpdate: function ()
                                {
                                    $(window).scrollTop(win.top);
                                }
                            });
                        });
                    });
                </script>

                <div class="row">
                    <div class="col-md-12">

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Notifiche</h3>
                            </div>

                            <div class="panel-body">
                                <table id="tableNotifications" class="table table-striped table-hover table-bordered" cellspacing="0" width="100%">

                                    <thead>
                                        <tr>
                                            <th>Matricola</th>
                                            <th>Credenziali</th>
                                            <th>CV</th>
                                            <th>Esami</th>
                                            <th>Azioni</th>
                                        </tr>
                                    </thead>

                                    <tbody align="center">
                                    </tbody>
                                </table>
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
                            &copy;
                            <a href="http://www.unisa.it" target="_blank"><strong>Unisa</strong> </a>
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

        <div class="modal fade" id="modalGestioneTirocinioANDPlacementAmministratore">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <center><h4 class="modal-title">Rifiutare la domanda di tirocinio.</h4></center>
                    </div>

                    <div class="modal-body">
                        <div class="row">
                            <div class="col-md-6">

                                <div class="form-group">
                                    <label for="serialNumberModalForReject" class="control-label">Matricola</label>

                                    <input type="text" id="serialNumberModalForReject" class="form-control" disabled>
                                </div>	

                            </div>

                            <div class="col-md-6">

                                <div class="form-group">
                                    <label for="nameANDsurnameModalForReject" class="control-label">Email dello studente</label>

                                    <input type="text" id="nameANDsurnameModalForReject" class="form-control" disabled>
                                </div>	

                            </div>
                        </div>
                        <form role="form" class="form-horizontal" action="/ServerWeb/addErrorToStudentInformation" method="POST">
                            <input type="hidden" name="hiddenErroriRiscontrati" id="hiddenErroriRiscontrati"/>
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="xe-widget xe-todo-list">
                                        <div class="xe-header">
                                            <center><h4 class="title"><strong>Errori</strong> riscontrati.</h4></center>
                                        </div>
                                        <div class="xe-body">
                                            <ul class="list-unstyled">
                                                <li>
                                                    <label>
                                                        <input name="descriptionCurriculum" value="Curriculum Vitae mancante: il file inviato al personale amministrativo presenta degli errori." type="checkbox" id="cvDocumentError" class="cbr"/>
                                                        Curriculum Vitae mancante: il file inviato dallo studente presenta degli errori.
                                                    </label>
                                                </li>
                                                <li>
                                                    <label>
                                                        <input name="descriptionLibretto" value="Libretto Universitario: il file inviato al personale amministrativo presenta delle incongruenze con i dati del sistema." type="checkbox" id="esDocumentError" class="cbr"/>
                                                        Libretto Universitario: il file inviato dallo studente presenta delle incongruenze con i dati del sistema.
                                                    </label>
                                                </li>
                                                <li>
                                                    <label>
                                                        <input name="descriptionCFUMancanti" value="Non possiedi un numero di CFU sufficienti per poter proseguire la pratica." type="checkbox" id="cfuNotFoundError" class="cbr"/>
                                                            CFU mancanti: Lo studente non possiede un numero di CFU sufficienti per poter proseguire la pratica.
                                                    </label>
                                                </li>
                                                <li>
                                                    <label>
                                                        <input name="descriptionOther" value="Sono stati riscontrati degli errori nell'elaborazione della tua pratica. Contatta l'ufficio amministrativo." type="checkbox" id="otherError" class="cbr" />
                                                        Altro: il motivo del rifiuto della richiesta non è elencato. Lo studente provvederà a contattare l'ufficio amministrativo.
                                                    </label>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                    </div>

                    <div class="modal-footer">
                        <center>
                            <button type="button" class="btn btn-white" data-dismiss="modal">Close</button>
                            <button type="submit" id="invio" class="btn btn-info">Invio Errori</button>
                        </center>
                    </div>
                    </form>
                </div>
            </div>
        </div>

        <div class="page-loading-overlay">
            <div class="loader-2"></div>
        </div>


        <link rel="stylesheet" href="../../assets/js/datatables/dataTables.bootstrap.css">
        <link rel="stylesheet" href="../../assets/css/fonts/meteocons/css/meteocons.css">

        <!-- Bottom Scripts -->
        <script src="../../assets/js/bootstrap.min.js"></script>
        <script src="../../assets/js/TweenMax.min.js"></script>
        <script src="../../assets/js/resizeable.js"></script>
        <script src="../../assets/js/joinable.js"></script>
        <script src="../../assets/js/xenon-api.js"></script>
        <script src="../../assets/js/xenon-toggles.js"></script>
        <script src="../../assets/js/datatables/js/jquery.dataTables.js"></script>

        <!-- Imported scripts on this page -->
        <script src="../../assets/js/datatables/dataTables.bootstrap.js"></script>
        <script src="../../assets/js/datatables/yadcf/jquery.dataTables.yadcf.js"></script>
        <script src="../../assets/js/datatables/tabletools/dataTables.tableTools.min.js"></script>

        <!-- Imported scripts on this page -->
        <script src="../../assets/js/xenon-widgets.js"></script>
        <script src="../../assets/js/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
        <script src="../../assets/js/jvectormap/regions/jquery-jvectormap-world-mill-en.js"></script>

        <!-- JavaScripts initializations and stuff -->
        <script src="../../assets/js/xenon-custom.js"></script>

    </body>
</html>