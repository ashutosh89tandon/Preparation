package rmi.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteAddInterface extends Remote{
	
	public int add(int a , int b)throws RemoteException;

}
