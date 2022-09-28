import java.util.ArrayList;
import java.util.List;

class Squad {
    private final List<Soldier> soldiers;

    public Squad() {
        this.soldiers = new ArrayList<>();
    }

    public void train(String specialty, String name) {
        Specialty spc = SpecialtyFactory.getSpecialty(specialty);
        soldiers.add(new Soldier(
                name,
                spc
        ));
    }

    public void doAction() {
        soldiers.forEach(soldier -> System.out.println(soldier.doAction()));
    }
}

class Soldier {
    private final String name;
    private final Specialty specialty;

    public Soldier(String name, Specialty specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    public String getName() {
        return name;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public String doAction() {
        return "Solder(" + name + ") " + specialty.doAction();
    }
}