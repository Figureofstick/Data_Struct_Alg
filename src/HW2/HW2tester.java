package HW2;

public class HW2tester {

        public static void main(String[] args){

            River snakeriver = new River(500);
            snakeriver.initialize();

            System.out.println(snakeriver);
            System.out.println(snakeriver.summary());
            snakeriver.iterate(1);
            System.out.println(snakeriver);
            System.out.println(snakeriver.summary());



            System.out.println(snakeriver.allBears());


            while(!snakeriver.allBears()){
                snakeriver.iterate(1);
                System.out.println(snakeriver);
                System.out.println(snakeriver.summary());
            }


        }

}
