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
        sh '''mvn clean'''
      }
    }

    stage('Build') {
      steps {
        sh 'mvn -B -DskipTests clean install'
      }
    }

    stage('Test') {
        steps {
            sh 'mvn test'
        }
        post {
            always {
                junit 'target/surefire-reports/*.xml'
            }
        }
    }
  }
}
