package manipolatoreOggetti.objectAction;

import manipolatoreOggetti.command.CommandHandler;
import manipolatoreOggetti.specificcommand.ListCommand;
import manipolatoreOggetti.view.GraphicObjectPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ListObjectAction extends AbstractAction {

    private GraphicObjectPanel panel;
    private CommandHandler handler;
    private int id;
    private String in;
    private String out;

    public ListObjectAction(GraphicObjectPanel panel, CommandHandler handler, int id, String in) {
        this.panel = panel;
        this.handler = handler;
        this.id = id;
        this.in = in;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ListCommand command;
        if (id > -1) {
            command = new ListCommand(panel, id);
        }
        else {
            command = new ListCommand(panel, in);
        }
        handler.handle(command);
        out = command.getOut();
    }

    public String getOut(){
        return out;
    }
}
