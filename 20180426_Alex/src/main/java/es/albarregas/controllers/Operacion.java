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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(name = "Operacion", urlPatterns = {"/operacion"})
public class Operacion extends HttpServlet {

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
        
        HttpSession sesion = request.getSession(true);
        sesion.removeAttribute("ave");
        String url;
        
        if (request.getParameter("enviar") != null) {
            switch (request.getParameter("opcion")) {
                case "create":
                    url = "JSP/Create/inicioC.jsp";
                    break;
                    
                case "read":
                    url = "JSP/Read/inicioR.jsp";
                    break;
                    
                case "update":
                    url = "JSP/Update/inicioU.jsp";
                    break;
                    
                case "delete":
                    url = "JSP/Delete/inicioD.jsp";
                    break;
                
                default:
                    url = "index.jsp";
                    break;
            }
            
            
            if (request.getParameter("opcion").equals("update") || request.getParameter("opcion").equals("delete")) {
                
                
                Connection conexion =(Connection) Conexion.getConexion();
                ResultSet resultado = null;
                ArrayList<Ave> aves= null;
                String sql = "select * from aves;";
                PreparedStatement preparada = null;
                
                try {
                    preparada = conexion.prepareStatement(sql);
                    resultado = preparada.executeQuery(sql);
                    aves= new ArrayList<Ave>();
                    while (resultado.next()) {
                        aves.add(new Ave(resultado.getString(1),resultado.getString(2),resultado.getString(3),resultado.getString(4)));
                    }
                    sesion.setAttribute("aves", aves);
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
                
                
            }
            
            
            
            request.getRequestDispatcher(url).forward(request, response);
            
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Operacion.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Operacion.class.getName()).log(Level.SEVERE, null, ex);
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
