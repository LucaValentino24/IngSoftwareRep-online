package manipolatoreOggetti.view;

import manipolatoreOggetti.command.CommandHandler;
import manipolatoreOggetti.specificcommand.PerimeterCommand;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PerimeterObjectAction extends AbstractAction {

    private GraphicObjectPanel panel;
    private CommandHandler handler;
    private int id;
    private String in;
    private double out;

    public PerimeterObjectAction(GraphicObjectPanel panel, CommandHandler handler, int id, String in) {
        this.panel = panel;
        this.handler = handler;
        this.id = id;
        this.in = in;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PerimeterCommand command;
        if (id > -1) {
            command = new PerimeterCommand(panel, id);
        }
        else {
            command = new PerimeterCommand(panel, in);
        }
        handler.handle(command);
        out = command.getOut();
    }

    public double getOut(){
        return out;
    }

}
