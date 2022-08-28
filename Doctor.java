public class Doctor {
    protected String name;
    protected int yearsOfExperience;
    protected int level;

    public Doctor(String name, int yearsOfExperience, int level) {
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.level = level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public int getLevel() {
        return level;
    }
}
