package rmi.remote;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RemoteAddServer {
	
	public static void main(String args[]) throws RemoteException, MalformedURLException
	{
		Registry reg=LocateRegistry.getRegistry("localhost",8080);
		RemoteAddInterfaceImpl impl=new RemoteAddInterfaceImpl();
		Naming.rebind("RemoteAddServer", impl);
	}
	

}
