pipeline {
  agent {
    docker {
      image 'maven:3.6-jdk-8-alpine'
      args '-v "$PWD":/usr/src/app'
    }

  }
  stages {
    stage('Initialize') {
      steps {
        sh '''echo PATH = ${PATH}
echo M@_HOME = ${M2_HOME}
mvn clean'''
      }
    }
    stage('Build') {
      steps {
        sh 'mvn -Dmaven.test.falure.ignore=true install'
      }
    }
    stage('Report') {
      steps {
        junit 'target/surefire-reports/** /*.xml'
        archiveArtifacts 'target/*.jar'
      }
    }
  }
}