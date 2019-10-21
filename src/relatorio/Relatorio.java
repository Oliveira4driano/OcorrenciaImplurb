/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorio;

import static com.sun.tools.doclint.Entity.image;
import model.Servidor;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Adriano
 */
public class Relatorio {
     public void gerarRelatorio(List<Servidor> lista){     
         //JasperReport jasperReport = null;
         //JasperPrint relatorio = null;
        try{
           
            InputStream fonte = Relatorio.class.getResourceAsStream("/Ocorrencia.jrxml");  
            JasperReport report = JasperCompileManager.compileReport(fonte);
            JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));
           // JasperExportManager.exportReportToPdfFile("Ocorrencia.jrxml", "arquivo.pdf");
            JasperViewer viewer = new JasperViewer(print, false);
            
            viewer.setTitle("Ocorrencia IMPLURB");
   
            //viewer.setIconImage();
            viewer.setVisible(true);
           
           /*
            InputStream fonte = Thread.currentThread().getClass().getResourceAsStream("/Ocorrencia.jasper");
            jasperReport = (JasperReport) JRLoader.loadObject( fonte );
            relatorio = JasperFillManager.fillReport(jasperReport, null, new JRBeanCollectionDataSource(lista));
            JasperViewer viewer = new JasperViewer(relatorio, false);
            viewer.setTitle("Relatório");
            viewer.setVisible(true);
            
            } catch (JRException jRException) {
            jRException.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();*/
           
                        
        } 
            catch (JRException e) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}

/*try {
            InputStream jasperFile = Thread.currentThread().getClass().getResourceAsStream("/br/com/furutani/relatorios/Rel_Precipitacoes.jasper");
            jasperReport = (JasperReport) JRLoader.loadObject( jasperFile );
            relatorio = JasperFillManager.fillReport(jasperReport, parametros, new RelatorioPrecipitacoesDS());
            JasperViewer viewer = new JasperViewer(relatorio, false);
            viewer.setTitle("Relatório");
            viewer.setVisible(true);
        } catch (JRException jRException) {
            jRException.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
