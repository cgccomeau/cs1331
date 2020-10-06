/**
 * A testing class for DoctorCS.java and RogueAI.java.
 *
 * @author 1331TAs
 * @version 1.0
 */
public class CrimeSimulator {
    public static void main(String[] args) {
        Coordinates coords = new Coordinates(13.31, 23.16);
        DoctorCS cs = new DoctorCS(new RogueAI(10, 0, 15, coords,
            new Coordinates(50.0, 25.5)), "Robert Paulson", 13310001);
        RogueAI ai = (RogueAI) cs.getAI();
        System.out.println(cs.toString());
        System.out.println(ai.toString());

        cs.saveTheDay();
        System.out.println(ai.toString());

        System.out.println(cs.getStatus());
        System.out.println(ai.getDestructed());
        //Coordinates coords = new Coordinates(13.31, 13.31);
        //Coordinates coords1 = new Coordinates(2.01, 9.26);
        //Coordinates coords2 = coords;
        //DoctorCS cs = new DoctorCS(new RogueAI(10, 0, 15, coords,
        //    coords2), "Robert Paulson", 13310001);
        //RogueAI ai = (RogueAI) cs.getAI();
        //RandomAI random = new RandomAI(coords1, coords2);
        //DoctorCS simpkins = new DoctorCS(random, "Chris Simpkins", 123456789);
        //System.out.println(cs);
        //System.out.println(ai);
        //for (int i = 0; i < 9; i++) {
        //    cs.saveTheDay();
        //    System.out.println(cs.getStatus());
        //}
        //System.out.println();
        //System.out.println(simpkins);
        //System.out.println(random);
        //System.out.println();
        //for (int i = 0; i < 9; i++) {
        //    simpkins.saveTheDay();
        //    System.out.println(simpkins.getStatus());
        //    random = new RandomAI(coords1, coords2);
        //    simpkins = new DoctorCS(random, "Chris Simpkins", 123456789);
//
        //}
        //System.out.println(random.getDestructed());
    }
}