package product.star.account.manager;

public interface AccountManager {
    void transfer(Account from, Account to, long amount);
    void transferByPhoneNumber(Account from, String phoneNumberTo, long amount);
}
