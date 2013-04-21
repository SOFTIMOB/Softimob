package editor;

import helper.WidgetHelper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import modelo.Chave;
import modelo.Cliente;
import modelo.Comodo;
import modelo.HistoricoImovel;
import modelo.Funcionario;
import modelo.Imovel;
import modelo.TipoComodo;
import modelo.TipoImovel;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.nebula.widgets.xviewer.XViewer;
import org.eclipse.nebula.widgets.xviewer.XViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import de.ralfebert.rcputils.tables.TableViewerBuilder;

import widget.imovel.ImovelXViewer;
import widget.imovel.ImovelXViewerFactory;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.custom.SashForm;

public class ChaveEditor extends SoftimobEditor {
	
	public static final String ID = "editor.ChaveEditor"; 
	private Text text;
	private Text text_1;
	private Text txtBusca;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	
	public ChaveEditor() {
	}

//		String inputfilepath = "C:\\Users\\Seven\\Desktop\\duvidas.docx";
//		WordprocessingMLPackage load;
//		try {
//			load = WordprocessingMLPackage.load(new java.io.File(inputfilepath));
//			load.getDocumentModel();
//			List<Object> jaxbNodesViaXPath = load.getMainDocumentPart().getJAXBNodesViaXPath("//w:t", true);
//			
//			for (Object object : jaxbNodesViaXPath) {
//				org.docx4j.wml.Text text = (org.docx4j.wml.Text) ((JAXBElement<?>) object).getValue();
//				String textValueBefore = text.getValue();   
//                
//                // Perform the replacement   
//				
//				
//      
//                String antiga ="\\$\\{";  
//                String nova = "seq";  
//                  
//                String textValueAfter = textValueBefore.replaceAll(antiga, nova);   
//
//                // Show the element before and after the replacement   
//                System.out.println("textValueBefore = " + textValueBefore);   
//                System.out.println("textValueAfter = " + textValueAfter); 
//			}
//		} catch (Docx4JException e) {
//			e.printStackTrace();
//		} catch (JAXBException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	@Override
	public void afterCreatePartControl(Composite parent) {
		Map<String, String> atributos = new HashMap<String, String>();
		atributos.put("Nome", "nome");
		atributos.put("CPF", "cpf");
		atributos.put("RG", "rg");
		
		Cliente c1 = new Cliente();
		c1.setNome("Adalberto");
		c1.setCpf("123456");
		c1.setRg("56783");
		
		Cliente c2 = new Cliente();
		c2.setNome("Joao");
		c2.setCpf("97877");
		c2.setRg("63827136");
		
		Cliente c3 = new Cliente();
		c3.setNome("Joana");
		c3.setCpf("73489274");
		c3.setRg("732468");
		parent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
		parent.setLayout(new GridLayout(1, false));
		
		SashForm sashForm = new SashForm(parent, SWT.NONE);
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		formToolkit.adapt(sashForm);
		formToolkit.paintBordersFor(sashForm);
		
		Composite composite_1 = new Composite(sashForm, SWT.NONE);
		formToolkit.adapt(composite_1);
		formToolkit.paintBordersFor(composite_1);
		composite_1.setLayout(new GridLayout(1, false));
		
		ExpandableComposite xpndblcmpstNewExpandablecomposite = formToolkit.createExpandableComposite(composite_1, ExpandableComposite.TWISTIE);
		xpndblcmpstNewExpandablecomposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		xpndblcmpstNewExpandablecomposite.setSize(152, 30);
		formToolkit.paintBordersFor(xpndblcmpstNewExpandablecomposite);
		xpndblcmpstNewExpandablecomposite.setText("Filtro de cômodos");
		xpndblcmpstNewExpandablecomposite.setExpanded(true);
		
		Composite composite = formToolkit.createComposite(xpndblcmpstNewExpandablecomposite, SWT.NONE);
		formToolkit.paintBordersFor(composite);
		xpndblcmpstNewExpandablecomposite.setClient(composite);
		composite.setLayout(new GridLayout(1, false));
		sashForm.setWeights(new int[] {1});
		new Label(parent, SWT.NONE);

		ImovelXViewer xViewer = new ImovelXViewer(parent, SWT.BORDER | SWT.FILL | SWT.FULL_SELECTION);
		Tree tree = xViewer.getTree();
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		//não mostra o menu no clique do botão direito
		xViewer.getMenuManager().dispose();

		List<XViewerColumn> columns = new ImovelXViewerFactory().getColumns();
		String[] colunas = new String[columns.size()];
		for (int i = 0; i < columns.size(); i++) {
			colunas[i] = columns.get(i).getName();
		}

		xViewer.setColumnProperties(colunas);

		xViewer.setInput(cadastrarImoveis());
//		
//		
//		Label lblNmero = new Label(parent, SWT.NONE);
//		lblNmero.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
//		lblNmero.setText("Número");
//		
//		text = new Text(parent, SWT.BORDER);
//		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
//		
//		Label lblImvel = new Label(parent, SWT.NONE);
//		lblImvel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
//		lblImvel.setText("Imóvel");
//		
//		text_1 = new Text(parent, SWT.BORDER);
//		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	}
		
	private List<Imovel> cadastrarImoveis() {
		List<Imovel> imoveis = new ArrayList<Imovel>();
		for(int i = 1 ; i < 10 ; i++){
			Random r = new Random();

			Imovel imovel = new Imovel();
			
			imovel.setCodigo(i + "");
			imovel.setMetragem(new BigDecimal(i * 100));
			imovel.setAngariador(new Funcionario("Adalberto " + i));
			imovel.setTipo(new TipoImovel("Tipo "+i));
			Cliente proprietario = new Cliente("Cliente "+i);
			proprietario.setTelefone("432432432");
			imovel.setProprietario(proprietario);
			imovel.setStatus(2);
			
			List<Chave> chaves = new ArrayList<Chave>();
			for(int f = 0; f < r.nextInt() * 3; f++){
				Chave chave = new Chave(f + " - " + i);
				chave.setImovel(imovel);
				
				chaves.add(chave);
			}
			imovel.setChaves(chaves);

			List<Comodo> comodos = new ArrayList<Comodo>();
			for(int f = 0; f < r.nextInt() * 3; f++){
				Comodo comodo = new Comodo();
				comodo.setDescricao("Comodo" + f);
				
				TipoComodo tipoComodo = new TipoComodo();
				tipoComodo.setNome("Tipo comodo do comodo "+comodo.getDescricao());
				comodo.setTipoComodo(tipoComodo);
				
				comodos.add(comodo);
			}
			imovel.setComodos(comodos);
			
			List<HistoricoImovel> historicos = new ArrayList<HistoricoImovel>();
			for(int f = 0; f < r.nextInt() * 3; f++){
				HistoricoImovel feedback = new HistoricoImovel();
				feedback.setFeedback("Feedback "+f);
				feedback.setData(new Date());
				
				historicos.add(feedback);
			}
			imovel.setFeedbacks(historicos);
			
			imoveis.add(imovel);
		}
		return imoveis;
	}
	
	@Override
	protected void salvar() {
	}
}
