package portal.comprobante.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import portal.comprobante.common.Constantes;
import portal.comprobante.common.CustomMessages;
import portal.comprobante.common.Utils;
import portal.comprobante.entity.Comprobante;
import portal.comprobante.service.interfaces.IComprobanteService;

@Controller
@RequestMapping(Constantes.comprobanteController)
public class ComprobanteController 
{	
	@Autowired
	private IComprobanteService ComprobanteService;
	private static final Log logger = LogFactory.getLog(ComprobanteController.class);
	
	@RequestMapping(value = Constantes.buscarAction, method = RequestMethod.GET)
	public ModelAndView buscar() 
	{
		return new ModelAndView(Constantes.buscarView);
	}
	
	@RequestMapping(value = Constantes.buscarAction, method = RequestMethod.POST)
	public ModelAndView buscar(HttpServletRequest request) 
	{
		ModelAndView model = new ModelAndView();
		model.setViewName(Constantes.buscarView);
		
		Comprobante comprobante = new Comprobante();
		comprobante.setTipoDocumento(request.getParameter("tipoDocumento"));
		comprobante.setRuc(request.getParameter("ruc"));
		comprobante.setSerieCorrelativo(request.getParameter("serieCorrelativo"));		
		comprobante.setFechaEmision(request.getParameter("fechaEmision"));		
		comprobante.setMonto(Double.parseDouble(request.getParameter("monto")));
		
		try 
		{
			Comprobante resp = ComprobanteService.getComprobante(comprobante);
			
		    if(resp != null)
		    {
		    	model.setViewName(Utils.redirectAction(Constantes.resultadoAction));
		    }
		    else
		    {
		    	model.addObject("mensajeError", CustomMessages.comprobanteNoEncontrado);
		    }
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			model.addObject("mensajeError", CustomMessages.haOcurridoUnErrorIntenteloNuevamente);
		}

		return model;
	}
	
	@RequestMapping(value = Constantes.resultadoAction, method = RequestMethod.GET)
	public ModelAndView resultado() 
	{
		return new ModelAndView(Constantes.resultadoView);
	}
}