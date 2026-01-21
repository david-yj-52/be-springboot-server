# 1단계: Build
FROM gradle:8.5-jdk21 AS build
WORKDIR /app
COPY . .
# 빌드 속도를 위해 데몬 끄고 테스트 제외
RUN chmod +x gradlew
RUN ./gradlew bootJar --no-daemon -x test

# 2단계: Run
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app

# OS 타임존을 미국 동부 표준시로 설정
ENV TZ=America/New_York
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# build 단계에서 생성된 bootJar 파일만 복사
COPY --from=build /app/build/libs/*-SNAPSHOT.jar app.jar

# 배포 환경을 인자로 받을 수 있게 설정 (기본값 dev)
ENV SPRING_PROFILES_ACTIVE=dev

# 실행 시 외부 설정 파일이나 환경 변수를 적용할 수 있도록 Entrypoint 구성
ENTRYPOINT ["java", "-Duser.timezone=Asia/Seoul", "-jar", "app.jar"]