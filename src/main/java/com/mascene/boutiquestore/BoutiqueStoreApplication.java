package com.mascene.boutiquestore;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mascene.ui.AppLoginPage;

/**
 * @author Raman.Ahuja
 * 
 *         Main Class to run the Boutique store
 *
 */
@SpringBootApplication
@ComponentScan({ "com.mascene.*" })
@EnableJpaRepositories("com.mascene.repository")
@EntityScan("com.mascene.entities")
@EnableTransactionManagement
public class BoutiqueStoreApplication {

	public static void main(String[] args) {
		ApplicationContext appContext = new SpringApplicationBuilder(BoutiqueStoreApplication.class).headless(false)
				.run(args);
		AppLoginPage appLogin = appContext.getBean(AppLoginPage.class);
		appLogin.setVisible(true);
	}

}
