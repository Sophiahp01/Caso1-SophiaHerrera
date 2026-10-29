/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package casoestudio1;

/**
 *
 * @author fapis
 */
public class Vehiculo {
    private String marca;
    private String placa;
    private int SeguroCompleto;
    private int GPS;
    private int dias;
    private double PrecioPorDia;
    
    public Vehiculo(){  
    } 

    public Vehiculo(String marca, String placa, int SeguroCompleto, int GPS, int dias, double PrecioPorDia) {
        this.marca = marca;
        this.placa = placa;
        this.SeguroCompleto = SeguroCompleto;
        this.GPS = GPS;
        this.dias = dias;
        this.PrecioPorDia = PrecioPorDia;
    }
    // Setters and Getters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getSeguroCompleto() {
        return SeguroCompleto;
    }

    public void setSeguroCompleto(int SeguroCompleto) {
        this.SeguroCompleto = SeguroCompleto;
    }

    public int getGPS() {
        return GPS;
    }

    public void setGPS(int GPS) {
        this.GPS = GPS;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public double getPrecioPorDia() {
        return PrecioPorDia;
    }

    public void setPrecioPorDia(double PrecioPorDia) {
        this.PrecioPorDia = PrecioPorDia;
    }
    
    public double calcularSubtotal() {
        double costoBase = this.PrecioPorDia*this.dias;
        
        // Si se alquila por más de 7 días, 15% descuento en el costo Base
        if (this.dias > 7) {
            costoBase = costoBase*0.85;
        }
        
        // Recargos diarios
        double recargoSeguro = 0;
        if (this.SeguroCompleto == 1) {
            recargoSeguro = 5000*this.dias;
        }
        
        double recargoGps = 0;
        if (this.GPS == 1) {
            recargoGps = 2000*this.dias;
        }
        
        return costoBase + recargoSeguro + recargoGps;
    }

    // Calcular puntos ganados
    public int calcularPuntos() {
        int puntos = 0;
        
        if (this.dias > 7) {
            puntos += 5;
        }
     
        if (this.SeguroCompleto == 1) {
            puntos += 2;
        }
        
        return puntos;
    }
}
