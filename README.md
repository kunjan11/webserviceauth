# webserviceauth : for test purpose only
This project is the combination of EJB/Webservice Security.
Made use of EJB 3.1 Lite.

The webserviceauth/configuration file have standalone.xml from EAP 6.4 with user property and role property file.

The configuration is as follows:-
*********************************
                <security-domain name="test-security-domain" cache-type="default">
                    <authentication>
                        <login-module code="org.jboss.security.auth.spi.UsersRolesLoginModule" flag="sufficient">
                            <module-option name="usersProperties" value="${jboss.server.config.dir}/test-users.properties"/>
                            <module-option name="rolesProperties" value="${jboss.server.config.dir}/test-roles.properties"/>
                            <module-option name="password-stacking" value="useFirstPass"/>
                        </login-module>
                    </authentication>
                </security-domain>
*********************************

The User properties file has the following:-
********************************************
test-users.properties:

jboss=äöüäöü
********************************************
NOTE: password can be anything else, the above is just for example purpose.

The Role Properties file has the following:-
********************************************
test-roles.properties:-

jboss=JBossAdmin
********************************************
NOTE: JBossAdmin is the role assigned to the user JBoss.

The Security in application:-
*****************************
In jboss-ejb3.xml:-
-------------------
  <assembly-descriptor>
    <s:security>
      <ejb-name>*</ejb-name>
      <s:security-domain>test-security-domain</s:security-domain>
    </s:security>
    ...
-------------------

in EJB itself:-
------------------------------
import org.jboss.ejb3.annotation.SecurityDomain;
import javax.annotation.security.RolesAllowed;

@SecurityDomain("test-security-domain")
@RolesAllowed("JBossAdmin")
------------------------------

in jboss-web.xml:-
------------------
<security-domain>test-security-domain</security-domain>
------------------

*****************************
