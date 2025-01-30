package manipolatoreOggetti.interpreteComandi;

import manipolatoreOggetti.command.CommandHandler;
import manipolatoreOggetti.view.GraphicObjectPanel;
import manipolatoreOggetti.objectAction.ListObjectAction;

import java.awt.event.ActionEvent;

public class ListC implements ComandoIF {

    private GraphicObjectPanel panel;
    private CommandHandler handler;
    private int id = -1;
    private String in;
    private String out;

    public ListC(int id, GraphicObjectPanel panel, CommandHandler handler) {
        this.id = id;
        this.panel = panel;
        this.handler = handler;
    }

    public ListC(String in, GraphicObjectPanel panel, CommandHandler handler) {
        this.in = in;
        this.panel = panel;
        this.handler = handler;
    }

    @Override
    public void interpreta(ActionEvent e) {
        ListObjectAction loa = new ListObjectAction(panel,handler,id,in);
        loa.actionPerformed(e);
        out = loa.getOut();
    }

    public String getOut(){
        return out;
    }
}
