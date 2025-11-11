package org.example;

import Views.WizardViewSwing;

public class MainSwing {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> new WizardViewSwing().setVisible(true));
    }
}
