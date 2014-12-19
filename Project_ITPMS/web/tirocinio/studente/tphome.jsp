<%@page import="it.unisa.tirocinio.manager.concrete.ConcreteMessageForServlet"%>
<%@page import="it.unisa.tirocinio.beans.TrainingOffer"%>
<%@page import="java.util.ArrayList"%>
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
        <script src="../../assets/js/tpLibrary.js"></script>

        <jsp:include page="/getStudentTrainingStatus" />
        <c:set var="statusMessage" value="${requestScope.message}"></c:set>
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
            <script>
                jQuery(document).ready(function ($) {
                    tpFunction.populateHomePanel(${idStudentStatus});
                });
            </script>
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
                        <a href="../../tirocinio/studente/tphome.html">
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
                        <li class="opened active">
                            <a href="../../tirocinio/studente/tphome.jsp">
                                <i class="linecons-cog"></i>
                                <span class="title">Home</span>
                            </a>
                        </li>
                        <li>
                            <a href="../../tirocinio/studente/tprichiestatirocinio.jsp">
                                <i class="linecons-cog"></i>
                                <span class="title">Richiesta tirocinio</span>
                            </a>
                        </li>
                        <li id="ID_modulistica_0">
                            <a href="../../tirocinio/studente/tpmodulistica.jsp">
                                <i class="linecons-note"></i>
                                <span class="title">Modulistica</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>

            <div class="main-content">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default"><!-- Add class "collapsed" to minimize the panel -->
                            <div class="panel-heading">
                                <h3 class="panel-title">Status personale</h3>
                            </div>

                            <div class="panel-body">
                                <center><h4 id="statusRequestTitle"></h4>
                                    <p id="statusRequestDescription"></p></center>
                            </div>
                        </div>
                    </div>
                </div>

                <script>
                    jQuery(document).ready(function ($)
                    {
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
                    <%
                            pageContext.setAttribute("path", "\"" + pageContext.getServletContext().getContextPath() + "\"");
                    %>
                        jQuery(document).ready(function ($) {
                            tpFunction.populateTableWithoutContacts('#tableNewsTrainingOrganization', '#tableContainer',${path});
                        });
                    });
                </script>

                <div class="row">
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