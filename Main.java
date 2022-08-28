import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static void  main(String[] args) {
        Surgeon[] surgeons = new Surgeon[3];
        boolean finished = false;
        int registeredSurgeons = 0;

        while (!finished) {
            int action;
            System.out.println("\nCirujanos registrados: " + registeredSurgeons);
            if(registeredSurgeons < surgeons.length) {
                System.out.println("1: Registrar");
            }
            System.out.println("2: Buscar");
            System.out.println("3: Consultar");
            System.out.println("4: Eliminar");
            System.out.println("0: Terminar");
            action = input.nextInt();
            input.nextLine();

            switch (action) {
                case 1:
                    if(registeredSurgeons < surgeons.length) {
                        surgeons[registeredSurgeons] = register();
                        registeredSurgeons++;
                        System.out.println("Cirujano registrado correctamente");
                    }
                    else {
                        System.out.println("Limite de registros alcanzado");
                    }
                    break;
                case 2:
                    edit(surgeons, lookFor(surgeons, registeredSurgeons));
                    break;
                case 3:
                    consult(surgeons, registeredSurgeons);
                    break;
                case 4:
                    if(registeredSurgeons > 0) {
                        delete(surgeons, registeredSurgeons, lookFor(surgeons, registeredSurgeons));
                        registeredSurgeons--;
                    }
                    break;
                case 0:
                    finished = true;
                    System.out.println("Terminado");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }
    }

    public static Surgeon register() {
        String name, speciality;
        int yearsOfExperience, level, kills, livesSaved;
        System.out.println("Nombre: ");
        name = input.nextLine();
        System.out.println("Años de experiencia: ");
        yearsOfExperience = Integer.parseInt(input.nextLine());
        System.out.println("Nivel: ");
        level = Integer.parseInt(input.nextLine());
        System.out.println("Especialidad: ");
        speciality = input.nextLine();
        System.out.println("Muertos: ");
        kills = Integer.parseInt(input.nextLine());
        System.out.println("Vidas salvadas: ");
        livesSaved = Integer.parseInt(input.nextLine());

        return new Surgeon(name, yearsOfExperience, level, speciality, kills, livesSaved);
    }

    public static void edit(Surgeon[] surgeons, int index) {
        boolean finished = false;
        while(!finished) {
            int action;
            surgeons[index].showInfo();
            System.out.println("\n1: Editar");
            System.out.println("0: Regresar");
            action = input.nextInt();
            input.nextLine();
            switch (action) {
                case 1 -> {
                    System.out.println("Años de experiencia: ");
                    surgeons[index].setYearsOfExperience(Integer.parseInt(input.nextLine()));
                    System.out.println("Nivel: ");
                    surgeons[index].setLevel(Integer.parseInt(input.nextLine()));
                    System.out.println("Especialidad: ");
                    surgeons[index].setSpeciality(input.nextLine());
                    System.out.println("Muertos: ");
                    surgeons[index].setKills(Integer.parseInt(input.nextLine()));
                    System.out.println("Vidas salvadas: ");
                    surgeons[index].setLivesSaved(Integer.parseInt(input.nextLine()));

                    System.out.println("Datos modificados correctamente");
                }
                case 0 -> finished = true;
                default -> System.out.println("Opcion invalida");
            }
        }
    }

    public static int lookFor(Surgeon[] surgeons, int registeredSurgeons) {
        String surgeon;
        System.out.println("Cirujano: ");
        surgeon = input.nextLine();
        boolean foundTarget = false;
        for(int i = 0; i < registeredSurgeons; i++) {
            if(surgeons[i].getName().equals(surgeon)) {
                return i;
            }
        }
        return -1;
    }

    public static void consult(Surgeon[] surgeons, int registeredSurgeons){
        for (int i = 1; i <= registeredSurgeons; i++) {
            System.out.println("\n----------Cirujano " + i + "----------");
            surgeons[i - 1].showInfo();
        }
    }

    public static void delete(Surgeon[] surgeons, int registeredSurgeons , int index) {
       for(int i = 0; i < registeredSurgeons; i++) {
           surgeons[i] = surgeons[i + 1];
       }
       System.gc();
    }
}
