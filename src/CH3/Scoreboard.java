package CH3;

import java.util.Random;

public class Scoreboard {
    //instance variables
    private int numEntries = 0; // number of actual entries
    private GameEntry[] board; // this is composition


    // constructor
    public Scoreboard(int capacity) {
        board = new GameEntry[capacity];
    }

    // methods
    public void addGame(GameEntry e){
        int newScore = e.getScore();
        int lowestScore = 0;
        // if (numEntries > 0){
          //  lowestScore = board[numEntries - 1].getScore();
        // }
        if (numEntries < board.length || newScore > lowestScore){
           if (numEntries < board.length){numEntries++;}
           int j = numEntries -1;
           while (j>0 && board[j-1].getScore() < newScore) {
               board[j] = board[j - 1];
               j--;
           }
           board[j] = e;
        }

    }

    // public GameEntry remove(int i){}
    public GameEntry remove(int i ){
        if (i<0 || i >= numEntries){
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        }
        GameEntry temp = board[i];
        for (int j = i; j < numEntries - 1; j++) {
            board[j] = board[j + 1];
        }
        board[numEntries-1] = null;
        numEntries--;
        return temp;
    }
    public String toString(){
        String sb = "Scoreboard: \n";
        for (int i = 0; i < numEntries ; i++){
            sb += (i+1) + ". " + board[i].toString() + "\n";

        }
        return sb;
    }

    public static void main(String[] args){
        Scoreboard highscores = new Scoreboard(10);

        GameEntry ge = new GameEntry("Leslie", 10);
        highscores.addGame(ge);
        GameEntry ge2 = new GameEntry("Ralph", 50);
        highscores.addGame(ge2);

        highscores.remove(1);

        Random rand = new Random();
        int[] scores = new int[5];
        rand.setSeed(System.currentTimeMillis());

        System.out.println(highscores.toString());

    }

}

