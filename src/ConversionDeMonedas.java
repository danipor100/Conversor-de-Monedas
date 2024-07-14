import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public interface ConversionDeMonedas {

    public static void conversorDeMonedas(TipoDeMoneda monedaInicial, TipoDeMoneda monedaFinal) {
        System.out.println("Indique la cantidad de dinero que desea convertir:");
try {
    Scanner teclado = new Scanner(System.in);
    BigDecimal importe = teclado.nextBigDecimal();
    teclado.nextLine();

    ConsumoApi conversion = new ConsumoApi();
    Moneda moneda = conversion.convertirMoneda(monedaInicial, monedaFinal, importe);
    System.out.println("La cantidad de " + importe + " " + monedaInicial.toString() + " corresponde a " + moneda.conversion_result() + " " + monedaFinal.toString());
    } catch (InputMismatchException e){
    System.out.println("Debes ingresar el número que corresponde a la cantidad de dinero que deseas convertir.");
    }

    }
}
