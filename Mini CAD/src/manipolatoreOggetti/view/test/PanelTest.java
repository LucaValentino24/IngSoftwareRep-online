package manipolatoreOggetti.view.test;

import manipolatoreOggetti.model.CircleObject;
import manipolatoreOggetti.model.GraphicObject;
import manipolatoreOggetti.view.GraphicObjectPanel;
import org.junit.jupiter.api.*;

import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

public class PanelTest {

    private GraphicObjectPanel panel;

    @BeforeEach
    public void setUp(){
        System.out.println("Inizializzazione del panel");
        panel = new GraphicObjectPanel();
    }

    @Test
    @DisplayName("aggiunge correttamente un graphic Object al panel")
    public void addTest(){
        GraphicObject g = new CircleObject(new Point2D.Float(100,100),20,1);
        panel.add(g);
        assertFalse(panel.objects.isEmpty());
        assertFalse(panel.ids.isEmpty());
        assertTrue(panel.objects.contains(g));
        assertTrue(panel.ids.contains(1));
    }

    @Test
    @DisplayName("rimuove correttamente un graphic object dal panel")
    public void removeTest(){
        GraphicObject g = new CircleObject(new Point2D.Float(100,100),20,1);
        panel.add(g);
        assertFalse(panel.objects.isEmpty());
        assertFalse(panel.ids.isEmpty());
        panel.remove(g);
        assertTrue(panel.objects.isEmpty());
        assertTrue(panel.ids.isEmpty());
        panel.add(g);
        panel.remove(1);
        assertTrue(panel.objects.isEmpty());
        assertTrue(panel.ids.isEmpty());
    }

    @Test
    @DisplayName("containsObject test")
    public void containsObjectTest(){
        GraphicObject g1 = new CircleObject(new Point2D.Float(100,100),20,1);
        GraphicObject g2 = new CircleObject(new Point2D.Float(300,200),20,2);
        panel.add(g1);
        panel.add(g2);
        assertTrue(panel.objects.contains(g1));
        assertTrue(panel.containsObject(g1));
        assertTrue(panel.objects.contains(g2));
        assertTrue(panel.containsObject(g2));
        panel.remove(g1);
        assertFalse(panel.objects.contains(g1));
        assertFalse(panel.containsObject(g1));
    }
}
