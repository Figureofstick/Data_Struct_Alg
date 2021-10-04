package Ch2;

public abstract class AbstractProgression {
    /*
     * instance variables
     */
    protected long current;

    /*
     * Constructors
     */
    /** Constructs a progression starting at zero. */
    public AbstractProgression() { this(0); }

    /** Constructs a progression with given start value. */
    public AbstractProgression(long start) { current = start; }

    /*
     * Methods
     */
    /** Returns the next value of the progression. */
    public long nextValue() { // this is a concrete method
        advance();
        return current;
    }
    protected abstract void advance(); //abstract method

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
