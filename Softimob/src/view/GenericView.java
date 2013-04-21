package view;

import helper.WidgetHelper;

import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.part.ViewPart;

public abstract class GenericView extends ViewPart{
	
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	
	private Composite cpBody;
	
	public GenericView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		
		Form frmNewForm = formToolkit.createForm(parent);
		frmNewForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		formToolkit.paintBordersFor(frmNewForm);
		frmNewForm.setText(getName());
		frmNewForm.getBody().setLayout(new GridLayout(1, false));
		
		cpBody = formToolkit.createComposite(frmNewForm.getBody(), SWT.NONE);
		cpBody.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		cpBody.setLayout(new GridLayout(2, false));
		formToolkit.paintBordersFor(cpBody);
		
		WidgetHelper.createTableWithFilter(formToolkit, cpBody, getAttributes());
		
		cpBody.redraw();
	}

	public abstract String getName();
	
	@Override
	public void setFocus() {
		Control[] children = cpBody.getChildren();
		children[1].forceFocus();
	}
	
	public abstract Map<String, String> getAttributes();
	
}
