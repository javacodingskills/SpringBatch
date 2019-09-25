package com.javacodingskills.spring.batch.demo3.job;

import com.javacodingskills.spring.batch.demo3.dto.EmployeeDTO;
import com.javacodingskills.spring.batch.demo3.mapper.EmployeeDBRowMapper;
import com.javacodingskills.spring.batch.demo3.model.Employee;
import com.javacodingskills.spring.batch.demo3.processor.EmployeeProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;

@Configuration
public class Demo3 {

    private JobBuilderFactory jobBuilderFactory;
    private StepBuilderFactory stepBuilderFactory;
    private DataSource dataSource;
    private EmployeeProcessor employeeProcessor;

    @Autowired
    public Demo3(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, EmployeeProcessor employeeProcessor, DataSource dataSource){
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.dataSource = dataSource;
        this.employeeProcessor = employeeProcessor;
    }

    private Resource outputResource = new FileSystemResource("output/employee_output.csv");

    @Qualifier(value = "demo3")
    @Bean
    public Job demo3Job() throws Exception {
        return this.jobBuilderFactory.get("demo3")
                .start(step1Demo3())
                .build();
    }

    @Bean
    public Step step1Demo3() throws Exception {
        return this.stepBuilderFactory.get("step1")
                .<Employee, EmployeeDTO>chunk(10)
                .reader(employeeDBReader())
                .processor(employeeProcessor)
                .writer(employeeFileWriter())
                .build();
    }


    @Bean
    public ItemStreamReader<Employee> employeeDBReader() {
        JdbcCursorItemReader<Employee> reader = new JdbcCursorItemReader<>();
        reader.setDataSource(dataSource);
        reader.setSql("select * from employee");
        reader.setRowMapper(new EmployeeDBRowMapper());
        return reader;
    }

    @Bean
    public ItemWriter<EmployeeDTO> employeeFileWriter() throws Exception {
        FlatFileItemWriter<EmployeeDTO> writer = new FlatFileItemWriter<>();
        writer.setResource(outputResource);
        writer.setLineAggregator(new DelimitedLineAggregator<EmployeeDTO>() {
            {
                setFieldExtractor(new BeanWrapperFieldExtractor<EmployeeDTO>() {
                    {
                        setNames(new String[]{"employeeId", "firstName", "lastName", "email", "age"});
                    }
                });
            }
        });
        writer.setShouldDeleteIfExists(true);
        return writer;
    }

}
