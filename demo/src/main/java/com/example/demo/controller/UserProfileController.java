package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.UserProfileMapper;
import com.example.demo.model.UserProfile;

@RestController
public class UserProfileController {
	
	private UserProfileMapper mapper;
	//private Map<String, UserProfile> userMap;
	public UserProfileController(UserProfileMapper mapper) {
		this.mapper = mapper;
	}
	
//	@PostConstruct
//	public void init() {
//		userMap = new HashMap<String, UserProfile>();
//		userMap.put("1", new UserProfile("1", "홍길동", "1111-1111", "서울시 강남구 대치1동"));
//		userMap.put("2", new UserProfile("2", "강길동", "2222-1111", "서울시 강남구 대치2동"));
//		userMap.put("3", new UserProfile("3", "장길동", "3333-1111", "서울시 강남구 대치3동"));
//	}
	
	@GetMapping("/user/{id}")
	public UserProfile getUserProfile(@PathVariable("id") String id) {
		return mapper.getUSerProfile(id);
		//return userMap.get(id); <-- 매퍼를 연결하게 되면 이렇게 할 필요가 없어짐
	}
	
	@GetMapping("/user/all")
	public List<UserProfile> getUserProfileList() {
		return mapper.getUserProfileList();
		//return new ArrayList<UserProfile>(userMap.values());
	}
	
	@PutMapping("/user/{id}")
	public void putUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
		mapper.insertUserProfile(id, name, phone, address);
		//UserProfile userProfile = new UserProfile(id, name, phone, address);
		//userMap.put(id,userProfile);
	}
	
	@PostMapping("/user/{id}")
	public void postUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
		mapper.updateUserProfile(id, name, phone, address);
		//UserProfile userProfile = userMap.get(id);
		//userProfile.setName(name);
		//userProfile.setPhone(phone);
		//userProfile.setAddress(address);

	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUserProfile(@PathVariable("id") String id) {
		mapper.deleteUserProfile(id);
		//userMap.remove(id);
	}
	
}
