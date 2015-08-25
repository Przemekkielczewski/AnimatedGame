package pl.przemek.Model.Units;

import java.awt.image.BufferedImage;
import pl.przemek.Model.Weapons.ATMissle;
import pl.przemek.Model.Weapons.MachineGun;

public class Gunship extends AbstractUnit {

	public Gunship(int posX, int posY, BufferedImage image1,
			BufferedImage image2) {
		super.name = "Gunship";
		super.image = image1;
		super.image2 = image2;
		super.posX = posX;
		super.posY = posY;
		super.structure = 3;
		super.armour = 1;
		super.speed = 5;
		super.defaultSpeed = 5;
		super.mainWeapon = new ATMissle();
		super.secondaryWeapon = new MachineGun();
		super.flying = true;
		super.description = "Gunships are used to destroy enemy armour.\n"
				+ " They are quite durable for air units, but have \n"
				+ "poor defense against jet fighters.";
	}

}