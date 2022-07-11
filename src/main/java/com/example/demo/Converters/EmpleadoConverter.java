package com.example.demo.Converters;

import com.example.demo.DTOS.EmpleadoDTO;
import com.example.demo.Entidades.Empleado;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class EmpleadoConverter {

    public static Empleado DtoAEntidad(EmpleadoDTO empleadoDTO) {
        Empleado empleado = new Empleado();
        empleado.setId(empleadoDTO.getId());
        empleado.setNombres(empleadoDTO.getNombres());
        empleado.setApellidos(empleadoDTO.getApellidos());
        empleado.setCargo(empleadoDTO.getCargo());
        empleado.setSalario(empleadoDTO.getSalario());
        empleado.setFechaNacimiento(empleadoDTO.getFechaNacimiento());
        empleado.setFechaVinculamiento(empleadoDTO.getFechaVinculamiento());
        empleado.setNumeroDocumento(empleadoDTO.getNumeroDocumento());
        return empleado;
    }
    public static EmpleadoDTO EntidadADto(Empleado empleado) {
        EmpleadoDTO empleadoDTO = new EmpleadoDTO();
        empleadoDTO.setId(empleado.getId());
        empleadoDTO.setNombres(empleado.getNombres());
        empleadoDTO.setApellidos(empleado.getApellidos());
        empleadoDTO.setCargo(empleado.getCargo());
        empleadoDTO.setSalario(empleado.getSalario());
        empleadoDTO.setFechaNacimiento(empleado.getFechaNacimiento());
        empleadoDTO.setFechaVinculamiento(empleado.getFechaVinculamiento());
        empleadoDTO.setNumeroDocumento(empleado.getNumeroDocumento());
        empleadoDTO.setEdadActual(calculoEdadActual(empleadoDTO));
        empleadoDTO.setTiempoEnCompañia(calculoTiempoEnLaEmpresa(empleadoDTO));
        return empleadoDTO;
    }
    private static String calculoEdadActual(EmpleadoDTO empleadoDTO){
        LocalDate fechaActual = LocalDate.now();
        Period period = Period.between(fechaActual, convertToLocalDateViaInstant(empleadoDTO.getFechaNacimiento()));
        int años = Math.abs(period.getYears());
        int meses = Math.abs(period.getMonths());
        int dias = Math.abs(period.getDays());
        String edadActual = String.format("%s Años, %s Meses, %s dias", años,meses,dias);
        return edadActual;
    }
    public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
    private static String calculoTiempoEnLaEmpresa(EmpleadoDTO empleadoDTO){
        LocalDate fechaActual = LocalDate.now();
        Period period = Period.between(fechaActual, convertToLocalDateViaInstant(empleadoDTO.getFechaVinculamiento()));
        int años = Math.abs(period.getYears());
        int meses = Math.abs(period.getMonths());
        int dias = Math.abs(period.getDays());
        String tiempoEnEmpresa = String.format("%s Años, %s Meses, %s dias", años,meses,dias);
        return tiempoEnEmpresa;
    }

}

