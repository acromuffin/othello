package ctrl;

import java.util.ArrayList;
import java.util.List;

import application.GameProc;
import gameAi.gameAi;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

public class Controller {

	GameProc game = null;
	
	@FXML private Circle circle00;
	@FXML private Circle circle01;
	@FXML private Circle circle02;
	@FXML private Circle circle03;
	@FXML private Circle circle04;
	@FXML private Circle circle05;
	@FXML private Circle circle06;
	@FXML private Circle circle07;
	
	@FXML private Circle circle10;
	@FXML private Circle circle11;
	@FXML private Circle circle12;
	@FXML private Circle circle13;
	@FXML private Circle circle14;
	@FXML private Circle circle15;
	@FXML private Circle circle16;
	@FXML private Circle circle17;

	@FXML private Circle circle20;
	@FXML private Circle circle21;
	@FXML private Circle circle22;
	@FXML private Circle circle23;
	@FXML private Circle circle24;
	@FXML private Circle circle25;
	@FXML private Circle circle26;
	@FXML private Circle circle27;
	

	@FXML private Circle circle30;
	@FXML private Circle circle31;
	@FXML private Circle circle32;
	@FXML private Circle circle33;
	@FXML private Circle circle34;
	@FXML private Circle circle35;
	@FXML private Circle circle36;
	@FXML private Circle circle37;

	@FXML private Circle circle40;
	@FXML private Circle circle41;
	@FXML private Circle circle42;
	@FXML private Circle circle43;
	@FXML private Circle circle44;
	@FXML private Circle circle45;
	@FXML private Circle circle46;
	@FXML private Circle circle47;

	@FXML private Circle circle50;
	@FXML private Circle circle51;
	@FXML private Circle circle52;
	@FXML private Circle circle53;
	@FXML private Circle circle54;
	@FXML private Circle circle55;
	@FXML private Circle circle56;
	@FXML private Circle circle57;

	@FXML private Circle circle60;
	@FXML private Circle circle61;
	@FXML private Circle circle62;
	@FXML private Circle circle63;
	@FXML private Circle circle64;
	@FXML private Circle circle65;
	@FXML private Circle circle66;
	@FXML private Circle circle67;

	@FXML private Circle circle70;
	@FXML private Circle circle71;
	@FXML private Circle circle72;
	@FXML private Circle circle73;
	@FXML private Circle circle74;
	@FXML private Circle circle75;
	@FXML private Circle circle76;
	@FXML private Circle circle77;
	
	
	private List<List<Circle>> circleList = new ArrayList<List<Circle>>();
	private List<Circle> tempList = null;
	
	
	@FXML private Button endButton;
	@FXML private Button buttonStartBlack;
	@FXML private Button buttonStartWhite;
	@FXML private Button buttonAutoBattle;
	@FXML private Button buttonAutoBattleReverse;
	
	@FXML private Label labelBlack;
	@FXML private Label labelWhite;
	@FXML private Label labelBlackCount;
	@FXML private Label labelWhiteCount;
	@FXML private Label labelYourColor;
	@FXML private Label labelYourColorDisp;
	@FXML private Label labelAiName;
	@FXML private Label labelSubAiName;
	
	@FXML public void onButtonAutoBattleCilck(){
		autoBattle(false);
	}
	
	@FXML public void onButtonAutoBattleReverseCilck() {
		autoBattle(true);
	}
	
	@FXML public void onEndButtonClick() {
		endGame();
	}
	
	@FXML public void onCircle00Click() {
		doStep(0,0);
	}	
	
	@FXML public void onCircle01Click() {
		doStep(0,1);
	}	
	
	@FXML public void onCircle02Click() {
		doStep(0,2);
	}	
	
	@FXML public void onCircle03Click() {
		doStep(0,3);
	}	
	
	@FXML public void onCircle04Click() {
		doStep(0,4);
	}	
	
	@FXML public void onCircle05Click() {
		doStep(0,5);
	}	
	
	@FXML public void onCircle06Click() {
		doStep(0,6);
	}	
	
	@FXML public void onCircle07Click() {
		doStep(0,7);
	}	
	
