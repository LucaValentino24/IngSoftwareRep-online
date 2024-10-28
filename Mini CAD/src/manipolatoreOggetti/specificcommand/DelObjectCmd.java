package manipolatoreOggetti.specificcommand;

import manipolatoreOggetti.command.Command;
import manipolatoreOggetti.model.GraphicObject;
import manipolatoreOggetti.view.GraphicObjectPanel;

import java.awt.geom.Point2D;

public class DelObjectCmd implements Command {

    private final GraphicObjectPanel panel;
    private GraphicObject go = null;
    private Point2D oldPos;

    public DelObjectCmd(GraphicObjectPanel panel, GraphicObject go) {
        this.panel = panel;
        this.go = go;
    }

    @Override
    public boolean doIt() {
        oldPos = go.getPosition();
        panel.remove(go);
        return true;
    }

    @Override
    public boolean undoIt() {
        panel.add(go);
        go.moveTo(oldPos);
        return true;
    }
}
