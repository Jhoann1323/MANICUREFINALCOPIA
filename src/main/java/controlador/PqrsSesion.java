/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import ejb.PqrsFacadeLocal;
import ejb.TipopqrsFacadeLocal;
import ejb.UsuarioFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import modelo.Pqrs;
import modelo.Tipopqrs;
import utilidades.PqrsMailRespuesta;
import utilidades.envioCorreoAdministrador;

// import utilidades.PqrsMailRespuesta;

//import utilidades.PqrsNotificacionAdministrador; 
/**
 *
 * @author maye
 */
@Named(value = "pqrsSesion")
@SessionScoped
public class PqrsSesion implements Serializable {

    @EJB
    private PqrsFacadeLocal pqrsFacadeLocal;
    
    @EJB 
    private UsuarioFacadeLocal usuarioFacadeLocal ;

    //estructura para las llaves foraneas
    @EJB
    private TipopqrsFacadeLocal tipopqrsFacadeLocal;
    private Pqrs pqrs;

    //inyeccion de dependecias (llaves foraneas ) 
    @Inject
    private Tipopqrs tipopqrs;

    private List<Pqrs> pqrss;

    //Estructura para listas de llaves foraneas (inyeccion de dependencias)
    private List<Tipopqrs> tipopqrss; 
    private List<String> correos; 
     pqrs = new Pqrs();
    private Pqrs pqr;
    private Pqrs pqrtemporal = new Pqrs();

    @PostConstruct

    public void init() {

      
        //estructura para renderizado llaves foraneas 
        tipopqrss = tipopqrsFacadeLocal.findAll();

        pqrss = pqrsFacadeLocal.findAll();

    }

    public void registrarPqrs() {

        if (pqrsFacadeLocal.registrarPqrs(pqrs, tipopqrs)) {
            tipopqrs = new Tipopqrs();

            pqrs = new Pqrs();
            pqrss = pqrsFacadeLocal.findAll();
        } else {
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "error", "error"
            ));
    }

    lic void guardarTemporal(Pqrs t) {

        pqrtemporal = t;

    }

    /*  
    public void avisarEmailCliente(Pqrs p){
        try {
            (p.getIdCliente().toString());
            PqrsMailRespuesta.correoPqrs(
                    p.getIdCliente().getNombre(),
                    p.getIdCliente().getApellido(),
                    p.getIdCliente().getCorreo(),
                    p.getFechaRegistro(),
                    p.getComentarioAdmin()
                    );
        } catch (Exception e) {
        }
        
        
    }
     */
    public void editarPqrs() {

        if (pqrsFacadeLocal.actualizarPqrs(pqrtemporal)) {

            PqrsMailRespuesta.correoPqrs(
                    pqrtemporal.getNombreCliente(),
                    pqrtemporal.getApellidoCliente(),
                    pqrtemporal.getCorreo(),
                    pqrtemporal.getFechaRegistro(),
                    pqrtemporal.getComentarioAdmin()
            );
            pqrss = pqrsFacadeLocal.findAll();
            pqrtemporal = new Pqrs();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "error", "error"
            ));
        }

    }
    
    public void avisoPqrs(){
        try {
            
            correos = usuarioFacadeLocal.leerCorreosAdmin();

            if (correos != null) {
                envioCorreoAdministrador.recuperarAdministrador(correos); ;
            } else {
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Fallo al enviar", "Fallo al enviar"));
        }
    }
    
   
/*
 public void generarArchivo(String tipoArchivo) throws JRException, IOException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext context = facesContext.getExternalContext();
        HttpServletResponse response = (HttpServletResponse) context.getResponse();
        File jasper = new File(context.getRealPath("/reportes/TipoPqrsreporte."));
        try {
            JasperPrint jp = JasperFillManager.fillReport(jasper.getPath(), new HashMap(), dataSource.getConnection());
            switch (tipoArchivo) {
                case "pdf":
                    response.setContentType("application/pdf");
                    response.addHeader("Content-disposition", "attachment; filename=Lista reportes tipo Reclamo.pdf");
                    OutputStream os = response.getOutputStream();
                    JasperExportManager.exportReportToPdfStream(jp, os);
                    os.flush();
                    os.close();
                    break;

                case "xlsx":
                    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
                    response.addHeader("Content-disposition", "attachment; filename=Lista reportes tipo Reclamo.xlsx");

                    JRXlsxExporter exporter = new JRXlsxExporter(); // initialize exporter 
                    exporter.setExporterInput(new SimpleExporterInput(jp)); // set compiled report as input
                    exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));

                    SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
                    configuration.setOnePagePerSheet(true); // setup configuration
                    configuration.setDetectCellType(true);
                    configuration.setSheetNames(new String[]{"reportes"});
                    exporter.setConfiguration(configuration); // set configuration    
                    exporter.exportReport();
                    break;

                case "docx":
                    response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                    response.addHeader("Content-disposition", "attachment; filename=Lista reportes tipo Reclamo.docx");

                    JRDocxExporter exporterDoc = new JRDocxExporter(); // initialize exporter 
                    exporterDoc.setExporterInput(new SimpleExporterInput(jp)); // set compiled report as input
                    exporterDoc.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));

                    SimpleDocxExporterConfiguration configurationDoc = new SimpleDocxExporterConfiguration();
                    configurationDoc.setMetadataAuthor("GlossNailsG."); // setup configuration
                    configurationDoc.setMetadataTitle("Reporte de pqrs");
                    configurationDoc.setMetadataSubject("Listado de pqrs");

                    exporterDoc.setConfiguration(configurationDoc); // set configuration    
                    exporterDoc.exportReport();
                    break;

                default:
                    System.err.println(" No se encontro este caso :: CategoriaView::generarArchivo");
                    break;

            }
            facesContext.responseComplete();

}
}
*/
    public void eliminarPqrs(Pqrs t) {

        try {
            pqrsFacadeLocal.remove(t);
            pqrss = pqrsFacadeLocal.findAll();

        } catch (Exception e) {
        }
    }

    public Pqrs getPqrs() {
        return pqrs;
    }

    public void setPqrs(Pqrs pqrs) {
        this.pqrs = pqrs;
    }

    public Tipopqrs getTipopqrs() {
        return tipopqrs;
    }

    public void setTipopqrs(Tipopqrs tipopqrs) {
        this.tipopqrs = tipopqrs;
    }

    public List<Pqrs> getPqrss() {
        return pqrss;
    }

    public void setPqrss(List<Pqrs> pqrss) {
        this.pqrss = pqrss;
    }

    public List<Tipopqrs> getTipopqrss() {
        return tipopqrss;
    }

    public void setTipopqrss(List<Tipopqrs> tipopqrss) {
        this.tipopqrss = tipopqrss;
    }

    public Pqrs getPqr() {
        return pqr;
    }

    public void setPqr(Pqrs pqr) {
        this.pqr = pqr;
    }

    public Pqrs getPqrtemporal() {
        return pqrtemporal;
    }

    public void setPqrtemporal(Pqrs pqrtemporal) {
        this.pqrtemporal = pqrtemporal;
    }

    public List<String> getCorreos() {
        return correos;
    }

    public void setCorreos(List<String> correos) {
        this.correos = correos;
    }

}
