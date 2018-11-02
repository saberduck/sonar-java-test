package checks.spring.SpringBeansShouldBeAccessibleCheck.ComponentScan;

import org.springframework.stereotype.Component;
// need to be on line 6 to avoid clashes in case of failure
@Component
class Y2 {} // Compliant
