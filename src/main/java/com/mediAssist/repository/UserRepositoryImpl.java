package com.mediAssist.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mediAssist.mapper.CategoryScopeExtractor;
import com.mediAssist.mapper.UserMapper;
import com.mediAssist.mapper.UserMapperExtractor;
import com.mediAssist.model.Category;
import com.mediAssist.model.Region;
import com.mediAssist.model.User;
import com.mediAssist.repository.impl.UserRepository;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	StringBuffer query;

	@Override
	@Transactional(readOnly = true)
	public List<User> getAllUsers() {
		String query = "select * from user";
		return jdbcTemplate.query(query, new UserMapper());
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<User> getAllUsersWithDetails() {
		String query = "select * from user left join shop on user.user_id = shop.user_id order by user.user_id";
		return (List<User>) jdbcTemplate.query(query, new UserMapperExtractor());
	}

	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Category> getScopeCat() {
		String query = "select region.region_id,region.region_name,"
				+ "site.site_id, site.site_name, category.category_id, category.category_name, category.category_seq as cat_seq_num,"
				+ "scope_category.scope_cat_id, scope_category.scope_name, scope_category.scope_seq as scope_seq_num "
				+ "from region "
				+ "inner join site on site.region_id = region.region_id "
				+ "inner join site_scope_category on site_scope_category.site_id = site.site_id "
				+ "inner join scope_category on scope_category.scope_cat_id = site_scope_category.scope_cat_id "
				+ "inner join category on category.category_id = scope_category.category_id";
		return (List<Category>) jdbcTemplate.query(query, new CategoryScopeExtractor());
		//return jdbcTemplate.query(query, new CategoryScopeMapper());
	}
	
	@Override
	public String saveUsers(final List<User> users) {
		String sql = "INSERT INTO USER " + "(user_name) VALUES (?)";
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			@Override
			public int getBatchSize() {
				return users.size();
			}

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				User user = users.get(i);
				ps.setString(1, user.getUserName());
			}

		});

		return null;
	}

	@Override
	public List<Region> getRegions() {
		String query = "select * from region";
		return jdbcTemplate.query(query, new RegionMapper());
	}

	/*
	select * from region
	left join site on site.region_id = region.region_id
	left join site_scope_category on site_scope_category.site_id = site.site_id
	left join scope_category on scope_category.scope_cat_id = site_scope_category.scope_cat_id
	left join category on category.category_id = scope_category.category_id*/

	/*
	 * select * from shop_customer left join shop on shop_customer.shop_id =
	 * shop.shop_id left join customer on shop_customer.customer_id =
	 * customer.customer_id left join user on user.User_Id = shop.user_id where
	 * user.User_Id = 2
	 */
}
