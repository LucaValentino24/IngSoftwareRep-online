package manipolatoreOggetti.view;

import manipolatoreOggetti.command.CommandHandler;
import manipolatoreOggetti.specificcommand.ZoomCommand;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ScaleObjectAction extends AbstractAction {

    private GraphicObjectPanel panel;
    private CommandHandler handler;
    private int id;
    private double factor = 1;

    public ScaleObjectAction(GraphicObjectPanel panel, CommandHandler handler, int id, double factor) {
        this.panel = panel;
        this.handler = handler;
        this.id = id;
        this.factor = factor;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        handler.handle(new ZoomCommand(panel.getGraphicObjectFromId(id),factor));
    }
}
