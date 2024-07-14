import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal implements ConversionDeMonedas{


    public static void main(String[] args) {

        String menu = """
                Sea bienvenido/a al Conversor de Monedas.
                A continuación se presentan las operaciones que puede realizar.
                1 - Convertir dólar estadounidense (USD) a peso argentino (ARS).
                2 - Convertir peso argentino (ARS) a dólar estadounidense (USD).
                3 - Convertir dólar estadounidense (USD) a real brasileño (BRL).
                4 - Convertir real brasileño (BRL) a dólar estadounidense (USD).
                5 - Convertir dólar estadounidense (USD) a peso colombiano (COP).
                6 - Convertir peso colombiano (COP) a dólar estadounidense (USD).
                7 - Salir
                Indica la operación que desea realizar:
                """;
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 7) {
            System.out.println(menu);

            try {
                opcion = teclado.nextInt();
                teclado.nextLine();

            } catch (InputMismatchException e){
                System.out.println("Error: Ingresa un número válido.");
                teclado.nextLine(); // Consumir la entrada incorrecta
                continue; // Volver al inicio del bucle
            }

            switch (opcion) {

                case 1:
                    ConversionDeMonedas.conversorDeMonedas(TipoDeMoneda.USD,TipoDeMoneda.ARS);
                    break;

                case 2:
                    ConversionDeMonedas.conversorDeMonedas(TipoDeMoneda.ARS,TipoDeMoneda.USD);
                    break;
                case 3:
                    ConversionDeMonedas.conversorDeMonedas(TipoDeMoneda.USD,TipoDeMoneda.BRL);
                    break;
                case 4:
                    ConversionDeMonedas.conversorDeMonedas(TipoDeMoneda.BRL, TipoDeMoneda.USD);
                    break;
                case 5:
                    ConversionDeMonedas.conversorDeMonedas(TipoDeMoneda.USD, TipoDeMoneda.COP);
                    break;
                case 6:
                    ConversionDeMonedas.conversorDeMonedas(TipoDeMoneda.COP,TipoDeMoneda.USD);
                    break;
                case 7:
                    System.out.println("Cerrando la aplicación. Muchas gracias por usar nuestro servicio.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
