/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.servlet.student;

import it.unisa.tirocinio.beans.Organization;
import it.unisa.tirocinio.beans.Person;
import it.unisa.tirocinio.beans.TrainingRequest;
import it.unisa.tirocinio.manager.concrete.ConcreteMessageForServlet;
import it.unisa.tirocinio.manager.concrete.ConcreteOrganization;
import it.unisa.tirocinio.manager.concrete.ConcretePerson;
import it.unisa.tirocinio.manager.concrete.ConcreteTrainingRequest;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Valentino
 */
public class insertTrainingRequestServlet extends HttpServlet {

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
        ConcreteMessageForServlet message = new ConcreteMessageForServlet();
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            String title = "marco carta";//request.getParameter("title");
            String description = "bho"; //request.getParameter("description");
            String professor = "nello";//request.getParameter("professorSSN");
            String student = "vale";//request.getParameter("studentSSN");
            String organiz = "ibm";//request.getParameter("organization");
            
            ConcretePerson aStudent = ConcretePerson.getInstance();
            Person studentSSN = aStudent.getStudent(student);
            
            ConcretePerson aProfessor = ConcretePerson.getInstance();
            Person professorSSN = aProfessor.getProfessor(professor);
            
            ConcreteOrganization anOrganization = ConcreteOrganization.getInstance();
            Organization organization = anOrganization.getOrganizationByAccount(organiz);
            
            ConcreteTrainingRequest aTrainingRequest = ConcreteTrainingRequest.getInstance();
            TrainingRequest trainingRequest = new TrainingRequest();
            
            trainingRequest.setDescription(description);
            trainingRequest.setOrganizationVATNumber(organization.getVATNumber());
            trainingRequest.setPersonSSN(professorSSN.getSSN());
            trainingRequest.setStudentSSN(studentSSN.getSSN());
            trainingRequest.setTitle(title);
            trainingRequest.setTrainingStatus(1);
            
            if(aTrainingRequest.createTrainingRequest(trainingRequest))
                message.setMessage("status", 1);
            else
                message.setMessage("status", 0);
            out.println("mmm "+message.getMessage("status"));
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
