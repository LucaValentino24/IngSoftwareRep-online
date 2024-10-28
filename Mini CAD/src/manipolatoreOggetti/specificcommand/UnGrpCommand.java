package manipolatoreOggetti.specificcommand;

import manipolatoreOggetti.command.Command;
import manipolatoreOggetti.model.AbstractGraphicObject;
import manipolatoreOggetti.model.GraphicObject;
import manipolatoreOggetti.model.GroupObject;
import manipolatoreOggetti.view.GraphicObjectPanel;

import java.util.LinkedList;

public class UnGrpCommand implements Command {

    private GroupObject group;
    private GraphicObjectPanel panel;
    private LinkedList<GraphicObject> objects = new LinkedList<>();

    public UnGrpCommand(GroupObject group, GraphicObjectPanel panel) {
        this.group = group;
        this.panel = panel;
    }

    @Override
    public boolean doIt() {
        for(GraphicObject object : group.getObjects()) {
            objects.add(object);
        }
        group.removeAllObjects();
        panel.remove(group);
        return true;
    }

    @Override
    public boolean undoIt() {
        for(GraphicObject object : objects) {
            group.addObject((AbstractGraphicObject) object);
        }
        panel.add(group);
        return true;
    }
}