package model.tool;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;

public class dayCount {
	public static String getKeepDay(Timestamp timestamp) {
		// 現在の日時を取得
		LocalDateTime now = LocalDateTime.now();

		// データベースから取得したTimestampをLocalDateTimeに変換
		LocalDateTime createdTime = timestamp.toLocalDateTime();

		// 現在時刻との差を計算
		Duration duration = Duration.between(createdTime, now);
		long daysElapsed = duration.toDays();

		// 表示用のフォーマットを返す
		return daysElapsed + "日目";
	}

	
}
