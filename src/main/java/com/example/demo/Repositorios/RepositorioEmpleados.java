package com.example.demo.Repositorios;

import com.example.demo.DTOS.EmpleadoDTO;
import com.example.demo.Entidades.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RepositorioEmpleados extends JpaRepository<Empleado, Long> {
}
