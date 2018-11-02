package checks.spring.SpringBeansShouldBeAccessibleCheck.ComponentScan;

import org.springframework.stereotype.Component;

// need to be on line 7 to avoid clashes in case of failure
@Component
class Z2 {} // Compliant
