package manipolatoreOggetti.view;

import manipolatoreOggetti.model.*;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class GroupObjectView implements GraphicObjectView{

    @Override
    public void drawGraphicObject(GraphicObject go, Graphics2D g) {
        GroupObject go2 = (GroupObject)go;
        for(GraphicObject go2Obj : go2.getObjects()) {
            if(go2Obj instanceof GroupObject)
                drawGraphicObject(go2Obj, g);
            else if(go2Obj instanceof CircleObject){
                CircleObject co = (CircleObject) go2Obj;
                Point2D position = co.getPosition();
                double r = co.getRadius();
                double x = position.getX() - r;
                double y = position.getY() - r;
                g.draw(new Ellipse2D.Double(x, y, r * 2.0, r * 2.0));
            }
            else if(go2Obj instanceof ImageObject){
                ImageObject io = (ImageObject) go2Obj;
                Dimension2D dim = io.getDimension();
                Point2D position = io.getPosition();
                Image image = io.getImage();
                int w = (int) (dim.getWidth());
                int h = (int) (dim.getHeight());
                int x = (int) (position.getX()) - w / 2;
                int y = (int) (position.getY()) - h / 2;

                g.drawImage(image, x, y, w, h, null);
            }
            else if(go2Obj instanceof RectangleObject){
                Point2D position = go2Obj.getPosition();
                Dimension2D dim = go2Obj.getDimension();
                double x = position.getX() - dim.getWidth() / 2.0;
                double y = position.getY() - dim.getHeight() / 2.0;
                g.draw(new Rectangle2D.Double(x, y, dim.getWidth(), dim.getHeight()));
            }
        }
    }
}
