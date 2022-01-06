package PNJ;

public class Modificador_PNJ {
	//Atributos personaje
	private PNJ personaje;
	
	//Creamos el metodo constructor
	public Modificador_PNJ(PNJ p){
		this.setPersonaje(p) ;
	}
	//Metodos para modificar
	public void setPersonaje(PNJ personaje) {
		this.personaje = personaje;
	}

	public PNJ getPersonaje() {
		return personaje;
	}
	
	public void modificar_habilidad(String hab,int num){
		if( hab == "antropologia" && personaje.getAntropologia()+num > 1 && personaje.getAntropologia()+num < 99 ){
			personaje.setAntropologia(personaje.getAntropologia()+num);
		}
		if( hab == "arqueologia" && personaje.getArqueologia()+num > 1 && personaje.getArqueologia()+num  < 99){
			personaje.setArqueologia(personaje.getArqueologia()+num);
		}
		if( hab== "artes marciales" && personaje.getArtes_marciales()+num > 1 && personaje.getArtes_marciales()+num < 99){
			personaje.setArtes_marciales(personaje.getArtes_marciales()+num);
		}
		if( hab == "astronomia" && personaje.getAstronomia()+num > 1 && personaje.getAstronomia()+num <99 ){
			personaje.setAstronomia(personaje.getAstronomia()+num);
		}
		if( hab == "biologia" && personaje.getBiologia()+num > 1 && personaje.getBiologia()+num < 99){
			personaje.setBiologia(personaje.getBiologia()+num);
		}
		if( hab == "buscar libros" && personaje.getBuscar_libros()+num > 25 && personaje.getBuscar_libros()+num < 99){
			personaje.setBuscar_libros(personaje.getBuscar_libros()+num);
		}
		if ( hab == "cerrajeria" && personaje.getCerrajeria()+num >1 &&  personaje.getCerrajeria()+num < 99){
			personaje.setCerrajeria(personaje.getCerrajeria()+num);
		}
		if ( hab == "charlataneria" && personaje.getCharlataneria()+num >5 &&  personaje.getCharlataneria()+num < 99){
			personaje.setCharlataneria(personaje.getCharlataneria()+num);
		}
		if ( hab == "ciencias ocultas" && personaje.getCiencias_ocultas()+num >1 &&  personaje.getCiencias_ocultas()+num < 99){
			personaje.setCiencias_ocultas(personaje.getCiencias_ocultas()+num);
		}
		if ( hab == "conducir automovil" && personaje.getConducir_automovil()+num >20 &&  personaje.getConducir_automovil()+num < 99){
			personaje.setConducir_automovil(personaje.getConducir_automovil()+num);
		}
		if ( hab == "conducir maquinaria" && personaje.getConducir_maquinaria()+num >1 &&  personaje.getConducir_maquinaria()+num < 99){
			personaje.setConducir_maquinaria(personaje.getConducir_maquinaria()+num);
		}
		if ( hab == "contabilidad" && personaje.getContabilidad()+num >10 &&  personaje.getContabilidad()+num < 99){
			personaje.setContabilidad(personaje.getContabilidad()+num);
		}
		if ( hab == "credito" && personaje.getCredito()+num >15 &&  personaje.getCredito()+num < 99){
			personaje.setCredito(personaje.getCredito()+num);
		}
		if ( hab == "derecho" && personaje.getDerecho()+num >5 &&  personaje.getDerecho()+num < 99){
			personaje.setDerecho(personaje.getDerecho()+num);
		}
		if ( hab == "descubrir" && personaje.getDescubrir()+num >25 &&  personaje.getDescubrir()+num < 99){
			personaje.setDescubrir(personaje.getDescubrir()+num);
		}
		if ( hab == "discreccion" && personaje.getDiscreccion()+num >10 &&  personaje.getDiscreccion()+num < 99){
			personaje.setDiscreccion(personaje.getDiscreccion()+num);
		}
		if ( hab == "disfrazarse" && personaje.getDisfrazarse()+num >1 &&  personaje.getDisfrazarse()+num < 99){
			personaje.setDisfrazarse(personaje.getDisfrazarse()+num);
		}
		if ( hab == "electricidad" && personaje.getElectricidad()+num >10 &&  personaje.getElectricidad()+num < 99){
			personaje.setElectricidad(personaje.getElectricidad()+num);
		}
		if ( hab == "equitacion" && personaje.getEquitacion()+num >5 &&  personaje.getEquitacion()+num < 99){
			personaje.setEquitacion(personaje.getEquitacion()+num);
		}
		if ( hab == "escuchar" && personaje.getEscuchar()+num >25 &&  personaje.getEscuchar()+num < 99){
			personaje.setEscuchar(personaje.getEscuchar()+num);
		}
		if ( hab == "esquivar" && personaje.getEsquivar()+num > personaje.getDestreza() * 2 &&  personaje.getEsquivar()+num < 99){
			personaje.setEsquivar(personaje.getEsquivar()+num);
		}
		if ( hab == "farmacologia" && personaje.getFarmacologia()+num >1 &&  personaje.getFarmacologia()+num < 99){
			personaje.setFarmacologia(personaje.getFarmacologia()+num);
		}
		if ( hab == "fisica" && personaje.getFisica()+num >1 &&  personaje.getFisica()+num < 99){
			personaje.setFisica(personaje.getFisica()+num);
		}
		if ( hab == "fotografia" && personaje.getFotografia()+num >10 &&  personaje.getFotografia()+num < 99){
			personaje.setFotografia(personaje.getFotografia()+num);
		}
		if ( hab == "geologia" && personaje.getGeologia()+num >1 &&  personaje.getGeologia()+num < 99){
			personaje.setGeologia(personaje.getGeologia()+num);
		}
		if ( hab == "habilidad artesanal" && personaje.getHabilidad_artesanal()+num >5 &&  personaje.getHabilidad_artesanal()+num < 99){
			personaje.setHabilidad_artesanal(personaje.getHabilidad_artesanal()+num);
		}
		if ( hab == "habilidad artistica" && personaje.getHabilidad_artistica()+num >5 &&  personaje.getHabilidad_artistica()+num < 99){
			personaje.setHabilidad_artistica(personaje.getHabilidad_artistica()+num);
		}
		if ( hab == "historia" && personaje.getHistoria()+num >20 &&  personaje.getHistoria()+num < 99){
			personaje.setHistoria(personaje.getHistoria()+num);
		}
		if ( hab == "historia natural" && personaje.getHistoria_natural()+num >10 &&  personaje.getHistoria_natural()+num < 99){
			personaje.setHistoria_natural(personaje.getHistoria_natural()+num);
		}
		if ( hab == "lanzar" && personaje.getLanzar()+num >25 &&  personaje.getLanzar()+num < 99){
			personaje.setLanzar(personaje.getLanzar()+num);
		}
		if ( hab == "lengua propia" && personaje.getLengua_propia()+num > personaje.getEducacion()*5 &&  personaje.getLengua_propia()+num < 99){
			personaje.setLengua_propia(personaje.getLengua_propia()+num);
		}
		if ( hab == "lanzar" && personaje.getLanzar()+num >25 &&  personaje.getLanzar()+num < 99){
			personaje.setLanzar(personaje.getLanzar()+num);
		}
		if ( hab == "mecanica" && personaje.getMecanica()+num >20 &&  personaje.getMecanica()+num < 99){
			personaje.setMecanica(personaje.getMecanica()+num);
		}
		if ( hab == "medicina" && personaje.getMedicina()+num >5 &&  personaje.getMedicina()+num < 99){
			personaje.setMedicina(personaje.getMedicina()+num);
		}
		if ( hab == "mitos Cthulu" && personaje.getMitos_Cthulu()+num >0 &&  personaje.getMitos_Cthulu()+num < 99){
			personaje.setMitos_Cthulu(personaje.getMitos_Cthulu()+num);
		}
		if ( hab == "nadar" && personaje.getNadar()+num >25 &&  personaje.getNadar()+num < 99){
			personaje.setNadar(personaje.getNadar()+num);
		}
		if ( hab == "ocultar" && personaje.getOcultar()+num >15 &&  personaje.getOcultar()+num < 99){
			personaje.setOcultar(personaje.getOcultar()+num);
		}
		if ( hab == "ocultarse" && personaje.getOcultarse()+num >10 &&  personaje.getOcultarse()+num < 99){
			personaje.setOcultarse(personaje.getOcultarse()+num);
		}
		if ( hab == "ocultarse" && personaje.getOcultarse()+num >10 &&  personaje.getOcultarse()+num < 99){
			personaje.setOcultarse(personaje.getOcultarse()+num);
		}
		if ( hab == "orientarse" && personaje.getOrientarse()+num >10 &&  personaje.getOrientarse()+num < 99){
			personaje.setOrientarse(personaje.getOrientarse()+num);
		}
		if ( hab == "otras lenguas" && personaje.getOtras_lenguas()+num >1 &&  personaje.getOtras_lenguas()+num < 99){
			personaje.setOtras_lenguas(personaje.getOtras_lenguas()+num);
		}
		if ( hab == "persuasion" && personaje.getPersuasion()+num >15 &&  personaje.getPersuasion()+num < 99){
			personaje.setPersuasion(personaje.getPersuasion()+num);
		}
		if ( hab == "pilotar" && personaje.getPilotar()+num >1 &&  personaje.getPilotar()+num < 99){
			personaje.setPilotar(personaje.getPilotar()+num);
		}
		if ( hab == "primeros auxilios" && personaje.getPrimeros_auxilios()+num >30 &&  personaje.getPrimeros_auxilios()+num < 99){
			personaje.setPrimeros_auxilios(personaje.getPrimeros_auxilios()+num);
		}
		if ( hab == "psicoanalisis" && personaje.getPsicoanalisis()+num >1 &&  personaje.getPsicoanalisis()+num < 99){
			personaje.setPsicoanalisis(personaje.getPsicoanalisis()+num);
		}
		if ( hab == "psicologia" && personaje.getPsicologia()+num >5 &&  personaje.getPsicologia()+num < 99){
			personaje.setPsicologia(personaje.getPsicologia()+num);
		}
		if ( hab == "quimica" && personaje.getQuimica()+num >1 &&  personaje.getQuimica()+num < 99){
			personaje.setQuimica(personaje.getQuimica()+num);
		}
		if ( hab == "regatear" && personaje.getRegatear()+num >5 &&  personaje.getRegatear()+num < 99){
			personaje.setRegatear(personaje.getRegatear()+num);
		}
		if ( hab == "saltar" && personaje.getSaltar()+num >25 &&  personaje.getSaltar()+num < 99){
			personaje.setSaltar(personaje.getSaltar()+num);
		}
		if ( hab == "seguir rastros" && personaje.getSeguir_rastros()+num >10 &&  personaje.getSeguir_rastros()+num < 99){
			personaje.setSeguir_rastros(personaje.getSeguir_rastros()+num);
		}
		if ( hab == "trepar" && personaje.getTrepar()+num >40 &&  personaje.getTrepar()+num < 99){
			personaje.setTrepar(personaje.getTrepar()+num);
		}
		if ( hab == "sigilo" && personaje.getSigilo()+num >30 &&  personaje.getSigilo()+num < 99){
			personaje.setSigilo(personaje.getSigilo()+num);
		}
		if ( hab == "ametralladora" && personaje.getAmetralladora()+num >15 &&  personaje.getAmetralladora()+num < 99){
			personaje.setAmetralladora(personaje.getAmetralladora()+num);
		}
		if ( hab == "arma corta" && personaje.getArma_corta()+num >20 &&  personaje.getArma_corta()+num < 99){
			personaje.setArma_corta(personaje.getArma_corta()+num);
		}
		if ( hab == "escopeta" && personaje.getEscopeta()+num >30 &&  personaje.getEscopeta()+num < 99){
			personaje.setEscopeta(personaje.getEscopeta()+num);
		}
		if ( hab == "fusil" && personaje.getFusil()+num >25 &&  personaje.getFusil()+num < 99){
			personaje.setFusil(personaje.getFusil()+num);
		}
		if ( hab == "subfusil" && personaje.getSubfusil()+num >15 &&  personaje.getSubfusil()+num < 99){
			personaje.setSubfusil(personaje.getSubfusil()+num);
		}
		if ( hab == "cabezazo" && personaje.getCabezazo()+num >10 &&  personaje.getCabezazo()+num < 99){
			personaje.setCabezazo(personaje.getCabezazo()+num);
		}
		if ( hab == "patada" && personaje.getPatada()+num >25 &&  personaje.getPatada()+num < 99){
			personaje.setPatada(personaje.getPatada()+num);
		}
		if ( hab == "presa" && personaje.getPresa()+num >25 &&  personaje.getPresa()+num < 99){
			personaje.setPresa(personaje.getPresa()+num);
		}
		if ( hab == "punetazo" && personaje.getPunetazo()+num >50 &&  personaje.getPunetazo()+num < 99){
			personaje.setPunetazo(personaje.getPunetazo()+num);
		}
		if ( hab == "cuchillo" && personaje.getCuchillo()+num >10 &&  personaje.getCuchillo()+num < 99){
			personaje.setCuchillo(personaje.getCuchillo()+num);
		}
		if ( hab == "bayoneta" && personaje.getBayoneta()+num >10 &&  personaje.getBayoneta()+num < 99){
			personaje.setBayoneta(personaje.getBayoneta()+num);
		}
		
			/*


		this.puñetazo=50;
		this.cuchillo=10;
		this.bayoneta=10;
		*/
	}
}
