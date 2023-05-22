public class pricipalgastos {
    public static void main(String[] args) {
        Gastos lazer1 = new Lazer("cimema", 40.00, false);
        Gastos fixo1 = new Fixo("Conta de Luz", 120.00);
        Gastos variavel1 = new Variavel("carro", 22500.00, 24);

        System.out.println(lazer1.apresentarTudo());
        System.out.println(fixo1.apresentarTudo());
        System.out.println(variavel1.apresentarTudo());
    }
}
