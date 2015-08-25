package pl.przemek.Model.Units;

import java.awt.image.BufferedImage;
import pl.przemek.Model.Weapons.AbstractWeapon;

public class AbstractUnit {

	protected String name;
	protected BufferedImage image;
	protected BufferedImage image2;
	protected int posX;
	protected int posY;
	protected Integer structure;
	protected Integer armour;
	protected Integer speed;
	protected Integer defaultSpeed;
	protected AbstractWeapon mainWeapon;
	protected AbstractWeapon secondaryWeapon;
	protected boolean flying = false;
	protected boolean destroyed = false;
	protected boolean attacked = false;
	protected String description;
	//atak w zale¿noœci od kategorii celu - isFlying, isNaval, isLand

	public String getName() {
		return this.name;
	}

	public BufferedImage getImage() {
		return this.image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public BufferedImage getImageChosen() {
		return this.image2;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosX() {
		return this.posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getPosY() {
		return this.posY;
	}

	public void setStructure(int structure) {
		this.structure = structure;
	}

	public int getStructure() {
		return this.structure;
	}

	public String getStructureText() {
		return this.structure.toString();
	}

	public int getArmour() {
		return this.armour;
	}

	public String getArmourText() {
		return this.armour.toString();
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setDefaultSpeed() {
		this.speed = this.defaultSpeed;
	}

	public String getSpeed() {
		return this.speed.toString();
	}

	public AbstractWeapon getMainWeapon() {
		return mainWeapon;
	}

	public AbstractWeapon getSecondaryWeapon() {
		return secondaryWeapon;
	}

	public String getDescription() {
		return description;
	}

	public boolean isFlying() {
		return this.flying;
	}
	
	public boolean isDestroyed() {
		return this.destroyed;
	}

	public void setDestroyed() {
		this.destroyed = true;
		this.speed = 0;
		this.hasAttacked();
	}

	public boolean hasAttacked() {
		return this.attacked;
	}

	public void setAttacked(boolean flag) {
		this.attacked = flag;
	}

	public void moveUp(int cost) {
		if (this.speed > 0 && this.speed >= cost) {
			this.posY = posY - 58;
			this.speed = this.speed - cost;
		}
	}

	public void moveDown(int cost) {
		if (this.speed > 0 && this.speed >= cost) {
			this.posY = posY + 58;
			this.speed = this.speed - cost;
		}
	}

	public void moveLeft(int cost) {
		if (this.speed > 0 && this.speed >= cost) {
			this.posX = posX - 62;
			this.speed = this.speed - cost;
		}
	}

	public void moveRight(int cost) {
		if (this.speed > 0 && this.speed >= cost) {
			this.posX = posX + 62;
			this.speed = this.speed - cost;
		}
	}
}
