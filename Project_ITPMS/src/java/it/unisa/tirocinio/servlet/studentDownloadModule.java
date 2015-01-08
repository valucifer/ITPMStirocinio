/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.servlet;

import it.unisa.integrazione.database.PersonManager;
import it.unisa.integrazione.database.exception.ConnectionException;
import it.unisa.tirocinio.beans.Department;
import it.unisa.tirocinio.beans.Person;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nello
 */
public class studentDownloadModule extends HttpServlet {

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
        try {
            response.setContentType("text/html;charset=UTF-8");
            response.setHeader("Access-Control-Allow-Origin", "*");
            String who = request.getParameter("who");
            String what = request.getParameter("what");
            String rootDirectoryPath = getServletContext().getRealPath("/");
            File directory = new File(rootDirectoryPath + "/files");
            String fullPath = directory.getAbsolutePath();
            String fileSeparator = System.getProperty("file.separator");
            
            PersonManager aPerson = PersonManager.getInstance();
            Person me = aPerson.getPersonByEmail(who);
            Department departmentAbb = me.getDepartment();
            String department = departmentAbb.getAbbreviation();
            String path = fullPath+fileSeparator+department;
            String customFilename = "";
            if( what.equals("registroOre")){
                path += fileSeparator+"register.pdf";
                customFilename = "registro_ore.pdf";
            }else if( what.equals("fineTirocinio")){
                path += fileSeparator+"module.pdf";
                customFilename = "modulo_fine_tirocinio.pdf";
            }
            
            // Make sure to show the download dialog
            response.setHeader("Content-disposition", "attachment; filename="+customFilename);
            ServletContext ctx = getServletContext();
            
            File my_file = new File(path);
            
            // This should send the file to browser
            ServletOutputStream out = response.getOutputStream();
            FileInputStream in = new FileInputStream(my_file);
            String mimeType = ctx.getMimeType(my_file.getAbsolutePath());
            response.setContentType(mimeType != null? mimeType:"application/pdf");
            response.setContentLength((int) my_file.length());
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            in.close();
            out.flush();
            out.close();
        } catch (SQLException ex) {
            Logger.getLogger(studentDownloadModule.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ConnectionException ex) {
            Logger.getLogger(studentDownloadModule.class.getName()).log(Level.SEVERE, null, ex);
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
