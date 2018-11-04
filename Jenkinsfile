pipeline {
    agent none
    stages {
        stage('mvn') {
            agent { docker 'maven:3.3.9' }
            steps {
                sh 'mvn --version'
            }
        }
        stage('docker') {
            agent any
            steps {
                sh 'docker --version'
                sh 'docker images'
            }
        }
    }
}