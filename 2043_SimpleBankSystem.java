class Bank {

    private long[] balance;  // Array to store account balances

    public Bank(long[] balance) {
        this.balance = balance;  // Initialize balances
    }

    // Method to transfer money between accounts
    public boolean transfer(int account1, int account2, long money) {
        // Check if both accounts are valid
        if (!isValid(account1) || !isValid(account2)) return false;
        // Check if account1 has enough balance
        if (balance[account1 - 1] < money) return false;
        // Perform transfer
        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;
        return true;
    }

    // Method to deposit money into an account
    public boolean deposit(int account, long money) {
        // Check if account is valid
        if (!isValid(account)) return false;
        // Add money to the account
        balance[account - 1] += money;
        return true;
    }

    // Method to withdraw money from an account
    public boolean withdraw(int account, long money) {
        // Check if account is valid
        if (!isValid(account)) return false;
        // Check if account has enough balance
        if (balance[account - 1] < money) return false;
        // Deduct money
        balance[account - 1] -= money;
        return true;
    }

    // Helper method to check if account number is valid
    private boolean isValid(int account) {
        return account >= 1 && account <= balance.length;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */
