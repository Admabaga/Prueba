package com.example.demo.Controlador;

import com.example.demo.DTOS.EmpleadoDTO;
import com.example.demo.Servicios.ServicioEmpleado;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorEmpleado {
  private ServicioEmpleado servicioEmpleado;
  public ControladorEmpleado(ServicioEmpleado servicioEmpleado) {
    this.servicioEmpleado = servicioEmpleado;
  }

  @PostMapping(value = "/empleados")
  public EmpleadoDTO guardarEmpleado(@RequestBody EmpleadoDTO empleadoDTO) {
    return servicioEmpleado.guardarEmpleado(empleadoDTO);
  }

}
