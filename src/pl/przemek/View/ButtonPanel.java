package pl.przemek.View;

import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {

	private Image upImage;
	private Image downImage;
	private Image leftImage;
	private Image rightImage;
	private Image attackImage;
	private Image undoImage;
	private Image infoImage;
	private Image menuImage;
	private Image endImage;

	private JButton leftButton;
	private JButton rightButton;
	private JButton upButton;
	private JButton downButton;
	private JButton attackButton;
	private JButton undoButton;
	private JButton infoButton;	
	private JButton menuButton;
	private JButton endButton;

	ButtonPanel() {
		try {
			upImage = ImageIO.read(new File(
					"Resources\\ButtonUp.jpg"));
			downImage = ImageIO.read(new File(
					"Resources\\ButtonDown.jpg"));
			leftImage = ImageIO.read(new File(
					"Resources\\ButtonLeft.jpg"));
			rightImage = ImageIO.read(new File(
					"Resources\\ButtonRight.jpg"));
			attackImage = ImageIO.read(new File(
					"Resources\\ButtonAttack.jpg"));
			undoImage = ImageIO.read(new File(
					"Resources\\ButtonUndo.jpg"));
			infoImage = ImageIO.read(new File(
					"Resources\\ButtonInfo.jpg"));
			menuImage = ImageIO.read(new File(
					"Resources\\ButtonMenu.jpg"));
			endImage = ImageIO.read(new File(
					"Resources\\ButtonEnd.jpg"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		leftButton = new JButton(new ImageIcon(leftImage));
		rightButton = new JButton(new ImageIcon(rightImage));
		upButton = new JButton(new ImageIcon(upImage));
		downButton = new JButton(new ImageIcon(downImage));
		attackButton = new JButton(new ImageIcon(attackImage));
		undoButton = new JButton(new ImageIcon(undoImage));
		infoButton = new JButton(new ImageIcon(infoImage));
		menuButton = new JButton(new ImageIcon(menuImage));
		endButton = new JButton(new ImageIcon(endImage));
		this.add(leftButton);
		this.add(rightButton);
		this.add(upButton);
		this.add(downButton);
		this.add(undoButton);
		this.add(attackButton);
		this.add(infoButton);
		this.add(menuButton);
		this.add(endButton);
	}
	
	public void addUpListener (ActionListener actionListener) {
		this.upButton.addActionListener(actionListener);
	}
	
	public void addDownListener (ActionListener actionListener) {
		this.downButton.addActionListener(actionListener);
	}
	
	public void addLeftListener (ActionListener actionListener) {
		this.leftButton.addActionListener(actionListener);
	}
	
	public void addRightListener (ActionListener actionListener) {
		this.rightButton.addActionListener(actionListener);
	}
	
	public void addUndoListener (ActionListener actionListener) {
		this.undoButton.addActionListener(actionListener);
	}
	
	public void addInfoListener (ActionListener actionListener) {
		this.infoButton.addActionListener(actionListener);
	}
	
	public void addAttackListener (ActionListener actionListener) {
		this.attackButton.addActionListener(actionListener);
	}
	
	public void addMenuListener (ActionListener actionListener) {
		this.menuButton.addActionListener(actionListener);
	}
	
	public void addEndListener (ActionListener actionListener) {
		this.endButton.addActionListener(actionListener);
	}
}