package lab11.Ex1_Observer;

public class Main {
    public static void main(String[] args) {
        Produto p1 = new Produto("House on a beach", 300000, 5000);
        Produto p2 = new Produto("iPhone 11", 700, 5000);
        Produto p3 = new Produto("Fiat 500", 14000, 5000);

        Cliente cl1 = new Cliente("Maria Rua");
        Cliente cl2 = new Cliente("Daniel Figueiredo");
        Cliente cl3 = new Cliente("Ines Freitas");

        Gestor g = new Gestor("André Moniz");

        g.notify(p1);
        g.notify(p2);
        g.notify(p3);

        System.out.println("---------------------ATTENTION! The Auction will begin---------------------");

        g.atualizarEnum(p1, enum_produtos.leilao);
        g.atualizarEnum(p2, enum_produtos.leilao);
        g.atualizarEnum(p3, enum_produtos.leilao);

        cl1.notify(p1);
        cl1.notify(p2);
        cl1.notify(p3);

        cl2.notify(p1);
        cl2.notify(p2);
        cl2.notify(p3);

        cl3.notify(p1);
        cl3.notify(p2);
        cl3.notify(p3);

        System.out.println("-----------------------------------------------------------------------------");

        cl1.licitacao(p1, 200000); // Won't work
        cl2.licitacao(p2, 800); // Will work
        cl3.licitacao(p3, 80000); // Will work

        // Wait for some time before selling the products
        try {
            Thread.sleep(6000); // Wait for 6 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Now update the state of the products to 'vendas'
        g.atualizarEnum(p1, enum_produtos.vendido);
        g.atualizarEnum(p2, enum_produtos.vendido);
        g.atualizarEnum(p3, enum_produtos.vendido);

        System.out.println();

        cl1.licitacao(p1, 300100);
        cl2.licitacao(p1, 310000);

        // Wait for some time before selling the product
        try {
            Thread.sleep(6000); // Wait for 6 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Now update the state of the product to 'vendas'
        g.atualizarEnum(p1, enum_produtos.vendido);
    }
}
