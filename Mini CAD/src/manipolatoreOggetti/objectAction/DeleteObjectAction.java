package manipolatoreOggetti.objectAction;

import manipolatoreOggetti.command.CommandHandler;
import manipolatoreOggetti.specificcommand.DelObjectCmd;
import manipolatoreOggetti.view.GraphicObjectPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DeleteObjectAction extends AbstractAction {

    GraphicObjectPanel panel;
    CommandHandler handler;
    int id;

    public DeleteObjectAction(GraphicObjectPanel panel, CommandHandler handler, int id) {
        super();
        this.panel = panel;
        this.handler = handler;
        this.id = id;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        handler.handle(new DelObjectCmd(panel,panel.getGraphicObjectFromId(id)));
    }
}
