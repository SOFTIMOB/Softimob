package filter;

import helper.ReflectionHelper;

import org.eclipse.jface.viewers.Viewer;

public class PropertyFilter extends GenericFilter{

	private String[] atributos;
	private String searchText;
	
	public PropertyFilter(String... atributos) {
		this.atributos = atributos;
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if(searchText == null || searchText.isEmpty())
			return true;
		
		try {
			return ReflectionHelper.compare(element, atributos, searchText.toLowerCase());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
