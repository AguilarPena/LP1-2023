public class Lazer extends Gastos {
    private boolean importante;

    Lazer (String nome, double valor, boolean importante) {
        super(nome, valor);
        this.importante = importante;
    }
    public boolean getImportante(){
        return importante;
    }
    public void setImportante(boolean importante){
        this.importante = importante;
    }
    
    public void mudarValor(double valor){
        super.mudarValor(valor * 1.05);
    }
    
    public String apresentarTudo(){
        return super.apresentarTudo() + " // Importante: " + (getImportante() ? "sim" : "não");
    }
}
