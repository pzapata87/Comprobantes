package portal.comprobante.common;

public enum TipoRespuestaEnum
{
	Ok (1),
	Error (0);
	
	private int tipoRespuesta;
	
	TipoRespuestaEnum(int tipoRespuesta)
    {
    	this.tipoRespuesta = tipoRespuesta;
    }
    
    public int GetValue()
    {
      return tipoRespuesta;
    }
}
