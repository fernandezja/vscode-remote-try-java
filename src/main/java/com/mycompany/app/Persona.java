/*----------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 *---------------------------------------------------------------------------------------*/

package com.mycompany.app;

import java.time.LocalDate;
import java.time.Period;

public abstract class Persona 
      implements IRegistrarAsistencia
   {

    public Persona(String nombre) {
    
        if (nombre == "") {
            throw new RuntimeException("No se permite nombre vacio");
        }

       //this.nombre = nombre
       this.setNombre(nombre);
   }

   private String nombre;

   public void setNombre(String valor){
       this.nombre = valor;
   }

   public String getNombre(){
        return this.nombre;
   }

   
   private LocalDate fechaNacimiento;

   public void setFechaNacimiento(LocalDate valor) {
      this.fechaNacimiento = valor;
   }

   public LocalDate getFechaNacimiento() {
      return this.fechaNacimiento;
   }

   public int edad() {
      //Option 1
      //int year = LocalDate.now().getYear();      
      //return year - this.getFechaNacimiento().getYear();

      //option 2
      return Period.between(this.getFechaNacimiento(), 
                           LocalDate.now()).getYears();
   }

   
   public String asistencia() {
      return "Asistencia registrada general";
      //return "Ir al campus a marcar";
   }

   public String formatear(String valor){
      return String.format("%s [FORMATEADO]", valor);   
   }

}
