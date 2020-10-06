public class GeorgiaTechCollege {

    public int numStudents;
    public static int currentYear;
    public String name;

    public GeorgiaTechCollege(int numStudents, int currentYear, String name) {
        this.numStudents = numStudents;
        this.currentYear = currentYear;
        this.name = name;
    }

    public GeorgiaTechCollege (int numStudents, String name) {
        this(numStudents, 2018, name); // delegation is new way of filing constructor data
    }

    public GeorgiaTechCollege() {
        numStudents = 500;
        currentYear = 2018;
        name = "College of Engineering";
    }


    public static void main (String[] args) {
        GeorgiaTechCollege collOfComputing = new GeorgiaTechCollege(2000, "College of Computing");
        GeorgiaTechCollege coll0fEngineering = new GeorgiaTechCollege(3000, "College of Engineering");
        //coll0fComputing.currentYear = 2018;
        System.out.println(collOfComputing.name);
        System.out.println(collOfComputing.numStudents);
        System.out.println(collOfComputing.currentYear);
    }
}