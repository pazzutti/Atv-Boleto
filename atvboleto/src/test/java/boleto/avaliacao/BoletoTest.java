package boleto.avaliacao;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class BoletoTest {
    @Test
    void testBoletoValido() {
        LocalDate vencimento = LocalDate.now().plusDays(10);
        LocalDate pagamento = LocalDate.now().plusDays(5);
        Boleto boleto = new Boleto(100.0f, vencimento, pagamento);
        assertEquals(100.0f, boleto.getValor());
        assertEquals(vencimento, boleto.getVencimento());
        assertEquals(pagamento, boleto.getPagamento());
    }

    @Test
    void testBoletoValorInvalido() {
        LocalDate vencimento = LocalDate.now().plusDays(10);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Boleto(-50.0f, vencimento, null));
        assertEquals("O valor do boleto deve ser maior que zero.", exception.getMessage());
    }

    @Test
    void testBoletoVencimentoInvalido() {
        LocalDate vencimento = LocalDate.now().minusDays(1);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Boleto(100.0f, vencimento, null));
        assertEquals("A data de vencimento deve ser posterior à data atual.", exception.getMessage());
    }

    @Test
    void testBoletoPagamentoInvalido() {
        LocalDate vencimento = LocalDate.now().plusDays(10);
        LocalDate pagamento = LocalDate.now().plusDays(15);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Boleto(100.0f, vencimento, pagamento));
        assertEquals("A data de pagamento deve ser anterior à data de vencimento.", exception.getMessage());
    }
}