package widget.imovel;

import java.util.HashSet;
import java.util.Set;

import modelo.Imovel;

import org.eclipse.nebula.widgets.xviewer.IXViewerFactory;
import org.eclipse.nebula.widgets.xviewer.XViewer;
import org.eclipse.swt.widgets.Composite;

public class ImovelXViewer extends XViewer{

	private final Set<Imovel> runList = new HashSet<Imovel>();
	
	public ImovelXViewer(Composite parent, int style, IXViewerFactory xViewerFactory) {
		super(parent, style, xViewerFactory);
		
		setContentProvider(new ImovelXViewerContentProvider());
		setLabelProvider(new ImovelXViewerLabelProvider(this));
	}

	public ImovelXViewer(Composite parent, int style) {
		this(parent, style, new ImovelXViewerFactory());
	}

	public boolean isScheduled(Imovel autoRunTask) {
		return true;
	}

	public boolean isRun(Imovel autoRunTask) {
		return runList.contains(autoRunTask);
	}

	public void setRun(Imovel autoRunTask, boolean run) {
		if (run)
			runList.add(autoRunTask);
		else
			runList.remove(autoRunTask);
	}
	
}
