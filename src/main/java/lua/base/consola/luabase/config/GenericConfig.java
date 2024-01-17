package lua.base.consola.luabase.config;

import lua.base.consola.luabase.visual.controllers.BaseConsoleController;
import lua.base.consola.luabase.visual.frames.ConsoleFrame;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GenericConfig {
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

	@Bean
	public ConsoleFrame consoleFrame(BaseConsoleController consoleController) {
		try {
			return new ConsoleFrame(consoleController);
		} catch (Exception e) {
			e.printStackTrace();
			throw e; // rethrow the exception to ensure Spring context loading fails as before
		}
	}
}
