package manipolatoreOggetti.view;

import manipolatoreOggetti.interpreteComandi.SyntaxException;
import manipolatoreOggetti.model.GraphicEvent;
import manipolatoreOggetti.model.GraphicObject;
import manipolatoreOggetti.model.GraphicObjectListener;
import manipolatoreOggetti.model.GroupObject;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;

public class GraphicObjectPanel extends JComponent implements GraphicObjectListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8993548105090978185L;

	/**
	 * @directed true
	 */

	public final List<GraphicObject> objects = new LinkedList<>();
	public List<Integer> ids = new LinkedList<>();


	public GraphicObjectPanel() {
		setBackground(Color.WHITE);
	}

	@Override
	public void graphicChanged(GraphicEvent e) {
		repaint();
		revalidate();

	}

	
	public GraphicObject getGraphicObjectAt(Point2D p) {
		for (GraphicObject g : objects) {
			if (g.contains(p))
				return g;
		}
		return null;
	}

	public GraphicObject getGraphicObjectFromId(int id) {
		for (GraphicObject g : objects) {
			if(g.getId() == id)
				return g;
		}
		throw new SyntaxException("non esiste oggetto con questo id");
	}

	@Override
	public Dimension getPreferredSize() {
		Dimension ps = super.getPreferredSize();
		double x = ps.getWidth();
		double y = ps.getHeight();
		for (GraphicObject go : objects) {
			double nx = go.getPosition().getX() + go.getDimension().getWidth() / 2;
			double ny = go.getPosition().getY() + go.getDimension().getHeight() / 2;
			if (nx > x)
				x = nx;
			if (ny > y)
				y = ny;
		}
		return new Dimension((int) x, (int) y);
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		for (GraphicObject go : objects) {
			GraphicObjectView view = GraphicObjectViewFactory.FACTORY.createView(go);
			view.drawGraphicObject(go, g2);
		}

	}

	public void add(GraphicObject go) {
		if(ids.contains(go.getId()))
			throw new SyntaxException("esiste già un oggetto con questo id");
		objects.add(go);
		ids.add(go.getId());
		go.addGraphicObjectListener(this);
		repaint();
	}

	public void remove(GraphicObject go) {
		if (objects.remove(go)) {
			if(go instanceof GroupObject)
				for(GraphicObject g:((GroupObject) go).getObjects()) {
					objects.remove(g);
					ids.remove(g.getId());
				}
			repaint();
			go.removeGraphicObjectListener(this);
		}

	}

	public void remove(int id){
		for (GraphicObject go : objects) {
			if(go.getId() == id){
				remove(go);
			}
		}
	}

	public boolean containsObject(GraphicObject go) {
		for (GraphicObject go1 : objects) {
			if(go1.equals(go))
				return true;
		}
		return false;
	}
}