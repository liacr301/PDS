package TP5;
import java.util.ArrayList;
import java.util.Scanner;

class circle{
    double raio;
        public double getRaio() {
            return raio;
        }
        public double setRaio(double raio){
            if (raio > 0){
                this.raio = raio;
            }
            return raio;
        }
        public String toString(){
            return "Raio: " + raio;
        }
        public boolean equals(Object obj){
            if (obj instanceof circle){
                circle c = (circle) obj;
                return this.raio == c.raio;
            }
            return false;
        }  
        public double getArea(){
            return Math.PI * Math.pow(raio, 2);
        }
        public double getPerimetro(){
            return 2 * Math.PI * raio;
        }
}



class triangle{
    double lado1;
    double lado2;
    double lado3;
    int lado;
    double newValor;
    
        public double getLado(int lado){
            switch (lado){
                case 1:
                    return lado1;
                case 2:
                    return lado2;
                case 3:
                    return lado3;
                default:
                    return 0;
            }
        }
        public double setLados(int lado, double newValor){
            assert lado1 + lado2 > lado3 && lado1 + lado3 > lado2 && lado2 + lado3 > lado1 : "Os lados não satisfazem a desigualdade triangular";
            switch (lado){
                case 1:
                    if (newValor > 0){
                        this.lado1 = newValor;
                    }
                    return lado1;
                case 2:
                    if (newValor > 0){
                        this.lado2= newValor;
                    }
                    return lado2;
                case 3:
                    if (newValor > 0){
                        this.lado3 = newValor;
                    }
                    return lado3;
                default:
                    return 0;
            }
        }
        public String toString(){
            return "Lado 1: " + lado1 + ";" + " Lado 2: " + lado2 + ";" + " Lado 3: " + lado3;
        }
        public boolean equals(Object obj){
            if (obj instanceof triangle){
                triangle t = (triangle) obj;
                return this.lado1 == t.lado1 && this.lado2 == t.lado2 && this.lado3 == t.lado3;
            }
            return false;
        }
        public double getPerimetro(){
            return lado1 + lado2 + lado3;
        }
        public double getArea(){
            double p = getPerimetro() / 2;
            return Math.sqrt(p * (p - lado1) * (p - lado2) * (p - lado3));
        }
    
}



class rect{
    double comp;
    double altura; 
        public double getComp() {
            return comp;
        }
        public double setComp(double comp){
            if (comp > 0){
                this.comp = comp;
            }
            return comp;
        }
        public double getAltura() {
            return altura;
        }
        public double setAltura(double altura){
            if (altura > 0){
                this.altura = altura;
            }
            return altura;
        }
        public String toString(){
            return "Comprimento: " + comp +  ";" + " Altura: " + altura;
        }
        public boolean equals(Object obj){
            if (obj instanceof rect){
                rect r = (rect) obj;
                return this.comp == r.comp && this.altura == r.altura;
            }
            return false;
        }
        public double getArea(){
            return comp * altura;
        }
        public double getPerimetro(){
            return 2 * (comp + altura);
        }



}
public class ex01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Object> formas = new ArrayList<>(); 
        int option;

        do {

            System.out.println("MENU DE ESCOLHAS");
            System.out.println("1. Criar círculo");
            System.out.println("2. Criar triângulo");
            System.out.println("3. Criar retângulo");
            System.out.println("4. Listagem de formas criadas");
            System.out.println("0. EXIT");
            option = sc.nextInt();

            switch (option) {

                case 1:

                    System.out.println("Digite o raio: ");
                    double raio = sc.nextDouble();
                    circle c = new circle();
                    c.setRaio(raio);
                    formas.add(c);
                    break;

                case 2:

                    System.out.println("Digite o lado 1: ");
                    double lado1 = sc.nextDouble();
                    System.out.println("Digite o lado 2: ");
                    double lado2 = sc.nextDouble();
                    System.out.println("Digite o lado 3: ");
                    double lado3 = sc.nextDouble();
                    triangle t = new triangle();
                    t.setLados(1, lado1); 
                    t.setLados(2, lado2);
                    t.setLados(3, lado3);
                    formas.add(t);
                    break;

                case 3:

                    System.out.println("Digite o comprimento: ");
                    double comp = sc.nextDouble();
                    System.out.println("Digite a altura: ");
                    double altura = sc.nextDouble();
                    rect r = new rect();
                    r.setComp(comp);
                    r.setAltura(altura); 
                    formas.add(r);
                    break;      

                case 4:

                    System.out.println("LISTAGEM DAS FORMAS CRIADAS:");

                    for (Object forma : formas) {

                        if (forma instanceof circle) { 
                            circle c1 = (circle) forma;
                            System.out.println("Círculo - " + c1.toString() + " - Área: " + c1.getArea() + " - Perímetro: " + c1.getPerimetro());

                        } else if (forma instanceof triangle) { 
                            triangle t1 = (triangle) forma;
                            System.out.println("Triângulo - " + t1.toString() + " - Área: " + t1.getArea() + " - Perímetro: " + t1.getPerimetro());

                        } else if (forma instanceof rect) { 
                            rect r1 = (rect) forma;
                            System.out.println("Retângulo - " + r1.toString() + " - Área: " + r1.getArea() + " - Perímetro: " + r1.getPerimetro());
                        }
                    }


                case 0:
                    System.out.println("Adeus!");
                    break;
            
                default:
                    System.out.println("Opção inválida, tente novamente!");;
            }


        } while (option != 0);
        sc.close();
    }
}
