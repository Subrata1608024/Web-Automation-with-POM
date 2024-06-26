package com.parabank.parasoft.testcases;

import com.parabank.parasoft.pages.AccountOpenedPage;
import com.parabank.parasoft.pages.CustomerLoginPage;
import com.parabank.parasoft.pages.OpenNewAccountPage;
import com.parabank.parasoft.pages.OverviewPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenNewAccountTest extends BaseTest{

    @Test
    public void openAccountShouldSucceed(){

      CustomerLoginPage loginPage =  page.getInstance(CustomerLoginPage.class);
 //     OverviewPage overviewPage=loginPage
    //          .fillUsername(getUsername())
     //         .fillPassword(getPassword())
     //         .clickLoginBtn();

        OverviewPage overviewPage = loginPage
                .dologin(getUsername(),getPassword());

        OpenNewAccountPage openNewAccountPage = overviewPage
                .clickOpenNewAccountLink()
                .selectAccount(1)
                .selectAccount(0);

        AccountOpenedPage accountOpenedPage = openNewAccountPage
                .clickNewAccountBtn();
        Assert.assertTrue(accountOpenedPage.isNewAccountId());
    }
    @Test
    public void openAccountShouldSucceed2(){

        AccountOpenedPage openedPage =  page.getInstance(CustomerLoginPage.class)
                .dologin(getUsername(),getPassword())
                .clickOpenNewAccountLink()
                .selectAccount(1)
                .selectAccount(0)
                .clickNewAccountBtn();
        Assert.assertTrue(openedPage.isNewAccountId());
    }

}
