package manipolatoreOggetti.interpreteComandi;

import manipolatoreOggetti.command.CommandHandler;
import manipolatoreOggetti.view.GraphicObjectPanel;
import manipolatoreOggetti.objectAction.MoveOffObjectAction;

import java.awt.event.ActionEvent;

public class MoveOff extends Move{

    public MoveOff(GraphicObjectPanel panel, CommandHandler handler, int id, Pos pos){
        super(panel, handler, id, pos);
    }

    @Override
    public void interpreta(ActionEvent e) {
        new MoveOffObjectAction(panel,handler,id,pos).actionPerformed(e);
    }
}
