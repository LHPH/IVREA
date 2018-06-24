package mx.gob.ivrea.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TARJETA")
public class TarjetaEntity {

    @Id
    @Column(name = "CVETARJETA")
    private Long cveTarjeta;
    @Column(name = "NUMERO_TARJETA")
    private String numeroTarjeta;
    @Column(name = "NIP")
    private String nip;
    @Column(name = "CVC")
    private String cvc;
    @Column(name = "ACTIVA")
    private Integer activa;
    //private CategoriaTarjetaEntity categoria;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CVECUENTA")
    private CuentaEntity cuenta;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CVEBANCO")
    private BancoEntity banco;

    public Long getCveTarjeta() {

        return cveTarjeta;
    }

    public void setCveTarjeta(Long cveTarjeta) {

        this.cveTarjeta = cveTarjeta;
    }

    public String getNumeroTarjeta() {

        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {

        this.numeroTarjeta = numeroTarjeta;
    }

    public String getNip() {

        return nip;
    }

    public void setNip(String nip) {

        this.nip = nip;
    }

    public String getCvc() {

        return cvc;
    }

    public void setCvc(String cvc) {

        this.cvc = cvc;
    }

    public Integer getActiva() {

        return activa;
    }

    public void setActiva(Integer activa) {

        this.activa = activa;
    }

   /* public CategoriaTarjetaEntity getCategoria() {

        return categoria;
    }

    public void setCategoria(CategoriaTarjetaEntity categoria) {

        this.categoria = categoria;
    }*/

    public CuentaEntity getCuenta() {

        return cuenta;
    }

    public void setCuenta(CuentaEntity cuenta) {

        this.cuenta = cuenta;
    }

    public BancoEntity getBanco() {

        return banco;
    }

    public void setBanco(BancoEntity banco) {

        this.banco = banco;
    }

}
