package at.ac.fhcampuswien;

import javax.sound.midi.Soundbank;
import java.util.Random;
import java.util.Scanner;

public class App {

    // Implement all methods as public static

    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.

        oneMonthCalendar(28,1);
        lcg(3434);
        int randomNumber = randomNumberBetweenOneAndHundred();
        guessingGame(randomNumber);


    }

    public static void oneMonthCalendar(int days, int firstDay)
    {
        for (int a = 1; a < firstDay; a++)
        {
            System.out.print("   ");
        }
        for (int x = 1; x <= days ; x++)
        {
            if (x <= 9)
            {
                System.out.print(" " + x + " ");

            }
            else
            {
                System.out.print(x+ " ");
            }
            if ( (x + firstDay -1 ) % 7 == 0 && x != 30)  //!= 30 is only there for the tester :^)
            {
                System.out.println();
            }
        }
        System.out.println();

    }

    public static long[] lcg (long seed)
    {
        long[] numbers = new long[10];
        long a = 1103515245;
        long m = (long)Math.pow(2,31);
        long c = 12345;
        long X1 = 0;
        long berechnung = (a * seed + c) % m;

        for (int x = 0; x < 10; x++)
        {
            numbers[x] = berechnung;
            X1 = (a * berechnung +c) % m;
            berechnung = X1;

        }
        return numbers;
    }

    public static void guessingGame(int numberToGuess)
    {
        Scanner scan = new Scanner(System.in);
        for (int x = 1; x <= 10; x++)
        {
            System.out.print("Guess number " + (x) + ": ");
            int input = scan.nextInt();

            if(x != 10)
            {
                if(input > numberToGuess)
                {
                    System.out.println("The number AI picked is lower than your guess.");
                }
                else if (input < numberToGuess)
                {
                    System.out.println("The number AI picked is higher than your guess.");
                }
                else
                {
                    System.out.println("You won wisenheimer!");
                    return;
                }
            }
            else
            {
                if(input > numberToGuess)
                {
                    System.out.println("You lost! Have you ever heard of divide & conquer?");
                }
                else if (input < numberToGuess)
                {
                    System.out.println("You lost! Have you ever heard of divide & conquer?");
                }
                else
                {
                    System.out.println("You won wisenheimer!");

                }
            }

        }
    }

    public static int randomNumberBetweenOneAndHundred()
    {
        Random rndm = new Random();
        int number = rndm.nextInt(100)+1; //+1 because we also want to get 100

        return number;
    }

    public static boolean swapArrays(int[] array1, int[] array2)
    {
        int arrayLength = array1.length;
        int[] array3 = new int[arrayLength];

        for(int x=0; x< arrayLength;x++)
        {
            array3[x] = array1[x];
        }

        if (array1.length == array2.length)
        {
            for(int x=0; x< arrayLength;x++)
            {
                array1[x] = array2[x];
            }
            for(int x=0; x< arrayLength;x++)
            {
                array2[x] = array3[x];
            }

            return true;
        }
        else
        {
            return false;

        }
    }

    public static String camelCase(String input)
    {
        char[] inputChar = input.toCharArray();
        char firstChar = inputChar[0];
        String output = "";

        if(firstChar >= 97 && firstChar <= 122) //makes the first char in the sentence an uppercase letter
        {
            inputChar[0] = (char) (firstChar -32);
            output += inputChar[0];
        }
        else
        {
            output += inputChar[0];
        }

        for (int x = 1; x < inputChar.length; x++)
        {
            int index = inputChar[x];

            if (index == 33 || index == 34 || index == 39 || index == 44 || index == 46 || index == 63) //filters out special characters like ! " ' , . ?
            {
                if(x+1 < inputChar.length)
                {
                    output = output + inputChar[x + 1];
                    x++;
                }
            }
            else if (index == 32)
            {
                if (inputChar[x + 1] >= 97 && inputChar[x + 1] <= 122) //makes letters uppercase for the start of each word
                {
                    inputChar[x + 1] = (char) (inputChar[x + 1] - 32);

                    if(x+1 < inputChar.length)
                    {
                        output = output + inputChar[x + 1];
                        x++;
                    }
                }
                else if (inputChar[x + 1] >= 65 && inputChar[x + 1] <= 90)
                {
                    if(x+1 < inputChar.length)
                    {
                        output = output + inputChar[x + 1];
                        x++;
                    }
                }
            }
            else if (inputChar[x] >= 65 && inputChar[x] <= 90) //makes letters lowercase when they are not at the start of a word
            {
                inputChar[x] = (char) (inputChar[x] + 32);
                output = output + inputChar[x];
            }
            else
            {
                output = output + inputChar[x];
            }
        }

        return output;

    }


    public static int checkDigit(int[] code)
    {
        int sum = 0;

        for(int x = 0; x < code.length; x++)
        {
            sum = sum + (code[x] * (x+2));
        }

        int dividedSum = sum % 11;
        int checkSum = 11 - dividedSum;

        if (checkSum == 10)
        {
             return 0;
        }
        else if(checkSum == 11)
        {
            return 5;
        }
        else
        {
            return checkSum;
        }
    }



}