package com.mediAssist.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.mediAssist.model.Category;
import com.mediAssist.model.Scope;

public class CategoryScopeExtractor implements ResultSetExtractor<Object> {

	@Override
	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Double, Category> map = new HashMap<Double, Category>();
		while(rs.next()){
			Double id = rs.getDouble("category_id");
			Category category = map.get(id);
			if(category == null){
				category = new Category();
				category.setCategoryId(rs.getDouble("category_id"));
				category.setCategoryName(rs.getString("category_name"));
				map.put(id, category);
			}
			
			//Double scopeId = rs.getDouble("scope_cat_id");
			List<Scope> scopes = category.getScopes();
			if(scopes == null){
				scopes = new ArrayList<Scope>();
				category.setScopes(scopes);
			}
			Scope scope = new Scope();
			scope.setScopeId(rs.getDouble("scope_cat_id"));
			scope.setScopeName(rs.getString("scope_name"));
			scope.setScopeSeqNumber(rs.getDouble("scope_seq_num"));
			scopes.add(scope);
			
		}
		
		return new ArrayList<Category>(map.values());
	}

}
