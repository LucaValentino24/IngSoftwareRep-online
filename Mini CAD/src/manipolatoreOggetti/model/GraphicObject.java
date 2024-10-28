package manipolatoreOggetti.model;

import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public interface GraphicObject extends Cloneable {

	void addGraphicObjectListener(GraphicObjectListener l);

	void removeGraphicObjectListener(GraphicObjectListener l);

	void moveTo(Point2D p);

	default void moveTo(double x, double y){
		moveTo(new Point2D.Double(x, y));
	}

	Point2D getPosition();

	Dimension2D getDimension();

	void scale(double factor);

	boolean contains(Point2D p);

	String getType();

	int getId();

	GraphicObject clone();

	String getProp();

	double getPerimeter();

	double getArea();
}