	@FXML public void onCircle10Click() {
		doStep(1,0);
	}	
	
	@FXML public void onCircle11Click() {
		doStep(1,1);
	}	
	
	@FXML public void onCircle12Click() {
		doStep(1,2);
	}	
	
	@FXML public void onCircle13Click() {
		doStep(1,3);
	}	
	
	@FXML public void onCircle14Click() {
		doStep(1,4);
	}	
	
	@FXML public void onCircle15Click() {
		doStep(1,5);
	}	
	
	@FXML public void onCircle16Click() {
		doStep(1,6);
	}	
	
	@FXML public void onCircle17Click() {
		doStep(1,7);
	}	
	
	@FXML public void onCircle20Click() {
		doStep(2,0);
	}	
	
	@FXML public void onCircle21Click() {
		doStep(2,1);
	}	
	
	@FXML public void onCircle22Click() {
		doStep(2,2);
	}	
	
	@FXML public void onCircle23Click() {
		doStep(2,3);
	}	
	
	@FXML public void onCircle24Click() {
		doStep(2,4);
	}	
	
	@FXML public void onCircle25Click() {
		doStep(2,5);
	}	
	
	@FXML public void onCircle26Click() {
		doStep(2,6);
	}	
	
	@FXML public void onCircle27Click() {
		doStep(2,7);
	}	
	
	@FXML public void onCircle30Click() {
		doStep(3,0);
	}	
	
	@FXML public void onCircle31Click() {
		doStep(3,1);
	}	
	
	@FXML public void onCircle32Click() {
		doStep(3,2);
	}	
	
	@FXML public void onCircle33Click() {
		doStep(3,3);
	}	
	
	@FXML public void onCircle34Click() {
		doStep(3,4);
	}	
	
	@FXML public void onCircle35Click() {
		doStep(3,5);
	}	
	
	@FXML public void onCircle36Click() {
		doStep(3,6);
	}	
	
	@FXML public void onCircle37Click() {
		doStep(3,7);
	}	
	
	@FXML public void onCircle40Click() {
		doStep(4,0);
	}	
	
	@FXML public void onCircle41Click() {
		doStep(4,1);
	}	
	
	@FXML public void onCircle42Click() {
		doStep(4,2);
	}	
	
	@FXML public void onCircle43Click() {
		doStep(4,3);
	}	
	
	@FXML public void onCircle44Click() {
		doStep(4,4);
	}	
	
	@FXML public void onCircle45Click() {
		doStep(4,5);
	}	
	
	@FXML public void onCircle46Click() {
		doStep(4,6);
	}	
	
	@FXML public void onCircle47Click() {
		doStep(4,7);
	}	
	
	@FXML public void onCircle50Click() {
		doStep(5,0);
	}	
	
	@FXML public void onCircle51Click() {
		doStep(5,1);
	}	
	
	@FXML public void onCircle52Click() {
		doStep(5,2);
	}	
	
	@FXML public void onCircle53Click() {
		doStep(5,3);
	}	
	
	@FXML public void onCircle54Click() {
		doStep(5,4);
	}	
	
	@FXML public void onCircle55Click() {
		doStep(5,5);
	}	
	
	@FXML public void onCircle56Click() {
		doStep(5,6);
	}	
	
	@FXML public void onCircle57Click() {
		doStep(5,7);
	}	
	
	@FXML public void onCircle60Click() {
		doStep(6,0);
	}	
	
	@FXML public void onCircle61Click() {
		doStep(6,1);
	}	
	
	@FXML public void onCircle62Click() {
		doStep(6,2);
	}	
	
	@FXML public void onCircle63Click() {
		doStep(6,3);
	}	
	
	@FXML public void onCircle64Click() {
		doStep(6,4);
	}	
	
	@FXML public void onCircle65Click() {
		doStep(6,5);
	}	
	
	@FXML public void onCircle66Click() {
		doStep(6,6);
	}	
	
	@FXML public void onCircle67Click() {
		doStep(6,7);
	}	
	
	@FXML public void onCircle70Click() {
		doStep(7,0);
	}	
	
