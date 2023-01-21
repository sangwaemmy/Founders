/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeguru.controller;

import java.net.URI;

/**
 *
 * @author SANGWA
 */
public class OpenBrowser {

    public static void main(String[] args) {
        try {
            URI uri = new URI("http://localhost:8282/api/v1/TestTomcat/Greet");
            java.awt.Desktop.getDesktop().browse(uri);
            System.out.println("Web page opened in browser");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
