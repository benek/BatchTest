package mx.sintelti.tests.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

/**
 * Author: Javier Ramirez Jr
 * Date: 31/12/17
 * Time: 20:15
 * Project: SpringBatchTest
 * www.sintelti.mx
 */
public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public Person process(final Person person) throws Exception{

        final String firstName = person.getFirstName().toUpperCase();
        final String lastName = person.getLastName().toUpperCase();

        final Person transformedPerson = new Person(firstName, lastName);

        log.info("Converting -{}- into -{}-.", person, transformedPerson);

        return transformedPerson;
    }

}
