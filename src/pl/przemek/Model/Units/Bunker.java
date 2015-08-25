package pl.przemek.Model.Units;

import java.awt.image.BufferedImage;
import pl.przemek.Model.Weapons.AutoCannon;
import pl.przemek.Model.Weapons.NavalCannon;

public class Bunker extends AbstractUnit {

	// int Size = 2;

	public Bunker(int posX, int posY, BufferedImage image1, BufferedImage image2) {
		super.name = "Bunker";
		super.image = image1;
		super.image2 = image2;
		super.posX = posX;
		super.posY = posY;
		super.structure = 10;
		super.armour = 5;
		super.speed = 0;
		super.defaultSpeed = 0;
		super.mainWeapon = new NavalCannon();
		super.secondaryWeapon = new AutoCannon();
		super.description = "Bunkers are heavy fortified buildings\n "
				+ " made from reinforced concrete. They usually \n"
				+ "protect important infrastructure or house big guns";
	}

}
