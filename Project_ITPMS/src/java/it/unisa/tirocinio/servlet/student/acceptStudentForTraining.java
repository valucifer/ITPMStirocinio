/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.servlet.student;

import it.unisa.tirocinio.beans.Person;
import it.unisa.tirocinio.beans.RejectedTrainingMessage;
import it.unisa.tirocinio.beans.StudentInformation;
import it.unisa.tirocinio.manager.concrete.ConcreteMessageForServlet;
import it.unisa.tirocinio.manager.concrete.ConcretePerson;
import it.unisa.tirocinio.manager.concrete.ConcreteRejectedTrainingMessage;
import it.unisa.tirocinio.manager.concrete.ConcreteStudentInformation;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "acceptStudentForTraining", urlPatterns = {"/acceptStudentForTraining"})

public class acceptStudentForTraining extends HttpServlet {
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
            throws ServletException, IOException, JSONException {
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out = response.getWriter();
        ConcreteMessageForServlet message = new ConcreteMessageForServlet();
        HttpSession session = request.getSession();
        try {
            /* TODO output your page here. You may use following sample code. */
            String studentMatricula = request.getParameter("matricula");
            ConcretePerson aPerson = ConcretePerson.getInstance();
            Person person = aPerson.getPersonToMatricula(studentMatricula);
            
            ConcreteStudentInformation aStudentInformation = ConcreteStudentInformation.getInstance();
            StudentInformation studentInformation = aStudentInformation.readAStudentInformation(person.getSSN());
            
            ConcreteRejectedTrainingMessage rejectedMessage = ConcreteRejectedTrainingMessage.getInstance();
            RejectedTrainingMessage aRejectedMessage = rejectedMessage.readLastTrainingMessage(person.getSSN());
            
            if(aRejectedMessage.getDescription() == null){
                aRejectedMessage = new RejectedTrainingMessage();
                aRejectedMessage.setDescription("La tua richiesta è stata accettata!");
                aRejectedMessage.setPersonSSN(person.getSSN());
                rejectedMessage.createRejectedTrainingMessage(aRejectedMessage);                
            }else{
                aRejectedMessage.setDescription("La tua richiesta è stata accettata!");
                rejectedMessage.updateRejectedTrainingMessage(aRejectedMessage);                     
            }
                    
            studentInformation.setStudentStatus(2);
           
            boolean toReturn = aStudentInformation.updateStudentInformation(studentInformation);
            if(toReturn){
                jsonObject.put("status", 1);
            }else{
                jsonObject.put("status", 0);
            }
            response.getWriter().write(jsonObject.toString());
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
        try {
            processRequest(request, response);
        } catch (JSONException ex) {
            Logger.getLogger(acceptStudentForTraining.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (JSONException ex) {
            Logger.getLogger(acceptStudentForTraining.class.getName()).log(Level.SEVERE, null, ex);
        }
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
