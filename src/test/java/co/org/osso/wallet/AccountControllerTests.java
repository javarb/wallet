package co.org.osso.wallet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class WalletApplicationControllerTests {

    private AccountController accountController;
    private AccountService accountService;

    @Before
    public void config() {
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

        Account actual = accountsResponse.getData().get(0);
        assertEquals(Long.valueOf(1), actual.getId());
        assertEquals("test_1", actual.getAccount());
        assertEquals("Fullname Test", actual.getFullName());
    }
}
