package qiucao.allureDemo;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

@Epic(value = "Allure测试报告演示Demo")
@Feature("Allure官方Junit5示例")
@Owner("城下秋草")
class Junit5SimpleTest {

    @Test
    @Feature("示例功能")
    @Severity(SeverityLevel.CRITICAL)
    void testOutput() {
        firstStep();
    }

    @Step
    private void firstStep() {
    }
}