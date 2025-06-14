package co.edu.iudigital.pos;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.jupiter.api.Test;

class HexagonalArchitectureTest {

    private final JavaClasses importedClasses =
            new ClassFileImporter().importPackages("co.edu.iudigital.pos");

    // @Test
    void controllersShouldOnlyDependOnServicesAndDomains() {
        ArchRuleDefinition.classes()
                .that().resideInAPackage("..controller..")
                .should().onlyDependOnClassesThat()
                .resideInAnyPackage(
                        "co.edu.iudigital.pos.controller..",
                        "co.edu.iudigital.pos.service..",
                        "co.edu.iudigital.pos.domain..",
                        "java..",
                        "org.springframework.."
                )
                .check(importedClasses);
    }

    // @Test
    void servicesShouldOnlyDependOnPortsAndDomains() {
        ArchRuleDefinition.classes()
                .that().resideInAPackage("..service..")
                .should().onlyDependOnClassesThat()
                .resideInAnyPackage(
                        "co.edu.iudigital.pos.service..",
                        "co.edu.iudigital.pos.port..",
                        "co.edu.iudigital.pos.domain..",
                        "java.."
                )
                .check(importedClasses);
    }

    // @Test
    void adaptersShouldOnlyDependOnDomainsAndInfrastructureAndPorts() {
        ArchRuleDefinition.classes()
                .that().resideInAPackage("..adapter..")
                .should().onlyDependOnClassesThat()
                .resideInAnyPackage(
                        "co.edu.iudigital.pos.adapter..",
                        "co.edu.iudigital.pos.domain..",
                        "co.edu.iudigital.pos.infrastructure..",
                        "co.edu.iudigital.pos.port..",
                        "org.mapstruct..",
                        "java.."
                )
                .check(importedClasses);
    }

    // @Test
    void domainsShouldOnlyDependOnDomainsAndInfrastructureAndPorts() {
        ArchRuleDefinition.classes()
                .that().resideInAPackage("..domain..")
                .should().onlyDependOnClassesThat()
                .resideInAnyPackage(
                        "co.edu.iudigital.pos.domain..",
                        "com.fasterxml.jackson..",
                        "lombok..",
                        "java.."
                )
                .check(importedClasses);
    }
}
