package com.company;


import java.io.InputStreamReader;
import java.util.Scanner;

//load testing app
///make x amounts of threads
//make them at interval x per second
//wait for response from server
// stop if the response code is 5xx or 4xx
public class Main {

    public static void main(String[] args) {
        int numberOfThreads = 1;
        double time =1;
        int perSec = 1;
        int messageVolume = 1;
        Scanner read = new Scanner(System.in);
        while(true){

            System.out.print("please input a number of simultaneous messages to send:");
            try {
                numberOfThreads = read.nextInt();
            }
            catch (Exception ex){
                numberOfThreads = 1;
                System.out.print("not an integer defaulting to 1");
            }

            System.out.print("please input how many messages you want them to be sending(default 1)");
            try {
                messageVolume = read.nextInt();
            }
            catch (Exception ex){
                messageVolume = 1;
                System.out.print("not an integer defaulting to 1");
            }

            System.out.print("please input how many messages you want them to send per second");
            try {
                perSec = read.nextInt();
                time = ToDelay(perSec);
            }
            catch (Exception ex){
                perSec = 1;
                System.out.print("not an integer defaulting to 1");
            }

                System.out.printf("%d threads will be created", numberOfThreads);

            Thread[] threadArray = new Thread[numberOfThreads];
            for (int i =0; i<numberOfThreads;i++) {
                threadArray[i] = new Thread(new TestSender());
            }

            for (int i =0; i<numberOfThreads;i++) {
                threadArray[i].start();
            }
            for (int i =0; i<numberOfThreads;i++) {
                try {
                    threadArray[i].join();
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
            }
            //threadArray.join();


            //TestSender t1 = new TestSender();
            //for (int i = 0;i<numberOfThreads;i++) {
            //    try {
            //        Thread.sleep(1000);
            //    }
            //    catch (InterruptedException yo){
            //        //do nothing if you are put to sleep
            //    }

            //    t1.start();


            }
            //t1.Join();






        }



    /*this method converts the amount of messages per second wanted
    * into the amount of time needed to delay the creation of threads
    * */
    private static double ToDelay( int perSec){
        Double time;
        time = 1/(double)perSec;
        System.out.print(time);
        if(time<0){
            return time;
        }
        else return 0;
    }
}
