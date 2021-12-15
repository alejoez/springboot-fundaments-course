package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.components.IComponentDependency;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	/*Para hacer la inyeccion de dependencia ya no es necesario escribir el @Autowired en versiones recientes de spring
	entonces se puede hacer de esta forma.
	Otra cosa, al hacer la inyeccion de dependencias de esta forma(en el constructor)
	permite inyectar un Mock en las pruebas unitarias.
	Asi que, de esta forma se considera una mejor practica que solo con:

	@Autowired
	private IComponentDependency iComponentDependency;

	* */
	private IComponentDependency iComponentDependency;
	public FundamentosApplication(IComponentDependency iComponentDependency){
		this.iComponentDependency = iComponentDependency;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		iComponentDependency.sayHello();
	}
}
