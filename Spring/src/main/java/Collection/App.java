package Collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext con = new ClassPathXmlApplicationContext("Collection/config.xml");
		Student u1 =(Student)con.getBean(Student.class);
		System.out.println(u1);
    }
}
