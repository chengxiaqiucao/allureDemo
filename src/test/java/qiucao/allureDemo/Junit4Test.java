package qiucao.allureDemo;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.is;


import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Epic(value = "Allure测试报告演示Demo")
@Feature("Allure官方Junit4示例")
@Owner("城下秋草")
public class Junit4Test {
	@Test
	@Story("Junit4示例")
    public void simpleTest() throws Exception {
        assertThat(2, is(2));
    }

    @Step
    public void checkThat2is2() {
        assertThat(2, is(2));
    }

    @Test
    @Story("Junit4示例")
    public void simpleTestWithSteps() throws Exception {
        checkThat2is2();
    }

    @Attachment
    public String makeAttach() {
        return "yeah, 2 is 2";
    }

    @Test
    @Story("Junit4携带附件")
    @Description("附件直接输出内容")
    public void simpleTestWithAttachments() throws Exception {
        assertThat(2, is(2));
        makeAttach();
    }

    @Description("携带文件作为附件")
    @Test
    @Story("Junit4携带附件")
    public void csvAttachmentTest() throws Exception {
        saveCsvAttachment();
    }

    @Attachment(value = "Sample csv attachment", type = "text/csv")
    public byte[] saveCsvAttachment() throws URISyntaxException, IOException {
        URL resource = getClass().getClassLoader().getResource("sample.csv");
        if (resource == null) {
            fail("Couldn't find resource 'sample.csv'");
        }
        return Files.readAllBytes(Paths.get(resource.toURI()));
    }
}
