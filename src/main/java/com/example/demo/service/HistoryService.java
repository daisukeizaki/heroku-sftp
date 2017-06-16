package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mybatis.dto.History;
import com.example.demo.mybatis.dto.HistoryExample;
import com.example.demo.mybatis.mapper.HistoryMapper;

@Service
public class HistoryService {
	@Autowired
	private HistoryMapper mapper;

	public int createHistory(History history) {
		return mapper.insertSelective(history);
	}

	public List<History> getHistories() {
		return mapper.selectByExample(new HistoryExample());
	}
}
