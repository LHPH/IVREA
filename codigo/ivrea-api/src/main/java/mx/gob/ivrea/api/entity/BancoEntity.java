package mx.gob.ivrea.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BANCOS")
public class BancoEntity {

    @Id
    @Column(name = "CVEBANCO")
    private String cveBanco;
    @Column(name = "DESCRIPCION")
    private String nombre;

    public String getCveBanco() {

        return cveBanco;
    }

    public void setCveBanco(String cveBanco) {

        this.cveBanco = cveBanco;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

}
