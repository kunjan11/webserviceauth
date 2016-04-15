package org.opensource.company.test;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import org.jboss.ejb3.annotation.SecurityDomain;
import org.jboss.ws.api.annotation.WebContext;


@WebService
@WebContext(authMethod="BASIC", transportGuarantee="NONE")
@SecurityDomain("test-security-domain")
@RolesAllowed("JBossAdmin")
@Stateless
public class Webservice {

	public Webservice() {
		// TODO Auto-generated constructor stub
		
	}
	
	@WebMethod
	public String callMeWithBasicAuth(final String text){
		return "talk back: " + text;
	}

}
