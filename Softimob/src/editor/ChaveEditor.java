package editor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class ChaveEditor extends SoftimobEditor {
	
	public static final String ID = "editor.ChaveEditor"; 
	private Text text;
	private Text text_1;
	
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
		parent.setLayout(new GridLayout(2, false));
		parent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
		
		Label lblNmero = new Label(parent, SWT.NONE);
		lblNmero.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNmero.setText("Número");
		
		text = new Text(parent, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblImvel = new Label(parent, SWT.NONE);
		lblImvel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblImvel.setText("Imóvel");
		
		text_1 = new Text(parent, SWT.BORDER);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	}
		
	@Override
	protected void salvar() {
	}
	
}
