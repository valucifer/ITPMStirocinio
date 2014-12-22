package org.apache.jsp.tirocinio.amministratore;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import it.unisa.tirocinio.beans.TrainingOffer;
import java.util.ArrayList;
import it.unisa.tirocinio.manager.concrete.ConcreteMessageForServlet;

public final class tpaggiungistudentetraining_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_remove_var_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_remove_var_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_set_var_value_nobody.release();
    _jspx_tagPool_c_remove_var_nobody.release();
    _jspx_tagPool_c_choose.release();
    _jspx_tagPool_c_when_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("        <meta name=\"description\" content=\"Xenon Boostrap Admin Panel\" />\r\n");
      out.write("        <meta name=\"author\" content=\"\" />\r\n");
      out.write("\r\n");
      out.write("        <title>DISTRA-MIT</title>\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://fonts.googleapis.com/css?family=Arimo:400,700,400italic\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/css/fonts/linecons/css/linecons.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/css/fonts/fontawesome/css/font-awesome.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/css/bootstrap-mod.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/css/xenon-core.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/css/xenon-forms.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/css/xenon-components.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/css/xenon-skins.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/css/custom.css\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/js/jquery-1.11.1.min.js\"></script>\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/js/tpAdministratorLibrary.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        ");

            pageContext.setAttribute("path", pageContext.getServletContext().getContextPath());
        
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script>\r\n");
      out.write("            jQuery(document).ready(function ($) {\r\n");
      out.write("                tpAdminFunction.appendAll('#comboboxOrganization', '#comboboxProfessor', '#comboboxStudent', '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("');\r\n");
      out.write("            });\r\n");
      out.write("        </script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body class=\"page-body\">\r\n");
      out.write("\r\n");
      out.write("        <nav class=\"navbar horizontal-menu navbar-fixed-top\"><!-- set fixed position by adding class \"navbar-fixed-top\" -->\r\n");
      out.write("\r\n");
      out.write("            <div class=\"navbar-inner\">\r\n");
      out.write("\r\n");
      out.write("                <!-- Navbar Brand -->\r\n");
      out.write("                <div class=\"navbar-brand\">\r\n");
      out.write("                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/offertaFormativa/amministratore/offertaFormativaAmministratore.html\" class=\"logo\">\r\n");
      out.write("                        <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/images/mitforsite.png\" width=\"80\" alt=\"\" class=\"hidden-xs\" />\r\n");
      out.write("                        <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/images/mitforsitemini.png\" width=\"80\" alt=\"\" class=\"visible-xs\" />\r\n");
      out.write("                    </a>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <!-- Mobile Toggles Links -->\r\n");
      out.write("                <div class=\"nav navbar-mobile\">\r\n");
      out.write("\r\n");
      out.write("                    <!-- This will toggle the mobile menu and will be visible only on mobile devices -->\r\n");
      out.write("                    <div class=\"mobile-menu-toggle\">\r\n");
      out.write("\r\n");
      out.write("                        <a href=\"#\" data-toggle=\"user-info-menu-horizontal\">\r\n");
      out.write("                            <i class=\"fa-key\"></i>\r\n");
      out.write("                        </a>\r\n");
      out.write("\r\n");
      out.write("                        <a href=\"#\" data-toggle=\"mobile-menu-horizontal\">\r\n");
      out.write("                            <i class=\"fa-bars\"></i>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"navbar-mobile-clear\"></div>\r\n");
      out.write("\r\n");
      out.write("                <!-- main menu -->\r\n");
      out.write("\r\n");
      out.write("                <ul class=\"navbar-nav\">\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/offertaFormativa/amministratore/offertaFormativaAmministratore.html\">\r\n");
      out.write("                            <i class=\"linecons-desktop\"></i>\r\n");
      out.write("                            <span class=\"title\">Offerta Formativa</span>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"#\">\r\n");
      out.write("                            <i class=\"linecons-graduation-cap\"></i>\r\n");
      out.write("                            <span class=\"title\">Gestione Tesi</span>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"opened active\">\r\n");
      out.write("                        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/tirocinio/amministratore/tpamministratore.jsp\">\r\n");
      out.write("                            <i class=\"linecons-megaphone\"></i>\r\n");
      out.write("                            <span class=\"title\">Gestione Tirocinio</span>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"#\">\r\n");
      out.write("                            <i class=\"linecons-lightbulb\"></i>\r\n");
      out.write("                            <span class=\"title\">Dottorato</span>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"#\">\r\n");
      out.write("                            <i class=\"linecons-globe\"></i>\r\n");
      out.write("                            <span class=\"title\">Links</span>\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <ul>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <a href=\"http://www.magistralemit.unisa.it/\" target=\"_blank\">\r\n");
      out.write("                                    <span class=\"title\">DISTRA-MIT</span>\r\n");
      out.write("                                </a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <a href=\"https://esse3web.unisa.it/unisa/Start.do\" target=\"_blank\">\r\n");
      out.write("                                    <span class=\"title\">Esse3</span>\r\n");
      out.write("                                </a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("                <!-- notifications and other links -->\r\n");
      out.write("                <ul class=\"nav nav-userinfo navbar-right\">\r\n");
      out.write("                    <li class=\"dropdown user-profile\">\r\n");
      out.write("                        <a href=\"#\" data-toggle=\"dropdown\">\r\n");
      out.write("                            <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/images/user-1.png\" alt=\"user-image\" class=\"img-circle img-inline userpic-32\" width=\"28\" />\r\n");
      out.write("                            <span id=\"spaceForUsername\">\r\n");
      out.write("                                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.person}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("                            </span>\r\n");
      out.write("                        </a>\r\n");
      out.write("\r\n");
      out.write("                        <ul class=\"dropdown-menu user-profile-menu list-unstyled\">\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/tirocinio/amministratore/gestioneTirocinio&PlacementAmministratoreProfiloPersonale.html\">\r\n");
      out.write("                                    <i class=\"fa-edit\"></i>\r\n");
      out.write("                                    Profilo\r\n");
      out.write("                                </a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li class=\"last\">\r\n");
      out.write("                                <a href=\"#\" id=\"logout\">\r\n");
      out.write("                                    <i class=\"fa-lock\"></i>\r\n");
      out.write("                                    Logout\r\n");
      out.write("                                </a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </nav>\r\n");
      out.write("        <div class=\"page-container\"><!-- add class \"sidebar-collapsed\" to close sidebar by default, \"chat-visible\" to make chat appear always -->\r\n");
      out.write("\r\n");
      out.write("            <!-- Add \"fixed\" class to make the sidebar fixed always to the browser viewport. -->\r\n");
      out.write("            <!-- Adding class \"toggle-others\" will keep only one menu item open at a time. -->\r\n");
      out.write("            <!-- Adding class \"collapsed\" collapse sidebar root elements and show only icons. -->\r\n");
      out.write("            <div class=\"sidebar-menu toggle-others\">\r\n");
      out.write("                <div class=\"sidebar-menu-inner\">\t\r\n");
      out.write("                    <ul id=\"main-menu\" class=\"main-menu\">\r\n");
      out.write("                        <!-- add class \"multiple-expanded\" to allow multiple submenus to open -->\r\n");
      out.write("                        <!-- class \"auto-inherit-active-class\" will automatically add \"active\" class for parent elements who are marked already with class \"active\" -->\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/tirocinio/amministratore/tpamministratore.jsp\">\r\n");
      out.write("                                <i class=\"linecons-cog\"></i>\r\n");
      out.write("                                <span class=\"title\">Offerta Tirocinio</span>\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/tirocinio/amministratore/tpinserimentofileamministratore.jsp\">\r\n");
      out.write("                                <i class=\"linecons-cog\"></i>\r\n");
      out.write("                                <span class=\"title\">Inserimento Moduli</span>\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/tirocinio/amministratore/tpassociazioneprofessoreazienda.jsp\">\r\n");
      out.write("                                <i class=\"linecons-cog\"></i>\r\n");
      out.write("                                <span class=\"title\">Associa Professore</span>\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/tirocinio/amministratore/tpregisteranorganization.jsp\">\r\n");
      out.write("                                <i class=\"linecons-cog\"></i>\r\n");
      out.write("                                <span class=\"title\">Registra Azienda</span>\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"opened active\">\r\n");
      out.write("                            <a href=\"#\">\r\n");
      out.write("                                <i class=\"linecons-cog\"></i>\r\n");
      out.write("                                <span class=\"title\">Aggiungi Tirocinio</span>\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/tirocinio/amministratore/tpvisionetirocini.jsp\">\r\n");
      out.write("                                <i class=\"linecons-cog\"></i>\r\n");
      out.write("                                <span class=\"title\">Visione Tirocini</span>\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"main-content\">\r\n");
      out.write("\r\n");
      out.write("                <script>\r\n");
      out.write("                    jQuery(document).ready(function ($) {\r\n");
      out.write("                        $('a[href=\"#layout-variants\"]').on('click', function (ev)\r\n");
      out.write("                        {\r\n");
      out.write("                            ev.preventDefault();\r\n");
      out.write("\r\n");
      out.write("                            var win = {top: $(window).scrollTop(), toTop: $(\"#layout-variants\").offset().top - 15};\r\n");
      out.write("\r\n");
      out.write("                            TweenLite.to(win, .3, {top: win.toTop, roundProps: [\"top\"], ease: Sine.easeInOut, onUpdate: function ()\r\n");
      out.write("                                {\r\n");
      out.write("                                    $(window).scrollTop(win.top);\r\n");
      out.write("                                }\r\n");
      out.write("                            });\r\n");
      out.write("                        });\r\n");
      out.write("                    });\r\n");
      out.write("                </script>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-sm-12\">\r\n");
      out.write("                        <div class=\"panel panel-default\">\r\n");
      out.write("                            <div class=\"panel-heading\">\r\n");
      out.write("                                <h3 class=\"panel-title\">Registrazione Nuovi Tirocini</h3>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"panel-body\">\r\n");
      out.write("                                <form role=\"form\" class=\"validate\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/insertTrainingRequest\" method=\"POST\">\r\n");
      out.write("                                    <div class=\"form-group\">\r\n");
      out.write("                                        <label class=\"col-sm-3 control-label\" for=\"titleTraining\">Titolo Tirocinio</label>\r\n");
      out.write("                                        <div class=\"col-sm-9\">\r\n");
      out.write("                                            <input required type=\"text\" class=\"form-control\" name=\"titleTraining\" id=\"titleTraining\" data-validate=\"required\" data-message-required=\"Per favore, inserisci il titolo.\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div><br><br>\r\n");
      out.write("                                    <div class=\"form-group\">\r\n");
      out.write("                                        <label class=\"col-sm-3 control-label\" for=\"descriptionTraining\">Descrizione Tirocinio</label>\r\n");
      out.write("                                        <div class=\"col-sm-9\">\r\n");
      out.write("                                            <input required type=\"text\" class=\"form-control\" name=\"descriptionTraining\" id=\"descriptionTraining\" data-validate=\"required\" data-message-required=\"Per favore, inserisci la descrizione.\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div><br><br>\r\n");
      out.write("                                    <div class=\"form-group-separator\"></div>\r\n");
      out.write("                                    <div class=\"form-group\">\r\n");
      out.write("                                        <label class=\"col-sm-3 control-label\" for=\"professorSSN\">Professore</label>\r\n");
      out.write("                                        <div class=\"col-sm-9\">\r\n");
      out.write("                                            <select name=\"professorSSN\" id=\"comboboxProfessor\" class=\"form-control\" data-validate=\"required\" data-message-required=\"Per favore, inserisci il professore.\">\r\n");
      out.write("                                            </select>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div><br><br>\r\n");
      out.write("                                    <div class=\"form-group\">\r\n");
      out.write("                                        <label class=\"col-sm-3 control-label\" for=\"organizationVAT\">Organizzazione</label>\r\n");
      out.write("                                        <div class=\"col-sm-9\">\r\n");
      out.write("                                            <select name=\"organizationVAT\" id=\"comboboxOrganization\" class=\"form-control\" data-validate=\"required\" data-message-required=\"Per favore, inserisci l\\'azienda.\">\r\n");
      out.write("                                            </select>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div><br>\r\n");
      out.write("                                    <div class=\"form-group\">\r\n");
      out.write("                                        <label class=\"col-sm-3 control-label\" for=\"studentSSN\">Studente</label>\r\n");
      out.write("                                        <div class=\"col-sm-9\">\r\n");
      out.write("                                            <select name=\"studentSSN\" id=\"comboboxStudent\" class=\"form-control\" data-validate=\"required\" data-message-required=\"Per favore, inserisci lo studente.\">\r\n");
      out.write("                                            </select>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div><br><br>\r\n");
      out.write("                                    <div class=\"form-group-separator\"></div>\r\n");
      out.write("                                    <div class=\"row\">\r\n");
      out.write("                                        <center>\r\n");
      out.write("                                            <button type=\"submit\" class=\"btn btn-blue fileinput-button\">\r\n");
      out.write("                                                <i class=\"fa-pencil\"></i>\r\n");
      out.write("                                                <span>Inserisci Tirocinio</span>\r\n");
      out.write("                                            </button>    \r\n");
      out.write("                                        </center>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    ");
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                    ");
      //  c:choose
      org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
      _jspx_th_c_choose_0.setPageContext(_jspx_page_context);
      _jspx_th_c_choose_0.setParent(null);
      int _jspx_eval_c_choose_0 = _jspx_th_c_choose_0.doStartTag();
      if (_jspx_eval_c_choose_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                        ");
          //  c:when
          org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
          _jspx_th_c_when_0.setPageContext(_jspx_page_context);
          _jspx_th_c_when_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
          _jspx_th_c_when_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${status == 0}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
          int _jspx_eval_c_when_0 = _jspx_th_c_when_0.doStartTag();
          if (_jspx_eval_c_when_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n");
              out.write("                                            <div class=\"alert alert-danger\">\r\n");
              out.write("                                                <center><strong>Errore,</strong> dati caricati non correttamente. Per favore, riprova.</center>\r\n");
              out.write("                                            </div>\r\n");
              out.write("                                            ");

                                                request.getSession().removeAttribute("message");
                                            
              out.write("\r\n");
              out.write("                                            ");
              if (_jspx_meth_c_remove_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_when_0, _jspx_page_context))
                return;
              out.write("\r\n");
              out.write("                                        ");
              int evalDoAfterBody = _jspx_th_c_when_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_c_when_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
            return;
          }
          _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
          out.write("\r\n");
          out.write("                                        ");
          //  c:when
          org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_1 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
          _jspx_th_c_when_1.setPageContext(_jspx_page_context);
          _jspx_th_c_when_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
          _jspx_th_c_when_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${status == 1}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
          int _jspx_eval_c_when_1 = _jspx_th_c_when_1.doStartTag();
          if (_jspx_eval_c_when_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n");
              out.write("                                            <div class=\"alert alert-success\">\r\n");
              out.write("                                                <center><strong>Eseguito,</strong> dati caricati correttamente.</center>\r\n");
              out.write("                                            </div>\r\n");
              out.write("                                            ");

                                                request.getSession().removeAttribute("message");
                                            
              out.write("\r\n");
              out.write("                                            ");
              if (_jspx_meth_c_remove_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_when_1, _jspx_page_context))
                return;
              out.write("\r\n");
              out.write("                                        ");
              int evalDoAfterBody = _jspx_th_c_when_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_c_when_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
            return;
          }
          _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
          out.write("\r\n");
          out.write("                                    ");
          int evalDoAfterBody = _jspx_th_c_choose_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_choose_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
        return;
      }
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
      out.write("\r\n");
      out.write("                                </form>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <!-- Main Footer -->\r\n");
      out.write("                <!-- Choose between footer styles: \"footer-type-1\" or \"footer-type-2\" -->\r\n");
      out.write("                <!-- Add class \"sticky\" to  always stick the footer to the end of page (if page contents is small) -->\r\n");
      out.write("                <!-- Or class \"fixed\" to  always fix the footer to the end of page -->\r\n");
      out.write("                <footer class=\"main-footer sticky footer-type-1\">\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"footer-inner\">\r\n");
      out.write("\r\n");
      out.write("                        <!-- Add your copyright text here -->\r\n");
      out.write("                        <div class=\"footer-text\">\r\n");
      out.write("                            &copy;\r\n");
      out.write("                            <a href=\"http://www.unisa.it\" target=\"_blank\"><strong>Unisa</strong> </a>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        <!-- Go to Top Link, just add rel=\"go-top\" to any link to add this functionality -->\r\n");
      out.write("                        <div class=\"go-up\">\r\n");
      out.write("\r\n");
      out.write("                            <a href=\"#\" rel=\"go-top\">\r\n");
      out.write("                                <i class=\"fa-angle-up\"></i>\r\n");
      out.write("                            </a>\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                </footer>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"page-loading-overlay\">\r\n");
      out.write("            <div class=\"loader-2\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/js/datatables/dataTables.bootstrap.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/css/fonts/meteocons/css/meteocons.css\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Bottom Scripts -->\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/js/bootstrap.min.js\"></script>\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/js/TweenMax.min.js\"></script>\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/js/resizeable.js\"></script>\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/js/joinable.js\"></script>\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/js/xenon-api.js\"></script>\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/js/xenon-toggles.js\"></script>\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/js/datatables/js/jquery.dataTables.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- Imported scripts on this page -->\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/js/datatables/dataTables.bootstrap.js\"></script>\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/js/datatables/yadcf/jquery.dataTables.yadcf.js\"></script>\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/js/datatables/tabletools/dataTables.tableTools.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- Imported scripts on this page -->\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/js/xenon-widgets.js\"></script>\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/js/jvectormap/jquery-jvectormap-1.2.2.min.js\"></script>\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/js/jvectormap/regions/jquery-jvectormap-world-mill-en.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/js/jquery-validate/jquery.validate.min.js\"></script>\r\n");
      out.write("        \r\n");
      out.write("        <!-- JavaScripts initializations and stuff -->\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/js/xenon-custom.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html> \r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("status");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.message.getMessage('status')}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }

  private boolean _jspx_meth_c_remove_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_when_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:remove
    org.apache.taglibs.standard.tag.common.core.RemoveTag _jspx_th_c_remove_0 = (org.apache.taglibs.standard.tag.common.core.RemoveTag) _jspx_tagPool_c_remove_var_nobody.get(org.apache.taglibs.standard.tag.common.core.RemoveTag.class);
    _jspx_th_c_remove_0.setPageContext(_jspx_page_context);
    _jspx_th_c_remove_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_0);
    _jspx_th_c_remove_0.setVar("status");
    int _jspx_eval_c_remove_0 = _jspx_th_c_remove_0.doStartTag();
    if (_jspx_th_c_remove_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_remove_var_nobody.reuse(_jspx_th_c_remove_0);
      return true;
    }
    _jspx_tagPool_c_remove_var_nobody.reuse(_jspx_th_c_remove_0);
    return false;
  }

  private boolean _jspx_meth_c_remove_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_when_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:remove
    org.apache.taglibs.standard.tag.common.core.RemoveTag _jspx_th_c_remove_1 = (org.apache.taglibs.standard.tag.common.core.RemoveTag) _jspx_tagPool_c_remove_var_nobody.get(org.apache.taglibs.standard.tag.common.core.RemoveTag.class);
    _jspx_th_c_remove_1.setPageContext(_jspx_page_context);
    _jspx_th_c_remove_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_1);
    _jspx_th_c_remove_1.setVar("status");
    int _jspx_eval_c_remove_1 = _jspx_th_c_remove_1.doStartTag();
    if (_jspx_th_c_remove_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_remove_var_nobody.reuse(_jspx_th_c_remove_1);
      return true;
    }
    _jspx_tagPool_c_remove_var_nobody.reuse(_jspx_th_c_remove_1);
    return false;
  }
}
