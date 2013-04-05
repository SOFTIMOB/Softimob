package editorCommand;

import editorInput.PlacaEditorInput;
import editor.PlacaEditor;

public class CmdPlaca extends GenericAbstractHandler {

	public CmdPlaca() {
		this.editorInput = new PlacaEditorInput();
		this.id = PlacaEditor.ID;
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
