package com.JakubP.RandomNumberApp.logic;

import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {

        int number = 0;
        Connector c = new Connector();
        ChatBot bot = ChatBot.getBot();
        Scanner scan = new Scanner(System.in);
        int choice;

        c.connect();

        while(true){
            System.out.println("Co chcesz zrobic?");
            System.out.println("1: Losuj");
            System.out.println("2: Zakończ");
            choice = scan.nextInt();
            if(choice==1){
                System.out.println();
                System.out.println("------------------------------------------------------");
                number = Generator.getRandomNumber(0,100, bot.getNumberFromMsg());
                System.out.println(number);
                System.out.println("------------------------------------------------------");
                System.out.println();
            }else if(choice==2){
                break;
            }
        }

        c.disconnect();
    }
}
