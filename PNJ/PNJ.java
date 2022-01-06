package PNJ;

public class PNJ {
	
	//Datos personaje
	private String nombre;
	private String jugador;
	private String titulo;
	private String lugar_Nacimiento;
	private char sexo;
	private int edad;
	
	//Carateristicas Principales
	
	private int fuerza;
	private int constitucion;
	private int tamano;
	private int destreza;
	private int apariencia;
	private int inteligencia;
	private int poder;
	private int educacion;
	
	//Caracteristicas Secundarias
	
	private int idea;
	private int suerte;
	private int conocimiento;
	private int mitos_Cthulu ;
	private String bonificacion_dano;
	private int puntos_cordura;
	private int puntos_magia;
	private int puntos_salud;
	private int puntos_ocupacionales;
	private int puntos_libres;
	
	//Habilidades
	
	private int antropologia;
	private int arqueologia;
	private int artes_marciales;
	private int astronomia;
	private int biologia;
	private int buscar_libros;
	private int cerrajeria;
	private int charlataneria;
	private int ciencias_ocultas;
	private int conducir_automovil;
	private int conducir_maquinaria;
	private int contabilidad;
	private int credito;
	private int derecho;
	private int descubrir;
	private int discreccion;
	private int disfrazarse;
	private int electricidad;
	private int equitacion;
	private int escuchar;
	private int esquivar;
	private int farmacologia;
	private int fisica;
	private int fotografia;
	private int geologia;
	private int habilidad_artesanal; //////////////////////////////
	private int habilidad_artistica; //////////////////////////////
	private int historia;
	private int historia_natural;
	private int lanzar;
	private int lengua_propia; //////////////////////////////////
	private int mecanica;
	private int medicina;
	private int nadar;
	private int ocultar;
	private int ocultarse;
	private int orientarse;
	private int otras_lenguas; //////////////////////////////////
	private int persuasion;
	private int pilotar; ///////////////////////////////////////
	private int primeros_auxilios;
	private int psicoanalisis;
	private int psicologia;
	private int quimica;
	private int regatear;
	private int saltar;
	private int seguir_rastros;
	private int trepar;
	private int sigilo;
	
	//Armas
	private int ametralladora;
	private int arma_corta;
	private int escopeta;
	private int fusil;
	private int subfusil;
	private int cabezazo;
	private int patada;
	private int presa;
	private int punetazo;
	private int bayoneta;
	private int cuchillo;
	
	//Creamos el metodo constructor
	public PNJ (String n,String j,String t,String ln,int e,char s){
		
		this.setNombre(n);
		this.setJugador(j);
		this.setTitulo(t);
		this.setSexo(s);
		this.setLugar_Nacimiento(ln);
		this.setEdad(e);
		this.setPNJDefault();
		this.setFuerza(this.dado1d6()+this.dado1d6()+this.dado1d6());
		this.setConstitucion(this.dado1d6()+this.dado1d6()+this.dado1d6());
		this.setTamano(this.dado1d6()+this.dado1d6());
		this.setDestreza(this.dado1d6()+this.dado1d6()+this.dado1d6());
		this.setApariencia(this.dado1d6()+this.dado1d6()+this.dado1d6());
		this.setInteligencia(this.dado1d6()+this.dado1d6());
		
	}
	
