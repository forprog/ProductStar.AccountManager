package product.star.account.manager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AccountMangerMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AccountManagerConfig.class);
        AccountManager accountManager = applicationContext.getBean(AccountManager.class);
        PhoneToAccountResolver phoneToAccountResolver = applicationContext.getBean(PhoneToAccountResolver.class);

        Account account1 = new Account(1,1000);
        Account account2 = new Account(2,2000);

        System.out.println(account1);

        String phoneNumber = "1234567";
        phoneToAccountResolver.addMapping(phoneNumber,account2);
        accountManager.transferByPhoneNumber(account1,phoneNumber,500);

        System.out.println(account1);
        System.out.println(account2);

        accountManager.transfer(account1,account2,250);

        System.out.println(account1);
        System.out.println(account2);

        accountManager.transferByPhoneNumber(account1,"123",100);

    }
}
