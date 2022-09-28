class SpecialtyFactory {
    private static final Specialty[] cache;
    private static int offset = 0;

    static {
        cache = new Specialty[10];
    }

    public static Specialty getSpecialty(String specialty) {
        int loc = find(specialty);
        if (loc == -1) {
            cache[offset] = new Specialty(specialty);
            return cache[offset++];
        } else return cache[loc];
    }

    private static int find(String specialty) {
        int loc = -1;
        for (int i = 0; i < offset; i++) {
            if (specialty.equals(cache[i].getSpecialty())) {
                loc = i;
                break;
            }
        }
        return loc;
    }
}

class Specialty {
    private final String specialty;
    //  and so on...

    public Specialty(String specialty) {
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String doAction() {
        return "[MOS: " + specialty + "]";
    }
}