package helper;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

import de.ralfebert.rcputils.properties.IValueFormatter;

public class FormatterHelper {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static Formatter formatter = new Formatter(Locale.getDefault());
	
	
	public String formatarData(Date data){
		return sdf.format(data);
	}
	
	public static SimpleDateFormat getSimpleDateFormat() {
		return sdf;
	}
	
}
