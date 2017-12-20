package dataProcess.model;

import java.util.ArrayList;
import java.util.List;

public class OriginAdult2D implements Cloneable {
    private Integer id;

    private Integer age;

    private String sex;

    private String nativeCountry;

    private String occupation;

    private String education;

    public List<String> getSensitiveAttrs() {
        List<String> sas = new ArrayList<String>();
        sas.add(occupation);
        sas.add(education);
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

    @Override
    public String toString() {
        return id + "," + age + "," + sex + "," + nativeCountry + "," + occupation + "," + education;
    }

    public String toStringWithoutId() {
        return age + "," + sex + "," + nativeCountry + "," + occupation + "," + education;
    }

    public OriginAdult2D() {}

    private OriginAdult2D(Builder b) {
        this.age = b.age;
        this.sex = b.sex;
        this.nativeCountry = b.nativeCountry;
        this.occupation = b.occupation;
        this.education = b.education;
    }

    @Override
    public OriginAdult2D clone() {
        OriginAdult2D cloneObject = null;
        try {
            cloneObject = (OriginAdult2D)super.clone();
        } catch (CloneNotSupportedException e) {
            System.err.println("对象克隆失败！！");
            throw new RuntimeException();
        }
        return cloneObject;
    }

    public static class Builder {

        private Integer id;
        private Integer age;
        private String  sex;
        private String  nativeCountry;
        private String  occupation;
        private String  education;

        public Builder() {
        }

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

        public OriginAdult2D build() {

            return new OriginAdult2D(this);
        }
    }
}


