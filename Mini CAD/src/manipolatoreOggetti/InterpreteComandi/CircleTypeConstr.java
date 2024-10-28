package manipolatoreOggetti.InterpreteComandi;

import manipolatoreOggetti.model.CircleObject;

import java.awt.geom.Point2D;

public class CircleTypeConstr extends TypeConstr {

    private float posFloat;

    public CircleTypeConstr(float posFloat) {
        this.posFloat = posFloat;
    }

    public CircleObject getPrototype(Point2D pos, int id){
        return new CircleObject(pos,posFloat,id);
    }
}
