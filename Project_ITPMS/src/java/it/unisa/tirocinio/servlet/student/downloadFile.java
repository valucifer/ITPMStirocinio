/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.servlet.student;

import it.unisa.tirocinio.beans.*;
import it.unisa.tirocinio.manager.concrete.*;
import java.io.*;
import static java.sql.DriverManager.println;
import javafx.print.Printer;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import jdk.nashorn.internal.objects.Global;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

/**
 *
 * @author Valentino
 */
@WebServlet(name = "downloadFile", urlPatterns = {"/downloadFile"})

public class downloadFile extends HttpServlet {
    static final long serialVersionUID = 1L;

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
        
        String matricula = request.getParameter("matricula");
        String tipologia = request.getParameter("typology");
        
        ConcretePerson aPerson = ConcretePerson.getInstance();
        Person person = aPerson.getPersonByMatricula(matricula);
         
        String filepath = "";
        
        ConcreteStudentInformation aStudentInformation = ConcreteStudentInformation.getInstance();
        StudentInformation studentInformation = aStudentInformation.readAStudentInformation(person.getSSN());
        
        if(tipologia.equals("CV")){
            filepath = studentInformation.getCVPath();
        }
        if(tipologia.equals("ES")){
            filepath = studentInformation.getATPath();
        }
        
        File file = new File(filepath);
        int length   = 0;
        ServletOutputStream outStream = response.getOutputStream();
        
        response.setContentType("Content-Type: application/octet-stream");
        response.setContentLength((int)file.length());

        // sets HTTP header
        response.setHeader("Content-Disposition", "attachment; filename=" + tipologia + ".pdf");

        byte[] byteBuffer = new byte[4096];
        DataInputStream in = new DataInputStream(new FileInputStream(file));

        // reads the file's bytes and writes them to the response stream
        while ((in != null) && ((length = in.read(byteBuffer)) != -1)){
            outStream.write(byteBuffer,0,length);
        }

        in.close();
        outStream.close();
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
