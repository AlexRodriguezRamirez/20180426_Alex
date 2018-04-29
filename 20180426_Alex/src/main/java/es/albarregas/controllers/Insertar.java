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
@WebServlet(name = "Insertar", urlPatterns = {"/insertar"})
public class Insertar extends HttpServlet {

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
        
        String url;
        String error = null;
        HttpSession sesion = request.getSession(false);
        
        Connection conexion =(Connection) Conexion.getConexion();
        PreparedStatement preparada;
        Ave ave = (Ave) sesion.getAttribute("ave");
        StringBuilder sql = new StringBuilder();
        
        if (request.getParameter("confirmar") != null) {
            
            try {
                sql.append("insert into aves (anilla, especie, lugar, fecha) values ('").append(ave.getAnilla()).append("','").append(ave.getEspecie()).append("','").append(ave.getLugar()).append("','").append(ave.getFecha()).append("');");
            
                preparada = conexion.prepareStatement(sql.toString());
                preparada.executeUpdate();
            }
            
            catch (SQLException ex) {
                error = "La anilla " + ave.getAnilla() + " ya se encuentra en la base de datos.";
                new es.albarregas.utils.MyLogger().doLog(ex,this.getClass(),"error");
                ex.printStackTrace();
            }
            

            request.setAttribute("error", error);
            url = "JSP/Create/finC.jsp";
            
        }
        
        else {
            url = "index.jsp";
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
            Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
            new es.albarregas.utils.MyLogger().doLog(ex,this.getClass(),"error");
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
            Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
            new es.albarregas.utils.MyLogger().doLog(ex,this.getClass(),"error");
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
