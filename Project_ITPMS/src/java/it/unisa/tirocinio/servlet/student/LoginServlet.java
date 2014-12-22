package it.unisa.tirocinio.servlet.student;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import it.unisa.integrazione.database.AccountManager;
import it.unisa.integrazione.database.exception.AccountNotActiveException;
import it.unisa.integrazione.database.exception.ConnectionException;
import it.unisa.tirocinio.beans.Account;
import it.unisa.tirocinio.beans.Person;
import it.unisa.tirocinio.manager.concrete.ConcreteAccount;
import it.unisa.tirocinio.manager.concrete.ConcretePerson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gemmacatolino
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            AccountManager accountManager = AccountManager.getInstance();
            Account account = accountManager.login(username, password);
            
            ConcretePerson person = ConcretePerson.getInstance();
            Person aPerson = new Person();
            
            if (account != null) {
                if(account.getTypeOfAccount().equals("organization")){
                    session.removeAttribute("loginError");
                    session.setAttribute("organization", account.getEmail());
                    response.sendRedirect("tirocinio/organizzazione/tporganizzazione.jsp");
                }
                if(account.getTypeOfAccount().equals("professor")){
                    session.removeAttribute("loginError");
                    session.setAttribute("person", account.getEmail());
                    response.sendRedirect("tirocinio/professore/tpprofessore.jsp");
                }
                if(account.getTypeOfAccount().equals("student")){
                    session.removeAttribute("loginError");
                    session.setAttribute("person", account.getEmail());
                    response.sendRedirect("tirocinio/studente/tphome.jsp");
                }
                if(account.getTypeOfAccount().equals("administrator")){
                    session.removeAttribute("loginError");
                    session.setAttribute("person", account.getEmail());
                    response.sendRedirect("tirocinio/amministratore/tpamministratore.jsp");
                }
            } else {
                session.setAttribute("loginError", "error");
                response.sendRedirect("login.jsp");
            }
            
        } catch (SQLException sqlException) {
            out.print("<h1>SQL Exception: </h1>" + sqlException.getMessage());
        } catch (ConnectionException connectionException) {
            out.print("<h1>Connection Exception</h1>");
        } catch (AccountNotActiveException ex) {
            out.print("<h1>Account not Active!</h1>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}