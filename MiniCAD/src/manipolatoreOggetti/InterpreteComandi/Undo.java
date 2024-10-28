package manipolatoreOggetti.InterpreteComandi;

import manipolatoreOggetti.command.HistoryCommandHandler;
import manipolatoreOggetti.view.GraphicObjectPanel;

import java.awt.event.ActionEvent;

public class Undo implements ComandoIF{

    private final HistoryCommandHandler handler;

    public Undo(HistoryCommandHandler handler) {
        this.handler = handler;
    }

    @Override
    public void interpreta(ActionEvent e) {
        handler.undo();
    }
}
