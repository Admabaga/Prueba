package com.example.demo.Servicios;

import com.example.demo.Converters.EmpleadoConverter;
import com.example.demo.DTOS.EmpleadoDTO;
import com.example.demo.Entidades.Empleado;
import com.example.demo.Repositorios.RepositorioEmpleados;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@Service
public class ServicioEmpleadoImpl implements ServicioEmpleado{
    private final RepositorioEmpleados repositorioEmpleados;

    public ServicioEmpleadoImpl(RepositorioEmpleados repositorioEmpleados) {
        this.repositorioEmpleados = repositorioEmpleados;
    }


    @Override
    public EmpleadoDTO guardarEmpleado(EmpleadoDTO empleadoDTO) {

        if(empleadoDTO == null){
            throw new RuntimeException("Debe completar todos los items");
        }
        if(edadActual(empleadoDTO) < 18){
            throw new RuntimeException("El empleado es menor de edad");
        }

        Empleado empleado = EmpleadoConverter.DtoAEntidad(empleadoDTO);
        empleado = repositorioEmpleados.save(empleado);
        return EmpleadoConverter.EntidadADto(empleado);
    }
    public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    private static Integer edadActual(EmpleadoDTO empleadoDTO){
        LocalDate fechaActual = LocalDate.now();
        Period period = Period.between(fechaActual, convertToLocalDateViaInstant(empleadoDTO.getFechaNacimiento()));
        int años = Math.abs(period.getYears());
        return años;
    }


}
