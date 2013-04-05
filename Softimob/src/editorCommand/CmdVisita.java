package editorCommand;

import editorInput.VisitaEditorInput;
import editor.VisitaEditor;

public class CmdVisita extends GenericAbstractHandler {

	public CmdVisita() {
		this.editorInput = new VisitaEditorInput();
		this.id = VisitaEditor.ID;
	}
	
//	@Override
//	public Object execute(ExecutionEvent event) throws ExecutionException {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
