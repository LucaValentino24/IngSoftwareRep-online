package manipolatoreOggetti.view;

import manipolatoreOggetti.InterpreteComandi.Pos;
import manipolatoreOggetti.command.CommandHandler;
import manipolatoreOggetti.model.AbstractGraphicObject;
import manipolatoreOggetti.model.GraphicObject;
import manipolatoreOggetti.specificcommand.MoveCommand;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.geom.Point2D;

public class MoveOffObjectAction extends AbstractAction {

    private GraphicObjectPanel panel;
    private CommandHandler handler;
    private int id;
    private Pos pos;

    public MoveOffObjectAction(GraphicObjectPanel panel, CommandHandler handler, int id, Pos pos) {
        this.panel = panel;
        this.handler = handler;
        this.id = id;
        this.pos = pos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GraphicObject go = panel.getGraphicObjectFromId(id);
        handler.handle(new MoveCommand(go, new Point2D.Double(go.getPosition().getX() + pos.getPos().getX(), go.getPosition().getY() + pos.getPos().getY())));
    }
}
