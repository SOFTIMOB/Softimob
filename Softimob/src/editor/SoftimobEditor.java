package editor;

import helper.EnterHelper;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

public abstract class SoftimobEditor extends EditorPart {

	public SoftimobEditor() {
	}

	@Override
	public void createPartControl(Composite parent) {
		
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		
		Composite cpPrincipal = new Composite(composite, SWT.NONE);
		cpPrincipal.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		cpPrincipal.setLayout(new GridLayout(2, false));
		
		Composite cpOpcoes = new Composite(composite, SWT.NONE);
		cpOpcoes.setLayout(new GridLayout(2, false));
		cpOpcoes.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button btnSalvar = new Button(cpOpcoes, SWT.NONE);
		GridData gd_btnSalvar = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnSalvar.heightHint = 50;
		gd_btnSalvar.widthHint = 70;
		btnSalvar.setLayoutData(gd_btnSalvar);
		btnSalvar.setText("Salvar");
		btnSalvar.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				salvar();
			}

		});
		
		Button btnCancelar = new Button(cpOpcoes, SWT.NONE);
		GridData gd_btnCancelar = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnCancelar.heightHint = 50;
		gd_btnCancelar.widthHint = 70;
		btnCancelar.setLayoutData(gd_btnCancelar);
		btnCancelar.setText("Cancelar");

		EnterHelper.addEnterNextControlToGroupOrComposite(parent);
		
		afterCreatePartControl(cpPrincipal);
	}

	public abstract void afterCreatePartControl(Composite parent);
	
	protected abstract void salvar();

	@Override
	public void setFocus() {
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
	}

	@Override
	public void doSaveAs() {
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		setSite(site);
		setInput(input);
	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}
}
