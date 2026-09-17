package com.monitoreo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AnimalServlet", urlPatterns = {"/AnimalServlet"})
public class AnimalServlet extends HttpServlet {

    // Manejo de peticiones POST (Recepción de datos del formulario)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Captura de parámetros enviados por el formulario HTML
        String nombre = request.getParameter("nombre");
        String especie = request.getParameter("especie");
        String estadoSalud = request.getParameter("estadoSalud");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Resultado del Registro</title></head>");
            out.println("<body>");
            out.println("<h2>¡Animal registrado con éxito mediante Servlet!</h2>");
            out.println("<p><strong>Nombre:</strong> " + nombre + "</p>");
            out.println("<p><strong>Especie:</strong> " + especie + "</p>");
            out.println("<p><strong>Estado de Salud:</strong> " + estadoSalud + "</p>");
            out.println("<br><a href='registro_animal.jsp'>Registrar otro animal</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // Manejo opcional de peticiones GET para consultas
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().println("Servidor activo para el sistema de monitoreo animal (GET).");
    }
}