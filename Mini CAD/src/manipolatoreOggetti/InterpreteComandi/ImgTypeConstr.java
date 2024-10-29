package manipolatoreOggetti.InterpreteComandi;

import manipolatoreOggetti.model.ImageObject;

import javax.swing.*;
import java.awt.geom.Point2D;

public class ImgTypeConstr extends TypeConstr{

    private String path;

    public ImgTypeConstr(String path){
        this.path = path;
    }

    public ImageObject getPrototype(Point2D pos, int id){
        return new ImageObject(new ImageIcon(path),pos,id);
    }
}
