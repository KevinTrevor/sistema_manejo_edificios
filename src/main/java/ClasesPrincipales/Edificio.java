/**
* Hecho por: Ruben Fuentes 26.326.992 y Alexander Noriega 27.280.176
* Carrera: Informática
* Materia: Algoritmos y Estructuras de Datos II
*/
package ClasesPrincipales;
import Lista.*;
import java.time.LocalDate;

/**
 * La clase Edificio registra el código del edificio, identificación del edificio,
 * estado, dirección del edificio, cédula del encargado, fecha de creación del 
 * edificio y la lista de pisos.
 */
public class Edificio {
    private String codigo, identificacion, estado, direccion, cedulaEncargado;
    private LocalDate fechaCreacion;
    private ListaEnlazada<Piso> pisos;

    /**
     * Método constructor de la clase Edificio. Inicializa los atributos como nulos.
     */
    public Edificio() {
        this.codigo = null;
        this.identificacion = null;
        this.estado = null;
        this.direccion = null;
        this.cedulaEncargado = null;
        this.fechaCreacion = null;
        this.pisos = null;
    }

    /**
     * Método constructor de la clase Edificio. Inicializa los atributos con los 
     * valores pasados como parametros.
     * @param codigo String
     * @param identificacion String
     * @param estado String
     * @param direccion String
     * @param cedulaEncargado String
     * @param fechaCreacion LocalDate
     */
    public Edificio(String codigo, String identificacion, String estado, 
            String direccion, String cedulaEncargado, LocalDate fechaCreacion) {
        this.codigo = codigo;
        this.identificacion = identificacion;
        this.estado = estado;
        this.direccion = direccion;
        this.cedulaEncargado = cedulaEncargado;
        this.fechaCreacion = fechaCreacion;
        this.pisos = new ListaEnlazada<>();
    }
    
    // INSERTAR

    /**
     * Metodo que agrega un nuevo piso a la lista de pisos del edificio.
     * @param nuevoPiso Piso
     */
    public void agregarPisos(Piso nuevoPiso){
       Nodo<Piso> nuevo = new Nodo<>(nuevoPiso);
       ListaEnlazada<Piso> listaPisos = this.getPisos();
       if (listaPisos.estaVacio()){
           listaPisos.setInicio(nuevo);
           listaPisos.setFin(nuevo);
           listaPisos.setSize(listaPisos.getSize() + 1);
       }
       else{
           Nodo<Piso> auxiliar = this.getPisos().getInicio();
           if(nuevoPiso.getNumeroPiso() < auxiliar.getInfo().getNumeroPiso()){
               nuevo.setSiguiente(auxiliar);
               listaPisos.setInicio(nuevo);
               listaPisos.setSize(listaPisos.getSize() + 1);
           }
           else{
                while(nuevoPiso.getNumeroPiso() > auxiliar.getInfo().getNumeroPiso() && auxiliar.getSiguiente() != null){
                    auxiliar = auxiliar.getSiguiente();
                }
           
                if (auxiliar.getInfo().getNumeroPiso().equals(nuevoPiso.getNumeroPiso())){
                    System.out.println("Ya existe un piso con este número.");
                }
                else{
                    if (auxiliar.getInfo().getNumeroPiso().equals(listaPisos.getFin().getInfo().getNumeroPiso())){
                        auxiliar.setSiguiente(nuevo);
                        listaPisos.setFin(nuevo);
                    }
                    else{
                        nuevo.setSiguiente(auxiliar.getSiguiente());
                        auxiliar.setSiguiente(nuevo);
                    }
                    listaPisos.setSize(listaPisos.getSize() + 1);
                }
           }
       }
    }
    
    /**
     * Método que agrega un nuevo local a un piso de la lista de pisos 
     * del edificio. 
     * @param numeroPiso Integer
     * @param nuevoLocal Local
     */
    public void agregarLocal(Integer numeroPiso, Local nuevoLocal){
        Piso pisoBuscado = this.getPisos().buscarDato(numeroPiso);
        if (pisoBuscado != null) {
            pisoBuscado.agregarLocal(nuevoLocal);
        }
    }
    
    /**
     * Metodo que agrega un nuevo pago a la lista de pagos de un local de un 
     * piso de la lista de pisos del edificio.
     * @param numeroPiso Integer
     * @param codigoLocal String
     * @param nuevoPago Pago
     */
    public void agregarPagoLocalEnMes(Integer numeroPiso, String codigoLocal,
            Pago nuevoPago){
        
        Piso pisoBuscado = this.getPisos().buscarDato(numeroPiso);
        if (pisoBuscado != null) {
            pisoBuscado.agregarPagoLocalEnMes(codigoLocal, nuevoPago);
        }
    }
    
