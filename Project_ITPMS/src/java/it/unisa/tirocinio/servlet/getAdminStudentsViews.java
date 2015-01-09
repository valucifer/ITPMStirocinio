/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.servlet;

import it.unisa.integrazione.model.Person;
import it.unisa.tirocinio.beans.ViewsResult;
import it.unisa.tirocinio.manager.concrete.ConcreteViews;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Valentino
 */
public class getAdminStudentsViews extends HttpServlet {

    private final JSONObject jsonObject = new JSONObject();
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
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        
        try {
            ConcreteViews aView = ConcreteViews.getInstance();
            ViewsResult aViewResultActive = aView.getAdminStudentActiveTraining();
            ViewsResult aViewResultEnded = aView.getAdminStudentEndedTraining();

            if ((aViewResultActive == null) && (aViewResultEnded == null)) {
                jsonObject.put("status", 0);
                response.getWriter().write(jsonObject.toString());
            }
            JSONArray array = new JSONArray();
            for (Person pers : aViewResultEnded.getPersons()) {
                JSONObject jsonTmp = new JSONObject();
                jsonTmp.put("name", pers.getName());
                jsonTmp.put("surname", pers.getSurname());
                jsonTmp.put("email", pers.getAccount().getEmail());
                jsonTmp.put("trainingstatus", "Concluso");
                array.put(jsonTmp);
            }
            for (Person pers : aViewResultActive.getPersons()) {
                JSONObject jsonTmp = new JSONObject();
                jsonTmp.put("name", pers.getName());
                jsonTmp.put("surname", pers.getSurname());
                jsonTmp.put("email", pers.getAccount().getEmail());
                jsonTmp.put("trainingstatus", "Attivo");
                array.put(jsonTmp);
            }

            jsonObject.put("status", 1);
            jsonObject.put("message", array);
            response.getWriter().write(jsonObject.toString());
        } catch (JSONException ex) {
            Logger.getLogger(getProfessorStudentsViews.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(getProfessorStudentsViews.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                response.getWriter().close();
            } catch (IOException ex) {
                Logger.getLogger(getAdminStudentsViews.class.getName()).log(Level.SEVERE, null, ex);
            }
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
