package manipolatoreOggetti.view;

import manipolatoreOggetti.command.CommandHandler;
import manipolatoreOggetti.model.GroupObject;
import manipolatoreOggetti.specificcommand.UnGrpCommand;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class UnGrpObjectAction extends AbstractAction {

    private GraphicObjectPanel panel;
    private CommandHandler handler;
    private GroupObject group;

    public UnGrpObjectAction(GraphicObjectPanel panel, CommandHandler handler, GroupObject group) {
        this.panel = panel;
        this.handler = handler;
        this.group = group;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        handler.handle(new UnGrpCommand(group,panel));
    }
}
