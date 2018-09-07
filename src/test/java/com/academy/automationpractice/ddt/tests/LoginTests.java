package com.academy.automationpractice.ddt.tests;

import com.academy.automationpractice.ddt.util.PropertyManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTests extends BaseTest {
    protected static final Logger LOG = LogManager.getLogger(LoginTests.class);

    @Test(dataProvider = "authProvider")
    public void testAuthCorrect(String email, String password, String userNameExpected) throws Exception {
        LOG.info("Start 'testAuthCorrect'");

        manager.goTo().home();
        manager.session().login();

        manager.verify().userIsLoggedIn(userNameExpected);
        manager.session().logout();

        LOG.info("Complete 'testAuthCorrect'");
    }

    @Test(dataProvider = "incorrectLoginProvider", enabled = false)
    // TODO
    public void testAuthIncorrect(String email, String password, String errorMsg) {
        System.out.println("Start 'testAuthIncorrect'");
        System.out.println(String.format("email: %s, password:%s, errorMsg:%s", email, password, errorMsg));
        System.out.println("Complete 'testAuthIncorrect'");
    }

    @DataProvider(name="authProvider")
    private Object[][] authProvider() {
        return new Object[][]{
                {PropertyManager.getProperty("automation.username"), PropertyManager.getProperty("automation.password"), "Oleg Afanasiev"}
        };
    }

    @DataProvider(name = "incorrectLoginProvider")
    public Object[][] provideIncorrectAuthData() {
        String authDataPath = PropertyManager.getProperty("auth.incorrect.data");

        try (XSSFWorkbook workbook = new XSSFWorkbook(authDataPath)) {
            XSSFSheet sheet = workbook.getSheetAt(0);

            Object[][] data = new Object[sheet.getLastRowNum()][3];

            for (int r = 1; r <= sheet.getLastRowNum(); r++) {
                XSSFRow row = sheet.getRow(r);
                String email = row.getCell(0).getStringCellValue();
                String password = row.getCell(1).getStringCellValue();
                String errMsg = row.getCell(2).getStringCellValue();

                data[r-1][0] = email;
                data[r-1][1] = password;
                data[r-1][2] = errMsg;
            }

            return data;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
