# identifiers story

So, I noticed that multiple values to `println` is not possible. I wrote this

```groovy
println normalName name_with_underscore $nameWithDollar 
```

And got this error

```bash
$ groovy identifierNames.groovy
normalName
Caught: java.lang.NullPointerException: Cannot invoke method name_with_underscore() on null object
java.lang.NullPointerException: Cannot invoke method name_with_underscore() on null object
        at identifierNames.run(identifierNames.groovy:9)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
```

And when I missed to initialize the map for the interpolated strings example,
I got this

```bash
$ groovy gStringsOrInterpolatedStrings.groovy
Caught: groovy.lang.MissingPropertyException: No such property: map for class: gStringsOrInterpolatedStrings
groovy.lang.MissingPropertyException: No such property: map for class: gStringsOrInterpolatedStrings
        at gStringsOrInterpolatedStrings.run(gStringsOrInterpolatedStrings.groovy:4)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
```

I also noticed that I could pass multiple groovy files to `groovy`, but it wasn't
running them all, as it didn't show any errors for the interpolated strings
file even though it had one and bubbled up only when I ran it standalone, also,
even the printing didn't happen for the identifier names, until I put it as the
first groovy file. Hmm


