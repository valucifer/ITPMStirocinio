/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.servlet.student;

import it.unisa.tirocinio.manager.concrete.ConcreteMessageForServlet;
import it.unisa.tirocinio.manager.concrete.ConcreteTrainingOffer;
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
@WebServlet(name = "deleteTrainingOfferByOrganizationServlet", urlPatterns = {"/deleteTrainingOfferByOrganizationServlet"})

public class deleteTrainingOfferByOrganizationServlet extends HttpServlet {
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
        response.setHeader("Access-Control-Allow-Origin", "*");
        
        PrintWriter out = response.getWriter();
        
        try {
            /* TODO output your page here. You may use following sample code. */
            ConcreteMessageForServlet message = new ConcreteMessageForServlet();
            int idRemove = Integer.parseInt(request.getParameter("idRemove"));
            HttpSession session = request.getSession();
            
            ConcreteTrainingOffer aTrainingOffer = ConcreteTrainingOffer.getInstance();
            
            boolean toReturn = aTrainingOffer.deleteTrainingOffer(idRemove);
            
            if(toReturn){
                //message.setMessage("status", 1);
                jsonObject.put("status",1);
            }else{
                //message.setMessage("status", 0);
                jsonObject.put("status",0);
            }
            //request.setAttribute("message",message);
            //response.sendRedirect(request.getContextPath()+"/tirocinio/organizzazione/tporganizzazione.jsp");
            
            response.getWriter().write(jsonObject.toString());
        } catch (JSONException ex) {
            Logger.getLogger(deleteTrainingOfferByOrganizationServlet.class.getName()).log(Level.SEVERE, null, ex);
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
