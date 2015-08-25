package pl.przemek.Model;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import pl.przemek.Model.Units.AbstractUnit;
import pl.przemek.Model.Units.Bunker;
import pl.przemek.Model.Weapons.AbstractWeapon;
import pl.przemek.View.AttackFrame;
import pl.przemek.View.MenuFrame;
import pl.przemek.View.StatusPanel;
import pl.przemek.View.UnitsRegister;

public class Model {

	CollisionsModule collisions = new CollisionsModule();

	private AbstractUnit chosenUnit;
	private Integer range;

	public void setStatusPanel(StatusPanel statusPanel, AbstractUnit unit) {
		statusPanel.setNameField(unit.getName());
		statusPanel.setStructureField(unit.getStructureText());
		statusPanel.setSpeedField(unit.getSpeed());
		statusPanel.setArmourField(unit.getArmourText());
		statusPanel.setMainWeaponField(unit.getMainWeapon().getDescription());
		statusPanel.setSecondaryWeaponField(unit.getSecondaryWeapon()
				.getDescription());
	}

	public void setAttackerPanel(AttackFrame attackFrame, AbstractUnit unit) {
		attackFrame.setAttackerNameField(unit.getName());
		attackFrame.setMainWeaponField(unit.getMainWeapon().getName());
		attackFrame
				.setMainWeaponStrenght(unit.getMainWeapon().getStringPower());
		attackFrame.setMainWeaponRange(unit.getMainWeapon().getStringRange());
		attackFrame
				.setSecondaryWeaponField(unit.getSecondaryWeapon().getName());
		attackFrame.setSecondaryWeaponStrenght(unit.getSecondaryWeapon()
				.getStringPower());
		attackFrame.setSecondaryWeaponRange(unit.getSecondaryWeapon()
				.getStringRange());
	}

	public void clearAttackerPanel(AttackFrame attackFrame) {
		attackFrame.setAttackerNameField("");
		attackFrame.setMainWeaponField("");
		attackFrame.setMainWeaponStrenght("");
		attackFrame.setMainWeaponRange("");
		attackFrame.setSecondaryWeaponField("");
		attackFrame.setSecondaryWeaponStrenght("");
		attackFrame.setSecondaryWeaponRange("");
	}

	public void setTargetPanel(AttackFrame attackFrame, AbstractUnit unit) {
		attackFrame.setTargetNameField(unit.getName());
		attackFrame.setTargetDistanceField(range.toString());
		attackFrame.setTargetStructureField(unit.getStructureText());
		attackFrame.setTargetArmourField(unit.getArmourText());
		attackFrame.setTargetSpeedField(unit.getSpeed());
		// dorób target
	}

	public void clearTargetPanel(AttackFrame attackFrame) {
		attackFrame.setTargetNameField("");
		attackFrame.setTargetDistanceField("");
		attackFrame.setTargetStructureField("");
		attackFrame.setTargetArmourField("");
		attackFrame.setTargetSpeedField("");
		// dorób target
	}

	public AbstractUnit chooseUnit(int mouseClickedX, int mouseClickedY,
			UnitsRegister register) {
		for (int i = 0; i < register.getListSize(); i++) {

			if (mouseClickedX >= register.getUnit(i).getPosX()
					&& mouseClickedX <= register.getUnit(i).getPosX() + 62
					&& mouseClickedY >= register.getUnit(i).getPosY()
					&& mouseClickedY <= register.getUnit(i).getPosY() + 58) {

				chosenUnit = register.getUnit(i);
			}
		}
		return chosenUnit;
	}

	public void moveLeft(AbstractUnit abstractUnit, UnitsRegister register) {
		if (this.collisions.collisionLeft(abstractUnit, register) == false) {
			abstractUnit.moveLeft(1);
		}
	}

	public void moveRight(AbstractUnit abstractUnit, UnitsRegister register) {
		if (this.collisions.collisionRight(abstractUnit, register) == false) {
			abstractUnit.moveRight(1);
		}
	}

	public void moveUp(AbstractUnit abstractUnit, UnitsRegister register) {
		if (this.collisions.collisionUp(abstractUnit, register) == false) {
			abstractUnit.moveUp(1);
		}
	}

	public void moveDown(AbstractUnit abstractUnit, UnitsRegister register) {
		if (this.collisions.collisionDown(abstractUnit, register) == false) {
			abstractUnit.moveDown(1);
		}
	}

	public void checkRange(AbstractUnit abstractUnit, AbstractUnit targetUnit) {
		range = Math
				.abs((abstractUnit.getPosX() / 62 - targetUnit.getPosX() / 62))
				+ Math.abs((abstractUnit.getPosY() / 58 - targetUnit.getPosY() / 58));
	}

	public void attack(AbstractUnit abstractUnit, AbstractUnit targetUnit,
			UnitsRegister register, int weaponNumber, JFrame frame) {

		AbstractWeapon weapon;

		if (weaponNumber == 1) {
			weapon = abstractUnit.getMainWeapon();
		} else {
			weapon = abstractUnit.getSecondaryWeapon();
		}

		if (weapon.getRange() >= range && targetUnit.isFlying() == false
				|| weapon.getRange() >= range
				&& weapon.isAttackingFlying() == true) {

			targetUnit.setStructure(targetUnit.getStructure()
					+ targetUnit.getArmour() - weapon.getPower());
			if (targetUnit.getStructure() < 0) {
				targetUnit.setStructure(0);
			}
		}

		if (targetUnit.getStructure() == 0
				&& targetUnit.getName().equals("Bunker")) {
			targetUnit.setImage(register.getDestroyedBunkerImage());
			targetUnit.setDestroyed();
			JOptionPane.showMessageDialog(frame,
					"Congratulations you have destroyed \n"
							+ "the bunker. Now the ships will \n"
							+ "be able to sail through.");
		} else if (targetUnit.getStructure() == 0) {
			targetUnit.setImage(register.getDestroyedUnitImage());
			targetUnit.setDestroyed();
		}
	}

	public void undo(AbstractUnit unit, int posX, int posY) {
		if (unit.hasAttacked() == false) {
			unit.setDefaultSpeed();
			unit.setPosX(posX);
			unit.setPosY(posY);
		}

	}

	public void BriefingOne(MenuFrame menuFrame) {
		JOptionPane.showMessageDialog(menuFrame,
				"Our scouts found a bunker located at \n"
						+ " strategic riverside that prohibits any \n"
						+ " boat transport in this sector. The \n"
						+ "bunker is large, heavily fortified and \n"
						+ "has enough firepower to engage and \n"
						+ "destroy any river boats we have. Your \n"
						+ " mission is to destory the bunker. \n"
						+ "Enemy can send reinforcements to this \n"
						+ "sector, but our intelligence shows you \n"
						+ "will have plenty of time before they arrive.");
	}

	public void endTurn(UnitsRegister register, JFrame frame, int turn) {
		for (int i = 0; i < register.getListSize(); i++) {
			if (register.getUnit(i).isDestroyed() == false) {
				register.getUnit(i).setDefaultSpeed();
				register.getUnit(i).setAttacked(false);
			}
		}
		if (turn == 14) {
			JOptionPane.showMessageDialog(frame,
					"Enemy reinforcements have arrived \n"
							+ "and you had to withdraw without \n"
							+ "completing mission objective.");
			System.exit(0);
		}
	}
}
