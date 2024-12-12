package walk;

public class When_i_wake_up {

	/*
	 * やることリスト
	 * 川周りの情報スッキリする
	 * マップ生成用競合回避メソッド 
	 * マップオブジェ追加
	 * display周辺のレイアウト 
	 * その他レイアウト
	 * リトライ周辺の挙動、メソッド通過ルートの調整
	 * ステータス(時間・空腹・気持ち・etc)追加
	 * flag鍵とhomeEnd周辺 
	 * flagのインデックス管理を上手いことやるメソッド追加
	 * display周辺のコードを上手いこと分ける
	 * 歩いたログ保存してResultとかに表示
	 * 
	 * 
	 * 
	 */

//	public static void debugmenue() {
//		int[] dammyPos = { 5, 5 };
//		int[] dammyNextPos = { 5, 6 };
//		getAround(dammyPos, dammyNextPos);
//		System.out.print("debug end　＞");
//		int stop = new java.util.Scanner(System.in).nextInt();
//		return;
//	}

	public static void main(String[] args) {
		int mapSize = 11;
		int[][] map = new int[mapSize][mapSize];
		int[] pos = new int[2];// 0=x,1=y
		int[] nextPos = new int[2];
		int[] flags = new int[10];
		/*flagsメモ ０．週回 １．橋 ２． ３．犬 ４． ５． ６． ７． ８． ９． */

//		debugmenue();

		while (true) {
			flags[9] = 0;
			opening();
			mapCreate(map, pos, nextPos);
			while (flags[9] != 1) {
				walk(flags);
				display(map, pos, nextPos, flags);
				if (flags[9] != 1)
					underDisplayTree(map, pos, nextPos, flags);
			}
		}
	}

