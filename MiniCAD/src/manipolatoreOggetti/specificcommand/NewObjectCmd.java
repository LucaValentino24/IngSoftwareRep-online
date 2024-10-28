package manipolatoreOggetti.specificcommand;

import manipolatoreOggetti.command.Command;
import manipolatoreOggetti.model.GraphicObject;
import manipolatoreOggetti.view.GraphicObjectPanel;

import java.awt.geom.Point2D;

public class NewObjectCmd implements Command {

	private final GraphicObjectPanel panel;
	private final GraphicObject go;
	private  Point2D pos = new Point2D.Double(0,0);

	public NewObjectCmd(GraphicObjectPanel panel, GraphicObject go) {
		this.panel = panel;
		this.go = go;
	}

	public NewObjectCmd(GraphicObjectPanel panel, GraphicObject go, Point2D point) {
		this.panel = panel;
		this.go = go;
		this.pos = point;
	}

	@Override
	public boolean doIt() {
		double x = pos.getX();
		double y =  pos.getY();
		go.moveTo(x, y);
		panel.add(go);

		return true;
	}

	@Override
	public boolean undoIt() {
		panel.remove(go);
		return true;
	}

}
