package com.company;
//REDUNDANT CODE
public class ActiveThreadCounter {
    private static int running = 0;
    private static ActiveThreadCounter instance;

    private ActiveThreadCounter(){}
/*
//this has more overhead so is no longer used
    public static synchronized ActiveThreadCounter getInstance(){
        if(instance == null){
            instance = new ActiveThreadCounter();
        }
        return instance;
    }
    */
    public static ActiveThreadCounter getInstance(){
        if(instance == null){
            synchronized (ActiveThreadCounter.class) {
                if(instance == null){
                    instance = new ActiveThreadCounter();
                }
            }
        }
        return instance;
    }


}

