package Ch2;

public class GeometricProgression extends Progression{
    // additional instance variables
    protected long multiplier;

    // Constructors
    public GeometricProgression(){this(2,1);}
    public GeometricProgression(long m) {this(m, 1);}
    public GeometricProgression(long m, long start){
        super(start);
        multiplier = m;
    }
    protected void advance() {current *= multiplier; }
}
