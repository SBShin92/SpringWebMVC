package himedia.springcontainer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext appContext =
				new ClassPathXmlApplicationContext("config/applicationContext.xml");
		// 클래스를 공유하는 빈이 있으면 .class접근 시 에러가 난다.
//		isSingleton(appContext);
		
//		moreBeansInSameClass(appContext);
		
		User user4 = (User)appContext.getBean("user4");
		User user5 = (User)appContext.getBean("user5");
		System.out.println("user4: " + user4);
		System.out.println("user5: " + user5);
		System.out.println("=====================");
		
		Friend friend6 = (Friend)appContext.getBean("friend6");
		System.out.println("friend6: " + friend6);
		User user6 = (User)appContext.getBean("user6");
		System.out.println("user6: " + user6);
		
		User user7 = (User)appContext.getBean("user7");
		System.out.println("user7: " + user7);
		
		
	}
	
	private static void moreBeansInSameClass(ClassPathXmlApplicationContext appContext) {
		System.out.println("======= Another Bean(user3) ==========");
		User userById = (User)appContext.getBean("user");
		System.out.println("userById : " + userById.getName());
		User user3 = (User)appContext.getBean("user3");
		System.out.println(userById == user3);
		
	}

	private static void isSingleton(ClassPathXmlApplicationContext appContext) {
		System.out.println("======= get Bean by Class ==========");		
		User userByClass = appContext.getBean(User.class);
		System.out.println("userByClass : " + userByClass.getName());
		System.out.println("======= get Bean by Id ==========");
		User userById = (User)appContext.getBean("user");
		System.out.println("userById : " + userById.getName());
		System.out.println("======= This is Singleton Factory! ==========");
		System.out.println("userByClass == userById ?: " + (userByClass == userById));
		System.out.println("is this Singleton? : " + appContext.isSingleton("user"));
		
	}
	
}
