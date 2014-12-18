/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.servlet.student;

import it.unisa.tirocinio.beans.Organization;
import it.unisa.tirocinio.beans.Person;
import it.unisa.tirocinio.beans.TrainingOffer;
import it.unisa.tirocinio.beans.TrainingRequest;
import it.unisa.tirocinio.manager.concrete.ConcreteMessageForServlet;
import it.unisa.tirocinio.manager.concrete.ConcreteOrganization;
import it.unisa.tirocinio.manager.concrete.ConcretePerson;
import it.unisa.tirocinio.manager.concrete.ConcreteTrainingOffer;
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

@WebServlet(name = "getStudentTrainingCompleteForTable", urlPatterns = {"/getStudentTrainingCompleteForTable"})
public class getStudentTrainingCompleteForTable extends HttpServlet {
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
        
        try {
            ConcretePerson aPerson = ConcretePerson.getInstance();
            ArrayList<Person> person = aPerson.getAllPeople();
            ArrayList<Person> student = new ArrayList<Person>();
            
            for(Person pers: person){
                if(aPerson.isAStudent(pers.getAccountEmail()))
                    student.add(pers);
            }
            
            ConcreteTrainingRequest aTrainingRequest = ConcreteTrainingRequest.getInstance();
            ConcreteOrganization anOrganization = ConcreteOrganization.getInstance();
            
            JSONArray array = new JSONArray();
            for( Person stud: student ){
                JSONObject jsonTmp = new JSONObject();
                jsonTmp.put("matricola", stud.getMatricula());
                jsonTmp.put("credenziali", stud.getName()+" "+stud.getSurname());
                jsonTmp.put("email", stud.getAccountEmail());
                jsonTmp.put("telefono", stud.getPhone());
                
                TrainingRequest trainingRequest = aTrainingRequest.readTrainingRequestByStudent(stud.getSSN());
                if(trainingRequest.getTrainingStatus() > 1){
                    jsonTmp.put("titolo", trainingRequest.getTitle());

                    Organization organization = anOrganization.readOrganization(trainingRequest.getOrganizationVATNumber());
                    jsonTmp.put("azienda", organization.getCompanyName());
                    
                    if(trainingRequest.getTrainingStatus() == 3){
                       jsonTmp.put("questionario", "Ha concluso il tirocinio");
                    }
                    if(trainingRequest.getTrainingStatus() == 2){
                        jsonTmp.put("questionario", "Non ha ancora concluso il questionario");
                    }
                    array.put(jsonTmp);
                }
            }
            
            if(array.length() == 0){
                jsonObject.put("status", 0);
            }else{
                jsonObject.put("status", 1);
                jsonObject.put("message", array);
            }
            
            //request.setAttribute("trainingMessage",message);
            //out.println(trainingOffer.get(0).getDescription()+" "+trainingOffer.get(0).getIdOfferTraining());
               
            response.getWriter().write(jsonObject.toString());
        } catch (JSONException ex) {
            Logger.getLogger(selectTrainingByOrganization.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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
