import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    static String get_exp(char[] regex, ArrayList<Object> aalfabe, int sayı) {
        String word="";

        for(int i=0;i<regex.length;i=i+1){
            if(i!=regex.length-1){
                if(aalfabe.contains(regex[i]) && regex[i+1]=='*'){
                    for(int s=0;s< sayı;s++) {
                        word=word+regex[i];
                    }
                }else if (regex[i]=='*') continue;
                else {word+= regex[i];}
            }else{
                if(aalfabe.contains(regex[i])) word=word+regex[i];
                else continue;
            }

        }

        return "{"+word+"}";
    }

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
//*************************INPUT İŞLEMLERİ*************************//
        System.out.println("(arada virgül ya da boşluk olmadan)Alfabeyi giriniz: ");
        String tempAlfabe=scanner.nextLine();
        char [] alfabe= tempAlfabe.toCharArray();
        ArrayList<Object> aalfabe= new ArrayList<>();
        for(int a=0;a< alfabe.length;a++) aalfabe.add(alfabe[a]);


        System.out.println("Düzenli ifadeyi giriniz: ");
        String tempRegex=scanner.nextLine();
        char [] regex=tempRegex.toCharArray();



        System.out.println("Kaç kelime istediğinizi giriniz: ");
        int sayı=scanner.nextInt();

//***************************KELİME ÜRETME*****************************//

        for (int temp_sayi = 0;temp_sayi < sayı;temp_sayi++) {
            System.out.println(get_exp(regex, aalfabe, temp_sayi));
        }


    }
}
/* YALNIZCA BASİT İFADELERİ YAPABİLMEKTEDİR 
PARANTEZ VE + İŞLEMİ YOKTUR
A*B
A*B* GİBİ İFADELER 
 */