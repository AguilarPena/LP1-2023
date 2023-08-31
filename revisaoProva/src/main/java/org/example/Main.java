import entity.Aluno;
import entity.Nota;
import entity.Professor;
import entity.Turma;
import org.h2.expression.Format;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Professor prof1 = new Professor("4695","25498885","Manu","SP3090884");
        Professor prof2 = new Professor("7895","12345678","Gabi","SP3090884");
        Professor prof3 = new Professor("2830","09317651","Igor","SP3083649");

        Turma turma213 = new Turma("Gabi",12, "4652");

        Aluno a1 = new Aluno("9865","Debora","SP634841",08.0);
        Aluno a2 = new Aluno("6324","ALison","SP998510",10.0);
        Aluno a3 = new Aluno("8674","Emanue","SP983325",07.0);

        Nota nota1 = new Nota(turma213,08.0);
        Nota nota2 = new Nota(turma213,09.0);
        Nota nota3 = new Nota(turma213,10.0);
        Nota nota4 = new Nota(turma213,07.0);

        /*Turma.setAlunos(Turma.getAlunos());
        System.out.println(turma213);*/

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();
        session.persist(turma213);
        transaction.commit();

        List<Turma> turmas = session.createQuery("from: Turma", Turma.class).list();


        for(int i=0; i<turmas.size(); i++){
            System.out.println(turmas.get(i));
        }

    }
}