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

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("\t<meta charset=\"utf-8\">\n");
      out.write("\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("\t\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("\t<meta name=\"description\" content=\"Xenon Boostrap Admin Panel\" />\n");
      out.write("\t<meta name=\"author\" content=\"\" />\n");
      out.write("\t\n");
      out.write("\t<title>DISTRA-MIT</title>\n");
      out.write("\n");
      out.write("\t<link rel=\"stylesheet\" href=\"http://fonts.googleapis.com/css?family=Arimo:400,700,400italic\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"../../assets/css/fonts/linecons/css/linecons.css\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"../../assets/css/fonts/fontawesome/css/font-awesome.min.css\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"../../assets/css/bootstrap-mod.css\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"../../assets/css/xenon-core.css\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"../../assets/css/xenon-forms.css\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"../../assets/css/xenon-components.css\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"../../assets/css/xenon-skins.css\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"../../assets/css/custom.css\">\n");
      out.write("\n");
      out.write("\t\n");
      out.write("\t<script src=\"../../assets/js/jquery-1.11.1.min.js\"></script>\n");
      out.write("\t<script src=\"../../assets/js/tpAdministratorLibrary.js\"></script>\n");
      out.write("\t<script src=\"../../assets/js/validatr.js\"></script>\n");
      out.write("\t\n");
      out.write("\t<script>\n");
      out.write("\t\tjQuery(document).ready(function ($) {\n");
      out.write("\t\t\t$('form').validatr();\n");
      out.write("\t\t});\n");
      out.write("\t</script>\n");
      out.write("\t");

		pageContext.setAttribute("path", "\""+pageContext.getServletContext().getContextPath()+"\"");
	
      out.write("\n");
      out.write("\n");
      out.write("\t<script>\n");
      out.write("\t\tjQuery(document).ready(function ($) {\n");
      out.write("\t\t\ttpAdminFunction.appendAll('#comboboxOrganization','#comboboxProfessor','#comboboxStudent',");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(");\n");
      out.write("\t\t});\n");
      out.write("\t</script>\n");
      out.write("</head>\n");
      out.write("<body class=\"page-body\">\n");
      out.write("\n");
      out.write("\t<nav class=\"navbar horizontal-menu navbar-fixed-top\"><!-- set fixed position by adding class \"navbar-fixed-top\" -->\n");
      out.write("\t\t\n");
      out.write("\t\t<div class=\"navbar-inner\">\n");
      out.write("\t\t\n");
      out.write("\t\t\t<!-- Navbar Brand -->\n");
      out.write("\t\t\t<div class=\"navbar-brand\">\n");
      out.write("\t\t\t\t<a href=\"../../offertaFormativa/amministratore/offertaFormativaAmministratore.html\" class=\"logo\">\n");
      out.write("\t\t\t\t\t<img src=\"../../assets/images/mitforsite.png\" width=\"80\" alt=\"\" class=\"hidden-xs\" />\n");
      out.write("\t\t\t\t\t<img src=\"../../assets/images/mitforsitemini.png\" width=\"80\" alt=\"\" class=\"visible-xs\" />\n");
      out.write("\t\t\t\t</a>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t<!-- Mobile Toggles Links -->\n");
      out.write("\t\t\t<div class=\"nav navbar-mobile\">\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\t<!-- This will toggle the mobile menu and will be visible only on mobile devices -->\n");
      out.write("\t\t\t\t<div class=\"mobile-menu-toggle\">\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<a href=\"#\" data-toggle=\"user-info-menu-horizontal\">\n");
      out.write("\t\t\t\t\t\t<i class=\"fa-key\"></i>\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<a href=\"#\" data-toggle=\"mobile-menu-horizontal\">\n");
      out.write("\t\t\t\t\t\t<i class=\"fa-bars\"></i>\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<div class=\"navbar-mobile-clear\"></div>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<!-- main menu -->\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t<ul class=\"navbar-nav\">\n");
      out.write("\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t<a href=\"../../offertaFormativa/amministratore/offertaFormativaAmministratore.html\">\n");
      out.write("\t\t\t\t\t\t<i class=\"linecons-desktop\"></i>\n");
      out.write("\t\t\t\t\t\t<span class=\"title\">Offerta Formativa</span>\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t</li>\n");
      out.write("\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t<a href=\"#\">\n");
      out.write("\t\t\t\t\t\t<i class=\"linecons-graduation-cap\"></i>\n");
      out.write("\t\t\t\t\t\t<span class=\"title\">Gestione Tesi</span>\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t</li>\n");
      out.write("\t\t\t\t<li class=\"opened active\">\n");
      out.write("\t\t\t\t\t<a href=\"../../tirocinio/amministratore/gestioneTirocinio&PlacementAmministratore.html\">\n");
      out.write("\t\t\t\t\t\t<i class=\"linecons-megaphone\"></i>\n");
      out.write("\t\t\t\t\t\t<span class=\"title\">Gestione Tirocinio</span>\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t</li>\n");
      out.write("\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t<a href=\"#\">\n");
      out.write("\t\t\t\t\t\t<i class=\"linecons-lightbulb\"></i>\n");
      out.write("\t\t\t\t\t\t<span class=\"title\">Dottorato</span>\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t</li>\n");
      out.write("                <li>\n");
      out.write("\t\t\t\t    <a href=\"#\">\n");
      out.write("\t\t\t\t        <i class=\"linecons-globe\"></i>\n");
      out.write("\t\t\t\t\t\t<span class=\"title\">Links</span>\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t\t<a href=\"http://www.magistralemit.unisa.it/\" target=\"_blank\">\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"title\">DISTRA-MIT</span>\n");
      out.write("\t\t\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t\t<a href=\"https://esse3web.unisa.it/unisa/Start.do\" target=\"_blank\">\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"title\">Esse3</span>\n");
      out.write("\t\t\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("                </li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t\t<!-- notifications and other links -->\n");
      out.write("\t\t\t<ul class=\"nav nav-userinfo navbar-right\">\n");
      out.write("                <li class=\"dropdown user-profile\">\n");
      out.write("\t\t\t\t\t<a href=\"#\" data-toggle=\"dropdown\">\n");
      out.write("\t\t\t\t\t\t<img src=\"../../assets/images/user-1.png\" alt=\"user-image\" class=\"img-circle img-inline userpic-32\" width=\"28\" />\n");
      out.write("\t\t\t\t\t\t<span id=\"spaceForUsername\">\n");
      out.write("\t\t\t\t\t\t</span>\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<ul class=\"dropdown-menu user-profile-menu list-unstyled\">\n");
      out.write("\t\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t\t<a href=\"../../tirocinio/amministratore/gestioneTirocinio&PlacementAmministratoreProfiloPersonale.html\">\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"fa-edit\"></i>\n");
      out.write("\t\t\t\t\t\t\t\tProfilo\n");
      out.write("\t\t\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t<li class=\"last\">\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\" id=\"logout\">\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"fa-lock\"></i>\n");
      out.write("\t\t\t\t\t\t\t\tLogout\n");
      out.write("\t\t\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t</li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\n");
      out.write("\t\t</div>\n");
      out.write("\t\t\n");
      out.write("\t</nav>\n");
      out.write("\t<div class=\"page-container\"><!-- add class \"sidebar-collapsed\" to close sidebar by default, \"chat-visible\" to make chat appear always -->\n");
      out.write("\t\t\t\n");
      out.write("\t\t<!-- Add \"fixed\" class to make the sidebar fixed always to the browser viewport. -->\n");
      out.write("\t\t<!-- Adding class \"toggle-others\" will keep only one menu item open at a time. -->\n");
      out.write("\t\t<!-- Adding class \"collapsed\" collapse sidebar root elements and show only icons. -->\n");
      out.write("\t\t<div class=\"sidebar-menu toggle-others\">\n");
      out.write("\t\t\t<div class=\"sidebar-menu-inner\">\t\n");
      out.write("\t\t\t\t<ul id=\"main-menu\" class=\"main-menu\">\n");
      out.write("\t\t\t\t\t<!-- add class \"multiple-expanded\" to allow multiple submenus to open -->\n");
      out.write("\t\t\t\t\t<!-- class \"auto-inherit-active-class\" will automatically add \"active\" class for parent elements who are marked already with class \"active\" -->\n");
      out.write("\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t<a href=\"../../tirocinio/amministratore/tpamministratore.jsp\">\n");
      out.write("\t\t\t\t\t\t\t<i class=\"linecons-cog\"></i>\n");
      out.write("\t\t\t\t\t\t\t<span class=\"title\">Offerta Tirocinio</span>\n");
      out.write("\t\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t<a href=\"../../tirocinio/amministratore/tpinserimentofileamministratore.jsp\">\n");
      out.write("\t\t\t\t\t\t\t<i class=\"linecons-cog\"></i>\n");
      out.write("\t\t\t\t\t\t\t<span class=\"title\">Inserimento Moduli</span>\n");
      out.write("\t\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t<a href=\"../../tirocinio/amministratore/tpassociazioneprofessoreazienda.jsp\">\n");
      out.write("\t\t\t\t\t\t\t<i class=\"linecons-cog\"></i>\n");
      out.write("\t\t\t\t\t\t\t<span class=\"title\">Associa Professore</span>\n");
      out.write("\t\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t<a href=\"#\">\n");
      out.write("\t\t\t\t\t\t\t<i class=\"linecons-cog\"></i>\n");
      out.write("\t\t\t\t\t\t\t<span class=\"title\">Registra Azienda</span>\n");
      out.write("\t\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t<li class=\"opened active\">\n");
      out.write("\t\t\t\t\t\t<a href=\"#\">\n");
      out.write("\t\t\t\t\t\t\t<i class=\"linecons-cog\"></i>\n");
      out.write("\t\t\t\t\t\t\t<span class=\"title\">Aggiungi Tirocinio</span>\n");
      out.write("\t\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t\n");
      out.write("\t\t<div class=\"main-content\">\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t<script>\n");
      out.write("\t\t\t\tjQuery(document).ready(function($){\n");
      out.write("\t\t\t\t\t$('a[href=\"#layout-variants\"]').on('click', function(ev)\n");
      out.write("\t\t\t\t\t{\n");
      out.write("\t\t\t\t\t\tev.preventDefault();\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\tvar win = {top: $(window).scrollTop(), toTop: $(\"#layout-variants\").offset().top - 15};\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\tTweenLite.to(win, .3, {top: win.toTop, roundProps: [\"top\"], ease: Sine.easeInOut, onUpdate: function()\n");
      out.write("\t\t\t\t\t\t\t{\n");
      out.write("\t\t\t\t\t\t\t\t$(window).scrollTop(win.top);\n");
      out.write("\t\t\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t\t});\n");
      out.write("\t\t\t\t\t});\n");
      out.write("\t\t\t\t});\n");
      out.write("\t\t\t</script>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t<div class=\"col-sm-12\">\n");
      out.write("\t\t\t\t\t<div class=\"panel panel-default\">\n");
      out.write("\t\t\t\t\t\t<div class=\"panel-heading\">\n");
      out.write("\t\t\t\t\t\t\t<h3 class=\"panel-title\">Registrazione Nuovi Tirocini</h3>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"panel-body\">\n");
      out.write("\t\t\t\t\t\t\t<form role=\"form\" class=\"form-horizontal\" action=\"/ServerWeb/insertTrainingRequestServlet\" method=\"POST\">\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<label class=\"col-sm-3 control-label\" for=\"titleTraining\">Titolo Tirocinio</label>\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-9\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input required type=\"text\" class=\"form-control\" name=\"titleTraining\" id=\"titleTraining\">\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<label class=\"col-sm-3 control-label\" for=\"descriptionTraining\">Descrizione Tirocinio</label>\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-9\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input required type=\"text\" class=\"form-control\" name=\"descriptionTraining\" id=\"descriptionTraining\">\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group-separator\"></div>\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<label class=\"col-sm-3 control-label\" for=\"professorSSN\">Professore</label>\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-9\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<select name=\"professorSSN\" id=\"comboboxProfessor\" class=\"form-control\" required>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<label class=\"col-sm-3 control-label\" for=\"organizationVAT\">Organizzazione</label>\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-9\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<select name=\"organizationVAT\" id=\"comboboxOrganization\" class=\"form-control\" required>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<label class=\"col-sm-3 control-label\" for=\"studentSSN\">Studente</label>\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-9\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<select name=\"studentSSN\" id=\"comboboxStudent\" class=\"form-control\" required>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group-separator\"></div>\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<center>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<button type=\"submit\" class=\"btn btn-blue fileinput-button\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<i class=\"fa-arrow-up\"></i>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<span>Inserisci Tirocinio</span>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<!-- The file input field used as target for the file upload widget -->\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</button>    \n");
      out.write("\t\t\t\t\t\t\t\t\t</center>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<!-- Main Footer -->\n");
      out.write("\t\t\t<!-- Choose between footer styles: \"footer-type-1\" or \"footer-type-2\" -->\n");
      out.write("\t\t\t<!-- Add class \"sticky\" to  always stick the footer to the end of page (if page contents is small) -->\n");
      out.write("\t\t\t<!-- Or class \"fixed\" to  always fix the footer to the end of page -->\n");
      out.write("\t\t\t<footer class=\"main-footer sticky footer-type-1\">\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<div class=\"footer-inner\">\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t\t<!-- Add your copyright text here -->\n");
      out.write("\t\t\t\t\t<div class=\"footer-text\">\n");
      out.write("\t\t\t\t\t\t&copy;\n");
      out.write("\t\t\t\t\t\t<a href=\"http://www.unisa.it\" target=\"_blank\"><strong>Unisa</strong> </a>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<!-- Go to Top Link, just add rel=\"go-top\" to any link to add this functionality -->\n");
      out.write("\t\t\t\t\t<div class=\"go-up\">\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t<a href=\"#\" rel=\"go-top\">\n");
      out.write("\t\t\t\t\t\t\t<i class=\"fa-angle-up\"></i>\n");
      out.write("\t\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t</footer>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<div class=\"page-loading-overlay\">\n");
      out.write("\t\t<div class=\"loader-2\"></div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t\n");
      out.write("\t<link rel=\"stylesheet\" href=\"../../assets/js/datatables/dataTables.bootstrap.css\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"../../assets/css/fonts/meteocons/css/meteocons.css\">\n");
      out.write("\t\n");
      out.write("\t<!-- Bottom Scripts -->\n");
      out.write("\t<script src=\"../../assets/js/bootstrap.min.js\"></script>\n");
      out.write("\t<script src=\"../../assets/js/TweenMax.min.js\"></script>\n");
      out.write("\t<script src=\"../../assets/js/resizeable.js\"></script>\n");
      out.write("\t<script src=\"../../assets/js/joinable.js\"></script>\n");
      out.write("\t<script src=\"../../assets/js/xenon-api.js\"></script>\n");
      out.write("\t<script src=\"../../assets/js/xenon-toggles.js\"></script>\n");
      out.write("\t<script src=\"../../assets/js/datatables/js/jquery.dataTables.js\"></script>\n");
      out.write("\n");
      out.write("\t<!-- Imported scripts on this page -->\n");
      out.write("\t<script src=\"../../assets/js/datatables/dataTables.bootstrap.js\"></script>\n");
      out.write("\t<script src=\"../../assets/js/datatables/yadcf/jquery.dataTables.yadcf.js\"></script>\n");
      out.write("\t<script src=\"../../assets/js/datatables/tabletools/dataTables.tableTools.min.js\"></script>\n");
      out.write("\t\n");
      out.write("\t<!-- Imported scripts on this page -->\n");
      out.write("\t<script src=\"../../assets/js/xenon-widgets.js\"></script>\n");
      out.write("\t<script src=\"../../assets/js/jvectormap/jquery-jvectormap-1.2.2.min.js\"></script>\n");
      out.write("\t<script src=\"../../assets/js/jvectormap/regions/jquery-jvectormap-world-mill-en.js\"></script>\n");
      out.write("\n");
      out.write("\t<!-- JavaScripts initializations and stuff -->\n");
      out.write("\t<script src=\"../../assets/js/xenon-custom.js\"></script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html> \n");
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
}
