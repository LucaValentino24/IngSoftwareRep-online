package manipolatoreOggetti.InterpreteComandi;

import manipolatoreOggetti.command.CommandHandler;
import manipolatoreOggetti.view.GraphicObjectPanel;
import manipolatoreOggetti.view.ScaleObjectAction;

import java.awt.event.ActionEvent;

public class Scale implements ComandoIF{

    private final GraphicObjectPanel panel;
    private final CommandHandler handler;
    private int id;
    private double posFloat;

    public Scale(GraphicObjectPanel panel, CommandHandler handler, int id, float posFloat) {
        this.panel = panel;
        this.handler = handler;
        this.id = id;
        this.posFloat = posFloat;
    }

    @Override
    public void interpreta(ActionEvent e) {
        new ScaleObjectAction(panel, handler, id, posFloat).actionPerformed(e);
    }
}
