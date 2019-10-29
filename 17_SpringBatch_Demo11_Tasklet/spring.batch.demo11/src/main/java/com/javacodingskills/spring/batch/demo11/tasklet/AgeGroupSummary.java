package com.javacodingskills.spring.batch.demo11.tasklet;

import com.javacodingskills.spring.batch.demo11.dto.EmployeeDTO;
import com.javacodingskills.spring.batch.demo11.utils.Constants;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.util.CollectionUtils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AgeGroupSummary implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {

        try (Stream<String> employees = Files.lines(Paths.get(Constants.FILE_PATH_EMPCSV))) {

            List<EmployeeDTO> employeeDTOList = employees.map((strData) -> strData.split(","))
                    .map(AgeGroupSummary::employeeMapper)
                    .collect(Collectors.toList());


            if (!CollectionUtils.isEmpty(employeeDTOList)) {
                Map<Integer, Long> ageGropuMap = employeeDTOList.stream()
                        .collect(Collectors.groupingBy(EmployeeDTO::getAge, Collectors.counting()));


                System.out.println(ageGropuMap);

                //todo
            }

        }

        return RepeatStatus.FINISHED;
    }

    private static EmployeeDTO employeeMapper(String[] record) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployeeId(record[0]);
        employeeDTO.setFirstName(record[1]);
        employeeDTO.setLastName(record[2]);
        employeeDTO.setEmail(record[3]);
        employeeDTO.setAge(Integer.parseInt(record[4]));
        return employeeDTO;
    }
}
