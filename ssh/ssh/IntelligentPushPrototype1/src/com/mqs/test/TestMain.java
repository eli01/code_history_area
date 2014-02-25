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

		/*配置完hibernate后*/
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf=(SessionFactory)ac.getBean("sessionFactory");
		Session session=sf.openSession();
		Transaction t=session.beginTransaction();
		News news=new News("伊朗新总统鲁哈尼", "据报道，伊朗最高领袖哈梅内伊3日正式批准哈桑·鲁哈尼为伊朗第11届总统。鲁哈尼从即日起出任伊朗新一任总统。"+

"在当天进行全国电视直播的仪式上，鲁哈尼从哈梅内伊手中接过委任函。鲁哈尼向选民和哈梅内伊表示感谢。他说，自己不会辜负选民的支持与信任，将致力于建设一个和平稳定、充满希望的国家。", new Date(),
				new BigDecimal("422"), null);
	
		Users users=new Users(new Short("18"),"大黄", "男", "linux运维","棒球", "truman", new BigDecimal("18797417847"), null);
		Readingrecord rRecord=new Readingrecord(news, users, new Date(), new Date(),
				"鲁哈尼从哈梅内伊手中接过委任函");
		session.save(news);
		session.save(users);
		session.save(rRecord);
		t.commit();		
	}

}
