package mx.gob.ivrea.cajero.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mx.gob.ivrea.api.constants.IvreaCajeroViewConstants;
import mx.gob.ivrea.api.constants.IvreaConstants;
import mx.gob.ivrea.api.constants.MensajeConstants;
import mx.gob.ivrea.api.constants.ParametrosConstants;
import mx.gob.ivrea.api.enums.EstatusOperacion;
import mx.gob.ivrea.api.enums.TipoOperacion;
import mx.gob.ivrea.api.model.Modelo;
import mx.gob.ivrea.api.model.MovimientoTarjeta;
import mx.gob.ivrea.api.model.Saldo;
import mx.gob.ivrea.api.security.CustomAuthenticationToken;
import mx.gob.ivrea.api.security.Usuario;
import mx.gob.ivrea.base.BaseController;
import mx.gob.ivrea.base.BaseRespuestaService;
import mx.gob.ivrea.cajero.interfaces.MovimientoTarjetaRemote;
import mx.gob.ivrea.cajero.interfaces.SaldoRemote;
import mx.gob.ivrea.cajero.validador.ValidadorCampos;
import mx.gob.ivrea.constants.ConstantsUtils;
import mx.gob.ivrea.paginacion.Celda;
import mx.gob.ivrea.paginacion.ConstantsPagination;
import mx.gob.ivrea.paginacion.Fila;
import mx.gob.ivrea.paginacion.Filtro;
import mx.gob.ivrea.paginacion.TablaPaginado;
import mx.gob.ivrea.paginacion.TipoCelda;
import mx.gob.ivrea.utils.CadenaHelper;

@Controller
@Scope(ConstantsUtils.REQUEST_SCOPE_CONTROLLERS)
@RequestMapping(value = IvreaConstants.RAIZ_MENU)
public class MenuController extends BaseController {

    private ModelAndView model = new ModelAndView();

    @Autowired
    private SaldoRemote saldoBusiness;

    @Autowired
    private MovimientoTarjetaRemote movimientoTarjetaBusiness;

    @Autowired
    private CadenaHelper cadenaHelper;

    @Autowired
    private ValidadorCampos validadorCampos;

