package edu.whut.web.junit;

import edu.whut.web.config.AppConfig;
import edu.whut.web.dao.OrganizationDao;
import edu.whut.web.dao.RoleDao;
import edu.whut.web.dao.UserDao;
import edu.whut.web.domain.Organization;
import edu.whut.web.domain.Role;
import edu.whut.web.domain.User;
import edu.whut.web.util.MD5;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDaoTest {
	static UserDao userDao;
	static OrganizationDao organizationDao;
	static RoleDao roleDao;

	static long userId = 1;
	User user = null;
	
	@BeforeClass
	public static void before() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);
		organizationDao = context.getBean(OrganizationDao.class);
		userDao = context.getBean(UserDao.class);
		roleDao = context.getBean(RoleDao.class);
	}

	@AfterClass
	public static void after() {
	}
	
	@Test
	public void test1FindAllUsers() {
		List<User> users = userDao.findAllOnes();
		assertTrue(users.size()>0);
	}

	@Test
	public void test2Insert() {
		user = new User();
		user.setName("qixin");
		user.setEmail("eee@163.com");
		MD5 md5 = new MD5();
		user.setPassword(md5.getMD5ofStr("123456"));
		Organization organization = new Organization();
		organization.setId(1);
		user.setOrganization(organization);
        user = userDao.insert(user);

        Set<Role> roles = new HashSet<Role>();
        Role role1 = roleDao.findById(1);
        roles.add(role1);
        user.setRoles(roles);
        userDao.update(user);
		userId = user.getId();
		assertTrue(userId > 1);
	}

	@Test
	public void test3FindById() {
		user = userDao.findById(userId);
		assertNotNull(user);
		assertNotNull(user.getOrganization());
		assertTrue(user.getRoles().size()>0);
	}
	@Test
	public void test4Update() {
		user = userDao.findById(userId);
		user.setName("刘明");
		Organization organization = new Organization();
		organization.setId(2);
		user.setOrganization(organization);
		user = userDao.update(user);		
		assertNotNull(user);
	}

	@Test
	public void test5Delete() {
		user = userDao.findById(userId);
		user = userDao.delete(user);
		assertNotNull(user);
	}

	@Test
	public void test6FindAllOnes() {
		List<User> users = userDao.findAllOnes();
		assertTrue(users.size() > 0);
	}
	
}
