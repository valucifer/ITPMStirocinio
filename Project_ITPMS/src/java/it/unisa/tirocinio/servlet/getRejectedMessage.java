/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.servlet;

import it.unisa.integrazione.database.PersonManager;
import it.unisa.integrazione.database.exception.ConnectionException;
import it.unisa.tirocinio.beans.Person;
import it.unisa.tirocinio.beans.RejectedTrainingMessage;
import it.unisa.tirocinio.manager.concrete.ConcreteRejectedTrainingMessage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Valentino
 */
@WebServlet(name = "getRejectedMessage", urlPatterns = {"/getRejectedMessage"})

public class getRejectedMessage extends HttpServlet {

    private JSONObject jsonObj = new JSONObject();

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
        HttpSession session = request.getSession();
        try {
            Person pers = (Person) session.getAttribute("person");
            String email = pers.getAccount().getEmail();

            PersonManager aPerson = PersonManager.getInstance();
            Person person = aPerson.getPersonByEmail(email);

            ConcreteRejectedTrainingMessage aRejectedMessage = ConcreteRejectedTrainingMessage.getInstance();
            RejectedTrainingMessage aMessage = aRejectedMessage.readLastTrainingMessage(person.getSsn());
            if (aMessage != null) {
                jsonObj.put("status", 1);
                jsonObj.put("Object", aMessage.getDescription());
            } else {
                jsonObj.put("status", 0);
            }
            response.getWriter().write(jsonObj.toString());
        } catch (JSONException ex) {
            Logger.getLogger(getRejectedMessage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(getRejectedMessage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ConnectionException ex) {
            Logger.getLogger(getRejectedMessage.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            response.getWriter().close();
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
        processRequest(request, response);
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
