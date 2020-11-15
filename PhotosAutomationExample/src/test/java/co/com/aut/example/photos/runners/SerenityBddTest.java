package co.com.aut.example.photos.runners;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.com.aut.example.photos.abilities.InteractWithDb;
import co.com.aut.example.photos.database.DatabaseConnectionInfo;
import co.com.aut.example.photos.database.DatabaseType;
import co.com.aut.example.photos.database.entity.Example;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SerenityRunner.class)
public class SerenityBddTest {


    @Test
    public void dataBaseConnectionTest() {
    	System.out.println("JAG20201115-TestJPABDMySql");
        DatabaseConnectionInfo connectionInfo = DatabaseConnectionInfo
                .builder()
                .username("root")
                .databaseType(DatabaseType.MYSQL)
                .url("jdbc:mysql://localhost/test_automation")
                .password("my-secret-pw")
                .entityNames(Stream.of(
                        Example.class)
                        .map(Class::getName)
                        .collect(Collectors.toList()))
                .build();


        Actor julian = Actor.named("julian");
        julian.can(InteractWithDb.using(connectionInfo));

        EntityManager entityManager = InteractWithDb.as(julian).getManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Example> criteriaQuery = criteriaBuilder
                .createQuery(Example.class);

        Root<Example> userRoot = criteriaQuery.from(Example.class);

        Example queryResult = entityManager
                .createQuery(criteriaQuery
                        .select(userRoot))
                .getSingleResult();

        System.out.println(queryResult);
    }
}