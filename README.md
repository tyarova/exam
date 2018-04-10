# exam
Exam Task
The task that need to be done for successful graduation from the QA Automation course

Running the tests
The tests are run on Chrome by default.

Getting Started
- Install Chrome browser;
- Set up IntelliJ IDEA. Can be downloaded through the link https://www.jetbrains.com/idea/download/#section=windows;
- Set up JDK.  Can be downloaded through the link http://www.oracle.com/technetwork/java/javase/downloads/index.html;
- Set up Maven - http://maven.apache.org/download.cgi. Set environtment variables. Instruction can be found by the link http://www.apache-maven.ru/install.html;
- Add following lines into your pom.xml build section:
<build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
        </plugins>
    </build>

- Add following lines into your pom.xml dependencies section:
     <dependencies>
              <dependency>
                <groupId>org.seleniumhq.selenium</groupId>
                <artifactId>selenium-java</artifactId>
                <version>3.9.1</version>
            </dependency>
            <dependency>
                <groupId>org.seleniumhq.selenium</groupId>
                <artifactId>selenium-support</artifactId>
                <version>3.9.1</version>
            </dependency>
            <dependency>
                <groupId>org.testng</groupId>
                <artifactId>testng</artifactId>
                <version>6.11</version>
            </dependency>
            <dependency>
                <groupId>io.github.bonigarcia</groupId>
                <artifactId>webdrivermanager</artifactId>
                <version>2.1.0</version>
            </dependency>
        </dependencies>

Running the tests
The tests are run on Chrome by default.

