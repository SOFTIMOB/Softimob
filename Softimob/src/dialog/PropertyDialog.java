package dialog;

import java.util.HashMap;
import java.util.Map;

import modelo.TipoComodo;
import modelo.TipoImovel;
import modelo.TipoImovelTipoComodo;

import org.apache.commons.lang.StringUtils;
import org.docx4j.samples.Filter;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import filter.ImovelComodoFilter;

public class PropertyDialog extends ElementListSelectionDialog{

	private Text txtFilter;
	private final TipoImovel tipoImovel;
	private Map<String, String> filtros;
	private Map<String, TipoComodo> comodos;
	private ImovelComodoFilter filter;
	
	public PropertyDialog(Shell parent, ILabelProvider renderer, TipoImovel tipoImovel) {
		super(parent, renderer);
		this.tipoImovel = tipoImovel;
		this.filtros = new HashMap<String, String>();
		this.comodos = new HashMap<String, TipoComodo>();
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite contents = (Composite) super.createDialogArea(parent);
		super.fFilteredList.setFilterMatcher(filter);

		return contents;
	}
	
	@Override
	protected Text createFilterText(Composite parent) {
		createOptions(parent);
		txtFilter = super.createFilterText(parent);
		return txtFilter;
	}
	
	private Control createOptions(Composite parent) {
		Composite cp = new Composite(parent, SWT.FILL);
		cp.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		cp.setLayout(new GridLayout(2, false));
		Group group = new Group(cp, SWT.NONE);
		group.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		group.setLayout(new RowLayout(SWT.HORIZONTAL));

		for(TipoImovelTipoComodo comodo : tipoImovel.getTipoComodos()){
			final Button btn= new Button(group, SWT.RADIO);
			
			String nome = comodo.getTipoComodo().getNome();
			
			btn.setText(nome);
			filtros.put(nome, StringUtils.EMPTY);
			comodos.put(nome, comodo.getTipoComodo());
			
			btn.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					String text = filtros.get(btn.getText());
					txtFilter.setText(text);
					
					if(filter != null){
						filter.setSelection(btn.getText());
						//FIXME o de baixo acho que nem precisa xD
//						filter.setSearchString(text);
					}
				}
			});
		}
		
		this.filter = new ImovelComodoFilter(comodos);
		
		return super.createContents(parent);
	}
	
}