	//Metodos de Datos
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setJugador(String jugador) {
		this.jugador = jugador;
	}
	public String getJugador() {
		return jugador;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setLugar_Nacimiento(String lugar_Nacimiento) {
		this.lugar_Nacimiento = lugar_Nacimiento;
	}
	public String getLugar_Nacimiento() {
		return lugar_Nacimiento;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public char getSexo() {
		return sexo;
	}
	
	public void setEdad(int edad) {
		if(edad < (this.getEducacion()+6)){
			edad = this.getEducacion()+6;
		}else{
			this.edad = edad;
			if(edad > 40 ){
				for(int i=edad-40;i>10;i=i-10){
					this.setEducacion(this.getEducacion()+1);
					this.setFuerza(this.getFuerza()-1);
					this.setDestreza(this.getDestreza()-1);
					this.setConstitucion(this.getConstitucion()-1);
					this.setApariencia(this.getApariencia()-1);
				}
			}
		}
		
	}
	public int getEdad() {
		return edad;
	}
	
	
	//Metodos de Caracteristicas Principales
	public void setFuerza(int fuerza) {
		if(fuerza<3){
			fuerza = 3 ;
		}else if(fuerza>18){
			fuerza = 18 ;
		}
		this.fuerza = fuerza;
	}
	public int getFuerza() {
		return fuerza;
	}
	public void setConstitucion(int constitucion) {
		if(constitucion<3){
			constitucion = 3 ;
		}else if(constitucion>18){
			constitucion = 18 ;
		}
		this.constitucion = constitucion;
	}
	public int getConstitucion() {
		return constitucion;
	}
	public void setTamano(int tamano) {
		if(tamano<2){
			tamano = 2 ;
		}else if(tamano>12){
			tamano = 12 ;
		}
		this.tamano = tamano + 6;
	}
	public int getTamano() {
		return tamano;
	}
	public void setDestreza(int destreza) {
		if(destreza<3){
			destreza = 3 ;
		}else if(destreza>18){
			destreza = 18 ;
		}
		this.destreza = destreza;
	}
	public int getDestreza() {
		return destreza;
	}
	public void setApariencia(int apariencia) {
		if(apariencia<3){
			apariencia = 3 ;
		}else if(apariencia>18){
			apariencia = 18 ;
		}
		this.apariencia = apariencia;
	}
	public int getApariencia() {
		return apariencia;
	}
	public void setInteligencia(int inteligencia) {
		if(apariencia<2){
			apariencia = 2 ;
		}else if(apariencia>12){
			apariencia = 12 ;
		}
		this.inteligencia = inteligencia + 6;
	}
	public int getInteligencia() {
		return inteligencia;
	}
	public void setPoder(int poder) {
		if(poder<3){
			poder = 3 ;
		}else if(poder>18){
			poder = 18 ;
		}
		this.poder = poder;
	}
	public int getPoder() {
		return poder;
	}
	public void setEducacion(int educacion) {
		if(poder<3){
			poder = 3 ;
		}else if(poder>18){
			poder = 18 ;
		}
		this.educacion = educacion + 3;
	}
	public int getEducacion() {
		return educacion;
	}
	public void setIdea(int idea){
		idea= this.getInteligencia() * 5;
		this.idea = idea;
	}
	public int getIdea() {
		return idea;
	}
	public void setSuerte(int suerte) {
		suerte = this.getPoder() * 5 ;
		this.suerte = suerte;
	}
	public int getSuerte() {
		return suerte;
	}
	public void setConocimiento(int conocimiento) {
		conocimiento = this.getEducacion() * 5;
		this.conocimiento = conocimiento;
	}
	public int getConocimiento() {
		return conocimiento;
	}
	public void setMitos_Cthulu(int mitos_Cthulu) {
		if(mitos_Cthulu <0){
			mitos_Cthulu = 0;
		}else if(mitos_Cthulu >100){
			mitos_Cthulu = 99;
		}
		this.mitos_Cthulu = mitos_Cthulu;
	}
	public int getMitos_Cthulu() {
		return mitos_Cthulu;
	}
	public void setBonificacion_dano() {
		int media = (int)(this.getFuerza() + this.getTamano())/2;
		if( media > 2 &&  media < 12){
			this.bonificacion_dano = "-1d6" ;
		}else if(media > 13 &&  media < 16){
			this.bonificacion_dano = "-1d4" ;
		}else if(media > 17 &&  media < 24){
			this.bonificacion_dano = "0" ;
		}else if(media > 25 &&  media < 32){
			this.bonificacion_dano = "1d4" ;
		}else if(media > 33 &&  media < 40){
			this.bonificacion_dano = "1d6" ;
		}else if(media > 41 &&  media < 56){
			this.bonificacion_dano = "2d6" ;
		}else if(media > 57 &&  media < 72){
			this.bonificacion_dano = "3d6" ;
		}else{
			this.bonificacion_dano = "4d6" ;
		}
		
	}
	public String getBonificacion_dano() {
		return bonificacion_dano;
	}
	public void setPuntos_cordura() {
		this.puntos_cordura = this.getPoder()*5 ;
	}
	public int getPuntos_cordura() {
		return puntos_cordura;
	}
	public void setPuntos_magia() {
		this.puntos_magia = this.getPoder()*5 ;
	}
	public int getPuntos_magia() {
		return puntos_magia;
	}
	public void setPuntos_salud(int puntos_salud) {
		this.puntos_salud = (int)(this.getTamano()+this.getConstitucion())/2;
	}
	public int getPuntos_salud() {
		return puntos_salud;
	}
	public void setPuntos_ocupacionales() {
		int puntos = this.getEducacion()*20;
		this.puntos_ocupacionales = puntos;
	}
	public void anadirPuntos_ocupacionales(int puntos_ocupacionales){
		this.puntos_ocupacionales = this.puntos_ocupacionales + puntos_ocupacionales ; 
	}
	public int getPuntos_ocupacionales() {
		return puntos_ocupacionales;
	}
	public void setPuntos_libres(int puntos_libres) { 
		this.puntos_libres = this.getInteligencia() * 5;
	}
	public void anadirPuntos_libres(int puntos_libres){
		this.puntos_libres = this.puntos_libres + puntos_libres ; 
	}
	public int getPuntos_libres() {
		return puntos_libres;
	}
	
	//Caracteristicas Secundarias __________________________________________________________
	public int dado1d6(){
		int dado=(int)(Math.random()*6+1);
		return dado;
	}
	public void setPNJDefault(){
		this.antropologia = 1;
		this.arqueologia = 1;
		this.artes_marciales = 1;
		this.astronomia = 1;
		this.biologia = 1;
		this.buscar_libros = 25;
		this.cerrajeria = 1;
		this.charlataneria = 5;
		this.ciencias_ocultas=1;
		this.conducir_automovil=20;
		this.conducir_maquinaria=1;
		this.contabilidad=10;
		this.credito=15;
		this.derecho=5;
		this.descubrir=25;
		this.discreccion=10;
		this.disfrazarse=1;
		this.electricidad=10;
		this.equitacion=5;
		this.escuchar=25;
		this.esquivar = this.getDestreza() * 2;
		this.farmacologia=1;
		this.fisica=1;
		this.fotografia=10;
		this.geologia=1;
		this.habilidad_artesanal=5;
		this.habilidad_artistica=5;
		this.historia=20;
		this.historia_natural=10;
		this.lanzar=25;
		this.lengua_propia=this.getEducacion()*5;
		this.mecanica=20;
		this.medicina=5;
		this.mitos_Cthulu=0;
		this.nadar=25;
		this.ocultar=15;
		this.ocultarse=10;
		this.orientarse=10;
		this.otras_lenguas=1;
		this.persuasion=15;
		this.pilotar=1;
		this.primeros_auxilios=30;
		this.psicoanalisis=1;
		this.psicologia=5;
		this.quimica=1;
		this.regatear=5;
		this.saltar=25;
		this.seguir_rastros=10;
		this.trepar=40;
		this.sigilo=30;
		this.ametralladora=15;
		this.arma_corta=20;
		this.escopeta=30;
		this.fusil=25;
		this.subfusil=15;
		this.cabezazo=10;
		this.patada=25;
		this.presa=25;
		this.punetazo=50;
		this.cuchillo=10;
		this.bayoneta=10;
	}
	public void setAntropologia(int antropologia) {
		this.antropologia = antropologia;
	}
	public int getAntropologia() {
		return antropologia;
	}
	public void setArqueologia(int arqueologia) {
		this.arqueologia = arqueologia;
	}
	public int getArqueologia() {
		return arqueologia;
	}
	public void setArtes_marciales(int artes_marciales) {
		this.artes_marciales = artes_marciales;
	}
	public int getArtes_marciales() {
		return artes_marciales;
	}
	public void setAstronomia(int astronomia) {
		this.astronomia = astronomia;
	}
	public int getAstronomia() {
		return astronomia;
	}
	public void setBiologia(int biologia) {
		this.biologia = biologia;
	}
	public int getBiologia() {
		return biologia;
	}
	public void setBuscar_libros(int buscar_libros) {
		this.buscar_libros = buscar_libros;
	}
	public int getBuscar_libros() {
		return buscar_libros;
	}
	public void setCerrajeria(int cerrajeria) {
		this.cerrajeria = cerrajeria;
	}
	public int getCerrajeria() {
		return cerrajeria;
	}
	public void setCharlataneria(int charlataneria) {
		this.charlataneria = charlataneria;
	}
	public int getCharlataneria() {
		return charlataneria;
	}
	public void setCiencias_ocultas(int ciencias_ocultas) {
		this.ciencias_ocultas = ciencias_ocultas;
	}
	public int getCiencias_ocultas() {
		return ciencias_ocultas;
	}
	public void setConducir_automovil(int conducir_automovil) {
		this.conducir_automovil = conducir_automovil;
	}
	public int getConducir_automovil() {
		return conducir_automovil;
	}
	public void setConducir_maquinaria(int conducir_maquinatia) {
		this.conducir_maquinaria = conducir_maquinaria;
	}
	public int getConducir_maquinaria() {
		return conducir_maquinaria;
	}
	public void setContabilidad(int contabilidad) {
		this.contabilidad = contabilidad;
	}
	public int getContabilidad() {
		return contabilidad;
	}
	public void setCredito(int credito) {
		this.credito = credito;
	}
	public int getCredito() {
		return credito;
	}
	public void setDerecho(int derecho) {
		this.derecho = derecho;
	}
	public int getDerecho() {
		return derecho;
	}
	public void setDescubrir(int descubrir) {
		this.descubrir = descubrir;
	}
	public int getDescubrir() {
		return descubrir;
	}
	public void setDiscreccion(int discreccion) {
		this.discreccion = discreccion;
	}
	public int getDiscreccion() {
		return discreccion;
	}
	public void setDisfrazarse(int disfrazarse) {
		this.disfrazarse = disfrazarse;
	}
	public int getDisfrazarse() {
		return disfrazarse;
	}
	public void setElectricidad(int electricidad) {
		this.electricidad = electricidad;
	}
	public int getElectricidad() {
		return electricidad;
	}
	public void setEquitacion(int equitacion) {
		this.equitacion = equitacion;
	}
	public int getEquitacion() {
		return equitacion;
	}
	public void setEscuchar(int escuchar) {
		this.escuchar = escuchar;
	}
	public int getEscuchar() {
		return escuchar;
	}
	public void setEsquivar(int esquivar) {
		this.esquivar = esquivar;
	}
	public int getEsquivar() {
		return esquivar;
	}
	public void setFarmacologia(int farmacologia) {
		this.farmacologia = farmacologia;
	}
	public int getFarmacologia() {
		return farmacologia;
	}
	public void setFisica(int fisica) {
		this.fisica = fisica;
	}
	public int getFisica() {
		return fisica;
	}
	public void setFotografia(int fotografia) {
		this.fotografia = fotografia;
	}
	public int getFotografia() {
		return fotografia;
	}
	public void setGeologia(int geologia) {
		this.geologia = geologia;
	}
	public int getGeologia() {
		return geologia;
	}
	public void setHabilidad_artesanal(int habilidad_artesanal) {
		this.habilidad_artesanal = habilidad_artesanal;
	}
	public int getHabilidad_artesanal() {
		return habilidad_artesanal;
	}
	public void setHabilidad_artistica(int habilidad_artistica) {
		this.habilidad_artistica = habilidad_artistica;
	}
	public int getHabilidad_artistica() {
		return habilidad_artistica;
	}
	public void setHistoria(int historia) {
		this.historia = historia;
	}
	public int getHistoria() {
		return historia;
	}
	public void setHistoria_natural(int historia_natural) {
		this.historia_natural = historia_natural;
	}
	public int getHistoria_natural() {
		return historia_natural;
	}
	public void setLanzar(int lanzar) {
		this.lanzar = lanzar;
	}
	public int getLanzar() {
		return lanzar;
	}
	public void setLengua_propia(int lengua_propia) {
		this.lengua_propia = lengua_propia;
	}
	public int getLengua_propia() {
		return lengua_propia;
	}
	public void setMecanica(int mecanica) {
		this.mecanica = mecanica;
	}
	public int getMecanica() {
		return mecanica;
	}
	public void setMedicina(int medicina) {
		this.medicina = medicina;
	}
	public int getMedicina() {
		return medicina;
	}
	public void setNadar(int nadar) {
		this.nadar = nadar;
	}
	public int getNadar() {
		return nadar;
	}
	public void setOcultar(int ocultar) {
		this.ocultar = ocultar;
	}
	public int getOcultar() {
		return ocultar;
	}
	public void setOcultarse(int ocultarse) {
		this.ocultarse = ocultarse;
	}
	public int getOcultarse() {
		return ocultarse;
	}
	public void setOrientarse(int orientarse) {
		this.orientarse = orientarse;
	}
	public int getOrientarse() {
		return orientarse;
	}
	public void setOtras_lenguas(int otras_lenguas) {
		this.otras_lenguas = otras_lenguas;
	}
	public int getOtras_lenguas() {
		return otras_lenguas;
	}
	public void setPersuasion(int persuasion) {
		this.persuasion = persuasion;
	}
	public int getPersuasion() {
		return persuasion;
	}
	public void setPilotar(int pilotar) {
		this.pilotar = pilotar;
	}
	public int getPilotar() {
		return pilotar;
	}
	public void setPrimeros_auxilios(int primeros_auxilios) {
		this.primeros_auxilios = primeros_auxilios;
	}
	public int getPrimeros_auxilios() {
		return primeros_auxilios;
	}
	public void setPsicoanalisis(int psicoanalisis) {
		this.psicoanalisis = psicoanalisis;
	}
	public int getPsicoanalisis() {
		return psicoanalisis;
	}
	public void setQuimica(int quimica) {
		this.quimica = quimica;
	}
	public int getQuimica() {
		return quimica;
	}
	public void setPsicologia(int psicologia) {
		this.psicologia = psicologia;
	}
	public int getPsicologia() {
		return psicologia;
	}
	public void setRegatear(int regatear) {
		this.regatear = regatear;
	}
	public int getRegatear() {
		return regatear;
	}
	public void setSaltar(int saltar) {
		this.saltar = saltar;
	}
	public int getSaltar() {
		return saltar;
	}
	public void setSeguir_rastros(int seguir_rastros) {
		this.seguir_rastros = seguir_rastros;
	}
	public int getSeguir_rastros() {
		return seguir_rastros;
	}
	public void setTrepar(int trepar) {
		this.trepar = trepar;
	}
	public int getTrepar() {
		return trepar;
	}
	public void setSigilo(int sigilo) {
		this.sigilo = sigilo;
	}
	public int getSigilo() {
		return sigilo;
	}
	//Metodos para las armas
	
	
	public void setAmetralladora(int ametralladora) {
		this.ametralladora = ametralladora;
	}
	public int getAmetralladora() {
		return ametralladora;
	}
	public void setArma_corta(int arma_corta) {
		this.arma_corta = arma_corta;
	}
	public int getArma_corta() {
		return arma_corta;
	}
	public void setEscopeta(int escopeta) {
		this.escopeta = escopeta;
	}
	public int getEscopeta() {
		return escopeta;
	}
	public void setFusil(int fusil) {
		this.fusil = fusil;
	}
	public int getFusil() {
		return fusil;
	}
	public void setSubfusil(int subfusil) {
		this.subfusil = subfusil;
	}
	public int getSubfusil() {
		return subfusil;
	}
	public void setCabezazo(int cabezazo) {
		this.cabezazo = cabezazo;
	}
	public int getCabezazo() {
		return cabezazo;
	}
	public void setPatada(int patada) {
		this.patada = patada;
	}
	public int getPatada() {
		return patada;
	}
	public void setPresa(int presa) {
		this.presa = presa;
	}
	public int getPresa() {
		return presa;
	}
	public void setPunetazo(int punetazo) {
		this.punetazo = punetazo;
	}
	public int getPunetazo() {
		return punetazo;
	}
	public void setBayoneta(int bayoneta) {
		this.bayoneta = bayoneta;
	}
	public int getBayoneta() {
		return bayoneta;
	}
	public void setCuchillo(int cuchillo) {
		this.cuchillo = cuchillo;
	}
	public int getCuchillo() {
		return cuchillo;
	}
	public String devolverFicha(){
		
		String dPersonaje="Nombre: "+this.nombre+"\nTitulo: "+this.titulo+"\nLugar de Nacimiento: "+this.lugar_Nacimiento+"\nSexo: "+this.sexo+"\nEdad: "+this.edad;
		String dPrincipales="\nFuerza: "+this.fuerza+"\nConstitucion: "+this.constitucion+"\nTamano: "+this.tamano+"\nDestreza: "+this.destreza+"\nApariencia: "+this.apariencia+"\nInteligencia: "+this.inteligencia+"\nPoder: "+this.poder+"\nEducacion: "+this.educacion;
		String dSecundaria="\nIdea: "+this.idea+ "\nSuerte: "+this.suerte+ "\nConocimiento: "+this.conocimiento+ "\nMitos Cthulu: " +this.mitos_Cthulu+ "\nBonificacion de Daño: "+this.bonificacion_dano+"\nPuntos Cordura: "+this.puntos_cordura+"\nPuntos Magia: "+this.puntos_magia+"\nPuntos Salud: "+this.puntos_salud+"\nPuntos Ocupacionales: "+this.puntos_ocupacionales+"\nPuntos Libre: "+this.puntos_libres;
		String dHab1="\nAntropologia: "+this.antropologia+"\n Arqueologia: "+this.arqueologia+"\nArtes Marciales: "+this.artes_marciales+"\nAstronomia: "+this.astronomia+"\nBiologia: "+this.biologia+"Buscar Libros: "+this.buscar_libros+"\nCerrajeria: "+this.cerrajeria+"\nCiencias Ocultas: "+this.ciencias_ocultas+"\nConducir Automovil: "+this.conducir_automovil+"\nConducir Maquinaria: "+this.conducir_maquinaria+"\nContabilidad: "+this.contabilidad+"\nCredito: "+this.derecho+"\nDerecho: "+this.derecho+"\nDescubrir: "+this.descubrir+"\nDiscreccion: "+this.discreccion+"\nDisfrazarse: "+this.disfrazarse+"\nElectricidad: "+this.electricidad+"\nEquitacion: "+this.equitacion+"\nEscuchar: "+this.escuchar+"\nEsquivar: "+this.esquivar+"\nFarmacologia: "+this.farmacologia+"\nFisica: "+this.fisica+"\nFotografia: "+this.fotografia+"\nGeologia: "+this.geologia+"\nHabilidad Artesanal: "+this.habilidad_artesanal;
		String dHab2="\nHabilidad Artistica: "+this.habilidad_artistica+"\nHistoria: "+this.historia+"\nHistoria Natural: "+this.historia_natural+"\nLanzar: "+this.lanzar+"\nLengua Propia: "+this.lengua_propia+"\nMecanica :"+this.mecanica+"\nNadar: "+this.nadar+"\nOcultar: "+this.ocultar+"\nOcultarse: "+this.ocultarse+"\nOrientarse: "+this.orientarse+"\nOtras Lenguas: "+this.otras_lenguas+"\nPersuasion: "+this.persuasion+"\nPilotar: "+this.pilotar+"\nPrimeros Auxilios: "+this.primeros_auxilios+"\nPsicoanalisis: "+this.psicoanalisis+"\nPsicologia: "+this.psicologia+"\nRegatear: "+this.regatear;		
		String dHab3="\nSaltar: "+this.saltar+"\nSeguir Rastros: "+this.seguir_rastros+"\nTrepar: "+this.trepar+"\nDiscreccion: "+this.discreccion+"\nDiscreccion: "+this.discreccion+"\nAmetralladora: "+this.ametralladora+"\nArma Corta: "+this.ametralladora+"\nEscopeta: "+this.escopeta + "\nFusil: "+this.fusil+"\nSubfusil: "+this.subfusil+"\nCabezazo: "+this.cabezazo+"\nPatada: "+this.patada+"\nPresa: "+this.presa+"\nPuñetazo: "+this.punetazo+"\nCuchillo: "+this.cuchillo+"\nBayoneta: "+this.bayoneta ;
		String c = dPersonaje+dPrincipales+dSecundaria+dHab1+dHab2+dHab3;
		return c;
	}
}	