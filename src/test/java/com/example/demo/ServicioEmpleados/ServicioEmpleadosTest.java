package com.example.demo.ServicioEmpleados;

import com.example.demo.Converters.EmpleadoConverter;
import com.example.demo.DTOS.EmpleadoDTO;
import com.example.demo.Entidades.Empleado;
import com.example.demo.Repositorios.RepositorioEmpleados;
import com.example.demo.Servicios.ServicioEmpleado;
import com.example.demo.Servicios.ServicioEmpleadoImpl;
import org.junit.Test;
import org.mockito.Mockito;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ServicioEmpleadosTest {
    private RepositorioEmpleados repositorioEmpleadosMock = Mockito.mock(RepositorioEmpleados.class);
    private ServicioEmpleado servicioEmpleado = new ServicioEmpleadoImpl(repositorioEmpleadosMock) {
    };

    @Test
    public void guardarEmpleado() throws ParseException {
        //given
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        Date fechaDeNacimiento = format.parse("1995-10-14");
        Date fechaVinculacion = format.parse("2020-10-14");
        EmpleadoDTO empleadoDTO = new EmpleadoDTO();
        empleadoDTO.setId(5l);
        empleadoDTO.setNombres("adrian Mauricio");
        empleadoDTO.setApellidos("Barrera garcia");
        empleadoDTO.setCargo("Administrador");
        empleadoDTO.setFechaNacimiento(fechaDeNacimiento);
        empleadoDTO.setSalario(200000.0);
        empleadoDTO.setTiempoEnCompañia("2 Años, 5 Meses, 28 dias");
        empleadoDTO.setEdadActual("27 Años, 5 Meses, 28 dias");
        empleadoDTO.setFechaVinculamiento(fechaVinculacion);
        Empleado empleado = EmpleadoConverter.DtoAEntidad(empleadoDTO);
        when(repositorioEmpleadosMock.save(any(Empleado.class))).thenReturn(empleado);

        //when
        EmpleadoDTO empleadoDto = servicioEmpleado.guardarEmpleado(empleadoDTO);

        //then
        verify(repositorioEmpleadosMock, times(1)).save(any(Empleado.class));
        assertEquals(empleadoDTO.getId(), empleadoDto.getId());
        assertEquals(empleadoDTO.getNombres(), empleadoDto.getNombres());
        assertEquals(empleadoDTO.getApellidos(), empleadoDto.getApellidos());
        assertEquals(empleadoDTO.getCargo(), empleadoDto.getCargo());
        assertEquals(empleadoDTO.getSalario(), empleadoDto.getSalario());
        assertEquals(empleadoDTO.getFechaNacimiento(), empleadoDto.getFechaNacimiento());
        assertEquals(empleadoDTO.getFechaVinculamiento(), empleadoDto.getFechaVinculamiento());
        assertEquals(empleadoDTO.getTiempoEnCompañia(), empleadoDto.getTiempoEnCompañia());
        assertEquals(empleadoDTO.getEdadActual(), empleadoDto.getEdadActual());
    }
}
