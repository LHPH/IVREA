package externo.rest.service;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

public interface PaymentServices {

    Response obtenerCatalogosServicios();

    Response pagarServicio(@PathParam("id") String clvServicio, @PathParam("cantidad") String cantidad,
            @PathParam("referencia") String referencia);

}
