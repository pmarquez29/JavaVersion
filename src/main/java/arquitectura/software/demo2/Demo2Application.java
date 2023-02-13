package arquitectura.software.demo2;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo2Application {
	private static final Logger logger = LoggerFactory.getLogger(Demo2Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);

		LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();

		JoranConfigurator configurator = new JoranConfigurator();
		configurator.setContext(context);
		context.reset();
		try {
			//ObjectMapper mapper = new ObjectMapper();

			configurator.doConfigure("src/main/java/logback.xml");
		} catch (JoranException e) {
			throw new RuntimeException(e);
		}
		StatusPrinter.printInCaseOfErrorsOrWarnings(context);
	}
}
