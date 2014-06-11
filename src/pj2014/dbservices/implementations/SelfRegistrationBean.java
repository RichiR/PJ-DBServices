package pj2014.dbservices.implementations;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class SelfRegistrationBean {

	@PostConstruct
	public void init() {
		try {
			InetAddress localhost = InetAddress.getLocalHost();
			
			//TODO in Hashmap reinschreiben
			System.out.println("Hostname: "+localhost.getHostName());
			System.out.println("Hostaddress: "+localhost.getHostAddress());
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
