package rmi.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteAddInterfaceImpl extends UnicastRemoteObject implements RemoteAddInterface{

	/**
	 * 
	 */
	private static final long serialVersionUID = 12345678L;

	public RemoteAddInterfaceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int add(int a, int b) throws RemoteException {
		// TODO Auto-generated method stub
		return a+b;
	}

}
