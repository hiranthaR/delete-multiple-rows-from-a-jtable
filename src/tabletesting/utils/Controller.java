/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabletesting.utils;

/**
 *
 * @author Hirantha
 */

//2 class
public interface Controller {
      void initializeView();
    void updateView();
    void clearView();
    View getView();
}
