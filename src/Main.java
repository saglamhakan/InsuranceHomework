import model.*;
import service.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        AccidentService accidentService = new AccidentService();
        AgencyService agencyService = new AgencyService();
        BankAccountService bankAccountService = new BankAccountService();
        InsuranceCompanyService insuranceCompanyService = new InsuranceCompanyService();
        CustomerService customerService = new CustomerService();
        InsuranceService insuranceService = new InsuranceService();
        InsuranceRequestService insuranceRequestService = new InsuranceRequestService();
        PaymentMovementService paymentMovementService = new PaymentMovementService();
        PolicyService policyService = new PolicyService();
        ProposalService proposalService = new ProposalService();
        VehicleService vehicleService = new VehicleService();

        Agency agency = agencyService.createAgency("Man");

        BankAccount bankAccount = bankAccountService.createBankAccount("Ziraat",
                "TR093043040", new BigDecimal(100000));

        agencyService.addBankAccountToAgency(agency, bankAccount);

        InsuranceCompany insuranceCompany = insuranceCompanyService.createInsuranceCompany("Allianz",
                "Adana/Çukurova", "655566", "Adana", new BigDecimal(8));

        Insurance insurance = insuranceService.createInsurance(InsuranceTypeEnum.COMPULSORY_TRAFFIC_INSURANCE,
                "Compulsory traffic insurance");
        insuranceCompanyService.addInsuranceToInsuranceCompany(insuranceCompany, insurance);
        BankAccount allianzBankAccount = bankAccountService.createBankAccount("Yapı kredi", "TR0989089340",
                new BigDecimal(10000000));

        insuranceCompanyService.addBankAccountToInsuranceCompany(insuranceCompany, allianzBankAccount);
        agencyService.addInsuranceCompanyToAgency(agency, insuranceCompany);


        Customer customer = customerService.createCustomer("Hakan", CustomerTypeEnum.INDIVIDUAL);
        BankAccount customerBankAccount = bankAccountService.createBankAccount("Akbank", "TR0467676789",
                new BigDecimal(5000));
        customerService.addBankAccountToCustomer(customer, customerBankAccount);
        agencyService.addCustomerToAgency(agency, customer);


        Vehicle vehicle = vehicleService.createVehicle("Volkswagen", "Golf", "01 HKN 01",
                "655656757", 2010, ColorTypeEnum.BLACK);
        customerService.addVehicleToCustomer(customer, vehicle);

        LocalDate accidentDate = LocalDate.now();
        Accident accident = accidentService.createAccident(accidentDate,"Trafik kazası gerçekleşti",
                new BigDecimal(5000), 6);

        vehicleService.addAccidentToVehicle(vehicle, accident);
        System.out.println(accident.toString());




        InsuranceRequest insuranceRequest = insuranceRequestService.createInsuranceRequest(vehicle);
        customerService.addInsuranceRequestToCustomer(customer, insuranceRequest);


        Proposal proposal = proposalService.createProposal(insuranceCompany, vehicle, new BigDecimal(2000),
                LocalDate.of(2010, 5, 21), LocalDate.of(2024, 7, 18),
                LocalDate.of(2011, 5, 21), false, new BigDecimal(100));
        insuranceRequestService.addProposalToInsuranceRequest(insuranceRequest, proposal);

        BigDecimal discountedPrice = proposalService.calculateDiscountedPrice(proposal);


        customerService.acceptProposal(customer, proposal, insuranceRequest);

        if (proposal.isApproved()){
            PaymentMovement customerPaymentToAgency = paymentMovementService.createPaymentMovement(customerBankAccount,
                    "InsurancePayment", MovementTypeEnum.OUTCOME, discountedPrice);
            bankAccount.setAmount(bankAccount.getAmount().add(discountedPrice));
            agencyService.addPaymentMovementToAgency(agency, customerPaymentToAgency);
        }

        PaymentMovement agencyPaymentToAgency = paymentMovementService.createPaymentMovement(bankAccount,
                "InsurancePayment", MovementTypeEnum.INCOME, discountedPrice);
        agencyService.addPaymentMovementToAgency(agency,agencyPaymentToAgency);


        PaymentMovement agencyPaymentToCompanyMovement = paymentMovementService.createPaymentMovement(
                bankAccount, "Insurance Payment Transfer", MovementTypeEnum.OUTCOME, discountedPrice);
        agencyService.addPaymentMovementToAgency(agency, agencyPaymentToCompanyMovement);



        PaymentMovement insurancePaymentToCompany = paymentMovementService.createPaymentMovement(allianzBankAccount,
                "InsurancePayment", MovementTypeEnum.INCOME, discountedPrice);
        allianzBankAccount.setAmount(allianzBankAccount.getAmount().add(discountedPrice));
        bankAccount.setAmount(bankAccount.getAmount().subtract(discountedPrice));
        insuranceCompanyService.addPaymentMovementToInsuranceCompany(insuranceCompany,insurancePaymentToCompany);


        BigDecimal commissionAmount = discountedPrice.multiply(proposal.getCompany().getCommission().divide(new BigDecimal(100)));
        allianzBankAccount.setAmount(allianzBankAccount.getAmount().subtract(commissionAmount));
        bankAccount.setAmount(bankAccount.getAmount().add(commissionAmount));

        PaymentMovement commissionTransferFromCompanyToAgency = paymentMovementService.createPaymentMovement(
                allianzBankAccount, "commission transfer",MovementTypeEnum.OUTCOME, commissionAmount );
        insuranceCompanyService.addPaymentMovementToInsuranceCompany(insuranceCompany, commissionTransferFromCompanyToAgency);

        PaymentMovement commissionIncomeToAgency = paymentMovementService.createPaymentMovement(bankAccount,
                "CommissionIncome", MovementTypeEnum.INCOME, commissionAmount);
        agencyService.addPaymentMovementToAgency(agency,commissionIncomeToAgency);

        System.out.println(customer);
        System.out.println(agency);
        System.out.println(insuranceCompany);
    }




}