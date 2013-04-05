package editorCommand;

import editorInput.AberturaChamadoReformaEditorInput;
import editor.AberturaChamadoReformaEditor;

public class CmdAberturaChamadoReforma extends GenericAbstractHandler{

	public CmdAberturaChamadoReforma() {
		this.editorInput = new AberturaChamadoReformaEditorInput();
		this.id = AberturaChamadoReformaEditor.ID;
	}
	
//	@Override
//	public Object execute(ExecutionEvent event) throws ExecutionException {
//		try {
//			HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().openEditor(new AberturaChamadoReformaEditorInput(), AberturaChamadoReformaEditor.ID);
//		} catch (PartInitException e) {
//			e.printStackTrace();
//		}
//		
//		return null;
//	}

}
