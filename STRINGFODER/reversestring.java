public class reversestring {
    public static void main(String[] args) {
        
        String name1 = "Add";


        // int reversename = name.length() - 1;
        // int i = 0;
        // while(i < name.length() && reversename >= 0 ){

        //     System.out.print(name.charAt(reversename));
        //     reversename--;
        //     i++;

        // }
        System.out.println("The original string is "+ name1 +"\nThe  reverse is "+ reveStringFn(name1));
        vowelsconstcounter(name1);

    }

    public static String reveStringFn(String name){
        int i ;
        String rev ="";

        for(i = name.length() - 1;i >= 0;i--){
            
            rev = rev + name.charAt(i);

        }

        return rev;
    }
    public static void vowelsconstcounter(String name){
        int vowelcount = 0;
        int constcount = 0;
        int specialcount = 0;
        String nameup = name.toUpperCase();

        for(int i = 0; i < name.length(); i++){
            if(nameup.charAt(i) >= 65 || nameup.charAt(i) <= 122){

                if(nameup.charAt(i) == 'A' || nameup.charAt(i) == 'E' || nameup.charAt(i) == 'I'||nameup.charAt(i) == 'O'||nameup.charAt(i) == 'U' ){
                    vowelcount = vowelcount + 1;
                }
                else{
                    constcount = constcount + 1;
                }
            }
            else{
                specialcount += 1;
            }

        }

        System.out.println("The number of vowels is "+ vowelcount);
        System.out.println("The number of constants is "+constcount);
        System.out.println("The number of special characters is "+specialcount);
            
    }


}
