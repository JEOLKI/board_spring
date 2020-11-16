package kr.or.ddit;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//테스트 대상 : repository + service : roo-context.xml
//repaository 에서 주입받는 sqlSessionTemplate : datasource-context.xml
//transaction : transaction-context.xml
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:kr/or/ddit/config/spring/root-context.xml",
									"classpath:kr/or/ddit/config/spring/datasource-context_dev.xml",
									"classpath:kr/or/ddit/config/spring/transaction-context.xml" })
public class ModelTestConfig {

	@Resource(name = "dataSource")
	private DataSource dataSource;

	@Ignore
	@Test
	public void dummy() {
	}

	@Before
	public void setup() {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScripts(new ClassPathResource("/kr/or/ddit/config/db/initData.sql")); // 사용할 스크립트 경로
		populator.setContinueOnError(false); // 스크립트 실행중 에러 발생시 멈춤
		DatabasePopulatorUtils.execute(populator, dataSource);
	}

}
