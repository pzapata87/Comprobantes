package portal.comprobante.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	
	public Comprobante getComprobante(Comprobante comprobante) throws Exception 
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Comprobante entity = null;
		
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement("CALL GetComprobante (?,?,?,?,?)");
			ps.setString(1, comprobante.getRuc());
			ps.setString(2, comprobante.getTipoDocumento());
			ps.setString(3, comprobante.getSerieCorrelativo());
			ps.setString(4, comprobante.getFechaEmision());
			ps.setDouble(5, comprobante.getMonto());

			rs = ps.executeQuery();
			
			if(rs.next())
			{
				entity = new Comprobante();
				entity.setRucEmisor(rs.getString("RucEmisor"));
				entity.setRuc(rs.getString("Ruc"));
				entity.setSerieCorrelativo(rs.getString("SerieCorrelativo"));
				entity.setFechaEmision(rs.getString("FechaEmision"));
				entity.setMonto(rs.getDouble("Monto"));
				entity.setPdf(rs.getString("Pdf"));
				entity.setXml(rs.getString("Xml"));
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			throw ex;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		
		return entity;
	}
}