	public static void cheetMap(int[][] map, int[] pos, int[] nextPos) {
//System.out.println("cheetMap1" + nextPos[0] + nextPos[1]);// debug
		int shelterByPos = map[pos[0]][pos[1]];
		map[pos[0]][pos[1]] += 1000;
		int shelterByNextPos = map[nextPos[0]][nextPos[1]];
		map[nextPos[0]][nextPos[1]] += 2000;

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] / 10 == 0) {
					System.out.print("[00" + map[i][j] + "]");
				} else if (map[i][j] / 100 == 0) {
					System.out.print("[0" + map[i][j] + "]");

				} else {
					System.out.print("[" + map[i][j] + "]");
				}
			}
			System.out.println();
		}
		System.out.println("-----------------------------");
		map[pos[0]][pos[1]] = shelterByPos;
		map[nextPos[0]][nextPos[1]] = shelterByNextPos;
	}

	public static void opening() {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("	目がさめたら夜だった。おうちに帰らなきゃ。");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.print("				2.walk ＞");
		int input = new java.util.Scanner(System.in).nextInt();

	}

	public static void walk(int[] flags) {
		flags[0]++;
		if (flags[0] < 5) {
			System.out.println("----------------------------------------");
			System.out.println();
			System.out.println();
			System.out.println("	now walking");
			System.out.println();
			System.out.println();
			System.out.print("				2.walk ＞");
			int input = new java.util.Scanner(System.in).nextInt();
			System.out.println("----------------------------------------");
			return;
		}
		if (flags[5] == 0) {
			System.out.println("----------------------------------------");
			System.out.println();
			System.out.println();
			System.out.println("	now walking");
			System.out.println();
			System.out.println();
			System.out.print("				2.walk 5.auto walk＞");
			int input = new java.util.Scanner(System.in).nextInt();
			switch (input) {
			case 5:
				flags[5]++;
				break;
			default:
				break;
			}
			System.out.println("----------------------------------------");
			return;
		} else {
			System.out.println("----------------------------------------");
			System.out.println();
			System.out.println();
			System.out.println("	now auto walking");
			System.out.println();
			System.out.println();
			System.out.println("				move forward");
			System.out.println("----------------------------------------");
			return;
		}
		
	}

	public static void mapCreate(int[][] map, int[] pos, int[] nextPos) {
		riverCreate(map);
		forestCreate(map);
		dogCreate(map);
		homeCreate(map);
		playerPosCreate(map, pos, nextPos);
	}

	public static void riverCreate(int[][] map) {
		int riverPos = map.length / 2;
		for (int i = 0; i < map.length; i++) {
			map[riverPos][i] = 110;
			map[riverPos + 1][i] = 120;
			map[riverPos - 1][i] = 120;
		}
		int[] bridge = new int[2];
		do {
			for (int i = 0; i < bridge.length; i++) {
				bridge[i] = new java.util.Random().nextInt(map[riverPos].length);

			}
		} while (bridge[0] == bridge[1]);

		for (int i = 0; i < bridge.length; i++) {
			map[riverPos][bridge[i]] = 130;
			for (int j = 0; j < 3; j++) {

				map[riverPos + 1][edgeOverCheck(map, bridge[i] - 1 + j)] = 160;
				map[riverPos - 1][edgeOverCheck(map, bridge[i] - 1 + j)] = 160;
			}
		}
		for (int i = 0; i < bridge.length; i++) {
			map[riverPos + 1][bridge[i]] = 150;
			map[riverPos - 1][bridge[i]] = 150;
		}
		map[riverPos][bridge[0]] = 131;

	}

	public static void forestCreate(int[][] map) {
		int bigForestPos[] = new int[2];// 0=x,1=y

		bigForestPos[0] = 2;
		bigForestPos[1] = 2;

		map[bigForestPos[0]][bigForestPos[1]] = 210;
		map[bigForestPos[0] - 1][bigForestPos[1]] = 210;
		map[bigForestPos[0]][bigForestPos[1] - 1] = 210;
		map[bigForestPos[0] - 1][bigForestPos[1] - 1] = 210;
	}

	public static void dogCreate(int[][] map) {
		int[][] dogPos = new int[10][2];

		for (int i = 0; i < dogPos.length; i++) {
			do {
				for (int j = 0; j < 2; j++) {
					dogPos[i][j] = new java.util.Random().nextInt(map.length);
				}
			} while (map[dogPos[i][0]][dogPos[i][1]] != 0);
			map[dogPos[i][0]][dogPos[i][1]] = 310;
		}
	}

	public static void homeCreate(int[][] map) {
		int[] homePos = new int[2];
		do {
			for (int i = 0; i < 2; i++) {
				homePos[i] = new java.util.Random().nextInt(map.length);
			}
		} while (map[homePos[0]][homePos[1]] != 0);
		map[homePos[0]][homePos[1]] = 400;
	}

	public static void playerPosCreate(int[][] map, int[] pos, int[] nextPos) {
		int direction = new java.util.Random().nextInt(4);
//System.out.println(direction);// debug

		do {
			pos[0] = new java.util.Random().nextInt(map.length);
			pos[1] = new java.util.Random().nextInt(map.length);
			updateNextPos(map, pos, nextPos, direction);

		} while (map[pos[0]][pos[1]] != 0 || map[nextPos[0]][nextPos[1]] != 0);
//map[pos[0]][pos[1]]+=1000;
//map[nextPos[0]][nextPos[1]]+=2000;
	}

	public static void updateNextPos(int[][] map, int pos[], int nextPos[], int direction) {
//System.out.println("updateNextPos" + direction);// debug
		switch (direction) {
		case 0:
			nextPos[0] = pos[0] - 1;
			nextPos[1] = pos[1];
			break;
		case 1:
			nextPos[0] = pos[0];
			nextPos[1] = pos[1] - 1;
			break;
		case 2:
			nextPos[0] = pos[0] + 1;
			nextPos[1] = pos[1];
			break;
		case 3:
			nextPos[0] = pos[0];
			nextPos[1] = pos[1] + 1;
			break;
		default:
			System.out.println("updateNextPosバグ");
			break;
		}
//System.out.println("updateNextPos1" + nextPos[0] + nextPos[1]);//debug
		nextPos = edgeOverCheck(map, nextPos);
//System.out.println("updateNextPos1" + nextPos[0] + nextPos[1]);//debagu
	}

	public static int[][] getAround(int[] pos, int[] nextPos) {
		int direction = getDirection(pos, nextPos); // debug close
		int[][] around = new int[10][2];
		System.out.println(pos[0] + "+" + pos[1] + "+" + direction);
		switch (direction) {
		case 0:
			for (int i = 1; i < around.length; i++) {
				around[i][0] = pos[0] - (i - 1) / 3 + 1;
				around[i][1] = pos[1] + (i - 1) % 3 - 1;
				System.out.println(around[i][0] + "--" + around[i][1] + "--");// debug
			}
			break;
		case 1:
			for (int i = 1; i < around.length; i++) {
				around[i][0] = pos[0] - (i - 1) % 3 + 1;
				around[i][1] = pos[1] - (i - 1) / 3 + 1;
				System.out.println(around[i][0] + "--" + around[i][1] + "--");// debug
			}
			break;
		case 2:
			for (int i = 1; i < around.length; i++) {
				around[i][0] = pos[0] + (i - 1) / 3 - 1;
				around[i][1] = pos[1] - (i - 1) % 3 + 1;
				System.out.println(around[i][0] + "--" + around[i][1] + "--");// debug
			}
			break;
		case 3:
			for (int i = 1; i < around.length; i++) {
				around[i][0] = pos[0] + (i - 1) % 3 - 1;
				around[i][1] = pos[1] + (i - 1) / 3 - 1;
				System.out.println(around[i][0] + "--" + around[i][1] + "--");// debug
			}
			break;
		default:
			System.out.println("getAroundエラー");
			break;
		}

		return around;

	}

	public static int[] edgeOverCheck(int[][] map, int[] checkedPos) {
		for (int i = 0; i < 2; i++) {
			if (checkedPos[i] > map.length - 1)
				checkedPos[i] = 0;
			if (checkedPos[i] < 0)
				checkedPos[i] = map.length - 1;
		}
		return checkedPos;
	}

	public static int edgeOverCheck(int[][] map, int checkedPos) {
		if (checkedPos > map.length - 1)
			checkedPos = 0;
		if (checkedPos < 0)
			checkedPos = map.length - 1;
		return checkedPos;

	}

	public static int getDirection(int[] pos, int[] nextPos) {
		if (pos[0] == nextPos[0] + 1)
			return 0;
		if (pos[1] == nextPos[1] + 1)
			return 1;
		if (pos[0] == nextPos[0] - 1)
			return 2;
		if (pos[1] == nextPos[1] - 1)
			return 3;
		if (pos[0] < nextPos[0])
			return 0;
		if (pos[1] < nextPos[1])
			return 1;
		if (pos[0] > nextPos[0])
			return 2;
		if (pos[1] > nextPos[1]) {
			return 3;
		} else {
			System.out.println("getDirectionバグ");
			return 4;
		}
	}

	public static void moveForward(int[][] map, int[] pos, int[] nextPos) {
		int direction = getDirection(pos, nextPos);
//System.out.println("moveForward1" + direction);// debug
		for (int i = 0; i < nextPos.length; i++) {
			pos[i] = nextPos[i];
		}
		updateNextPos(map, pos, nextPos, direction);
//System.out.println("moveForward2" + nextPos[0] + nextPos[1]);// debug

//System.out.println("moveForward3" + nextPos[0] + nextPos[1]);// debug
	}

	public static int directionReverce(int direction) {
		switch (direction) {
		case 0:
			direction = 2;
			break;
		case 1:
			direction = 3;
			break;
		case 2:
			direction = 0;
			break;
		case 3:
			direction = 1;
			break;
		}
		return direction;
	}

	public static int directionLeft(int direction) {
		switch (direction) {
		case 0:
			direction = 1;
			break;
		case 1:
			direction = 2;
			break;
		case 2:
			direction = 3;
			break;
		case 3:
			direction = 0;
			break;
		}
		return direction;
	}

	public static int directionRight(int direction) {
		switch (direction) {
		case 0:
			direction = 3;
			break;
		case 1:
			direction = 0;
			break;
		case 2:
			direction = 1;
			break;
		case 3:
			direction = 2;
			break;
		}
		return direction;
	}

	public static void display(int[][] map, int[] pos, int[] nextPos, int[] flags) {

		System.out.println();
		System.out.println();

		if (flags[0] == 1) {
			System.out.print("	前には");
		}

		switch (map[nextPos[0]][nextPos[1]]) {
		case 0:
			System.out.println("	なんもない");
			break;
		case 110:
			System.out.println("	川だ");
			break;
		case 120:
			System.out.println("	");
			break;
		case 130:
			System.out.println("	新しい橋だ");
			break;
		case 131:
			System.out.println("	古い橋だ");
			break;
		case 150:
			System.out.println("	");
			break;
		case 160:
			System.out.println("	");
			break;
		case 210:
			System.out.println("	森だ。　怖いから無理。");
			break;
		case 310:
			System.out.println("	犬だ！　逃げろ！");
			int direction = getDirection(pos, nextPos);
//	System.out.println("inu getDir nextPos"+nextPos[0]+nextPos[1]);//debug
			direction = directionReverce(direction);
//	System.out.println("inu dirRev nextPos"+nextPos[0]+nextPos[1]);//debug
			updateNextPos(map, pos, nextPos, direction);
//	System.out.println("inu updNex nextPos"+nextPos[0]+nextPos[1]);//debug
			moveForward(map, pos, nextPos);
//	System.out.println("inu movFwa nextPos"+nextPos[0]+nextPos[1]); //debug
			flags[3]++;
			if (flags[3] == 7)
				inuEnd(flags);
			return;
		case 400:
			System.out.println("	家だ？？！！");
			break;
		default:
			System.out.println("	バグってる");
			break;
		}
		if (flags[0] == 1) {
			System.out.print("	ここには");
		}
		switch (map[pos[0]][pos[1]]) {
		case 0:
			System.out.println("	なんにもない");
			break;
		case 120:
			System.out.println("	川が流れてる");
			break;
		case 130:
			System.out.println("	橋を渡る");
			break;
		case 131:
			flags[1]++;
			if (flags[1] == 2) {
				System.out.println("かなり　崩れそう");
				int direction = getDirection(pos, nextPos);
				direction = directionReverce(direction);
				updateNextPos(map, pos, nextPos, direction);
				moveForward(map, pos, nextPos);
				int[] keepPos = { pos[0], pos[1] };
				bridgeEnd(pos, flags, keepPos);
			}
			System.out.println("	崩れそう");

			break;
		case 150:
			System.out.println("	橋 渡るの？");
		case 160:
			switch (getDirection(pos, nextPos)) {
			case 0, 2:
				if (map[nextPos[0]][nextPos[1] - 1] / 10 == 13 || map[nextPos[0]][nextPos[1] + 1] / 10 == 13) {
					System.out.println("	橋が見える");
				}
				break;
			case 1, 3:
				if (map[nextPos[0] - 1][nextPos[1]] / 10 == 13 || map[nextPos[0] + 1][nextPos[1] + 1] / 10 == 13) {
					System.out.println("	橋が見える");
				}
				break;
			}
			break;
		case 310:
			System.out.println("	犬だ！");
			break;
		case 400:
			System.out.println("家に着きました");
			homeEnd();
		default:
			System.out.println("	しらん");
			break;
		}
		System.out.println();
		System.out.println();
	}

	public static void underDisplayTree(int[][] map, int[] pos, int[] nextPos, int[] flags) {
		if (flags[3] == 1 || flags[3] == 3 || flags[3] == 5) {
			flags[3]++;
			return;
		}

		if (flags[5] > 0) {
			if (map[nextPos[0]][nextPos[1]] / 10 == 0) {

				moveForward(map, pos, nextPos);
				return;
			} else {
				underDisplayAutWalk10(map, pos, nextPos, flags);
			}
		}
		if (map[nextPos[0]][nextPos[1]] / 10 % 10 != 1) {
			underDisplayNomal(map, pos, nextPos, flags);
		} else {
			underDisplayFront10(map, pos, nextPos, flags);
		}
	}

	public static void underDisplayNomal(int[][] map, int[] pos, int[] nextPos, int[] flags) {
		System.out.print("1.左を向く 2.前に進む 3.右を向く　9.チート＞");
		int input = new java.util.Scanner(System.in).nextInt();
		switch (input) {
		case 1:
			updateNextPos(map, pos, nextPos, directionLeft(getDirection(pos, nextPos)));
			break;
		case 2:
			moveForward(map, pos, nextPos);
			break;
		case 3:
			updateNextPos(map, pos, nextPos, directionRight(getDirection(pos, nextPos)));
			break;
		case 9:
			cheetMap(map, pos, nextPos);
			underDisplayTree(map, pos, nextPos, flags);
			break;
		}
	}

	public static void underDisplayFront10(int[][] map, int[] pos, int[] nextPos, int[] flags) {
		System.out.print("1.左を向く 2.前には進めない 3.右を向く　9.チート＞");
		int input = new java.util.Scanner(System.in).nextInt();
		switch (input) {
		case 1:
			updateNextPos(map, pos, nextPos, directionLeft(getDirection(pos, nextPos)));
			break;
		case 2:
			System.out.println("無理。");
			muriEnd(flags);
			break;
		case 3:
			updateNextPos(map, pos, nextPos, directionRight(getDirection(pos, nextPos)));
			break;
		case 9:
			cheetMap(map, pos, nextPos);
			underDisplayTree(map, pos, nextPos, flags);
			break;
		default:
			System.out.println("変なの押した。");
			underDisplayTree(map, pos, nextPos, flags);
			break;
		}
	}

	public static void underDisplayAutWalk10(int[][] map, int[] pos, int[] nextPos, int[] flags) {
		System.out.print("1.左を向く 2.前には進めない 3.右を向く　5.autwalk:off 9.チート＞");
		int input = new java.util.Scanner(System.in).nextInt();
		switch (input) {
		case 1:
			updateNextPos(map, pos, nextPos, directionLeft(getDirection(pos, nextPos)));
			break;
		case 2:
			System.out.println("無理。");
			muriEnd(flags);
			break;
		case 3:
			updateNextPos(map, pos, nextPos, directionRight(getDirection(pos, nextPos)));
			break;
		case 5:
			flags[5] = 0;
			underDisplayFront10(map, pos, nextPos, flags);
			break;
		case 9:
			cheetMap(map, pos, nextPos);
			underDisplayTree(map, pos, nextPos, flags);
			break;
		default:
			System.out.println("変なの押した。");
			underDisplayTree(map, pos, nextPos, flags);
			break;
		}
	}

	public static void homeEnd() {
		System.out.println("おやすみ～～");
		System.out.println("game crear");
	}

	public static void muriEnd(int[] flags) {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("	now muriking");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.print("				0.muri ＞");
		int input = new java.util.Scanner(System.in).nextInt();
		System.out.println("----------------------------------------");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("	無理なもんは無理。");
		System.out.println();
		System.out.println();
		System.out.println("			game over");
		System.out.print("			1.最初から 2.続きから　＞");
		input = new java.util.Scanner(System.in).nextInt();
		switch (input) {
		case 1:
			flags[9] = 1;
			break;
		case 2:
			break;
		}
	}

	public static void bridgeEnd(int[] pos, int[] flags, int[] keepPos) {
		System.out.print("1.急げ！ 2.前に進む 3.急げ！　9.チート＞");
		int input = new java.util.Scanner(System.in).nextInt();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("		あっ...");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.print("				0.fall＞");
		input = new java.util.Scanner(System.in).nextInt();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("		落ちちゃった。");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("			game over");
		System.out.print("			1.最初から 2.少し前から　＞");
		input = new java.util.Scanner(System.in).nextInt();
		switch (input) {
		case 1:
			flags[9] = 1;
			break;
		case 2:
			pos[0] = keepPos[0];
			pos[1] = keepPos[1];
			break;
		}
	}

	public static void inuEnd(int[] flags) {
		System.out.println("犬おおすぎるから寝る");
		System.out.println("game over");
		int input = new java.util.Scanner(System.in).nextInt();
		switch (input) {
		default:
			flags[9] = 1;
			break;
		}
	}

	/*
	 * ⓪メイン opening(); mapCreate();
	 * 
	 * while(true) walk(); display(map[][]); Scanner displayUnder(map[][]);
	 * 
	 * ending();
	 * 
	 * }
	 * 
	 * /*
	 * 
	 * 
	 * ①opning syso目が覚めたら (nomal(7*7)) （debugプレイ）
	 * 
	 * ②mapCreate
	 * 
	 * １．river(map[][]) x = mapSize/2 [x][全部]＝11=(川 通れない） [x+-1][全部]＝12=川が見える
	 * 橋がないと渡れない [x][yとz]=13=(橋 通れる) [x+-1][y+-とz+-]＝14＝橋が見える [x+-1][yとz]=15=橋だ
	 * 
	 * ２．forest x = mapsizeの乱数 [0と１と２][x]=0 → 21 ＝(森 通れない) [mapsize-0と-1と-2][x]=0 →
	 * 21 ＝(森 通れない)
	 * 
	 * 3.dog x y = mapsizeRan [x][y]/10 == 1 || 13 →reRandom else→31=犬
	 * 
	 * 9.home
	 * 
	 * 
	 * 10.pos[][] map[x][y]%10 ==1 → 乱数作り直し else →pos[x][y] direction =0-3
	 * switch(direction) 0:nextPos = [x+1][y]
	 * 
	 * ③.walk syso "now walking"
	 * 
	 * ④display(nextPos,map,pos); int excute = map[pos[0]][pos[1]] switch(excute){
	 * 
	 * ⑤displayUnder syso 1.左を向く 2.前に進む 3.右を向く etc Scanner → 1 =
	 * switch(direction)case0:nextpos[x-][y-] ... 3= ... 2 pos = nextpos;
	 * 
	 * 
	 * ⑥excute(pos,nextpos) switch(pos) switch()
	 * 
	 * 
	 * ⑥
	 * 
	 */
}
