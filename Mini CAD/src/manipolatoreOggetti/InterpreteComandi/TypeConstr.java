package manipolatoreOggetti.InterpreteComandi;


import manipolatoreOggetti.model.AbstractGraphicObject;

import java.awt.geom.Point2D;

public abstract class TypeConstr{

    public abstract AbstractGraphicObject getPrototype(Point2D pos, int id);
}
