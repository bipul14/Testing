package com.wwjdbc.mapper;

import java.util.List;

public class QueryMaker {
	Function f=(List<String>list) -> {
		String q="null or";
		for(String query:list) {
			q=q.concat(query)+"or ";
		}
		return q;
	};
	
	String s="select * from emp"+f;
	
}

interface Function{
	String function(List<String>list);
}