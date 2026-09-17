package com.monitoreo.api;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * API REST para la gestión y consulta de los registros del Sistema de Monitoreo Animal.
 * Cumple con los estándares de diseño y desarrollo de servicios web del proyecto.
 * 
 * @author Cristóbal Acevedo
 * @version 1.0
 */
@WebServlet(name = "AnimalesApi", urlPatterns = {"/api/animales"})
public class AnimalesApi extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        // Simulación de respuesta JSON con el listado de animales
        out.println("[");
        out.println("  {\"id\": 1, \"nombre\": \"Luna\", \"especie\": \"Bovino\", \"estadoSalud\": \"Estable\"},");
        out.println("  {\"id\": 2, \"nombre\": \"Rayo\", \"especie\": \"Equino\", \"estadoSalud\": \"En Observación\"}");
        out.println("]");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        
        String nombre = request.getParameter("nombre");
        String especie = request.getParameter("especie");
        String estadoSalud = request.getParameter("estadoSalud");
        
        PrintWriter out = response.getWriter();
        
        if(nombre != null && especie != null) {
            response.setStatus(HttpServletResponse.SC_CREATED);
            out.println("{\"estado\": \"success\", \"mensaje\": \"Animal " + nombre + " registrado correctamente via API.\"}");
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.println("{\"estado\": \"error\", \"mensaje\": \"Faltan datos obligatorios para el registro.\"}");
        }
    }
}