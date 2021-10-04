package Ch2;

/** Generates a simple progression. By default: 0, 1, 2, ... */
public class Progression {
    /*
     * instance variables
     */
    protected long current;

    /*
     * Constructors
     */
    /** Constructs a progression starting at zero. */
    public Progression() { this(0); }

    /** Constructs a progression with given start value. */
    public Progression(long start) { current = start; }

    /*
     * Methods
     */
    /** Returns the next value of the progression. */
    public long nextValue() {
        advance();
        return current;
    }

    /** Advances the current value to the next value of the progression. */
    protected void advance() {
        current++;
    }

    /** Prints the next n values of the progression, separated by spaces. */
    public void printProgression(int n) {
        System.out.println("Current value: " + current);
        System.out.print("Next " + n + " values: ");
        for (int i=0; i<n; i++) {
            System.out.print(nextValue() + " ");
        }
        System.out.println();
    }
}