package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class Proposal {

    private InsuranceCompany company;

    private Vehicle vehicle;

    private BigDecimal offerPrice;

    private LocalDate starDate;
    private LocalDate endDate;

    private LocalDate expireDate;

    private boolean isApproved = false;

    private BigDecimal discountPrice;

    public Proposal(InsuranceCompany company, Vehicle vehicle, BigDecimal offerPrice, LocalDate starDate, LocalDate endDate, LocalDate expireDate, boolean isApproved, BigDecimal discountPrice) {
        this.company = company;
        this.vehicle = vehicle;
        this.offerPrice = offerPrice;
        this.starDate = starDate;
        this.endDate = endDate;
        this.expireDate = expireDate;
        this.isApproved = isApproved;
        this.discountPrice = discountPrice;
    }

    public Proposal() {
    }

    public InsuranceCompany getCompany() {
        return company;
    }

    public void setCompany(InsuranceCompany company) {
        this.company = company;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public BigDecimal getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(BigDecimal offerPrice) {
        this.offerPrice = offerPrice;
    }

    public LocalDate getStarDate() {
        return starDate;
    }

    public void setStarDate(LocalDate starDate) {
        this.starDate = starDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public String toString() {
        return "Proposal{" +
                "company=" + company +
                ", vehicle=" + vehicle +
                ", offerPrice=" + offerPrice +
                ", starDate=" + starDate +
                ", endDate=" + endDate +
                ", expireDate=" + expireDate +
                ", isApproved=" + isApproved +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
