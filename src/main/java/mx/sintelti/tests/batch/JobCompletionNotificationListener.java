package mx.sintelti.tests.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Author: Javier Ramirez Jr
 * Date: 31/12/17
 * Time: 21:03
 * Project: SpringBatchTest
 * www.sintelti.mx
 */

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution){
        if (jobExecution.getStatus() == BatchStatus.COMPLETED){
            log.info("Job finished! Time to verify the results ;)");

            List<Person> results = jdbcTemplate.query(
                    "SELECT first_name, last_name FROM people", new RowMapper<Person>() {
                @Override
                public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return new Person(rs.getString(1), rs.getString(2));
                }
            });

            for (Person person : results){
                log.info("Found -{}- in the database.", person);
            }
        }
    }

}
