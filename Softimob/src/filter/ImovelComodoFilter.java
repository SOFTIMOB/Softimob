package filter;

import java.util.Map;

import modelo.Comodo;
import modelo.Imovel;
import modelo.TipoComodo;

import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.ui.dialogs.FilteredList.FilterMatcher;

public class ImovelComodoFilter extends ViewerFilter implements FilterMatcher{


	public ImovelComodoFilter(Map<String, TipoComodo> comodos) {
		this.comodos = comodos;
	}

	private final Map<String, TipoComodo> comodos;
	private String searchString;
	private String selection;
	
	public void setSelection(String selection){
		this.selection = selection;
	}
	
	public void setSearchString(String searchString){
		this.searchString = ".*" + searchString + ".*";
	}
	
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		Imovel imovel = (Imovel) element;
		
		for(Comodo comodo : imovel.getComodos()){
			if(comodo.getTipoComodo().equals(comodos.get(selection))){
				if(comodo.getDescricao().matches(searchString))
					return true;
			}
		}
		
		return false;
	}

}
