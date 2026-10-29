/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package casoestudio1;

import javax.swing.JOptionPane;

/**
 *
 * @author fapis
 */
public class CasoEstudio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Datos del Cliente
        String nombreCliente=JOptionPane.showInputDialog("Ingrese el nombre del cliente");
        String cedulaCliente=JOptionPane.showInputDialog("Digite el numero de cedula");
        
        //Categoria VIP o Regular 
        int opcionCategoria=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la categoria del cliente:\n1. VIP\n2. Regular")); 
        String categoria="";
        if (opcionCategoria == 1) {
            categoria = "VIP";
        } else {
            categoria = "Regular";
        }
        
        //Validacion del mes
        int mes = 0;
        do {
            mes=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes en el que se realizaron los alquileres (del 1 al 12)"));
            if (mes < 1 || mes > 12) {
                JOptionPane.showMessageDialog(null, "Error: El mes debe de ser entre 1 y 12");
            }
        } while (mes<1 || mes>12);
    
        int cantidadVehiculos = 0;
        double subtotalAcumulado = 0;
        int puntosAcumulados = 0;

        //Datos del vehiculo
        int opcionContinuar = 0;

        do {
            String placa = JOptionPane.showInputDialog("Ingrese la placa del vehiculo:");
            String marca = JOptionPane.showInputDialog("Ingrese la marca del vehiculo:");
            double precioPorDia = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio base por dia"));
            
            int dias = 0;
            do {
                dias = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de días de alquiler (mayor a 0):"));
                if (dias <= 0) {
                    JOptionPane.showMessageDialog(null, "Error: La cantidad de días debe ser mayor a 0");
                }
            } while (dias <= 0);

            int seguro = Integer.parseInt(JOptionPane.showInputDialog("¿El alquiler incluye seguro completo?\n1. Sí\n2. No"));
            int gps = Integer.parseInt(JOptionPane.showInputDialog("¿El alquiler incluye dispositivo GPS?\n1. Sí\n2. No"));

            Vehiculo miVehiculo=new Vehiculo(marca, placa, seguro, gps, dias, precioPorDia);

            double subtotalVehiculo = miVehiculo.calcularSubtotal();
            int puntosVehiculo = miVehiculo.calcularPuntos();
            
            //Acumuladores totales
            cantidadVehiculos++;
            subtotalAcumulado += subtotalVehiculo;
            puntosAcumulados += puntosVehiculo;

 
            System.out.println(">> Subtotal vehiculo " + placa + ": " + subtotalVehiculo + " | Puntos ganados: " + puntosVehiculo);
            JOptionPane.showMessageDialog(null, "Subtotal vehiculo " + placa + ": " + subtotalVehiculo + "\nPuntos ganados: " + puntosVehiculo);
        
            opcionContinuar = Integer.parseInt(JOptionPane.showInputDialog("¿Desea registrar otro vehículo?\n1. Sí\n2. No"));

        } while (opcionContinuar == 1);

        double totalFinal = subtotalAcumulado;
        int puntosTotalesFinales = puntosAcumulados;
        String mensajeVip = "";

        if (opcionCategoria == 1) {
            double descuentoVip = subtotalAcumulado * 0.05;
            totalFinal = subtotalAcumulado - descuentoVip;
            puntosTotalesFinales = puntosAcumulados * 2;
            mensajeVip = "APLICANDO BENEFICIOS VIP (5% Descuento / Puntos x2)\n";
        }

        // Resumen final
        String resumenFinal = "RESUMEN FINAL DE ALQUILERES\n" +
                "=====\n" +
                "Cliente: " + nombreCliente + "\n" +
                "Cédula: " + cedulaCliente + "\n" +
                "Categoría: " + categoria + "\n" +
                "Mes de registro: " + mes + "\n" +
                "Cantidad de vehículos procesados: " + cantidadVehiculos + "\n" +
                "Subtotal antes de descuento VIP: " + subtotalAcumulado + "\n" +
                "Puntos antes de bono VIP: " + puntosAcumulados + "\n" +
                mensajeVip +
                "TOTAL A PAGAR: " + totalFinal + "\n" +
                "PUNTOS DE LEALTAD TOTALES: " + puntosTotalesFinales;
        
        JOptionPane.showInputDialog(null, resumenFinal);
        System.out.println("casoestudio1.CasoEstudio1.main()");
               
    }
    public static String obtenerNombreMes(int mes) {
        String[] meses = {
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };
        return meses[mes - 1];
    }
        

}