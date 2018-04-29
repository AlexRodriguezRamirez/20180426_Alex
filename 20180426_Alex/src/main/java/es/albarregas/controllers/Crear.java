/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Ave;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author Alex
 */
@WebServlet(name = "Crear", urlPatterns = {"/crear"})
public class Crear extends HttpServlet {

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
        
        StringBuilder error = new StringBuilder();
        error.append("");
        String url;
        Ave ave = new Ave();
        HttpSession sesion = request.getSession(true);
        
        try {
            BeanUtils.populate(ave, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(Crear.class.getName()).log(Level.SEVERE, null, ex);
            new es.albarregas.utils.MyLogger().doLog(ex,this.getClass(),"error");
        }
        sesion.setAttribute("ave", ave);
        
        if (request.getParameter("enviar") != null) {
            
            if (request.getParameter("anilla").equals("")) {
                error.append("Debe introducir una anilla.<br>");
            }
            if (request.getParameter("anilla").length() > 3) {
                error.append("La anilla no puede contener m&aacute;s de 3 caracteres.<br>");
            }
            if (request.getParameter("especie").equals("")) {
                error.append("Debe introducir una especie.<br>");
            }
            if (request.getParameter("lugar").equals("")) {
                error.append("Debe introducir un lugar.<br>");
            }
            if (request.getParameter("fecha").equals("")) {
                error.append("Debe introducir una fecha.<br>");
            }
            
            if (!error.toString().equals("")) {
                request.setAttribute("error", error);
                url = "JSP/Create/inicioC.jsp";
            }
            else {
                url = "JSP/Create/crear.jsp";
            }   
        }
        
        else {
            url = "index.jsp";
        }
        
        
        request.getRequestDispatcher(url).forward(request, response);
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
