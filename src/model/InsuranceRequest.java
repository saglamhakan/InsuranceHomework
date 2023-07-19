package model;

import java.util.ArrayList;

public class InsuranceRequest {
    private ArrayList<Proposal> proposalList;

    private Policy policy;

    private Vehicle vehicle;

    public InsuranceRequest() {
    }

    public ArrayList<Proposal> getProposalList() {
        return proposalList;
    }

    public void setProposalList(ArrayList<Proposal> proposalList) {
        this.proposalList = proposalList;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "InsuranceRequest{" +
                "proposalList=" + proposalList +
                ", policy=" + policy +
                ", vehicle=" + vehicle +
                '}';
    }
}
