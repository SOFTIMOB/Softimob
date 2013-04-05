package editorCommand;

import editorInput.FuncionarioEditorInput;
import editor.FuncionarioEditor;

public class CmdFuncionario extends GenericAbstractHandler {

	public CmdFuncionario() {
		this.editorInput = new FuncionarioEditorInput();
		this.id = FuncionarioEditor.ID;
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