    @RequestMapping(value = {IvreaCajeroViewConstants.RAIZ,IvreaCajeroViewConstants.SIN_SLASH}, method = RequestMethod.GET)
    public ModelAndView entrarMenu(HttpSession session, Model model) {

        logger.info("Entrando a menu");
        CustomAuthenticationToken auth=(CustomAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
        Usuario user = (Usuario)auth.getPrincipal();
        model.addAttribute(ParametrosConstants.NOMBRE_USUARIO,user.getNombre());
        this.model.setViewName(ParametrosConstants.VISTA_MENU);
        return this.model;
    }

    @RequestMapping(value = IvreaCajeroViewConstants.VISTA_CONSULTAR_SALDO, method = RequestMethod.GET)
    public ModelAndView consultarSaldo(HttpSession session, Model model) {

        logger.info("Consultando saldo");
        CustomAuthenticationToken auth=(CustomAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
        Usuario user = (Usuario)auth.getPrincipal();

        Modelo modelo = new Modelo();
        modelo.setCampo1(user.getUsername());
        BaseRespuestaService<Saldo, EstatusOperacion> respuesta = saldoBusiness.consultarSaldo(modelo);

        Saldo saldo = respuesta.getObjeto();
        EstatusOperacion estatus = respuesta.getEstatus();
        switch (estatus) {
            case EXITOSO:
                model.addAttribute(ParametrosConstants.FECHA, new Date());
                model.addAttribute(ParametrosConstants.CUENTA, saldo.getCuenta());
                model.addAttribute(ParametrosConstants.TARJETA, saldo.getTarjeta());
                model.addAttribute(ParametrosConstants.SALDO, saldo.getSaldo());
                this.model.setViewName(ParametrosConstants.VISTA_CONSULTAR_SALDO);
                return this.model;
            default:
                return errorVistaDefault(model);
        }
    }

    @RequestMapping(value = IvreaCajeroViewConstants.VISTA_RETIRAR_SALDO, method = RequestMethod.GET)
    public ModelAndView retirarSaldo(HttpSession session, Model model) {

        logger.info("Retirando saldo");
        Modelo modelo = new Modelo();
        CustomAuthenticationToken auth=(CustomAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
        Usuario user = (Usuario)auth.getPrincipal();
        modelo.setCampo1(user.getUsername());
        BaseRespuestaService<Saldo, EstatusOperacion> respuesta = saldoBusiness.consultarSaldo(modelo);

        Saldo saldo = respuesta.getObjeto();
        EstatusOperacion estatus = respuesta.getEstatus();

        switch (estatus) {
            case EXITOSO:
                model.addAttribute(ParametrosConstants.SALDO, saldo.getSaldo());
                this.model.setViewName(ParametrosConstants.VISTA_RETIRAR_SALDO);
                return this.model;
            default:
                return errorVistaDefault(model);
        }       
    }

    @RequestMapping(value = IvreaCajeroViewConstants.VISTA_DEPOSITAR_SALDO, method = RequestMethod.GET)
    public ModelAndView depositarSaldo(HttpSession session, Model model) {

        logger.info("Depositando saldo");
        Modelo modelo = new Modelo();
        CustomAuthenticationToken auth=(CustomAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
        Usuario user = (Usuario)auth.getPrincipal();
        modelo.setCampo1(user.getUsername());
        BaseRespuestaService<Saldo, EstatusOperacion> respuesta = saldoBusiness.consultarSaldo(modelo);

        Saldo saldo = respuesta.getObjeto();
        EstatusOperacion estatus = respuesta.getEstatus();

        switch (estatus) {
            case EXITOSO:
                model.addAttribute(ParametrosConstants.TIPO_OPERACION, TipoOperacion.DEPOSITO.getValor());
                model.addAttribute(ParametrosConstants.SALDO, saldo.getSaldo());
                model.addAttribute(ParametrosConstants.CUENTA, saldo.getCuenta());
        
                this.model.setViewName(ParametrosConstants.VISTA_DEPOSITAR_SALDO);
                return this.model;
            default:
                return errorVistaDefault(model);
        }              
    }

    @RequestMapping(value = IvreaCajeroViewConstants.VISTA_TRANSFERENCIA, method = RequestMethod.GET)
    public ModelAndView transferencia(HttpSession session, Model model) {

        logger.info("Transferencia bancaria");
        Modelo modelo = new Modelo();
        CustomAuthenticationToken auth=(CustomAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
        Usuario user = (Usuario)auth.getPrincipal();
        modelo.setCampo1(user.getUsername());
        BaseRespuestaService<Saldo, EstatusOperacion> respuesta = saldoBusiness.consultarSaldo(modelo);

        Saldo saldo = respuesta.getObjeto();
        EstatusOperacion estatus = respuesta.getEstatus();

        switch (estatus) {
            case EXITOSO:
                model.addAttribute(ParametrosConstants.SALDO, saldo.getSaldo());
                model.addAttribute(ParametrosConstants.CUENTA, saldo.getCuenta());
                model.addAttribute(ParametrosConstants.TIPO_OPERACION, TipoOperacion.TRANSFERENCIA.getValor());
                this.model.setViewName(ParametrosConstants.VISTA_TRANSFERENCIA);
                return this.model;
            default:
                return errorVistaDefault(model);
        }              

    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = IvreaCajeroViewConstants.VISTA_CONSULTAR_MOVIMIENTOS, method = RequestMethod.GET)
    public ModelAndView consultarMovimientos(HttpSession session, Model model) {

        logger.info("Consultar movimientos");
        this.model.setViewName(ParametrosConstants.VISTA_CONSULTA_MOVIMIENTOS);

        Modelo modelo = new Modelo();
        CustomAuthenticationToken auth=(CustomAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
        Usuario user = (Usuario)auth.getPrincipal();
        modelo.setCampo1(user.getUsername());
        modelo.setCampo2("1");
        BaseRespuestaService<Filtro, EstatusOperacion> respuesta = movimientoTarjetaBusiness.obtenerMovimientos(modelo);

        List<MovimientoTarjeta> movimientos = (List<MovimientoTarjeta>) respuesta.getObjeto().getDatos();
        EstatusOperacion estatus = respuesta.getEstatus();

        switch (estatus) {
            case EXITOSO:
                model.addAttribute(ParametrosConstants.MOVIMIENTOS, movimientos);
                respuesta.getObjeto().getTotalPaginas();
                logger.info("Total Paginas {}",respuesta.getObjeto().getTotalPaginas());
                model.addAttribute(ParametrosConstants.TOTAL_PAGINAS,2);
                model.addAttribute(ParametrosConstants.TAMANIO_PAGINA, movimientos.size());
                return this.model;
            default:
                return errorVistaDefault(model);
        }           
    }

    @RequestMapping(value = IvreaCajeroViewConstants.VISTA_PAGO_SERVICIOS, method = RequestMethod.GET)
    public ModelAndView pagarServicios(HttpSession session, Model model) {

        logger.info("Pago de Servicios");
        this.model.setViewName(ParametrosConstants.VISTA_PAGAR_SERVICIOS);
        List<String> servicios = new ArrayList<String>();
        servicios.add("Luz");
        servicios.add("Telefono");
        servicios.add("Internet");
        model.addAttribute(ParametrosConstants.SERVICIOS, servicios);
        return this.model;
    }

    @RequestMapping(value = IvreaCajeroViewConstants.VISTA_COMPRA_TIEMPO, method = RequestMethod.GET)
    public ModelAndView comprarTiempoAire(HttpSession session, Model model) {

        logger.info("Comprar Tiempo Aire");
        this.model.setViewName(ParametrosConstants.VISTA_COMPRAR_TIEMPO_AIRE);
        List<String> proveedores = new ArrayList<String>();
        proveedores.add("Telcel");
        proveedores.add("Movistar");
        proveedores.add("UNEFON");
        model.addAttribute(ParametrosConstants.PROVEEDORES, proveedores);
        return this.model;
    }

    @RequestMapping(value = { IvreaCajeroViewConstants.ACCION_CONSULTA_SALDO,
            IvreaCajeroViewConstants.ACCION_RETIRAR_SALDO, IvreaCajeroViewConstants.ACCION_DEPOSITAR_SALDO,
            IvreaCajeroViewConstants.ACCION_CONSULTA_MOVIMIENTOS, IvreaCajeroViewConstants.ACCION_PAGAR_SERVICIOS,
            IvreaCajeroViewConstants.ACCION_COMPRAR_TIEMPO }, params = { "btnRegresar" })
    public String regresarMenu(Model model) {

        return new StringBuilder(IvreaConstants.TOKEN_REDIRECT).append(IvreaCajeroViewConstants.RAIZ)
                .append(IvreaCajeroViewConstants.VISTA_MENU).toString();
    }

    @RequestMapping(value = IvreaCajeroViewConstants.ACCION_DEPOSITAR_SALDO, method = RequestMethod.POST, params = {
            ParametrosConstants.SUBMIT_DEPOSITAR_SALDO })
    public String depositarSaldoAccion(HttpServletRequest request, HttpSession session, Model model,
            RedirectAttributes redir) {

        logger.info("Accion Depositar Saldo");
        CustomAuthenticationToken auth=(CustomAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
        Usuario user = (Usuario)auth.getPrincipal();
        
        EstatusOperacion estatus = EstatusOperacion.NO_EXITOSO;
        Saldo saldo = null;

        String campoSaldoDepositar=null;
        String campoSaldoDisponible=null;

        if(validadorCampos.validarDatosDepositar(request)){

            campoSaldoDepositar = request.getParameter(ParametrosConstants.CAMPO_CANTIDAD);
            campoSaldoDisponible = request.getParameter(ParametrosConstants.CAMPO_SALDO);
    
            double saldoDepositar = Double.parseDouble(campoSaldoDepositar);
            double saldoDisponible = Double.parseDouble(campoSaldoDisponible);
    
            Modelo modelo = new Modelo();
            modelo.setCampo1(user.getUsername());
            modelo.setCampo2(campoSaldoDepositar);
            modelo.setCampo3(String.valueOf(saldoDepositar + saldoDisponible));

            BaseRespuestaService<Saldo, EstatusOperacion> respuesta = saldoBusiness.depositarSaldo(modelo);
            saldo = respuesta.getObjeto();
            estatus = respuesta.getEstatus();
        }
        /*
         * Saldo saldo = new Saldo();
         * saldo.setCuenta("1234567");
         * saldo.setSaldo(1000D);
         * EstatusOperacion estatus = EstatusOperacion.EXITOSO;
         */
        switch (estatus) {
            case EXITOSO:
                String args = cadenaHelper.unirSubcadenas(campoSaldoDepositar, saldo.getCuenta(),String.valueOf(saldo.getSaldo()));
                redir.addFlashAttribute(ParametrosConstants.MENSAJE, MensajeConstants.DEPOSITO_SALDO_EXITOSO);
                redir.addFlashAttribute(ParametrosConstants.ARGUMENTOS, args);
                redir.addFlashAttribute(ParametrosConstants.HAY_BOTON_IMP, true);
                return new StringBuilder(IvreaConstants.TOKEN_REDIRECT)
                        .append(IvreaCajeroViewConstants.VISTA_MENSAJE_EXITO).toString();
            case NO_EXITOSO:
                redir.addFlashAttribute(ParametrosConstants.HAY_ERROR, true);
                return new StringBuilder(IvreaConstants.TOKEN_REDIRECT)
                        .append(IvreaCajeroViewConstants.VISTA_DEPOSITAR_SALDO).toString();
            default:
                redir.addFlashAttribute(ParametrosConstants.MENSAJE, MensajeConstants.DEPOSITO_SALDO_ERROR);
                return new StringBuilder(IvreaConstants.TOKEN_REDIRECT)
                    .append(IvreaCajeroViewConstants.VISTA_MENSAJE_ERROR).toString();
        }
    }

    @RequestMapping(value = IvreaCajeroViewConstants.ACCION_RETIRAR_SALDO, method = RequestMethod.POST, params = {
            ParametrosConstants.SUBMIT_RETIRAR_SALDO })
    public String retirarSaldoAccion(HttpServletRequest request, HttpSession session, Model model,
            RedirectAttributes redir) {

        logger.info("Accion Retirar Saldo");
        CustomAuthenticationToken auth=(CustomAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
        Usuario user = (Usuario)auth.getPrincipal();
        
        EstatusOperacion estatus = EstatusOperacion.NO_EXITOSO;
        Saldo saldo = null;

        String campoSaldoRetirar=null;
        String campoSaldoDisponible=null;

        if(validadorCampos.validarDatosRetiro(request)){
           
            campoSaldoRetirar = request.getParameter(ParametrosConstants.CAMPO_CANTIDAD);
            campoSaldoDisponible = request.getParameter(ParametrosConstants.CAMPO_SALDO);

            double saldoRetirar = Double.parseDouble(campoSaldoRetirar);
            double saldoDisponible = Double.parseDouble(campoSaldoDisponible);
            
            Modelo modelo = new Modelo();
            modelo.setCampo1(user.getUsername());
            modelo.setCampo2(campoSaldoRetirar);
            modelo.setCampo3(String.valueOf(saldoDisponible-saldoRetirar));

            BaseRespuestaService<Saldo, EstatusOperacion> respuesta = saldoBusiness.retirarSaldo(modelo);
            saldo = respuesta.getObjeto();
            estatus = respuesta.getEstatus();
        }
          /*Saldo saldo = new Saldo();
          saldo.setCuenta("1234567");
          saldo.setSaldo(1000D);
          EstatusOperacion estatus = EstatusOperacion.EXITOSO;
          */
        switch (estatus) {
            case EXITOSO:
                String args = cadenaHelper.unirSubcadenas(campoSaldoRetirar, saldo.getCuenta(), String.valueOf(saldo.getSaldo()));
                redir.addFlashAttribute(ParametrosConstants.MENSAJE, MensajeConstants.RETIRO_SALDO_EXITOSO);
                redir.addFlashAttribute(ParametrosConstants.ARGUMENTOS, args);
                redir.addFlashAttribute(ParametrosConstants.HAY_BOTON_IMP, true);
                return new StringBuilder(IvreaConstants.TOKEN_REDIRECT)
                        .append(IvreaCajeroViewConstants.VISTA_MENSAJE_EXITO).toString();
            case NO_EXITOSO:
                redir.addFlashAttribute(ParametrosConstants.HAY_ERROR, true);
                return new StringBuilder(IvreaConstants.TOKEN_REDIRECT)
                        .append(IvreaCajeroViewConstants.VISTA_RETIRAR_SALDO).toString();
            default:
                //Error
                redir.addFlashAttribute(ParametrosConstants.MENSAJE, MensajeConstants.RETIRO_SALDO_ERROR);
                return new StringBuilder(IvreaConstants.TOKEN_REDIRECT)
                    .append(IvreaCajeroViewConstants.VISTA_MENSAJE_ERROR).toString();
        }
    }

    @RequestMapping(value = IvreaCajeroViewConstants.ACCION_DEPOSITAR_SALDO, method = RequestMethod.POST, params = {
            ParametrosConstants.SUBMIT_TRANSFERENCIA_SALDO })
    public String transferenciaSaldoAccion(HttpServletRequest request, HttpSession session, Model model,
            RedirectAttributes redir) {
         logger.info("Accion Transferir Saldo a otra cuenta");
         
        CustomAuthenticationToken auth=(CustomAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
        Usuario user = (Usuario)auth.getPrincipal();

        String campoSaldoDepositar =null;
        String campoSaldoDisponible = null;
        String campoOtraCuenta = null;
        Saldo saldo = null;
        EstatusOperacion estatus = EstatusOperacion.NO_EXITOSO;

        if(validadorCampos.validarDatosDepositar(request)){
            campoSaldoDepositar = request.getParameter(ParametrosConstants.CAMPO_CANTIDAD);
            campoSaldoDisponible = request.getParameter(ParametrosConstants.CAMPO_SALDO);
            campoOtraCuenta = request.getParameter(ParametrosConstants.CAMPO_OTRA_CUENTA);

            Modelo modelo = new Modelo();
            modelo.setCampo1(user.getUsername());
            modelo.setCampo2(campoSaldoDepositar);
            modelo.setCampo3(campoSaldoDisponible);
            modelo.setCampo4(campoOtraCuenta);

            BaseRespuestaService<Saldo, EstatusOperacion> respuesta = saldoBusiness.transferirSaldo(modelo);
            saldo = respuesta.getObjeto();
            estatus = respuesta.getEstatus();

        }

        switch (estatus) {
            case EXITOSO:
                String args = cadenaHelper.unirSubcadenas(campoSaldoDepositar, saldo.getCuenta(),String.valueOf(saldo.getSaldo()));
                redir.addFlashAttribute(ParametrosConstants.MENSAJE, MensajeConstants.DEPOSITO_SALDO_EXITOSO);
                redir.addFlashAttribute(ParametrosConstants.ARGUMENTOS, args);
                redir.addFlashAttribute(ParametrosConstants.HAY_BOTON_IMP, true);
                return new StringBuilder(IvreaConstants.TOKEN_REDIRECT)
                        .append(IvreaCajeroViewConstants.VISTA_MENSAJE_EXITO).toString();
            case ERROR:
                redir.addFlashAttribute(ParametrosConstants.MENSAJE, MensajeConstants.DEPOSITO_SALDO_ERROR);
                return new StringBuilder(IvreaConstants.TOKEN_REDIRECT)
                        .append(IvreaCajeroViewConstants.VISTA_MENSAJE_ERROR).toString();
            case NO_EXITOSO:
                redir.addFlashAttribute(ParametrosConstants.HAY_ERROR, true);
                return new StringBuilder(IvreaConstants.TOKEN_REDIRECT)
                        .append(IvreaCajeroViewConstants.VISTA_TRANSFERENCIA).toString();
            default:
        }
        return null;
    }

    @RequestMapping(value = IvreaCajeroViewConstants.VISTA_MENSAJE_EXITO)
    public ModelAndView mensajeExito(Model model) {

        model.addAttribute(ParametrosConstants.TIPO_MENSAJE, "success");
        model.addAttribute(ParametrosConstants.NOMBRE_BOTON, "Menu");
        model.addAttribute(ParametrosConstants.ACCION, IvreaCajeroViewConstants.VISTA_MENU);
        this.model.setViewName(ParametrosConstants.VISTA_MENSAJE);
        return this.model;
    }

    @RequestMapping(value = IvreaCajeroViewConstants.VISTA_MENSAJE_ERROR)
    public ModelAndView mensajeError(Model model) {

        model.addAttribute(ParametrosConstants.TIPO_MENSAJE, "danger");
        model.addAttribute(ParametrosConstants.NOMBRE_BOTON, "Menu");
        model.addAttribute(ParametrosConstants.ACCION, IvreaCajeroViewConstants.VISTA_MENU);
        this.model.setViewName(ParametrosConstants.VISTA_MENSAJE);
        return this.model;
    }

    @RequestMapping(value = IvreaCajeroViewConstants.VISTA_MENSAJE_INFO)
    public ModelAndView mensajeInfo(Model model) {

        model.addAttribute(ParametrosConstants.TIPO_MENSAJE, "info");
        model.addAttribute(ParametrosConstants.NOMBRE_BOTON, "Menu");
        model.addAttribute(ParametrosConstants.ACCION, IvreaCajeroViewConstants.VISTA_MENU);
        this.model.setViewName(ParametrosConstants.VISTA_MENSAJE);
        return this.model;
    }

    private ModelAndView errorVistaDefault(Model model){
        model.addAttribute(ParametrosConstants.TIPO_MENSAJE, "danger");
        model.addAttribute(ParametrosConstants.NOMBRE_BOTON, "Menu");
        model.addAttribute(ParametrosConstants.MENSAJE,MensajeConstants.VISTA_NO_DISPONIBLE);
        model.addAttribute(ParametrosConstants.ACCION, IvreaCajeroViewConstants.VISTA_MENU);
        this.model.setViewName(ParametrosConstants.VISTA_MENSAJE);
        return this.model;
    }
    
    @RequestMapping(value="movimiento",method=RequestMethod.POST)
    @ResponseBody
    public String consultarMovimientoPagina(@RequestParam(value = "pag", required = true) String pag) {
    	
    	TablaPaginado tabla = new TablaPaginado();
    	logger.info("Se recibe parametro de paginacion {}",pag);
    	
    	 Modelo modelo = new Modelo();
         CustomAuthenticationToken auth=(CustomAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
         Usuario user = (Usuario)auth.getPrincipal();
         modelo.setCampo1(user.getUsername());
         modelo.setCampo2(pag);
         BaseRespuestaService<Filtro, EstatusOperacion> respuesta = movimientoTarjetaBusiness.obtenerMovimientos(modelo);

         List<MovimientoTarjeta> movimientos = (List<MovimientoTarjeta>) respuesta.getObjeto().getDatos();
         EstatusOperacion estatus = respuesta.getEstatus();

         switch (estatus) {
             case EXITOSO:
            	 
                List<Fila> filas = new ArrayList<Fila>();	 
                for(MovimientoTarjeta mov: movimientos) {
                	Fila fila = new Fila();
                	List<Celda> celdas = new ArrayList<Celda>();
                	
                	Celda celda1 = new Celda(mov.getFecha(),TipoCelda.TEXTO);
                	Celda celda2 = new Celda(mov.getConcepto(),TipoCelda.TEXTO);
                	Celda celda3 = new Celda(mov.getCantidad(),TipoCelda.TEXTO);
                	
                	celdas.add(celda1);
                	celdas.add(celda2);
                	celdas.add(celda3);
                	
                	fila.setCeldas(celdas);
                	filas.add(fila);
                }
                tabla.setFilas(filas);
                
                int numPag = Integer.parseInt(pag);
                
                tabla.setTotal(movimientos.size());
                tabla.setNumInicio(ConstantsPagination.DEFAULT_TAM_PAGINA*(numPag-1)+1);
                tabla.setNumFinal(ConstantsPagination.DEFAULT_TAM_PAGINA*numPag);
                return tabla.construirTabla();
             default:
            	 return null;
                 
         }           
    }
    
    @ExceptionHandler(Exception.class)
    public ModelAndView sendError(Exception exc) {
    	logger.error("************** ERROR **************",exc);
    	return null;
    }
    
}
