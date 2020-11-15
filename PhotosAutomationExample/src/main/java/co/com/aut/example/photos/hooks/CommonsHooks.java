package co.com.aut.example.photos.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CommonsHooks {
	private boolean pruebaexitosa = true;

	@After(order = 1, value = "@consultarfoto")
	public void downScenario1() {
		System.out.println("JAG4hola after steps2commonshook");
		if (!pruebaexitosa) {
			System.out.println("**********JAGvalor pruebaexitosa " + pruebaexitosa + "****");
			System.out.println("********************Prueba Hook PhotoSteps2 After*********************");

		}
	}


	@After(order = 2, value = "@consultarfoto or @obtenerPhoto")
	public void downScenario() {
		System.out.println("JAG5hola after steps2commonshook");
			}
	
	@Before(order=1)
	public void setupScenario() {
		System.out.println("*******************************************************setupScenarioCommonsHookJAGPruebaPhotoSteps1 Before*********************");
	}

	

	@Before
	public void setupScenario1() {
		System.out.println("********************JAGPrueba CommonsHook PhotoSteps2 Before*********************");
	}

}
