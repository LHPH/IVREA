package externo.soap.service.impl;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.jws.WebService;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import externo.soap.model.ProveedorTelefonia;
import externo.soap.model.RespuestaPago;
import externo.soap.model.SolicitudPago;
import externo.soap.repository.TelefoniaRepository;
import externo.soap.service.TelefoniaService;

@WebService(endpointInterface = "externo.soap.service.TelefoniaService", serviceName = "TelefoniaService")
@Service
public class TelefoniaServiceImpl implements TelefoniaService {

    @Autowired
    TelefoniaRepository telefoniaRepository;

    public List<ProveedorTelefonia> obtenerProveedoresTelefonia() {

        return telefoniaRepository.obtenerProveedoresTelefonia();
    }

    public RespuestaPago pagarServicio(SolicitudPago pago) {

        RespuestaPago respuesta = new RespuestaPago();
        try {
            respuesta.setExito(true);
            respuesta.setIdTransaccion("" + ((int) (Math.random() * 1000) + 1));
            respuesta.setError("");
            GregorianCalendar gregory = new GregorianCalendar();
            gregory.setTime(new Date());
            XMLGregorianCalendar calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory);
            respuesta.setFecha(calendar);
        } catch (DatatypeConfigurationException e) {
            respuesta.setFecha(null);
        }
        return respuesta;
    }

}
