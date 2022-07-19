package ShootingGame;

import java.util.Random;
import java.util.Scanner;

public class shootingTarget {
    public static void main(String[] args) {
        String[][] target = new String[6][6];

        targetFiller(target);

        Random random = new Random();
        int firstIndex = random.nextInt(5) + 1;
        int secondIndex = random.nextInt(5) + 1;
        System.out.println(firstIndex+ " " + secondIndex);
        Scanner sc = new Scanner(System.in);
        System.out.println("All set, get ready to rumble");
        while(true){
            System.out.print("enter row: ");
            int enteredRow=sc.nextInt();
            if(enteredRow>target.length-1 || enteredRow==0){
                System.out.println("Entered row must be between 1 and 5. Please, try again. ");
                continue;
            }

            System.out.print("enter column: ");
            int enteredColumn=sc.nextInt();
            if(enteredColumn>target.length-1 || enteredColumn==0){
                System.out.println("Entered column must be between 1 and 5. Please, try again.");
                continue;

            }
            if(enteredRow==firstIndex && enteredColumn==secondIndex){
                target[firstIndex][secondIndex]="x";
                printArray(target);
                System.out.println("You have won!");
                break;
            }else{
                missedShoot(target,enteredRow, enteredColumn);
                printArray(target);
                System.out.println("Please, try again");
            }




        }

    }

    public static void targetFiller(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[0][j] = String.valueOf(j);
                arr[i][0] = String.valueOf(i);
                if (i != 0 && j != 0) {
                    arr[i][j] = "-";
                }
                System.out.print(arr[i][j] + " | ");
            }
            System.out.println();

        }
    }

    public static void printArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " | ");
            }
            System.out.println();

        }
    }
    public static String[][] missedShoot (String[][] array, int first, int second){
        array[first][second]="*";
        return array;

    }



}



