package com.example.demo.Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Entity
public class Empleado {
    @Id
    @GeneratedValue
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

    public Empleado(Long id, String nombres, String apellidos, String numeroDocumento, Date fechaNacimiento, Date fechaVinculamiento, String cargo, Double salario, String tiempoEnCompañia, String edadActual) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.numeroDocumento = numeroDocumento;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaVinculamiento = fechaVinculamiento;
        this.cargo = cargo;
        this.salario = salario;
        this.tiempoEnCompañia = tiempoEnCompañia;
        this.edadActual = edadActual;
    }

    public Empleado() {
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getNombres() {return nombres;}

    public void setNombres(String nombres) {this.nombres = nombres;}

    public String getApellidos() {return apellidos;}

    public void setApellidos(String apellidos) {this.apellidos = apellidos;}

    public String getNumeroDocumento() {return numeroDocumento;}

    public void setNumeroDocumento(String numeroDocumento) {this.numeroDocumento = numeroDocumento;}

    public Date getFechaNacimiento() {return fechaNacimiento;}

    public void setFechaNacimiento(Date fechaNacimiento) {this.fechaNacimiento = fechaNacimiento;}

    public Date getFechaVinculamiento() {return fechaVinculamiento;}

    public void setFechaVinculamiento(Date fechaVinculamiento) {this.fechaVinculamiento = fechaVinculamiento;}

    public String getCargo() {return cargo;}

    public void setCargo(String cargo) {this.cargo = cargo;}

    public Double getSalario() {return salario;}

    public void setSalario(Double salario) {this.salario = salario;}

    public String getTiempoEnCompañia() {return tiempoEnCompañia;}

    public void setTiempoEnCompañia(String tiempoEnCompañia) {this.tiempoEnCompañia = tiempoEnCompañia;}

    public String getEdadActual() {return edadActual;}

    public void setEdadActual(String edadActual) {this.edadActual = edadActual;}

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", numeroDocumento='" + numeroDocumento + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", fechaVinculamiento=" + fechaVinculamiento +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                ", tiempoEnCompañia=" + tiempoEnCompañia +
                ", edadActual=" + edadActual +
                '}';
    }
}
