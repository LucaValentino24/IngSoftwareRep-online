package manipolatoreOggetti.InterpreteComandi;

import manipolatoreOggetti.command.HistoryCommandHandler;
import manipolatoreOggetti.command.NaiveCommandHandler;
import manipolatoreOggetti.model.GraphicObject;
import manipolatoreOggetti.view.GraphicObjectPanel;

import java.io.Reader;
import java.util.LinkedList;

public class RicercaComandi {

    private AnalizzatoreLessicale lexer;
    private Simboli simbolo;
    private int id = 0;
    private GraphicObjectPanel panel;
    private HistoryCommandHandler historyHandler;
    private NaiveCommandHandler naiveHandler;
    private String lettura;

    public RicercaComandi(Reader in, GraphicObjectPanel panel, HistoryCommandHandler historyHandler, NaiveCommandHandler naiveHandler) {
        lexer = new AnalizzatoreLessicale(in);
        simbolo = lexer.prossimoSimbolo();
        this.historyHandler = historyHandler;
        this.panel = panel;
        this.naiveHandler = naiveHandler;
    }

    public ComandoIF getComando() {
        if(simbolo == Simboli.NEW)
            return getCreateCommand();
        else if (simbolo == Simboli.DEL)
            return getRemoveCommand();
        else if (simbolo == Simboli.MV)
            return getMoveCommand();
        else if (simbolo == Simboli.MVOFF)
            return getMoveOffCommand();
        else if (simbolo == Simboli.SCALE)
            return getScaleCommand();
        else if (simbolo == Simboli.GRP)
            return getGrpCommand();
        else if (simbolo == Simboli.UNGRP)
            return getUnGrpCommand();
        else if (simbolo == Simboli.UNDO)
            return undo();
        else if (simbolo == Simboli.REDO)
            return redo();
        else if (simbolo == Simboli.LS)
            return getListCommand();
        else if (simbolo == Simboli.PERIMETER)
            return getPerimeterCommand();
        else if (simbolo == Simboli.AREA)
            return getAreaCommand();
        return null;
    }

    private Create getCreateCommand(){
        simbolo = lexer.prossimoSimbolo();
        if(simbolo == Simboli.CIRCLE){
            simbolo = lexer.prossimoSimbolo();
            atteso(Simboli.TONDA_APERTA);
            atteso(Simboli.NUMERO);
            while(simbolo == Simboli.NUMERO || simbolo == Simboli.PUNTO)
                simbolo = lexer.prossimoSimbolo();
            float posFloat = lexer.getNumero();
            atteso(Simboli.TONDA_CHIUSA);
            Pos pos = pos();
            int id = id();
            return new Create(new CircleTypeConstr(posFloat),pos, id, panel, historyHandler);
        }
        else if(simbolo == Simboli.RECTANGLE){
            simbolo = lexer.prossimoSimbolo();
            Pos pos1 = pos();
            Pos pos2 = pos();
            int id = id();
            return new Create(new RectangleTypeConstr(pos1),pos2, id, panel, historyHandler);
        }
        else if(simbolo == Simboli.IMG){
            simbolo = lexer.prossimoSimbolo();
            atteso(Simboli.TONDA_APERTA);
            atteso(Simboli.PATH);
            while(simbolo == Simboli.PATH || simbolo == Simboli.PUNTO)
                simbolo = lexer.prossimoSimbolo();
            atteso(Simboli.TONDA_CHIUSA);
            String path = lexer.getPath();
            Pos pos = pos();
            int id = id();
            return new Create(new ImgTypeConstr(path),pos,id, panel, historyHandler);
        }
        throw new SyntaxException("errore");
    }

    private Remove getRemoveCommand() {
        simbolo = lexer.prossimoSimbolo();
        int id = id();
        return new Remove(id, panel, historyHandler);
    }

    private Move getMoveCommand() {
        simbolo = lexer.prossimoSimbolo();
        int id = id();
        Pos pos = pos();
        return new Move(panel, historyHandler, id, pos);
    }

    private MoveOff getMoveOffCommand(){
        simbolo = lexer.prossimoSimbolo();
        int id = id();
        Pos pos = pos();
        return new MoveOff(panel, historyHandler, id, pos);
    }

    private Scale getScaleCommand(){
        simbolo = lexer.prossimoSimbolo();
        int id = id();
        atteso(Simboli.VIRGOLA);
        atteso(Simboli.NUMERO);
        while(simbolo == Simboli.NUMERO || simbolo == Simboli.PUNTO)
            simbolo = lexer.prossimoSimbolo();
        float scale = lexer.getNumero();
        return new Scale(panel, historyHandler, id, scale);
    }

