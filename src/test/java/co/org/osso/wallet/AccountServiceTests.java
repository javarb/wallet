package co.org.osso.wallet;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class AccountServiceTests {

    private AccountRepository mockRepo = Mockito.mock(AccountRepository.class);
    private AccountService target = new AccountService(mockRepo);

    @Test
    public void whenNotDataInDBReturnEmptyJSON() {
        when(mockRepo.findAll()).thenReturn(new ArrayList<>());
        ListAccountsResponse response = target.listAccounts();
        assertEquals(0, response.getData().size());

    }

    @Test
    public void whenThereIsFiveAccountInDBReturnFiveAccountJSON() {
        when(mockRepo.findAll()).thenReturn(asList(
                makeAccount(1L),
                makeAccount(2L),
                makeAccount(3L),
                makeAccount(4L),
                makeAccount(5L)
        ));
        ListAccountsResponse response = target.listAccounts();
        assertEquals(5, response.getData().size());
        for (int i = 1; i <= response.getData().size(); i++) {
            Account actual = response.getData().get(i - 1);
            assertEquals(Long.valueOf(i), actual.getId());
            assertEquals("account_" + i, actual.getAccount());
            assertEquals("Account number " + i, actual.getFullName());
        }

    }

    private Account makeAccount(Long i) {
        Account account = new Account();
        account.setId(i);
        account.setAccount("account_" + i);
        account.setFullName("Account number " + i);
        return account;
    }

}
