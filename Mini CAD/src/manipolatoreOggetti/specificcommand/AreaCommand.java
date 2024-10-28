package manipolatoreOggetti.specificcommand;

import manipolatoreOggetti.InterpreteComandi.SyntaxException;
import manipolatoreOggetti.command.Command;
import manipolatoreOggetti.model.GraphicObject;
import manipolatoreOggetti.view.GraphicObjectPanel;

public class AreaCommand implements Command {

    private GraphicObjectPanel panel;
    private int id = -1;
    private String in;
    private double out = 0;

    public AreaCommand(GraphicObjectPanel panel, int id) {
        this.panel = panel;
        this.id = id;
    }

    public AreaCommand(GraphicObjectPanel panel, String in) {
        this.panel = panel;
        this.in = in;
    }

    @Override
    public boolean doIt() {
        if (id > -1) {
            out += panel.getGraphicObjectFromId(id).getArea();
        }
        else if (in.equalsIgnoreCase("circle")){
            for (GraphicObject go : panel.objects)
                if(go.getType().equals("Circle"))
                    out += go.getArea();
        }
        else if (in.equalsIgnoreCase("rectangle")){
            for (GraphicObject go : panel.objects)
                if(go.getType().equals("Rectangle"))
                    out += go.getArea();
        }
        else if (in.equalsIgnoreCase("image")){
            for (GraphicObject go : panel.objects)
                if(go.getType().equals("Image"))
                    out += go.getArea();
        }
        else if (in.equalsIgnoreCase("groups")){
            for (GraphicObject go : panel.objects)
                if(go.getType().equals("Group"))
                    out += go.getArea();
        }
        else if (in.equalsIgnoreCase("all")){
            for(GraphicObject go : panel.objects)
                out += go.getArea();
        }
        else
            throw new SyntaxException("carattere invalido");
        return true;
    }

    public double getOut(){
        return out;
    }

    @Override
    public boolean undoIt() {
        return false;
    }
}
