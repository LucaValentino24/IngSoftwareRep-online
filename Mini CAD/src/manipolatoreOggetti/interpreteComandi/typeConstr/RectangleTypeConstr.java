package manipolatoreOggetti.interpreteComandi.typeConstr;

import manipolatoreOggetti.interpreteComandi.Pos;
import manipolatoreOggetti.model.RectangleObject;

import java.awt.geom.Point2D;

public class RectangleTypeConstr extends TypeConstr{

    private Pos dim;

    public RectangleTypeConstr(Pos dim) {
        this.dim = dim;
    }

    public RectangleObject getPrototype(Point2D pos, int id){
        return new RectangleObject(pos,dim.getPos().getX(),dim.getPos().getY(),id);
    }
}
