package practice.notedays.smtp;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * # SMTP 활용한 메일 전송 클래스<br>
 * 
 * - java SMTP를 활용한 메일 전송 클래스
 * - config.properties 에 SMTP 인증정보 (유저/비번) 정의할 것!
 * - Connection 정보를 다른 것으로 갱신할땐 refreshConnectionInfo() 활용!
 * 
 * @author JeongWon
 *
 */
public class EmailSender {

	// @ SMTP 연결 및 인증 관련
	private String host;
	private String userName;
	private String password;

	private Properties props;
	private Session session;

	public EmailSender(String host, int port, boolean isSSL) {
		// @ 전역 변수 설정
		this.host = host;

		// @ 커넥션 설정값 Properties 생성
		props = System.getProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		if (isSSL) {
			props.put("mail.smtp.ssl.enable", "true");
		}

		// @ 위의 Properties 설정값으로 세션 오브젝트 생성
		session = Session.getDefaultInstance(props);
	}

	/**
	 * <strong># SMTP 메일 전송 서비스</strong>
	 * 
	 * @param from : 보내는 사람 메일 주소
	 * @param fromName : 보내는 사람 이름
	 * @param toAddress : 받는 사람 메일 주소
	 * @param subject : 메일 제목
	 * @param body : 메일 안의 내용 (html 작성)
	 * 
	 * @throws AddressException : 받는 사람 메일 주소 오류
	 * @throws MessagingException : 메일 전송 설정 오류 
	 * @throws UnsupportedEncodingException : 보내는 사람 (이름 및 주소) 설정 오류
	 */
	public void send(String from, String fromName, String subject, String body, String toAddress)
			throws AddressException, MessagingException, UnsupportedEncodingException {
		// @ 메세지 생성
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(from, fromName));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
		msg.setHeader("Content-Type", "text/html");
		msg.setSubject(subject);
		msg.setContent(body, "text/html; charset=UTF-8");

		try (Transport transport = session.getTransport()) {
			// @ 위에 설정된 SMTP 유저명 & 비밀번호로 커넥션 생성
			transport.connect(host, userName, password);

			// @ 메일 전송
			transport.sendMessage(msg, msg.getAllRecipients());
		}

		// @ 결과 로그 출력
		StringBuilder builder = new StringBuilder("[ EmailSender ]\n");
		builder.append(String.format("%-7s : %s", "From", fromName + "<" + from + ">"));
		builder.append("\n");
		builder.append(String.format("%-7s : %s", "To", toAddress));
		builder.append("\n");
		builder.append(String.format("%-7s : %s", "Subject", subject));
		System.out.println(builder.toString());
	}

	public void send(EmailForm email, String toAddress) throws AddressException, UnsupportedEncodingException, MessagingException {
		send(email.getFrom(), email.getFromName(), email.getSubject(), email.getBody(), toAddress);
	}

	public void refreshConnectInfo(String host, String userName, String password) {
		this.host = host;
		this.userName = userName;
		this.password = password;
	}

}
