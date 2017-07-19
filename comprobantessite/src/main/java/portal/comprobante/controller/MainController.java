package portal.comprobante.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import portal.comprobante.common.Constantes;
import portal.comprobante.common.Utils;

@Controller
@RequestMapping(Constantes.mainController)
public class MainController 
{	
	@RequestMapping(value = Constantes.mainAction, method = RequestMethod.GET)
	public ModelAndView index(HttpSession sesion) 
	{
		return new ModelAndView(Utils.redirectAction(Constantes.accountController, Constantes.logoutAction));
	}
}