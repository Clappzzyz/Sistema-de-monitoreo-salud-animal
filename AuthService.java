package com.monitoreo.api;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servicio web para gestionar el registro y la autenticación (Login) de usuarios
 * en el sistema de monitoreo.
 * 
 * @author Cristóbal Acevedo
 * @version 1.0
 */
@WebServlet(name = "AuthService", urlPatterns = {"/api/auth"})
public class AuthService extends HttpServlet {

    // Simulación de base de datos en memoria para el ejercicio
    private static String usuarioRegistrado = "admin";
    private static String passwordRegistrado = "12345";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        
        // Capturar parámetros enviados en la petición
        String accion = request.getParameter("accion"); // "registrar" o "login"
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        PrintWriter out = response.getWriter();

        if ("registrar".equalsIgnoreCase(accion)) {
            // Lógica de registro básica
            usuarioRegistrado = usuario;
            passwordRegistrado = password;
            out.println("{\"estado\": \"success\", \"mensaje\": \"Usuario registrado exitosamente.\"}");
            
        } else if ("login".equalsIgnoreCase(accion)) {
            // Lógica de validación de autenticación
            if (usuarioRegistrado.equals(usuario) && passwordRegistrado.equals(password)) {
                out.println("{\"estado\": \"success\", \"mensaje\": \"Autenticación satisfactoria. Bienvenid@ " + usuario + "\"}");
            } else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                out.println("{\"estado\": \"error\", \"mensaje\": \"Error en la autenticación: usuario o contraseña incorrectos.\"}");
            }
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.println("{\"estado\": \"error\", \"mensaje\": \"Acción no válida.\"}");
        }
    }
}