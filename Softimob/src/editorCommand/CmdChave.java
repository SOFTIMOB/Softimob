package editorCommand;

import editorInput.ChaveEditorInput;
import editor.ChaveEditor;

public class CmdChave extends GenericAbstractHandler {

	public CmdChave() {
		editorInput = new ChaveEditorInput();
		id = ChaveEditor.ID;
	}

}
