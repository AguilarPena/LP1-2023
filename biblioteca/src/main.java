public class main {
    public static void main(String[] args) {

        biblioteca BIB18 = new biblioteca("Francisco Montojos", new Dono("Leticia ", 34567));

        System.out.println(BIB18.getDono().getNome() + BIB18.getDono().getCPF());

        BIB18.addfuncionarios(new funcionarios("Luciana", 92483));
        BIB18.addfuncionarios(new funcionarios("Regiane", 50168));
        BIB18.addfuncionarios(new funcionarios("Alexandre", 28641));

        BIB18.addlivros(new livros("Fúria Vermelha", "Pierce Brown", 2014));
        BIB18.addlivros(new livros("O Ladrao de Raiso", "Rick Riordan", 2008));
        BIB18.addlivros(new livros("Fahrenheit 451", "Ray Bradbury", 1953));

    }
}
