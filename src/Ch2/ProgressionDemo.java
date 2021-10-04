package Ch2;

public class ProgressionDemo {
    public static void main(String[] args){
        AbstractProgression sequence;

        // Simple progression
        // System.out.print("---Simple/default progression--- \n");
        // sequence = new Progression(100);
        // sequence.printProgression(10);

        //Arithmetic progression
        System.out.print("---Arithmetic progression w stepsize 10--- \n");
        sequence = new ArithmeticProgression(100);
        sequence.printProgression(10);

        //Geometric progression
        // System.out.print("---Geometric progression w m=2-- \n");
        //sequence = new GeometricProgression();
        // sequence.printProgression(10);
    }
}
