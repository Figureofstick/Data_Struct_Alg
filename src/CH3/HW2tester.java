package CH3;

public class HW2tester {

        public static void main(String[] args){

            River snakeriver = new River();
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
