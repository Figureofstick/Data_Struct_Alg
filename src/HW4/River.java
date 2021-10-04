package HW4;

import HW2.Animal;
import HW2.Bear;
import HW2.Fish;

import java.util.Random;


public class River {
    // instance variables
    private int size; // num of slots in river
    private int numAnimals = 0; // number of actual animals
    private Animal[] animals; // this holds our animal objects

    Random rand = new Random(System.currentTimeMillis());

    // constructors
    public River(int given){
        animals = new Animal[given];
        size = given;
    }
    public River(){
        animals = new Animal[500];
        size = 500;
    }

    // methods

    public void setSize(int setter){
        size = setter;

    }


    public void addAnimal(String type, int place){
       if (type == "Bear"){
           animals[place] = new Bear();
           numAnimals++;
       }
       else if(type == "Fish") {
           animals[place] = new Fish();
           numAnimals++;
       }
    }




    public void initialize() {
        int i = rand.nextInt(3); // This is a "switching" int that will either be 0,1,2
        int tempSize = size;

        for (int j = 0 ; j < tempSize ; j++ ){
            if(i == 0){
                addAnimal("Bear", j);
                i = rand.nextInt(3);
            }
            else if(i == 1){
                addAnimal("Fish", j);
                i = rand.nextInt(3);
            }
            else if(i == 2){i = rand.nextInt(3);}
        }
    }

    public boolean allBears(){
        Boolean tempBool = true;
        int tempSize = size;
        for(int j = 0; j < tempSize; j ++){
            if(animals[j] == null || animals[j].toString() == "Fish"){
                tempBool = false;
            }
        }
    return tempBool;
    }


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
    public String toString(){
            String comp = "This river is composed of : \n";
            int tempSize = size;
            for (int i = 0; i < tempSize ; i++){
               if (animals[i] == null ){comp += (i+1) + ". This space is blank\n";}
                else{ comp += (i+1) + ". " + animals[i].toString() + "\n";}

            }
            return comp;
        }

    public String summary(){
        int tempSize = size;
        int b = 0;
        int f = 0;
        int n = 0;
        for (int i = 0; i < tempSize ; i++){
            if (animals[i] == null){ n++; }
            else{
                if(animals[i].toString() == "Fish"){ f++; }
                else if(animals[i].toString() == "Bear"){b++;}
            }

        }
        return "This river is composed of " + b + " bears, " + f + " fish, and " + n + " empty spaces.";
    }
}
