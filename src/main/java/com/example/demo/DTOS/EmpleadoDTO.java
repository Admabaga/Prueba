package com.example.demo.DTOS;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Data

public class EmpleadoDTO {
    private Long id;
    private String nombres;
    private String apellidos;
    private String numeroDocumento;
    private Date fechaNacimiento;
    private Date fechaVinculamiento;
    private String cargo;
    private Double salario;
    private String tiempoEnCompañia;
    private String edadActual;

}
