package manipolatoreOggetti.view;

import manipolatoreOggetti.command.CommandHandler;
import manipolatoreOggetti.specificcommand.AreaCommand;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AreaObjectAction implements ActionListener {

    private GraphicObjectPanel panel;
    private CommandHandler handler;
    private int id;
    private String in;
    private double out;

    public AreaObjectAction(GraphicObjectPanel panel, CommandHandler handler, int id, String in) {
        this.panel = panel;
        this.handler = handler;
        this.id = id;
        this.in = in;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AreaCommand command;
        if (id > -1) {
            command = new AreaCommand(panel, id);
        }
        else {
            command = new AreaCommand(panel, in);
        }
        handler.handle(command);
        out = command.getOut();
    }

    public double getOut(){
        return out;
    }
}
