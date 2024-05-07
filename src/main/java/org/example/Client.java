package org.example;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        System.out.println("Connecting to my server");
        Socket newSocket = new Socket("10.37.157.240",3256);

        MyCoolDataStructure queue = new MyCoolDataStructure();
        DataReader myDataReader = new DataReader(newSocket, queue);
        ProgramLogicDoer myProgramLogicDoer = new ProgramLogicDoer(queue);

        Thread dataReadThread = new Thread(myDataReader);
        Thread programLogicThread = new Thread(myProgramLogicDoer);

        dataReadThread.start();
        programLogicThread.start();

        OutputStream out = newSocket.getOutputStream();
        ObjectOutputStream objOut = new ObjectOutputStream(out);

        objOut.writeObject("FIRST from Keith");
        objOut.writeObject("SECOND from Keith");
        objOut.writeObject("THIRD from Keith");

        System.out.println("Done sending messages");
    }
}