package pl.przemek.View;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AttackFrame extends JFrame {

	private JLabel targetName;
	private JTextField targetNameField;
	private JLabel targetDistance;
	private JTextField targetDistanceField;
	private JLabel targetStructure;
	private JTextField targetStructureField;
	private JLabel targetArmour;
	private JTextField targetArmourField;
	private JLabel targetSpeed;
	private JTextField targetSpeedField;
	public JButton mainWeaponButton;
	public JButton secondaryWeaponButton;
	public JButton confirmButton;
	public JButton cancelButton;
	private JLabel attackerName;
	private JTextField attackerNameField;
	private JLabel attackerMainWeapon;
	private JTextField attackerMainWeaponField;
	private JLabel attackerMainStrenght;
	private JTextField attackerMainStrenghtField;
	private JLabel attackerMainRange;
	private JTextField attackerMainRangeField;
	private JLabel attackerSecondaryWeapon;
	private JTextField attackerSecondaryWeaponField;
	private JLabel attackerSecondaryStrenght;
	private JTextField attackerSecondaryStrenghtField;
	private JLabel attackerSecondaryRange;
	private JTextField attackerSecondaryRangeField;
	private JPanel buttonPanel;
	private JPanel targetPanel;
	private JPanel attackerPanel;
	
	public AttackFrame () {
		this.setTitle("Attack");
		this.setSize (700, 200);
		this.setLayout(new GridLayout(1,3));
		
		targetName = new JLabel ("target name: ");
		targetNameField = new JTextField(14);
		targetNameField.setEditable(false);
		targetDistance = new JLabel ("target Distance: ");
		targetDistanceField = new JTextField(10);
		targetDistanceField.setEditable(false);
		targetStructure = new JLabel ("target structure: ");
		targetStructureField = new JTextField(10);
		targetStructureField.setEditable(false);
		targetArmour = new JLabel ("target armour: ");
		targetArmourField = new JTextField(10);
		targetArmourField.setEditable(false);
		targetSpeed = new JLabel ("target speed: ");
		targetSpeedField = new JTextField(10);
		targetSpeedField.setEditable(false);
		targetPanel = new JPanel(new GridLayout (5,2));
		targetPanel.add(targetName);
		targetPanel.add(targetNameField);
		targetPanel.add(targetDistance);
		targetPanel.add(targetDistanceField);
		targetPanel.add(targetStructure);
		targetPanel.add(targetStructureField);
		targetPanel.add(targetArmour);
		targetPanel.add(targetArmourField);
		targetPanel.add(targetSpeed);
		targetPanel.add(targetSpeedField);
		
		confirmButton = new JButton ("confirm target");
		mainWeaponButton = new JButton("attack - main weapon");
		secondaryWeaponButton = new JButton("attack - secondary weapon");
		cancelButton = new JButton ("cancel attack");
		buttonPanel = new JPanel ();
		attackerPanel = new JPanel();
		buttonPanel.add(confirmButton);
		buttonPanel.add(mainWeaponButton);
		buttonPanel.add(secondaryWeaponButton);
		buttonPanel.add(cancelButton);
		
		attackerName = new JLabel ("attacker name: ");
		attackerNameField = new JTextField(14);
		attackerNameField.setEditable(false);
		attackerMainWeapon = new JLabel ("main weapon: ");
		attackerMainWeaponField = new JTextField(10);
		attackerMainWeaponField.setEditable(false);
		attackerMainStrenght = new JLabel ("strenght: ");
		attackerMainStrenghtField = new JTextField(10);
		attackerMainStrenghtField.setEditable(false);
		attackerMainRange = new JLabel ("range: ");
		attackerMainRangeField = new JTextField(10);
		attackerMainRangeField.setEditable(false);
		attackerSecondaryWeapon = new JLabel ("secondary weapon: ");
		attackerSecondaryWeaponField = new JTextField(10);
		attackerSecondaryWeaponField.setEditable(false);
		attackerSecondaryStrenght = new JLabel ("strenght: ");
		attackerSecondaryStrenghtField = new JTextField(10);
		attackerSecondaryStrenghtField.setEditable(false);
		attackerSecondaryRange = new JLabel ("range: ");
		attackerSecondaryRangeField = new JTextField(10);
		attackerSecondaryRangeField.setEditable(false);
		attackerPanel = new JPanel(new GridLayout (7,2));
		attackerPanel.add(attackerName);
		attackerPanel.add(attackerNameField);
		attackerPanel.add(attackerMainWeapon);
		attackerPanel.add(attackerMainWeaponField);
		attackerPanel.add(attackerMainStrenght);
		attackerPanel.add(attackerMainStrenghtField);
		attackerPanel.add(attackerMainRange);
		attackerPanel.add(attackerMainRangeField);
		attackerPanel.add(attackerSecondaryWeapon);
		attackerPanel.add(attackerSecondaryWeaponField);
		attackerPanel.add(attackerSecondaryStrenght);
		attackerPanel.add(attackerSecondaryStrenghtField);
		attackerPanel.add(attackerSecondaryRange);
		attackerPanel.add(attackerSecondaryRangeField);
		
		this.add(targetPanel);
		this.add(buttonPanel);
		this.add(attackerPanel);
	}
	
	public void setTargetNameField(String name){
		this.targetNameField.setText(name);
	}
	
	public void setTargetDistanceField(String distance){
		this.targetDistanceField.setText(distance);
	}
	
	public void setTargetStructureField(String structure){
		this.targetStructureField.setText(structure);
	}
	
	public void setTargetArmourField(String armour){
		this.targetArmourField.setText(armour);
	}
	
	public void setTargetSpeedField(String speed){
		this.targetSpeedField.setText(speed);
	}
	
	public void addConfirmTargetListener (ActionListener actionListener) {
		this.confirmButton.addActionListener(actionListener);
	}
	
	public void addAttackMainWeaponListener (ActionListener actionListener) {
		this.mainWeaponButton.addActionListener(actionListener);
	}
	
	public void addAttackSecondaryWeaponListener (ActionListener actionListener) {
		this.secondaryWeaponButton.addActionListener(actionListener);
	}
	
	public void addAttackCancelListener (ActionListener actionListener) {
		this.cancelButton.addActionListener(actionListener);
	}
	
	public void setAttackerNameField(String name){
		this.attackerNameField.setText(name);
	}
	
	public void setMainWeaponField(String mainWeapon){
		this.attackerMainWeaponField.setText(mainWeapon);
	}
	
	public void setMainWeaponStrenght(String mainWeapon){
		this.attackerMainStrenghtField.setText(mainWeapon);
	}
	
	public void setMainWeaponRange(String mainWeapon){
		this.attackerMainRangeField.setText(mainWeapon);
	}
	
	public void setSecondaryWeaponField(String secondaryWeapon){
		this.attackerSecondaryWeaponField.setText(secondaryWeapon);
	}
	
	public void setSecondaryWeaponStrenght(String mainWeapon){
		this.attackerSecondaryStrenghtField.setText(mainWeapon);
	}
	
	public void setSecondaryWeaponRange(String mainWeapon){
		this.attackerSecondaryRangeField.setText(mainWeapon);
	}
	
	public JButton getMainWeaponButton () {
		return mainWeaponButton;
	}
	
	public JButton getSecondaryWeaponButton () {
		return secondaryWeaponButton;
	}
	
	public JButton getConfirmButton () {
		return confirmButton;
	}
	
	public JButton getCancelButton () {
		return cancelButton;
	}
}
