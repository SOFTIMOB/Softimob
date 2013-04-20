package editor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class AberturaChamadoReformaEditor extends SoftimobEditor{
	
	public static final String ID = "editor.AberturaChamadoReformaEditor"; //$NON-NLS-1$
	
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	public AberturaChamadoReformaEditor() {
	}


	@Override
	protected void salvar() {
	}


	@Override
	public void afterCreatePartControl(Composite parent) {
		GridLayout gl_composite = new GridLayout(2, false);
		parent.setLayout(gl_composite);
		parent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		Label lblNmero = new Label(parent, SWT.NONE);
		lblNmero.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNmero.setText("Número");
		
		text_3 = new Text(parent, SWT.BORDER);
		text_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblImvel = new Label(parent, SWT.NONE);
		lblImvel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblImvel.setText("Imóvel");
		
		text = new Text(parent, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblData = new Label(parent, SWT.NONE);
		lblData.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblData.setText("Data de solicitação");
		
		text_1 = new Text(parent, SWT.BORDER);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblProblema = new Label(parent, SWT.NONE);
		lblProblema.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblProblema.setText("Problema");
		
		text_2 = new Text(parent, SWT.BORDER);
		GridData gd_text_2 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_text_2.heightHint = 74;
		text_2.setLayoutData(gd_text_2);
	}
}
