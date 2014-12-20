/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.servlet.student;

import it.unisa.tirocinio.beans.Person;
import it.unisa.tirocinio.beans.StudentInformation;
import it.unisa.tirocinio.manager.concrete.ConcreteMessageForServlet;
import it.unisa.tirocinio.manager.concrete.ConcretePerson;
import it.unisa.tirocinio.manager.concrete.ConcreteStudentInformation;
import it.unisa.tirocinio.manager.concrete.ConcreteTrainingRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet(name = "getStudentDetails", urlPatterns = {"/getStudentDetails"})

public class getStudentDetails extends HttpServlet {
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
            
            ConcreteStudentInformation aStudentInformation = ConcreteStudentInformation.getInstance();
            ArrayList<StudentInformation> studentInformation = aStudentInformation.getAllStudentInformations();
            ConcretePerson aPerson = ConcretePerson.getInstance();
            
            ConcreteTrainingRequest aTrainingRequest = ConcreteTrainingRequest.getInstance();
            
            if(studentInformation == null){
                jsonObject.put("status", 0);
            }else{
                JSONArray array = new JSONArray();
                for( StudentInformation stuInf: studentInformation ){
                    Person person = aPerson.readPersonByAccount(stuInf.getEmailStudent());
                    int trainingStatus = aTrainingRequest.readTrainingRequestByStudent(person.getSSN()).getTrainingStatus();
                    if( (trainingStatus != 2) && (trainingStatus != 3) ){
                        JSONObject jsonTmp = new JSONObject();
                        jsonTmp.put("idStudent",stuInf.getMatricula());
                        jsonTmp.put("matricula", stuInf.getMatricula());
                        jsonTmp.put("credenziali", stuInf.getStudentSSN());
                        jsonTmp.put("statusStudent", stuInf.getStudentStatus());
                        jsonTmp.put("curriculum", stuInf.getCVPath());
                        jsonTmp.put("libretto", stuInf.getATPath());
                        jsonTmp.put("emailStudent", stuInf.getEmailStudent());

                        array.put(jsonTmp);
                    }
                }
                jsonObject.put("status", 1);
                jsonObject.put("message", array);
                //request.setAttribute("trainingMessage",message);
                //out.println(trainingOffer.get(0).getDescription()+" "+trainingOffer.get(0).getIdOfferTraining());
            }
            response.getWriter().write(jsonObject.toString());
        } catch (JSONException ex) {
            Logger.getLogger(getStudentDetails.class.getName()).log(Level.SEVERE, null, ex);
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
