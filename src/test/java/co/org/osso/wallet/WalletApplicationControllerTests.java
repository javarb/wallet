package co.org.osso.wallet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WalletApplicationControllerTests {

    private AccountController accountController;
    private AccountService accountService;

    @Before
    public void config(){
        accountService = Mockito.mock(AccountService.class);
        accountController = new AccountController(accountService);
    }

    @Test
    public void testServiceListAccountAnswerFromController() {
        final Account account = new Account();
        final ListAccountsResponse accountList = new ListAccountsResponse();
        account.setId(Long.valueOf(1));
        account.setAccount("test_1");
        account.setFullName("Fullname Test");
        accountList.getData().add(account);

        Mockito.when(accountService.listAccounts()).thenReturn(accountList);
        ListAccountsResponse accountsResponse = accountController.listAccounts();

        Assert.assertEquals(accountsResponse.getData().get(0).getId(),Long.valueOf(1));
        Assert.assertEquals(accountsResponse.getData().get(0).getAccount(),"test_1");
        Assert.assertEquals(accountsResponse.getData().get(0).getFullName(),"Fullname Test");
    }
}