    // COMPARACIONES
    
    @Override
    public boolean equals(Object busqueda){
        return this.getCodigo().compareTo((String) busqueda) == 0;
    }
    
    // MODIFICAR

    /**
     * Método para modificar los valores de un local específico en un piso 
     * especifico de un edificio.
     * @param numeroPiso Integer
     * @param codigoLocal String
     * @param cedulaArrendatario String
     * @param montoMensualidad Float
     */
    
    public void modificarLocal(Integer numeroPiso, String codigoLocal, String cedulaArrendatario, 
            Float montoMensualidad){
        
        Piso pisoBuscado = this.getPisos().buscarDato(numeroPiso);
        if (pisoBuscado != null) {
            pisoBuscado.modificarLocal(codigoLocal, cedulaArrendatario, montoMensualidad);
            this.getPisos().modificarDato(numeroPiso, pisoBuscado);
        }
    }
    
    /**
     * Método para modificar los valores de un piso específico de un edificio.
     * @param numeroPiso Integer
     * @param cedulaEncargado String
     * @param fechaRegistro LocalDate
     */
    public void modificarPiso(Integer numeroPiso, String cedulaEncargado, 
            LocalDate fechaRegistro){
        
        Piso pisoBuscado = this.getPisos().buscarDato(numeroPiso);
        if (pisoBuscado != null) {
            pisoBuscado.modificarPiso(cedulaEncargado, fechaRegistro);
            this.getPisos().modificarDato(numeroPiso, pisoBuscado);
        }
    }
    
    /**
     * Metodo para modificar los valores de un edificio.
     * @param identificacion String
     * @param estado String
     * @param direccion String
     * @param cedulaEncargado String
     * @param fechaCreacion LocalDate
     */
    public void modificarEdificio(String identificacion, String estado, 
            String direccion, String cedulaEncargado, LocalDate fechaCreacion){
        
        this.setIdentificacion(identificacion);
        this.setEstado(estado);
        this.setDireccion(direccion);
        this.setCedulaEncargado(cedulaEncargado);
        this.setFechaCreacion(fechaCreacion);
    }
    
    // ELIMINAR

    /**
     * Método para eliminar un piso específico de la lista de pisos del edificio.
     * @param numeroPiso Integer
     */
    public void eliminarPiso(Integer numeroPiso){
        this.getPisos().eliminarDato(numeroPiso);
    }
    
    // MOSTRAR
    
    @Override
    public String toString(){
        return "Código del edificio: " + this.getCodigo() + 
                "\nNombre del edificio: " + this.getIdentificacion() + 
                "\nEstado: " + this.getEstado() + 
                "\nDirrecion del edificio: " + this.getDireccion() +
                "\nEncargado del edificio: " + this.getCedulaEncargado() +
                "\nFecha de creación: " + this.getFechaCreacion() +
                "\nNumero de pisos: " + this.getNumeroPisos() +
                "\nNúmero de locales: " +this.getNumeroLocales() ;
    }
    
    /**
     * Método que retorna la información de un local específico en un piso 
     * específico de un edificio.
     * @param numeroPiso
     * @param codigoLocal
     * @return
     */
    public String mostrarLocalPorCodigo(Integer numeroPiso, String codigoLocal){
        String localStr = "";
        Piso pisoBuscado = this.getPisos().buscarDato(numeroPiso);
        if (pisoBuscado != null) {
            localStr = pisoBuscado.mostrarLocalPorCodigo(codigoLocal);
        }
        return localStr;
    }
    
    // GETTER Y SETTER

    /**
     * Método que retorna el valor del atributo codigo.
     * @return String
     */
    
    public String getCodigo() {
        return this.codigo;
    }
    
    /**
     * Método que asigna un valor al atributo codigo.
     * @param codigo String
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Método que retorna el valor del atributo identificacion.
     * @return String
     */
    public String getIdentificacion() {
        return this.identificacion;
    }

    /**
     * Método que asigna un valor al atributo identificacion.
     * @param identificacion String
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * Método que retorna el valor del atributo estado.
     * @return String
     */
    public String getEstado() {
        return this.estado;
    }

    /**
     * Método que asigna un valor al atributo estado.
     * @param estado String
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Método que retorna el valor del atributo direccion.
     * @return String
     */
    public String getDireccion() {
        return this.direccion;
    }

    /**
     * Método que asigna un valor al atributo direccion.
     * @param direccion String
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Método que retorna el valor del atributo cedulaEncargado.
     * @return String
     */
    public String getCedulaEncargado() {
        return this.cedulaEncargado;
    }

