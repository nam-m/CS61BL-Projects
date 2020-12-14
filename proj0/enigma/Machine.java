package enigma;

import java.util.Arrays;

import static enigma.EnigmaException.*;

/** Class that represents a complete enigma machine.
 *  @author Nam Anh Mai
 */
public class Machine {

    /** A new Enigma machine with alphabet ALPHA, 1 < NUMROTORS rotor slots,
     *  and 0 <= PAWLS < NUMROTORS pawls. ALLROTORS contains all the
     *  available rotors. */
    public Machine(Alphabet alpha, int numRotors, int numPawls,
            Rotor[] allRotors) {
        _alphabet = alpha;
        // FIXME - Assign any additional instance variables.
        _numRotors = numRotors;
        _numPawls = numPawls;
        _allRotors = allRotors;
        _rotorSlots = new Rotor[numRotors];
    }

    /** Return the number of rotor slots I have. */
    public int numRotors() {
        // FIXME - How do we access the number of Rotor slots I have?
        return _numRotors;
    }

    /** Return the number pawls (and thus rotating rotors) I have. */
    public int numPawls() {
        // FIXME - How do we access the number of pawls I have?
        return _numPawls;
    }

    /** Set my rotor slots to the rotors named ROTORS from my set of
     *  available rotors (ROTORS[0] names the reflector).
     *  Initially, all rotors are set at their 0 setting. */
    public void insertRotors(String[] rotors) {
        // FIXME - How do we fill this Machine with Rotors, based on names of available Rotors?
        for (int i=0; i < rotors.length; i++) {
            for (Rotor allRotor : _allRotors) {
                // Upper case is needed to compare fixed rotor's name (e.g. Beta, Gamma) to "rotors" value
                if (allRotor.name().toUpperCase().equals(rotors[i]))
                    _rotorSlots[i] = allRotor;
            }
        }
    }

    /** Set my rotors according to SETTING, which must be a string of
     *  numRotors()-1 upper-case letters. The first letter refers to the
     *  leftmost rotor setting (not counting the reflector).  */
    public void setRotors(String setting) {
        // FIXME - How do we set the positions of each Rotor in this Machine?
        for (int i=0; i < setting.length(); i++) {
            _rotorSlots[i+1].set(setting.charAt(i));
        }
    }

    /** Set the plugboard to PLUGBOARD. */
    public void setPlugboard(Permutation plugboard) {
        // FIXME - How do we assign our plugboard, based on a given Permutation?
        _plugboard = plugboard;
    }

    /** Returns the result of converting the input character C (as an
     *  index in the range 0..alphabet size - 1), after first advancing
     *  the machine. */
    public int convert(int c) {
    	// HINT: This one is tough! Consider using a helper method which advances
    	//			the appropriate Rotors. Then, send the signal into the
    	//			Plugboard, through the Rotors, bouncing off the Reflector,
    	//			back through the Rotors, then out of the Plugboard again.
        // FIXME - How do we convert a single character index?
        advance();
        // Character after entering plugboard
        int intoPlugboard = _plugboard.permute(c);
        int RotorToReflector = intoPlugboard;
        for (int i=numRotors()-1; i >= 0; i--) {
            RotorToReflector = convertRotors(_rotorSlots[i], RotorToReflector);
            System.out.println(RotorToReflector);
        }
        System.out.println("Character after entering reflector: " + RotorToReflector);
        int ReflectorToRotor = RotorToReflector;
        // Character after bouncing off reflector (1)
        for (int i=1; i < numRotors(); i++) {
            ReflectorToRotor = invertRotors(_rotorSlots[i], ReflectorToRotor);
            System.out.println(ReflectorToRotor);
        }
        System.out.println("Character after exiting outermost rotor: " + ReflectorToRotor);
        int outOfPlugboard = _plugboard.permute(ReflectorToRotor);
        return outOfPlugboard;
    }

    /** Optional helper method for convert() which rotates the necessary Rotors. */
    private void advance() {
    	// FIXME - How do we make sure that only the correct Rotors are advanced?
        /* When pawl of rotor (i-1) slips into notched ring of rotor i
            both rotor (i-1) and rotor i move (except fixed rotor)
            Rotor right next to a fixed rotor only moves due to the rotor on its right*/
        for (int i=numRotors()-1; i > numRotors()-numPawls(); i--) {
            if (_rotorSlots[i].atNotch()) {
                _rotorSlots[i-1].advance();
                if (i != numRotors()-1)
                    _rotorSlots[i].advance();
            }
        }
        // Outermost rotor always moves when pawl moves
        _rotorSlots[numRotors()-1].advance();
    }

    private int convertRotors (Rotor rotor, int c) {
        return rotor.convertForward(c);
    }

