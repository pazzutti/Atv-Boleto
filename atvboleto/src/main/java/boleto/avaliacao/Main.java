package boleto.avaliacao;
import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        LocalDate vencimento = LocalDate.now().plusDays(10);
        LocalDate pagamento = LocalDate.now().plusDays(5);
        
        Boleto boleto = new Boleto(100.0f, vencimento, pagamento);
        System.out.println(boleto);
    }
}