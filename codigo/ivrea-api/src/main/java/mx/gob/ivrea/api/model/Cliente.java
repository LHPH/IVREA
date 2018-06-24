package mx.gob.ivrea.api.model;

import mx.gob.ivrea.base.BaseModel;

public class Cliente extends BaseModel {

    private Long idCliente;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;
    private Cuenta cuenta;

    public Long getIdCliente() {

        return idCliente;
    }

    public void setIdCliente(Long idCliente) {

        this.idCliente = idCliente;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getDireccion() {

        return direccion;
    }

    public void setDireccion(String direccion) {

        this.direccion = direccion;
    }

    public String getTelefono() {

        return telefono;
    }

    public void setTelefono(String telefono) {

        this.telefono = telefono;
    }

    public String getCorreo() {

        return correo;
    }

    public void setCorreo(String correo) {

        this.correo = correo;
    }

    public Cuenta getCuenta() {

        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {

        this.cuenta = cuenta;
    }

}
