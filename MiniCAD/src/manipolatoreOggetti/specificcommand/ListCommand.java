package manipolatoreOggetti.specificcommand;

import manipolatoreOggetti.InterpreteComandi.SyntaxException;
import manipolatoreOggetti.command.Command;
import manipolatoreOggetti.model.GraphicObject;
import manipolatoreOggetti.view.GraphicObjectPanel;

public class ListCommand implements Command {

    private GraphicObjectPanel panel;
    private int id = -1;
    private String in;
    private StringBuilder out = new StringBuilder();

    public ListCommand(GraphicObjectPanel panel, int id) {
        this.panel = panel;
        this.id = id;
    }

    public ListCommand(GraphicObjectPanel panel, String in) {
        this.panel = panel;
        this.in = in;
    }

    @Override
    public boolean doIt() {
        if (id > -1) {
            out = out.append(panel.getGraphicObjectFromId(id).getProp());
        }
        else if (in.equalsIgnoreCase("circle")){
            for (GraphicObject go : panel.objects)
                if(go.getType().equals("Circle"))
                    out.append(go.getProp()).append("\n");
        }
        else if (in.equalsIgnoreCase("rectangle")){
            for (GraphicObject go : panel.objects)
                if(go.getType().equals("Rectangle"))
                    out.append(go.getProp()).append("\n");
        }
        else if (in.equalsIgnoreCase("image")){
            for (GraphicObject go : panel.objects)
                if(go.getType().equals("Image"))
                    out.append(go.getProp()).append("\n");
        }
        else if (in.equalsIgnoreCase("groups")){
            for (GraphicObject go : panel.objects)
                if(go.getType().equals("Group"))
                    out.append(go.getProp()).append("\n");
        }
        else if (in.equalsIgnoreCase("all")){
            for(GraphicObject go : panel.objects)
                out.append(go.getProp()).append("\n");
        }
        else
            throw new SyntaxException("carattere invalido");
        return true;
    }

    public String getOut(){
        return out.toString();
    }

    @Override
    public boolean undoIt() {
        return false;
    }
}
