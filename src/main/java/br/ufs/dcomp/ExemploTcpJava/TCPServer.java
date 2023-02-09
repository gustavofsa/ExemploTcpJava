/**
 * @author Tarcisio da Rocha (Prof. DCOMP/UFS)
 */
package br.ufs.dcomp.ExemploTcpJava;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TCPServer{
    public static void main(String[] args){
        
        try {
            System.out.print("[ Iniciando Servidor TCP    .........................  ");
            ServerSocket ss = new ServerSocket(3300, 5, InetAddress.getByName("127.0.0.1"));
            System.out.println("[OK] ]");
            
            while(true) {
                System.out.print("[ Aquardando pedidos de conexão    ..................  ");
                Socket sock = ss.accept(); // Operação bloqueante (aguardando pedido de conexão)
                System.out.println("[OK] ]");
                
                InputStream is = sock.getInputStream(); //Canal de entrada de dados
                OutputStream os = sock.getOutputStream(); //Canal de saída de dados
                
                Integer qntBytes = is.available();
                
                System.out.println("Quantidade de bytes is.available: " + qntBytes);
                
                byte[] buf = new byte[100]; // buffer de recepção
    
                System.out.print("[ Aguardando recebimento de mensagem   ..............  ");
                is.read(buf); // Operação bloqueante (aguardando chegada de dados)
                System.out.println("[OK] ]");
                
                String msg = new String(buf); // Mapeando vetor de bytes recebido para String
                
                System.out.println("  Mensagem recebida: " + msg);
                
                System.out.println("Digite uma mensagem para o cliente:");
                Scanner scan = new Scanner(System.in);
                String msgToClient = scan.nextLine();
                
                System.out.print("[ Enviando mensagem para o cliente:  ................  ");
                
                byte[] messageBuff = msgToClient.getBytes();
                
                os.write(messageBuff);
                
                System.out.println("[OK] ]");
            }
        }catch(Exception e){System.out.println(e);}    
        System.out.println("[ FIM ]");
    }
}