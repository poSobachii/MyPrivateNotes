* When you configure your datasource URL (e.g., `jdbc:mysql://localhost:3306/mydatabase`), Spring Boot attempts to automatically identify the required
  driver class based on the subprotocol (the part before the `://`). In this case, `jdbc:mysql` would map to the `com.mysql.cj.jdbc.Driver` class.
  Similarly, `jdbc:postgresql` would point to `org.postgresql.Driver`, and `jdbc:mariadb` would lead to `org.mariadb.jdbc.Driver`.
* Therefore, specifying the `driver-class-name` property becomes redundant in most cases when using Spring Boot. Spring handles the detection for you
  as long as the appropriate JDBC driver library is present on the classpath.