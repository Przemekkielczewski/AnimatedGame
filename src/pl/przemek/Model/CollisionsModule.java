package pl.przemek.Model;

import pl.przemek.Model.Units.AbstractUnit;
import pl.przemek.View.UnitsRegister;

public class CollisionsModule {

	private int terrainList[][] = new int[30][2];

	public CollisionsModule() {
		terrainList[0][0] = 0;
		terrainList[0][1] = 744;

		terrainList[1][0] = 58;
		terrainList[1][1] = 496;

		terrainList[2][0] = 116;
		terrainList[2][1] = 558;

		terrainList[3][0] = 174;
		terrainList[3][1] = 558;

		terrainList[4][0] = 522;
		terrainList[4][1] = 620;// ma³e kamienie

		terrainList[5][0] = 174;
		terrainList[5][1] = 496;
		terrainList[6][0] = 174;
		terrainList[6][1] = 434;
		terrainList[7][0] = 232;
		terrainList[7][1] = 434;
		terrainList[8][0] = 232;
		terrainList[8][1] = 496;// du¿y kamieñ

		terrainList[9][0] = 522;
		terrainList[9][1] = 62;
		terrainList[10][0] = 464;
		terrainList[10][1] = 62;
		terrainList[11][0] = 464;
		terrainList[11][1] = 124;
		terrainList[12][0] = 522;
		terrainList[12][1] = 124;// du¿y kamieñ

		terrainList[13][0] = 522;// rzeka od do³u planszy
		terrainList[13][1] = 310;

		terrainList[14][0] = 522;
		terrainList[14][1] = 372;

		terrainList[15][0] = 522;
		terrainList[15][1] = 434;

		terrainList[16][0] = 464;
		terrainList[16][1] = 310;

		terrainList[17][0] = 406;
		terrainList[17][1] = 310;

		terrainList[18][0] = 406;
		terrainList[18][1] = 248;

		terrainList[19][0] = 348;
		terrainList[19][1] = 248;

		terrainList[20][0] = 348;
		terrainList[20][1] = 186;
		terrainList[21][0] = 348;
		terrainList[21][1] = 124;

		terrainList[22][0] = 290;
		terrainList[22][1] = 248;
		terrainList[23][0] = 290;
		terrainList[23][1] = 186;
		terrainList[24][0] = 290;
		terrainList[24][1] = 124;
		terrainList[25][0] = 290;
		terrainList[25][1] = 62;
		terrainList[26][0] = 290;
		terrainList[26][1] = 0;

		terrainList[27][0] = 232;
		terrainList[27][1] = 0;
		terrainList[28][0] = 232;
		terrainList[28][1] = 62;
		terrainList[29][0] = 232;
		terrainList[29][1] = 124;
	}

	public boolean collisionLeft(AbstractUnit abstractUnit,
			UnitsRegister register) {
		return collisionGeneral(abstractUnit, register, -62, -0);
	}

	public boolean collisionRight(AbstractUnit abstractUnit,
			UnitsRegister register) {
		return collisionGeneral(abstractUnit, register, +62, +0);
	}

	public boolean collisionUp(AbstractUnit abstractUnit, UnitsRegister register) {
		return collisionGeneral(abstractUnit, register, -0, -58);
	}

	public boolean collisionDown(AbstractUnit abstractUnit,
			UnitsRegister register) {
		return collisionGeneral(abstractUnit, register, +0, +58);
	}

	private boolean collisionGeneral(AbstractUnit abstractUnit,
			UnitsRegister register, int posX, int posY) {
		if (abstractUnit.isFlying() == false) {
			for (int i = 0; i < terrainList.length; i++) {
				if (terrainList[i][0] == abstractUnit.getPosY() + posY
						&& terrainList[i][1] == abstractUnit.getPosX() + posX) {
					return true;
				}
			}
		}
		for (int j = 0; j < register.getListSize(); j++) {
			if (register.getUnit(j).isDestroyed() == false
					&& register.getUnit(j).getPosY() == abstractUnit.getPosY()
							+ posY
					&& register.getUnit(j).getPosX() == abstractUnit.getPosX()
							+ posX) {
				return true;
			}
		}
		return false;
	}
}
