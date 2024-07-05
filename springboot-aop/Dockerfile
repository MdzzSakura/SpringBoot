# 使用官方的OpenJDK 8作为基础镜像
FROM openjdk:8-jre-slim
# 作者信息
LABEL maintainer="yjj"

# 设置工作目录
WORKDIR /app

# 将构建的jar文件复制到镜像中的/app目录下
COPY target/springboot-aop-0.0.1-SNAPSHOT.jar /app/springboot-aop-0.0.1-SNAPSHOT.jar

# 设置容器启动时执行的命令
CMD ["java", "-jar", "/app/springboot-aop-0.0.1-SNAPSHOT.jar"]
