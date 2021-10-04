package Ch1;

public class HelloWorld {
    public static void main(String[] args){
        System.out.println("Hello World");

        //Variable names must start with a character, $, _
        //  can contain a number
        //  can't be any reserved word

        //Primitive/basic data types
        boolean flag = true; // note lowercase true/false
        char grade = 'A'; // single quotes
        int i = 255; // 32-bit int; byte = 8-bit; short=16-bit; long=64bit;
        float pi = 3.1415F; // 32-bit (note the F at the end)
        double ee = 2.71828; //64-bit

        System.out.println((int)pi); //int casting truncates
        String greeting = "Hello";
        greeting = "Hola";
        greeting = greeting + String.valueOf(i);
        System.out.println(greeting);


        // Classes and objects
        Counter c; //declares a variable -- no object constructed
        c = new Counter(); // constructs a new Counter, assigns its reference

        System.out.println("Value of c.count: " + c.getCount());

        Counter c2 = new Counter( 10);
        System.out.println("Value of c2.count: " + c2.getCount());

        c.increment();
        System.out.println("Value of c.count after increment(): " + c.getCount());
        c.increment(50);
        System.out.println("Value of c.count after increment(50): " + c.getCount());

        c.reset();

        // Arrays
        // int[] primes;
        // int[] primes = new int[100]; // create an array of 100 ints, all zeroes
        int[] primes = {2,3,5,7,11,13,17,19,23,29};
        System.out.println(primes[0]); // primes [0:5] ie slices don't work

        // Enumerators
        Day today;
        today = Day.TUE;
        System.out.println(today);
    }
    public enum Day {MON, TUE, WED, THU, FRI, SAT, SUN};
}
