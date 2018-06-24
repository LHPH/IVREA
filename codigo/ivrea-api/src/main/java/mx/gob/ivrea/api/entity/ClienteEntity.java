package mx.gob.ivrea.api.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class ClienteEntity {

    @Id
    @Column(name = "")
    private Long cveCliente;
    @Column(name = "")
    private String nombre;
    @Column(name = "")
    private String direccion;
    @Column(name = "")
    private String correo;
    @OneToMany(mappedBy = "cliente")
    private List<CuentaEntity> cuentas;

    public Long getCveCliente() {

        return cveCliente;
    }

    public void setCveCliente(Long cveCliente) {

        this.cveCliente = cveCliente;
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

    public String getCorreo() {

        return correo;
    }

    public void setCorreo(String correo) {

        this.correo = correo;
    }

    public List<CuentaEntity> getCuentas() {

        return cuentas;
    }

    public void setCuentas(List<CuentaEntity> cuentas) {

        this.cuentas = cuentas;
    }

}
