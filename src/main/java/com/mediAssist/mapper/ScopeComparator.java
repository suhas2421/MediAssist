package com.mediAssist.mapper;

import java.util.Comparator;

import com.mediAssist.model.Scope;

public class ScopeComparator implements Comparator<Scope>{

	@Override
	public int compare(Scope s1, Scope s2) {
		int i = s1.getScopeId().compareTo(s2.getScopeId());
		System.out.println("from comparator >>> "+i);
		return i;
	}

}
