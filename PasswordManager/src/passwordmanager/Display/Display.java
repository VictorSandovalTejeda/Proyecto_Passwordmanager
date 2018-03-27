/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager.Display;

import console.JSystem;
import java.util.Scanner;

/**
 *
 * @author jsarmiento
 */
public class Display {

    private String name;
    private String email;
    private String password;
    private String nPassword;
    private String pSeguridad;
    private String rSeguridad;
    //Instancio Scanner dentro de la funcion Display principal para uso general.
    Scanner teclado = new Scanner(System.in);

    /**
     * **** Instancio de manera general las clases usadas.*****
     */
    HeaderMain callHeaderMain = new HeaderMain();
    //Display callDisplayMetodscallHeaderMain = new Display();
    ValidarEmail callValidator = new ValidarEmail();
    //**************FIN INSTANCIA*****************//

    //Funcion de Inicio de Sesion de Usuarios.
    public void Login() {
        Display callDisplayMetods = new Display();
        int exit = 0;
        do {
            callHeaderMain.headerIniciarSesion();//llamo el menu de inicio de sesion.
            System.out.println("Ingrese Correo Electrónico:\t\t\t\t      (R) for Sign up - (S) for Exit");
            System.out.print(" ");
            email = teclado.nextLine();
            if ("R".equalsIgnoreCase(email)) {
                callDisplayMetods.registroUser();
            } else if ("S".equalsIgnoreCase(email)) {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                callHeaderMain.header();
                callHeaderMain.EndSoftware();
                System.exit(0);
            }
            callValidator.validar(email, "L");//ingreso el correo al validador.
            System.out.println("Ingrese su contraseña");
            System.out.print(" ");
            password = teclado.nextLine();
            if ("R".equalsIgnoreCase(password)) {
                callDisplayMetods.registroUser();
            } else if ("S".equalsIgnoreCase(password)) {
                System.exit(0);
            }
            //Aqui programacion para insertar el correo a la consulata de la bd.
            //CODIGO PROVICIONAL.
            String bien = "";
            System.out.println("Todo salio bien S/N");
            bien = teclado.nextLine();
            if ("S".equalsIgnoreCase(bien)) {
                //SIN CODIGO
            } else if ("N".equalsIgnoreCase(bien)) {
                //LLAMAR CLASE RECUPERAR PASSWORD  
                callDisplayMetods.RecoverPassword();

            }
        } while (exit != 1);
    }

    //Funcion Registro de Usuarios.
    public void registroUser() {
        Display callDisplayMetods = new Display();
        int exit = 0;

        do {
            JSystem.out.printColorln(JSystem.Color.cyan, "____________________________________________________________________________________________");
            JSystem.out.printColorln(JSystem.Color.blue, "\n---------------PasswordManager, Registrate a Continuacion , ¡Siempre Gratis!--------------");
            JSystem.out.printColorln(JSystem.Color.cyan, "____________________________________________________________________________________________");
            //Llamo al menu de registro.
            callHeaderMain.headerRegistro();
            callDisplayMetods.dateregistroUser();
        } while (exit != 1);
    }

    public void dateregistroUser() {
        Display callDisplayMetods = new Display();
        System.out.println("Ingresa tu nombre:\t\t\t\t\t\t              (C) for Cancel");
        System.out.print(" ");
        name = teclado.nextLine();
        System.out.println();//space line.
        callDisplayMetods.cancelar(name, null, null, null, null);
        System.out.println("Ingrese su correo:");
        System.out.print(" ");
        email = teclado.nextLine();
        System.out.println();//space line.
        callDisplayMetods.cancelar(null, email, null, null, null);
        callValidator.validar(email, "R");//mando el correo al validador para la verificacion.
        System.out.println("Ingrese su Contraseña:");
        System.out.print(" ");
        password = teclado.nextLine();
        System.out.println();//space line.
        callDisplayMetods.cancelar(null, null, password, null, null);
        System.out.println("Seleccione una pregunta de seguridad:");
        System.out.println("1) ¿Cuál es el nombre de tu primer mascota?");
        System.out.println("2) ¿Cuál es el nombre de tu abuelo?");
        System.out.println("3) ¿Últimos dígitos de tu número de teléfono?");
        System.out.print(" ");
        int opt = teclado.nextInt();
        switch (opt) {
            case 1:
                pSeguridad = "¿Cuál es el nombre de tu primer mascota?";
                break;
            case 2:
                pSeguridad = "¿Cuál es el nombre de tu abuelo?";
                break;
            case 3:
                pSeguridad = "¿últimos dígitos de tu número de teléfono?";
                break;
            default:
                break;
        }
        teclado.nextLine();
        callDisplayMetods.cancelar(null, null, null, pSeguridad, null);
        System.out.println();//space line.
        System.out.println("Ingrese la respuesta secreta:");
        System.out.print(" ");
        rSeguridad = teclado.nextLine();
        callDisplayMetods.cancelar(null, null, null, null, rSeguridad);

        //Aqui el codigo de la programacion de la consulta.
        System.out.println("Registro exitoso...");
    }

