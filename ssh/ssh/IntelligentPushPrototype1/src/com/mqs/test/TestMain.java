package com.mqs.test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.mqs.domain.News;
import com.mqs.domain.Readingrecord;
import com.mqs.domain.Users;


public class TestMain {

	/**
	 * @param args
	 */
	@Transactional
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*������hibernate��*/
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf=(SessionFactory)ac.getBean("sessionFactory");
		Session session=sf.openSession();
		Transaction t=session.beginTransaction();
		News news=new News("��������ͳ³����", "�ݱ�����������������÷����3����ʽ��׼��ɣ��³����Ϊ���ʵ�11����ͳ��³����Ӽ��������������һ����ͳ��"+

"�ڵ������ȫ������ֱ������ʽ�ϣ�³����ӹ�÷�������нӹ�ί�κ���³������ѡ��͹�÷������ʾ��л����˵���Լ����Ṽ��ѡ���֧�������Σ��������ڽ���һ����ƽ�ȶ�������ϣ���Ĺ��ҡ�", new Date(),
				new BigDecimal("422"), null);
	
		Users users=new Users(new Short("18"),"���", "��", "linux��ά","����", "truman", new BigDecimal("18797417847"), null);
		Readingrecord rRecord=new Readingrecord(news, users, new Date(), new Date(),
				"³����ӹ�÷�������нӹ�ί�κ�");
		session.save(news);
		session.save(users);
		session.save(rRecord);
		t.commit();		
	}

}
