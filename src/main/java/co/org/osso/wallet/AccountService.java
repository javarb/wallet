package co.org.osso.wallet;

import org.springframework.stereotype.Service;

@Service
public class AccountService {

    ListAccountsResponse listAccounts(){
        final ListAccountsResponse accountList = new ListAccountsResponse();
        for (int i = 0; i < 10; i++) {
            final Account account = new Account();
            account.setId(Long.valueOf(i));
            account.setAccount("user_" + i);
            account.setFullName("Test User " + i);
            accountList.getData().add(account);

        }
        return accountList;

    }

}

