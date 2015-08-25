package pl.przemek.View;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuFrame extends JFrame {

	private JPanel buttonPanel;
	private JButton missionOneButton;
	private JButton missionTwoButton;
	private JButton restartButton;
	private JButton briefingOneButton;
	private JButton briefingTwoButton;
	private JButton quitMenuButton;
	private JButton quitGameButton;
	
	//restart
	public MenuFrame () {
		this.setTitle("Menu");
		this.setSize(200, 300);
		this.setLayout(new GridLayout(1,1));
		
		missionOneButton = new JButton ("mission one");
		missionOneButton.setEnabled(false);
		briefingOneButton = new JButton ("first Briefing");
		missionTwoButton = new JButton ("mission two");
		missionTwoButton.setEnabled(false);
		briefingTwoButton = new JButton ("second Briefing");
		briefingTwoButton.setEnabled(false);
		restartButton = new JButton ("restart mission");
		restartButton.setEnabled(false);
		quitMenuButton = new JButton ("quit menu");
		quitGameButton = new JButton ("quit game");
		buttonPanel = new JPanel();
		buttonPanel.add(missionOneButton);
		buttonPanel.add(briefingOneButton);
		buttonPanel.add(missionTwoButton);
		buttonPanel.add(briefingTwoButton);
		buttonPanel.add(restartButton);
		buttonPanel.add(quitMenuButton);
		buttonPanel.add(quitGameButton);
		this.add(buttonPanel);
	}
	
	public void addMissionOneListener(ActionListener actionListener) {
		this.missionOneButton.addActionListener(actionListener);
	}
	
	public void addBriefingOneListener(ActionListener actionListener) {
		this.briefingOneButton.addActionListener(actionListener);
	}
	
	public void addMissionTwoListener(ActionListener actionListener) {
		this.missionTwoButton.addActionListener(actionListener);
	}
	
	public void addBriefingTwoListener(ActionListener actionListener) {
		this.briefingTwoButton.addActionListener(actionListener);
	}
	
	public void addRestartListener(ActionListener actionListener) {
		this.restartButton.addActionListener(actionListener);
	}
	
	public void addQuitGameListener(ActionListener actionListener) {
		this.quitGameButton.addActionListener(actionListener);
	}
	
	public void addQuitMenuListener(ActionListener actionListener) {
		this.quitMenuButton.addActionListener(actionListener);
	}
	
}
