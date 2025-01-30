package manipolatoreOggetti.objectAction;

import manipolatoreOggetti.command.CommandHandler;
import manipolatoreOggetti.model.GraphicObject;
import manipolatoreOggetti.specificcommand.GrpCommand;
import manipolatoreOggetti.view.GraphicObjectPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class GrpObjectAction extends AbstractAction {

    private GraphicObjectPanel panel;
    private CommandHandler handler;
    private LinkedList<GraphicObject> listaOggetti;
    private int id;

    public GrpObjectAction(GraphicObjectPanel panel, CommandHandler handler, LinkedList<GraphicObject> listaOggetti,int id) {
        this.panel = panel;
        this.handler = handler;
        this.listaOggetti = listaOggetti;
        this.id = id;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        handler.handle(new GrpCommand(listaOggetti, panel,id));
    }
}
