package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.bean.IMyBeanWithDependency;
import com.fundamentos.springboot.fundamentos.bean.MyBean;
import com.fundamentos.springboot.fundamentos.bean.IMyPersonalDependency;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.springboot.fundamentos.components.IComponentDependency;
import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.pojo.UserPojo;
import com.fundamentos.springboot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;

import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	/*Para hacer la inyeccion de dependencia ya no es necesario escribir el @Autowired en versiones recientes de spring
	entonces se puede hacer de esta forma.
	Otra cosa, al hacer la inyeccion de dependencias de esta forma(en el constructor)
	permite inyectar un Mock en las pruebas unitarias.
	Asi que, de esta forma se considera una mejor practica que solo con:

	@Autowired
	private IComponentDependency iComponentDependency;

	* */
	private IComponentDependency iComponentDependency;
	private MyBean myBean;
	private IMyBeanWithDependency iMyBeanWithDependency;
	private IMyPersonalDependency myPersonalDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;

	/*Cuando se haga mas de una implementacion de una dependencia, al momento de inyectarla
	* de debe indicar por medio de @Qualifier el nombre de la dependencia que queremos implementar
	* ya que hay dos implementaciones diferentes.*/
	public FundamentosApplication(@Qualifier("componentTwoImplement") IComponentDependency iComponentDependency, MyBean myBean,
								  IMyBeanWithDependency iMyBeanWithDependency, MyBeanWithProperties myBeanWithProperties,UserPojo userPojo, UserRepository userRepository){
		this.iComponentDependency = iComponentDependency;
		this.myBean = myBean;
		this.iMyBeanWithDependency = iMyBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//previousExamples();
		saveUser();
		getUserInformation();
	}

	public void previousExamples(){
		iComponentDependency.sayHello();
		myBean.print();
		iMyBeanWithDependency.printWithDependency();
		//myPersonalDependency.personInformation();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail()+"-"+userPojo.getPassword());
		LOGGER.error("Esto es un error de la aplicacion");
	}

	private void saveUser(){
		User user = new User("Alejandro", "Escobar", "alejo@hotmail.com", LocalDate.of(2022, 05, 01));
		User user2 = new User("Alejandra", "Salamanca", "aleja@hotmail.com", LocalDate.of(1998, 05, 01));
		User user3 = new User("Valeria", "Arce", "valeria@hotmail.com", LocalDate.of(1995, 05, 01));
		User user4 = new User("Daniel", "Ruiz", "daniel@hotmail.com", LocalDate.of(1996, 05, 01));
		User user5 = new User("Oriana", "Gracia", "oriana@hotmail.com", LocalDate.of(2000, 05, 01));
		User user6 = new User("Janeth", "Marin", "naneth@hotmail.com", LocalDate.of(1994, 05, 01));
		User user7 = new User("Diego", "Rodriguez", "diego@hotmail.com", LocalDate.of(2005, 05, 01));

		List<User> userList = Arrays.asList(user, user2, user3, user4, user5, user6, user7);

		userList.stream().forEach(userRepository::save);
	}

	public void getUserInformation(){
		LOGGER.info("Se encontro el usuario "+ userRepository.findByUserEmail("alejo@hotmail.com")
				.orElseThrow(() -> new RuntimeException("No se ha encontrado ningun usuario con ese correo")));


		userRepository.findAndSort("Alej", Sort.by("id").descending())
				.stream().forEach(user -> LOGGER.info("Usuario con metoro sort"+ user));

	}
}
