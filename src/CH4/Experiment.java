package CH4;

public class Experiment {
    public static String concatString(char c, int n){
        String result = "";
        for (int i=0; i<n; i++){
            result += c;
        }
        return result;
    }
    public static String concatSB(char c, int n){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i<n; i++){
            result.append(c);
        }
        return result.toString();
    }

    public static void main (String[] args){
        System.out.println(concatString('*',40));
        System.out.println(concatSB('+',40));

        int n = 1;

        long startTime = System.currentTimeMillis();
        String junk = concatString('*',n);
        long endTime = System.currentTimeMillis();

        System.out.println(endTime-startTime);

        startTime = System.currentTimeMillis();
        junk = concatSB('+',n);
        endTime = System.currentTimeMillis();

        System.out.println(endTime-startTime);
    }
}
