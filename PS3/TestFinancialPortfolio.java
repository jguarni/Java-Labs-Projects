import junit.framework.TestCase;


public class TestFinancialPortfolio extends TestCase {
    public void test_getNetBalance() {
        FinancialPortfolio portfolio = new FinancialPortfolio(
            "Jane Doe", 
            new Account[]{new Account("Checking", 500, 0),
                          new Account("Savings", 0, 0.01),
                          new Account("VISA", -1000, 0.02)});
        assertEquals(-500.0, portfolio.getNetBalance());
        
        portfolio.getAccounts()[1].deposit(750); // deposit $750 in savings
        
        assertEquals(250.0, portfolio.getNetBalance());
    }
    
    public void test_endOfMonth() {
        FinancialPortfolio portfolio = new FinancialPortfolio(
            "Jane Doe", 
            new Account[]{new Account("Checking", 500, 0),
                          new Account("Savings", 750, 0.01),
                          new Account("VISA", -1000, 0.02)});
        assertEquals(250.0, portfolio.getNetBalance());
        
        portfolio.endOfMonth(); 
        // checking should stay the same, savings should increase, VISA decrease
        
        assertEquals(237.5, portfolio.getNetBalance());
    }
    
    public void test_findAccountMethods() {
        FinancialPortfolio portfolio1 = new FinancialPortfolio(
            "Test", 
            new Account[]{new Account("Account1", 1000, 0),
                          new Account("Account2", 500, 0.01),
                          new Account("Account3", -750, 0.01),
                          new Account("Account4", -1500, 0)});
        assertEquals("Account1", portfolio1.getLowestInterestAccountWithPositiveBalance().getId());
        assertEquals("Account3", portfolio1.getHighestRateIndebtedAccount().getId());
        
        FinancialPortfolio portfolio2 = new FinancialPortfolio(
            "Test", 
            new Account[]{new Account("Account5", 1000, 0.015),
                          new Account("Account6", 500, 0.01),
                          new Account("Account7", 750, 0.02),
                          new Account("Account8", 1500, 0)});
        assertEquals("Account8", portfolio2.getLowestInterestAccountWithPositiveBalance().getId());
        assertEquals(null, portfolio2.getHighestRateIndebtedAccount()); // no indebted account

        FinancialPortfolio portfolio3 = new FinancialPortfolio(
            "Test", 
            new Account[]{new Account("Account9", -1000, 0),
                          new Account("Account10", -500, 0.01)});
        assertEquals(null, portfolio3.getLowestInterestAccountWithPositiveBalance()); // no positive account
        assertEquals("Account10", portfolio3.getHighestRateIndebtedAccount().getId());
    }
    
    public void test_payoffDebt1() {
        FinancialPortfolio portfolio = new FinancialPortfolio(
            "Jane Doe", 
            new Account[]{new Account("Checking", 500, 0),
                          new Account("Savings", 750, 0.01),
                          new Account("VISA", -1000, 0.02)});
        assertEquals(250.0, portfolio.getNetBalance());
        
        portfolio.payoffDebt();
        
        // should still have 250.0 net balance
        assertEquals(250.0, portfolio.getNetBalance());
        // checking should have zero balance
        assertEquals(0.0, portfolio.getAccounts()[0].getBalance());
        // savings should have 250.0 balance
        assertEquals(250.0, portfolio.getAccounts()[1].getBalance());
        //  VISA should have 0 balance
        assertEquals(0.0, portfolio.getAccounts()[2].getBalance());

        portfolio.endOfMonth(); 

        // checking should stay the same
        assertEquals(0.0, portfolio.getAccounts()[0].getBalance());
        //  savings should increase
        assertEquals(252.5, portfolio.getAccounts()[1].getBalance());
        //  VISA the same because it has 0 balance
        assertEquals(0.0, portfolio.getAccounts()[2].getBalance());

        assertEquals(252.5, portfolio.getNetBalance());
    }
    
    public void test_payoffDebt2() {
        // a portfolio with negative net balance that cannot pay off the full debt
        FinancialPortfolio inTheRed = new FinancialPortfolio(
            "Uncle Sam", 
            new Account[]{new Account("IRS", 1000, 0),
                          new Account("Savings Bonds", 500, 0.01),
                          new Account("Social Security", -750, 0.01),
                          new Account("Medicare", -1500, 0)});
        
        assertEquals(-750.0, inTheRed.getNetBalance());
        
        inTheRed.payoffDebt();
        assertEquals(-750.0, inTheRed.getNetBalance());
        
        // IRS and Savings Bonds should now have balance 0
        assertEquals(0.0, inTheRed.getAccounts()[0].getBalance());
        assertEquals(0.0, inTheRed.getAccounts()[1].getBalance());

        // Social Security should be paid off (balance of 0) because
        //  it had the highest interest rate of all negative balance accounts
        assertEquals(0.0, inTheRed.getAccounts()[2].getBalance());

        // but Medicare will still have -750 balance
        assertEquals(-750.0, inTheRed.getAccounts()[3].getBalance());
    }
}
