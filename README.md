# JavaMultiModule
A Maven multi-module project that uses both appium and selenium without conflicts

Run 'mvn package' in the root directory. This will create two Jar files in the target folders of the appium and selenium sub-modules.

You can then import those Jars into projects that need to use Appium and Selenium.

The Appium and Selenium sub-modules also inherit shared classes from the SharedModule to handle repeated code.
