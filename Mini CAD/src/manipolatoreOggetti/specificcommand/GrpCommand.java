package manipolatoreOggetti.specificcommand;

import manipolatoreOggetti.command.Command;
import manipolatoreOggetti.model.*;
import manipolatoreOggetti.view.GraphicObjectPanel;

import java.util.LinkedList;

public class GrpCommand implements Command {

    private LinkedList<GraphicObject> objects;
    private GroupObject group;
    private GraphicObjectPanel panel;
    private int id;

    public GrpCommand(LinkedList<GraphicObject> objects, GraphicObjectPanel panel, int id){
        this.objects = objects;
        this.panel = panel;
        this.id = id;
        group = new GroupObject(id,objects.getFirst().getPosition());
    }

    @Override
    public boolean doIt() {
        for(GraphicObject object : objects){
            if(!panel.containsObject(object)) {
                group.removeAllObjects();
                return false;
            }
            group.addObject(object);
        }
        panel.add(group);
        return true;
    }

    @Override
    public boolean undoIt() {
        group.removeAllObjects();
        panel.remove(group);
        return true;
    }
}
