/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.servlet.student;

import it.unisa.tirocinio.beans.Person;
import it.unisa.tirocinio.beans.Questionnaire;
import it.unisa.tirocinio.beans.RejectedTrainingMessage;
import it.unisa.tirocinio.beans.TrainingRequest;
import it.unisa.tirocinio.manager.concrete.ConcretePerson;
import it.unisa.tirocinio.manager.concrete.ConcreteQuestionnaire;
import it.unisa.tirocinio.manager.concrete.ConcreteRejectedTrainingMessage;
import it.unisa.tirocinio.manager.concrete.ConcreteTrainingRequest;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Valentino
 */
public class insertTrainingQuestionnaire extends HttpServlet {

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
            String matricolaStudente = request.getParameter("matricolaStudente");
            String nomeAzienda = request.getParameter("nomeAzienda");
            String tipologiaAzienda = request.getParameter("tipologiaAzienda");
            String uno = request.getParameter("uno");
            String due = request.getParameter("due");
            String tre = request.getParameter("tre");
            String quattro = request.getParameter("quattro");
            String cinque = request.getParameter("cinque");
            String sei = request.getParameter("sei");
            String sette = request.getParameter("sette");

            ConcretePerson aPerson = ConcretePerson.getInstance();
            Person person = aPerson.getPersonByMatricula(matricolaStudente);

            ConcreteTrainingRequest aTrainingRequest = ConcreteTrainingRequest.getInstance();
            TrainingRequest trainingRequest = aTrainingRequest.readTrainingRequestByStudent(person.getSSN());

            if (trainingRequest.getTrainingStatus() == 2) {

                Questionnaire aQuestionnaire = new Questionnaire(nomeAzienda, tipologiaAzienda, uno, due, person.getSSN(), tre, quattro, cinque, sei, sette);

                ConcreteQuestionnaire questionnaires = ConcreteQuestionnaire.getInstance();
                boolean toReturn = questionnaires.insertQuestionnaire(aQuestionnaire);

                ConcreteRejectedTrainingMessage aRejectedMessage = ConcreteRejectedTrainingMessage.getInstance();
                RejectedTrainingMessage messageReject = aRejectedMessage.readLastTrainingMessage(person.getSSN());
                boolean toReturnMessage = aRejectedMessage.deleteOrganization(messageReject.getIdRejectedTraingMessage());

                trainingRequest.setTrainingStatus(3);

                boolean toReturnTraining = aTrainingRequest.updateTrainingRequest(trainingRequest);

                if (toReturn && toReturnTraining && toReturnMessage) {
                    request.setAttribute("questionnaireStatus", 1);
                } else {
                    request.setAttribute("questionnaireStatus", 0);
                }
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/tirocinio/studente/tpquestionario.jsp");
                dispatcher.forward(request, response);
                //response.sendRedirect(request.getContextPath() + "/tirocinio/studente/tpquestionario.jsp");
            }else{
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/tirocinio/studente/tpquestionario.jsp");
                dispatcher.forward(request, response);
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
