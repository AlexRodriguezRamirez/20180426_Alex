/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.connections;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Alex
 */


public class Conexion {
    public static Connection conexion;

    public static Connection getConexion() throws SQLException {
        
        try{
            Context initialContext = new InitialContext();
            DataSource dataSource = (DataSource)initialContext.lookup("java:comp/env/jdbc/pruebasjava");
            conexion = dataSource.getConnection();
        } catch(NamingException ex){
            System.out.println("Problemas en el acceso al recurso...");
            ex.printStackTrace();
        }
       return conexion;
    }
}
