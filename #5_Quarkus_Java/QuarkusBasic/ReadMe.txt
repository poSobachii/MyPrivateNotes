mvn io.quarkus:quarkus-maven-plugin:0.13.1:create \
    -DprojectGroupId=quarkusSimpleApp \
    -DprojectArtifactId=quarkus-simple-app \
	-DclassName="quarkusSimpleApp.HelloResource" \
	-Dpath="/hello"
// This will generate the project skeleton, a HelloResource with a /hello endpoint exposed, configuration, Maven project, and Dockerfiles.

./mvnw compile quarkus:dev
// to run quarkus server. running in :dev environmets enables hot swap
// to stop properly , type "q"

./mvnw package
//to compile into jar file

java -jar target/quarkus-simple-app-1.0-SNAPSHOT-runner.jar
// to run jar file

./mvnw package -Pnative
// you need Graalvm to run native
// Graalvm is not ready for Java 11*

// install Graalvm
// export JAVA_HOME=/Library/Java/JavaVirtualMachines/graalvm-ce-java11-21.2.0/Contents/Home
// export PATH=/Library/Java/JavaVirtualMachines/graalvm-ce-java11-21.2.0/Contents/Home/bin:$PATH
// xattr -r -d com.apple.quarantine /Library/Java/JavaVirtualMachines/graalvm-ce-java11-21.2.0

// to return back to normal java
// export JAVA_HOME=/usr/local/Cellar/openjdk@11/11.0.12/libexec/openjdk.jdk/Contents/Home
// export PATH=/usr/local/Cellar/openjdk@11/11.0.12/libexec/openjdk.jdk/Contents/Home/bin:$PATH

// comment Application.class , dependencies in pom.xml should run +- quarkus from void main method as usual
for further tutorial proceed to https://www.baeldung.com/quarkus-io

