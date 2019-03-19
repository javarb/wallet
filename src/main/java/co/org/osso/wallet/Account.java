package co.org.osso.wallet;

class Account {
    private Long id;
    private String account;
    private String fullName;

    public void setId(Long id) {
        this.id = id;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getId() {
        return this.id;
    }

    public String getAccount() {
        return this.account;
    }

    public String getFullName() {
        return this.fullName;
    }

}
