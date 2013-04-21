package view;

import helper.ImageHelper;
import helper.WidgetHelper;

import java.util.List;
import java.util.Map;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.part.ViewPart;

import de.ralfebert.rcputils.tables.TableViewerBuilder;import org.eclipse.wb.swt.SWTResourceManager;

public abstract class GenericView extends ViewPart{
	
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	
	private Composite cpBody;
	private Action actAdd;
	private Action actRefresh;

	private TableViewerBuilder tvb;
	
	public GenericView() {
		createActions();
	}
	
	private void createActions() {
		{
			actAdd = new Action("Cadastrar") {
				@Override
				public void run() {
					cadastrar();
				}			};
			actAdd.setImageDescriptor(ImageHelper.ADD_DESCRIPTOR_16);
		}
		{
			actRefresh = new Action("Atualizar") {
				@Override
				public void run() {
					atualizar();
				}			};
			actRefresh.setImageDescriptor(ImageHelper.REFRESH_DESCRIPTOR_16);
		}
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		
		Form frmNewForm = formToolkit.createForm(parent);		frmNewForm.getHead().setFont(SWTResourceManager.getFont("Sans", 16, SWT.BOLD));		frmNewForm.setImage(getImage());
		frmNewForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		formToolkit.paintBordersFor(frmNewForm);
		frmNewForm.setText(getName());
		frmNewForm.getBody().setLayout(new GridLayout(1, false));
		
		cpBody = formToolkit.createComposite(frmNewForm.getBody(), SWT.NONE);
		cpBody.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		cpBody.setLayout(new GridLayout(2, false));
		formToolkit.paintBordersFor(cpBody);
		
		tvb = WidgetHelper.createTableWithFilter(formToolkit, cpBody, getAttributes());
		tvb.getTable().setMenu(getMenu(tvb.getTable()));
		
		tvb.setInput(getInput());
		
		frmNewForm.getToolBarManager().add(actAdd);
		frmNewForm.getToolBarManager().add(actRefresh);
		frmNewForm.updateToolBar();
		frmNewForm.update();
	}

	protected void atualizar() {
		tvb.getTableViewer().refresh();
	}
	
	public void cadastrar(){
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(getIEditorInput(), getEditorId());
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}
	
	public abstract String getName();
	
	protected abstract Image getImage();

	public abstract Map<String, String> getAttributes();
	
	protected abstract IEditorInput getIEditorInput();

	protected abstract String getEditorId();
	
	protected abstract <T> List<T> getInput();
	
	protected abstract Menu getMenu(Table tb);
	
	@Override
	public void setFocus() {
		Control[] children = cpBody.getChildren();
		children[1].forceFocus();
	}
	
}
