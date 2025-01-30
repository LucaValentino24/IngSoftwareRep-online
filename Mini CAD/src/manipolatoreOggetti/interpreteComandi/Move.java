package manipolatoreOggetti.interpreteComandi;

import manipolatoreOggetti.command.CommandHandler;
import manipolatoreOggetti.view.GraphicObjectPanel;
import manipolatoreOggetti.objectAction.MoveObjectAction;

import java.awt.event.ActionEvent;

public class Move implements ComandoIF{

    final GraphicObjectPanel panel;
    final CommandHandler handler;
    int id;
    Pos pos;

    public Move(GraphicObjectPanel panel, CommandHandler handler, int id, Pos pos) {
        this.panel = panel;
        this.handler = handler;
        this.id = id;
        this.pos = pos;
    }

    @Override
    public void interpreta(ActionEvent e) {
        new MoveObjectAction(panel, handler, id, pos).actionPerformed(e);
    }
}
