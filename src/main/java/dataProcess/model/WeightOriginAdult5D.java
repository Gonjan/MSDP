package dataProcess.model;

import java.util.ArrayList;
import java.util.List;

public class WeightOriginAdult5D {
    private Integer id;

    private Integer age;

    private String sex;

    private String nativeCountry;

    private String occupation;

    private String education;

    private String maritalStatus;

    private String workclass;

    private String race;

    private Double weight;

    public List<String> getSensitiveAttrs() {
        List<String> sas = new ArrayList<String>();
        sas.add(occupation);
        sas.add(education);
        sas.add(maritalStatus);
        sas.add(workclass);
        sas.add(race);
        return sas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getNativeCountry() {
        return nativeCountry;
    }

    public void setNativeCountry(String nativeCountry) {
        this.nativeCountry = nativeCountry == null ? null : nativeCountry.trim();
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation == null ? null : occupation.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus == null ? null : maritalStatus.trim();
    }

    public String getWorkclass() {
        return workclass;
    }

    public void setWorkclass(String workclass) {
        this.workclass = workclass == null ? null : workclass.trim();
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race == null ? null : race.trim();
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return id + "," + age + "," + sex + "," + nativeCountry + "," + occupation + "," + education + "," + maritalStatus
                + "," + workclass + "," + race + "," + weight;
    }

    public String toStringWithoutId() {
        return age + "," + sex + "," + nativeCountry + "," + occupation + "," + education + "," + maritalStatus
                + "," + workclass + "," + race + "," + weight;
    }

    public WeightOriginAdult5D() {}

    public WeightOriginAdult5D(Builder b) {
        age = b.age;
        sex = b.sex;
        nativeCountry = b.nativeCountry;
        occupation = b.occupation;
        education = b.education;
        maritalStatus = b.maritalStatus;
        workclass = b.workclass;
        race = b.race;
        weight = b.weight;
    }

    public static class Builder {
        private Integer id;

        private Integer age;

        private String sex;

        private String nativeCountry;

        private String occupation;

        private String education;

        private String maritalStatus;

        private String workclass;

        private String race;

        private Double weight;

        public Builder() {}

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder sex(String sex) {
            this.sex = sex;
            return this;
        }

        public Builder nativeCountry(String nativeCountry) {
            this.nativeCountry = nativeCountry;
            return this;
        }

        public Builder education(String education) {
            this.education = education;
            return this;
        }
        public Builder occupation(String occupation) {
            this.occupation = occupation;
            return this;
        }

        public Builder maritalStatus(String maritalStatus) {
            this.maritalStatus = maritalStatus;
            return this;
        }

        public Builder workclass(String workclass) {
            this.workclass = workclass;
            return this;
        }

        public Builder race(String race) {
            this.race = race;
            return this;
        }

        public Builder weight(Double weight) {
            this.weight = weight;
            return this;
        }

        public WeightOriginAdult5D build() {
            return new WeightOriginAdult5D(this);
        }
    }
}