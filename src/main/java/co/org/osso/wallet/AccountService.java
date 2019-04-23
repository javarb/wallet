package co.org.osso.wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public AccountService(AccountRepository repo) {
        accountRepository = repo;
    }

    ListAccountsResponse listAccounts() {

        ListAccountsResponse accountsResponse = new ListAccountsResponse();
        for (Account account : accountRepository.findAll()) {
            accountsResponse.getData().add(account);
        }

        return accountsResponse;

    }

}

