package editor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import view.TipoComodoView;

import editorInput.GenericEditorInput;

public class ClienteEditor extends SoftimobEditor {
	
	public static final String ID = "editor.ClienteEditor"; //$NON-NLS-1$
	
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_5;
	private Text text_7;
	private Text text_4;
	private Text text_6;
	private Text text_8;
	private Text text_9;
	private Text text_10;
	public ClienteEditor() {
	}

	@Override
	public void afterCreatePartControl(Composite parent) {
		parent.setLayout(new GridLayout(2, false));
		parent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
		
		Label lblNome = new Label(parent, SWT.NONE);
		lblNome.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNome.setText("Nome");
		
		text = new Text(parent, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblEndereo = new Label(parent, SWT.NONE);
		lblEndereo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblEndereo.setText("CPF");
		
		text_1 = new Text(parent, SWT.BORDER);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblCep = new Label(parent, SWT.NONE);
		lblCep.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblCep.setText("RG");
		
		text_2 = new Text(parent, SWT.BORDER);
		text_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblRg = new Label(parent, SWT.NONE);
		lblRg.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblRg.setText("Filiação");
		
		text_3 = new Text(parent, SWT.BORDER);
		text_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblCpf = new Label(parent, SWT.NONE);
		lblCpf.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblCpf.setText("Estado Civil");
		
		ComboViewer comboViewer = new ComboViewer(parent, SWT.READ_ONLY);
		Combo combo = comboViewer.getCombo();
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblNacionalidade = new Label(parent, SWT.NONE);
		lblNacionalidade.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNacionalidade.setText("Nacionalidade");
		
		text_5 = new Text(parent, SWT.BORDER);
		text_5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblTelefone_1 = new Label(parent, SWT.NONE);
		lblTelefone_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTelefone_1.setText("Telefone");
		
		text_4 = new Text(parent, SWT.BORDER);
		text_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblCelular = new Label(parent, SWT.NONE);
		lblCelular.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblCelular.setText("Celular");
		
		text_6 = new Text(parent, SWT.BORDER);
		text_6.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblEmail = new Label(parent, SWT.NONE);
		lblEmail.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblEmail.setText("E-mail");
		
		text_7 = new Text(parent, SWT.BORDER);
		text_7.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Group grpEndereo = new Group(parent, SWT.NONE);
		grpEndereo.setText("Endereço");
		grpEndereo.setLayout(new GridLayout(2, false));
		grpEndereo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		
		Label lblCep_1 = new Label(grpEndereo, SWT.NONE);
		lblCep_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblCep_1.setText("CEP");
		
		text_8 = new Text(grpEndereo, SWT.BORDER);
		text_8.setText("");
		text_8.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblUf = new Label(grpEndereo, SWT.NONE);
		lblUf.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblUf.setText("UF");
		
		ComboViewer comboViewer_1 = new ComboViewer(grpEndereo, SWT.NONE);
		Combo combo_1 = comboViewer_1.getCombo();
		combo_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblCidade = new Label(grpEndereo, SWT.NONE);
		lblCidade.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblCidade.setText("Cidade");
		
		ComboViewer comboViewer_2 = new ComboViewer(grpEndereo, SWT.NONE);
		Combo combo_2 = comboViewer_2.getCombo();
		combo_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblBairro = new Label(grpEndereo, SWT.NONE);
		lblBairro.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblBairro.setText("Bairro");
		
		ComboViewer comboViewer_3 = new ComboViewer(grpEndereo, SWT.NONE);
		Combo combo_3 = comboViewer_3.getCombo();
		combo_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblRua = new Label(grpEndereo, SWT.NONE);
		lblRua.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblRua.setText("Rua");
		
		ComboViewer comboViewer_4 = new ComboViewer(grpEndereo, SWT.NONE);
		Combo combo_4 = comboViewer_4.getCombo();
		combo_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblNmero = new Label(grpEndereo, SWT.NONE);
		lblNmero.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNmero.setText("Número");
		
		text_9 = new Text(grpEndereo, SWT.BORDER);
		text_9.setText("");
		text_9.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblComplemento = new Label(grpEndereo, SWT.NONE);
		lblComplemento.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblComplemento.setText("Complemento");
		
		text_10 = new Text(grpEndereo, SWT.BORDER);
		text_10.setText("");
		text_10.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	}

	@Override
	protected void salvar() {
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(TipoComodoView.ID);
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}

}
