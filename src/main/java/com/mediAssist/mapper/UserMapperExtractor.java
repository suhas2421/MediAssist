package com.mediAssist.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.mediAssist.model.Shop;
import com.mediAssist.model.User;

public class UserMapperExtractor implements ResultSetExtractor<Object>{

	@Override
	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Double, User> map = new HashMap<Double, User>();
		while(rs.next()){
			Double id = rs.getDouble("user_id");
			User user = map.get(id);
			if(user==null){
				user = new User();
				user.setUserId(id);
				user.setUserName(rs.getString("user_name"));
				map.put(id, user);
			}
			
			Double shopId = rs.getDouble("shop_id");
			List<Shop> shopList = user.getShops();
			if(shopList == null){
				shopList = new ArrayList<Shop>();
				user.setShops(shopList);
			}
			Shop shop = new Shop();
			shop.setShopId(shopId);
			shop.setShopName(rs.getString("shop_name"));
			shop.setAddress(rs.getString("shop_address"));
			shopList.add(shop);
			
		}
		return new ArrayList<User>(map.values());
	}

}