    private int invertRotors (Rotor rotor, int c) {
        return rotor.convertBackward(c);
    }

    /** Returns the encoding/decoding of MSG, updating the state of
     *  the rotors accordingly. */
    public String convert(String msg) {
    	// HINT: Strings are basically just a series of characters
        return ""; // FIXME - How do we convert an entire String?
    }

    /** Common alphabet of my rotors. */
    private final Alphabet _alphabet;

    // FIXME - How do we keep track of my available Rotors/my Rotors/my pawls/my plugboard
    private int _numRotors;
    private int _numPawls;
    private Rotor[] _allRotors;
    private Rotor[] _rotorSlots;
    private Permutation _plugboard;

    // FIXME: ADDITIONAL FIELDS HERE, IF NEEDED.

    // To run this through command line, from the proj0 directory, run the following:
    // javac enigma/Machine.java enigma/Rotor.java enigma/FixedRotor.java enigma/Reflector.java enigma/MovingRotor.java enigma/Permutation.java enigma/Alphabet.java enigma/CharacterRange.java enigma/EnigmaException.java
    // java enigma/Machine
    public static void main(String[] args) {
        CharacterRange upper = new CharacterRange('A', 'Z');
        MovingRotor rotorI = new MovingRotor("I",
                new Permutation("(AELTPHQXRU) (BKNW) (CMOY) (DFG) (IV) (JZ) (S)", upper),
                "Q");
        MovingRotor rotorII = new MovingRotor("II",
                new Permutation("(FIXVYOMW) (CDKLHUP) (ESZ) (BJ) (GR) (NT) (A) (Q)", upper),
                "E");
        MovingRotor rotorIII = new MovingRotor("III",
                new Permutation("(ABDHPEJT) (CFLVMZOYQIRWUKXSG) (N)", upper),
                "V");
        MovingRotor rotorIV = new MovingRotor("IV",
                new Permutation("(AEPLIYWCOXMRFZBSTGJQNH) (DV) (KU)", upper),
                "J");
        MovingRotor rotorV = new MovingRotor("V",
                new Permutation("(AVOLDRWFIUQ)(BZKSMNHYC) (EGTJPX)", upper),
                "Z");
        FixedRotor rotorBeta = new FixedRotor("Beta",
                new Permutation("(ALBEVFCYODJWUGNMQTZSKPR) (HIX)", upper));
        FixedRotor rotorGamma = new FixedRotor("Gamma",
                new Permutation("(AFNIRLBSQWVXGUZDKMTPCOYJHE)", upper));
        Reflector rotorB = new Reflector("B",
                new Permutation("(AE) (BN) (CK) (DQ) (FU) (GY) (HW) (IJ) (LO) (MP) (RX) (SZ) (TV)", upper));
        Reflector rotorC = new Reflector("C",
                new Permutation("(AR) (BD) (CO) (EJ) (FN) (GT) (HK) (IV) (LM) (PW) (QZ) (SX) (UY)", upper));

        Rotor[] allRotors = new Rotor[9];
        allRotors[0] = rotorI;
        allRotors[1] = rotorII;
        allRotors[2] = rotorIII;
        allRotors[3] = rotorIV;
        allRotors[4] = rotorV;
        allRotors[5] = rotorBeta;
        allRotors[6] = rotorGamma;
        allRotors[7] = rotorB;
        allRotors[8] = rotorC;

        Machine machine = new Machine(upper, 5, 3, allRotors);
        machine.insertRotors(new String[]{"B", "BETA", "III", "IV", "I"});

//        System.out.println(machine.numRotors() == 5);
//        System.out.println(machine.numPawls() == 3);
        System.out.println("Rotor slots from inner to outer: " + Arrays.toString(machine._rotorSlots));
        machine.setRotors("AXLE");
        System.out.print("Rotor positions from inner to outer: ");
        for (Rotor r : machine._rotorSlots) {
            System.out.print(r.setting() + " ");
        }
        System.out.println();
        machine.setPlugboard(new Permutation("(HQ) (EX) (IP) (TR) (BY)", upper));
        System.out.println(machine.convert(5));
        System.out.print("Rotor positions from inner to outer: ");
        for (Rotor r : machine._rotorSlots) {
            System.out.print(r.setting() + " ");
        }
//        System.out.println();
//        System.out.println(machine.convert(17) == 21);
//        System.out.println(machine.convert("OMHISSHOULDERHIAWATHA").equals("PQSOKOILPUBKJZPISFXDW"));
//        System.out.println(machine.convert("TOOK THE CAMERA OF ROSEWOOD").equals("BHCNSCXNUOAATZXSRCFYDGU"));
//        System.out.println(machine.convert("Made of sliding folding rosewood").equals("FLPNXGXIXTYJUJRCAUGEUNCFMKUF"));
    }
}
