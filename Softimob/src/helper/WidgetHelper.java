package helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;

import de.ralfebert.rcputils.tables.TableViewerBuilder;
import filter.PropertyFilter;

public class WidgetHelper {

	public static TableViewerBuilder createTableWithFilter(FormToolkit form, Composite composite, Map<String, String> atributos){
		List<String> atributosList = new ArrayList<String>();
		
		Label lblFiltro = form.createLabel(composite, "Filtro", SWT.NONE);
		lblFiltro.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		final Text txtBusca = new Text(composite, SWT.BORDER);
		txtBusca.setToolTipText("");
		GridData gd_txtBusca = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_txtBusca.widthHint = 334;
		txtBusca.setLayoutData(gd_txtBusca);
		
		Composite cpTable = new Composite(composite, SWT.NONE);
		cpTable.setLayout(new GridLayout(1, false));
		cpTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		
		final TableViewerBuilder tvb = new TableViewerBuilder(cpTable);
		for(String key: atributos.keySet()){
			String atributo = atributos.get(key);
			atributosList.add(atributo);
			
			tvb.createColumn(key).bindToProperty(atributo).build();
		}
		
		final PropertyFilter filter = new PropertyFilter(atributosList);
		tvb.getTableViewer().addFilter(filter);
		
		txtBusca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				filter.setSearchText(txtBusca.getText());
				tvb.getTableViewer().refresh();
			}
		});
		
		return tvb;
	}

}