    public void cancelar(String name, String email, String password, String pSecreta, String rSecreta) {
        Display callDisplayMetods = new Display();
        if ("C".equalsIgnoreCase(name) || "C".equalsIgnoreCase(email) || "C".equalsIgnoreCase(password) || "C".equalsIgnoreCase(pSecreta) || "C".equalsIgnoreCase(rSecreta)) {
            JSystem.out.printColorln(JSystem.Color.blue, "____________________________________________________________________________________________");
            JSystem.out.printColorln(JSystem.ColorBg.red, JSystem.Color.white, "\n-----------------------------------SUSCRIPCIÓN CANCELADA------------------------------------");
            JSystem.out.printColorln(JSystem.Color.blue, "____________________________________________________________________________________________");
            callDisplayMetods.Login();
        }
    }

    public void QuestionVerificationEmail() {
        Display callDisplayMetods = new Display();
        JSystem.out.printColorln(JSystem.Color.blue, "____________________________________________________________________________________________");
        JSystem.out.printColorln(JSystem.ColorBg.red, JSystem.Color.white, "\n-------------------El email ingresado no cumple los requisitos como correo------------------");
        JSystem.out.printColorln(JSystem.ColorBg.red, JSystem.Color.white, "\t\t\t\tDeseas Registrarte Ahora-->'S/N'\t\t\t    ");
        JSystem.out.printColorln(JSystem.Color.blue, "____________________________________________________________________________________________");
        System.out.print(" ");
        String rsp = teclado.next();
        if (rsp.equalsIgnoreCase("S")) {
            teclado.nextLine();//limpiare la cache.
            callDisplayMetods.registroUser();//llamo a la pantalla registro de usuarios.    
        } else if (rsp.equalsIgnoreCase("N")) {
            teclado.nextLine();//limpiare la cache.  
            JSystem.out.printColorln(JSystem.Color.cyan, "____________________________________________________________________________________________");
            JSystem.out.printColorln(JSystem.Color.cyan, "____________________________________________________________________________________________");
            System.out.println();
            callDisplayMetods.Login();//llamo a login de usurios.
        } else {
            JSystem.out.printColorln(JSystem.Color.blue, "____________________________________________________________________________________________");
            JSystem.out.printColorln(JSystem.ColorBg.red, JSystem.Color.white, "\n------------------Ha ocurrido un error, dato introducido incorrectamente-------------------");
            JSystem.out.printColorln(JSystem.Color.blue, "____________________________________________________________________________________________");
            callDisplayMetods.Login();//llamo a login de usurios.
        }
    }

    public void QuestionVerificationEmailRegister() {
        Display callDisplayMetods = new Display();
        JSystem.out.printColorln(JSystem.Color.blue, "____________________________________________________________________________________________");
        JSystem.out.printColorln(JSystem.ColorBg.red, JSystem.Color.white, "\n-------------------El email ingresado no cumple los requisitos como correo------------------");
        JSystem.out.printColorln(JSystem.ColorBg.red, JSystem.Color.white, "\t\t\tDeseas Continuar con el registro --> 'S/N'\t\t\t    ");
        JSystem.out.printColorln(JSystem.Color.blue, "____________________________________________________________________________________________");
        System.out.print(" ");
        String rsp = teclado.next();
        if (rsp.equalsIgnoreCase("S")) {
            teclado.nextLine();//limpiare la cache.
            callDisplayMetods.dateregistroUser();
            //Contunuo con el registro. 
            callDisplayMetods.registroUser();
        } else if (rsp.equalsIgnoreCase("N")) {
            teclado.nextLine();//limpiare la cache.  
            JSystem.out.printColorln(JSystem.Color.cyan, "____________________________________________________________________________________________");
            JSystem.out.printColorln(JSystem.Color.cyan, "____________________________________________________________________________________________");
            System.out.println();
            callDisplayMetods.Login();//llamo a login de usurios.

        } else {
            JSystem.out.printColorln(JSystem.Color.blue, "____________________________________________________________________________________________");
            JSystem.out.printColorln(JSystem.ColorBg.red, JSystem.Color.white, "\n------------------Ha ocurrido un error, dato introducido incorrectamente-------------------");
            JSystem.out.printColorln(JSystem.Color.blue, "____________________________________________________________________________________________");
            callDisplayMetods.Login();//llamo a login de usuarios.
        }
    }

