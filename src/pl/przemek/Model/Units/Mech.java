package pl.przemek.Model.Units;

import java.awt.image.BufferedImage;
import pl.przemek.Model.Weapons.AAMissle;
import pl.przemek.Model.Weapons.AutoCannon;

public class Mech extends AbstractUnit {

	public Mech(int posX, int posY, BufferedImage image1, BufferedImage image2) {
		super.name = "Mech";
		super.image = image1;
		super.image2 = image2;
		super.posX = posX;
		super.posY = posY;
		super.structure = 4;
		super.armour = 2;
		super.speed = 1;
		super.defaultSpeed = 1;
		super.mainWeapon = new AAMissle();
		super.secondaryWeapon = new AutoCannon();
		super.description = "Mechs are durable, universal units, \n"
				+ "good for any terrain. They are \n"
				+ "especially effective against aircrafts";
	}

}
