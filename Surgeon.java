public class Surgeon extends Doctor{
    private String speciality;
    private int kills;
    private int livesSaved;

    public Surgeon(String name, int yearsOfExperience, int level, String speciality, int kills, int livesSaved) {
        super(name, yearsOfExperience, level);
        this.speciality = speciality;
        this.kills = kills;
        this.livesSaved = livesSaved;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public void setLivesSaved(int livesSaved) {
        this.livesSaved = livesSaved;
    }

    public String getSpeciality() {
        return speciality;
    }

    public int getKills() {
        return kills;
    }

    public int getLivesSaved() {
        return livesSaved;
    }

    public void showInfo() {
        System.out.println("Nombre: " + name);
        System.out.println("Años de experiencia: " + yearsOfExperience);
        System.out.println("Nivel: " + level);
        System.out.println("Especialidad: " + speciality);
        System.out.println("Muertos: " + kills);
        System.out.println("Vidas salvadas: " + livesSaved);
    }
}
