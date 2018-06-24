package mx.gob.ivrea.api.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CUENTA")
public class CuentaEntity {

    @Id
    @Column(name = "CVECUENTA")
    private Long cveCuenta;
    @Column(name = "NUMERO_CUENTA")
    private String numeroCuenta;
    @Column(name = "SALDO")
    private Double saldo;
    @ManyToOne
    @JoinColumn(name = "CVECLIENTE")
    private ClienteEntity cliente;
    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
    private List<MovimientoEntity> movimientos;

    public Long getCveCuenta() {

        return cveCuenta;
    }

    public void setCveCuenta(Long cveCuenta) {

        this.cveCuenta = cveCuenta;
    }

    public String getNumeroCuenta() {

        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {

        this.numeroCuenta = numeroCuenta;
    }

    public Double getSaldo() {

        return saldo;
    }

    public void setSaldo(Double saldo) {

        this.saldo = saldo;
    }

    public ClienteEntity getCliente() {

        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {

        this.cliente = cliente;
    }

    public List<MovimientoEntity> getMovimientos() {

        return movimientos;
    }

    public void setMovimientos(List<MovimientoEntity> movimientos) {

        this.movimientos = movimientos;
    }

}
