package com.mediAssist.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mediAssist.model.Region;

public class RegionMapper implements RowMapper<Region>{

	@Override
	public Region mapRow(ResultSet rs, int rowNum) throws SQLException {
		Region region = new Region();
		region.setRegionId(rs.getDouble("region_id"));
		region.setRegionName(rs.getString("region_name"));
		return region;
	}

}
