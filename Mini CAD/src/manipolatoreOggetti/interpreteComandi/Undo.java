package manipolatoreOggetti.interpreteComandi;

import manipolatoreOggetti.command.HistoryCommandHandler;

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
