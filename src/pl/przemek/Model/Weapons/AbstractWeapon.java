package pl.przemek.Model.Weapons;

public class AbstractWeapon {

	protected String name;
	protected Integer power;
	protected Integer range;
	protected boolean attackflying = false;

	public String getName() {
		return name;
	}

	public int getPower() {
		return power;
	}

	public int getRange() {
		return range;
	}
	
	public boolean isAttackingFlying () {
		return this.attackflying;
	}

	public String getDescription() {
		return this.name + "(" + this.power.toString() + ")" + "("
				+ this.range.toString() + ")";
	}

	public String getStringPower() {
		return power.toString();
	}

	public String getStringRange() {
		return range.toString();
	}
}
