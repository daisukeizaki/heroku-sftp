package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.mybatis.dto.History;
import com.example.demo.service.HistoryService;

@Controller
@EnableAutoConfiguration
public class HelloController {
	@Autowired
	HistoryService service;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(Model model) {
		// 次のHTML名
		return "index";
	}
	
	@RequestMapping(value="/history", method=RequestMethod.GET)
	public String history(Model model) {
		model.addAttribute("histories", service.getHistories());
		
		// 次のHTML名
		return "history";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String send(
			// 画面から受け取ったパラメータ
			@RequestParam("name") String name,
			Model model) {

		// 画面に渡すパラメータ
		model.addAttribute("msg", "あなたは" + name + "と入力しました。");
		
		// 履歴登録
		History history = new History();
		history.setValue(name);
		service.createHistory(history);
		
		// 次のHTML名
		return "result";
	}
}
