package Sem_2;

import java.util.Random;
import java.util.Scanner;

// Написать консольное приложение - игру Быки и Коровы, числовой вариант либо со словами. Дать пользователю 3-5 попыток угадать загаданное.

public class task1 {

    public static Scanner sc = new Scanner(System.in,  "Cp866");
    public static Random rand = new Random();
    public static String[] arr = {"кура", "крол", "утка", "гусь"};
    public static boolean win = false;
    public static int tryes = 0;

    public static void main(String[] args) {
        int cntTryes = countTryes();
        sc.nextLine();
        String word = selectWord();
        String userword;
        while (!win && tryes < cntTryes){
            userword = userInput();
            System.out.println(checkWord(word, userword));
            tryes++;
        }        
        if (!win){
            System.out.println("Вы проиграли. Было загадано: " + word);
        }
    }

    public static String selectWord(){
        return arr[rand.nextInt(arr.length)];
    }

    public static int countTryes(){
        System.out.print("Введите количество попыток (от 3 до 5): ");
        return sc.nextInt();
    }

    public static String userInput() {
        System.out.print("Введите слово из 4-х неповторяющихся букв: ");
        return sc.nextLine();
    }
    
    public static String checkWord(String word, String userword) {
        int countCows = 0;
        int countBulls = 0;

        char [] arrCharword = word.toCharArray();
        char [] arrCharUserWord = userword.toCharArray();

        for (int i = 0; i < word.length(); i++){
            //ищем быков
            if (arrCharword[i] == arrCharUserWord[i]){
                countBulls++;
            }
            // ищем коров
            for (int j = 0; j < word.length(); j++){
                if ((arrCharUserWord[i] == arrCharword[j]) && (i != j)){
                    countCows++;
                }
            }
        }

        if (countBulls == word.length()){
            win = true;
            return "Быков: " + countBulls + "\nКоров: " + countCows + "\nПобеда! Вы угадали!";
        } else {
            return "Быков: " + countBulls + "\nКоров: " + countCows;
        }
    }
}