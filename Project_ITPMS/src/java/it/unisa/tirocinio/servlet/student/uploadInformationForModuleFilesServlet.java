/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.servlet.student;


import it.unisa.tirocinio.beans.Person;
import it.unisa.tirocinio.manager.concrete.ConcreteMessageForServlet;
import it.unisa.tirocinio.manager.concrete.ConcretePerson;
import java.io.*;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
import java.util.logging.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.*;

/**
 *
 * @author Valentino
 */
public class uploadInformationForModuleFilesServlet extends HttpServlet {
    private PrintWriter out = null;
    private boolean isMultipart;
    private String filePath;
    private String fileSeparator = null;
    
    @Override
    public void init() {
        fileSeparator = System.getProperty("file.separator");
        String userHome = System.getProperty("user.home");
        filePath = userHome+fileSeparator+"ModuleForUploadFile";
        
        File directoryCheck = new File(filePath);
        if( !directoryCheck.exists() ){
            directoryCheck.mkdir();
        } 
    }
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
        response.setHeader("Access-Control-Allow-Origin","*");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out = response.getWriter();
            isMultipart = ServletFileUpload.isMultipartContent(request);
            
            String serialNumber = null;
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List fileItems = upload.parseRequest(request);
            Iterator i = fileItems.iterator();
            File fileToStore = null;
            String adminSubfolderPath = filePath;
            serialNumber = "DISTRA - Module";
            adminSubfolderPath += fileSeparator+serialNumber;
            new File(adminSubfolderPath).mkdir();

            while ( i.hasNext () ) {
                FileItem fi = (FileItem)i.next();
                
                if ( !fi.isFormField () ){
                    // Get the uploaded file parameters
                    String fieldName = fi.getFieldName();
                    String fileName = fi.getName();
                    Date date = new Date();
                    if( fieldName.equals("tp")){
                        fileToStore = new File(adminSubfolderPath+fileSeparator+"Module.pdf");
                    }else if( fieldName.equals("eco")){
                        fileToStore = new File(adminSubfolderPath+fileSeparator+"Register.pdf");
                    }
                    fi.write( fileToStore ) ;
                   // out.println("Uploaded Filename: " + fieldName + "<br>");
                }
            }
            ConcreteMessageForServlet message = new ConcreteMessageForServlet();
            message.setMessage("status", 1);
            response.sendRedirect(request.getContextPath()+"/tirocinio/amministratore/tpinserimentofileamministratore.jsp");
            
        } catch (Exception ex) {
            Logger.getLogger(uploadInformationForModuleFilesServlet.class.getName()).log(Level.SEVERE, null, ex);
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
