package editor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class FecharChamadoReformaEditor extends SoftimobEditor {
	
	public static final String ID = "editor.FecharChamadoReformaEditor"; //$NON-NLS-1$
	
	public FecharChamadoReformaEditor() {
	}
	private Text text;
	private Text text_1;
	private Text text_2;

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
		
		Label lblNmero = new Label(composite, SWT.NONE);
		lblNmero.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNmero.setText("Número");

		text = new Text(composite, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblData = new Label(composite, SWT.NONE);
		lblData.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblData.setText("Data de conclusão");

		text_1 = new Text(composite, SWT.BORDER);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblProblema = new Label(composite, SWT.NONE);
		lblProblema.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblProblema.setText("Conclusão");

		text_2 = new Text(composite, SWT.BORDER);
		GridData gd_text_2 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_text_2.heightHint = 88;
		text_2.setLayoutData(gd_text_2);
		new Label(composite, SWT.NONE);
		
		Button btnReformado = new Button(composite, SWT.CHECK);
		btnReformado.setText("Reformado");

		super.createPartControl(parent);
	}

	@Override
	protected void salvar() {
		// TODO Auto-generated method stub
		
	}

}