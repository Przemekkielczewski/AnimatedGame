package pl.przemek.Model.Units;

import java.awt.image.BufferedImage;

import pl.przemek.Model.Weapons.MachineGun;
import pl.przemek.Model.Weapons.MediumGun;

public class MainTank extends AbstractUnit {

	public MainTank(int posX, int posY, BufferedImage image1,
			BufferedImage image2) {
		super.name = "Main Tank";
		super.image = image1;
		super.image2 = image2;
		super.posX = posX;
		super.posY = posY;
		super.structure = 4;
		super.armour = 3;
		super.speed = 2;
		super.defaultSpeed = 2;
		super.mainWeapon = new MediumGun();
		super.secondaryWeapon = new MachineGun();
		super.description = "Main Tanks are designed to provide\n"
				+ " heavy firepower on the battlefield. They have\n"
				+ "thick armour and pretty good range";
	}

}