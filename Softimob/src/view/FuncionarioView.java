package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

import de.ralfebert.rcputils.tables.TableViewerBuilder;

public class FuncionarioView extends ViewPart{
	private Text text;
	public FuncionarioView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		
		Composite composite_1 = new Composite(parent, SWT.NONE);
		composite_1.setLayout(new GridLayout(1, false));
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));

		ViewForm viewForm_1 = new ViewForm(parent, SWT.NONE);
		viewForm_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		Composite composite = new Composite(viewForm_1, SWT.NONE);
		viewForm_1.setContent(composite);
		composite.setLayout(new GridLayout(1, false));
		
		text = new Text(composite, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Composite composite_3 = new Composite(composite, SWT.NONE);
		composite_3.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		TableViewerBuilder tvb = new TableViewerBuilder(composite_3);
		
		tvb.createColumn("Nome").bindToProperty("nome").useAsDefaultSortColumn().build();
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}
}
