package model;

public class Insurance {

    private String name;

    private InsuranceTypeEnum insuranceTypeEnum;

    public Insurance() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InsuranceTypeEnum getInsuranceTypeEnum() {
        return insuranceTypeEnum;
    }

    public void setInsuranceTypeEnum(InsuranceTypeEnum insuranceTypeEnum) {
        this.insuranceTypeEnum = insuranceTypeEnum;
    }

    @Override
    public String toString() {
        return "Insurance{" +
                "name='" + name + '\'' +
                ", insuranceTypeEnum=" + insuranceTypeEnum +
                '}';
    }
}
