package Server;

import java.net.*;
import java.util.Scanner;
import java.io.*;
import Operation.Operation;
public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
			
			//Lancement du server
			ServerSocket socketServer = new ServerSocket(1234);
			System.out.println("Je suis un serveur en attente la connexion d'un client");
			
			//Acceptation du connexion
			Socket socket = socketServer.accept();
			System.out.println("un client est connecté");
			
			// Flux de comunication
			OutputStream os = socket.getOutputStream();
			InputStream is = socket.getInputStream();
			// Flux de traitement
			ObjectOutputStream oos = new ObjectOutputStream(os);//sérialiser
			ObjectInputStream ois = new ObjectInputStream(is);//déserialiser
			// Reçeption de l'objet
			Operation o = (Operation)ois.readObject();
			
			// Récupération des parameters
			int nb1 = o.getOp1();
			int nb2 = o.getOp2();
			char op = o.getOperation();
			// Calculatrice
			switch (op) {
			case '+':
				o.setResult(nb1 + nb2);
				break;
			case '-':
				o.setResult(nb1 - nb2);
				break;
			case '*':
				o.setResult(nb1 * nb2);
				break;
			case '/':
				o.setResult(nb1 / nb2);
				break;
				

			default:
				break;
			}
			
			// Envoie de l'objet au client 
			oos.writeObject(o);
			// Fermeture du  socket
			socket.close();
			socketServer.close();
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}



	}

/** utilisation de inputstreamreader et bufferreader pour recevoir et envoiyer plus d'1 octect 
// Flux de traitement
PrintWriter pw = new PrintWriter(os,true);
InputStreamReader isr = new InputStreamReader(is);
BufferedReader br = new BufferedReader(isr);
//Reçeption du premier entier
String s = br.readLine();
int e1 = Integer.parseInt(s);

// Reçeption du deuxieme entier
s = br.readLine();
int e2 = Integer.parseInt(s);


//Reception du type d'operation
s = br.readLine();

//Calculatrice
int r=0;
switch (s) {
case "+":
	r = e1 + e2;
	break;
case "-":
	r = e1 - e2;
	break;
case "*":
	r = e1 * e2;
	break;
case "/":
	r = e1 / e2;
	break;
	

default:
	break;
}
//Envoie du résultat
pw.println(r);
**/

	}


