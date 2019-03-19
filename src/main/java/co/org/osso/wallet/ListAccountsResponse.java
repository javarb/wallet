package co.org.osso.wallet;

import java.util.ArrayList;
import java.util.List;

class ListAccountsResponse {
    private List<Account> data = new ArrayList<>();

    public List<Account> getData() {
        return data;
    }

    public void setData(List<Account> data) {
        this.data = data;
    }


}
