package com.apidesign.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apidesign.user.entity.User;
import com.apidesign.user.service.UserService;
import com.apidesign.user.vo.ResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

	//private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		log.info("Calling saveUser controller method.");
		return userService.saveUser(user);
	}

//	@GetMapping("/{id}")
//	public User findUserById(@PathVariable("id") Long userId) {
//		log.info("Calling saveUser controller method.");
//		return userService.findUserById(userId);
//	}

	@GetMapping("/{id}")
	public ResponseTemplateVO findUserWithDepartment(@PathVariable("id") Long userId) {
		log.info("Calling findUserWithDepartment controller method.");
		return userService.findUserWithDepartment(userId);
	}
}
