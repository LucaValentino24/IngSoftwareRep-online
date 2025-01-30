package manipolatoreOggetti.finestra;

import manipolatoreOggetti.interpreteComandi.*;
import manipolatoreOggetti.command.HistoryCommandHandler;
import manipolatoreOggetti.command.NaiveCommandHandler;
import manipolatoreOggetti.model.CircleObject;
import manipolatoreOggetti.model.GroupObject;
import manipolatoreOggetti.model.ImageObject;
import manipolatoreOggetti.model.RectangleObject;
import manipolatoreOggetti.view.*;

import javax.swing.*;
import java.awt.*;
import java.io.StringReader;

public class Finestra extends JFrame {

    private final int LENGTH = 1000;
    private final int HEIGHT = 800;
    private boolean full = true;
    private final GraphicObjectPanel panel = new GraphicObjectPanel();
    private final HistoryCommandHandler historyHandler = new HistoryCommandHandler();
    private final NaiveCommandHandler naiveHandler = new NaiveCommandHandler();

    public Finestra(){
        super();
        init(LENGTH, HEIGHT,full);
    }

    public Finestra(String title){
        super(title);
        init(LENGTH, HEIGHT,full);
    }

    public Finestra(String title, boolean full){
        super(title);
        init(LENGTH, HEIGHT,full);
    }

    public Finestra(String title, int length, int height){
        super(title);
        init(length, height,full);
    }

    private void init(int length, int height, boolean full){
        panel.setPreferredSize(new Dimension(length,height));
        this.add(panel,BorderLayout.CENTER);
        if(full)
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        GraphicObjectViewFactory.FACTORY.installView(RectangleObject.class, new RectangleObjectView());
        GraphicObjectViewFactory.FACTORY.installView(CircleObject.class, new CircleObjectView());
        GraphicObjectViewFactory.FACTORY.installView(ImageObject.class, new ImageObjectView());
        GraphicObjectViewFactory.FACTORY.installView(GroupObject.class, new GroupObjectView());

        JTextPane textPane = new JTextPane();
        textPane.setEditable(false);
        getContentPane().add(textPane,BorderLayout.SOUTH);
        textPane.setSize(length,200);

        JTextField campoTesto = new JTextField();
        getContentPane().add(campoTesto, BorderLayout.NORTH);
        campoTesto.setSize(length,50);
        campoTesto.addActionListener(e -> {
            String comando = campoTesto.getText();
            StringReader sr = new StringReader(comando);
            RicercaComandi rc = new RicercaComandi(sr,panel, historyHandler, naiveHandler);
            ComandoIF com = rc.getComando();
            if(com instanceof ListC){
                ListC l = (ListC) com;
                l.interpreta(e);
                textPane.setText(l.getOut());
            }
            else if (com instanceof Perimeter){
                Perimeter p = (Perimeter) com;
                p.interpreta(e);
                textPane.setText(p.getOut());
            }
            else if (com instanceof Area){
                Area a = (Area) com;
                a.interpreta(e);
                textPane.setText(a.getOut());
            }
            else
                com.interpreta(e);
        });


        this.setSize(length, height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
