package portal.comprobante.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import portal.comprobante.dao.interfaces.IComprobanteRepository;
import portal.comprobante.entity.Comprobante;

@Repository
public class ComprobanteRepository implements IComprobanteRepository 
{
	@Autowired
	private DataSource dataSource;

	public void registrarComprobante(Comprobante comprobante) throws Exception 
	{
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement("CALL RegistrarComprobante (?,?,?,?,?,?,?,?)");
			ps.setString(1, comprobante.getRucEmisor());
			ps.setString(2, comprobante.getRuc());
			ps.setString(3, comprobante.getTipoDocumento());
			ps.setString(4, comprobante.getSerieCorrelativo());
			ps.setString(5, comprobante.getFechaEmision());
			ps.setDouble(6, comprobante.getMonto());
			ps.setString(7, comprobante.getXml());
			ps.setString(8, comprobante.getPdf());

			ps.executeUpdate();
			
			ps.close();
		} catch (Exception ex) {
			throw ex;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public void actualizarEstado(Comprobante comprobante) throws Exception 
	{
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement("CALL ActualizarEstado (?,?,?,?,?,?)");
			ps.setString(1, comprobante.getRucEmisor());
			ps.setString(2, comprobante.getRuc());
			ps.setString(3, comprobante.getTipoDocumento());
			ps.setString(4, comprobante.getSerieCorrelativo());
			ps.setString(5, comprobante.getEstado());
			ps.setString(6, comprobante.getDescripcionEstado());

			ps.executeUpdate();
			
			ps.close();
		} catch (Exception ex) {
			throw ex;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}	
}