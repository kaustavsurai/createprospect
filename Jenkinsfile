pipeline {
    agent any

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
                usernameVariable: 'USERNAME',
                passwordVariable: 'PASSWORD']]) {
                    bat 'usr/local/bin/cf login -a http://api.run.pivotal.io -u $USERNAME -p $PASSWORD'
                    bat 'usr/local/bin/cf push'
                }
            }
        }
    }
}