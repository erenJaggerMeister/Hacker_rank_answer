import java.util.Scanner;

public class lvable {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int manyChar = sc.nextInt();
        char[] arrSentence = new char[manyChar];

        //call method "insertCharToArray"
        insertCharToArray(manyChar, arrSentence);
    }

    public static void insertCharToArray(int manyChar, char[] arrSentence){
        for(int i=0 ; i<manyChar ; i++){
            char inputChar = sc.next().charAt(0);
            arrSentence[i] = inputChar;
        }
    }

    public static int minimumNumberOperation(char[] arrSentence){
        //cek if there is character 'l'
        boolean foundCharL = new String(arrSentence).indexOf('l') != -1;

        int locationOfL = -1;
        if(foundCharL == true){
            locationOfL = new String(arrSentence).indexOf('l');
        }

        //cek if there is character 'v'
        boolean foundCharV = new String(arrSentence).indexOf('v') != -1;

        int locationOfV = -1;
        if(foundCharV == true){
            locationOfV = new String(arrSentence).indexOf('v');
        }
    }
}
