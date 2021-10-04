package Ch1;

public class Counter {
    // Attributes/data/state/instance variables
        private int count;

    // Constructors
        public Counter(){} // default constructor
        public Counter(int initial){ count = initial;}
    // Methods
        public int getCount() { return count; } // getter method or accessor method
        public void increment() { count++; } // update method, modifier method
        public void increment(int delta) { count += delta;} // overload increment()
    // count = count + delta; +=, -=, *=, /=
        public void reset() { count = 0;}
}
