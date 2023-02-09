/**
 * @author Tarcisio da Rocha (Prof. DCOMP/UFS)
 */
package br.ufs.dcomp.ExemploTcpJava;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TCPClient{
    public static void main(String[] args){
        try {
            System.out.println("Escreva a mensagem:");
            Scanner scan = new Scanner(System.in);
            String msg = scan.nextLine();
            
            System.out.print("[ Conectando com o Servidor TCP    ..................  ");
            Socket sock = new Socket("127.0.0.1", 3300);
            System.out.println("[OK] ]");
            
            InputStream is = sock.getInputStream(); // Canal de entrada de dados
            OutputStream os = sock.getOutputStream(); // Canal de saída de dados
            byte[] buf = msg.getBytes(); // Obtendo a respresntação em bytes da mensagem

            System.out.print("[ Enviando mensagem    ..............................  ");
            os.write(buf);
            System.out.println("[OK] ]");
            
            System.out.println("Recebendo mensagem do servidor ....................  ");
            
            byte[] serverMsgBuff = new byte[50];
            is.read(serverMsgBuff);
            
            String serverMsg = new String(serverMsgBuff);
            
            System.out.println("Mensagem do servidor: " + serverMsg);
            
            sock.close();
        }catch(Exception e){System.out.println(e);}    
        System.out.println("[ FIM ]");
    }
}