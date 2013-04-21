package filter;

import helper.ReflectionHelper;

import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

public class PropertyFilter extends ViewerFilter{

	private List<String> atributos;
	private String searchText;
	
	public PropertyFilter(String... atributos) {
		this.atributos = Arrays.asList(atributos);
	}

	public PropertyFilter(List<String> atributos) {
		this.atributos = atributos;
	}

	public void setSearchText(String searchText) {
		this.searchText = ".*" + searchText + ".*";
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
