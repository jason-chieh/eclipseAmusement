package mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class JavaMail {
// ---------------------------------------------------------�򥻸��

	private String userName = "chimingchieh@gmail.com"; // �H��̫H�c
	private String password = "slcs vzzj zrhy xhjv"; // �H��̱K�X
	private String customer = "a2028290@gmail.com"; // ����̶l�c
	private String subject = "�A���J�������X"; // ���D
	private String txt = "<h1>�l�󤺮e</h1><h2>��r���e</h2>"; // ���e
	
	

	public String getCustomer() {
		return customer;
	}



	public void setCustomer(String customer) {
		this.customer = customer;
	}



	public String getTxt() {
		return txt;
	}



	public void setTxt(String txt) {
		this.txt = txt;
	}



	public void SendMail() {
		// ---------------------------------------------------------�s�u�]�w
		Properties prop = new Properties();

		// �]�w�s�u��smtp
		prop.setProperty("mail.transport.protocol", "smtp");

		// host�D��:smtp.gmail.com
		prop.setProperty("mail.host", "smtp.gmail.com");

		// host port:465
		prop.put("mail.smtp.port", "465");

		// �H��̱b���ݭn���ҡG�O
		prop.put("mail.smtp.auth", "true");

		// �ݭn�w����ƶǿ�h (SSL)�G�O
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		// �w����ƶǿ�h (SSL) �q�T��G465
		prop.put("mail.smtp.socketFactory.port", "465");

		// ��ܳs�u��T
		prop.put("mail.debug", "true");

		// ---------------------------------------------------------����
		// ---------------------------------------------------------Session�q�{�ݩʳ]�w��
		// �ΦW���O
//		Session session = Session.getDefaultInstance(prop, new Authenticator() {
//
//			@Override
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(userName, password);
//			}
//		});

		// class
		Auth auth = new Auth(userName, password);
		Session session = Session.getDefaultInstance(prop, auth);

		// ---------------------------------------------------------Message�l��榡
		MimeMessage message = new MimeMessage(session);

		try {
			// �H���
			// �ΦW���O
			// message.setSender(new InternetAddress(userName));

			// class
			InternetAddress sender = new InternetAddress(userName);
			message.setSender(sender);
			
			// �����
			message.setRecipient(RecipientType.TO, new InternetAddress(customer));
			
			// ���D
			message.setSubject(subject);
			
			// ���e/�榡
			message.setContent(txt, "text/html;charset = UTF-8");
			
			
			// ---------------------------------------------------------Transport�ǰeMessage
			Transport transport = session.getTransport();
			
			// transport�Nmessage�e�X
			transport.send(message);
			
			// ����Transport
			transport.close();
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}

class Auth extends Authenticator {

	private String userName;
	private String password;

	public Auth(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		PasswordAuthentication pa = new PasswordAuthentication(userName, password);
		return pa;
	}

}