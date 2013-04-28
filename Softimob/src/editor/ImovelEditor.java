package editor;

import helper.ListElementDialogHelper;
import modelo.Chave;
import modelo.Cliente;
import modelo.HistoricoImovel;
import modelo.Imovel;
import modelo.Proposta;
import modelo.Vistoria;

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
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import modelo.Funcionario;
import org.eclipse.swt.widgets.List;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import modelo.TipoImovel;
import java.math.BigDecimal;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.jface.layout.TreeColumnLayout;

public class ImovelEditor extends SoftimobEditor{
	
	public static final String ID = "editor.ImovelEditor"; //$NON-NLS-1$
	
	private WritableValue value = WritableValue.withValueType(Imovel.class);
	private WritableValue valueProposta = WritableValue.withValueType(Proposta.class);
	private WritableValue valueHistorico = WritableValue.withValueType(HistoricoImovel.class);
	private WritableValue valueVistoria = WritableValue.withValueType(Vistoria.class);
	private WritableValue valueChave = WritableValue.withValueType(Chave.class);
	
	private Text txtProprietario;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_1;
	private Text text_7;
	private Text text_8;
	private Text text_11;
	private Text text_12;
	private Text text_13;
	private Text text_14;
	private Text text_15;
	private Text text_16;
	private Text text_17;
	private Text text_18;
	private Text text_19;
	private Text text_20;
	private Text text_9;
	private Text text_10;
	private Text text_21;
	private Text text_6;
	private ComboViewer comboViewer_4;
	private Button btnVenda;
	private Button btnAluguel;
	private ComboViewer comboViewer_3;

	private TableViewerBuilder tvbChave;

	private TableViewerBuilder tvbHistorico;

	private TableViewerBuilder tvbVistoria;

	private TableViewerBuilder tvbProposta;

	private TableViewerBuilder tvbComodo;
	
	public ImovelEditor() {
	}

	@Override
	public void afterCreatePartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		
		CTabFolder tabFolder = new CTabFolder(parent, SWT.BORDER);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		CTabItem tbtmDescrio_1 = new CTabItem(tabFolder, SWT.NONE);
		tbtmDescrio_1.setText("Descrição");
		
		Composite composite = new Composite(tabFolder, SWT.NONE);
		tbtmDescrio_1.setControl(composite);
		GridLayout gl_composite = new GridLayout(4, false);
		gl_composite.verticalSpacing = 10;
		composite.setLayout(gl_composite);
		
		Label lblCdigo = new Label(composite, SWT.NONE);
		lblCdigo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblCdigo.setText("Código");
		
		text_21 = new Text(composite, SWT.BORDER);
		GridData gd_text_21 = new GridData(SWT.LEFT, SWT.CENTER, true, false, 2, 1);
		gd_text_21.widthHint = 101;
		text_21.setLayoutData(gd_text_21);
		new Label(composite, SWT.NONE);
		
		Label lblProprietario = new Label(composite, SWT.NONE);
		lblProprietario.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblProprietario.setText("Proprietário");
		
		txtProprietario = new Text(composite, SWT.BORDER);
		txtProprietario.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		ListElementDialogHelper.addListElementDialogToText(txtProprietario, value , "proprietario");
		
		Button btnSelecionar_3 = new Button(composite, SWT.NONE);
		btnSelecionar_3.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		btnSelecionar_3.setText("Selecionar");
		
		Label lblAngariad = new Label(composite, SWT.NONE);
		lblAngariad.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblAngariad.setText("Angariador");
		
		text_2 = new Text(composite, SWT.BORDER);
		text_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Button button_6 = new Button(composite, SWT.NONE);
		button_6.setText("Selecionar");
		
		Label lblTipoImvel = new Label(composite, SWT.NONE);
		lblTipoImvel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTipoImvel.setText("Tipo Imóvel");
		
		comboViewer_4 = new ComboViewer(composite, SWT.READ_ONLY);
		Combo combo_4 = comboViewer_4.getCombo();
		combo_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		new Label(composite, SWT.NONE);
		
