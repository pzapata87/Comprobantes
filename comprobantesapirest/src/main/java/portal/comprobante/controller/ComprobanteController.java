package portal.comprobante.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import portal.comprobante.common.Constantes;
import portal.comprobante.common.JsonResult;
import portal.comprobante.common.TipoRespuestaEnum;
import portal.comprobante.dto.ComprobanteDto;
import portal.comprobante.entity.Comprobante;
import portal.comprobante.service.interfaces.IComprobanteService;

@RestController
@RequestMapping(Constantes.comprobanteController)
public class ComprobanteController
{	
	@Autowired
	private IComprobanteService ComprobanteService;
	private static final Log logger = LogFactory.getLog(ComprobanteController.class);
	
	@RequestMapping(value= "/registrar", method={ RequestMethod.POST})
	public @ResponseBody JsonResult registrar(@RequestBody ComprobanteDto comprobanteDto) 
	{
		JsonResult jsonResult = new JsonResult();
		
		try
		{
			Comprobante comprobanteDomain = new Comprobante();
			comprobanteDomain.setRuc(comprobanteDto.getRuc());
			comprobanteDomain.setRucEmisor(comprobanteDto.getRucEmisor());
			comprobanteDomain.setTipoDocumento(comprobanteDto.getTipoDocumento());
			comprobanteDomain.setSerieCorrelativo(comprobanteDto.getSerieCorrelativo());
			comprobanteDomain.setFechaEmision(comprobanteDto.getFechaEmision());
			comprobanteDomain.setMonto(comprobanteDto.getMonto());
			comprobanteDomain.setXml(comprobanteDto.getXml());
			comprobanteDomain.setPdf(comprobanteDto.getPdf());
			
			ComprobanteService.registrarComprobante(comprobanteDomain);
			jsonResult.setCodigo(TipoRespuestaEnum.Ok.GetValue());
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			jsonResult.setCodigo(TipoRespuestaEnum.Error.GetValue());
			jsonResult.setDescripcion(ex.getMessage());
		}
		
		return jsonResult;		
	}
	
	@RequestMapping(value= "/actualizar", method={ RequestMethod.POST})
	public @ResponseBody JsonResult actualizar(@RequestBody ComprobanteDto comprobanteDto) 
	{
		JsonResult jsonResult = new JsonResult();
		
		try
		{
			Comprobante comprobanteDomain = new Comprobante();
			comprobanteDomain.setRuc(comprobanteDto.getRuc());
			comprobanteDomain.setRucEmisor(comprobanteDto.getRucEmisor());
			comprobanteDomain.setTipoDocumento(comprobanteDto.getTipoDocumento());
			comprobanteDomain.setSerieCorrelativo(comprobanteDto.getSerieCorrelativo());
			comprobanteDomain.setFechaEmision(comprobanteDto.getFechaEmision());
			comprobanteDomain.setMonto(comprobanteDto.getMonto());
			comprobanteDomain.setXml(comprobanteDto.getXml());
			comprobanteDomain.setPdf(comprobanteDto.getPdf());
			
			ComprobanteService.actualizarEstado(comprobanteDomain);
			jsonResult.setCodigo(TipoRespuestaEnum.Ok.GetValue());
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			jsonResult.setCodigo(TipoRespuestaEnum.Error.GetValue());
			jsonResult.setDescripcion(ex.getMessage());
		}
		
		return jsonResult;		
	}
}