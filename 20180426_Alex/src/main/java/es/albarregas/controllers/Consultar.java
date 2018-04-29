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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alex
 */
@WebServlet(name = "Consultar", urlPatterns = {"/consultar"})
public class Consultar extends HttpServlet {

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
        
        String error = "";
        String url = "";

        Connection conexion =(Connection) Conexion.getConexion();
        PreparedStatement preparada = null;
        ResultSet resultado = null;
        Ave ave = null;
        String anilla = request.getParameter("anilla");
        String sql = null;
        
        
        
        if (request.getParameter("enviar")!= null) {
            if (request.getParameter("anilla").equals("")) {
                error = "Debe introducir una anilla.";
            }
            if (request.getParameter("anilla").length() > 3) {
                error = "La anilla no puede contener m&aacute;s de 3 caracteres.";
            }
            
            
            if (!error.equals("")) {
                request.setAttribute("error", error);
                url = "JSP/Read/inicioR.jsp";
            }
            else {
                sql = "select * from aves where anilla = ?";
                preparada = conexion.prepareStatement(sql);
                preparada.setString(1, anilla);
                    
                try {
                    resultado = preparada.executeQuery();
                    resultado.next();
                    ave = new Ave(resultado.getString(1),resultado.getString(2),resultado.getString(3),resultado.getString(4));  
                    request.setAttribute("ave", ave);
            //url = "";
                } catch (SQLException ex) {
                    request.setAttribute("error", "La anilla " + anilla + " no se encuentra en la base de datos.");
                    new es.albarregas.utils.MyLogger().doLog(ex,this.getClass(),"error");
                    ex.printStackTrace();
                }  
                
                url = "JSP/Read/mostrar.jsp";
            }
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
            Logger.getLogger(Consultar.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Consultar.class.getName()).log(Level.SEVERE, null, ex);
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
