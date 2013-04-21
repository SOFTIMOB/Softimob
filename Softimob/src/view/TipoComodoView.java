package view;

import java.util.HashMap;
import java.util.Map;

public class TipoComodoView extends GenericView{

	public static final String ID = "view.TipoComodoView"; 
	
	private Map<String,String> atributos;

	public TipoComodoView() {
		atributos = new HashMap<String, String>();
		atributos.put("Nome", "Nome");
	}
	
	@Override
	public String getName() {
		return "Consulta de Cômodos";
	}

	@Override
	public Map<String, String> getAttributes() {
		return atributos;
	}
	
}
