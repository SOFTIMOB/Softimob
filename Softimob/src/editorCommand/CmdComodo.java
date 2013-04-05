package editorCommand;

import editorInput.ComodoEditorInput;
import editor.ComodoEditor;

public class CmdComodo extends GenericAbstractHandler {

	public CmdComodo() {
		this.editorInput = new ComodoEditorInput();
		this.id = ComodoEditor.ID;
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
