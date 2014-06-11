package pj2014.dbservices.factories;




import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;


import pj2014.dbservices.interfaces.DocumentDBServiceRemote;


public class UserDBServiceProxyFactory {
	public static DocumentDBServiceRemote getProxy(String baseUrl) {
		
		RegisterBuiltin.register(ResteasyProviderFactory.getInstance());
		return ProxyFactory.create(DocumentDBServiceRemote.class, baseUrl);						
		
	}
}
