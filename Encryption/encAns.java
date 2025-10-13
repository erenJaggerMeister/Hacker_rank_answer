import java.util.Scanner;

public class encAns {
    static String input;
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args0){
        input = sc.nextLine();
        Result res = new Result();
        String test = res.encryption(input);
        System.out.println(test);
    }
}

class Result{
    public static String encryption(String s){
        //Write your code here
        String resEncrypt = "";
        String[][] arrayString = arrayWords(s);
        resEncrypt = encryptArray(arrayString);
        return resEncrypt;
    }

    private static String[][] arrayWords(String s){
        try{
            int baris = (int) Math.floor(Math.sqrt(s.length()));
            int kolom = (int) Math.ceil(Math.sqrt(s.length()));
            if(!((baris*kolom)>=s.length())){
                if(baris<kolom){
                    baris++;
                } else {
                    kolom++;
                }
            }
            String[][] putWordsArray = new String[baris][kolom];
            int indexString = 0;
            for(int i=0; i<baris ; i++){
                for(int j=0;j<kolom;j++){
                    String addChar = (indexString>=s.length()) ? "" : String.valueOf(s.charAt(indexString));
                    putWordsArray[i][j] = addChar;
                    indexString++;
                }
            }
            //test print
            // for(int i=0; i<baris ; i++){
            //     for(int j=0;j<kolom;j++){
            //         System.out.print(putWordsArray[i][j]+" ");
            //     }
            //     System.out.println();
            // }
            return putWordsArray;
        } catch(Exception e){
            e.printStackTrace();
            System.err.println(e);
            System.out.println("Error message : "+e.getMessage());
            return null;
        }
    }

    private static String encryptArray(String[][] s){
        try{
            String result = "";
            int baris = s.length;
            int kolom = s[0].length;
            // for(int i=0;i<baris;i++){
            //     for(int j=0;j<kolom;j++){
            //         result += s[j][i];
            //     }
            //     result += " ";
            // }
            for(int j=0;j<kolom;j++){
                for(int i=0;i<baris;i++){
                    result += s[i][j];
                }
                result += " ";
            }
            return result;
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("Error message: "+e.getMessage());
            return null;
        }
    }
}