package externo.soap.service;

import java.util.List;

import javax.jws.WebService;

import externo.soap.model.ProveedorTelefonia;
import externo.soap.model.RespuestaPago;
import externo.soap.model.SolicitudPago;

@WebService
public interface TelefoniaService {

    List<ProveedorTelefonia> obtenerProveedoresTelefonia();

    RespuestaPago pagarServicio(SolicitudPago pago);

}
