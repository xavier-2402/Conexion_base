package Controlador;

import Modelo.Auto;
import Vista.VistaFormulario;
import Vista.VistaLista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaController implements ActionListener {
    private VistaLista lista;

    public ListaController(VistaLista lista) {
        this.lista = lista;
        this.lista.setVisible(true);
        this.lista.setResizable(true);
        this.lista.setLocationRelativeTo(null);
        this.lista.getBtn_atras().addActionListener(this);
        Auto auto = new Auto();
        auto.ListarAutos(lista, auto);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.lista.getBtn_atras()){
            VistaFormulario formulario = new VistaFormulario();
            FormularioController controladorformulario = new FormularioController(formulario);
            this.lista.dispose();
        }
         }
    
    
    
    
}
