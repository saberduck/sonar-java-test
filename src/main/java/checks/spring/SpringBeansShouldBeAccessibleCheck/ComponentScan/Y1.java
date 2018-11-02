package checks.spring.SpringBeansShouldBeAccessibleCheck.ComponentScan;
import org.springframework.stereotype.Component;
// need to be on line 5 to avoid clashes in case of failure
@Component
class Y1 {} // Compliant
