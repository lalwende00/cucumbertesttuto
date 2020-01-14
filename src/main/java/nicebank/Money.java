package nicebank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Money {

    private int dollars;
    private int cents;

    public Money add(Money depositedAmount) {
        this.dollars += depositedAmount.getDollars();
        this.cents += depositedAmount.getCents();
        return this;
    }
}
