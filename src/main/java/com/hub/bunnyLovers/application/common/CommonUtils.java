package com.hub.bunnyLovers.application.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class CommonUtils {

	/**
	 * 문자열이 null이거나 공백인 경우 빈 문자열을 반환하고, 그렇지 않으면 문자열을 반환합니다.
	 *
	 * @param input 입력 문자열
	 * @return 조건에 따라 처리된 문자열
	 */
	public static String ifNotNullOrEmpty(String str) {
		return Objects.requireNonNullElse(str, "");
	}

	/**
	 * 두 개의 문자열을 입력받아 첫 번째 문자열이 null이거나 공백인 경우 두 번째 문자열을 반환하고, 그렇지 않으면 첫 번째 문자열을 그대로 반환합니다.
	 *
	 * @param str1 첫 번째 문자열
	 * @param str2 두 번째 문자열
	 * @return 조건에 따라 처리된 문자열
	 */
	public static String getOrElse(String str1, String str2) {
		return Objects.requireNonNullElse(str1, str2);
	}

	public static LocalDateTime formatToLocalDateTime(String format) {
		return LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern(format)),
			DateTimeFormatter.ofPattern(format));
	}

}
