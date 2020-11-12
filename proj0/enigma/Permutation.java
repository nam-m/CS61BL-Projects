package enigma;

import static enigma.EnigmaException.*;

/** Represents a permutation of a range of integers starting at 0 corresponding
 *  to the characters of an alphabet.
 *  @author Nam Anh Mai
 */
public class Permutation {

    /** Set this Permutation to that specified by CYCLES, a string in the
     *  form "(cccc) (cc) ..." where the c's are characters in ALPHABET, which
     *  is interpreted as a permutation in cycle notation.  Characters in the
     *  alphabet that are not included in any cycle map to themselves.
     *  Whitespace is ignored. */
    public Permutation(String cycles, Alphabet alphabet) {
        _alphabet = alphabet;
        _cycles = cycles;
        // FIXME - Assign any additional instance variables.
    }

    public String[] splitCycles(String str) {
        //Remove left and right parentheses and split permutation cycles into an array
        return str.replaceAll("[()]", "").split("\\s");
    }

    /** Return the value of P modulo the size of this permutation. */
    final int wrap(int p) {
        int r = p % size();
        if (r < 0) {
            r += size();
        }
        return r;
    }

    /** Returns the size of the alphabet I permute. */
    public int size() {
        // FIXME - How do we ask the alphabet for its size?
        return _alphabet.size();
    }

    /** Return the index result of applying this permutation to the character
     *  at index P in ALPHABET. */
    public int permute(int p) {
    	// NOTE: it might be beneficial to have one permute() method always call the other
        // FIXME - How do we use our instance variables to get the index that P permutes to?
        return _alphabet.toInt(permute(_alphabet.toChar(wrap(p))));
    }

    /** Return the index result of applying the inverse of this permutation
     *  to the character at index C in ALPHABET. */
    public int invert(int c) {
    	// NOTE: it might be beneficial to have one invert() method always call the other
        // FIXME - How do we use our instance variables to get the index that C inverts to?
        return _alphabet.toInt(invert(_alphabet.toChar(wrap(c))));
    }

    /** Return the character result of applying this permutation to the index
     * of character P in ALPHABET. */
    public char permute(char p) {
    	// NOTE: it might be beneficial to have one permute() method always call the other
        // FIXME - How do we use our instance variables to get the character that P permutes to?
        char nextChar = p;
        //Split cycles into a string array of permutation groups
        String[] cycleString = splitCycles(_cycles);
        for (String s : cycleString) {
            if (s.contains(String.valueOf(p))) {
                int nextCharLocation = s.indexOf(p) + 1;
                if (nextCharLocation == s.length())
                    nextCharLocation = 0;
                nextChar = s.charAt(nextCharLocation);
            }
        }
        return nextChar;
    }

    /** Return the character result of applying the inverse of this permutation
	 * to the index of character P in ALPHABET. */
    public char invert(char c) {
    	// NOTE: it might be beneficial to have one invert() method always call the other
        // FIXME - How do we use our instance variables to get the character that C inverts to?
        char prevChar = c;
        //Split cycles into a string array of permutation groups
        String[] cycleString = splitCycles(_cycles);
        for (String s : cycleString) {
            if (s.contains(String.valueOf(c))) {
                int prevCharLocation = s.indexOf(c) - 1;
                if (prevCharLocation == -1)
                    prevCharLocation = s.length() - 1;
                prevChar = s.charAt(prevCharLocation);
            }
        }
        return prevChar;
    }

    /** Return the alphabet used to initialize this Permutation. */
    public Alphabet alphabet() {
        return _alphabet;
    }

    /** Alphabet of this permutation. */
    private Alphabet _alphabet;
    //A string in the form of "(ccc) (cc) ..."
    private String _cycles;

    // FIXME - How do we store which letter permutes/inverts to which?

    // FIXME: ADDITIONAL FIELDS HERE, AS NEEDED

    // Some starter code for unit tests. Feel free to change these up!
    // To run this through command line, from the proj0 directory, run the following:
    // javac enigma/Permutation.java enigma/Alphabet.java enigma/CharacterRange.java enigma/EnigmaException.java
    // java enigma/Permutation
    public static void main(String[] args) {
        Permutation perm = new Permutation("(THEV) (CU) (ROS)", new CharacterRange('A', 'Z'));
        System.out.println(perm.size() == 26);
        System.out.println(perm.permute('V') == 'T');
        System.out.println(perm.invert('R') == 'S');
        System.out.println(perm.permute(3));
        System.out.println(perm.invert(0));
    }
}
