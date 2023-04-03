/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.GUI;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 *
 * @author asus
 */

public class DataValidator {
    public static void validateTextEmpty(JTextField field, StringBuilder sb, String errorMessage){
      if (field.getText().equals("")){
          sb.append(errorMessage).append("\n");
          field.setBackground(new Color(226,110,110));
          field.requestFocus();
      }else{
          field.setBackground(Color.white);
      }
    }
//    public static void validatePassmpty(JPasswordField field, StringBuilder sb,String errorMessage){
//        String password = new String(field.getPassword());
//        if (password.equals("")){
//          sb.append(errorMessage).append("\n");
//          field.setBackground(new Color(226,110,110));
//          field.requestFocus();
//      }else{
//          field.setBackground(Color.white);
//      }
//    }

}
