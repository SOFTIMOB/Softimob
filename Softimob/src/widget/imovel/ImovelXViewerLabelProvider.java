package widget.imovel;

import helper.FormatterHelper;

import java.util.ArrayList;
import java.util.List;

import modelo.Chave;
import modelo.Comodo;
import modelo.HistoricoImovel;
import modelo.Imovel;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.nebula.widgets.xviewer.XViewerColumn;
import org.eclipse.nebula.widgets.xviewer.XViewerLabelProvider;
import org.eclipse.swt.graphics.Image;

public class ImovelXViewerLabelProvider extends XViewerLabelProvider {

	public ImovelXViewerLabelProvider(ImovelXViewer viewer) {
		super(viewer);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String getColumnText(Object element, XViewerColumn xCol, int columnIndex) throws Exception {
		if(element instanceof String)
			return element.toString();
		else if(element instanceof Imovel){
			Imovel imovel = (Imovel) element;
			
			if(xCol.equals(ImovelXViewerFactory.angariador))
				return imovel.getAngariador() == null ? "" : imovel.getAngariador().getNome();
			if(xCol.equals(ImovelXViewerFactory.metragem))
				return imovel.getMetragem().toString();
			if(xCol.equals(ImovelXViewerFactory.codigo))
				return imovel.getCodigo();
			if(xCol.equals(ImovelXViewerFactory.proprietario))
				return imovel.getProprietario() == null ? "" : imovel.getProprietario().getNome();
//			if(xCol.equals(ImovelXViewerFactory.status))
//				return imovel.getStatus().toString();
			if(xCol.equals(ImovelXViewerFactory.tipo))
				return imovel.getTipo() == null ? "" : imovel.getTipo().getDescricao();
		}else if(element instanceof Chave){
			
			if(columnIndex == 0)
				return ((Chave)element).getNumero();
		}else if(element instanceof HistoricoImovel){
			
			if(columnIndex == 0)
				return FormatterHelper.getSimpleDateFormat().format(((HistoricoImovel)element).getData());
			if(columnIndex == 1)
				return ((HistoricoImovel)element).getFuncionario() == null ? "" : ((HistoricoImovel)element).getFuncionario().getNome();
//			if(columnIndex == 2)
//				return ((HistoricoImovel)element).getFeedback();
		}else if(element instanceof Comodo){
			
			if(columnIndex == 0)
				return ((Comodo)element).getTipoComodo().getNome();
			if(columnIndex == 1)
				return ((Comodo)element).getDescricao();
		}else if(element instanceof List){
			
			List<Object> elements = (List<Object>) element;
				
			if(xCol.equals(ImovelXViewerFactory.codigo) && elements.size() > 0){
				if(elements.get(0) instanceof Comodo)
					return "Cômodos";
				if(elements.get(0) instanceof Chave)
					return "Chaves";
				if(elements.get(0) instanceof HistoricoImovel)
					return "Históricos";
			}
			if(xCol.equals(ImovelXViewerFactory.metragem))
				return String.valueOf(elements.size());
		}
		return "";
	}
	
	@Override
	public void addListener(ILabelProviderListener listener) {
	}

	@Override
	public void dispose() {
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
	}

	@Override
	public Image getColumnImage(Object element, XViewerColumn xCol, int columnIndex) throws Exception {
		return null;
	}

}
