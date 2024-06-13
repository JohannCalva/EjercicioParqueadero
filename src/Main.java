import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Parqueadero par = new Parqueadero();
        int op;
        do{
            System.out.println("\nSeleccione la opcion que desea realizar");
            System.out.println("1. Ingresar un carro al parqueadero");
            System.out.println("2. Dar salida a un carro del parqueadero");
            System.out.println("3. Informar los ingresos del parqueadero");
            System.out.println("4. Consultar la cantidad de puestos disponibles");
            System.out.println("5. Avanzar reloj del parqueadero");
            System.out.println("6. Cambiar la tarifa del parqueadero");
            System.out.println("7. Carros con placa PB y Mas de 24 horas");
            System.out.println("8. Desocupar parqueadero");
            System.out.println("9. Salir");
            System.out.print("Opcion: ");
            op = Integer.parseInt(br.readLine());

            switch(op){
                case 1:
                    System.out.println("Ingresar un carro al parqueadero\n");
                    System.out.println("Ingrese la placa del carro: ");
                    String placa = br.readLine();
                    int ingreso = par.entrarCarro(placa);
                    switch(ingreso){
                        case Parqueadero.PARQUEADERO_CERRADO :
                            System.out.println("No puede ingresar, el parqueadero esta cerrado.");
                            break;
                        case Parqueadero.CARRO_YA_EXISTE:
                            System.out.println("El carro ya existe");
                            break;
                        case Parqueadero.NO_HAY_PUESTO:
                            System.out.println("No puede ingresar. No hay puestos disponibles.");
                            break;
                        default:
                            System.out.println("Bienvenido. Ingrese en el puesto: " + (ingreso + 1));
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Salida del parqueadero\n");
                    System.out.println("Ingrese la placa del carro: ");
                    String placaSale = br.readLine();
                    int salida = par.sacarCarro(placaSale);
                    switch(salida){
                        case Parqueadero.PARQUEADERO_CERRADO:
                            System.out.println("No puede salir, el parqueadero esta cerrado");
                            break;
                        case Parqueadero.CARRO_NO_EXISTE:
                            System.out.println("El carro no existe");
                            break;
                        default:
                            System.out.println("Puede salir, su valor a pagar es: " + salida);
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Informe de ingresos al parqueadero\n");
                    if(par.carrosTotal() > 0){
                        System.out.println("Hay " + par.carrosTotal() + " carro/s en el parqueadero");
                    }else{
                        System.out.println("No hay carros en el parqueadero");
                    }
                    int ingresos = par.darMontoCaja();
                    System.out.println("Ingresos del parqueadero: " + ingresos);
                    break;
                case 4:
                    System.out.println("Cantidad de puestos disponibles\n");
                    int puestosLibres = par.calcularPuestosLibres();
                    System.out.println("Hay " + puestosLibres + " puestos libres en el parqueadero");
                    break;
                case 5:
                    System.out.println("Avanzar reloj del parqueadero\n");
                    par.avanzarHora();
                    System.out.println("Hora actual: " + par.darHoraActual());


                    break;
                case 6:
                    System.out.println("Cambio de tarifa del parqueadero\n");
                    System.out.println("La tarifa actual es: " +par.darTarifa());
                    System.out.println("Ingrese la nueva tarifa: ");
                    int nuevaTarifa = Integer.parseInt(br.readLine());
                    par.cambiarTarifa(nuevaTarifa);
                    System.out.println("La nueva tarifa es: " + par.darTarifa());
                    break;
                case 7:
                    System.out.println(par.metodo1());
                    break;
                case 8:
                    System.out.println(par.metodo2());
                    break;
                case 9:
                    System.out.println("Gracias por usar");
                    break;
                default:
                    System.out.println("Esta opcion no existe. Ingrese nuevamente.\n");
                    break;
            }
        }while(op != 9);
    }
}