package org.example;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        String outMessage = "Hi!";
        System.out.println("Creating a socket and waiting for connection");
        ServerSocket mySocket = new ServerSocket(3256);
        Socket actualSocket = mySocket.accept();
        System.out.println("Client has connected to server socket!");

        MyCoolDataStructure queue = new MyCoolDataStructure();
        DataReader myDataReader = new DataReader(actualSocket, queue);
        ProgramLogicDoer myProgramLogicDoer = new ProgramLogicDoer(queue);

        Thread dataReadThread = new Thread(myDataReader);
        Thread programLogicThread = new Thread(myProgramLogicDoer);

        dataReadThread.start();
        programLogicThread.start();
    }
}