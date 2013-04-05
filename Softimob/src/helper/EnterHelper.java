package helper;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

public class EnterHelper {

	private static List<Control> arrayControls = new ArrayList<Control>();
	private static boolean shiftPressed = false;
	protected static boolean ctrlPressed = false;
	
	public static void addEnterNextControlToGroupOrComposite(Control control){
		addControl(new Control[]{control});
		
		for(final Control children : arrayControls){
			if(!children.isDisposed()){
				addEnterNextControl(children);
			}
		}
	}
	
	private static void addEnterNextControl(final Control control){
		control.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if(e.keyCode == SWT.SHIFT)
					shiftPressed = false;
				if(e.keyCode == SWT.CTRL)
					ctrlPressed = false;
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.keyCode == SWT.SHIFT)
					shiftPressed = true;
				if(e.keyCode == SWT.CTRL)
					ctrlPressed = true;
			}
		});
		
		control.addTraverseListener(new TraverseListener() {
			@Override
			public void keyTraversed(TraverseEvent e) {
				if(e.character == SWT.CR){
					if(!ctrlPressed){
						control.traverse(shiftPressed ? SWT.TRAVERSE_TAB_PREVIOUS : SWT.TRAVERSE_TAB_NEXT);
						e.doit = false;
					}
				}
			}
		});
	}
	
	private static void addControl(Control[] controls){
		for(Control control : controls){
			if(control instanceof Text || control instanceof Combo || control instanceof Table || control instanceof Button){
				arrayControls.add(control);
			} else if(control instanceof Group){
				addControl(((Group) control).getChildren());
			} else if(control instanceof Composite){
				addControl(((Composite) control).getChildren());
			} 
		}
	}
	
}