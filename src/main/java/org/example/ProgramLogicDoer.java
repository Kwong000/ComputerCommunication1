package org.example;

public class ProgramLogicDoer implements Runnable{

    MyCoolDataStructure inData;

    public ProgramLogicDoer(MyCoolDataStructure inData) {
        this.inData = inData;
    }

    public void run() {
        Object inMessage1 = inData.get();
        while (true) {
            if (inMessage1 != null) {
                System.out.println(inMessage1);
            }
            inMessage1 = inData.get();
        }
    }
}