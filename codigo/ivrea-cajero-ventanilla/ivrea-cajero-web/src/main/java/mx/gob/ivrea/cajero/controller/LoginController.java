package mx.gob.ivrea.cajero.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mx.gob.ivrea.api.constants.IvreaCajeroViewConstants;
import mx.gob.ivrea.api.constants.IvreaConstants;
import mx.gob.ivrea.api.constants.ParametrosConstants;
import mx.gob.ivrea.api.model.Cliente;
import mx.gob.ivrea.api.model.Modelo;
import mx.gob.ivrea.base.BaseController;
import mx.gob.ivrea.cajero.interfaces.ClienteRemote;
import mx.gob.ivrea.constants.ConstantsUtils;

@Controller
@Scope(ConstantsUtils.REQUEST_SCOPE_CONTROLLERS)
public class LoginController extends BaseController {

    private ModelAndView model = new ModelAndView();

    @Autowired
    ClienteRemote clienteBusiness;

    @RequestMapping(value = IvreaCajeroViewConstants.VISTA_LOGIN, method = RequestMethod.GET)
    public ModelAndView entrarLogin(HttpSession session, Model model) {

        logger.info("Entrando a Login");
        this.model.setViewName(ParametrosConstants.VISTA_LOGIN);
        return this.model;
    }

    @RequestMapping(value = IvreaCajeroViewConstants.ACCION_INGRESAR, method = RequestMethod.POST)
    public String ingresar(HttpSession session, HttpServletRequest request, Model model) {

        logger.info("Ingresando al sistema");
        String numTarjeta = request.getParameter(ParametrosConstants.CAMPO_TARJETA);
        String nip = request.getParameter(ParametrosConstants.CAMPO_NIP);

        Modelo modelo = new Modelo();
        modelo.setCampo1(numTarjeta
        modelo.setCampo2(nip);
        Cliente cliente = clienteBusiness.obtenerCliente(modelo);
        if (cliente != null) {
            this.logger.info("Existe el cliente");
            session.setAttribute(ParametrosConstants.NOMBRE_CLIENTE, cliente.getNombre());
            session.setAttribute(ParametrosConstants.TARJETA, numTarjeta);

        } else {
            this.logger.info("No existe el cliente");
        }
        return new StringBuilder(IvreaConstants.TOKEN_REDIRECT).append(IvreaCajeroViewConstants.VISTA_MENU).toString();

    }

}
