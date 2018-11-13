package com.revolhope.deepdev.myjavalibrary.network.tcp;

import java.io.IOException;
import java.net.ServerSocket;

public class TcpServer implements ITcpServer
{
	private ServerSocket server;
	private boolean isRunning;
	private Thread threadSocket;

	public TcpServer(final int port) throws IOException
	{
		this.server = new ServerSocket(port);
		this.isRunning = false;
	}

	public void listenOnMainThread()
	{
		listen();
		isRunning = false;
	}

	public void listenNewThread()
	{
		threadSocket = new Thread(new Runnable() 
		{
			@Override
			public void run()
			{
				listen();
			}
		});
		threadSocket.start();
		isRunning = true;
	}

	public boolean isRunning()
	{
		return this.isRunning;
	}

	private void listen() {}

	public void close()
	{
		if (isRunning && threadSocket != null)
		{
			threadSocket.interrupt();
			isRunning = false;
		}
	}

}
