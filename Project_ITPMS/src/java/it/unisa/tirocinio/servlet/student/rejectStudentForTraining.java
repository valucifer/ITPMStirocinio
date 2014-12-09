/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.servlet.student;

import it.unisa.tirocinio.beans.RejectedTrainingMessage;
import it.unisa.tirocinio.beans.StudentInformation;
import it.unisa.tirocinio.manager.concrete.ConcreteMessageForServlet;
import it.unisa.tirocinio.manager.concrete.ConcreteRejectedTrainingMessage;
import it.unisa.tirocinio.manager.concrete.ConcreteStudentInformation;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Valentino
 */
public class rejectStudentForTraining extends HttpServlet {

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
        ConcreteMessageForServlet message = new ConcreteMessageForServlet();
        HttpSession session = request.getSession();
        try {
            /* TODO output your page here. You may use following sample code. */
            String studentSSN = "vvv"; //request.getParameter("studentSSN");
            String description = "bastardo"; //request.getParameter("descriptionError");
            
            ConcreteStudentInformation aStudentInformation = ConcreteStudentInformation.getInstance();
            StudentInformation studentInformation = aStudentInformation.readStudentInformation(studentSSN);
            
            studentInformation.setStudentStatus(1);
            
            ConcreteRejectedTrainingMessage rejectedMessage = ConcreteRejectedTrainingMessage.getInstance();
            RejectedTrainingMessage reject = new RejectedTrainingMessage();
            reject.setDescription(description);
            reject.setPersonSSN(studentSSN);
            rejectedMessage.createRejectedTrainingMessage(reject);
            
            if(aStudentInformation.updateStudentInformation(studentInformation) && rejectedMessage.createRejectedTrainingMessage(reject)){
                message.setMessage("status", 1);
            }else{
                 message.setMessage("status", 0);
            }
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
