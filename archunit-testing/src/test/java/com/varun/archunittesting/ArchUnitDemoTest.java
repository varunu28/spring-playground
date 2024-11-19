package com.varun.archunittesting;

import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.core.domain.properties.CanBeAnnotated.Predicates.annotatedWith;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static de.rweisleder.archunit.spring.SpringAnnotationPredicates.springAnnotatedWith;

@AnalyzeClasses(packagesOf = ArchunitTestingApplication.class, importOptions = DoNotIncludeTests.class)
public class ArchUnitDemoTest {

    // Test for naming conventions
    @ArchTest ArchRule ControllerNaming = classes()
        .that().areAnnotatedWith(RestController.class)
        .should().haveSimpleNameEndingWith("Controller");

    @ArchTest ArchRule ServiceNaming = classes()
        .that().areAnnotatedWith(Service.class)
        .should().haveSimpleNameEndingWith("Service");

    @ArchTest ArchRule RepositoryNaming = classes()
        .that().areAnnotatedWith(Repository.class)
        .should().haveSimpleNameEndingWith("Repository");

    // Test for package location
    @ArchTest ArchRule ControllerPackageLocation = classes()
        .that(springAnnotatedWith(Controller.class))
        .should().resideInAPackage("..controller..");

    @ArchTest ArchRule ServicePackageLocation = classes()
        .that().areAnnotatedWith(Service.class)
        .should().resideInAPackage("..service..");

    @ArchTest ArchRule RepositoryPackageLocation = classes()
        .that().areAnnotatedWith(Repository.class)
        .should().resideInAPackage("..repository..");

    @ArchTest ArchRule ExceptionsInExceptionPackage = classes()
        .that().haveSimpleNameEndingWith("Exception")
        .should().resideInAPackage("..exception..");

    // Test for all exceptions extending RuntimeException
    @ArchTest ArchRule ExceptionsShouldExtendRuntimeException = classes()
        .that().haveSimpleNameEndingWith("Exception")
        .should().beAssignableTo(RuntimeException.class);

    // Test for layered architecture
    @ArchTest
    ArchRule Layers = Architectures.layeredArchitecture()
        .consideringOnlyDependenciesInLayers()
        .layer("Controller").definedBy(annotatedWith(RestController.class))
        .layer("Service").definedBy(annotatedWith(Service.class))
        .layer("Repository").definedBy(annotatedWith(Repository.class))
        .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
        .whereLayer("Repository").mayOnlyBeAccessedByLayers("Service")
        .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller");
}
