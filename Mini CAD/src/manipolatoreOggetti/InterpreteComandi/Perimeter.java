package manipolatoreOggetti.InterpreteComandi;

import manipolatoreOggetti.command.CommandHandler;
import manipolatoreOggetti.view.GraphicObjectPanel;
import manipolatoreOggetti.view.ListObjectAction;
import manipolatoreOggetti.view.PerimeterObjectAction;

import java.awt.event.ActionEvent;

public class Perimeter implements ComandoIF{

    private GraphicObjectPanel panel;
    private CommandHandler handler;
    private int id = -1;
    private String in;
    private double out;

    public Perimeter(int id, GraphicObjectPanel panel, CommandHandler handler) {
        this.id = id;
        this.panel = panel;
        this.handler = handler;
    }

    public Perimeter(String in, GraphicObjectPanel panel, CommandHandler handler) {
        this.in = in;
        this.panel = panel;
        this.handler = handler;
    }

    @Override
    public void interpreta(ActionEvent e) {
        PerimeterObjectAction poa = new PerimeterObjectAction(panel,handler,id,in);
        poa.actionPerformed(e);
        out = poa.getOut();
    }

    public String getOut(){
        return Double.toString(out);
    }
}
