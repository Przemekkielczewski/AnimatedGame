package pl.przemek.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.beans.PropertyVetoException;

import javax.swing.BorderFactory;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	
	private MapComponent mapComponent;
	private JPanel controlPanel;
	private ButtonPanel buttonPanel;
	private StatusPanel statusPanel;
	
	public MainFrame() {
		this.setTitle("WarGame");
		this.setSize(885, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		controlPanel = new JPanel();
		mapComponent = new MapComponent();
		buttonPanel = new ButtonPanel();
		statusPanel = new StatusPanel();
		controlPanel.setBorder(BorderFactory.createEtchedBorder());
		controlPanel.setLayout(new GridLayout (2,1));
		controlPanel.setBackground(Color.BLACK);
		controlPanel.add(buttonPanel);
		controlPanel.add(statusPanel);
		this.add(mapComponent, BorderLayout.CENTER);
		this.add(controlPanel, BorderLayout.SOUTH);
	}
	
	public JPanel getControlPanel () {
		return this.controlPanel;
	}
	
	public MapComponent getMapComponent () {
		return this.mapComponent;
	}
	
	public ButtonPanel getButtonPanel () {
		return this.buttonPanel;
	}
	
	public StatusPanel getStatusPanel () {
		return this.statusPanel;
	}
	
}