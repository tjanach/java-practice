package orange.advnet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdvNetData {

    Integer nbFTE = 14;

    Map<String, Double> production = new HashMap<>();
    public void currentProduction(){
        production.put("OLN", 20.0); //percent
        production.put("OLS", 20.0); //percent
        production.put("OLR", 20.0); //percent
        production.put("GIC", 20.0); //percent
        production.put("UE", 20.0); //percent
    }

    Map<String, String> partners = new HashMap<>();
    public void setPartners(){
        partners.put("Orange", "key"); //importance: key, normal
        partners.put("Cloudify", "key"); //importance: key, normal
        partners.put("WUT", "normal"); //importance: key, normal
    }

    List<String> keyProjects = new ArrayList<>;
    public void setKeyProjects(){
        keyProjects.add("Project 1"); //project info
        keyProjects.add("Project 1"); //project info
        keyProjects.add("Project 1"); //project info
    }

    List<String> tools = new ArrayList<>;
    public void setTools(){
        tools.add("Tool 1");
        tools.add("Project 1");
        tools.add("Project 1");
    }


}
