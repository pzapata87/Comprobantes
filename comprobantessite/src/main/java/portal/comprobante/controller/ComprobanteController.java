package portal.comprobante.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import portal.comprobante.common.Constantes;

@Controller
@RequestMapping(Constantes.comprobanteController)
public class ComprobanteController 
{	
	private static final Log logger = LogFactory.getLog(ComprobanteController.class);
	
	@RequestMapping(value = Constantes.buscarAction, method = RequestMethod.GET)
	public ModelAndView buscar() 
	{
		return new ModelAndView(Constantes.buscarView);
	}
}