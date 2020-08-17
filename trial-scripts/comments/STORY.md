# story

Okay, I just tried the groovy doc concept

```bash
$ cat groovyDoc.groovy
/**
 * A Class description
 */
class Person {
    /** the name of the person */
    String name

    /**
     * Creates a greeting method for a certain person.
     *
     * @param otherPerson the person to greet
     * @return a greeting message
     */
    String greet(String otherPerson) {
       "Hello ${otherPerson}"
    }
}
```

```bash
$ groovy groovyDoc.groovy
Caught: groovy.lang.GroovyRuntimeException: This script or class could not be run.
It should either:
- have a main method,
- be a JUnit test or extend GroovyTestCase,
- implement the Runnable interface,
- or be compatible with a registered script runner. Known runners:
  * org.apache.groovy.plugin.DefaultRunners$Junit3TestRunner
  * org.apache.groovy.plugin.DefaultRunners$Junit3SuiteRunner
  * org.apache.groovy.plugin.DefaultRunners$Junit4TestRunner
  * groovy.junit5.plugin.JUnit5Runner
  * org.apache.groovy.plugin.testng.TestNgRunner

groovy.lang.GroovyRuntimeException: This script or class could not be run.
It should either:
- have a main method,
- be a JUnit test or extend GroovyTestCase,
- implement the Runnable interface,
- or be compatible with a registered script runner. Known runners:
  * org.apache.groovy.plugin.DefaultRunners$Junit3TestRunner
  * org.apache.groovy.plugin.DefaultRunners$Junit3SuiteRunner
  * org.apache.groovy.plugin.DefaultRunners$Junit4TestRunner
  * groovy.junit5.plugin.JUnit5Runner
  * org.apache.groovy.plugin.testng.TestNgRunner

	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
```

```bash
$ cat groovyDoc.groovy
/**
 * A Class description
 */
class Person {
    /** the name of the person */
    String name

    /**
     * Creates a greeting method for a certain person.
     *
     * @param otherPerson the person to greet
     * @return a greeting message
     */
    String greet(String otherPerson) {
       "Hello ${otherPerson}"
    }

    static void main(String[] args) {
        println greet("Karuppiah")
    }
}

$ groovy groovyDoc.groovy
Caught: groovy.lang.MissingMethodException: No signature of method: static Person.greet() is applicable for argument types: (String) values: [Karuppiah]
Possible solutions: greet(java.lang.String), grep(), grep(java.lang.Object), getAt(java.lang.String), print(java.io.PrintWriter), sleep(long)
groovy.lang.MissingMethodException: No signature of method: static Person.greet() is applicable for argument types: (String) values: [Karuppiah]
Possible solutions: greet(java.lang.String), grep(), grep(java.lang.Object), getAt(java.lang.String), print(java.io.PrintWriter), sleep(long)
	at Person.main(groovyDoc.groovy:19)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
```

So, I tried to call a non-static method from a static method! 😅 That's why it's
looking for a static method named `greet` with that contract!

I converted the `greet` method to static and it worked :)

```bash
$ groovy groovyDoc.groovy
Hello Karuppiah
```

Now I checked how to do documentation a bit here

https://www.infoworld.com/article/2074120/documenting-groovy-with-groovydoc.html

```bash
$ groovydoc -h
Usage: groovydoc [options] [packagenames] [sourcefiles]
GroovyDoc is a tool responsible for generating documentation from your code. It
acts like the Javadoc tool in the Java world but is capable of handling both
groovy and java files.
      -author               Include @author paragraphs (currently not used)
      -charset=<charset>    Charset for cross-platform viewing of generated
                              documentation
      -classpath            Specify where to find the class files - must be
                              first argument
      -cp, --classpath      Aliases for '-classpath'
  -d, --destdir=<dir>       Destination directory for output files
      --debug               Enable debug output
      -doctitle=<html>      Include title for the overview page
      -exclude=<pkglist>    Specify a list of packages to exclude (separated by
                              colons for all operating systems)
      -fileEncoding=<charset>
                            Charset for generated documentation files
      -footer=<html>        Include footer text for each page
  -h, -help, --help         Display this help message
      -header=<html>        Include header text for each page
      -nomainforscripts     Don't include the implicit 'public static void
                              main' method for scripts
      -noscripts            Don't process Groovy Scripts
      -notimestamp          Don't include timestamp within hidden comment in
                              generated HTML
      -noversionstamp       Don't include Groovy version within hidden comment
                              in generated HTML
      -overview=<file>      Read overview documentation from HTML file
      -package              Show package/protected/public classes and members
      -private              Show all classes and members
      -protected            Show protected/public classes and members (default)
      -public               Show only public classes and members
      -quiet                Suppress superfluous output
      -sourcepath=<pathlist>
                            Specify where to find source files (dirs separated
                              by platform path separator)
      -stylesheetfile=<path>
                            File to change style of the generated documentation
      -verbose              Enable verbose output
      --version             Display the version
      -windowtitle=<text>   Browser window title for the documentation
```

```bash
$ groovydoc -d docOutput groovyDoc.groovy
$ open docOutput/index-all.html
$ open docOutput/index.html
```
