package editorCommand;

import editorInput.TipoImovelEditorInput;
import editor.TipoImovelEditor;

public class CmdTipoImovel extends GenericAbstractHandler {

	public CmdTipoImovel() {
		this.editorInput = new TipoImovelEditorInput();
		this.id = TipoImovelEditor.ID;
	}
	
//	@Override
//	public Object execute(ExecutionEvent event) throws ExecutionException {
//		try {
//			HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().openEditor(new ChaveEditorInput(), ChaveEditor.ID);
//		} catch (PartInitException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

}
