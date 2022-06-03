/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.primefaces.model.DefaultStreamedContent;

/**
 *
 * @author aluno
 */
public class Relatorio {
    
    public static DefaultStreamedContent gerar(InputStream is, Map<String, Object> params, JRBeanCollectionDataSource dataSource){
        
        
        try {
            JasperPrint jp = JasperFillManager.fillReport(is, null, dataSource);
            
            JRPdfExporter export = new JRPdfExporter();
            
            export.setExporterInput(new SimpleExporterInput(jp));
            
            ByteArrayOutputStream saida = new ByteArrayOutputStream();
            
            export.setExporterOutput(new SimpleOutputStreamExporterOutput(saida));
            
            export.exportReport();
            
            
            return DefaultStreamedContent.builder()
                .name("relatorio-conta-corrente.pdf")
                .contentType("application/pdf")
                .stream(() -> new ByteArrayInputStream(saida.toByteArray()))
                .build();
            
            
        } catch (JRException ex) {
            ex.printStackTrace();
            System.out.println("Erro ao gerar o relatorio de conta corrente");
        }
        return null;
        
    }
    
}
