public class student {
    public String name;
    public String id;
    public String stuClassNo;

    public student(String name, String id, String stuClassNo) {
        this.name = name;
        this.id = id;
        this.stuClassNo = stuClassNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStuClassNo() {
        return stuClassNo;
    }

    public void setStuClassNo(String stuClassNo) {
        this.stuClassNo = stuClassNo;
    }
}
