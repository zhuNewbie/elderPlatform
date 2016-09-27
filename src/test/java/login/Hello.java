package login;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Hello h = (Hello) ctx.getBean("hl");
		System.out.println(h);
		ClassPathXmlApplicationContext t = (ClassPathXmlApplicationContext)ctx;
		t.close();
	}

}
