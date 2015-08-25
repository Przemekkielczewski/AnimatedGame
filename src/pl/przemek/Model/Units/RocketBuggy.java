package pl.przemek.Model.Units;

import java.awt.image.BufferedImage;
import pl.przemek.Model.Weapons.ATMissle;
import pl.przemek.Model.Weapons.MachineGun;

public class RocketBuggy extends AbstractUnit {

	public RocketBuggy(int posX, int posY, BufferedImage image1,
			BufferedImage image2) {
		super.name = "Rocket Buggy";
		super.image = image1;
		super.image2 = image2;
		super.posX = posX;
		super.posY = posY;
		super.structure = 3;
		super.armour = 1;
		super.speed = 3;
		super.defaultSpeed = 3;
		super.mainWeapon = new ATMissle();
		super.secondaryWeapon = new MachineGun();
		super.description = "Rocket Buggy is light assault unit. \n"
				+ "It can quickly deliver heavy firepower, \n"
				+ "but is fragile to enemy counterattacks";
	}

}
