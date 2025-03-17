package boleto.avaliacao;
import java.time.LocalDate;
public class Boleto {
    private float valor;
    private LocalDate vencimento;
    private LocalDate pagamento;

    public Boleto(float valor, LocalDate vencimento, LocalDate pagamento) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do boleto deve ser maior que zero.");
        }
        if (vencimento.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("A data de vencimento deve ser posterior à data atual.");
        }
        if (pagamento != null && pagamento.isAfter(vencimento)) {
            throw new IllegalArgumentException("A data de pagamento deve ser anterior à data de vencimento.");
        }
        this.valor = valor;
        this.vencimento = vencimento;
        this.pagamento = pagamento;
    }

    public float getValor() {
        return valor;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public LocalDate getPagamento() {
        return pagamento;
    }

    public void setPagamento(LocalDate pagamento) {
        if (pagamento.isAfter(vencimento)) {
            throw new IllegalArgumentException("A data de pagamento deve ser anterior à data de vencimento.");
        }
        this.pagamento = pagamento;
    }

    @Override
    public String toString() {
        return "Boleto{" +
                "valor=" + valor +
                ", vencimento=" + vencimento +
                ", pagamento=" + (pagamento != null ? pagamento : "Não pago") +
                '}';
    }
}
