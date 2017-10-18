/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabletesting.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import tabletesting.uis.LoginView;
import tabletesting.utils.Controller;
import tabletesting.utils.UIFactory;
import tabletesting.utils.View;

/**
 *
 * @author Hirnatha
 */
public class LoginController implements Controller{
    
    private LoginView view = new LoginView();

    @Override
    public void initializeView() {
        
        view.getBtnLogin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(view.getTxtUserName().getText().toString().equalsIgnoreCase("nipuna")&&view.getTxtPassword().getText().toString().equals("nipuna123")){
                    UIFactory.hideUI(UIFactory.UIName.LOGIN);
                    UIFactory.showUI(UIFactory.UIName.TABLE);
                } else {
                    JOptionPane.showMessageDialog(view, "username or password incorrect","error",1);
                    view.getTxtUserName().setText("");
                    view.getTxtPassword().setText("");
                }
            }
        });
        
        view.getTxtUserName().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_ENTER){
                    view.getBtnLogin().doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        view.getTxtPassword().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_ENTER){
                    view.getBtnLogin().doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

  

    @Override
    public void clearView() {
    }

    @Override
    public View getView() {
        return view;
    }

    @Override
    public void updateView() {
    }
    
}
