package pl.przemek.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import pl.przemek.Model.Model;
import pl.przemek.Model.Units.AbstractUnit;
import pl.przemek.View.AttackFrame;
import pl.przemek.View.MainFrame;
import pl.przemek.View.MenuFrame;
import pl.przemek.View.StatusPanel;
import pl.przemek.View.UnitsRegister;

public class Controller {

	private MainFrame mainView;
	private MenuFrame menuFrame;
	private AttackFrame attackFrame;
	private Model model;

	private int turn;
	private int mouseClickedX;
	private int mouseClickedY;
	private int unitPosX;
	private int unitPosY;
	private AbstractUnit chosenUnit;
	private AbstractUnit attackingUnit;
	private BufferedImage tempImage;

	public Controller(MainFrame mainView, Model model) {
		this.mainView = mainView;
		this.model = model;
		
		menuFrame = new MenuFrame();
		attackFrame = new AttackFrame();
		
		this.turn = 1;
		this.unitPosX = 0;
		this.unitPosY = 0;

		this.mainView.getMapComponent().addMouseListener(new MouseHandler());
		this.mainView.getButtonPanel().addLeftListener(new ListenerForLeft());
		this.mainView.getButtonPanel().addRightListener(new ListenerForRight());
		this.mainView.getButtonPanel().addUpListener(new ListenerForUp());
		this.mainView.getButtonPanel().addDownListener(new ListenerForDown());
		this.mainView.getButtonPanel().addUndoListener(new ListenerForUndo());
		this.mainView.getButtonPanel().addAttackListener(
				new ListenerForAttack());
		this.mainView.getButtonPanel().addInfoListener(new ListenerForInfo());
		this.mainView.getButtonPanel().addMenuListener(new ListenerForMenu());
		this.mainView.getButtonPanel().addEndListener(new ListenerForEnd());
		this.attackFrame
				.addAttackMainWeaponListener(new ListenerForAttackMain());
		this.attackFrame
				.addAttackSecondaryWeaponListener(new ListenerForAttackSecondary());
		this.attackFrame.addAttackCancelListener(new ListenerForAttackCancel());
		this.attackFrame.addConfirmTargetListener(new ListenerForConfirm());
		this.menuFrame.addBriefingOneListener(new ListenerForBriefingOne());
		this.menuFrame.addQuitGameListener(new ListenerForExit());
		this.menuFrame.addQuitMenuListener(new ListenerForClose());
		
	}

	private UnitsRegister getUnitsRegister() {
		return mainView.getMapComponent().getUnitsRegister();
	}

	private StatusPanel getStatusPanel() {
		return mainView.getStatusPanel();
	}

	private class MouseHandler extends MouseAdapter {

		public void mousePressed(MouseEvent event) {

			if (chosenUnit != null && chosenUnit.isDestroyed() == false) {
				chosenUnit.setImage(tempImage);
			}

			mouseClickedX = event.getX();
			mouseClickedY = event.getY();

			chosenUnit = model.chooseUnit(mouseClickedX, mouseClickedY,
					getUnitsRegister());
			model.setStatusPanel(getStatusPanel(), chosenUnit);

			unitPosX = chosenUnit.getPosX();
			unitPosY = chosenUnit.getPosY();

			if (chosenUnit.isDestroyed() == false) {
				tempImage = chosenUnit.getImage();
				chosenUnit.setImage(chosenUnit.getImageChosen());
				mainView.getMapComponent().repaint();
			}
		}
	}

	private class ListenerForLeft implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			model.moveLeft(chosenUnit, getUnitsRegister());
			mainView.getStatusPanel().setSpeedField(chosenUnit.getSpeed());
			mainView.getMapComponent().repaint();
		}
	}

	private class ListenerForRight implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			model.moveRight(chosenUnit, getUnitsRegister());
			mainView.getStatusPanel().setSpeedField(chosenUnit.getSpeed());
			mainView.getMapComponent().repaint();
		}
	}

	private class ListenerForUp implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			model.moveUp(chosenUnit, getUnitsRegister());
			mainView.getStatusPanel().setSpeedField(chosenUnit.getSpeed());
			mainView.getMapComponent().repaint();
		}
	}

	private class ListenerForDown implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			model.moveDown(chosenUnit, getUnitsRegister());
			mainView.getStatusPanel().setSpeedField(chosenUnit.getSpeed());
			mainView.getMapComponent().repaint();
		}
	}

	private class ListenerForUndo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (chosenUnit.hasAttacked() == false) {
				model.undo(chosenUnit, unitPosX, unitPosY);
				mainView.getMapComponent().repaint();
			}
		}
	}

	private class ListenerForAttack implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			attackingUnit = chosenUnit;
			if (attackingUnit.hasAttacked() == false) {
				attackFrame.mainWeaponButton.setEnabled(true);
				attackFrame.secondaryWeaponButton.setEnabled(true);
			} else {
				attackFrame.mainWeaponButton.setEnabled(false);
				attackFrame.secondaryWeaponButton.setEnabled(false);
			}
			model.setAttackerPanel(attackFrame, chosenUnit);
			attackFrame.setVisible(true);
			attackFrame.setAlwaysOnTop(true);
		}
	}

	private class ListenerForInfo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane
					.showMessageDialog(mainView, chosenUnit.getDescription());
		}
	}

	private class ListenerForMenu implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			menuFrame.setVisible(true);
		}
	}

	private class ListenerForEnd implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			model.endTurn(getUnitsRegister(), mainView, turn);
			turn = turn + 1;
		}
	}

	private class ListenerForConfirm implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			model.checkRange(attackingUnit, chosenUnit);
			model.setTargetPanel(attackFrame, chosenUnit);
			attackFrame.repaint();
		}
	}

	private class ListenerForAttackMain implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (attackingUnit != chosenUnit) {

				if (attackingUnit.hasAttacked() == false) {
					attackFrame.mainWeaponButton.setEnabled(true);
				}
				model.attack(attackingUnit, chosenUnit, 
						getUnitsRegister(), 1, mainView);
				getStatusPanel().setStructureField(
						chosenUnit.getStructureText());
				attackingUnit.setAttacked(true);
				attackFrame.setVisible(false);

				if (chosenUnit.isDestroyed() == false) {
					chosenUnit.setImage(tempImage);
				}
				model.clearAttackerPanel(attackFrame);
				model.clearTargetPanel(attackFrame);
				mainView.getMapComponent().repaint();
				attackingUnit = null;
				chosenUnit = null;
			}
		}
	}

	private class ListenerForAttackSecondary implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			if (attackingUnit != chosenUnit) {

				model.attack(attackingUnit, chosenUnit, 
						getUnitsRegister(), 2, mainView);
				getStatusPanel().setStructureField(
						chosenUnit.getStructureText());
				attackingUnit.setAttacked(true);
				attackFrame.setVisible(false);

				if (chosenUnit.isDestroyed() == false) {
					chosenUnit.setImage(tempImage);
				}
				model.clearAttackerPanel(attackFrame);
				model.clearTargetPanel(attackFrame);
				mainView.getMapComponent().repaint();
				attackingUnit = null;
				chosenUnit = null;
			}
		}
	}

	private class ListenerForAttackCancel implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			model.clearAttackerPanel(attackFrame);
			model.clearTargetPanel(attackFrame);
			attackFrame.setVisible(false);
		}
	}

	private class ListenerForExit implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
	}

	private class ListenerForClose implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			menuFrame.setVisible(false);
			menuFrame.setAlwaysOnTop(true);
		}
	}

	private class ListenerForBriefingOne implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			model.BriefingOne(menuFrame);
		}
	}
}