    public void QuestionRecoverPassword() {
        Display callDisplayMetods = new Display();
        JSystem.out.printColorln(JSystem.Color.blue, "____________________________________________________________________________________________");
        JSystem.out.printColorln(JSystem.ColorBg.red, JSystem.Color.white, "\n---------------Los datos ingresados no se encuentran en nuestra base de datos---------------");
        JSystem.out.printColorln(JSystem.Color.blue, "____________________________________________________________________________________________");
        JSystem.out.printColor(JSystem.Color.cyan, "¿TIENES PROBLEMAS PARA INGRESAR A TU CUENTA?");
        JSystem.out.printColorln(JSystem.ColorBg.yellow, JSystem.Color.red, "S/N");
        String opt = teclado.nextLine();
        if ("S".equalsIgnoreCase(opt)) {

        } else if ("N".equalsIgnoreCase(opt)) {
            callDisplayMetods.Login();//llamo a login de usuarios.  
        }
    }

    public void RecoverPassword() {
        Display callDisplayMetods = new Display();
        callHeaderMain.headerRecoverPassword();
        JSystem.out.printColorln(JSystem.Color.blue, "DEBES PROPORCIONAR LOS SIGUIENTES DATOS PARA RECUPERAR TU ACCESO.");
        JSystem.out.printColorln(JSystem.Color.cyan, "☻ Dirección de correo electrónico");
        JSystem.out.printColorln(JSystem.Color.cyan, "☻ Respuesta a la pregunta de seguridad");
        JSystem.out.printColor(JSystem.Color.blue, "CONTINUAR ");
        JSystem.out.printColorln(JSystem.ColorBg.yellow, JSystem.Color.red, "S/N");
        System.out.print(" ");
        String opt = teclado.nextLine();
        if ("S".equalsIgnoreCase(opt)) {
            callDisplayMetods.DatesRecoverPassword();
        } else if ("N".equalsIgnoreCase(opt)) {
            callDisplayMetods.Login();//llamo a login de usuarios.  
        }
    }

    public void DatesRecoverPassword() {
        System.out.println("Ingrese su Correo electrónico");
        System.out.print(" ");
        email = teclado.nextLine();
        callValidator.validar(email, "S");
        System.out.println();
        System.out.println("Ingrese la respuesta a la siguiente pregunta");
        //SACAR LA PREGUNTA DE LA BD.
        JSystem.out.printColor(JSystem.Color.blue, " ");
        System.out.println(pSeguridad);
        System.out.print(" ");
        rSeguridad = teclado.nextLine();
        /*REALIZAR LA CONSULATA A LA BD SI EXISTE LA RESPUESTA
            SI EXISTE CONTINUAR*/
        System.out.println("Ingrese su nueva contraseña");
        System.out.print(" ");
        nPassword = teclado.nextLine();
        //REALIZAR EL UPDATE DE LA NUEVA PASSWORD A LA BD.         
    }

    public void QuestionVerificationEmailRecover() {
        Display callDisplayMetods = new Display();
        JSystem.out.printColorln(JSystem.Color.blue, "____________________________________________________________________________________________");
        JSystem.out.printColorln(JSystem.ColorBg.red, JSystem.Color.white, "\n-------------------El email ingresado no cumple los requisitos como correo------------------");
        JSystem.out.printColorln(JSystem.ColorBg.red, JSystem.Color.white, "\t\t\tDeseas Continuar con la recuperacion --> 'S/N'\t\t\t    ");
        JSystem.out.printColorln(JSystem.Color.blue, "____________________________________________________________________________________________");
        System.out.print(" ");
        String rsp = teclado.next();
        if (rsp.equalsIgnoreCase("S")) {
            teclado.nextLine();//limpiare la cache.
            callDisplayMetods.DatesRecoverPassword();
        } else if (rsp.equalsIgnoreCase("N")) {
            teclado.nextLine();//limpiare la cache.
            callDisplayMetods.Login();//llamo a login de usurios.
        } else {
            JSystem.out.printColorln(JSystem.Color.blue, "____________________________________________________________________________________________");
            JSystem.out.printColorln(JSystem.ColorBg.red, JSystem.Color.white, "\n------------------Ha ocurrido un error, dato introducido incorrectamente-------------------");
            JSystem.out.printColorln(JSystem.Color.blue, "____________________________________________________________________________________________");
            callDisplayMetods.Login();//llamo a login de usuarios.
        }
    }

    public void Perfil() {
        callHeaderMain.headerPerfil();
        System.out.println("Menú de opciones");
        System.out.println("1) Ingresar Nueva Cuenta\n 2) Ver Cuentas.\t\t\t\t\t\t\t    Ingrese (S) para Salir");
        System.out.print(" ");
    }

}
