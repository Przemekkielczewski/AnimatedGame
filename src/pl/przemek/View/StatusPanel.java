package pl.przemek.View;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StatusPanel extends JPanel {
	
	private JLabel nameLabel;
	private JTextField nameField;
	private JLabel structureLabel;
	private JTextField structureField;
	private JLabel armourLabel;
	private JTextField armourField;
	private JLabel speedLabel;
	private JTextField speedField;
	private JLabel mainWeaponLabel;
	private JTextField mainWeaponField;
	private JLabel secondaryWeaponLabel;
	private JTextField secondaryWeaponField;
	
	public StatusPanel () {
		
		nameLabel = new JLabel("Type: ");
		nameField = new JTextField (14);
		nameField.setEditable(false);
		structureLabel = new JLabel ("Structure: ");
		structureField = new JTextField(2);
		structureField.setEditable(false);
		armourLabel = new JLabel ("Armour: ");
		armourField = new JTextField(2);
		armourField.setEditable(false);
		speedLabel = new JLabel ("Speed: ");
		speedField = new JTextField(2);
		speedField.setEditable(false);
		mainWeaponLabel = new JLabel ("Weapon 1: ");
		mainWeaponField = new JTextField(10);
		mainWeaponField.setEditable(false);
		secondaryWeaponLabel = new JLabel ("Weapon 2: ");
		secondaryWeaponField = new JTextField(10);
		secondaryWeaponField.setEditable(false);
		
		this.add(nameLabel);
		this.add(nameField);
		this.add(structureLabel);
		this.add(structureField);
		this.add(armourLabel);
		this.add(armourField);
		this.add(speedLabel);
		this.add(speedField);
		this.add(mainWeaponLabel);
		this.add(mainWeaponField);
		this.add(secondaryWeaponLabel);
		this.add(secondaryWeaponField);	
	}
	
	public void setNameField(String name){
		this.nameField.setText(name);
	}
	
	public void setStructureField(String structure){
		this.structureField.setText(structure);
	}
	
	public void setArmourField(String armour){
		this.armourField.setText(armour);
	}
	
	public void setSpeedField(String speed){
		this.speedField.setText(speed);
	}
	
	public void setMainWeaponField(String mainWeapon){
		this.mainWeaponField.setText(mainWeapon);
	}
	
	public void setSecondaryWeaponField(String secondaryWeapon){
		this.secondaryWeaponField.setText(secondaryWeapon);
	}
}
