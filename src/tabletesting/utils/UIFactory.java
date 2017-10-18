/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabletesting.utils;

import java.util.HashMap;
import java.util.Map;
import tabletesting.controllers.LoginController;
import tabletesting.controllers.MyTableController;

/**
 *
 * @author Hirantha
 */


//3rd class
public class UIFactory {
    
    //2
    private static final Map<UIName,Controller> factory = new HashMap<>();
    
    
    //3 
    public static final Controller getController(UIName name){
        
        Controller controller = factory.get(name);
        //methanin ehata yanna nm ui ekak hadala(class eka withrai one) View ekata implient kaarala
        //Controlelers hadala ewa contllrer ekata impliment karala thiyenna one
        
        if (controller == null){
            
            switch (name){
                
                case LOGIN:
                    controller = new LoginController();
                    break;
                
                case TABLE:
                    controller = new MyTableController();
                    break;
            }
            factory.put(name, controller); //store object
            controller.initializeView(); //initialing components
        }
        return controller;
    }
    
    //4
    public static final void showUI(UIName name){
        Controller c = getController(name);
        c.updateView(); //ui eka hide karala aye pennaddi wade thiyana data upate/clear karanna wage use karaki
        View view = c.getView();
        view.setLocationRelativeTo(null); //get center on dsiplay
        view.setVisible(true);
    }
    
    //5
    public static final void hideUI(UIName name){
        Controller c  = getController(name);
        c.getView().dispose();
    }
    
    //done
    
    //1
    public enum UIName {
        LOGIN,
        TABLE;
    }
}
