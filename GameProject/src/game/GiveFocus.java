/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author kimbe
 */
public class GiveFocus extends MouseAdapter {

    private Component target;

    /**
     * gives focus to the keyboard
     */
    public GiveFocus(Component target) {
        this.target = target;
    }

    /**
     * gives focus to the mouse
     */
    public void mouseEntered(MouseEvent e) {
        target.requestFocus();
    }
}
