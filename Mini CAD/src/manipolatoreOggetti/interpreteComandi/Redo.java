package manipolatoreOggetti.interpreteComandi;

import manipolatoreOggetti.command.HistoryCommandHandler;

import java.awt.event.ActionEvent;

public class Redo implements ComandoIF{

    private final HistoryCommandHandler handler;

    public Redo(HistoryCommandHandler handler) {
        this.handler = handler;
    }

    @Override
    public void interpreta(ActionEvent e) {
        handler.redo();
    }
}
