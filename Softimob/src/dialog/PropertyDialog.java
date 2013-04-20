package dialog;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.dialogs.FilteredList;

public class PropertyDialog extends ElementListSelectionDialog{

	public PropertyDialog(Shell parent, ILabelProvider renderer) {
		super(parent, renderer);
	}
	
}
