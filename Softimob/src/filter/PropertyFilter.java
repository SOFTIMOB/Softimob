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

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		try {
			return ReflectionHelper.compare(element, atributos, searchText);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
