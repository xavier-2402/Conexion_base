package Controlador;

import Modelo.Auto;
import Vista.VistaFormulario;
import Vista.VistaLista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioController  implements ActionListener{
     
    private VistaFormulario formulario;

    public FormularioController(VistaFormulario formulario) {
        this.formulario = formulario;
        this.formulario.setVisible(true);
        this.formulario.setResizable(true);
        this.formulario.setLocationRelativeTo(null);
        this.formulario.getBtn_listar().addActionListener(this);
        this.formulario.getBtn_guardar().addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Auto auto = new Auto();
        if(e.getSource()==this.formulario.getBtn_listar()){
            VistaLista lista = new VistaLista();
            ListaController controladorlista = new ListaController(lista);
            this.formulario.dispose();
        }
        if(e.getSource()==this.formulario.getBtn_guardar()){
            auto.cargarDatos(auto, formulario);
            auto.GuardarAuto(auto);
        }
      }

   
    
    
}
