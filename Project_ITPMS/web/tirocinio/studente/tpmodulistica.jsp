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
        <script src="../../assets/js/jspdf.min.js"></script>
        <script src="../../assets/js/splitlines.js"></script>

    </head>
    <body class="page-body">

        <nav class="navbar horizontal-menu navbar-fixed-top"><!-- set fixed position by adding class "navbar-fixed-top" -->

            <div class="navbar-inner">

                <!-- Navbar Brand -->
                <div class="navbar-brand">
                    <a href="offertaFormativaStudente.html" class="logo">
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
                        <a href="offertaFormativaAmministratore.html">
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
                        <a href="gestioneTirocinio&PlacementAmministratore.html">
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
                                <a href="#">
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
                            <a href="../../tirocinio/studente/tprichiestatirocinio.jsp">
                                <i class="linecons-cog"></i>
                                <span class="title">Richiesta tirocinio</span>
                            </a>
                        </li>
                        <li id="ID_modulistica_0" class="opened active">
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
                    <div class="col-sm-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Modulo online del Progetto Formativo (PF)</h3>
                            </div>
                            <div class="panel-body">
                                <center><p>Compila il modulo seguente con i dati richiesti per ottenere il file in formato PDF del Piano Formativo. Nessun campo è obbligatorio per la compilazione online, ma ti verrà data la possibilità di scrivere a mano i campi di cui non conosci l'esatto valore.</p></center>
                                <br><br><br>
                                <form role="form" class="validate">
                                    <div class="form-group">
                                        <label class="control-label">Tirocinante (Cognome e Nome):</label>
                                        <input type="text" class="form-control" name="name" data-validate="required" id="studentName">
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label">Nato a:</label>
                                        <input type="text" class="form-control" name="birthplace" data-validate="required" id="birthPlace">
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label">In data:</label>
                                        <div class="input-group input-group-sm input-group-minimal">
                                            <span class="input-group-addon">
                                                <i class="fa-calendar"></i>
                                            </span>
                                            <input type="text" class="form-control" data-mask="date" data-validate="required,date" id="birthDate">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label">Residente in:</label>
                                        <input type="text" class="form-control" name="living" data-validate="required" id="livingPlace">
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label">Codice Fiscale:</label>
                                        <input type="text" class="form-control" name="ssn" data-validate="required" id="serialNumber">
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label">Corso di Diploma/Laurea in:</label>
                                        <input type="text" class="form-control" name="studies" data-validate="required" id="masterIn">
                                    </div>
                                    <div class="form-group-separator"></div>
                                    <div class="form-group">
                                        <label class="control-label">Attuale condizione:</label>
                                        <select class="form-control" id="select1">
                                            <option value="">--Seleziona--</option>
                                            <option value="Studente scuola secondaria superiore">Studente scuola secondaria superiore</option>
                                            <option value="Universitaria">Universitaria</option>
                                            <option value="Frequentante corso post-diploma">Frequentante corso post-diploma</option>
                                            <option value="Frequentante corso post-laurea">Frequentante corso post-laurea</option>
                                            <option value="Allievo della formazione professionale">Allievo della formazione professionale</option>
                                            <option value="Disoccupato/in mobilità">Disoccupato/in mobilità</option>
                                            <option value="Inoccupato">Inoccupato</option>
                                        </select>
                                    </div>
                                    <div class="form-group-separator"></div>
                                    <div class="form-group">
                                        <label class="control-label">Specificare se il soggetto è portatore di Handicap:</label>
                                        <select class="form-control" id="select2">
                                            <option value="">--Seleziona--</option>
                                            <option value="Si">Si</option>
                                            <option value="No">No</option>
                                        </select>
                                    </div>
                                    <div class="form-group-separator"></div>
                                    <div class="form-group">
                                        <label class="control-label">Azienda/Ente ospite:</label>
                                        <input type="text" class="form-control" name="organization" data-validate="required" id="organization">
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label">Sede del Tirocinio (stabilimento/reparto/ufficio):</label>
                                        <input type="text" class="form-control" name="place" data-validate="required" id="place">
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label">Tempi di accesso ai locali aziendali:</label>
                                        <input type="text" class="form-control" name="accessTime" data-validate="required" id="accessTime">
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label">Periodo di tirocinio (max 12 mesi):</label>
                                      
                                        <div class="input-group input-group-sm input-group-minimal col-sm-4" id="start">
                                            <span class="input-group-addon">
                                                Inizio tirocinio:
                                                <i class="fa-calendar"></i>
                                            </span>
                                            <input type="text" class="form-control" data-mask="date" data-validate="required,date" id="trainingStart">
                                        </div>
                                        <br>
                                        <div class="input-group input-group-sm input-group-minimal col-sm-4">
                                            <span class="input-group-addon">
                                                Fine tirocinio:
                                                <i class="fa-calendar"></i>
                                            </span>
                                            <input type="text" class="form-control" data-mask="date" data-validate="required,date" id="trainingEnd">
                                        </div>
                                        <!--<div class="daterange daterange-inline" data-format="dd MMMM YYYY" data-start-date="${now}" data-end-date="${nextMonth}">
                                            <i class="fa-calendar"></i>
                                            <span>${now} - ${nextMonth}</span>
                                        </div>-->
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label">Tutor Accademico:</label>
                                        <input type="text" class="form-control" name="tutor" data-validate="required" id="tutor">
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label">Tutor Azienda/Ente:</label>
                                        <input type="text" class="form-control" name="tutorOrganization" data-validate="required" id="tutorOrganization">
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label">Polizze Assicurative:</label>
                                        <textarea type="textarea" class="form-control" align="justify" rows="4" disabled id="assurance">INAL Gestione per conto dello Stato prevista dal combinato disposto dagli artt. 127 e 190 del T.U. INAIL (DPR N. 1124/65) e regolamentato dal D.M. 10.10.85; Infortuni posizione 261044627 Compagnia Generali Responsabilità Civile Terzi Compagnia Generali 261044624</textarea>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label">Obiettivi e modalità tirocinio:</label>
                                        <input type="text" class="form-control" name="objectives" data-validate="required" id="objectives">
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label">Facilitazioni previste:</label>
                                        <input type="text" class="form-control" name="facilities" data-validate="required" id="facilities">
                                    </div>
                                    <div class="form-group-separator"></div>
                                    <script>
                                        jQuery(document).ready(function ($) {
                                            $("#printModuleButton").click(function (e) {
                                                var first = moment($('#trainingStart').val(), "DD MM YYYY");
                                                var second = moment($('#trainingEnd').val(), "DD MM YYYY");
                                                if (first.isValid() && second.isVali d()) {
                                                    if (first > second)
                                                        alert("La data di inizio e di fine tirocinio sono errate!");
                                                    else {
                                                        var diff = '';
                                                            if ($('#trainingStart').val() !== ' '  && $('#trainingEnd').val() !== '')
                                                        diff = second.diff(first, 'months');
                                                    tpFunction.generatePDF($('#studentName').val(), $('#birthPlace').val(), $('#birthDate').val(), $('#livingPlace').val(), $('#serialNumber').val(), $('#masterIn').val(), $('#select1').val(), $('#select2').val(), $('#organization').val(), $('#place').val(), $('#accessTime').val(), $('#tutor').val(), $('#tutorOrganization').val(), $('#assurance').val(), $('#objectives').val(), $('#facilities').val(), $('#trainingStart').val(), $('#trainingEnd').val(), diff);
                                                }
                                                    } else {
                                                tpFunction.generatePDF($('#studentName').val(), $('#birthPlace').val(), $('#birthDate').val(), $('#livingPlace').val(), $('#serialNumber').val(), $('#masterIn').val(), $('#select1').val(), $('#select2').val(), $('#organization').val(), $('#place').val(), $('#accessTime').val(), $('#tutor').val(), $('#tutorOrganization').val(), $('#assurance').val(), $('#objectives').val(), $('#facilities').val(), '', '', '');
                                            }
                                        });
                                        });        </script>
                                    <div class="row">
                                        <center><button type="button" class="btn btn-success fileinput-button" id="printModuleButton"><i class="fa-print"></i>
                                                <span>Stampa Modulo</span></button></center>
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
                                <h3 class="panel-title">Modulo Registro delle Ore</h3>
                            </div>
                            <div class="panel-body">
                                <p>Tramite il pulsante sottostante, è possibile scaricare il modulo del registro delle ore.</p>
                                <br>
                                <div class="row">
                                    <center><button type="button" class="btn btn-success"><i class="fa-file-text-o"></i>
                                            <span>Stampa Registro</span></button></center>
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


        <link rel="stylesheet" href="../../assets/js/datatables/dataTables.bootstrap.css">
        <link rel="stylesheet" href="../../assets/css/fonts/meteocons/css/meteocons.css">
        <link rel="stylesheet" href="../../assets/js/select2/select2.css">
        <link rel="stylesheet" href="../../assets/js/select2/select2-bootstrap.css">
        <link rel="stylesheet" href="../../assets/js/daterangepicker/daterangepicker-bs3.css">


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
        <script src="../../assets/js/jquery-ui/jquery-ui.min.js"></script>
        <script src="../../assets/js/selectboxit/jquery.selectBoxIt.min.js"></script>
        <script src="../../assets/js/moment.min.js"></script>
        <script src="../../assets/js/daterangepicker/daterangepicker.js"></script>


        <!-- Imported scripts on this page -->
        <script src="../../assets/js/xenon-widgets.js"></script>
        <script src="../../assets/js/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
        <script src="../../assets/js/jvectormap/regions/jquery-jvectormap-world-mill-en.js"></script>
        <script src="../../assets/js/inputmask/jquery.inputmask.bundle.js"></script>


        <!-- JavaScripts initializations and stuff -->
        <script src="../../assets/js/xenon-custom.js"></script>

    </body>
</html>