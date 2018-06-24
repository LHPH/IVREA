package mx.gob.ivrea.api.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIMIENTO")
public class MovimientoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_MOV")
    @SequenceGenerator(name = "SEC_MOV", sequenceName = "SEQ_MOVIMIENTO", allocationSize = 5)
    private Long cveMovimiento;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "CANTIDAD")
    private String cantidad;
    @Column(name = "FECHA")
    private Date fecha;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CVECUENTA", referencedColumnName = "CVECUENTA")
    private CuentaEntity cuenta;

    public Long getCveMovimiento() {

        return cveMovimiento;
    }

    public void setCveMovimiento(Long cveMovimiento) {

        this.cveMovimiento = cveMovimiento;
    }

    public String getDescripcion() {

        return descripcion;
    }

    public void setDescripcion(String descripcion) {

        this.descripcion = descripcion;
    }

    public String getCantidad() {

        return cantidad;
    }

    public void setCantidad(String cantidad) {

        this.cantidad = cantidad;
    }

    public Date getFecha() {

        return fecha;
    }

    public void setFecha(Date fecha) {

        this.fecha = fecha;
    }

    public CuentaEntity getCuenta() {

        return cuenta;
    }

    public void setCuenta(CuentaEntity cuenta) {

        this.cuenta = cuenta;
    }

}
