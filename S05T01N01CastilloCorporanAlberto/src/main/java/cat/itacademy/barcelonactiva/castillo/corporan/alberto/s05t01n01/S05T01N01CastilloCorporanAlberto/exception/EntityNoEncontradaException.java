package cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05t01n01.S05T01N01CastilloCorporanAlberto.exception;

public class EntityNoEncontradaException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public EntityNoEncontradaException(String mensaje) {
		super(mensaje);
	}

}
