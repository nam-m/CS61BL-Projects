package enigma;

import java.nio.CharBuffer;

import static enigma.EnigmaException.*;

/** Class that represents a rotating rotor in the enigma machine.
 *  @author Nam Anh Mai
 */
public class MovingRotor extends Rotor {

    /** A rotor named NAME whose permutation in its default setting is
     *  PERM, and whose notches are at the positions indicated in NOTCHES.
     *  The Rotor is initially in its 0 setting (first character of its
     *  alphabet).
     */
    public MovingRotor(String name, Permutation perm, String notches) {
        super(name, perm);
        // FIXME - Assign any additional instance variables.
        _notches = notches;
        _permutation = perm;
    }

    // FIXME - This class inherits all of the information present in the
    //			Rotor class, meaning that any method which exists in
    //			Rotor can be used from MovingRotor. This will make more sense
    //			later in the course, but for now, you should think about
    //			how a MovingRotor's behavior is different from a FixedRotor.
    //			Does a MovingRotor's behavior differ from the default Rotor
    //			behavior? Some methods that differ appear below. Do we need
    //			to update any other methods in this class in order for it to
    //			behave as a moving Rotor? Check out Rotor and FixedRotor to
    //			see what methods might be different between these two classes.

    @Override // Use this special tag when updating the behavior of a method this class inherits from Rotor
    public boolean rotates() {
        // FIXME - How do we know whether this Rotor should rotate?
        return true;
    }

    @Override // Use this special tag when updating the behavior of a method this class inherits from Rotor
    public boolean atNotch() {
        // FIXME - How do we know whether this Rotor is at a notch?
        // Since there can be more than 1 notch per rotor, i.e. notches can be "A"; "DG"; "WRS"
        String[] notchArray = _notches.split("");
        for (String s : notchArray) {
            Character currentPos =  super.alphabet().toChar(setting());
            if (s.equals(String.valueOf(currentPos))) {
                return true;
            }
        }
        return false;
    }

    @Override // Use this special tag when updating the behavior of a method this class inherits from Rotor
    public void advance() {
        // FIXME - What methods can we use to advance this Rotor by one position?
        super.set(_permutation.wrap(super.setting() + 1));
    }

    // FIXME - How do we keep track of my notches?
    public String getNotch() {
        return _notches;
    }

    // FIXME: ADDITIONAL FIELDS HERE, AS NEEDED
    private String _notches;
    private Permutation _permutation;
    // To run this through command line, from the proj0 directory, run the following:
    // javac enigma/Rotor.java enigma/MovingRotor.java enigma/Permutation.java enigma/Alphabet.java enigma/CharacterRange.java enigma/EnigmaException.java
    // java enigma/MovingRotor
    public static void main(String[] args) {
        Permutation perm = new Permutation("(AB) (CDEFGHIJKLMNOPQRSTUVWXYZ)", new CharacterRange('A', 'Z'));
        MovingRotor rotor = new MovingRotor("forward one", perm, "B");

        System.out.println(rotor.name().equals("forward one"));
        System.out.println(rotor.alphabet() == perm.alphabet());
        System.out.println(rotor.permutation() == perm);
        System.out.println(rotor.rotates() == true);
        System.out.println(rotor.reflecting() == false);

        System.out.println(rotor.size() == 26);
        rotor.set(23);
        System.out.println(rotor.setting());
        System.out.println(rotor.atNotch());
        rotor.set('X');
        System.out.println(rotor.setting());
        System.out.println(rotor.atNotch());

        System.out.println(rotor.convertForward(0) == 1);
        System.out.println(rotor.convertBackward(1) == 0);

        rotor.set(0);
        System.out.print("Current setting: ");
        System.out.println(rotor.setting());
        rotor.advance();
        System.out.print("Setting after advance: ");
        System.out.println(rotor.setting());
        System.out.println(rotor.atNotch() == true);

        System.out.println(rotor.convertForward(0) == 25);
        System.out.println(rotor.convertBackward(25) == 0);
    }

}
