package editor;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;

public class AddContaPagarReceberEditor extends SoftimobEditor {
	private Text text;
	public AddContaPagarReceberEditor() {
	}

	@Override
	protected void salvar() {
	}

	@Override
	public void afterCreatePartControl(Composite parent) {
		GridLayout gl_parent = new GridLayout(2, false);
		gl_parent.verticalSpacing = 10;
		parent.setLayout(gl_parent);
		
		Label lblDataDaConta = new Label(parent, SWT.NONE);
		lblDataDaConta.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblDataDaConta.setText("Data da Conta");
		
		DateTime dateTime = new DateTime(parent, SWT.BORDER);
		
		Label lblDataDeVencimento = new Label(parent, SWT.NONE);
		lblDataDeVencimento.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblDataDeVencimento.setText("Data de Vencimento");
		
		DateTime dateTime_1 = new DateTime(parent, SWT.BORDER);
		
		Label lblTipo = new Label(parent, SWT.NONE);
		lblTipo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTipo.setText("Tipo");
		
		ComboViewer comboViewer = new ComboViewer(parent, SWT.READ_ONLY);
		Combo combo = comboViewer.getCombo();
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblOrigem = new Label(parent, SWT.NONE);
		lblOrigem.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblOrigem.setText("Origem");
		
		ComboViewer comboViewer_1 = new ComboViewer(parent, SWT.READ_ONLY);
		Combo combo_1 = comboViewer_1.getCombo();
		combo_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblValor = new Label(parent, SWT.NONE);
		lblValor.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblValor.setText("Valor");
		
		text = new Text(parent, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
	}

}
