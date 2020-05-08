package se.lexicon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import se.lexicon.data_access.*;

import java.util.Scanner;

@Configuration
@ComponentScan("app")
public class ComponentScanConfig {

    @Bean
    public StudentDao studentDao(){
        return new StudentDaoImpl();
    }

    @Bean
    public UserInputService inputService(){
        return new ScannerInputService(new Scanner(System.in));
    }

    @Bean
    public StudentManagement studentManagement(){
        return new StudentManagementConsoleImpl(inputService(),studentDao());
    }

}
