package Client;
import java.net.*;
import java.util.Scanner;
import Operation.Operation;
import java.io.*;
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
			
			//Connexion au serveur
			System.out.println("Je suis un client pas encore connecté...");
			InetAddress ia = InetAddress.getByName("10.25.12.183");
			InetSocketAddress isa = new InetSocketAddress(ia,1234);
			Socket socket = new Socket();
			socket.connect(isa);
			System.out.println("Je suis un client connecté");
			
			// Lecture d'un entier
			Scanner scanner = new Scanner(System.in);
			
			// Flux de communication
			OutputStream os = socket.getOutputStream();
			InputStream is = socket.getInputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			ObjectInputStream ois = new ObjectInputStream(is);
			//Envoie de objet
			Operation O1= new Operation(100,2,'*');
			oos.writeObject(O1);
			
			// Reçeption de l'objet
			O1 = (Operation)ois.readObject();
			System.out.println("Résultat = "+O1.getResult());
		
			
			//Fermeture du Connexion
			socket.close();
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		


	}


/** utilisation de inputstreamreader et bufferreader pour recevoir et envoiyer plus d'1 octect 
//Flux de traitement
PrintWriter pw = new PrintWriter(os,true);
InputStreamReader isr = new InputStreamReader(is);
BufferedReader br = new BufferedReader(isr);
//Envoie du premier entier
System.out.println("Tapez Le premier entier");
int nb1 = scanner.nextInt();
pw.println(nb1);
//Envoie du deuxieme entier
System.out.println("Tapez le deuxieme entier");
int nb2 = scanner.nextInt();
pw.println(nb2);
//Envoie du type d'operation
String op;
do {
	System.out.println("Choix d'operation:");
	op = scanner.nextLine();
} while (!(op.equals("+")) && !(op.equals("-")) && !(op.equals("*"))&& !(op.equals("/")));
pw.println(op);
//Reçeption du résultat
String s = br.readLine();
int result = Integer.parseInt(s);
//Afficahge du résultat
System.out.println(nb1+" "+op+" "+nb2+"="+result);
**/

	}


