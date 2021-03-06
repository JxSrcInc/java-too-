package jxsource.net.proxy.test.http;

import java.io.IOException;
import java.net.ServerSocket;

import jxsource.net.proxy.ControllerManager;
import jxsource.net.proxy.ControllerManagerImpl;
import jxsource.net.proxy.DefaultSocketFactory;
import jxsource.net.proxy.delegate.DefaultDelegate;
import jxsource.net.proxy.delegate.Delegate;
import jxsource.net.proxy.delegate.RequestHandler;
import jxsource.net.proxy.delegate.Context;
import jxsource.net.proxy.http.entity.ProxyHttpEntityDestinationSocketManager;

public class TestHttpServerFactory implements Context{

	public ServerSocket getServerSocket() throws IOException {
		return new DefaultSocketFactory().createServerSocket();
	}

	public Delegate getDelegate() {
		DefaultDelegate delegate = new DefaultDelegate();
		delegate.addProcessorFactory(new TestHttpProcessorFactory());
		return delegate;
	}

	public String getHost() {
		return "localhost";
	}

	public int getPort() {
		return 10090;
	}


}
