package cn.yy.JavaMail;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.junit.Test;

import cn.itcast.mail.AttachBean;
import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;

public class Demo1 {
	@Test
	public void fun1() throws Exception {
		/*
		 * 1. 得到session-
		 */
		Properties props = new Properties();
		props.setProperty("mail.host", "smtp.163.com");
		props.setProperty("mail.smtp.auth", "true");
		
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("18245014683", "zhangsiqi951016");
			}
		};
		
		Session session = Session.getInstance(props, auth);
		
		/*
		 * 2. 创建MimeMessage
		 */
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("18245014683@163.com"));//设置发件人
		msg.setRecipients(RecipientType.TO, "572176750@qq.com");//设置收件人
		//msg.setRecipients(RecipientType.CC, "572176750@qq.com");//设置抄送
		//msg.setRecipients(RecipientType.BCC, "572176750@qq.com");//设置暗送
		
		msg.setSubject("这是来自ITCAST的测试邮件");
		msg.setContent("这就是一封垃圾邮件！", "text/html;charset=utf-8");
		
		/*
		 * 3. 发送
		 */
		Transport.send(msg);
	}
	
	/**
	 * 带有附件的邮件！！！
	 */
	@Test
	public void fun2() throws Exception {
		/*
		 * 1. 得到session
		 */
		Properties props = new Properties();
		props.setProperty("mail.host", "smtp.163.com");
		props.setProperty("mail.smtp.auth", "true");
		
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("18245014683", "zhangsiqi951016");
			}
		};
		
		Session session = Session.getInstance(props, auth);
		
		/*
		 * 2. 创建MimeMessage
		 */
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("18245014683@163.com"));//设置发件人
		msg.setRecipients(RecipientType.TO, "572176750@qq.com");//设置收件人
		
		msg.setSubject("这是来自ITCAST的测试邮件有附件");
		
		
		////////////////////////////////////////////////////////
		/*
		 * 当发送包含附件的邮件时，邮件体就为多部件形式！
		 * 1. 创建一个多部件的部件内容！MimeMultipart
		 *   MimeMultipart就是一个集合，用来装载多个主体部件！
		 * 2. 我们需要创建两个主体部件，一个是文本内容的，另一个是附件的。
		 *   主体部件叫MimeBodyPart
		 * 3. 把MimeMultipart设置给MimeMessage的内容！
		 */
		MimeMultipart list = new MimeMultipart();//创建多部分内容
		
		// 创建MimeBodyPart
		MimeBodyPart part1 = new MimeBodyPart();
		// 设置主体部件的内容
		part1.setContent("hello Java Mail!", "text/html;charset=utf-8");
		// 把主体部件添加到集合中
		list.addBodyPart(part1);
		
		
		// 创建MimeBodyPart
		MimeBodyPart part2 = new MimeBodyPart();
		part2.attachFile(new File("E:/image.jpg"));//设置附件的内容
		part2.setFileName(MimeUtility.encodeText("哈哈.jpg"));//设置显示的文件名称，其中encodeText用来处理中文乱码问题
		list.addBodyPart(part2);
		
		msg.setContent(list);//把它设置给邮件作为邮件的内容。
		
		
		////////////////////////////////////////////////////////
		
		/*
		 * 3. 发送
		 */
		Transport.send(msg);		
	}
	
	@Test
	public void fun3() throws Exception {
		/*
		 * 1. 得到session
		 */
		Session session = MailUtils.createSession("smtp.163.com", 
				"18245014683", "zhangsiqi951016");
		/*
		 * 2. 创建邮件对象
		 */
		Mail mail = new Mail("18245014683@163.com",
				"572176750@qq.com",
				"hello welcom to here？", "this is agood essay");
		
		/*
		 * 创建两个附件对象
		 */
		AttachBean ab1 = new AttachBean(new File("E:/image.jpg"), "想想.jpg");
		AttachBean ab2 = new AttachBean(new File("E:/aaa.log"), "hello.log");
		
		// 添加到mail中
		mail.addAttach(ab1);
		mail.addAttach(ab2);
		
		/*
		 * 3. 发送
		 */
		MailUtils.send(session, mail);
	}
	//there is a bug and don't know how to send a message from qq email to qq email
	@Test
	public void fun4() throws MessagingException, IOException{
		Session session=MailUtils.createSession("smtp.qq.com", "572176750","yy#18686728024a");
		Mail mail =new Mail("572176750@qq.com", "1905492410@qq.com", "hello zsq", "welcom to our class!");
		MailUtils.send(session, mail);
		
	}
}
