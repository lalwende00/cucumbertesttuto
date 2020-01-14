package nicebank;

import lombok.Getter;

@Getter
public class Account {

    private Money balance = new Money();

    public void deposit(Money depositedAmount){
        balance.add(depositedAmount);
    }
}
