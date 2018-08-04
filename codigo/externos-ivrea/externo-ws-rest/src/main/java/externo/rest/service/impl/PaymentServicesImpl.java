package externo.rest.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import externo.rest.model.Recibo;
import externo.rest.model.Servicio;
import externo.rest.service.PaymentServices;
import externo.rest.service.util.Constantes;

public class PaymentServicesImpl implements PaymentServices {

    @GET
    @Path(Constantes.OBTENER_CATALOGO)
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED })
    public Response obtenerCatalogosServicios() {

        List<Servicio> list = new ArrayList<Servicio>();
        Servicio s = new Servicio(1L, "Redial");
        Servicio s2 = new Servicio(2L, "Luz");
        Servicio s3 = new Servicio(3L, "Telefono y/o Internet");
        Servicio s4 = new Servicio(4L, "Otro");

        list.add(s);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        return Response.ok(list).build();
    }

    @POST
    @Path(Constantes.PAGAR_SERVICIO)
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED })
    public Response pagarServicio(@PathParam("id") String clvServicio, @PathParam("cantidad") String cantidad,
            @PathParam("referencia") String referencia) {

        Recibo recibo = new Recibo();
        recibo.setFecha(new Date());
        recibo.setExito(true);
        recibo.setIdTransaccion("" + ((int) (Math.random() * 1000) + 1));

        StringBuilder sb = new StringBuilder();
        sb.append("Se ha pagado satisfactoriamente la cantidad de ");
        sb.append(cantidad);
        sb.append("para pagar el servicio cuya transaccion es ");
        sb.append(recibo.getIdTransaccion());
        recibo.setMensaje(sb.toString());

        return Response.ok(recibo).build();
    }

}
