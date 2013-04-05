package editor;

import helper.ListElementDialogHelper;
import modelo.Cliente;
import modelo.Imovel;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.ralfebert.rcputils.tables.TableViewerBuilder;

public class ImovelEditor extends SoftimobEditor{
	
	public static final String ID = "editor.ImovelEditor"; //$NON-NLS-1$
	
	private WritableValue value = WritableValue.withValueType(Imovel.class);
	
	private Text txtProprietario;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text;
	
	public ImovelEditor() {
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout gl_composite = new GridLayout(3, false);
		gl_composite.verticalSpacing = 10;
		composite.setLayout(gl_composite);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		Label lblProprietario = new Label(composite, SWT.NONE);
		lblProprietario.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblProprietario.setText("Proprietário");
		
		txtProprietario = new Text(composite, SWT.BORDER);
		txtProprietario.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtProprietario.setEditable(false);
		new Label(composite, SWT.NONE);
		ListElementDialogHelper.addListElementDialogToText(txtProprietario, value , "proprietario");
		
		Label lblTipoImvel = new Label(composite, SWT.NONE);
		lblTipoImvel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTipoImvel.setText("Tipo Imóvel");
		
		text = new Text(composite, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		
		Label lblRua = new Label(composite, SWT.NONE);
		lblRua.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblRua.setText("Endereço");
		
		text_2 = new Text(composite, SWT.BORDER);
		text_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		
		Label lblCep = new Label(composite, SWT.NONE);
		lblCep.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblCep.setText("CEP");
		
		text_3 = new Text(composite, SWT.BORDER);
		text_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		
		Label lblValor = new Label(composite, SWT.NONE);
		lblValor.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblValor.setText("Valor");
		
		text_4 = new Text(composite, SWT.BORDER);
		text_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		
		Label lblMetragem = new Label(composite, SWT.NONE);
		lblMetragem.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblMetragem.setText("Metragem");
		
		text_5 = new Text(composite, SWT.BORDER);
		text_5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		
		Label lblAngariador = new Label(composite, SWT.NONE);
		lblAngariador.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblAngariador.setText("Angariador");
		
		text_6 = new Text(composite, SWT.BORDER);
		text_6.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		
		Label lblComdos = new Label(composite, SWT.NONE);
		lblComdos.setText("Comôdos");
		
		Composite cpComodos = new Composite(composite, SWT.NONE);
		cpComodos.setLayout(new GridLayout(1, false));
		cpComodos.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
		
		TableViewerBuilder tvb = new TableViewerBuilder(cpComodos);
		tvb.createColumn("Nome").bindToProperty("nome").build();
		tvb.createColumn("Descrição").bindToProperty("descricao").makeEditable().build();
		
		Composite cpBotoes = new Composite(composite, SWT.NONE);
		cpBotoes.setLayout(new GridLayout(1, false));
		cpBotoes.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		
		Button btnAdicionar = new Button(cpBotoes, SWT.NONE);
		GridData gd_btnAdicionar = new GridData(SWT.LEFT, SWT.BOTTOM, false, true, 1, 1);
		btnAdicionar.setLayoutData(gd_btnAdicionar);
		btnAdicionar.setText("Adicionar");
		
		Button btnRemover = new Button(cpBotoes, SWT.NONE);
		btnRemover.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, true, 1, 1));
		btnRemover.setText("Remover");

		value.setValue(new Imovel());
		
		initDataBindings();

		super.createPartControl(parent);
	}
	
	@Override
	protected void salvar() {
	}
	
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeTextText_1ObserveWidget = WidgetProperties.text(SWT.NONE).observe(txtProprietario);
		IObservableValue valueAngariadorObserveDetailValue = PojoProperties.value(Imovel.class, "proprietario.nome", Cliente.class).observeDetail(value);
		bindingContext.bindValue(observeTextText_1ObserveWidget, valueAngariadorObserveDetailValue, null, null);
		//
		return bindingContext;
	}
}
