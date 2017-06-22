# Java Testing Toolbox

[![Maven Central](https://img.shields.io/maven-central/v/com.github.qacore/java-testing-toolbox.svg)](http://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22com.github.qacore%22%20AND%20a%3A%22java-testing-toolbox%22) 
[![Build Status](https://travis-ci.org/QACore/Java-Testing-Toolbox.svg?branch=master)](https://travis-ci.org/QACore/Java-Testing-Toolbox)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://github.com/QACore/Java-Testing-Toolbox/blob/master/LICENSE.txt)

This is a framework for writing maintainable [Selenium](https://github.com/SeleniumHQ/selenium), [Appium](https://github.com/appium/appium), REST API and others tests that also makes integrating much easier.

## Full Documentation

See the [Wiki](https://github.com/QACore/Java-Testing-Toolbox/wiki) for full documentation, examples, operational details and other information.

## Continuous Integration Builds

| CI Server | OS      | Status | Description |
| --------- | ------- | ------ | ----------- |
| Travis CI | Linux   | [![Build Status](https://travis-ci.org/QACore/Java-Testing-Toolbox.svg?branch=master)](https://travis-ci.org/QACore/Java-Testing-Toolbox) | Used to perform quick checks on submitted pull requests and for build matrices including JDK 8 and JDK 9 early access builds |

## Setting up

To keep up to date with the latest releases of Java Testing Toolbox, modify the following block in the pom.xml:

```xml
<dependencies>
   <dependency>
      <groupId>com.github.qacore</groupId>
      <artifactId>java-testing-toolbox</artifactId>
      <version>1.4.0</version>
   </dependency>
</dependencies>
```

## Getting Started

After setting up [apache maven][mvn], you will have support for the following features:
* [**Java Testing Toolbox Configuration**](https://github.com/QACore/Java-Testing-Toolbox/wiki/Java-Testing-Toolbox-Configuration)
   * *JUnit Configuration*
   * *Selenium Configuration*
      * *Chrome*
      * *Edge*
      * *Firefox*
      * *HtmlUnit*
      * *Internet Explorer*
      * *Opera*
      * *PhantomJS*
      * *Safari*
* [**JUnit**](https://github.com/QACore/Java-Testing-Toolbox/wiki/JUnit)
   * *Categories*
   * *Runners*
      * *Parallel*
      * *Parallel Categories*
      * *Parallel Parameterized*
      * *Parallel Suite*
* [**Selenium**](https://github.com/QACore/Java-Testing-Toolbox/wiki/Selenium)
   * *Parallel*
      * *WebDriver Manager*
      * *Managed WebDriver Context*
   * *Page Objects Pattern*
      * Page Objects
      * Login Page Objects
   * *Support*
      * *HTML5*
         * *Application Cache*
         * *Local Storage*
         * *Web Storage*
         * *Session Storage*

## Authors

* **[Leonardo Carmona da Silva]** - *Product Owner and Software Architect* - [LeoCarmona](https://github.com/LeoCarmona) on [LinkedIn](https://www.linkedin.com/in/l3ocarmona/)

See also the list of [contributors](https://github.com/QACore/Java-Testing-Toolbox/graphs/contributors) who participated in this project.

## License

This project is licensed under the Apache License 2.0 - see the [LICENSE.txt](LICENSE.txt) file for details

[mvn]: https://maven.apache.org/download.cgi
