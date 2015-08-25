package pl.przemek.Model.Units;

import java.awt.image.BufferedImage;

import pl.przemek.Model.Weapons.AutoCannon;
import pl.przemek.Model.Weapons.HeavyGun;

public class HeavyTank extends AbstractUnit {

	public HeavyTank(int posX, int posY, BufferedImage image1,
			BufferedImage image2) {
		super.name = "Heavy Tank";
		super.image = image1;
		super.image2 = image2;
		super.posX = posX;
		super.posY = posY;
		super.structure = 5;
		super.armour = 4;
		super.speed = 2;
		super.defaultSpeed = 2;
		super.mainWeapon = new HeavyGun();
		super.secondaryWeapon = new AutoCannon();
		super.description = "";
	}

}
