##Overview##
This is a simple library that takes leverages some of the features found in Groovy 2.4+.  The idea is to simplify
commonly applied patterns and logic in a non-intrusive way.  The tests contain the most up-to-date examples but here
are a few highlights.

##Data Generation Ability##
Sometimes you need to generate random data sets, especially during testing, and the `GenerationAbility` trait can
help.  Using it is very simple:

```
class Foo implements GenerationAbility {

    String makeSomeFakeString() {
        randomHexString()
    }
}
```

That's it!  Since the helper is implemented as a trait, you are free to override a method implementation at
will.  Try that with `@Delegate`!

##Type Enhancers##
Many time we use libraries that contain static helper methods to perform common tasks.  Using Groovy's Category
mechanism, we've enhanced some of the built in types will nice helper routines which means you no longer have to seek
out helper libraries.  Simply including the `tools-groovy` JAR in your classpath is enough to activate all of the
enhancements.  Here are few examples of the methods we've added:

```
byte[] buffer = 'some string'.utf8Bytes
byte[] clone = existingByteArray.copy()
String hash = existingByteArray.toMD5()
String hash = anInputStream.toMD5()
```

The Groovydocs and tests are the best place to look for current examples.
