package co.org.osso.wallet;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WalletApplicationTests {

    private AccountService AccountServiceTarget = new AccountService();

    @Test
    public void inMemoryAccountsNotNull() {
        ListAccountsResponse accounts = AccountServiceTarget.listAccounts();
        Assert.assertNotNull(accounts);

    }

    @Test
    public void inMemoryAccountNameEqualsTo() {
        ListAccountsResponse accounts = AccountServiceTarget.listAccounts();
        Assert.assertEquals("user_1", accounts.getData().get(1).getAccount());

    }
}
