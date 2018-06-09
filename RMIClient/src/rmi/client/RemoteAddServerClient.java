package rmi.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import rmi.remote.RemoteAddInterface;

public class RemoteAddServerClient {
	
	public static void main(String args[])
	{
		
		String url="rmi://localhost:8080/RemoteAddServer";
		try{
			
			RemoteAddInterface impl=(RemoteAddInterface)Naming.lookup(url);
			
			System.out.println("Sum : "+impl.add(1, 2));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
