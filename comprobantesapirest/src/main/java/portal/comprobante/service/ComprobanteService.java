package portal.comprobante.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import portal.comprobante.dao.interfaces.IComprobanteRepository;
import portal.comprobante.entity.Comprobante;
import portal.comprobante.service.interfaces.IComprobanteService;

@Service
public class ComprobanteService implements IComprobanteService 
{
	@Autowired
	private IComprobanteRepository comprobanteRepo;
	
	public void registrarComprobante(Comprobante comprobante) throws Exception 
	{
		comprobanteRepo.registrarComprobante(comprobante);
	}

	public void actualizarEstado(Comprobante comprobante) throws Exception
	{
		comprobanteRepo.actualizarEstado(comprobante);
	}
}