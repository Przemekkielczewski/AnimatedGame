package pl.przemek.View;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

import pl.przemek.Model.Units.AbstractUnit;

public class MapComponent extends JComponent {

	private BufferedImage map;
	private UnitsRegister unitsRegister;
	
	public MapComponent() {
		unitsRegister = new UnitsRegister();
		
		try {
			map = ImageIO.read(new File("Resources\\Mars.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paintComponent(Graphics g) {

		g.drawImage(map, 0, 0, null);
		
		for (int i = 0; i < unitsRegister.getListSize(); i++) {	
			this.drawUnit(unitsRegister.getUnit(i), g);
		}
	}

	public void drawUnit(AbstractUnit unit, Graphics w) {
		w.drawImage(unit.getImage(), unit.getPosX(), unit.getPosY(), null);
	}

	public UnitsRegister getUnitsRegister() {
		return this.unitsRegister;
	}

}
