package editorCommand;

import editorInput.ClienteEditorInput;
import editor.ClienteEditor;

public class CmdCliente extends GenericAbstractHandler {

	public CmdCliente() {
		this.editorInput = new ClienteEditorInput();
		this.id = ClienteEditor.ID;
	}
	
//	@Override
//	public Object execute(ExecutionEvent event) throws ExecutionException {
//		try {
//			HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().openEditor(new ClienteEditorInput(), ClienteEditor.ID);
//		} catch (PartInitException e) {
//			e.printStackTrace();
//		}
//		
//		return null;
//	}

}