    private Group getGrpCommand(){
        simbolo = lexer.prossimoSimbolo();
        atteso(Simboli.TONDA_APERTA);
        LinkedList<GraphicObject> listaOggetti = new LinkedList<>();
        int id = id();
        listaOggetti.add(panel.getGraphicObjectFromId(id));
        while(simbolo == Simboli.VIRGOLA){
            simbolo = lexer.prossimoSimbolo();
            int id1=id();
            listaOggetti.add(panel.getGraphicObjectFromId(id1));
        }
        atteso(Simboli.TONDA_CHIUSA);
        int idfin = id();
        return new Group(panel, historyHandler,listaOggetti,idfin);
    }

    private Ungroup getUnGrpCommand(){
        simbolo = lexer.prossimoSimbolo();
        int id = id();
        return new Ungroup(panel, historyHandler,id);
    }

    private Undo undo(){
        return new Undo(historyHandler);
    }

    private Redo redo(){
        return new Redo(historyHandler);
    }

    private ListC getListCommand(){
        simbolo = lexer.prossimoSimbolo();
        if(simbolo == Simboli.NUMERO){
            int id = id();
            ListC list = new ListC(id, panel, naiveHandler);
            return list;
        }
        else if(simbolo == Simboli.CIRCLE) {
            ListC list = new ListC("circle", panel, naiveHandler);
            return list;
        }
        else if(simbolo == Simboli.RECTANGLE){
            ListC list = new ListC("rectangle", panel, naiveHandler);
            return list;
        }
        else if(simbolo == Simboli.IMG) {
            ListC list = new ListC("image", panel, naiveHandler);
            return list;
        }
        else if(simbolo == Simboli.ALL){
            ListC list = new ListC("all", panel, naiveHandler);
            return list;
        }
        else if (simbolo == Simboli.GROUPS){
            ListC list = new ListC("groups", panel, naiveHandler);
            return list;
        }
        throw new SyntaxException("valore non atteso");
    }

    private Perimeter getPerimeterCommand(){
        simbolo = lexer.prossimoSimbolo();
        if(simbolo == Simboli.NUMERO){
            int id = id();
            return new Perimeter(id, panel, naiveHandler);
        }
        else if(simbolo == Simboli.CIRCLE) {
            return new Perimeter("circle", panel, naiveHandler);
        }
        else if(simbolo == Simboli.RECTANGLE){
            return new Perimeter("rectangle", panel, naiveHandler);
        }
        else if(simbolo == Simboli.IMG) {
            return new Perimeter("image", panel, naiveHandler);
        }
        else if(simbolo == Simboli.ALL){
            return new Perimeter("all", panel, naiveHandler);
        }
        else if (simbolo == Simboli.GROUPS){
            return new Perimeter("groups", panel, naiveHandler);
        }
        throw new SyntaxException("valore non atteso");
    }

    private Area getAreaCommand(){
        simbolo = lexer.prossimoSimbolo();
        if(simbolo == Simboli.NUMERO){
            int id = id();
            return new Area(id, panel, naiveHandler);
        }
        else if(simbolo == Simboli.CIRCLE) {
            return new Area("circle", panel, naiveHandler);
        }
        else if(simbolo == Simboli.RECTANGLE){
            return new Area("rectangle", panel, naiveHandler);
        }
        else if(simbolo == Simboli.IMG) {
            return new Area("image", panel, naiveHandler);
        }
        else if(simbolo == Simboli.ALL){
            return new Area("all", panel, naiveHandler);
        }
        else if (simbolo == Simboli.GROUPS){
            return new Area("groups", panel, naiveHandler);
        }
        throw new SyntaxException("valore non atteso");
    }

    private Pos pos() {
        atteso(Simboli.TONDA_APERTA);
        atteso(Simboli.NUMERO);
        while(simbolo == Simboli.NUMERO || simbolo == Simboli.PUNTO)
            simbolo = lexer.prossimoSimbolo();
        float pos1 = lexer.getNumero();
        atteso(Simboli.VIRGOLA);
        atteso(Simboli.NUMERO);
        while(simbolo == Simboli.NUMERO || simbolo == Simboli.PUNTO)
            simbolo = lexer.prossimoSimbolo();
        float pos2 = lexer.getNumero();
        atteso(Simboli.TONDA_CHIUSA);
        Pos ret = new Pos(pos1,pos2);
        return ret;
    }

    private int id(){
        atteso(Simboli.NUMERO);
        while(simbolo == Simboli.NUMERO)
            simbolo = lexer.prossimoSimbolo();
        int id = lexer.getNumeroInt();
        return id;
    }

    private void atteso(Simboli s){
        if (simbolo != s) {
            String msg = " trovato " + simbolo + " mentre si attendeva " + s;
            throw new SyntaxException(msg);
        }
        simbolo = lexer.prossimoSimbolo();
    }
}
