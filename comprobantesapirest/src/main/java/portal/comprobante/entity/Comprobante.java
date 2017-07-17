package portal.comprobante.entity;

public class Comprobante 
{
	private int id;
	private String rucEmisor;
	private String ruc;
	private String tipoDocumento;
	private String serieCorrelativo;
	private String fechaEmision;
	private Double monto;
	private String xml;
	private String pdf;
	private String estado;
	private String descripcionEstado;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getRucEmisor() {
		return rucEmisor;
	}
	
	public void setRucEmisor(String rucEmisor) {
		this.rucEmisor = rucEmisor;
	}
	
	public String getRuc() {
		return ruc;
	}
	
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	public String getSerieCorrelativo() {
		return serieCorrelativo;
	}
	
	public void setSerieCorrelativo(String serieCorrelativo) {
		this.serieCorrelativo = serieCorrelativo;
	}
	
	public String getFechaEmision() {
		return fechaEmision;
	}
	
	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	
	public Double getMonto() {
		return monto;
	}
	
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	
	public String getXml() {
		return xml;
	}
	
	public void setXml(String xml) {
		this.xml = xml;
	}
	
	public String getPdf() {
		return pdf;
	}
	
	public void setPdf(String pdf) {
		this.pdf = pdf;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getDescripcionEstado() {
		return descripcionEstado;
	}
	
	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
	}	
}
