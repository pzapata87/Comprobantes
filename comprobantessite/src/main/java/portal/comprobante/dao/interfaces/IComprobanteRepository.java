package portal.comprobante.dao.interfaces;

import portal.comprobante.entity.Comprobante;

public interface IComprobanteRepository 
{
	void registrarComprobante(Comprobante comprobante) throws Exception;
	void actualizarEstado(Comprobante comprobante) throws Exception;
	Comprobante getComprobante(Comprobante comprobante) throws Exception;
}