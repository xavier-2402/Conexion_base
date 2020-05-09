package Main;

import Controlador.FormularioController;
import Vista.VistaFormulario;

/**
 *
 * @author Xavier Yanza
 */
public class Main {
    
    public static void main(String[]args){
        
        VistaFormulario formulario = new VistaFormulario();
        FormularioController controladorformulario = new FormularioController(formulario);
    }
}
