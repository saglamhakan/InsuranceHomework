package model;

import java.util.ArrayList;
import java.util.List;


public class Customer {

    private String name;

    private ArrayList<BankAccount> bankAccountList;

    private ArrayList<InsuranceRequest> insuranceRequestList;
    private CustomerTypeEnum customerTypeEnum;

    private ArrayList<Policy> policyList;

    private List<PaymentMovement> paymentMovementList;
    private ArrayList<Vehicle> vehicleList;

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<BankAccount> getBankAccountList() {
        return bankAccountList;
    }

    public void setBankAccountList(ArrayList<BankAccount> bankAccountList) {
        this.bankAccountList = bankAccountList;
    }

    public ArrayList<InsuranceRequest> getInsuranceRequestList() {
        return insuranceRequestList;
    }

    public void setInsuranceRequestList(ArrayList<InsuranceRequest> insuranceRequestList) {
        this.insuranceRequestList = insuranceRequestList;
    }

    public CustomerTypeEnum getCustomerTypeEnum() {
        return customerTypeEnum;
    }

    public void setCustomerTypeEnum(CustomerTypeEnum customerTypeEnum) {
        this.customerTypeEnum = customerTypeEnum;
    }

    public ArrayList<Policy> getPolicyList() {
        return policyList;
    }

    public void setPolicyList(ArrayList<Policy> policyList) {
        this.policyList = policyList;
    }

    public List<PaymentMovement> getPaymentMovementList() {
        return paymentMovementList;
    }

    public void setPaymentMovementList(List<PaymentMovement> paymentMovementList) {
        this.paymentMovementList = paymentMovementList;
    }

    public ArrayList<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(ArrayList<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", bankAccountList=" + bankAccountList +
                ", insuranceRequestList=" + insuranceRequestList +
                ", customerTypeEnum=" + customerTypeEnum +
                ", policyList=" + policyList +
                ", paymentMovementList=" + paymentMovementList +
                ", vehicleList=" + vehicleList +
                '}';
    }
}
