package com.company;

public class TestSender implements Runnable{
    private Thread t;
    private int threadNumber;
    private static int activeThreads = 0;//how many threads are currently running
    private String ipAddress;
    private String payload;
    private static int amountToSend=1;//how many messages you want the threads to each send
    private int amountSent = 0;
    private static int timeToWait = 500;//how long you want to wait before sending amount of messages



    public TestSender(){
        ipAddress = "127.0.0.0";
        payload = "someData";
        amountToSend = 1;
        timeToWait=1000;
    }

    public TestSender(String serverAddress,String Payload){
        ipAddress = serverAddress;
        payload = Payload;
        amountToSend=1;
        timeToWait=1000;
    }
    public TestSender(int Amount, int TimeInterval){
        ipAddress = "127.0.0.0";
        payload = "someData";
        amountToSend=Amount;
        timeToWait=TimeInterval;
    }

    public TestSender(String serverAddress,String Payload, int Amount, int TimeInterval){
        ipAddress = "127.0.0.0";
        payload = "someData";
        amountToSend=Amount;
        timeToWait=TimeInterval;
    }


    public void run(){
        try {
            activeThreads++;
            threadNumber = activeThreads;

            for (amountSent=0;amountSent<=amountToSend;amountSent++) {
                printInfo();
                Thread.sleep(timeToWait);
            }
            activeThreads--;
        }
        catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
    }
    public void start () {
        System.out.println("Starting thread");
        //if (t == null) {
            t = new Thread (this);
            t.start ();
        //}
    }





    public void printInfo(){
        System.out.printf("\n\n-----------THREADINFO------------\nIP:%s\nPAYLOAD:%s\n THREADNO:%d/%d\nAMOUNT SENT%d/%d\n\n--------------STOP------------\n", ipAddress,payload,threadNumber,activeThreads ,amountSent,amountToSend);
    }

    public void attachFile(String FileName){

    }















    public static void setTimeToWait(int timeToWait) {
        try {
            TestSender.timeToWait = timeToWait;
        }
        catch (Exception ex){
            TestSender.timeToWait = 1000;
        }
    }

    public static void setActiveThreads(int activeThreads) {
        try {
            TestSender.activeThreads = activeThreads;
        }
        catch (Exception ex){
            TestSender.activeThreads = 0;
        }

    }

    public void setAmountSent(int amountSent) {
        try {
            this.amountSent = amountSent;
        }
        catch (Exception ex){
            this.amountSent = 0;
        }
    }

    public void setIpAddress(String ipAddress) {
        if (ipAddress!=null) {
            this.ipAddress = ipAddress;
        }
        else{
            this.ipAddress = "127.0.0.0";
        }
    }

    public void setPayload(String payload) {
        if (payload!=null) {
            this.payload = payload;
        }
        else{
            this.payload="NO PAYLOAD SPECIFIED";
        }
    }

    public static void setAmountToSend(int amountToSend) {
        if (amountToSend < 0) {
            TestSender.amountToSend = amountToSend;
        } else {
            TestSender.amountToSend = 1;
        }
    }
}

