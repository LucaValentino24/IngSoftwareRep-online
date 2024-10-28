package manipolatoreOggetti.InterpreteComandi;

import manipolatoreOggetti.command.CommandHandler;
import manipolatoreOggetti.view.CreateObjectAction;
import manipolatoreOggetti.view.GraphicObjectPanel;

import java.awt.event.ActionEvent;

public class Create implements ComandoIF {

    private TypeConstr typeConstr;
    private Pos pos;
    private int id;
    private GraphicObjectPanel panel;
    private CommandHandler handler;

    public Create(TypeConstr typeConstr, Pos pos, int id,GraphicObjectPanel panel, CommandHandler handler){
        this.typeConstr = typeConstr;
        this.pos = pos;
        this.id = id;
        this.panel = panel;
        this.handler = handler;
    }

    @Override
    public void interpreta(ActionEvent e) {
        new CreateObjectAction(typeConstr.getPrototype(pos.getPos(), id), panel, handler, pos.getPos()).actionPerformed(e);
    }
}
