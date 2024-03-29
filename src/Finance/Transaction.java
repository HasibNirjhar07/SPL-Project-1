package Finance;

import java.time.LocalDateTime;

class Transaction
{
    private String description;
    private double amount;
    private LocalDateTime dateTime;
    private String transactionType;

    public Transaction(String description, double amount, String transactionType)
    {
        this.description = description;
        if (amount < 0)
        {
            throw new IllegalArgumentException("Finance.Transaction amount must be non-negative.");
        }
        this.amount = amount;
        this.transactionType= transactionType;
        this.dateTime= LocalDateTime.now();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription()
    {
        return description;
    }

    public double getAmount()
    {
        return amount;
    }

    public String getTransactionType()
    {
        return transactionType;
    }
    public void setTransactionType(String type)
    {
        this.transactionType=type;
    }

    public LocalDateTime getDateTime()
    {
        return dateTime;
    }

}