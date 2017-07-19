package portal.comprobante.common;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class Utils
{	
	public static void crearCarpeta(String path)
	{
		File dir = new File(path);
		if (!dir.exists())
			dir.mkdir();
	}
	
	public static void eliminarArchivo(String path)
	{
		File file = new File(path);
		file.delete();
	}
	
	public static String getDateLastDayOfMonth(String fecha) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	    Date date = sdf.parse(fecha);

	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    
	    return String.format("%s/%s/%s", calendar.get(Calendar.MONTH) + 1, calendar.getActualMaximum(Calendar.DAY_OF_MONTH), 
	    		calendar.get(Calendar.YEAR));
	}
	
	public static Date convertStringToDate(String fecha) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	    Date date = sdf.parse(fecha);

	    return date;
	}
	
	public static Date addDaysToDate(Date fecha, int numDias)
	{
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(fecha);
	    calendar.add(Calendar.DATE, numDias);
	    
	    return calendar.getTime();
	}
	
	public static String redirectAction(String controller, String nameAction)
	{
		return String.format("redirect:/%s%s", controller, nameAction);
	}
	
	public static String redirectAction(String nameAction)
	{
		return String.format("redirect:/%s", nameAction);
	}
	
	public static String urlBaseServicio()
	{
		ResourceBundle bundle = ResourceBundle.getBundle("aplicacion");
		return bundle.getString("aplicacion.urlBaseServicio");
	}
}