#FROM：表示基础镜像，即运行环境 VOLUME /tmp创建/tmp目录并持久化到Docker数据文件夹，
#因为Spring Boot使用的内嵌Tomcat容器默认使用/tmp作为工作目录 ADD：拷贝文件并且重命名(ADD elk-web-1.0-SNAPSHOT.jar elk.jar
#将应用jar包复制到/elk.jar) EXPOSE：并不是真正的发布端口，这个只是容器部署人员与建立image的人员之间的交流，
#即建立image的人员告诉容器布署人员容器应该映射哪个端口给外界 ENTRYPOINT：容器启动时运行的命令，相当于我们在命令行中输入java -jar xxxx.jar，
#为了缩短 Tomcat 的启动时间，添加java.security.egd的系统属性指向/dev/urandom作为 ENTRYPOINT

FROM java:8
VOLUME /tmp
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

#docker run -di --name 容器名称 -p 8080:8080 镜像名称