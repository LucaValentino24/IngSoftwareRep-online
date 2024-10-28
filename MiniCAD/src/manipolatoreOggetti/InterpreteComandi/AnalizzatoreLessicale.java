package manipolatoreOggetti.InterpreteComandi;

import java.io.*;

public class AnalizzatoreLessicale {

    private StreamTokenizer input;
    private Simboli simbolo;
    private String numero = "";
    private String path = "";

    public AnalizzatoreLessicale(Reader in){
        input = new StreamTokenizer(in);
        input.resetSyntax();
        input.eolIsSignificant(false);
        input.wordChars('a', 'z');
        input.wordChars('A', 'Z');
        input.wordChars('0', '9');
        input.parseNumbers();
        input.whitespaceChars('\u0000', ' ');
        input.ordinaryChar(':');
        input.ordinaryChar('-');
        input.ordinaryChar('.');
        input.ordinaryChar('"');
        input.ordinaryChar('(');
        input.ordinaryChar(')');
        input.ordinaryChar(',');
        input.ordinaryChar('/');
    }

    public Simboli prossimoSimbolo(){
        try{
            switch (input.nextToken()){
                case StreamTokenizer.TT_EOF:
                    simbolo = Simboli.EOF;
                    break;
                case StreamTokenizer.TT_WORD:
                    if(input.sval.equalsIgnoreCase("new"))
                        simbolo = Simboli.NEW;
                    else if(input.sval.equalsIgnoreCase("del"))
                        simbolo = Simboli.DEL;
                    else if(input.sval.equalsIgnoreCase("mv"))
                        simbolo = Simboli.MV;
                    else if(input.sval.equalsIgnoreCase("mvoff"))
                        simbolo = Simboli.MVOFF;
                    else if(input.sval.equalsIgnoreCase("scale"))
                        simbolo = Simboli.SCALE;
                    else if(input.sval.equalsIgnoreCase("ls"))
                        simbolo = Simboli.LS;
                    else if(input.sval.equalsIgnoreCase("all"))
                        simbolo = Simboli.ALL;
                    else if(input.sval.equalsIgnoreCase("Groups"))
                        simbolo = Simboli.GROUPS;
                    else if(input.sval.equalsIgnoreCase("grp"))
                        simbolo = Simboli.GRP;
                    else if(input.sval.equalsIgnoreCase("ungrp"))
                        simbolo = Simboli.UNGRP;
                    else if(input.sval.equalsIgnoreCase("area"))
                        simbolo = Simboli.AREA;
                    else if(input.sval.equalsIgnoreCase("perimeter"))
                        simbolo = Simboli.PERIMETER;
                    else if(input.sval.equalsIgnoreCase("circle"))
                        simbolo = Simboli.CIRCLE;
                    else if(input.sval.equalsIgnoreCase("rectangle"))
                        simbolo = Simboli.RECTANGLE;
                    else if(input.sval.equalsIgnoreCase("img"))
                        simbolo = Simboli.IMG;
                    else if(input.sval.equalsIgnoreCase("undo"))
                        simbolo = Simboli.UNDO;
                    else if(input.sval.equalsIgnoreCase("redo"))
                        simbolo = Simboli.REDO;
                    else {
                        simbolo = Simboli.PATH;
                        path = path.concat(input.sval);
                    }
                    break;
                case StreamTokenizer.TT_NUMBER:
                    simbolo = Simboli.NUMERO;
                    numero = numero.concat(String.valueOf(input.nval));
                    break;
                case '.':
                    simbolo = Simboli.PUNTO;
                    numero = numero.concat(".");
                    path = path.concat(".");
                    break;
                case ':':
                    simbolo = Simboli.PATH;
                    path = path.concat(":");
                    break;
                case '"':
                    simbolo = Simboli.PATH;
                    path = path.concat("\"");
                    break;
                case '/':
                    simbolo = Simboli.PATH;
                    path = path.concat("/");
                    break;
                case'-':
                    simbolo = Simboli.PATH;
                    path = path.concat("-");
                    break;
                case '(':
                    simbolo = Simboli.TONDA_APERTA;
                    break;
                case ')':
                    simbolo = Simboli.TONDA_CHIUSA;
                    break;
                case ',':
                    simbolo = Simboli.VIRGOLA;
                    break;
                default:
                    simbolo = Simboli.CHAR_INVALIDO;
            }
        } catch(IOException e){
            simbolo = Simboli.EOF;
        }
        return simbolo;
    }

    public float getNumero(){
        String ret = numero;
        numero = "";
        path = "";
        return Float.parseFloat(ret);
    }

    public int getNumeroInt(){
        String ret = numero;
        numero = "";
        path = "";
        return Math.round(Float.parseFloat(ret));
    }

    public String getPath(){
        String ret = path;
        path = "";
        numero = "";
        return ret;
    }
}