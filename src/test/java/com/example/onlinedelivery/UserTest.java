package com.example.onlinedelivery;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.onlinedelivery.model.Role;
import com.example.onlinedelivery.model.User;
import com.example.onlinedelivery.services.GenericService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
//@ContextConfiguration(classes = CustomConfig.class, loader = AnnotationConfigContextLoader.class)
public class UserTest {
	
@Autowired
GenericService<User> userService;
	@Test
	public void addUser() {
		User user = new User();
		user.setFirstName("ram");
		user.setLastName("basnet");
		user.setContactNo("986890");
		user.setAddress("shankhamul");
		user.setDob(new Date());
		user.setGender("male");
		user.setUsername("ram");
		user.setPassword("ram");
//		List<Role> role = new ArrayList<>();
//		role.setName("admin");
//		user.setRoles(role);
		int id =userService.saveInfo(user).getId();
	log.debug("saved {}",id);
	userService.deleteById(id);
	log.debug("deleted");
		
	}

}
