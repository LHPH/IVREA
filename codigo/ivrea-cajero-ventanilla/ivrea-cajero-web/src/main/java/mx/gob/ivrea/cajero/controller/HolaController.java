package mx.gob.ivrea.cajero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mx.gob.ivrea.base.BaseController;
import mx.gob.ivrea.cajero.interfaces.HolaRemote;

@Controller
public class HolaController extends BaseController {

    @Autowired
    HolaRemote holaRemote;  

    @RequestMapping(value = "/hello")
    public ModelAndView hello(Model model) {

        logger.info("************** ***********  Entrando a Hola");
        String mensaje = holaRemote.hola();
        model.addAttribute("mensaje", mensaje);
        return new ModelAndView("hello");

    }

}
