package manipolatoreOggetti.objectAction;

import manipolatoreOggetti.interpreteComandi.Pos;
import manipolatoreOggetti.command.CommandHandler;
import manipolatoreOggetti.specificcommand.MoveCommand;
import manipolatoreOggetti.view.GraphicObjectPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MoveObjectAction extends AbstractAction {

    private GraphicObjectPanel panel;
    private CommandHandler handler;
    private int id;
    private Pos pos;

    public MoveObjectAction(GraphicObjectPanel panel, CommandHandler handler, int id, Pos pos) {
        this.panel = panel;
        this.handler = handler;
        this.id = id;
        this.pos = pos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        handler.handle(new MoveCommand(panel.getGraphicObjectFromId(id), pos.getPos()));
    }
}
