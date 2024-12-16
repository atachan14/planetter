package model.upGrade;

import java.util.Random;

import model.data.UpGradeData;

public class DestinyDrowManager {

	public static UpGradeData nomalExe(String plName) {
		Random random = new Random();
		int destiny = random.nextInt(6);

		return nomalDestiny(destiny);
	}

	public static UpGradeData hyperExe(String plName) {
		Random random = new Random();
		int destiny = random.nextInt(6);

		return hyperDestiny(destiny);
	}

	static UpGradeData nomalDestiny(int destiny) {
		switch (destiny) {
		case 0:
			return new UpGradeData(0, "トランポリン設置", 4000);
		case 1:
			return new UpGradeData(1, "お引越し", 20000);
		case 2:
			return new UpGradeData(2, "ホームを作成", 40000);
		case 3:
			return new UpGradeData(3, "ダンスタイム制定", 35000);
		case 4:
			return new UpGradeData(4, "ミサイル発射", 55000);
		case 5:
			return new UpGradeData(5, "宇宙犬を放流", 8000);
		case 6:
			return new UpGradeData(6, "アンテナを設置", 60000);
		case 7:
			return new UpGradeData(7, "テレパシー送信", 15000);
		case 8:
			return new UpGradeData(8, "プラネットツリー", 10000);
		case 9:
			return new UpGradeData(9, "サイズ拡張", 1000);
		case 10:
			return new UpGradeData(10, "未知との遭遇", 22222);
		default:
			System.out.println("nomalDestiny default:" + destiny);
			return null;
		}
	}

	static UpGradeData hyperDestiny(int destiny) {
		switch (destiny) {
		case 0:
			return new UpGradeData(100, "ステルス化", 500000);
		case 1:
			return new UpGradeData(101, "ぷらねっとチャット解除", 200000);
		case 2:
			return new UpGradeData(102, "ギャラクシーワープ", 230000);
		case 3:
			return new UpGradeData(103, "衛星化", 350000);
		case 4:
			return new UpGradeData(104, "ギャラクシーアナウンス", 280000);
		case 5:
			return new UpGradeData(105, "ギャラクシーワープ", 230000);
		default:
			System.out.println("nomalDestiny default:" + destiny);
			return null;
		}

	}
}
