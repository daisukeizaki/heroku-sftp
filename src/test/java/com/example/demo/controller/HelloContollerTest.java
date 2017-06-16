package com.example.demo.controller;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.mybatis.dto.History;
import com.example.demo.service.HistoryService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloContollerTest {

	private MockMvc mvc;

	@Autowired
	 private WebApplicationContext wac;


	@Before
	public void setup() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Mock
	private HistoryService service;

	@Test
	public void test_index_正常系() throws Exception {
		mvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index"));
	}

	@Test
	public void test_history_正常系() throws Exception {
        when(this.service.getHistories()).thenReturn(new ArrayList<History>());
        mvc.perform(get("/history")).andExpect(status().isOk()).andExpect(view().name("history"));
	}

	@Test
	public void test_send_正常系() throws Exception {
        when(this.service.createHistory(anyObject())).thenReturn(1);
        mvc.perform(post("/").param("name", "something")).andExpect(status().isOk()).andExpect(view().name("result"));
	}

	@Test
	public void test_send_パラメータ不正() throws Exception {
        when(this.service.createHistory(anyObject())).thenReturn(1);
        mvc.perform(post("/")).andExpect(status().isBadRequest());
	}
}
