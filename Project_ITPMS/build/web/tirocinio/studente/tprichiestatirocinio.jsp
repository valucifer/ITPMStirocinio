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
        <!--<link rel="stylesheet" href="../../assets/css/bootstrap.css">-->
        <link rel="stylesheet" href="../../assets/css/bootstrap-mod.css">
        <link rel="stylesheet" href="../../assets/css/xenon-core.css">
        <link rel="stylesheet" href="../../assets/css/xenon-forms.css">
        <link rel="stylesheet" href="../../assets/css/xenon-components.css">
        <link rel="stylesheet" href="../../assets/css/xenon-skins.css">
        <link rel="stylesheet" href="../../assets/css/jquery.fileupload.css">
        <link rel="stylesheet" href="../../assets/css/custom.css">
        <link rel="stylesheet" href="../../assets/js/datatables/dataTables.bootstrap.css">
        <link rel="stylesheet" href="../../assets/css/fonts/meteocons/css/meteocons.css">



        <script src="../../assets/js/jquery-1.11.1.min.js"></script>
        <script src="../../assets/js/tpLibrary.js"></script>
        <script src="../../assets/js/validatr.js"></script>

        <script>
            jQuery(document).ready(function ($) {
                $('form').validatr();
            });
        </script>
        <jsp:include page="/getStudentTrainingStatus" />
        <c:set var="statusMessage" value="${requestScope.message }"></c:set>
        <%
            ConcreteMessageForServlet _message = (ConcreteMessageForServlet) pageContext.getAttribute("statusMessage");
            int requestStatus = (Integer) _message.getMessage("status");
            String description = (String) _message.getMessage("description");
            int studentStatus = (Integer) _message.getMessage("idStudentStatus");
            pageContext.setAttribute("status", requestStatus);
            pageContext.setAttribute("description", description);
            pageContext.setAttribute("idStudentStatus", studentStatus);
        %>

        <c:if test="${status == 1}">
            <c:choose>
                <c:when test="${idStudentStatus == 3}">
                    <script>
                        jQuery(document).ready(function ($) {
                            $("ID_modulistica_0").empty();
                            tpFunction.createPendingStudentPanel('#panelBody');
                        });
                    </script>
                </c:when>
                <c:when test="${idStudentStatus == 2}">
                  
                    <script>
                        <%
                            pageContext.setAttribute("path", "\""+pageContext.getServletContext().getContextPath()+"\"");
                        %>
                        jQuery(document).ready(function ($) {
                            tpFunction.createAcceptStudentPanel('#panelBody');
                            tpFunction.populateTable('#tableNewsTrainingOrganization','#tableContainer',${path});
                        });
                    </script>
                </c:when>
                <c:otherwise>
                    <script>
                        jQuery(document).ready(function ($) {
                            $("ID_modulistica_0").empty();
                        });
                    </script>
                </c:otherwise>
            </c:choose>
        </c:if>

    </head>
    <body class="page-body">

        <nav class="navbar horizontal-menu navbar-fixed-top"><!-- set fixed position by adding class "navbar-fixed-top" -->

            <div class="navbar-inner">

                <!-- Navbar Brand -->
                <div class="navbar-brand">
                    <a href="../../offertaFormativa/studente/offertaFormativaStudente.html" class="logo">
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
                        <a href="../../offertaFormativa/studente/offertaFormativaStudente.html">
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
                        <a href="../../tirocinio/studente/gestioneTirocinio&PlacementStudente.html">
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
                                <a href="../../tirocinio/studente/gestioneTirocinio&PlacementStudenteProfiloPersonale.html">
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
                        <li>
                            <a href="../../tirocinio/studente/gestioneTirocinio&PlacementStudente.html">
                                <i class="linecons-cog"></i>
                                <span class="title">Home</span>
                            </a>
                        </li>
                        <li>
                            <a href="../../tirocinio/studente/gestioneTirocinio&PlacementStudenteRichiestaTirocinio.html">
                                <i class="linecons-cog"></i>
                                <span class="title">Richiesta tirocinio</span>
                            </a>
                        </li>
                        <li id="ID_modulistica_0" class="opened active">
                            <a href="../../tirocinio/studente/gestioneTirocinio&PlacementStudenteModulistica.html">
                                <i class="linecons-note"></i>
                                <span class="title">Modulistica</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>

            <div class="main-content">

                <div class="row">

                    <div class="col-md-12">

                        <!-- Default panel -->
                        <div class="panel panel-default" id="panelDefault">
                            <div class="panel-heading">
                                Richiesta Tirocinio
                            </div>

                            <div class="panel-body" id="panelBody">

                                <p>Questa sezione del sito ti permetterà di inoltrare una richiesta di tirocinio. Per inviare la tua richiesta, è necessario tu possieda un Curriculum Vitae e un documento sul quale vengono descritti esami effettuati, data di convalida e cfu ad essi associati.</p>
                                <p>Entrambi i files devono essere in formato PDF e inviati all'Ufficio Amministrativo tramite i moduli sottostanti. L'ufficio amministrativo, in seguito, provvederà ad esaminare la tua richiesta e ti comunicherà su questa pagina l'esito della stessa.</p>
                                <br><br>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div class="form-group">
                                            <form role="form" class="form-horizontal" action="/ServerWeb/uploadInformationFilesServlet" method="POST" enctype="multipart/form-data">
                                                <div class="row">
                                                    <label class="col-sm-2 control-label" for="field-4" >Curriculum Vitae</label>
                                                    <div class="col-sm-8">
                                                        <input type="file" class="form-control" required id="field-4" name="cv" accept="application/pdf">
                                                    </div>
                                                    <div class="col-sm-2"></div>
                                                </div>
                                                <br>
                                                <div class="row">
                                                    <label class="col-sm-2 control-label" for="field-5">Esami svolti</label>
                                                    <div class="col-sm-8">
                                                        <input type="file" class="form-control" required id="field-5" name="doc" accept="application/pdf">
                                                    </div>
                                                    <div class="col-sm-2"></div>
                                                </div>
                                                <br><br><br>
                                                <div id="filesControl" align="center"></div>
                                                <div class="row">
                                                    <center><button type="submit" class="btn btn-success fileinput-button"><i class="fa-arrow-up"></i>
                                                            <span>Invia Richiesta</span></button></center>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>

                </div>
                <div class="row" hidden id="tableContainer">
                    <div class="col-md-12">

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Tirocini Disponibili</h3>
                            </div>

                            <div class="panel-body">

                                <table id="tableNewsTrainingOrganization" class="table table-striped table-hover table-bordered" cellspacing="0" width="100%">
                                    <!--<thead>
                                            <tr>
                                                    <th>Nome Azienda</th>
                                                    <th>Professore Associato</th>
                                                    <th>Descrizione</th>
                                                    <th>Contatti</th>
                                            </tr>
                                    </thead>-->
                                    <tbody align='center'>

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
        <script src="../../assets/js/datatables/js/jquery.dataTables.js"></script>
        <script src="../../assets/js/datatables/dataTables.bootstrap.js"></script>
        <script src="../../assets/js/datatables/yadcf/jquery.dataTables.yadcf.js"></script>
        <script src="../../assets/js/datatables/tabletools/dataTables.tableTools.min.js"></script>



        <script src="../../assets/js/xenon-widgets.js"></script>
        <script src="../../assets/js/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
        <script src="../../assets/js/jvectormap/regions/jquery-jvectormap-world-mill-en.js"></script>

        <!-- JavaScripts initializations and stuff -->
        <script src="../../assets/js/xenon-custom.js"></script>

    </body>
</html>