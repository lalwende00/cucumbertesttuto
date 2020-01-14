package nicebank;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CashWithdrawalSteps {

    //private Account myAccount;
    private KnowsMyAccount helper;

    public CashWithdrawalSteps(){
        helper = new KnowsMyAccount();
    }

    @Given("I have deposited ${money} in my account")
    public void iHaveDeposited$InMyAccount(Money money) {
        System.out.println("$" + money.getDollars() + "." + money.getCents());
        helper.getMyAccount().deposit(money);
        Assert.assertEquals("Incorrect account balance -", money, helper.getMyAccount().getBalance());
    }

    @When("I request ${int}")
    public void iRequest$(int requestedAmount) {
        Teller teller = new Teller();
        teller.withdrawFrom(helper.getMyAccount(), requestedAmount);
    }

    @Then("${int} should be dispensed")
    public void $ShouldBeDispensed(int arg0) {
       // throw new PendingException();
    }

    static class KnowsMyAccount{
        private Account myAccount;

        Account getMyAccount(){
            if(myAccount == null) myAccount = new Account();
            return myAccount;
        }
    }

}
