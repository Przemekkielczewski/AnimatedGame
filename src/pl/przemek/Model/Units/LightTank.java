package pl.przemek.Model.Units;

import java.awt.image.BufferedImage;

import pl.przemek.Model.Weapons.LightGun;
import pl.przemek.Model.Weapons.MachineGun;

public class LightTank extends AbstractUnit {

	public LightTank(int posX, int posY, BufferedImage image1,
			BufferedImage image2) {
		super.name = "Light Tank";
		super.image = image1;
		super.image2 = image2;
		super.posX = posX;
		super.posY = posY;
		super.structure = 4;
		super.armour = 2;
		super.speed = 3;
		super.defaultSpeed = 3;
		super.mainWeapon = new LightGun();
		super.secondaryWeapon = new MachineGun();
		super.description = "";
	}

}
