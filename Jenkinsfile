pipeline {
    agent any
    tools{
        jdk 'JAVA_HOME'
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                withMaven(maven: 'maven_3_5_2'){
                    bat 'mvn clean package'
                }
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'

                withCredentials([[$class:'UsernamePasswordMultiBinding',
                credentialsId: 'PCF_LOGIN',
                usernameVariable: 'kaustav541@gmail.com',
                passwordVariable: 'Delhi-2021']]) {
                    bat 'cf login -a https://api.run.pivotal.io -u $USERNAME -p $PASSWORD'
                    bat 'cf push'
                }
            }
        }
    }
}