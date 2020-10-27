package kr.or.ddit.util;

public class HtmlConvert {

	/**
	 * 문자열을 받아들여 문자열 각각의 첫줄에 : 를 붙인다. 게시판에서 reply에 대한 글을 처리할 경우 사용된다.
	 * 
	 * @param msg 변경할 문자열
	 * @return 변경된 문자열
	 */
	public static String reContent(String msg) {
		msg = specialChar(msg);
		StringBuffer sb = new StringBuffer();
		sb.append(":");
		for (int i = 0; i < msg.length(); i++) {
			if (msg.charAt(i) == '\n') {
				sb.append(msg.charAt(i));
				sb.append(":");
			} else {
				sb.append(msg.charAt(i));
			}

		}
		return sb.toString();
	}

	/**
	 * 공백에 대한 처리를 한다. \n 는 <br>
	 * , \t 는 &nbsp;&nbsp;&nbsp; 로 ' ' 는 &nbsp;로 각각 변경한다.
	 * 
	 * @param msg 변경할 문자열
	 * @return 변경된 문자열
	 */
	public static String whiteSpace(String msg) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < msg.length(); i++) {
			if (msg.charAt(i) == '\n') {
				sb.append("<br>");
			} else if (msg.charAt(i) == '\t') {
				sb.append("&nbsp;&nbsp;&nbsp;");
			} else if (msg.charAt(i) == ' ') {
				sb.append("&nbsp;");
			} else
				sb.append(msg.charAt(i));
		}
		return sb.toString();
	}

	/**
	 * 문자열을 받아들여 &, ", \, <, > 등의 문자를 &amp;, &quot;, &#039, &lt; , &gt;로 변경한다.
	 * 
	 * @param msg 변경할 문자열
	 * @return 변경된 문자열
	 */
	public static String specialChar(String msg) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < msg.length(); i++) {
			if (msg.charAt(i) == '&') {
				sb.append("&amp;");
			} else if (msg.charAt(i) == '"') {
				sb.append("&quot;");
			} else if (msg.charAt(i) == '\'') {
				sb.append("&#039;");
			} else if (msg.charAt(i) == '<') {
				sb.append("&lt;");
			} else if (msg.charAt(i) == '>') {
				sb.append("&gt;");
			} else
				sb.append(msg.charAt(i));
		}
		return sb.toString();
	}

}
