package manipolatoreOggetti.interpreteComandi;

import manipolatoreOggetti.command.CommandHandler;
import manipolatoreOggetti.model.GroupObject;
import manipolatoreOggetti.view.GraphicObjectPanel;
import manipolatoreOggetti.objectAction.UnGrpObjectAction;

import java.awt.event.ActionEvent;

public class Ungroup implements ComandoIF{

    private final GraphicObjectPanel panel;
    private final CommandHandler handler;
    private int id;

    public Ungroup(GraphicObjectPanel panel, CommandHandler handler, int id) {
        this.panel = panel;
        this.handler = handler;
        this.id = id;
    }

    @Override
    public void interpreta(ActionEvent e) {
        new UnGrpObjectAction(panel,handler, (GroupObject) panel.getGraphicObjectFromId(id)).actionPerformed(e);
    }
}
