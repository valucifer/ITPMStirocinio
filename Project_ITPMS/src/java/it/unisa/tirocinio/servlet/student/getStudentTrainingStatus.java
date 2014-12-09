/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.servlet.student;

import it.unisa.integrazione.manager.concrete.ConcreteStudent;
import it.unisa.tirocinio.beans.Person;
import it.unisa.tirocinio.beans.StudentInformation;
import it.unisa.tirocinio.beans.StudentStatus;
import it.unisa.tirocinio.manager.concrete.ConcreteMessageForServlet;
import it.unisa.tirocinio.manager.concrete.ConcretePerson;
import it.unisa.tirocinio.manager.concrete.ConcreteStudentInformation;
import it.unisa.tirocinio.manager.concrete.ConcreteStudentStatus;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Valentino
 */
public class getStudentTrainingStatus extends HttpServlet {

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
        
        ConcretePerson aPerson = ConcretePerson.getInstance();
        String email = "vale" ;//request.getParameter("accountEmail");
        
        Person person = aPerson.getStudent(email);
            
        ConcreteStudentInformation aStudentInformation = ConcreteStudentInformation.getInstance();
        StudentInformation studentInformation = aStudentInformation.readStudentInformation(person.getSSN());

        ConcreteStudentStatus aStudentStatus = ConcreteStudentStatus.getInstance();
        StudentStatus studentStatus = aStudentStatus.readStudentStatus(studentInformation.getStudentStatus());
        
        if(studentStatus != null){
            message.setMessage("status",1);
            message.setMessage("description",studentStatus.getDescription());
            //request.getRequestDispatcher("/WEB-INF/gestioneTirocinio&PlacementOrganizzazione.jsp").forward(request, response);
            out.println("message "+message.getMessage("status"));
        }else{
            message.setMessage("status",0);
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
