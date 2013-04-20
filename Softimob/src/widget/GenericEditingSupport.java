package widget;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TextCellEditor;

public abstract class GenericEditingSupport extends EditingSupport{

	private CellEditor cellEditor;
	
	public GenericEditingSupport(ColumnViewer viewer) {
		super(viewer);
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		if(cellEditor == null)
			cellEditor = new TextCellEditor();
		return cellEditor;
	}

	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

	@Override
	protected abstract Object getValue(Object element);

	@Override
	protected abstract void setValue(Object element, Object value);

}
