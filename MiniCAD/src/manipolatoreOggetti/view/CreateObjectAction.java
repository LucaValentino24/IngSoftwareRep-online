package manipolatoreOggetti.view;

import manipolatoreOggetti.command.CommandHandler;
import manipolatoreOggetti.model.AbstractGraphicObject;
import manipolatoreOggetti.model.GraphicObject;
import manipolatoreOggetti.specificcommand.NewObjectCmd;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.geom.Point2D;

public class CreateObjectAction extends AbstractAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5399493440620423134L;
	AbstractGraphicObject prototype;
	GraphicObjectPanel panel;
	CommandHandler ch;
	Point2D point ;

	public CreateObjectAction(AbstractGraphicObject prototype,
			GraphicObjectPanel panel, CommandHandler ch, Point2D point) {
		super();
		this.prototype = prototype;
		this.panel = panel;
		this.ch = ch;
		this.point = point;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		GraphicObject go = prototype.clone();
		ch.handle(new NewObjectCmd(panel, go, point));

	}

}
