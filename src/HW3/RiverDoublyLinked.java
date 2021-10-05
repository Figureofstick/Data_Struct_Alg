package HW3;

import java.util.Random;


public class RiverDoublyLinked {
    // instance variables

    private int numAnimals = 0; // number of actual animals
    // private Animal[] animals; // this holds our animal objects
    private DoublyLinkedList<Animal> animals = new DoublyLinkedList<>();
    Random rand = new Random(System.currentTimeMillis());

    // constructors
    public RiverDoublyLinked(){
        DoublyLinkedList<Animal> animals = new DoublyLinkedList<>();

    }

    // methods
    public void addAnimal(String type, String place) {
        int temp_rand = rand.nextInt(2);
        if (animals.isEmpty()) {
            if (type == "Bear") {
                animals.addFirst(new Bear());
            }
            else if (type == "Fish") {
                animals.addFirst(new Fish());
            }
            else if (type == "EmptyAnimal") {
                animals.addFirst(new EmptyAnimal());
            }
        }
        else {
            if (type == "Bear") {
                if (place == "Up") {
                    animals.addFirst(new Bear());
                }
                else if (place == "Down") {
                    animals.addLast(new Bear());
                }
                else if (place == "Rand") {
                    if(temp_rand == 0){animals.addFirst(new Bear());}
                    else if(temp_rand == 1){ animals.addLast(new Bear());}

                }
            }
            else if (type == "Fish") {
                if (place == "Up") {
                    animals.addFirst(new Fish());
                }
                else if (place == "Down") {
                    animals.addLast(new Fish());
                }
                else if (place == "Rand") {
                    if(temp_rand == 0){animals.addFirst(new Fish());}
                    else if(temp_rand == 1){ animals.addLast(new Fish());}
                }
            }
            else if (type == "EmptyAnimal") {
                if (place == "Up") {
                    animals.addFirst(new EmptyAnimal());
                }
                else if (place == "Down") {
                    animals.addLast(new EmptyAnimal());
                }
                else if (place == "Rand") {
                    if(temp_rand == 0){animals.addFirst(new EmptyAnimal());}
                    else if(temp_rand == 1){ animals.addLast(new EmptyAnimal());}
                }
            }
        }
    }

    public void changeAnimal(String type, String place){
        int temp_rand = rand.nextInt(2);
            if (type == "Bear") {
                if (place == "Up") {
                    animals.removeFirst();
                    animals.addFirst(new Bear());
                }
                else if (place == "Down") {
                    animals.removeLast();
                    animals.addLast(new Bear());
                }
                else if (place == "Rand") {
                    if(temp_rand == 0) {
                        animals.removeFirst();
                        animals.addFirst(new Bear());
                    }
                    else if(temp_rand == 1){
                        animals.removeLast();
                        animals.addLast(new Bear());
                    }

                }
            }
            else if (type == "Fish") {
                if (place == "Up") {
                    animals.removeFirst();
                    animals.addFirst(new Fish());
                }
                else if (place == "Down") {
                    animals.removeLast();
                    animals.addLast(new Fish());
                }
                else if (place == "Rand") {
                    if(temp_rand == 0){
                        animals.removeFirst();
                        animals.addFirst(new Fish());}
                    else if(temp_rand == 1){
                        animals.removeLast();
                        animals.addLast(new Fish());}
                }
            }
        }


    public void initialize(int spaces) {
        int i = rand.nextInt(3); // This is a "switching" int that will either be 0,1,2
        int tempSize = spaces;
        for (int j = 0 ; j < tempSize ; j++ ){
            if(i == 0){
                addAnimal("Bear", "Rand");
                i = rand.nextInt(3);
            }
            else if(i == 1){
                addAnimal("Fish", "Rand");
                i = rand.nextInt(3);
            }
            else if(i == 2){
                addAnimal("EmptyAnimal", "Rand");
                i = rand.nextInt(3);}
        }
    }

    public boolean allBears(){
        Boolean tempBool = true;
        int tempSize = animals.size();
        for(int j = 0; j <= tempSize; j ++){
            String tempSingleAnimal = animals.first().toString();
            if (tempSingleAnimal != "Bear" && tempBool){
                tempBool = false;
            }
            animals.addLast(animals.removeFirst());
            }
            animals.addFirst(animals.removeLast());
    return tempBool;
    }


    public void moveUp() {
        if(animals.first().toString() == "Empty") {
        // move animal to different empty cell condition
        changeAnimal(animals.toString(), "Up");
        }
        // mate animals condition
        else if(animals.toString() == animals.first().toString() && animals.toString() != "Empty"){
            String tempAnimalType = animals.toString();
            int tempSize = animals.size();
            boolean tempBool = true;
            for(int i=0; i<tempSize; i++ ){
                animals.addLast(animals.removeFirst());
                if(tempBool && animals.first().toString()== "Empty"){
                   changeAnimal(tempAnimalType, "Up");
                   tempBool = false;
                }

            };
        }
        // bear eats fish condition
        else if(animals.first().toString() != animals.toString() && animals.toString() != "Empty") {
            if(animals.first().toString() == "Fish"){changeAnimal("Bear","Up");}
            else if(animals.toString() == "Fish"){
                animals.addFirst(animals.removeLast());
                changeAnimal("Bear", "Up");
                animals.addLast(animals.removeFirst());
            }
        }
        }


     public void moveDown() {
         if(animals.last().toString() == "Empty") {
         // move animal to different empty cell condition
         changeAnimal(animals.toString(), "Down");
         }
         // mate animals condition
         else if(animals.toString() == animals.last().toString() && animals.toString() != "Empty"){
             String tempAnimalType = animals.toString();
             int tempSize = animals.size();
             boolean tempBool = true;
             for(int i=0; i<tempSize; i++ ){
                 animals.addFirst(animals.removeLast());
                 if(tempBool && animals.last().toString()== "Empty"){
                    changeAnimal(tempAnimalType, "Down");
                    tempBool = false;
                 }

             };
         }
         // bear eats fish condition
        else if(animals.last().toString() != animals.toString() && animals.toString() != "Empty") {
             if(animals.last().toString() == "Fish"){changeAnimal("Bear","Down");}
             else if(animals.toString() == "Fish"){
                 animals.addFirst(animals.removeLast());
                 changeAnimal("Bear", "Up");
                 animals.addLast(animals.removeFirst());
             }
         }
         }


    public void iterate(int times){
        while(times > 0){
            int tempSize = animals.size();
            for(int i = 0; i < tempSize -1; i++){
                int choice = rand.nextInt(3);
                if(choice == 0 ){moveUp();}
                else if(choice == 1){moveDown();}
                animals.addLast(animals.removeFirst());
            }
            times--;
            if(allBears()){break;}
        }

    }

    public String toString(){
            String comp = "This river is composed of : \n";

            comp += animals.toList();
            return comp;
    }

    public String summary(){
        int tempSize = animals.size();
        int b = 0;
        int f = 0;
        int n = 0;


        for (int i = 0; i <= tempSize ; i++){
            String tempSingleAnimal = animals.first().toString();


            if (tempSingleAnimal == "Empty"){ n++; }
            else if(tempSingleAnimal == "Fish"){f++;}
            else if(tempSingleAnimal == "Bear"){b++;}
            animals.addLast(animals.removeFirst());

        }
        animals.addFirst(animals.removeLast());
        return "This river is composed of " + b + " bears, " + f + " fish, and " + n + " empty spaces.";
    }

}

