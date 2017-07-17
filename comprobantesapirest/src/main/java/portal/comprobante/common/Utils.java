package portal.comprobante.common;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils
{	
	public static String getDateLastDayOfMonth(String fecha) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	    Date date = sdf.parse(fecha);

	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    
	    return String.format("%s/%s/%s", calendar.get(Calendar.MONTH) + 1, calendar.getActualMaximum(Calendar.DAY_OF_MONTH), 
	    		calendar.get(Calendar.YEAR));
	}	
	
	/**
	 * @param fecha
	 * @return dd/MM/yyyy
	 * @throws ParseException
	 */
	public static String getFormat1(Date fecha) throws ParseException
	{
		if(fecha == null) return "";
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");		
		return sdf.format(fecha);
	}
	
	/**
	 * @param fecha
	 * @return dd/MM/yyyy hh:mm:ss
	 * @throws ParseException
	 */
	public static String getFormat2(Timestamp fecha) throws ParseException
	{
		if(fecha == null) return "";
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");		
		return sdf.format(fecha);
	}
	
	public static String restarFecha(Timestamp fechaIni, Timestamp fechaFin)
	{
		if(fechaIni == null || fechaFin == null) return "";
		
		long diff = fechaFin.getTime() - fechaIni.getTime();

		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		
		return String.format("%02d:%02d:%02d", diffHours, diffMinutes, diffSeconds);
	}
}