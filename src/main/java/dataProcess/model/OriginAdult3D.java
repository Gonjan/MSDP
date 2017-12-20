package dataProcess.model;

import com.sun.tools.corba.se.idl.constExpr.Or;

import java.util.ArrayList;
import java.util.List;

public class OriginAdult3D {
    private Integer id;

    private Integer age;

    private String sex;

    private String nativeCountry;

    private String occupation;

    private String education;

    private String maritalStatus;

    public List<String> getSensitiveAttrs() {
        List<String> sas = new ArrayList<String>();
        sas.add(occupation);
        sas.add(education);
        sas.add(maritalStatus);
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

    @Override
    public String toString() {
        return id + "," + age + "," + sex + "," + nativeCountry + "," + occupation + "," + education + "," + maritalStatus;
    }

    public String toStringWithoutId() {
        return age + "," + sex + "," + nativeCountry + "," + occupation + "," + education + "," + maritalStatus;
    }

    public OriginAdult3D(){}

    private OriginAdult3D(Builder b) {
        this.id = b.id;
        this.age = b.age;
        this.sex = b.sex;
        this.nativeCountry = b.nativeCountry;
        this.occupation = b.occupation;
        this.education = b.education;
        this.maritalStatus = b.maritalStatus;
    }

    public static class Builder {
        private Integer id;

        private Integer age;

        private String sex;

        private String nativeCountry;

        private String occupation;

        private String education;

        private String maritalStatus;

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

        public Builder occupation(String occupation) {
            this.occupation = occupation;
            return this;
        }

        public Builder education(String education) {
            this.education = education;
            return this;
        }

        public Builder maritalStatus(String maritalStatus){
            this.maritalStatus = maritalStatus;
            return this;
        }

        public OriginAdult3D build() {
            return new OriginAdult3D(this);
        }
    }
}