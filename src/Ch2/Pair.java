package Ch2;

public class Pair<A, B> {
    // instance variables
    A first;
    B second;

    public Pair(A a, B b) {
        first = a;
        second = b;
    }
    // methods
    public A getFirst() {return first;}
    public B getSecond() {return second;}
    public String toString() {
        return "[" + first + "," + second + "]";
    }
    public static void main(String[] args){
        Pair<String, Double> bid;
        bid = new Pair<String,Double>("ORCL",35.64);
        System.out.println(bid.toString());

        Pair<Double, Double> point = new Pair<>(1.5, 2.25); // use type inference
        System.out.println(point);

    }
}
