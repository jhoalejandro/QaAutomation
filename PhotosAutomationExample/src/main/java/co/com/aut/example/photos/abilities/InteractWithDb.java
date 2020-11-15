package co.com.aut.example.photos.abilities;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;

import javax.persistence.EntityManager;

import co.com.aut.example.photos.database.DatabaseConnectionInfo;
import co.com.aut.example.photos.database.persistence.manager.JpaEntityManagerFactory;

public class InteractWithDb implements Ability {

	private EntityManager entityManager;

	public EntityManager getManager() {
		return entityManager;
	}

	public InteractWithDb(DatabaseConnectionInfo databaseConnectionInfo) {
		this.entityManager = new JpaEntityManagerFactory(databaseConnectionInfo).getEntityManager();
	}

	public static InteractWithDb using(DatabaseConnectionInfo databaseConnectionInfo) {
		return new InteractWithDb(databaseConnectionInfo);
	}

	public static InteractWithDb as(Actor actor) {
		return actor.abilityTo(InteractWithDb.class);
	}
}