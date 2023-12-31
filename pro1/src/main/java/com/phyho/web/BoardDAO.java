package com.phyho.web;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BoardDAO {

	List<Map<String, Object>> boardList();

	Map<String, Object> detail(int bno);

	int write(Map<String, Object> map);

}
