package manipolatoreOggetti.interpreteComandi;

import manipolatoreOggetti.command.CommandHandler;
import manipolatoreOggetti.objectAction.AreaObjectAction;
import manipolatoreOggetti.view.GraphicObjectPanel;

import java.awt.event.ActionEvent;

public class Area implements ComandoIF{

    private GraphicObjectPanel panel;
    private CommandHandler handler;
    private int id = -1;
    private String in;
    private double out;

    public Area(int id, GraphicObjectPanel panel, CommandHandler handler) {
        this.id = id;
        this.panel = panel;
        this.handler = handler;
    }

    public Area(String in, GraphicObjectPanel panel, CommandHandler handler) {
        this.in = in;
        this.panel = panel;
        this.handler = handler;
    }

    @Override
    public void interpreta(ActionEvent e) {
        AreaObjectAction aoa = new AreaObjectAction(panel,handler,id,in);
        aoa.actionPerformed(e);
        out = aoa.getOut();
    }

    public String getOut(){
        return Double.toString(out);
    }
}
