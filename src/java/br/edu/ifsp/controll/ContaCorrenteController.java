/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.controll;

import br.edu.ifsp.model.ContaCorrente;
import br.edu.ifsp.util.Relatorio;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author aluno
 */
@Named
@SessionScoped
public class ContaCorrenteController implements Serializable{
    
    
    
    public StreamedContent gerarRelatorioContaCorrente(){
    
        // Obter a lista de contas correntes
        List<ContaCorrente> lista = obterContaCorrente();
        
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lista);
        
        InputStream is = getClass().getResourceAsStream("/br/edu/ifsp/relatorio/relatorio-contas.jasper");
        
        
        return Relatorio.gerar(is, null, dataSource);
        
    }

    private List<ContaCorrente> obterContaCorrente() {
        List<ContaCorrente> contasCorrentes = new ArrayList<>();
        
        contasCorrentes.add(new ContaCorrente(1, 1000.0));
        contasCorrentes.add(new ContaCorrente(2, 666.0));
        contasCorrentes.add(new ContaCorrente(3, 874567.0));
        contasCorrentes.add(new ContaCorrente(4, 0.0));
        contasCorrentes.add(new ContaCorrente(5, 6522.0));
        contasCorrentes.add(new ContaCorrente(6, 3500.0));
        contasCorrentes.add(new ContaCorrente(7, 120.27));
        
        return contasCorrentes;
    }
    
}
