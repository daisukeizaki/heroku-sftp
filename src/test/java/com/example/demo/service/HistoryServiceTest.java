package com.example.demo.service;
import static org.assertj.db.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.assertj.db.type.Changes;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.mybatis.dto.History;
import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.destination.DataSourceDestination;
import com.ninja_squad.dbsetup.destination.Destination;
import com.ninja_squad.dbsetup.operation.DeleteAll;
import com.ninja_squad.dbsetup.operation.Insert;
import com.ninja_squad.dbsetup.operation.Operation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HistoryServiceTest {
	@Autowired
	HistoryService service;

	@Autowired
	DataSource dataSource;

	@Rule
	public TestName testName = new TestName();
	
	public static final DeleteAll DELETE_ALL =
			Operations.deleteAllFrom("history");

	public static final Insert INSERT =
	        Operations.insertInto("history")
	                .columns("value")
	                .values("Tanaka")
	                .values("Yoshida")
	                .values("Suzuki")
	                .build();
	@Before
	public void setup() {
		Destination dest = new DataSourceDestination(dataSource);
		Operation ops = Operations.sequenceOf(DELETE_ALL, INSERT);
		DbSetup dbSetup = new DbSetup(dest, ops);
		dbSetup.launch();
	}

	@Test
	public void 全ての履歴データが取得できる() {
		List<History> result = service.getHistories();
		assertEquals(3, result.size());
		assertEquals("Tanaka", result.get(0).getValue());
		assertEquals("Yoshida", result.get(1).getValue());
		assertEquals("Suzuki", result.get(2).getValue());
	}

	@Test
	public void 一件の登録が正常にできる() {
        Changes changes = new Changes(dataSource);

        History record = new History();
		record.setValue("登録");

		changes.setStartPointNow();
		int result = service.createHistory(record);
		changes.setEndPointNow();

		assertEquals(1, result);
		assertThat(changes)
			.hasNumberOfChanges(1)
			.ofCreation().hasNumberOfChanges(1)
			.ofCreationOnTable("history").hasNumberOfChanges(1);
	}

}
