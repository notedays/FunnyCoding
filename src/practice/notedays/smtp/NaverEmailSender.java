package practice.notedays.smtp;

/**
 * # NaverSMTP 서비스 클래스
 * 
 * - Naver Mail ( id@naver.com ) 계정으로 메일 전송
 * - SSL / TLS 작업에 다른 포트 분기 
 * 
 * @author Jeongwon
 *
 */
public class NaverEmailSender extends EmailSender{
	
	/* 
	 * # Naver SMTP 호스트 
	*/
	private final static String HOST = "smtp.naver.com";

	// # 포트 번호 (SSL : 465 / TLS : 587)
	private final static int PORT = 465;

	// # EmailSender 값 설정
	private NaverEmailSender(String host, int port) {
		super(host, port, port == 465);
	}
	
	// # SingleTone
	private static NaverEmailSender instance = new NaverEmailSender(HOST, PORT);
	public static NaverEmailSender getInstance() {
		return instance;
	}
}
