package view;

import helper.ImageHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.IEditorInput;

import editor.ComodoEditor;
import editorInput.ComodoEditorInput;

public class TipoComodoView extends GenericView{

	public static final String ID = "view.TipoComodoView"; 
	
	private Map<String,String> atributos;
	private IEditorInput comodoEditorInput;
	
	public TipoComodoView() {
		atributos = new HashMap<String, String>();
		atributos.put("Nome", "Nome");
		
		comodoEditorInput = new ComodoEditorInput();
	}
	
	@Override
	public String getName() {
		return "Consulta de Cômodos";
	}

	@Override
	public Map<String, String> getAttributes() {
		return atributos;
	}

	@Override
	protected IEditorInput getIEditorInput() {
		return comodoEditorInput;
	}

	@Override
	protected String getEditorId() {
		return ComodoEditor.ID;
	}

	@Override
	protected Image getImage() {
		return ImageHelper.HOUSE_32;
	}

	@Override
	protected Menu getMenu(Table tb) {
		Menu mn = new Menu(tb);
		
		MenuItem mi = new MenuItem(mn, SWT.NONE);
		mi.setText("AHAUSDHSA");
		
		return mn;
	}

	@Override
	protected <T> List<T> getInput() {
		return null;
	}
	
}
