package practice.notedays.smtp;

public class EmailForm {
	
	private final String from;
	private final String fromName;
	private final String subject;
	private final String body;

	public EmailForm(String from, String fromName, String subject, String body) {
		super();
		this.from = from;
		this.fromName = fromName;
		this.subject = subject;
		this.body = body;
	}

	public String getFrom() {
		return from;
	}

	public String getFromName() {
		return fromName;
	}

	public String getSubject() {
		return subject;
	}

	public String getBody() {
		return body;
	}

}
