package qiucao.allureDemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Issues;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;

@Epic(value = "Allure测试报告演示Demo")
@Feature("演示Allure中的注解定制")
@Owner("城下秋草")
public class AllureTest {

	@Test
	@DisplayName("Allure描述")
	@Story("Allure注解描述")
	@Description("失败用例，此处为描述信息")
	@Severity(SeverityLevel.CRITICAL)
	void addDescription() {
		Assertions.assertTrue(false);
	}
	
	@Test
	@Story("Allure添加步骤")
	@Description("用例包含多个步骤")
	@Severity(SeverityLevel.NORMAL)
	void multiSteps() {
		step001();
		step002();
		step003();
	}
	
	@Step("用例步骤一")
	void step001() {}
	
	@Step("用例步骤二")
	void step002() {}
	
	@Step("用例步骤三")
	void step003() {}

	@Test
	@Story("Allure外部链接")
	@Description("失败用例关联issue")
	@Severity(SeverityLevel.BLOCKER)
	@Issue("1")
	void testIssues() {
		Assertions.assertEquals(2,3);
	}
	
	@Test
	@Story("Allure外部链接")
	@Description("关联用例管理系统用例链接")
	@Severity(SeverityLevel.MINOR)
	@TmsLink("Case001")
	void testTmsLink() {
		Assertions.assertEquals(2,2);
	}
	
	@Test
	@Story("Allure外部链接")
	@Description("关联外部资源链接")
	@Severity(SeverityLevel.MINOR)
	@Link(name = "5c83d2aa6d5f670edc43c606", type = "qiucao")
	void testLink() {
		Assertions.assertEquals(2,2);
	}
}
