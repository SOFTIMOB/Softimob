package editorCommand;

import editorInput.ImovelEditorInput;
import editor.ImovelEditor;

public class CmdImovel extends GenericAbstractHandler{

	public CmdImovel() {
		editorInput = new ImovelEditorInput();
		id = ImovelEditor.ID;
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
