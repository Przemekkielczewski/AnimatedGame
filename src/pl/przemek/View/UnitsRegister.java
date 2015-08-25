package pl.przemek.View;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import pl.przemek.Model.Units.AbstractUnit;
import pl.przemek.Model.Units.Bunker;
import pl.przemek.Model.Units.MainTank;
import pl.przemek.Model.Units.RocketBuggy;
import pl.przemek.Model.Units.Gunship;
import pl.przemek.Model.Units.JetBomber;
import pl.przemek.Model.Units.Mech;

public class UnitsRegister {

	// jednostki s¹ na tablicy, jeden obszar to 62 x 58
	private ArrayList<AbstractUnit> unitsList;
	private AbstractUnit mainTank1;
	private AbstractUnit mainTank2;
	private AbstractUnit mainTank3;
	private AbstractUnit mech1;
	private AbstractUnit mech2;
	private AbstractUnit mech3;
	private AbstractUnit mech4;
	private AbstractUnit bunker;

	private AbstractUnit buggy4;
	private AbstractUnit buggy5;
	private AbstractUnit buggy6;
	private AbstractUnit buggy7;
	private AbstractUnit buggy8;
	private AbstractUnit gunship1;
	private AbstractUnit gunship2;
	private AbstractUnit bomber1;
	private AbstractUnit bomber2;

	BufferedImage mainTankGrey;
	BufferedImage mainTankGreyChosen;
	BufferedImage mechGrey;
	BufferedImage mechGreyChosen;
	BufferedImage bunkerGrey;
	BufferedImage bunkerChosen;
	BufferedImage buggyGreen;
	BufferedImage buggyGreenChosen;
	BufferedImage gunshipGreen;
	BufferedImage gunshipGreenChosen;
	BufferedImage bomberGreen;
	BufferedImage bomberGreenChosen;
	BufferedImage wrecked;
	BufferedImage destroyedBunker;

	public UnitsRegister() {

		mainTankGrey = this.loadImage("mainTankGrey.jpg");
		mainTankGreyChosen = this.loadImage("mainTankGreyChosen.jpg");
		mechGrey = this.loadImage("MechGrey.jpg");
		mechGreyChosen = this.loadImage("MechGreyChosen.jpg");
		bunkerGrey = this.loadImage("Bunker.jpg");
		bunkerChosen = this.loadImage("BunkerChosen.jpg");
		buggyGreen = this.loadImage("BuggyGreen.jpg");
		buggyGreenChosen = this.loadImage("BuggyGreenChosen.jpg");
		gunshipGreen = this.loadImage("GunshipGreen.jpg");
		gunshipGreenChosen = this.loadImage("GunshipGreenChosen.jpg");
		bomberGreen = this.loadImage("BomberGreen.jpg");
		bomberGreenChosen = this.loadImage("BomberGreenChosen.jpg");
		wrecked = this.loadImage("Wrecked.jpg");
		destroyedBunker = this.loadImage("DestroyedBunker.jpg");

		
		//tablica = 10 x 14(58 x 62)
		unitsList = new ArrayList<AbstractUnit>();
		mainTank1 = new MainTank(124, 58, mainTankGrey, mainTankGreyChosen);
		mainTank2 = new MainTank(62, 116, mainTankGrey, mainTankGreyChosen);
		mainTank3 = new MainTank(62, 0, mainTankGrey, mainTankGreyChosen);
		mech1 = new Mech(0, 522, mechGrey, mechGreyChosen);
		mech2 = new Mech(186, 406, mechGrey, mechGreyChosen);
		mech3 = new Mech(62, 406, mechGrey, mechGreyChosen);
		mech4 = new Mech(0, 116, mechGrey, mechGreyChosen);
		bunker = new Bunker(186, 522, bunkerGrey, bunkerChosen);

		buggy4 = new RocketBuggy(744, 522, buggyGreen, buggyGreenChosen);
		buggy5 = new RocketBuggy(806, 464, buggyGreen, buggyGreenChosen);
		buggy6 = new RocketBuggy(806, 522, buggyGreen, buggyGreenChosen);
		buggy7 = new RocketBuggy(806, 290, buggyGreen, buggyGreenChosen);
		buggy8 = new RocketBuggy(744, 290, buggyGreen, buggyGreenChosen);
		gunship1 = new Gunship(620, 0, gunshipGreen, gunshipGreenChosen);
		gunship2 = new Gunship(620, 174, gunshipGreen, gunshipGreenChosen);
		bomber1 = new JetBomber(744, 58, bomberGreen, bomberGreenChosen);
		bomber2 = new JetBomber(744, 174, bomberGreen, bomberGreenChosen);

		unitsList.add(mainTank1);
		unitsList.add(mainTank2);
		unitsList.add(mainTank3);
		unitsList.add(mech1);
		unitsList.add(mech2);
		unitsList.add(mech3);
		unitsList.add(mech4);
		unitsList.add(bunker);
		unitsList.add(buggy4);
		unitsList.add(buggy5);
		unitsList.add(buggy6);
		unitsList.add(buggy7);
		unitsList.add(buggy8);
		unitsList.add(gunship1);
		unitsList.add(gunship2);
		unitsList.add(bomber1);
		unitsList.add(bomber2);
	}

	private BufferedImage loadImage(String resName) {
		BufferedImage loadedImage = null;
		try {
			loadedImage = ImageIO.read(new File(
					"C:\\Users\\Ula\\Desktop\\javaproj\\"
							+ "AnimatedGame\\Resources\\" + resName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return loadedImage;
	}

	public int getListSize() {
		return this.unitsList.size();
	}

	public ArrayList<AbstractUnit> getList() {
		return this.unitsList;
	}

	public AbstractUnit getUnit(int index) {
		return this.unitsList.get(index);
	}

	public void deleteUnit(int unit) {
		this.unitsList.remove(unit);
	}

	public BufferedImage getDestroyedUnitImage() {
		return this.wrecked;
	}
	
	public BufferedImage getDestroyedBunkerImage() {
		return this.destroyedBunker;
	}
}