	@FXML public void onCircle71Click() {
		doStep(7,1);
	}	
	
	@FXML public void onCircle72Click() {
		doStep(7,2);
	}	
	
	@FXML public void onCircle73Click() {
		doStep(7,3);
	}	
	
	@FXML public void onCircle74Click() {
		doStep(7,4);
	}	
	
	@FXML public void onCircle75Click() {
		doStep(7,5);
	}	
	
	@FXML public void onCircle76Click() {
		doStep(7,6);
	}	
	
	@FXML public void onCircle77Click() {
		doStep(7,7);
	}	
	
	@FXML public void onStartBlackClick() {
		startGame(1);
	}
	
	@FXML public void onStartWhiteClick() {
		startGame(-1);
	}
	
	int playerColor = 0;
	
	public void startGame(int color) {
		initCircleColor();
		buttonStartBlack.setVisible(false);
		buttonStartWhite.setVisible(false);
		buttonAutoBattle.setVisible(false);
		buttonAutoBattleReverse.setVisible(false);
		playerColor = color;
		game = new GameProc();		
		if(playerColor == -1) {
			game.doAutoStep(1,game.getAi());
		}
		refreshCircle();
		endButton.setVisible(true);
		if(playerColor == -1) {
			labelYourColorDisp.setText("White");
		} else {
			labelYourColorDisp.setText("Black");
		}
		labelYourColor.setVisible(true);
		labelYourColorDisp.setVisible(true);
		labelAiName.setText("AI : " + game.getAiClass());
	}
	
	public void endGame() {
		refreshCircle();
		buttonStartBlack.setVisible(true);
		buttonStartWhite.setVisible(true);
		buttonAutoBattle.setVisible(true);
		buttonAutoBattleReverse.setVisible(true);
		endButton.setVisible(false);
		//labelYourColor.setVisible(false);
		//labelYourColorDisp.setVisible(false);
		playerColor = 0;
		game = null;
	}
	
