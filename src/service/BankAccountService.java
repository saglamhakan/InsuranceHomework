package service;

import model.BankAccount;

import java.math.BigDecimal;

public class BankAccountService {

    private String bankName;
    private String ibanNo;
    private BigDecimal amount;
    public BankAccount createBankAccount(String bankName, String ibanNo, BigDecimal amount){
         BankAccount bankAccount = new BankAccount();
         bankAccount.setBankName(bankName);
         bankAccount.setIbanNo(ibanNo);
         bankAccount.setAmount(amount);
         return bankAccount;
    }
/*
    public void makePayment(BankAccount receiverAccount, BankAccount senderAccount){
        receiverAccount.setAmount(receiverAccount.getAmount().add(amount)); //Alıcı hesabın mevcut bakiyesine ödeme tutarını ekler
        senderAccount.setAmount(senderAccount.getAmount().subtract(amount));// Gönderen hesabın mevcut bakiyesinden ödeme tutarını çıkarır
    }

 */
}
