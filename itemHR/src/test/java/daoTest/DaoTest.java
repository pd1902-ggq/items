package daoTest;

import com.iotek.dao.AdministratorDao;
import com.iotek.dao.AttendenceDao;
import com.iotek.model.Administrator;
import com.iotek.model.Attendence;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations="classpath:bean.xml")
public class DaoTest {
//    @Resource
    private AdministratorDao administratorDao=null;
    private AttendenceDao attendenceDao=null;
    @org.junit.Test
    public void testadd(){
        ApplicationContext context=new ClassPathXmlApplicationContext( "classpath:bean.xml" );
        AdministratorDao administratorDao= (AdministratorDao) context.getBean( "administratorDao" );
//        administratorDao.addAdmin( new Administrator( "aaa2","aaa" ) );
//        administratorDao.addAdmin( new Administrator( "aaa3","aaa" ) );
        Administrator administrator=new Administrator(  );
        administrator.seta_name( "aaa" );
        administrator.seta_pass( "aaa" );
        List<Administrator> administrators = administratorDao.queryAdmin( administrator );
        for (Administrator administrator1 : administrators) {
            System.out.println(administrator1);
        }

    }
    @Test
    public void test1(){
        ApplicationContext context=new ClassPathXmlApplicationContext( "classpath:bean.xml" );
        attendenceDao= (AttendenceDao) context.getBean( "attendenceDao" );
        List<Attendence> attendences = attendenceDao.queryAttendenceBypage( 0, 3 );
        for (Attendence attendence : attendences) {
            System.out.println(attendence);
        }
    }
}