	public void autoBattle(boolean reverse) {
		initCircleColor();
		labelYourColor.setVisible(false);
		labelYourColorDisp.setVisible(false);
		game = new GameProc();
		gameAi mainAi = null;
		gameAi subAi = null;
		if(game.getSubAi() == null) {
			mainAi = subAi = game.getAi();
		} else if (reverse) {
			mainAi = game.getSubAi();
			subAi = game.getAi();
		} else {
			mainAi = game.getAi();
			subAi = game.getSubAi();
		}
		buttonStartBlack.setVisible(false);
		buttonStartWhite.setVisible(false);
		buttonAutoBattle.setVisible(false);
		buttonAutoBattleReverse.setVisible(false);

		labelAiName.setText("AI : " + game.getAiClass());
		labelSubAiName.setText("Sub AI : " + game.getSubAiClass());
		
		
		while(true) {
			if(game.getAva(1)) {
				game.doAutoStep(1, mainAi);
			} else if (!game.getAva(-1)) {
				break;
			}
			if(game.getAva(-1)){
				game.doAutoStep(-1, subAi);
			} else if (!game.getAva(1)) {
				break;
			}
		}

		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(game.getBoard()[i][j] == 1) {
					circleList.get(i).get(j).setFill(javafx.scene.paint.Color.BLACK);
				} else if (game.getBoard()[i][j] == -1) {
					circleList.get(i).get(j).setFill(javafx.scene.paint.Color.WHITE);
				} else {
					circleList.get(i).get(j).setFill(javafx.scene.paint.Color.valueOf("006F07"));
				}
			}
		}

		labelBlackCount.setText("" + game.getCount(1));
		labelWhiteCount.setText("" + game.getCount(-1));
		

		buttonStartBlack.setVisible(true);
		buttonStartWhite.setVisible(true);
		buttonAutoBattle.setVisible(true);
		buttonAutoBattleReverse.setVisible(true);
		
	}
	
	
	public void doStep(int x,int y) {
		if(playerColor == 0) return;
		if(!game.getAvaGrid(x,y,playerColor)) return;
		game.doStep(x,y,playerColor);
		if(!game.getAva(-1*playerColor)) {
			if(!game.getAva(playerColor)) {
				endGame();
				return;
			}else {
				refreshCircle();
				return;
			}
		}
		while(true) {
			game.doAutoStep(-1*playerColor,game.getAi());
			if(!game.getAva(playerColor)) {
				if(!game.getAva(-1*playerColor)) {
					endGame();
					return;
				}
				continue;
			}
			break;
		}
		refreshCircle();
	}
	
	public void refreshCircle() {
		int[][] board = game.getBoard();
		boolean[][] ava = game.getAvaGridAll(playerColor);
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(board[i][j] == 1) {
					circleList.get(i).get(j).setFill(javafx.scene.paint.Color.BLACK);
				} else if (board[i][j] == -1) {
					circleList.get(i).get(j).setFill(javafx.scene.paint.Color.WHITE);
				} else if (ava[i][j]) {
						circleList.get(i).get(j).setFill(javafx.scene.paint.Color.GRAY);
				} else {
					circleList.get(i).get(j).setFill(javafx.scene.paint.Color.valueOf("006F07"));
				}
			}
		}
		labelBlackCount.setText("" + game.getCount(1));
		labelWhiteCount.setText("" + game.getCount(-1));
	}
	
	private void initCircleColor() {
		circleList = new ArrayList<List<Circle>>();
		
		tempList = new ArrayList<Circle>();
		tempList.add(circle00);
		tempList.add(circle01);
		tempList.add(circle02);
		tempList.add(circle03);
		tempList.add(circle04);
		tempList.add(circle05);
		tempList.add(circle06);
		tempList.add(circle07);
		circleList.add(tempList);
		
		tempList = new ArrayList<Circle>();
		tempList.add(circle10);
		tempList.add(circle11);
		tempList.add(circle12);
		tempList.add(circle13);
		tempList.add(circle14);
		tempList.add(circle15);
		tempList.add(circle16);
		tempList.add(circle17);
		circleList.add(tempList);
		
		tempList = new ArrayList<Circle>();
		tempList.add(circle20);
		tempList.add(circle21);
		tempList.add(circle22);
		tempList.add(circle23);
		tempList.add(circle24);
		tempList.add(circle25);
		tempList.add(circle26);
		tempList.add(circle27);
		circleList.add(tempList);

		tempList = new ArrayList<Circle>();
		tempList.add(circle30);
		tempList.add(circle31);
		tempList.add(circle32);
		tempList.add(circle33);
		tempList.add(circle34);
		tempList.add(circle35);
		tempList.add(circle36);
		tempList.add(circle37);
		circleList.add(tempList);

		tempList = new ArrayList<Circle>();
		tempList.add(circle40);
		tempList.add(circle41);
		tempList.add(circle42);
		tempList.add(circle43);
		tempList.add(circle44);
		tempList.add(circle45);
		tempList.add(circle46);
		tempList.add(circle47);
		circleList.add(tempList);

		tempList = new ArrayList<Circle>();
		tempList.add(circle50);
		tempList.add(circle51);
		tempList.add(circle52);
		tempList.add(circle53);
		tempList.add(circle54);
		tempList.add(circle55);
		tempList.add(circle56);
		tempList.add(circle57);
		circleList.add(tempList);

		tempList = new ArrayList<Circle>();
		tempList.add(circle60);
		tempList.add(circle61);
		tempList.add(circle62);
		tempList.add(circle63);
		tempList.add(circle64);
		tempList.add(circle65);
		tempList.add(circle66);
		tempList.add(circle67);
		circleList.add(tempList);

		tempList = new ArrayList<Circle>();
		tempList.add(circle70);
		tempList.add(circle71);
		tempList.add(circle72);
		tempList.add(circle73);
		tempList.add(circle74);
		tempList.add(circle75);
		tempList.add(circle76);
		tempList.add(circle77);
		circleList.add(tempList);
		
		for (int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				circleList.get(i).get(j).setFill(javafx.scene.paint.Color.valueOf("006F07"));
			}
		}
	}

}
