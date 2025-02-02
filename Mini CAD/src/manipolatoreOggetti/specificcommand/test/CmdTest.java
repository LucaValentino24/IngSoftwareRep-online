package manipolatoreOggetti.specificcommand.test;

import manipolatoreOggetti.command.Command;
import manipolatoreOggetti.model.CircleObject;
import manipolatoreOggetti.model.GraphicObject;
import manipolatoreOggetti.model.GroupObject;
import manipolatoreOggetti.specificcommand.GrpCommand;
import manipolatoreOggetti.specificcommand.MoveCommand;
import manipolatoreOggetti.specificcommand.NewObjectCmd;
import manipolatoreOggetti.specificcommand.UnGrpCommand;
import manipolatoreOggetti.view.GraphicObjectPanel;
import org.junit.jupiter.api.*;

import java.awt.geom.Point2D;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class CmdTest {

    GraphicObjectPanel panel;

    @BeforeEach
    public void setUp() {
        panel = new GraphicObjectPanel();
    }

    @Test
    @DisplayName("Prova del comando new")
    public void newCmdTest(){
        Point2D pos = new Point2D.Double(100, 100);
        GraphicObject go = new CircleObject(pos,20,1);
        Command cmd = new NewObjectCmd(panel,go,pos);
        assertTrue(panel.objects.isEmpty() && panel.ids.isEmpty());
        assertTrue(cmd.doIt());
        assertFalse(panel.objects.isEmpty());
        assertTrue(panel.containsObject(go));
        assertFalse(panel.ids.isEmpty());
    }

    @Test
    @DisplayName("Prova del comando grp")
    public void groupCmdTest(){
        Point2D pos1 = new Point2D.Double(100, 100);
        Point2D pos2 = new Point2D.Double(200, 100);
        Point2D pos3 = new Point2D.Double(300, 100);
        GraphicObject go1 = new CircleObject(pos1,20,1);
        GraphicObject go2 = new CircleObject(pos2,20,2);
        GraphicObject go3 = new CircleObject(pos3,20,3);
        LinkedList<GraphicObject> objs = new LinkedList<>();
        objs.add(go1);
        objs.add(go2);
        objs.add(go3);
        Command cmd1 = new NewObjectCmd(panel,go1,pos1);
        cmd1.doIt();
        Command cmd2 = new NewObjectCmd(panel,go2,pos2);
        cmd2.doIt();
        Command cmd3 = new NewObjectCmd(panel,go3,pos3);
        cmd3.doIt();
        assertFalse(panel.objects.isEmpty() && panel.ids.isEmpty());
        Command cmd = new GrpCommand(objs, panel, 4);
        assertTrue(cmd.doIt());
        assertTrue(panel.ids.contains(4));
        assertTrue(panel.containsObject(panel.getGraphicObjectFromId(4)));
        Command ungrpCmd = new UnGrpCommand((GroupObject) panel.getGraphicObjectFromId(4),panel);
        assertTrue(ungrpCmd.doIt());
        assertFalse(panel.ids.contains(4));
        assertTrue(panel.containsObject(go1));
        assertTrue(panel.containsObject(go2));
        assertTrue(panel.containsObject(go3));
    }

    @Test
    @DisplayName("Prova del comando move")
    public void moveCmdTest(){
        Point2D pos1 = new Point2D.Double(100, 100);
        GraphicObject go1 = new CircleObject(pos1,20,1);
        Command cmd1 = new NewObjectCmd(panel,go1,pos1);
        assertTrue(cmd1.doIt());
        assertEquals(go1.getPosition(),pos1);
        Point2D pos2 = new Point2D.Double(200, 100);
        Command moveCmd = new MoveCommand(go1,pos2);
        assertTrue(moveCmd.doIt());
        assertEquals(go1.getPosition(), pos2);
    }
}
