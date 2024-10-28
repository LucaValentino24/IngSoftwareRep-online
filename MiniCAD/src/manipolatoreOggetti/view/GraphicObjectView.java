package manipolatoreOggetti.view;

import manipolatoreOggetti.model.GraphicObject;

import java.awt.*;

public interface GraphicObjectView {
	void drawGraphicObject(GraphicObject go, Graphics2D g);
}
