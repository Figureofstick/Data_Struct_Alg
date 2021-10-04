package CH3;

import java.util.Random;


public class River {
    // instance variables
    private int size; // num of slots in river
    private int numAnimals = 0; // number of actual animals
    // private Animal[] animals; // this holds our animal objects
    private DoublyLinkedList<Animal> animals = new DoublyLinkedList<>();
    Random rand = new Random(System.currentTimeMillis());

    // constructors
    public River(){
        DoublyLinkedList<Animal> animals = new DoublyLinkedList<>();
        size = 0;
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
        DoublyLinkedList<Animal> tempRiver = new DoublyLinkedList<Animal>();
        for(int j = 0; j <= tempSize; j ++){
            String tempSingleAnimal = animals.first().toString();

            if (tempSingleAnimal != "Bear"){
                tempBool = false;
                break;
            }

            tempRiver.addLast(animals.removeFirst());
            }

    return tempBool;
    }

    /*
    public void moveUp(int place) {
        if (place != 0 && animals[place] != null) {
            // move animal to different empty cell condition
            if (animals[place - 1] == null) {
                animals[place - 1] = animals[place];
                animals[place] = null;
            }
            // mate animals condition
            else if (animals[place - 1].toString() == animals[place].toString()) {
                int upSpaces = 0;
                int downSpaces = 0;
                Boolean tempBool = true;
                while (tempBool) {
                    upSpaces++;
                    downSpaces++;
                    if ((place - upSpaces) > -1 && animals[place - upSpaces] == null) {
                        animals[place - upSpaces] = animals[place];
                        tempBool = false;
                    }
                    else if ((place + downSpaces) < size && animals[place + downSpaces] == null) {
                        animals[place + downSpaces] = animals[place];
                        tempBool = false;
                    }
                    else if(upSpaces > size || downSpaces > size){break;}
                }
            }
            // bear eats fish condition
            else if (animals[place - 1].toString() != animals[place].toString()) {
                if (animals[place].toString() == "Fish") {
                animals[place] = new Bear();
            }
                else if (animals[place - 1].toString() == "Fish") {
                animals[place - 1] = new Bear();
            }
        }
    }
    }

    public void moveDown(int place){
        if(place != size && animals[place] != null){
            // move animal to different empty cell condition
            if(animals[place+1] == null && (place + 1) < size ){
                animals[place+1] = animals[place];
                animals[place] = null;
            }
            // mate animals condition
            else if(animals[place+1].toString() == animals[place].toString()){
                int upSpaces = 0;
                int downSpaces = 0;
                Boolean tempBool = true;
                while(tempBool){
                    upSpaces++;
                    downSpaces++;
                    if((place + downSpaces) < size && animals[place+downSpaces] == null){
                        animals[place+downSpaces] = animals[place];
                        tempBool = false;
                    }

                    else if((place - upSpaces) > -1 && animals[place-upSpaces] == null){
                        animals[place-upSpaces] = animals[place];
                        tempBool = false;
                    }
                    else if(upSpaces > size || downSpaces > size){break;}
                }
            }
            // bear eats fish condition
            else if(animals[place+1].toString() != animals[place].toString()){
                if(animals[place].toString() == "Fish"){animals[place] = new Bear();}
                else if(animals[place+1].toString() == "Fish"){animals[place+1] = new Bear();}

            }
        }
    }

    public void iterate(int times){
        while(times > 0){
            int tempSize = size;
            for(int i = 0; i < tempSize -1; i++){
                int choice = rand.nextInt(3);
                if(choice == 0 && i != 0){moveUp(i);}
                else if(choice == 1 && i != tempSize){moveDown(i);}
            }
            times--;
            if(allBears()){break;}
        }

    }
    */
    public String toString(){
            String comp = "This river is composed of : \n";

            comp += animals.toString();
            return comp;
    }

    public String summary(){
        int tempSize = animals.size();
        int b = 0;
        int f = 0;
        int n = 0;
        DoublyLinkedList<Animal> tempRiver = new DoublyLinkedList<Animal>();
        for (int i = 0; i <= tempSize ; i++){

            String tempSingleAnimal = animals.first().toString();
            if (tempSingleAnimal == "Empty"){ n++; }
            else if(tempSingleAnimal == "Fish"){f++;}
            else if(tempSingleAnimal == "Bear"){b++;}
            tempRiver.addLast(animals.removeFirst());

        }
        animals = tempRiver;

        return "This river is composed of " + b + " bears, " + f + " fish, and " + n + " empty spaces.";
    }

}

