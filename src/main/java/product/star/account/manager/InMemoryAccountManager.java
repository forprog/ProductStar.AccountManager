package product.star.account.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InMemoryAccountManager implements AccountManager {
    PhoneToAccountResolver phoneToAccountResolver;

    @Autowired
    public InMemoryAccountManager(PhoneToAccountResolver phoneToAccountResolver) {
        this.phoneToAccountResolver = phoneToAccountResolver;
    }

    @Override
    public void transfer(Account from, Account to, long amount) {
        if (from.getAmount() < amount) {
            throw new IllegalStateException("Not enough money: " + from);
        }
        from.setAmount(from.getAmount() - amount);
        to.setAmount(to.getAmount() + amount);
    }

    @Override
    public void transferByPhoneNumber(Account from, String phoneNumberTo, long amount) {
        Account accountTo = phoneToAccountResolver.findAccountByPhoneNumber(phoneNumberTo).orElseThrow(() -> new IllegalArgumentException("Account not found by phone: " + phoneNumberTo));

        transfer(from, accountTo, amount);
    }
}
