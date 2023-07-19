package service;

import model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    ProposalService proposalService = new ProposalService();
    PaymentMovementService paymentMovementService = new PaymentMovementService();


    public Customer createCustomer(String name, CustomerTypeEnum customerTypeEnum){
        Customer customer = new Customer();
        customer.setName(name);
        customer.setCustomerTypeEnum(customerTypeEnum);
        return customer;
    }

    public void addBankAccountToCustomer(Customer customer, BankAccount bankAccount){
        if (customer.getBankAccountList()!=null){
            customer.getBankAccountList().add(bankAccount);
        }
        ArrayList<BankAccount> bankAccountList = new ArrayList<>();
        bankAccountList.add(bankAccount);
        customer.setBankAccountList(bankAccountList);
    }

    public void addInsuranceRequestToCustomer(Customer customer, InsuranceRequest insuranceRequest) {
        if (customer.getInsuranceRequestList() != null) {
            customer.getInsuranceRequestList().add(insuranceRequest);
        } else {
            ArrayList<InsuranceRequest> insuranceRequestList = new ArrayList<>();
            insuranceRequestList.add(insuranceRequest);
            customer.setInsuranceRequestList(insuranceRequestList);
        }
    }

    public void addPolicyListToCustomer(Customer customer, Policy policy) {
        if (customer.getPolicyList() != null) {
            customer.getPolicyList().add(policy);
        } else {
            ArrayList<Policy> policyRequestList = new ArrayList<>();
            policyRequestList.add(policy);
            customer.setPolicyList(policyRequestList);
        }
    }

    public void addPaymentMovementToCustomer(Customer customer, PaymentMovement paymentMovement) {
        if (customer.getPaymentMovementList() != null) {
            customer.getPaymentMovementList().add(paymentMovement);
        } else {
            ArrayList<PaymentMovement> paymentMovementList = new ArrayList<>();
            paymentMovementList.add(paymentMovement);
            customer.setPaymentMovementList(paymentMovementList);
        }
    }

    public void addVehicleToCustomer(Customer customer, Vehicle vehicle) {
        if (customer.getVehicleList() != null) {
            customer.getVehicleList().add(vehicle);
        } else {
            ArrayList<Vehicle> vehicleList = new ArrayList<>();
            vehicleList.add(vehicle);
            customer.setVehicleList(vehicleList);
        }



    }
    public void acceptProposal(Customer customer, Proposal proposal, InsuranceRequest insuranceRequest) {
        //customer nesnesinden insuranceRequestList adlı bir liste elde ettik. Bu liste müşterinin sigorta taleplerini içerir
        List<InsuranceRequest> insuranceRequestList = customer.getInsuranceRequestList();
        for(InsuranceRequest request: insuranceRequestList) { // insuranceRequest nesnesinin proposalList listesindeki her bir
                                                            // proposal nesnesi için kontrol yapılır. Her bir Proposal nesnesi  proposal1 olarak adlandırılır.
            if (request.equals(insuranceRequest)) {
                for (Proposal proposal1 : insuranceRequest.getProposalList()) {//Eğer proposal1 proposal a eşitse proposalService tarafından indirimli fiyat hesaplanır.
                    if (proposal1.equals(proposal))
                    {
                        BigDecimal discountedPrice = proposalService.calculateDiscountedPrice(proposal);
                        BankAccount customerBankAccount = checkCustomerBankAccount(customer,discountedPrice); // checkCustomerBankAccount metoduna çağrı yapılır ve müşterinin banka hesabını dönüyoruz.
                        if (customerBankAccount != null) {
                            customerBankAccount.setAmount(customerBankAccount.getAmount()//Burada müşterinin banka hesabındaki miktar indirimli fiyat kadar düşer
                                    .subtract(discountedPrice));
                            PaymentMovement customerPaymentMovement = paymentMovementService //Müşteri ödeme hareketi oluşturulur.
                                    .createPaymentMovement(customerBankAccount,
                                            "Insurance Payment", MovementTypeEnum.OUTCOME, discountedPrice);
                            addPaymentMovementToCustomer(customer, customerPaymentMovement);// Müşteriye ödeme hareketi eklenir.
                        }
                        proposal1.setApproved(true); //Öneri onaylanır
                    }
                }//Bu kod parçacığı, müşterinin sigorta taleplerini ve önerilerini kontrol eder.
                // Eğer verilen bir sigorta talebi ve öneri mevcutsa, indirimli fiyat hesaplanır ve müşterinin banka hesabından düşülür.
                // Ayrıca, öneri onaylanır.
            }
        }
    }

    public BankAccount checkCustomerBankAccount(Customer customer, BigDecimal amount) {
        List<BankAccount> bankAccountList = customer.getBankAccountList(); //Müşterinin hesap listesini alırız
        for (BankAccount account : bankAccountList) {
            if (account.getAmount().compareTo(amount) >= 0) { //Eğer hesaptaki miktar istenen miktarla eşit ya da büyükse hesabı döndürürüz
                return account;
            }
        }
        return null;
    } //Bu kod parçacığı, müşterinin banka hesaplarını kontrol ederek, belirli bir miktarı karşılayacak bir hesap bulmayı sağlar.
      // Eğer böyle bir hesap bulunursa, hesabı döndürür. Bulunamazsa null değerini döndürür.
}
