/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.servlet;

import it.unisa.integrazione.manager.concrete.ConcreteOfferTraining;
import it.unisa.tirocinio.database.ProfessorDBOperation;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Valentino
 */
public class SelectTrainingByProfessorServlet extends HttpServlet {
    private final JSONObject message = new JSONObject();

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
        JSONArray trainingInfoForSpecificProf = new JSONArray();
        try {
            int primaryKey = Integer.parseInt(request.getParameter("primaryKey"));
            ProfessorDBOperation professor = new ProfessorDBOperation();
            ArrayList<ConcreteOfferTraining> training = professor.getOfferTrainingByProfessorByFK_Account(primaryKey);
            for(int i = 0; i < training.size(); i++){
                ConcreteOfferTraining tmp_training = training.get(i);
                JSONObject trainingInfo = new JSONObject();
                trainingInfo.put("idOfferTraining",tmp_training.getidOfferTraining());
                trainingInfo.put("descriptionTraining",tmp_training.getDescription());
                trainingInfoForSpecificProf.put(trainingInfo);
            }
            message.put("status",1);
            message.put("TrainingForSpecificProfessorList", trainingInfoForSpecificProf);
            response.getWriter().write(message.toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsertTrainingByProfessorServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InsertTrainingByProfessorServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(SelectTrainingByProfessorServlet.class.getName()).log(Level.SEVERE, null, ex);
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
