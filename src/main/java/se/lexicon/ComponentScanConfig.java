package se.lexicon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import se.lexicon.data_access.*;
import se.lexicon.model.Student;

import java.util.List;
import java.util.Scanner;

@Configuration
    @ComponentScan("app")
    public class ComponentScanConfig {

        @Bean
        public StudentDao studentDao(){
            StudentDao studentDao = new StudentDaoImpl();
            return studentDao;
        }

        @Bean
        public UserInputService inputService(){
            UserInputService inputService = new ScannerInputService(new Scanner(System.in));
            return inputService;
        }

        @Bean
        public StudentManagement studentManagement(){
            StudentManagement studentManagement = new StudentManagementConsoleImpl(inputService(),studentDao());
            return studentManagement;
        }

}
