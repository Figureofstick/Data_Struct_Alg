package HW4;

import HW3.RiverDoublyLinked;

public class HW4Tester {
    public static void main(String[] args){

        RiverDoublyLinked snakeriver = new RiverDoublyLinked();
        snakeriver.initialize(500);

        System.out.println(snakeriver);

        System.out.println(snakeriver.summary());

        System.out.println(snakeriver);

        System.out.println(snakeriver.allBears());

        System.out.println(snakeriver);
            /*
            snakeriver.iterate(1);

            System.out.println(snakeriver.summary());



            System.out.println(snakeriver.allBears());


            while(snakeriver.allBears() != true){
                snakeriver.iterate(1);
                System.out.println(snakeriver);
                System.out.println(snakeriver.summary());
            }
            */

    }
}
