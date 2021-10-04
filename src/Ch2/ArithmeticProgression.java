package Ch2;

public class ArithmeticProgression extends AbstractProgression{
    // Additional instance variable
    protected long increment;

    // Constructors
    public ArithmeticProgression(){
        this(1, 0);
    }

    public ArithmeticProgression(long stepsize){
        this(stepsize, 0);
    }
    public ArithmeticProgression(long stepsize, long start){
        super(start);
        increment = stepsize;
    }
    // Override super method
    protected void advance() {current += increment; }
}
