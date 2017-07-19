package portal.comprobante.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import portal.comprobante.common.Constantes;
import portal.comprobante.common.Utils;

@Controller
@RequestMapping(Constantes.accountController)
public class AccountController 
{	
	private static final Log logger = LogFactory.getLog(AccountController.class);
	
	@RequestMapping(value = Constantes.loginAction, method = RequestMethod.GET)
	public ModelAndView login() 
	{
		return new ModelAndView(Constantes.loginView);
	}
	
	@RequestMapping(value = Constantes.logoutAction, method = RequestMethod.GET)
    public String logout(HttpServletRequest request) 
	{
    	HttpSession session = request.getSession();
    	session.invalidate();
    	
    	return Utils.redirectAction(Constantes.accountController, Constantes.loginAction);
    }
	
	@RequestMapping(value = Constantes.loginAction, method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request) 
	{
		ModelAndView model = new ModelAndView();
		model.setViewName(Constantes.loginView);	
		
		return model;
	}
}