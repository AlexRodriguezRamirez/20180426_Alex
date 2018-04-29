/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Ave;
import es.albarregas.connections.Conexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alex
 */
@WebServlet(name = "Modificar", urlPatterns = {"/modificar"})
public class Modificar extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        String url = "";
        String error = "";
        HttpSession sesion = request.getSession(false);
        Ave ave = (Ave) sesion.getAttribute("ave");
        
        if (request.getParameter("confirmar") != null) {
            if(request.getParameter("especie").equals(ave.getEspecie()) && request.getParameter("lugar").equals(ave.getLugar()) && request.getParameter("fecha").equals(ave.getFecha())){
                    
                 error="No se ha modificado ning&uacute;n valor.";
                 request.setAttribute("error", error);
            }
            
            else {
                
                Connection conexion =(Connection) Conexion.getConexion();
                StringBuilder sql = new StringBuilder();
                PreparedStatement preparada = null;
                
                sql.append("update aves set especie='").append(request.getParameter("especie")).append("',lugar='").append(request.getParameter("lugar")).append("',fecha='").append(request.getParameter("fecha")).append("' WHERE anilla='").append(ave.getAnilla()).append("'");
                preparada = conexion.prepareStatement(sql.toString());
                preparada.executeUpdate();
   
            }
            
            url = "JSP/Update/finU.jsp";
        }
        
        else {
            if (request.getParameter("volver") != null) {
                url = "index.jsp";
            }   
        }
        
        request.getRequestDispatcher(url).forward(request, response);
        
        
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Modificar.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Modificar.class.getName()).log(Level.SEVERE, null, ex);
        }
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
