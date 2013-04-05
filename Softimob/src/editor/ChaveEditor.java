package editor;

import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;

import org.docx4j.openpackaging.contenttype.ContentTypeManager;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.PresentationMLPackage;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
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
		
		Label lblImvel = new Label(composite, SWT.NONE);
		lblImvel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblImvel.setText("Imóvel");
		
		text_1 = new Text(composite, SWT.BORDER);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		String inputfilepath = "C:\\Users\\Seven\\Desktop\\duvidas.docx";
		WordprocessingMLPackage load;
		try {
			load = WordprocessingMLPackage.load(new java.io.File(inputfilepath));
			load.getDocumentModel();
			List<Object> jaxbNodesViaXPath = load.getMainDocumentPart().getJAXBNodesViaXPath("//w:t", true);
			
			for (Object object : jaxbNodesViaXPath) {
				org.docx4j.wml.Text text = (org.docx4j.wml.Text) ((JAXBElement<?>) object).getValue();
				String textValueBefore = text.getValue();   
                
                // Perform the replacement   
				
				
      
                String antiga ="\\$\\{";  
                String nova = "seq";  
                  
                String textValueAfter = textValueBefore.replaceAll(antiga, nova);   

                // Show the element before and after the replacement   
                System.out.println("textValueBefore = " + textValueBefore);   
                System.out.println("textValueAfter = " + textValueAfter); 
			}
		} catch (Docx4JException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		super.createPartControl(parent);
	}

	@Override
	protected void salvar() {
		// TODO Auto-generated method stub
		
	}
	
}
