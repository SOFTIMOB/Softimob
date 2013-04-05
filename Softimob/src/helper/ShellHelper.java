package helper;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class ShellHelper {

	public static Shell getShell(){
		return PlatformUI.getWorkbench().getDisplay().getActiveShell();
	}
	
}
