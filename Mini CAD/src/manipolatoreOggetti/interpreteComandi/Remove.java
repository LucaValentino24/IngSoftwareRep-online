package manipolatoreOggetti.interpreteComandi;

import manipolatoreOggetti.command.CommandHandler;
import manipolatoreOggetti.objectAction.DeleteObjectAction;
import manipolatoreOggetti.view.GraphicObjectPanel;

import java.awt.event.ActionEvent;

public class Remove implements ComandoIF{

    private final GraphicObjectPanel panel;
    private final CommandHandler handler;
    private int id;

    public Remove(int id, GraphicObjectPanel panel, CommandHandler handler) {
        this.id = id;
        this.panel = panel;
        this.handler = handler;
    }

    @Override
    public void interpreta(ActionEvent e) {
        new DeleteObjectAction(panel,handler,id).actionPerformed(e);
    }
}
