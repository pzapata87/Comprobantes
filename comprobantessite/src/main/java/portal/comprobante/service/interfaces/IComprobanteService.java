package portal.comprobante.service.interfaces;

import portal.comprobante.entity.Comprobante;

public interface IComprobanteService
{
	void registrarComprobante(Comprobante comprobante) throws Exception;
	void actualizarEstado(Comprobante comprobante) throws Exception;
	Comprobante getComprobante(Comprobante comprobante) throws Exception;
}