    /**
     * Método que asigna un valor al atributo cedulaEncargado.
     * @param cedulaEncargado String
     */
    public void setCedulaEncargado(String cedulaEncargado) {
        this.cedulaEncargado = cedulaEncargado;
    }

    /**
     * Método que retorna el valor del atributo fechaCreacion.
     * @return LocalDate
     */
    public LocalDate getFechaCreacion() {
        return this.fechaCreacion;
    }

    /**
     * Método que asigna un valor al atributo fechaCreacion.
     * @param fechaCreacion LocalDate
     */
    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * Método que retorna el valor del atributo pisos.
     * @return ListaEnlazada
     */
    public ListaEnlazada<Piso> getPisos() {
        return this.pisos;
    }
    
    /**
     * Método que retorna el valor total del monto recaudado en un mes en todos 
     * los locales de todos los pisos de un edificio.
     * @param mes String
     * @return Float
     */
    public Float getMontoEnMes(String mes){
        Float montoRecaudado = new Float(0);
        Nodo<Piso> nodoPiso = this.getPisos().getInicio();
        while(nodoPiso != null){
            montoRecaudado = montoRecaudado + nodoPiso.getInfo().getMontoEnMes(mes);
            nodoPiso = nodoPiso.getSiguiente();
        }
        return montoRecaudado;
    }
    
    /**
     * Método que retorna el valor total del monto restante en un mes en todos 
     * los locales de todos los pisos en un edificio.
     * @param mes String
     * @return Float
     */
    public Float getRestanteEnMes(String mes){
        Float montoRestante = new Float(0);
        Nodo<Piso> nodoPiso = this.getPisos().getInicio();
        while(nodoPiso != null){
            montoRestante = montoRestante + nodoPiso.getInfo().getRestanteEnMes(mes);
            nodoPiso = nodoPiso.getSiguiente();
        }
        return montoRestante;
    }
    
    /**
     * Método que retorna el valor total de locales en un edificio.
     * @return int
     */
    public int getNumeroLocales(){
        int totalLocales = 0;
        Nodo<Piso> piso = this.getPisos().getInicio();
        while(piso != null){
            totalLocales = totalLocales + piso.getInfo().getNumeroLocales();
            piso = piso.getSiguiente();
        }
        return totalLocales;
    }
    
    /**
     * Método que retorna la cantidad de locales que tienen una mensualidad menor
     * al monto indicado por su parametro.
     * @param monto 
     * @return
     */
    public int getLocalesMontoMenorA(Integer monto) {
    	Nodo<Piso> piso = this.getPisos().getInicio();
    	Integer contador = 0;
    	while(piso != null) {
    		contador += piso.getInfo().getLocalesMenorA(monto);
    		piso = piso.getSiguiente();
    	}
    	
    	return contador;
    }
    
    /**
     * Método que retorna el valor total de locales que pagaron en un mes 
     * específico en todos los pisos de un edificio.
     * @param mes String
     * @return int
     */
    public int getNumeroLocalesPagosEnMes(String mes){
        int totalLocales = 0;
        Nodo<Piso> piso = this.getPisos().getInicio();
        while (piso != null){
            totalLocales = totalLocales + piso.getInfo().getLocalesPagadosEnMes(mes);
            piso = piso.getSiguiente();
        }
        return totalLocales;
    }
    
    /**
     * Método que retorna el tamaño de la lista de pisos.
     * @return int
     */
    public int getNumeroPisos(){
        return this.getPisos().getSize();
    }
    
    /**
     * Método que retorna la cedula del encargado de mantenimiento de un piso
     * específico.
     * @param numeroPiso Integer
     * @return String
     */
    public String getCedulaEncargadoPiso(Integer numeroPiso){
        String cedulaEncontrada = "";
        Piso pisoBuscado = this.getPisos().buscarDato(numeroPiso);
        if (pisoBuscado != null){
            cedulaEncontrada = pisoBuscado.getCedulaEncargado();
        }
        return cedulaEncontrada;
    }
    
    /**
     * Método que retorna la cedula del arrendatario de un local especifico de un 
     * piso específico.
     * @param numeroPiso
     * @param codigoLocal
     * @return
     */
    public String getCedulaArrendatarioLocal(Integer numeroPiso, String codigoLocal){
        String cedulaEncontrada = "";
        Piso pisoBuscado = this.getPisos().buscarDato(numeroPiso);
        if (pisoBuscado != null){
            cedulaEncontrada = pisoBuscado.getCedulaArrendatarioLocal(codigoLocal);
        }
        return cedulaEncontrada;
    }
}
