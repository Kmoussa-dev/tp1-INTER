import jakarta.xml.ws.Service;
import services.Facade;
import services.FacadeImplService;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Provider;

public class main {

    public static void main(String[] args) {
        FacadeImplService service = new FacadeImplService();
        Facade proxy = service.getFacadePort();
        System.out.println("liste : "+proxy.getAllNom());

        try {
            URL url = new URL("http://localhost:9191/annuaire?wsdl");
            FacadeImplService serviceWithUrl =
                    new FacadeImplService(url, new QName("http://service/","FacadeService"));
            Facade servicePortWithUrl = serviceWithUrl.getFacadePort();
            System.out.println(servicePortWithUrl.getAllNom());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
