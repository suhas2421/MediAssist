package com.mediAssist.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediAssist.model.Category;
import com.mediAssist.model.Region;
import com.mediAssist.model.User;
import com.mediAssist.repository.impl.UserRepository;
import com.mediAssist.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public Map<String, List<User>> getAllUsers() {
		Map<String, List<User>> map = new HashMap<String, List<User>>();
		map.put("response", userRepository.getAllUsersWithDetails());
		return map;
	}

	@Override
	public Map<String, String> saveUsers(List<User> users) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("response", userRepository.saveUsers(users));
		return map;
	}

	@Override
	public List<Category> getCatScope() {
		return userRepository.getScopeCat();
		/*List<CatScopeVO> catScopeVOs = new ArrayList<CatScopeVO>();
		CatScopeVO catScopeVO;
		for (CategoryScope categoryScope : categoryScopes) {
			catScopeVO = new CatScopeVO();
			
			catScopeVOs.add(catScopeVO);
		}
		return null;*/
	}

	@Override
	public List<Region> getRegion() {
		return userRepository.getRegions();
	}

}
