**What is a Docker ?** \
Docker is an open-source tool designed to make it easier to create, deploy, and run applications by using containers engine that uses the Linux Kernel features. 
Containers allow a developer to package up an application with all of the parts it needs, such as libraries and other dependencies, and deploy it as one package.
Docker enables you to separate your applications from your infrastructure so you can deliver software quickly.

**Docker image**\
A Docker image contains application code, libraries, tools, dependencies and other files needed to make an application run. 
When a user runs an image, it can become one or many instances of a container. Docker images have multiple layers, each one originates from the previous layer but is different from it.

**Docker container**\
Docker images are read-only templates used to build containers. Containers are deployed instances created from those templates
A Docker container image is a lightweight, standalone, executable package of software that includes everything needed to run an application: code, runtime, system tools, system libraries and settings.

**Docker volumes**\
Docker volumes are file systems mounted on Docker containers to preserve data generated by the running container. 
The volumes are stored on the host, independent of the container life cycle. This allows users to back up data and share file systems between containers easily.

**Docker Networking**\
Docker networking allows you to attach a container to as many networks as you like. You can also attach an already running container.
There are three common Docker network types – bridge networks, used within a single host, overlay networks, for multi-host communication, and macvlan networks which are used to connect Docker containers directly to host network interfaces.

**Docker Compose**\
Compose is a tool for defining and running multi-container Docker applications. With Compose, you use a YAML file to configure your application's services.
Define the services that make up your app in docker-compose.yml so they can be run together in an isolated environment.

##### What is this tutorial for ?
This lesson is to teach Docker usage, launch your app within docker container, compose multiple container and share it for public access.


1. You need a docker to be installed. Head to https://www.docker.com/get-started and get desktop docker (since it has compose inbuilt)
    Check "docker --version" & "docker-compose --version" they are both installed.
    You can install docker with choco and brew as well, just google for correct command. 

    "docker run hello-world"   - to test docker is working

2. you also need some program so that you can compile to .jar and will use as container - TBA

3. First lesson Docker basics, simple app running container.\ 
    Second lesson - volumes/networking/compose. Multiple container app.

4. Homework - launch any DB container (mssql is the easiest) and connect to it (app or any other interface, Intellij for example)

5. https://docs.docker.com/ official docker docs page for more information.
    
    
