package com.apidesign.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.apidesign.user.entity.User;
import com.apidesign.user.repository.UserRepository;
import com.apidesign.user.vo.Department;
import com.apidesign.user.vo.ResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	//private static final Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	private String url = "http://DEPARTMENT-SERVICE/departments/";

	public User saveUser(User user) {
		log.info("Calling saveUser method of UserService");
		return userRepository.save(user);
	}

	public User findByUserId(Long userId) {
		return userRepository.findByUserId(userId);
	}

	public ResponseTemplateVO findUserWithDepartment(Long userId) {
		
		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user = findByUserId(userId);
		Department dept = restTemplate.getForObject(url + user.getDepartmentId(), Department.class);
		vo.setUser(user);
		vo.setDepartment(dept);
		return vo;
	}
}
