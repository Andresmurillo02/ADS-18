package com.mycompany.nequi;

import java.util.Locale;

import java.util.Random;

import javax.swing.JOptionPane;

public class Ahorro {

    private int saldo = 7000000, saldoC = 20000000, retiroD = 2100000;
    private boolean continuar = true;

    public Ahorro() {
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldoC() {
        return saldoC;
    }

    public void setSaldoC(int saldoC) {
        this.saldoC = saldoC;
    }

    public int getRetiroD() {
        return retiroD;
    }

    public void setRetiroD(int retiroD) {
        this.retiroD = retiroD;

    }

    public void cajero() {
        while (continuar) {
            try {
                StringBuilder menu = new StringBuilder("MENU CAJERO AUTOMATICO \n\n ");
                menu.append("seleccione una opcion del 1 al 4 asi: \n")
                        .append("1.Consultar saldo \n")
                        .append("2.Consignar dinero \n")
                        .append("3.Retirar dinero \n")
                        .append("4.Salir");
                String opcion = JOptionPane.showInputDialog(null, menu,
                        "CAJERO AUTOMATICO", JOptionPane.QUESTION_MESSAGE);
                if (opcion == null) {
                    if (confirmarSalida()) {
                        continuar = false;
                    }
                    continue;
                }
                int opc = Integer.parseInt(opcion);
                switch (opc) {
                    case 1:
                        consultarSaldo();

                        break;

                    case 2:
                        ConsignarDinero();
                        break;

                    default:
                        throw new AssertionError();
                }

            } catch (NumberFormatException e) {

                JOptionPane.showInputDialog("ERROR:debe ingresar numeros del 1 del 4:");
            }
        }

    }

    public boolean confirmarSalida() {
        int confirmar = JOptionPane.showConfirmDialog(null, "¿Deseas Salir?",
                "CONFIRMAR SALIDA", JOptionPane.YES_NO_OPTION);
        return confirmar == JOptionPane.YES_OPTION;
    }

    public String idValidacion() {
        Random random = new Random();
        int numero = random.nextInt(9000) + 1000;
        return "ID de la operacion #" + numero + "\n";

    }

    public void consultarSaldo() {
        String validacion = idValidacion();
        StringBuilder mensaje = new StringBuilder("CONSULTAR SALDO \n");
        mensaje.append(validacion)
                .append("Su saldo es: $")
                .append(String.format("%,d", saldo));
        JOptionPane.showMessageDialog(null, mensaje, "Consultar saldo", JOptionPane.INFORMATION_MESSAGE);

    }

    public void ConsignarDinero() {
        try {
            JOptionPane.showInternalMessageDialog(null, "POR FAVOR NO INGRESE MONEDAS", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            String consg = JOptionPane.showInputDialog(null, "Consignar dinero", JOptionPane.DEFAULT_OPTION);
            if (consg == null) {
                return;
            }
            int valor = Integer.parseInt(consg);
            if (valor %10000 == 0) {
                saldo += valor;
                JOptionPane.showMessageDialog(null, "CONSIGNACION EXITOSA\n SU NUEVO SALDO ES" +saldo);
            }
            else{
            JOptionPane.showInternalMessageDialog(null, "MONTO INVALIDO", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "SOLO SE PUEDEN INGRESAR VALORES NUMERICOS \n", "ADVERTENCIA \n", JOptionPane.WARNING_MESSAGE);
        }

    }

}
