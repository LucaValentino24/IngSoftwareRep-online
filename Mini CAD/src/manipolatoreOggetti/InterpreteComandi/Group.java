package manipolatoreOggetti.InterpreteComandi;

import manipolatoreOggetti.command.CommandHandler;
import manipolatoreOggetti.model.AbstractGraphicObject;
import manipolatoreOggetti.model.GraphicObject;
import manipolatoreOggetti.view.GraphicObjectPanel;
import manipolatoreOggetti.view.GrpObjectAction;

import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class Group implements ComandoIF{

    private final GraphicObjectPanel panel;
    private final CommandHandler handler;
    private LinkedList<GraphicObject> listaOggetti;
    private int id;

    public Group(GraphicObjectPanel panel, CommandHandler handler, LinkedList<GraphicObject> listaOggetti, int id) {
        this.panel = panel;
        this.handler = handler;
        this.listaOggetti = listaOggetti;
        this.id = id;
    }

    @Override
    public void interpreta(ActionEvent e) {
        new GrpObjectAction(panel, handler,listaOggetti,id).actionPerformed(e);
    }
}