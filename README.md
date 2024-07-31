# README

## Prerequisites

Before setting up the project, ensure that you have the following installed:

- **Java Development Kit (JDK):**  
  Ensure that you have JDK 8 or higher installed. You can download it from [Oracle's official website](https://www.oracle.com/java/technologies/javase-downloads.html) or use OpenJDK from [AdoptOpenJDK](https://adoptopenjdk.net/).

- **Apache Tomcat Server:**  
  Apache Tomcat 9.x is required. You can download it from the [Apache Tomcat website](https://tomcat.apache.org/).

- **Database (PostgreSQL/MySQL):**  
  You need to specify the driver, URL, username, and password in the `database.properties` file. Create this file yourself in the `src/main/resources/` directory. Template for `database.properties` is located in the same folder - `database.properties.origin`.

## Running with IntelliJ IDEA

To run the project using IntelliJ IDEA, follow these steps:

1. **Install Smart Tomcat Plugin:**
   - Open IntelliJ IDEA.
   - Go to `File` -> `Settings` -> `Plugins`.
   - Search for `Smart Tomcat` in the marketplace and install it.

2. **Configure Tomcat in IntelliJ IDEA:**
   - Go to `Run` -> `Edit Configurations`.
   - Click on the '+' button and choose `Smart Tomcat` from the list.
   - Set the `Tomcat server` parameter and specify the path to your local Tomcat installation.
   - Set the `Context path` parameter to `/`.

3. **Build the Project:**
   - Run the following command to build the project:

     ```bash
     ./mvnw clean package
     ```

4. **Run the Application:**
   - Once the build is successful, you can run the application using the Smart Tomcat configuration.

## Running with VS Code

To run the project using Visual Studio Code, follow these steps:

1. **Install Community Server Connectors Extension:**
   - Open Visual Studio Code.
   - Go to the Extensions view by clicking on the square icon in the sidebar or pressing `Ctrl+Shift+X`.
   - Search for `Community Server Connectors` and install the extension.

2. **Deploy the WAR File:**
   - Use the extension to deploy the generated WAR file directly.
   - You may need to set the context path in the extension settings. Refer to the extension's documentation for specific instructions.

## Additional Notes

- **Maven Wrapper:**  
  This project uses the Maven Wrapper, so you do not need to install Maven separately. Use `./mvnw` for Unix-based systems and `mvnw.cmd` for Windows to run Maven commands.

- **Environment Variables:**  
  You may need to set environment variables for `JAVA_HOME` and `CATALINA_HOME` to point to your JDK and Tomcat installations, respectively.
