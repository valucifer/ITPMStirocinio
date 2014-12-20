package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_redirect_url_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_redirect_url_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_redirect_url_nobody.release();
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      if (_jspx_meth_c_choose_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>DISTRA-MIT</title>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://fonts.googleapis.com/css?family=Arimo:400,700,400italic\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/fonts/linecons/css/linecons.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/fonts/fontawesome/css/font-awesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/bootstrap.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/xenon-core.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/xenon-forms.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/xenon-components.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/xenon-skins.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/custom.css\">\n");
      out.write("\n");
      out.write("        <script src=\"assets/js/jquery-1.11.1.min.js\"></script>\n");
      out.write("\n");
      out.write("        ");
      if (_jspx_meth_c_choose_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <div id=\"loginErrorDialog\" class=\"modal fade\">\n");
      out.write("        <div class=\"modal-dialog\">\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                    <h4 class=\"modal-title\">Errore nell'autenticazione</h4>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    <p>\n");
      out.write("                        Le tue credenziali sono errate.<br>\n");
      out.write("                        Controlla email e/o password.\n");
      out.write("                    </p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("    <body class=\"page-body\">\n");
      out.write("        <nav class=\"navbar horizontal-menu navbar-fixed-top\"><!-- set fixed position by adding class \"navbar-fixed-top\" -->\n");
      out.write("\n");
      out.write("            <div class=\"navbar-inner\">\n");
      out.write("\n");
      out.write("                <!-- Navbar Brand -->\n");
      out.write("                <div class=\"navbar-brand\">\n");
      out.write("                    <a href=\"index.jsp\" class=\"logo\">\n");
      out.write("                        <img src=\"assets/images/mitforsite.png\" width=\"80\" alt=\"\" class=\"hidden-xs\" />\n");
      out.write("                        <img src=\"assets/images/mitforsitemini.png\" width=\"80\" alt=\"\" class=\"visible-xs\" />\n");
      out.write("                    </a>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <!-- Mobile Toggles Links -->\n");
      out.write("                <div class=\"nav navbar-mobile\">\n");
      out.write("\n");
      out.write("                    <!-- This will toggle the mobile menu and will be visible only on mobile devices -->\n");
      out.write("                    <div class=\"mobile-menu-toggle\">\n");
      out.write("\n");
      out.write("                        <a href=\"#\" data-toggle=\"user-info-menu-horizontal\">\n");
      out.write("                            <i class=\"fa-key\"></i>\n");
      out.write("                        </a>\n");
      out.write("\n");
      out.write("                        <a href=\"#\" data-toggle=\"mobile-menu-horizontal\">\n");
      out.write("                            <i class=\"fa-bars\"></i>\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"navbar-mobile-clear\"></div>\n");
      out.write("\n");
      out.write("                <!-- main menu -->\n");
      out.write("\n");
      out.write("                <ul class=\"navbar-nav\">\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"index.jsp\">\n");
      out.write("                            <i class=\"fa fa-home\"></i>\n");
      out.write("                            <span class=\"title\">Home</span>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"offertaFormativa.html\">\n");
      out.write("                            <i class=\"linecons-desktop\"></i>\n");
      out.write("                            <span class=\"title\">Offerta Formativa</span>\n");
      out.write("                        </a>\t\t\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"gestioneTesi.html\">\n");
      out.write("                            <i class=\"linecons-graduation-cap\"></i>\n");
      out.write("                            <span class=\"title\">Gestione Tesi</span>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"gestioneTirocinio.html\">\n");
      out.write("                            <i class=\"linecons-megaphone\"></i>\n");
      out.write("                            <span class=\"title\">Gestione Tirocinio</span>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"dottorato.html\">\n");
      out.write("                            <i class=\"linecons-lightbulb\"></i>\n");
      out.write("                            <span class=\"title\">Dottorato</span>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#\">\n");
      out.write("                            <i class=\"linecons-globe\"></i>\n");
      out.write("                            <span class=\"title\">Links</span>\n");
      out.write("                        </a>\n");
      out.write("                        <ul>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"http://www.magistralemit.unisa.it/\" target=\"_blank\">\n");
      out.write("                                    <span class=\"title\">DISTRA-MIT</span>\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"https://esse3web.unisa.it/unisa/Start.do\" target=\"_blank\">\n");
      out.write("                                    <span class=\"title\">Esse3</span>\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                <!-- notifications and other links -->\n");
      out.write("                <ul class=\"nav nav-userinfo navbar-right\">\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"register.html\">\n");
      out.write("                            <i class=\"fa-pencil\"></i>\n");
      out.write("                            <span class=\"title\">Registrazione</span>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"opened active\">\n");
      out.write("                        <a href=\"login.html\">\n");
      out.write("                            <i class=\"fa-user\"></i>\n");
      out.write("                            <span class=\"title\">Login</span>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </nav>\n");
      out.write("        <!--BODY-->\n");
      out.write("\n");
      out.write("        <div class=\"page-container\">\n");
      out.write("            <div class=\"main-content\">\n");
      out.write("                <div class=\"col-sm-2\"></div>\n");
      out.write("                <div class=\"col-sm-8\">\n");
      out.write("                    <div class=\"panel panel-default\">\n");
      out.write("\n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            <h3 class=\"panel-title\">Accedi a MITPlatform</h3>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"panel-body\">\n");
      out.write("                            <form id=\"loginForm\" method=\"POST\" action=\"login\">\n");
      out.write("\n");
      out.write("                                <div id=\"form-group-username\" class=\"form-group\">\n");
      out.write("                                    <label>Username:</label>\n");
      out.write("                                    <div class=\"input-group\">\n");
      out.write("                                        <span class=\"input-group-addon\"><i class=\"fa-user\"></i></span>\n");
      out.write("                                        <input type=\"text\" id=\"username\" class=\"form-control\" name=\"username\" placeholder=\"Inserisci lo username\" required/>\n");
      out.write("                                    </div>\n");
      out.write("                                    <span id=\"validate_username\" style=\"color:#cc3f44\"></span>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label>Password:</label>\n");
      out.write("                                    <div class=\"input-group\">\n");
      out.write("                                        <span class=\"input-group-addon\"><i class=\"fa-key\"></i></span>\n");
      out.write("                                        <input type=\"password\" id=\"password\" class=\"form-control\" name=\"password\" placeholder=\"Inserisci la password\" required/>\n");
      out.write("                                    </div>\n");
      out.write("                                    <span id=\"validate_password\" style=\"color:#cc3f44\"></span>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label>\n");
      out.write("                                        <input type=\"checkbox\" class=\"cbr cbr-done\" id=\"rememberMeForLogin\" checked>\n");
      out.write("                                        Ricordami la prossima volta\n");
      out.write("                                    </label>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"col-sm-12\">\n");
      out.write("                                    <div id=\"messageControl\" align=\"center\">\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <input type=\"submit\" id=\"signin\" class=\"btn btn-blue\" value=\"Sign in\"> \n");
      out.write("                                    <button type=\"reset\"  id=\"reset\"  class=\"btn btn-white\">Reset</button>\n");
      out.write("                                </div>\n");
      out.write("                            </form>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-sm-2\"></div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Bottom Scripts -->\n");
      out.write("        <script src=\"assets/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/TweenMax.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/resizeable.js\"></script>\n");
      out.write("        <script src=\"assets/js/joinable.js\"></script>\n");
      out.write("        <script src=\"assets/js/xenon-api.js\"></script>\n");
      out.write("        <script src=\"assets/js/xenon-toggles.js\"></script>\n");
      out.write("        <script src=\"assets/js/jquery-ui/jquery-ui.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Imported scripts on this page -->\n");
      out.write("        <script src=\"assets/js/tocify/jquery.tocify.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Imported scripts on this page -->\n");
      out.write("        <script src=\"assets/js/jquery-validate/jquery.validate.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- JavaScripts initializations and stuff -->\n");
      out.write("        <script src=\"assets/js/xenon-custom.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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

  private boolean _jspx_meth_c_choose_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_0.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_0.setParent(null);
    int _jspx_eval_c_choose_0 = _jspx_th_c_choose_0.doStartTag();
    if (_jspx_eval_c_choose_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("    ");
        if (_jspx_meth_c_when_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write('\n');
        int evalDoAfterBody = _jspx_th_c_choose_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
      return true;
    }
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
    return false;
  }

  private boolean _jspx_meth_c_when_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_0.setPageContext(_jspx_page_context);
    _jspx_th_c_when_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.person != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_when_0 = _jspx_th_c_when_0.doStartTag();
    if (_jspx_eval_c_when_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("        ");
        if (_jspx_meth_c_redirect_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_when_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("    ");
        int evalDoAfterBody = _jspx_th_c_when_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
    return false;
  }

  private boolean _jspx_meth_c_redirect_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_when_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:redirect
    org.apache.taglibs.standard.tag.rt.core.RedirectTag _jspx_th_c_redirect_0 = (org.apache.taglibs.standard.tag.rt.core.RedirectTag) _jspx_tagPool_c_redirect_url_nobody.get(org.apache.taglibs.standard.tag.rt.core.RedirectTag.class);
    _jspx_th_c_redirect_0.setPageContext(_jspx_page_context);
    _jspx_th_c_redirect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_0);
    _jspx_th_c_redirect_0.setUrl("index.jsp");
    int _jspx_eval_c_redirect_0 = _jspx_th_c_redirect_0.doStartTag();
    if (_jspx_th_c_redirect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_redirect_url_nobody.reuse(_jspx_th_c_redirect_0);
      return true;
    }
    _jspx_tagPool_c_redirect_url_nobody.reuse(_jspx_th_c_redirect_0);
    return false;
  }

  private boolean _jspx_meth_c_choose_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_1 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_1.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_1.setParent(null);
    int _jspx_eval_c_choose_1 = _jspx_th_c_choose_1.doStartTag();
    if (_jspx_eval_c_choose_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("            ");
        if (_jspx_meth_c_when_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_1, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_choose_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_1);
      return true;
    }
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_1);
    return false;
  }

  private boolean _jspx_meth_c_when_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_1 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_1.setPageContext(_jspx_page_context);
    _jspx_th_c_when_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_1);
    _jspx_th_c_when_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.loginError != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_when_1 = _jspx_th_c_when_1.doStartTag();
    if (_jspx_eval_c_when_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                <script type=\"text/javascript\">\n");
        out.write("                    $(function () {\n");
        out.write("                        $(\"#loginErrorDialog\").modal();\n");
        out.write("                    });\n");
        out.write("                </script>\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_c_when_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
    return false;
  }
}
