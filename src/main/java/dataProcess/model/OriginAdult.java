package dataProcess.model;

public class OriginAdult {
    private Integer id;

    private Integer age;

    private String sex;

    private String nativeCountry;

    private String occupation;

    private String education;

    private String maritalStatus;

    private String workclass;

    private String race;

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

    public OriginAdult() {}

    private OriginAdult(Builder b) {
        this.age = b.age;
        this.sex = b.sex;
        this.nativeCountry = b.nativeCountry;
        this.occupation = b.occupation;
        this.education = b.education;
        this.maritalStatus = b.maritalStatus;
        this.workclass = b.workclass;
        this.race = b.race;
    }

    public static class Builder {
        private OriginAdult originAdult = null;

        private Integer id;

        private Integer age;

        private String sex;

        private String nativeCountry;

        private String occupation;

        private String education;

        private String maritalStatus;

        private String workclass;

        private String race;

        public Builder(){}

        public Builder(OriginAdult originAdult) {
            this.originAdult = originAdult;
        }

        public Builder age(int age) {
            if(this.originAdult != null) {
                originAdult.setAge(age);
            } else {
                this.age = age;
            }
            return this;
        }

        public Builder sex(String sex) {
            if(this.originAdult != null) {
                originAdult.setSex(sex);
            } else {
                this.sex = sex;
            }
            return this;
        }

        public Builder nativeCountry(String nativeCountry) {
            if(this.originAdult != null) {
                originAdult.setNativeCountry(nativeCountry);
            } else {
                this.nativeCountry = nativeCountry;
            }
            return this;
        }

        public Builder occupation(String occupation) {
            if(this.originAdult != null) {
                originAdult.setOccupation(occupation);
            } else {
                this.occupation = occupation;
            }
            return this;
        }

        public Builder education(String education) {
            if(this.originAdult != null) {
                originAdult.setEducation(education);
            } else {
                this.education = education;
            }
            return this;
        }

        public Builder maritalStatus(String maritalStatus) {
            if(this.originAdult != null) {
                originAdult.setMaritalStatus(maritalStatus);
            } else {
                this.maritalStatus = maritalStatus;
            }
            return this;
        }

        public Builder workclass(String workclass) {
            if(this.originAdult != null) {
                originAdult.setWorkclass(workclass);
            } else {
                this.workclass = workclass;
            }
            return this;
        }

        public Builder race(String race) {
            if(this.originAdult != null) {
                originAdult.setRace(race);
            } else {
                this.race = race;
            }
            return this;
        }

        public OriginAdult build() {
            if(this.originAdult != null) {
                return this.originAdult;
            } else {
                return new OriginAdult(this);
            }
        }
    }

    public static void main(String[] args) {
        OriginAdult originAdult = new OriginAdult();
        OriginAdult originAdult1 = new OriginAdult.Builder(originAdult).age(29).education("jj").build();
        OriginAdult originAdult2 = new Builder(originAdult).age(30).build();
        System.out.println(originAdult2 == originAdult1);
        System.out.println(originAdult.getAge());

    }
}