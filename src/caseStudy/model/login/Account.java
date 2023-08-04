package caseStudy.model.login;

import java.io.Serializable;

public class Account implements Serializable {
    private static final long serialVersionUID = 234122996006267687L;
    private String  account ;
    private String password ;
    public Account() {
    }

    public Account(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
