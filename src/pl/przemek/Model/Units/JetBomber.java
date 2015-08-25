package pl.przemek.Model.Units;

import java.awt.image.BufferedImage;
import pl.przemek.Model.Weapons.AAMissle;
import pl.przemek.Model.Weapons.BunkerBomb;

public class JetBomber extends AbstractUnit {

	public JetBomber(int posX, int posY, BufferedImage image1,
			BufferedImage image2) {
		super.name = "Jet Bomber";
		super.image = image1;
		super.image2 = image2;
		super.posX = posX;
		super.posY = posY;
		super.structure = 4;
		super.armour = 0;
		super.speed = 8;
		super.defaultSpeed = 8;
		super.mainWeapon = new BunkerBomb();
		super.secondaryWeapon = new AAMissle();
		super.flying = true;
		super.description = "Jet Bombers are used for delivering \n"
				+ "the heavy hitting weapons mainly against \n"
				+ "buildings and other large targets";
	}

}
