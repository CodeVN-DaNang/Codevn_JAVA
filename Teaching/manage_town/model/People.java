package manage_town.model;

public class People {
    //Họ tên, Tuổi, Nghề nghiệp, số chứng minh nhân dân
    private String peopleId;
    private String namePeople;
    private String agePeople;
    private String major;

    public People(String peopleId, String namePeople, String agePeople, String major) {
        this.peopleId = peopleId;
        this.namePeople = namePeople;
        this.agePeople = agePeople;
        this.major = major;
    }
    
    public String getPeopleId() {
        return peopleId;
    }
    public void setPeopleId(String peopleId) {
        this.peopleId = peopleId;
    }
    public String getNamePeople() {
        return namePeople;
    }
    public void setNamePeople(String namePeople) {
        this.namePeople = namePeople;
    }
    public String getAgePeople() {
        return agePeople;
    }
    public void setAgePeople(String agePeople) {
        this.agePeople = agePeople;
    }
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "People [peopleId=" + peopleId + ", namePeople=" + namePeople + ", agePeople=" + agePeople + ", major="
                + major + "]";
    }
}
