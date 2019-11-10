package dao;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PersistenceProperties {

	private static final String JDBC_URL = "JDBC_URL";

	private static final String JDBC_USER = "JDBC_USER";

	private static final String JDBC_PASSWORD = "JDBC_PASSWORD";

	/**
	 * Procura por propriedades que ir�o sobrescrever o persistence.xml. A procura �
	 * feita na pasta home do usu�rio, em vari�veis de ambiente e em propriedades
	 * passadas na inicializa��o do processo Java.
	 * 
	 * @return Properties propriedades que ir�o sobrescrever o persistence.xml
	 * @throws Exception
	 */
	public Properties get() {
		try {
			Properties props = new Properties();

			props.putAll(userHomeJdbcFile());// Digital Ocean

			// Se esse m�todo (systemEnv) retornar alguma propriedade, igual a que o m�todo
			// anterior
			// tenha configurado, ela ir� prevalecer.
			props.putAll(systemEnv()); // Heroku

			// Se esse m�todo (javaPropertyJdbcFile()) retornar alguma propriedade, igual a
			// que o m�todo anterior
			// tenha configurado, ela ir� prevalecer.
			props.putAll(javaPropertyJdbcFile());

			// Se esse m�todo (javaProperties()) retornar alguma propriedade, igual a que o
			// m�todo anterior
			// tenha configurado, ela ir� prevalecer.
			props.putAll(javaProperties());

			return props;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Verifica a exist�ncia de um arquivo jdbc.properties na pasta home do usu�rio.
	 * Caso exista, ele ir� ler as propriedades que est�o dentro dele.
	 * 
	 * A chave das propriedades desse arquivo devem ser iguais ao nome da
	 * propriedade do persistence.xml que se deseja sobreescrever.
	 * 
	 * @return Properties propriedades que ir�o sobrescrever o persistence.xml
	 * @throws Exception
	 */
	private Properties userHomeJdbcFile() throws Exception {
		Properties props = new Properties();

		File fileProperties = new File(System.getProperty("user.home"), "jdbc.properties");

		if (fileProperties.exists()) {
			props.load(new FileInputStream(fileProperties));
		}

		return props;
	}

	/**
	 * Verifica a exist�ncia de vari�veis de ambiente que ser�o usadas para
	 * sobrescrever as propriedades do persistence.xml.
	 * 
	 * A vari�vel de ambiente para url, usu�rio e senha devem ter o mesmo nome dos
	 * valores das propriedades est�ticas {@link #JDBC_URL}, {@link #JDBC_USER} e
	 * {@link #JDBC_PASSWORD} respectivamente.
	 * 
	 * @return Properties propriedades que ir�o sobrescrever o persistence.xml
	 * @throws Exception
	 */
	private Properties systemEnv() {
		Properties props = new Properties();

		if (System.getenv().containsKey(JDBC_URL)) {
			props.put("javax.persistence.jdbc.url", System.getenv(JDBC_URL));
		}

		if (System.getenv().containsKey(JDBC_USER)) {
			props.put("javax.persistence.jdbc.user", System.getenv(JDBC_USER));
		}

		if (System.getenv().containsKey(JDBC_PASSWORD)) {
			props.put("javax.persistence.jdbc.password", System.getenv(JDBC_PASSWORD));
		}

		return props;
	}

	/**
	 * Verifica a exist�ncia de um par�metro Java passado na inicializa��o da
	 * aplica��o. Esse par�metro deve se chamar "jdbc-file", portanto ser� passado
	 * dessa forma "-Djdbc-file=/caminho/jdbc.properites".
	 * 
	 * A chave das propriedades desse arquivo devem ser iguais ao nome da
	 * propriedade do persistence.xml que se deseja sobreescrever.
	 * 
	 * @return Properties propriedades que ir�o sobrescrever o persistence.xml
	 * @throws Exception
	 */
	private Properties javaPropertyJdbcFile() throws Exception {
		Properties props = new Properties();

		if (!System.getProperties().containsKey("jdbc-file")) {
			return props;
		}

		File fileProperties = new File(System.getProperty("jdbc-file"));

		if (fileProperties.exists()) {
			props.load(new FileInputStream(fileProperties));
		}

		return props;
	}

	/**
	 * Verifica a exist�ncia de propriedades Java que ser�o usadas para sobrescrever
	 * as propriedades do persistence.xml.
	 * 
	 * A propriedade Java para url, usu�rio e senha devem ter o mesmo nome dos
	 * valores das propriedades est�ticas {@link #JDBC_URL}, {@link #JDBC_USER} e
	 * {@link #JDBC_PASSWORD} respectivamente.
	 * 
	 * Caso queira sobrescrever a url, por exemplo, a propriedade a ser passada ser�
	 * "-DJDBC_URL=jdbc:mysql://url:porta/banco"
	 * 
	 * @return Properties propriedades que ir�o sobrescrever o persistence.xml
	 * @throws Exception
	 */
	private Properties javaProperties() {
		Properties props = new Properties();

		if (System.getProperties().containsKey(JDBC_URL)) {
			props.put("javax.persistence.jdbc.url", System.getProperty(JDBC_URL));
		}

		if (System.getProperties().containsKey(JDBC_USER)) {
			props.put("javax.persistence.jdbc.user", System.getProperty(JDBC_USER));
		}

		if (System.getProperties().containsKey(JDBC_PASSWORD)) {
			props.put("javax.persistence.jdbc.password", System.getProperty(JDBC_PASSWORD));
		}

		return props;
	}
}
