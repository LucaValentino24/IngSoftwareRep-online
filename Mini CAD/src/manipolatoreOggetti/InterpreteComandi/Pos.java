package manipolatoreOggetti.InterpreteComandi;

import java.awt.geom.Point2D;

public class Pos {

    private float posFloat1;
    private float posFloat2;

    public Pos(float posFloat1, float posFloat2) {
        this.posFloat1 = posFloat1;
        this.posFloat2 = posFloat2;
    }

    public Point2D getPos(){
        return new Point2D.Float(posFloat1, posFloat2);
    }
}
