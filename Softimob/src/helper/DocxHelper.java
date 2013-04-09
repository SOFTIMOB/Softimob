package helper;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.Text;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.xml.bind.JAXBElement;

public class DocxHelper {

	private final String XPATH_TO_SELECT_TEXT_NODES = "//w:t";
	
	@SuppressWarnings("rawtypes")
	public void createPartControl(File file, HashMap<String, String> coringas) {

		try {
			//Abre o arquivo
			WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(file);

			//Pega todas as linhas do arquivo e joga em uma lista
			List<Object> texts = wordMLPackage.getMainDocumentPart().getJAXBNodesViaXPath(XPATH_TO_SELECT_TEXT_NODES, true);
			
			for (Object obj : texts) {
				Text text = (Text) ((JAXBElement) obj).getValue();
				String linha = text.getValue();
				
				Set<String> keySet = coringas.keySet();
				for (String coringa: keySet) {
					//Pega o key do map que é a palavra coringa e seta no lugar dela a variavel
					linha = linha.replaceAll(coringa, coringas.get(coringa));
				}
				//Seta a linha no docx
				text.setValue(linha);
			}
			wordMLPackage.save(file);

		} catch (Docx4JException e) {
		} catch (Exception e) {
		}

	}

}
