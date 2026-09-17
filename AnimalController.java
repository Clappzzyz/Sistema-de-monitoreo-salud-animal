package com.monitoreo.controller;

/**
 * Clase controladora para gestionar las peticiones HTTP relacionadas con los animales.
 * Aplica los estándares de nomenclatura y buenas prácticas de desarrollo web.
 * 
 * @author Cristóbal Acevedo
 * @version 1.0
 */
public class AnimalController {

    /**
     * Método encargado de recibir los parámetros del formulario y registrar el animal.
     * 
     * @param nombre Nombre identificador del animal
     * @param especie Especie a la que pertenece
     * @param estadoSalud Estado clínico actual
     * @return Mensaje de confirmación de registro exitoso
     */
    public String registrarNuevoAnimal(String nombre, String especie, String estadoSalud) {
        // Validar que los campos no estén vacíos antes de procesar
        if(nombre == null || especie == null) {
            return "Error: Los datos son obligatorios.";
        }
        
        // Lógica de inserción hacia la capa de datos (DAO)
        System.out.println("Registrando animal: " + nombre);
        
        return "Registro guardado correctamente.";
    }
}