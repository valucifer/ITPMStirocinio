<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/fonts/linecons/css/linecons.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/fonts/fontawesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap-mod.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/xenon-core.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/xenon-forms.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/xenon-components.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/xenon-skins.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/custom.css">


        <script src="${pageContext.request.contextPath}/assets/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/tpLibrary.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/validatr.js"></script>
        <jsp:include page="/getStudentQuestionnaireCompletion">
            <jsp:param name="matricula" value="0512200013" />
        </jsp:include>
        <c:set var="questionnaireCompletion" value="${requestScope.questionnaireCompletion }"></c:set>
        <%
            int qCompletion = (Integer) pageContext.getAttribute("questionnaireCompletion");
            pageContext.setAttribute("qCompletion", qCompletion);
        %>

        <c:choose>
            <c:when test="${qCompletion == 1}">
                <script>
                    jQuery(document).ready(function ($) {
                        $("#questPanel").empty();
                        tpFunction.createQuestionnaireAlreadySendPanel('questPanel');
                    });
                </script>
            </c:when>

        </c:choose>


    </head>

    <body class="page-body">

        <nav class="navbar horizontal-menu navbar-fixed-top"><!-- set fixed position by adding class "navbar-fixed-top" -->

            <div class="navbar-inner">

                <!-- Navbar Brand -->
                <div class="navbar-brand">
                    <a href="${pageContext.request.contextPath}/offertaFormativa/studente/offertaFormativaStudente.html" class="logo">
                        <img src="${pageContext.request.contextPath}/assets/images/mitforsite.png" width="80" alt="" class="hidden-xs" />
                        <img src="${pageContext.request.contextPath}/assets/images/mitforsitemini.png" width="80" alt="" class="visible-xs" />
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
                        <a href="${pageContext.request.contextPath}/offertaFormativa/amministratore/offertaFormativaAmministratore.html">
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
                        <a href="${pageContext.request.contextPath}/tirocinio/studente/tpstudente.jsp">
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
                            <img src="${pageContext.request.contextPath}/assets/images/user-1.png" alt="user-image" class="img-circle img-inline userpic-32" width="28" />
                            <span id="spaceForUsername">
                            </span>
                        </a>

                        <ul class="dropdown-menu user-profile-menu list-unstyled">
                            <li>
                                <a href="${pageContext.request.contextPath}/tirocinio/amministratore/gestioneTirocinio&PlacementAmministratoreProfiloPersonale.html">
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
                            <a href="${pageContext.request.contextPath}/tirocinio/amministratore/tpamministratore.jsp">
                                <i class="linecons-cog"></i>
                                <span class="title">Offerta Tirocinio</span>
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/tirocinio/amministratore/tpinserimentofileamministratore.jsp">
                                <i class="linecons-cog"></i>
                                <span class="title">Inserimento Moduli</span>
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/tirocinio/amministratore/tpassociazioneprofessoreazienda.jsp">
                                <i class="linecons-cog"></i>
                                <span class="title">Associa Professore</span>
                            </a>
                        </li>
                        <li class="opened active">
                            <a href="#">
                                <i class="linecons-cog"></i>
                                <span class="title">Registra Azienda</span>
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/tirocinio/amministratore/tpaggiungistudentetraining.jsp">
                                <i class="linecons-cog"></i>
                                <span class="title">Aggiungi Tirocinio</span>
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/tirocinio/amministratore/tpvisionetirocini.jsp">
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
                    <div class="col-sm-12">
                        <div class="panel panel-default" id="questPanel">
                            <div class="panel-heading">
                                <h3 class="panel-title">Questionario valutativo</h3>
                            </div>
                            <div class="panel-body" id='panel-body'>
                                <form role="form" class="form-horizontal" action='/ServerWeb/insertTrainingQuestionnaire' method='POST'>
                                    <p align="justify">Esprimi il tuo grado di giudizio di accordo sulle affermazioni che seguono. Seleziona le caselle utilizzando la scala progressova da 1 a 5; per effettuare tale giudizio, i criteri da utilizzare sono: </p> 
                                    <br>
                                    <center>
                                        <p>
                                            <label class="checkbox-inline">
                                                <input type="checkbox" checked disabled>
                                                1
                                            </label>
                                            <label class="checkbox-inline">
                                                <input type="checkbox" checked disabled>
                                                2
                                            </label>
                                            <label class="checkbox-inline">
                                                <input type="checkbox" checked disabled>
                                                3
                                            </label>
                                            <label class="checkbox-inline">
                                                <input type="checkbox" checked disabled>
                                                4
                                            </label>
                                            <label class="checkbox-inline">
                                                <input type="checkbox" checked disabled>
                                                5
                                            </label>
                                        </p>
                                    </center>
                                    <br>
                                    <p align="justify">dove, ovviamente, i valori da attribuire ad ogni casella sono: 1: insufficiente; 2: mediocre; 3: sufficiente; 4:buono; 5:ottimo.</p>
                                    <br>

                                    <div class="form-group-separator"></div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label" for="matricolaStudente">Matricola: </label>
                                        <div class="col-sm-9">
                                            <input required type="text" class="form-control" name="matricolaStudente" id="matricolaStudente">
                                        </div>
                                    </div><div class="form-group">
                                        <label class="col-sm-2 control-label" for="nomeAzienda">Azienda Ospitante: </label>
                                        <div class="col-sm-9">
                                            <input required type="text" class="form-control" name="nomeAzienda" id="nomeAzienda">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label" for="tipologiaAzienda">Tipologia Struttura: </label>
                                        <div class="col-sm-9">
                                            <select name="tipologiaAzienda" id="pippo" class="form-control" required>
                                                <option value>--Select--</option>
                                                <option value="Azienda_pubblica">   Azienda Pubblica</option>
                                                <option value="Azieda_privata">     Azienda Privata</option>
                                                <option value="MIT">    Tirocinio Interno</option>
                                                <option value="Impresa_NO_PROFIT">  Impresa no Profit</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group-separator"></div>
                                    <br>
                                    <div class="col-sm-11">
                                        <table class="table responsive" >
                                            <thead>
                                                <tr>
                                                    <th>Valutazione</th><th>1</th><th>2</th><th>3</th><th>4</th><th>5</th>
                                                </tr>
                                            </thead>
                                            <tbody >
                                                <tr>
                                                    <td align="justify">Grado di soddisfazione per il ruolo di mansione svolta</td>
                                                    <td><input type="radio" name="uno" value="1"></td>
                                                    <td><input type="radio" name="uno" value="2"></td>
                                                    <td><input type="radio" name="uno" value="3"></td>
                                                    <td><input type="radio" name="uno" value="4"></td>
                                                    <td><input type="radio" name="uno" value="5"></td>
                                                </tr>
                                                <tr>
                                                    <td align="justify">Adeguatezza delle competenze acquisite nel persorso di studi rispetto alle attività di tirocinio svolte</td>
                                                    <td><input type="radio" name="due" value="1"></td>
                                                    <td><input type="radio" name="due" value="2"></td>
                                                    <td><input type="radio" name="due" value="3"></td>
                                                    <td><input type="radio" name="due" value="4"></td>
                                                    <td><input type="radio" name="due" value="5"></td>
                                                </tr>
                                                <tr>
                                                    <td align="justify">Valutazione del tutor universitario, durante le attività di tirocinio</td>
                                                    <td><input type="radio" name="tre" value="1"></td>
                                                    <td><input type="radio" name="tre" value="2"></td>
                                                    <td><input type="radio" name="tre" value="3"></td>
                                                    <td><input type="radio" name="tre" value="4"></td>
                                                    <td><input type="radio" name="tre" value="5"></td>
                                                </tr>
                                                <tr>
                                                    <td align="justify">Valutazione del tutor aziendale, durante le attività di tirocinio</td>
                                                    <td><input type="radio" name="quattro" value="1"></td>
                                                    <td><input type="radio" name="quattro" value="2"></td>
                                                    <td><input type="radio" name="quattro" value="3"></td>
                                                    <td><input type="radio" name="quattro" value="4"></td>
                                                    <td><input type="radio" name="quattro" value="5"></td>
                                                </tr>
                                                <tr>
                                                    <td align="justify">Valutazione del supporto ricevuto nelle informazioni e attività di tirocinio preliminari e successive allo svolgimento del tirocinio</td>
                                                    <td><input type="radio" name="cinque" value="1"></td>
                                                    <td><input type="radio" name="cinque" value="2"></td>
                                                    <td><input type="radio" name="cinque" value="3"></td>
                                                    <td><input type="radio" name="cinque" value="4"></td>
                                                    <td><input type="radio" name="cinque" value="5"></td>
                                                </tr>
                                                <tr>
                                                    <td align="justify">Valutazione acquisizione di competenze nello svolgimento delle attività di tirocinio</td>
                                                    <td><input type="radio" name="sei" value="1"></td>
                                                    <td><input type="radio" name="sei" value="2"></td>
                                                    <td><input type="radio" name="sei" value="3"></td>
                                                    <td><input type="radio" name="sei" value="4"></td>
                                                    <td><input type="radio" name="sei" value="5"></td>
                                                </tr>
                                                <tr>
                                                    <td align="justify">Valutazione complessiva dell'esperienza di tirocinio</td>
                                                    <td><input type="radio" name="sette" value="1"></td>
                                                    <td><input type="radio" name="sette" value="2"></td>
                                                    <td><input type="radio" name="sette" value="3"></td>
                                                    <td><input type="radio" name="sette" value="4"></td>
                                                    <td><input type="radio" name="sette" value="5"></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <script>
                                        jQuery(document).ready(function ($) {
                                            function controlRadio() {
                                                var uno = $("input[name='uno']:checked").val();
                                                var due = $("input[name='due']:checked").val();
                                                var tre = $("input[name='tre']:checked").val();
                                                var quattro = $("input[name='quattro']:checked").val();
                                                var cinque = $("input[name='cinque']:checked").val();
                                                var sei = $("input[name='sei']:checked").val();
                                                var sette = $("input[name='sette']:checked").val();
                                                if ((uno != null) && (due != null) && (tre != null) && (quattro != null) && (cinque != null) && (sei != null) && (sette != null)) {
                                                    $("#submit").removeAttr("disabled");
                                                }
                                            }

                                            $("input[type=radio]").change(function () {
                                                controlRadio();
                                            });
                                        });
                                    </script>

                                    <div class="form-group-separator"></div>
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <center>
                                                <button id="submit" type="submit" class="btn btn-blue fileinput-button" disabled>
                                                    <i class="fa-pencil"></i>
                                                    <span>Invia questionario</span>
                                                </button>    
                                            </center>
                                        </div>
                                    </div>
                                </form>
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

        <div class="page-loading-overlay">
            <div class="loader-2"></div>
        </div>


        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/js/datatables/dataTables.bootstrap.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/fonts/meteocons/css/meteocons.css">

        <!-- Bottom Scripts -->
        <script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/TweenMax.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/resizeable.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/joinable.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/xenon-api.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/xenon-toggles.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/datatables/js/jquery.dataTables.js"></script>

        <!-- Imported scripts on this page -->
        <script src="${pageContext.request.contextPath}/assets/js/datatables/dataTables.bootstrap.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/datatables/yadcf/jquery.dataTables.yadcf.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/datatables/tabletools/dataTables.tableTools.min.js"></script>

        <!-- Imported scripts on this page -->
        <script src="${pageContext.request.contextPath}/assets/js/xenon-widgets.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/jvectormap/regions/jquery-jvectormap-world-mill-en.js"></script>

        <!-- JavaScripts initializations and stuff -->
        <script src="${pageContext.request.contextPath}/assets/js/xenon-custom.js"></script>

    </body>
</html> 
