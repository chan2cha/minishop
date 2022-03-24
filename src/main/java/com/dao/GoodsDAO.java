package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.GoodsDTO;
import com.dto.MemberDTO;

public class GoodsDAO {

	public List<GoodsDTO> goodsList(SqlSession session, String gCategory) {
		List<GoodsDTO> list = session.selectList("GoodsMapper.goodsList", gCategory);
		return list;
	}

	


}
