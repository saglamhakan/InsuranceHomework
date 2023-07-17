package model;

import java.math.BigDecimal;
import java.util.Date;

public class Proposal {

    private InsuranceCompany company;

    private Vehicle vehicle;

    private BigDecimal offerPrice;

    private Date starDate;
    private Date endDate;

    private Date expireDate;

    private boolean isApproved;

    private BigDecimal discountPrice;

    public Proposal(InsuranceCompany company, Vehicle vehicle, BigDecimal offerPrice, Date starDate, Date endDate, Date expireDate, boolean isApproved, BigDecimal discountPrice) {
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

    public Date getStarDate() {
        return starDate;
    }

    public void setStarDate(Date starDate) {
        this.starDate = starDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
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
}