		Label lblMetragem = new Label(composite, SWT.NONE);
		lblMetragem.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblMetragem.setText("Metragem");
		
		text_5 = new Text(composite, SWT.BORDER);
		text_5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		new Label(composite, SWT.NONE);
		
		Label lblValor = new Label(composite, SWT.NONE);
		lblValor.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblValor.setText("Valor");
		
		text_4 = new Text(composite, SWT.BORDER);
		text_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		new Label(composite, SWT.NONE);
		
		Label lblFotos = new Label(composite, SWT.NONE);
		lblFotos.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblFotos.setText("Fotos");
		
		text_3 = new Text(composite, SWT.BORDER);
		text_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Button button_7 = new Button(composite, SWT.NONE);
		button_7.setText("Selecionar");
		
		Label lblObservaes_3 = new Label(composite, SWT.NONE);
		lblObservaes_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblObservaes_3.setText("Observações");
		
		text_6 = new Text(composite, SWT.BORDER);
		GridData gd_text_6 = new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1);
		gd_text_6.heightHint = 43;
		text_6.setLayoutData(gd_text_6);
		new Label(composite, SWT.NONE);
		
		btnVenda = new Button(composite, SWT.CHECK);
		btnVenda.setText("Venda");
		
		btnAluguel = new Button(composite, SWT.CHECK);
		btnAluguel.setText("Aluguel");
		new Label(composite, SWT.NONE);
		
		Group grpCmodos = new Group(composite, SWT.NONE);
		grpCmodos.setLayout(new GridLayout(2, false));
		grpCmodos.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 4, 1));
		grpCmodos.setText("Cômodos");
		
		Composite composite_10 = new Composite(grpCmodos, SWT.NONE);
		composite_10.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 2));
		
		criarTabelaComodo(composite_10);

		Button btnAdicionar = new Button(grpCmodos, SWT.NONE);
		btnAdicionar.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, false, true, 1, 1));
		btnAdicionar.setText("Adicionar");
		
		Button btnRemover = new Button(grpCmodos, SWT.NONE);
		btnRemover.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, true, 1, 1));
		btnRemover.setText("Remover");
		
		CTabItem tbtmEndereo = new CTabItem(tabFolder, SWT.NONE);
		tbtmEndereo.setText("Endereço");
		
		Composite composite_1 = new Composite(tabFolder, SWT.NONE);
		tbtmEndereo.setControl(composite_1);
		GridLayout gl_composite_1 = new GridLayout(3, false);
		gl_composite_1.verticalSpacing = 10;
		composite_1.setLayout(gl_composite_1);
		
		Label lblCep_1 = new Label(composite_1, SWT.NONE);
		lblCep_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblCep_1.setText("CEP");
		
		text_1 = new Text(composite_1, SWT.BORDER);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label label = new Label(composite_1, SWT.NONE);
		label.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Label lblUf = new Label(composite_1, SWT.NONE);
		lblUf.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblUf.setText("UF");
		
		ComboViewer comboViewer = new ComboViewer(composite_1, SWT.READ_ONLY);
		Combo combo = comboViewer.getCombo();
		new Label(composite_1, SWT.NONE);
		
		Label lblCidade = new Label(composite_1, SWT.NONE);
		lblCidade.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblCidade.setText("Cidade");
		
		ComboViewer comboViewer_1 = new ComboViewer(composite_1, SWT.READ_ONLY);
		Combo combo_1 = comboViewer_1.getCombo();
		combo_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite_1, SWT.NONE);
		
		Label lblBairro = new Label(composite_1, SWT.NONE);
		lblBairro.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblBairro.setText("Bairro");
		
		ComboViewer comboViewer_2 = new ComboViewer(composite_1, SWT.READ_ONLY);
		Combo combo_2 = comboViewer_2.getCombo();
		combo_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite_1, SWT.NONE);
		
		Label lblRua_1 = new Label(composite_1, SWT.NONE);
		lblRua_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblRua_1.setText("Rua");
		
		comboViewer_3 = new ComboViewer(composite_1, SWT.READ_ONLY);
		Combo combo_3 = comboViewer_3.getCombo();
		combo_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite_1, SWT.NONE);
		
		Label lblNmero = new Label(composite_1, SWT.NONE);
		lblNmero.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNmero.setText("Número");
		
		text_7 = new Text(composite_1, SWT.BORDER);
		GridData gd_text_7 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_text_7.widthHint = 98;
		text_7.setLayoutData(gd_text_7);
		new Label(composite_1, SWT.NONE);
		
		Label lblComplemento = new Label(composite_1, SWT.NONE);
		lblComplemento.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblComplemento.setText("Complemento");
		
		text_8 = new Text(composite_1, SWT.BORDER);
		text_8.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite_1, SWT.NONE);
		
		CTabItem tbtmChaves = new CTabItem(tabFolder, SWT.NONE);
		tbtmChaves.setText("Chaves");
		
		Composite composite_2 = new Composite(tabFolder, SWT.NONE);
		tbtmChaves.setControl(composite_2);
		composite_2.setLayout(new GridLayout(2, false));
		
		Composite cpTvbChave = new Composite(composite_2, SWT.NONE);
		cpTvbChave.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2));
		
		criarTabelaChave(cpTvbChave);
		
		Button btnNovo = new Button(composite_2, SWT.NONE);
		btnNovo.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, false, true, 1, 1));
		btnNovo.setText("Novo");
		
		Button btnRemover_3 = new Button(composite_2, SWT.NONE);
		btnRemover_3.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, true, 1, 1));
		btnRemover_3.setText("Remover");
		
		Group grpChave = new Group(composite_2, SWT.NONE);
		grpChave.setText("Chave");
		grpChave.setLayout(new GridLayout(3, false));
		grpChave.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Label lblNmero_1 = new Label(grpChave, SWT.NONE);
		lblNmero_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNmero_1.setText("Número");
		
		text_15 = new Text(grpChave, SWT.BORDER);
		text_15.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		new Label(grpChave, SWT.NONE);
		
		Button btnImobiliria = new Button(grpChave, SWT.RADIO);
		btnImobiliria.setText("Imobiliária");
		
		Button btnCliente = new Button(grpChave, SWT.RADIO);
		btnCliente.setText("Cliente");
		new Label(grpChave, SWT.NONE);
		new Label(grpChave, SWT.NONE);
		
		Button btnSalvar_2 = new Button(grpChave, SWT.NONE);
		GridData gd_btnSalvar_2 = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
		gd_btnSalvar_2.widthHint = 73;
		btnSalvar_2.setLayoutData(gd_btnSalvar_2);
		btnSalvar_2.setText("Salvar");
		
		CTabItem tbtmHistricos = new CTabItem(tabFolder, SWT.NONE);
		tbtmHistricos.setText("Históricos");
		
		Composite composite_3 = new Composite(tabFolder, SWT.NONE);
		tbtmHistricos.setControl(composite_3);
		composite_3.setLayout(new GridLayout(2, false));
		
		Composite cpTvbHistorico = new Composite(composite_3, SWT.NONE);
		cpTvbHistorico.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2));
		cpTvbHistorico.setLayout(new GridLayout(1, false));
		
		criarTabelaHistorico(cpTvbHistorico);
		
		Button btnAdicionarHistórico = new Button(composite_3, SWT.NONE);
		btnAdicionarHistórico.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, false, true, 1, 1));
		btnAdicionarHistórico.setText("Novo");
		
		Button btnRemover_1 = new Button(composite_3, SWT.NONE);
		btnRemover_1.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, true, 1, 1));
		btnRemover_1.setText("Remover");
		
		Group grpNovoHistrico = new Group(composite_3, SWT.NONE);
		GridLayout gl_grpNovoHistrico = new GridLayout(3, false);
		gl_grpNovoHistrico.verticalSpacing = 10;
		grpNovoHistrico.setLayout(gl_grpNovoHistrico);
		grpNovoHistrico.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		grpNovoHistrico.setText("Histórico");
		
		Label lblData_1 = new Label(grpNovoHistrico, SWT.NONE);
		lblData_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblData_1.setText("Data");
		
		DateTime dateTime_1 = new DateTime(grpNovoHistrico, SWT.BORDER);
		dateTime_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		new Label(grpNovoHistrico, SWT.NONE);
		
		Label lblFuncionrio_1 = new Label(grpNovoHistrico, SWT.NONE);
		lblFuncionrio_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblFuncionrio_1.setText("Funcionário");
		
		text_12 = new Text(grpNovoHistrico, SWT.BORDER);
		text_12.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button btnSelecionar_2 = new Button(grpNovoHistrico, SWT.NONE);
		btnSelecionar_2.setText("Selecionar");
		
		Label lblClienteHistorico = new Label(grpNovoHistrico, SWT.NONE);
		lblClienteHistorico.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblClienteHistorico.setText("Cliente");
		
		text_14 = new Text(grpNovoHistrico, SWT.BORDER);
		text_14.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button button_4 = new Button(grpNovoHistrico, SWT.NONE);
		button_4.setText("Selecionar");
		
		Label lblObservaes = new Label(grpNovoHistrico, SWT.NONE);
		lblObservaes.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		lblObservaes.setText("Observações");
		
		text_13 = new Text(grpNovoHistrico, SWT.BORDER);
		GridData gd_text_13 = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
		gd_text_13.heightHint = 51;
		text_13.setLayoutData(gd_text_13);
		new Label(grpNovoHistrico, SWT.NONE);
		new Label(grpNovoHistrico, SWT.NONE);
		
		Button btnSalvar = new Button(grpNovoHistrico, SWT.NONE);
		GridData gd_btnSalvar = new GridData(SWT.RIGHT, SWT.BOTTOM, true, false, 1, 1);
		gd_btnSalvar.widthHint = 75;
		btnSalvar.setLayoutData(gd_btnSalvar);
		btnSalvar.setText("Salvar");
		
		CTabItem tbtmPropostas = new CTabItem(tabFolder, SWT.NONE);
		tbtmPropostas.setText("Propostas");
		
		Composite composite_4 = new Composite(tabFolder, SWT.NONE);
		tbtmPropostas.setControl(composite_4);
		composite_4.setLayout(new GridLayout(2, false));
		
		Composite cpTvbProposta = new Composite(composite_4, SWT.NONE);
		cpTvbProposta.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2));
		
		criarTabelaProposta(cpTvbProposta);
		
		Button btnNovo_1 = new Button(composite_4, SWT.NONE);
		btnNovo_1.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, false, true, 1, 1));
		btnNovo_1.setText("Novo");
		
		Button btnRemover_2 = new Button(composite_4, SWT.NONE);
		btnRemover_2.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, true, 1, 1));
		btnRemover_2.setText("Remover");
		
		Group grpProposta = new Group(composite_4, SWT.NONE);
		grpProposta.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		grpProposta.setText("Proposta");
		GridLayout gl_grpProposta = new GridLayout(3, false);
		gl_grpProposta.verticalSpacing = 10;
		grpProposta.setLayout(gl_grpProposta);
		
		Label lblData = new Label(grpProposta, SWT.NONE);
		lblData.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblData.setText("Data");
		
		DateTime dateTime = new DateTime(grpProposta, SWT.BORDER);
		dateTime.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		new Label(grpProposta, SWT.NONE);
		
		Label lblValor_1 = new Label(grpProposta, SWT.NONE);
		lblValor_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblValor_1.setText("Valor");
		
		text_10 = new Text(grpProposta, SWT.BORDER);
		text_10.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(grpProposta, SWT.NONE);
		
		Label lblCliente = new Label(grpProposta, SWT.NONE);
		lblCliente.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblCliente.setText("Cliente");
		
		text_9 = new Text(grpProposta, SWT.BORDER);
		text_9.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button btnSelecionar_1 = new Button(grpProposta, SWT.NONE);
		btnSelecionar_1.setText("Selecionar");
		
		Label lblFuncionrio = new Label(grpProposta, SWT.NONE);
		lblFuncionrio.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblFuncionrio.setText("Funcionário");
		
		text_11 = new Text(grpProposta, SWT.BORDER);
		text_11.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Button button_2 = new Button(grpProposta, SWT.NONE);
		button_2.setText("Selecionar");
		
		Label lblObservaes_2 = new Label(grpProposta, SWT.NONE);
		lblObservaes_2.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		lblObservaes_2.setText("Observações");
		
		text_20 = new Text(grpProposta, SWT.BORDER);
		GridData gd_text_20 = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
		gd_text_20.heightHint = 49;
		text_20.setLayoutData(gd_text_20);
		new Label(grpProposta, SWT.NONE);
		new Label(grpProposta, SWT.NONE);
		
		Button button_3 = new Button(grpProposta, SWT.NONE);
		GridData gd_button_3 = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
		gd_button_3.widthHint = 69;
		button_3.setLayoutData(gd_button_3);
		button_3.setText("Salvar");
		
		CTabItem tbtmVistoria = new CTabItem(tabFolder, SWT.NONE);
		tbtmVistoria.setText("Vistorias");
		
		Composite composite_8 = new Composite(tabFolder, SWT.NONE);
		tbtmVistoria.setControl(composite_8);
		composite_8.setLayout(new GridLayout(2, false));
		
		Composite cpVistoria = new Composite(composite_8, SWT.NONE);
		cpVistoria.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 2));
		
		criarTabelaVistoria(cpVistoria);
		
		Button btnNovaVistoria = new Button(composite_8, SWT.NONE);
		btnNovaVistoria.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, false, true, 1, 1));
		btnNovaVistoria.setText("Novo");
		
		Button btnRemover_4 = new Button(composite_8, SWT.NONE);
		btnRemover_4.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, true, 1, 1));
		btnRemover_4.setText("Remover");
		
		Group grpVistoria = new Group(composite_8, SWT.NONE);
		GridLayout gl_grpVistoria = new GridLayout(3, false);
		gl_grpVistoria.verticalSpacing = 10;
		grpVistoria.setLayout(gl_grpVistoria);
		grpVistoria.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1));
		grpVistoria.setText("Vistoria");
		
		Label lblData_2 = new Label(grpVistoria, SWT.NONE);
		lblData_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblData_2.setText("Data");
		
		DateTime dateTime_2 = new DateTime(grpVistoria, SWT.BORDER);
		new Label(grpVistoria, SWT.NONE);
		
		Label lblFuncion = new Label(grpVistoria, SWT.NONE);
		lblFuncion.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblFuncion.setText("Funcionário");
		
		text_16 = new Text(grpVistoria, SWT.BORDER);
		text_16.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button btnSelecionar = new Button(grpVistoria, SWT.NONE);
		btnSelecionar.setText("Selecionar");
		
		Label lblInquilino = new Label(grpVistoria, SWT.NONE);
		lblInquilino.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblInquilino.setText("Inquilino");
		
		text_17 = new Text(grpVistoria, SWT.BORDER);
		text_17.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button button = new Button(grpVistoria, SWT.NONE);
		button.setText("Selecionar");
		
		Label lblArquivo = new Label(grpVistoria, SWT.NONE);
		lblArquivo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblArquivo.setText("Arquivo");
		
		text_18 = new Text(grpVistoria, SWT.BORDER);
		text_18.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button button_1 = new Button(grpVistoria, SWT.NONE);
		button_1.setText("Selecionar");
		
		Label lblObservaes_1 = new Label(grpVistoria, SWT.NONE);
		lblObservaes_1.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		lblObservaes_1.setText("Observações");
		
		text_19 = new Text(grpVistoria, SWT.BORDER);
		GridData gd_text_19 = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
		gd_text_19.heightHint = 54;
		text_19.setLayoutData(gd_text_19);
		new Label(grpVistoria, SWT.NONE);
		new Label(grpVistoria, SWT.NONE);
		
		Button btnSalvar_3 = new Button(grpVistoria, SWT.NONE);
		GridData gd_btnSalvar_3 = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
		gd_btnSalvar_3.widthHint = 79;
		btnSalvar_3.setLayoutData(gd_btnSalvar_3);
		btnSalvar_3.setText("Salvar");
		
		value.setValue(new Imovel());
		
		initDataBindings();
	}
	
	private void criarTabelaChave(Composite composite){
		tvbChave = new TableViewerBuilder(composite);
		
		tvbChave.createColumn("Número").bindToProperty("numero").build();
	}
	
	private void criarTabelaComodo(Composite composite){
		tvbComodo = new TableViewerBuilder(composite);
		
		tvbComodo.createColumn("Comodo").bindToProperty("tipoComodo.nome").build();
		tvbComodo.createColumn("Descrição").bindToProperty("descricao").makeEditable().build();
	}
	
	private void criarTabelaHistorico(Composite composite){
		tvbHistorico = new TableViewerBuilder(composite);
		
		tvbHistorico.createColumn("Data da Visita").bindToProperty("data").build();
		tvbHistorico.createColumn("Funcionário").bindToProperty("funcionario.nome").build();
		tvbHistorico.createColumn("Cliente").bindToProperty("cliente.nome").build();
		tvbHistorico.createColumn("Observações").setPercentWidth(60).bindToProperty("observacoes").build();
	}
	
	private void criarTabelaVistoria(Composite composite){
		tvbVistoria = new TableViewerBuilder(composite);
		
		tvbVistoria.createColumn("Data da Vistoria").bindToProperty("data").build();
		tvbVistoria.createColumn("Funcionário").bindToProperty("funcionario.nome").build();
		tvbVistoria.createColumn("Inquilino").bindToProperty("inquilino.nome").build();
		tvbVistoria.createColumn("Fotos").bindToProperty("fotos").build();
		tvbVistoria.createColumn("Observações").setPercentWidth(60).bindToProperty("observacoes").build();
	}

	private void criarTabelaProposta(Composite composite){
		tvbProposta = new TableViewerBuilder(composite);
		
		tvbProposta.createColumn("Data de vistoria").bindToProperty("data").build();
		tvbProposta.createColumn("Valor").bindToProperty("valor").build();
		tvbProposta.createColumn("Cliente").bindToProperty("cliente.nome").build();
		tvbProposta.createColumn("Funcioário").bindToProperty("funcionario.nome").build();
		tvbProposta.createColumn("Observações").setPercentWidth(60).bindToProperty("observacoes").build();
	}
	
	@Override
	protected void salvar() {
	}
	
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeTextText_1ObserveWidget = WidgetProperties.text(SWT.NONE).observe(txtProprietario);
		IObservableValue valueAngariadorObserveDetailValue = PojoProperties.value(Imovel.class, "proprietario.nome", String.class).observeDetail(value);
		bindingContext.bindValue(observeTextText_1ObserveWidget, valueAngariadorObserveDetailValue, null, null);
		//
		IObservableValue observeTextText_21ObserveWidget = WidgetProperties.text(SWT.Modify).observe(text_21);
		IObservableValue valueCodigoObserveDetailValue = PojoProperties.value(Imovel.class, "codigo", String.class).observeDetail(value);
		bindingContext.bindValue(observeTextText_21ObserveWidget, valueCodigoObserveDetailValue, null, null);
		//
		IObservableValue observeTextText_2ObserveWidget = WidgetProperties.text(SWT.NONE).observe(text_2);
		IObservableValue valueAngariadorObserveDetailValue_1 = PojoProperties.value(Imovel.class, "angariador", Funcionario.class).observeDetail(value);
		bindingContext.bindValue(observeTextText_2ObserveWidget, valueAngariadorObserveDetailValue_1, null, null);
		//
		IObservableValue observeSingleSelectionComboViewer_4 = ViewerProperties.singleSelection().observe(comboViewer_4);
		IObservableValue valueTipoObserveDetailValue = PojoProperties.value(Imovel.class, "tipo.descricao", String.class).observeDetail(value);
		bindingContext.bindValue(observeSingleSelectionComboViewer_4, valueTipoObserveDetailValue, null, null);
		//
		IObservableValue observeTextText_5ObserveWidget = WidgetProperties.text(SWT.Modify).observe(text_5);
		IObservableValue valueMetragemObserveDetailValue = PojoProperties.value(Imovel.class, "metragem", BigDecimal.class).observeDetail(value);
		bindingContext.bindValue(observeTextText_5ObserveWidget, valueMetragemObserveDetailValue, null, null);
		//
		IObservableValue observeTextText_4ObserveWidget = WidgetProperties.text(SWT.Modify).observe(text_4);
		IObservableValue valueValorObserveDetailValue = PojoProperties.value(Imovel.class, "valor", BigDecimal.class).observeDetail(value);
		bindingContext.bindValue(observeTextText_4ObserveWidget, valueValorObserveDetailValue, null, null);
		//
		IObservableValue observeSelectionBtnVendaObserveWidget = WidgetProperties.selection().observe(btnVenda);
		IObservableValue valueVenderObserveDetailValue = PojoProperties.value(Imovel.class, "vender", Boolean.class).observeDetail(value);
		bindingContext.bindValue(observeSelectionBtnVendaObserveWidget, valueVenderObserveDetailValue, null, null);
		//
		IObservableValue observeSelectionBtnAluguelObserveWidget = WidgetProperties.selection().observe(btnAluguel);
		IObservableValue valueAlugarObserveDetailValue = PojoProperties.value(Imovel.class, "alugar", Boolean.class).observeDetail(value);
		bindingContext.bindValue(observeSelectionBtnAluguelObserveWidget, valueAlugarObserveDetailValue, null, null);
		//
		IObservableValue observeTextText_1ObserveWidget_1 = WidgetProperties.text(SWT.Modify).observe(text_1);
		IObservableValue valueEnderecocepObserveDetailValue = PojoProperties.value(Imovel.class, "endereco.cep", String.class).observeDetail(value);
		bindingContext.bindValue(observeTextText_1ObserveWidget_1, valueEnderecocepObserveDetailValue, null, null);
		//
		IObservableValue observeSingleSelectionComboViewer_3 = ViewerProperties.singleSelection().observe(comboViewer_3);
		IObservableValue valueEnderecoruanomeObserveDetailValue = PojoProperties.value(Imovel.class, "endereco.rua.nome", String.class).observeDetail(value);
		bindingContext.bindValue(observeSingleSelectionComboViewer_3, valueEnderecoruanomeObserveDetailValue, null, null);
		//
		IObservableValue observeTextText_7ObserveWidget = WidgetProperties.text(SWT.Modify).observe(text_7);
		IObservableValue valueEndereconumeroObserveDetailValue = PojoProperties.value(Imovel.class, "endereco.numero", String.class).observeDetail(value);
		bindingContext.bindValue(observeTextText_7ObserveWidget, valueEndereconumeroObserveDetailValue, null, null);
		//
		IObservableValue observeTextText_8ObserveWidget = WidgetProperties.text(SWT.Modify).observe(text_8);
		IObservableValue valueEnderecocomplementoObserveDetailValue = PojoProperties.value(Imovel.class, "endereco.complemento", String.class).observeDetail(value);
		bindingContext.bindValue(observeTextText_8ObserveWidget, valueEnderecocomplementoObserveDetailValue, null, null);
		//
		IObservableValue observeTextText_12ObserveWidget = WidgetProperties.text(SWT.NONE).observe(text_12);
		IObservableValue valueHistoricoFuncionarioObserveDetailValue = PojoProperties.value(HistoricoImovel.class, "funcionario.nome", String.class).observeDetail(valueHistorico);
		bindingContext.bindValue(observeTextText_12ObserveWidget, valueHistoricoFuncionarioObserveDetailValue, null, null);
		//
		IObservableValue observeTextText_14ObserveWidget = WidgetProperties.text(SWT.NONE).observe(text_14);
		IObservableValue valueHistoricoClientenomeObserveDetailValue = PojoProperties.value(HistoricoImovel.class, "cliente.nome", String.class).observeDetail(valueHistorico);
		bindingContext.bindValue(observeTextText_14ObserveWidget, valueHistoricoClientenomeObserveDetailValue, null, null);
		//
		IObservableValue observeTextText_13ObserveWidget = WidgetProperties.text(SWT.Modify).observe(text_13);
		IObservableValue valueHistoricoObservacoesObserveDetailValue = PojoProperties.value(HistoricoImovel.class, "observacoes", String.class).observeDetail(valueHistorico);
		bindingContext.bindValue(observeTextText_13ObserveWidget, valueHistoricoObservacoesObserveDetailValue, null, null);
		//
		IObservableValue observeTextText_10ObserveWidget = WidgetProperties.text(SWT.Modify).observe(text_10);
		IObservableValue valuePropostaValorObserveDetailValue = PojoProperties.value(Proposta.class, "valor", BigDecimal.class).observeDetail(valueProposta);
		bindingContext.bindValue(observeTextText_10ObserveWidget, valuePropostaValorObserveDetailValue, null, null);
		//
		IObservableValue observeTextText_9ObserveWidget = WidgetProperties.text(SWT.Modify).observe(text_9);
		IObservableValue valuePropostaCompradornomeObserveDetailValue = PojoProperties.value(Proposta.class, "comprador.nome", String.class).observeDetail(valueProposta);
		bindingContext.bindValue(observeTextText_9ObserveWidget, valuePropostaCompradornomeObserveDetailValue, null, null);
		//
		IObservableValue observeTextText_11ObserveWidget = WidgetProperties.text(SWT.Modify).observe(text_11);
		IObservableValue valuePropostaFuncionarioObserveDetailValue = PojoProperties.value(Proposta.class, "funcionario", Funcionario.class).observeDetail(valueProposta);
		bindingContext.bindValue(observeTextText_11ObserveWidget, valuePropostaFuncionarioObserveDetailValue, null, null);
		//
		IObservableValue observeTextText_20ObserveWidget = WidgetProperties.text(SWT.Modify).observe(text_20);
		IObservableValue valuePropostaObservacoesObserveDetailValue = PojoProperties.value(Proposta.class, "observacoes", String.class).observeDetail(valueProposta);
		bindingContext.bindValue(observeTextText_20ObserveWidget, valuePropostaObservacoesObserveDetailValue, null, null);
		//
		IObservableValue observeTextText_16ObserveWidget = WidgetProperties.text(SWT.Modify).observe(text_16);
		IObservableValue valueVistoriaFuncionarionomeObserveDetailValue = PojoProperties.value(Vistoria.class, "funcionario.nome", String.class).observeDetail(valueVistoria);
		bindingContext.bindValue(observeTextText_16ObserveWidget, valueVistoriaFuncionarionomeObserveDetailValue, null, null);
		//
		IObservableValue observeTextText_17ObserveWidget = WidgetProperties.text(SWT.Modify).observe(text_17);
		IObservableValue valueVistoriaInquilinonomeObserveDetailValue = PojoProperties.value(Vistoria.class, "inquilino.nome", String.class).observeDetail(valueVistoria);
		bindingContext.bindValue(observeTextText_17ObserveWidget, valueVistoriaInquilinonomeObserveDetailValue, null, null);
		//
		IObservableValue observeTextText_19ObserveWidget = WidgetProperties.text(SWT.Modify).observe(text_19);
		IObservableValue valueVistoriaObservacoesObserveDetailValue = PojoProperties.value(Vistoria.class, "observacoes", String.class).observeDetail(valueVistoria);
		bindingContext.bindValue(observeTextText_19ObserveWidget, valueVistoriaObservacoesObserveDetailValue, null, null);
		//
		return bindingContext;
	}
}
