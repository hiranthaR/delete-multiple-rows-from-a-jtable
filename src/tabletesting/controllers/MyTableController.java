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
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tabletesting.database.UserSQL;
import tabletesting.entities.User;
import tabletesting.uis.MyTableView;
import tabletesting.utils.Controller;
import tabletesting.utils.View;

/**
 *
 * @author Hirantha
 */
//you have to impliment some methods here as we define before
//in case of View,they are already exists
public class MyTableController implements Controller {

    private MyTableView view = new MyTableView();
    DefaultTableModel dtm;

    @Override
    public void initializeView() {

        dtm = (DefaultTableModel) view.getTblUsers().getModel();

        //prevent text and more than 10 characters
        view.getTxtNumber().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume();
                }

                if (view.getTxtNumber().getText().length() > 9) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        view.getBtnInsert().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = view.getTxtName().getText().toString();
                String address = view.getTxtAddress().getText().toString();
                String number = view.getTxtNumber().getText().toString();

                if (!name.equals("") && !address.equals("") && !(number.length() < 10)) {
                    User user = new User(0, name, address, number);
                    UserSQL.insertUser(user);

                    view.getTxtName().setText("");
                    view.getTxtNumber().setText("");
                    view.getTxtAddress().setText("");

                    updateView();
                } else {
                    JOptionPane.showMessageDialog(view, "Some fields missing");
                }
            }
        });

        view.getBtnDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (view.getTblUsers().getSelectedRowCount() != 0) {

                    int[] rows = view.getTblUsers().getSelectedRows();

                    int del = 1;

                    for (int i = 0; i < rows.length; i++) {
                        int id = (int) dtm.getValueAt(rows[i], 0);
                        UserSQL.deleteRow(id);
                        dtm.removeRow(rows[i]);

                        try {
                            rows[i + 1] = rows[i + 1] - del;
                        } catch (ArrayIndexOutOfBoundsException ex) {
                            break;
                        }
                        del++;
                    }

                } else {
                    JOptionPane.showMessageDialog(view, "Nothing Selected!");
                }

            }
        }
        );
        
        view.getTxtName().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getBtnInsert().doClick();
            }
        });
        
        view.getTxtAddress().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getBtnInsert().doClick();
            }
        });
        
        view.getTxtNumber().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getBtnInsert().doClick();
            }
        });

    }

    @Override
    public void updateView() {

        List<User> users = UserSQL.getAllUsers();

        dtm.setRowCount(0);

        for (User user : users) {
            dtm.addRow(new Object[]{user.getId(), user.getName(), user.getAddress(), user.getNumber()});
        }

    }

    @Override
    public void clearView() {
    }

    @Override
    public View getView() {
        return view;
    }

}
