/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabletesting.utils;

import java.awt.Component;

/**
 *
 * @author Hirantha
 */

/**
 * 1 class eka
 * karanna yanne view ekai code ekai wen karannna yana eka
 * loku app walata meka godak wadagath.invetry ehema
 * mekedi hadanne view/controller eka object ekai.ewama aye aye use karanna thama code eka liyanne.ehtakota object hadila hadila ram eka pirene ne
 * aye wasi thama code ekai view ekai wenama nisa deka wenama galawala ganna puluwan
 * mewa me jFrame class eke method tikakmai aye thiyenne
 * meka ui wala view ekakata impliment karata wenasak wenne.mokada e method thiyenawa JFrame class eka extend karan inna nisa
 * 
 * ilaga controller interface eka imliment karama eke method tika override karanna kiyanwa
 */
public interface View {
    
    void setVisible(boolean value);
    void setLocationRelativeTo(Component c);
    void dispose();
    void setExtendedState(int state);
    
}
