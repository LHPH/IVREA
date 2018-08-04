package externo.rest.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "demo", namespace = "http://www.myserviceapi.com")
public class Servicio implements Serializable {

    private Long idServicio;
    private String nombre;

    public Servicio() {

    }

    public Servicio(Long id, String nombre) {

        this.idServicio = id;
        this.nombre = nombre;
    }

    public Long getIdServicio() {

        return idServicio;
    }

    public void setIdServicio(Long idServicio) {

        this.idServicio = idServicio;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

}
