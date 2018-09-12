package rexmport;

import org.apache.xmlrpc.*;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfig;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.URL;
import java.util.Vector;

public class RexXMLRPCClient {

    public static void main (String [] args) {

        try {
            XmlRpcClientConfig clientConfig = new XmlRpcClientConfigImpl();
            ((XmlRpcClientConfigImpl) clientConfig).setServerURL(new URL(""));
            XmlRpcClient client = new XmlRpcClient();
            client.setConfig(clientConfig);
            client.execute();

            Vector params = new Vector();

            params.addElement(new Integer(17));
            params.addElement(new Integer(13));

            Object result = client.execute("sample.sum", params);

            int sum = ((Integer) result).intValue();
            System.out.println("The sum is: "+ sum);

        } catch (Exception exception) {
            System.err.println("JavaClient: " + exception);
        }
    }

}
