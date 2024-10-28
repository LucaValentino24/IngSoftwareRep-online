package manipolatoreOggetti.model;

import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.util.*;

public class GroupObject extends AbstractGraphicObject{

    private Point2D position;

    private List<GraphicObject> objects = new LinkedList<>();

    public GroupObject(int id,Point2D position) {
        super(id);
        this.position = position;
    }


    @Override
    public boolean contains(Point2D p){
        for(GraphicObject o : objects)
            if(o.contains(p))
                return true;
        return false;
    }

    @Override
    public String getType() {
        return "Group";
    }

    @Override
    public void moveTo(Point2D p){
        for(GraphicObject o : objects){
            double distanceX = Math.abs(position.getX()-o.getPosition().getX());
            double distanceY = Math.abs(position.getY()-o.getPosition().getY());
            o.moveTo(p.getX()+distanceX, p.getY()+distanceY);
        }
        position.setLocation(p);
        notifyListeners(new GraphicEvent(this));
    }

    @Override
    public Point2D getPosition(){
        return new Point2D.Double(position.getX(), position.getY());
    }

    @Override
    public Dimension2D getDimension() {
        return null;
    }

    @Override
    public void scale(double factor){
        for(GraphicObject o : objects)
            o.scale(factor);
    }

    public GroupObject clone(){
        GroupObject cloned = (GroupObject)super.clone();
        cloned.position = (Point2D)position.clone();
        cloned.objects = new LinkedList<>(objects);
        for(GraphicObject o : objects)
            cloned.objects.add(o.clone());
        return cloned;
    }

    public LinkedList<GraphicObject> getObjects(){
        LinkedList<GraphicObject> cloned = new LinkedList<>();
        cloned.addAll(objects);
        return cloned;
    }


    public void addObject(GraphicObject o){
        objects.add(o);
    }

    public void removeObject(GraphicObject o){
        objects.remove(o);
    }

    public void removeAllObjects(){
        objects.clear();
    }

    @Override
    public String getProp() {
        StringBuilder ret = new StringBuilder("gruppo -> id: ");
        ret.append(getId()).append(", formato da:\n");
        for(GraphicObject o : objects)
            ret.append(o.getProp()).append("\n");
        return ret.toString();
    }

    @Override
    public double getPerimeter() {
        double ret = 0;
        for (GraphicObject o : objects)
            ret += o.getPerimeter();
        return ret;
    }

    @Override
    public double getArea() {
        double ret = 0;
        for (GraphicObject o : objects)
            ret += o.getArea();
        return ret;
    }
}
