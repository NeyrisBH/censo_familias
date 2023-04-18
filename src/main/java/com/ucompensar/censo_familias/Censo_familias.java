package com.ucompensar.censo_familias;
import java.util.Scanner;

/**
 * @author Neyris
 */
public class Censo_familias {
    
     public static void main(String[] args) {
        Censo_familias censo = new Censo_familias();
        censo.Censo();
     }

    public void Censo() {

        int cantidadFamilias;
        double totalAgua = 0, totalLuz = 0, totalGas = 0;

        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de familias: ");
        cantidadFamilias = input.nextInt();

        Info_Familia[] infoFamilia =  new Info_Familia[cantidadFamilias];

        for (int i = 0; i < cantidadFamilias; i++) {
            System.out.println("Ingrese los datos de la familia # " + (i + 1));
            int idFamilia = (i + 1);
            System.out.println("Ingrese el estrato de la familia # " + (i + 1));
            int estrato = input.nextInt();
            System.out.println("Ingrese el valor de Agua de la familia # " + (i + 1));
            double valorAgua = input.nextDouble();
            System.out.println("Ingrese el valor de Luz de la familia # " + (i + 1));
            double valorLuz = input.nextDouble();
            System.out.println("Ingrese el valor de Gas de la familia # " + (i + 1));
            double valorGas = input.nextDouble();
            
            infoFamilia[i] = new Info_Familia(idFamilia, valorAgua, valorLuz, valorGas, estrato);
        }
        
        for (int i = 0; i < cantidadFamilias; i++) {
            totalAgua += infoFamilia[i].calcularSubsidioAgua();
            totalLuz += infoFamilia[i].calcularSubsidioLuz();
            totalGas += infoFamilia[i].calcularSubsidioGas();
        }
        
        // Mostrar el total a pagar por cada servicio público
        System.out.println("Total a pagar por servicio público:");
        System.out.println("- Agua: $" + totalAgua);
        System.out.println("- Luz: $" + totalLuz);
        System.out.println("- Gas: $" + totalGas);

        input.close();
    }


    class Info_Familia {

        private int idFamilia;
        private double valorAgua, valorLuz, valorGas;
        private double valorAguaDescuento, valorLuzDescuento, valorGasDescuento;
        private double descuento;
        private int estrato;

        public Info_Familia(int idFamilia, double valorAgua, double valorLuz, double valorGas, int estrato) {
            this.idFamilia = idFamilia;
            this.valorAgua = valorAgua;
            this.valorLuz = valorLuz;
            this.valorGas = valorGas;
            this.estrato = estrato;
        }

        public int getIdFamilia() {
            return idFamilia;
        }

        public void setIdFamilia(int idFamilia) {
            this.idFamilia = idFamilia;
        }

        public double getValorAgua() {
            return valorAgua;
        }

        public void setValorAgua(double valorAgua) {
            this.valorAgua = valorAgua;
        }

        public double getValorLuz() {
            return valorLuz;
        }

        public void setValorLuz(double valorLuz) {
            this.valorLuz = valorLuz;
        }

        public double getValorGas() {
            return valorGas;
        }

        public void setValorGas(double valorGas) {
            this.valorGas = valorGas;
        }

        public double getValorAguaDescuento() {
            return valorAguaDescuento;
        }

        public void setValorAguaDescuento(double valorAguaDescuento) {
            this.valorAguaDescuento = valorAguaDescuento;
        }

        public double getValorLuzDescuento() {
            return valorLuzDescuento;
        }

        public void setValorLuzDescuento(double valorLuzDescuento) {
            this.valorLuzDescuento = valorLuzDescuento;
        }

        public double getValorGasDescuento() {
            return valorGasDescuento;
        }

        public void setValorGasDescuento(double valorGasDescuento) {
            this.valorGasDescuento = valorGasDescuento;
        }

        public double getDescuento() {
            return descuento;
        }

        public void setDescuento(double descuento) {
            this.descuento = descuento;
        }

        public int getEstrato() {
            return estrato;
        }

        public void setEstrato(int estrato) {
            this.estrato = estrato;
        }
        
        
        public double calcularSubsidioAgua() {
            switch (estrato) {
                case 1:
                    descuento = 0.2;
                    break;
                case 2:
                    descuento = 0.15;
                    break; 
                default:
                    descuento = 0.09;
                    break;
            }
            valorAguaDescuento = valorAgua * (1 - descuento);
            return valorAguaDescuento;
        }
        
        public double calcularSubsidioLuz() {
            switch (estrato) {
                case 1:
                    descuento = 0.2;
                    break;
                case 2:
                    descuento = 0.15;
                    break; 
                default:
                    descuento = 0.09;
                    break;
            }
            valorLuzDescuento = valorLuz * (1 - descuento);
            return valorLuzDescuento;
        }
        
        public double calcularSubsidioGas() {
            switch (estrato) {
                case 1:
                    descuento = 0.2;
                    break;
                case 2:
                    descuento = 0.15;
                    break; 
                default:
                    descuento = 0.09;
                    break;
            }
            valorGasDescuento = valorGas * (1 - descuento);
            return valorGasDescuento;
        }
    }
}
